package com.shoplazza;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.github.rholder.retry.*;
import com.shoplazza.exceptions.ShoplaazaErrorResponseException;
import com.shoplazza.exceptions.ShoplazzaClientException;
import com.shoplazza.mappers.ResponseEntityToStringMapper;
import com.shoplazza.mappers.ShoplazzaSdkObjectMapper;
import com.shoplazza.model.*;
import com.shoplazza.model.request.*;
import com.shoplazza.utils.JsonUtils;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.client.ClientProperties;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import java.net.URI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


public class ShoplazzaSdk {

    private static final Logger log = LoggerFactory.getLogger(ShoplazzaSdk.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();
    static final String API_VERSION_PREFIX = "openapi";
    static final String RETRY_AFTER_HEADER = "Retry-After";
    static final String ACCESS_TOKEN_HEADER = "Access-Token";
    static final String PRODUCTS = "products";
    static final String WEBHOOKS = "webhooks";
    static final String ORDERS = "orders";
    static final String REFUND = "refund";
    static final String COUNT = "count";
    static final String PARTIAL_REFUND = "partial_refund";
    static final String FULFILLMENTS = "fulfillments";
    static final String SHOP = "shop";
    private static final long TWO_HUNDRED_MILLISECONDS = 200L;
    private static final String EQUALS = "=";
    private static final String AMPERSAND = "&";
    private static final String MINIMUM_REQUEST_RETRY_DELAY_CANNOT_BE_LARGER_THAN_MAXIMUM_REQUEST_RETRY_DELAY_MESSAGE = "Maximum request retry delay must be larger than minimum request retry delay.";
    private static final String INVALID_MINIMUM_REQUEST_RETRY_DELAY_MESSAGE = "Minimum request retry delay cannot be set lower than 200 milliseconds.";
    private static final Logger LOGGER = LoggerFactory.getLogger(ShoplazzaSdk.class);
    private static final String HTTPS = "https://";
    private static final String API_TARGET = ".myshoplaza.com/";
    private static final int DEFAULT_REQUEST_LIMIT = 50;
    private static final int TOO_MANY_REQUESTS_STATUS_CODE = 429;
    private static final int UNPROCESSABLE_ENTITY_STATUS_CODE = 422;
    private static final int LOCKED_STATUS_CODE = 423;

    private static final String SHOP_RETRIEVED_MESSAGE = "Starting to make calls for Shoplazza store with ID of {} and name of {}";
    private static final String COULD_NOT_BE_SAVED_SHOPIFY_ERROR_MESSAGE = "could not successfully be saved";
    private static final String RETRY_FAILED_MESSAGE = "Request retry has failed.";

    private static final Long DEFAULT_MAXIMUM_REQUEST_RETRY_TIMEOUT_IN_MILLISECONDS = 180000L;
    private static final Long DEFAULT_MAXIMUM_REQUEST_RETRY_RANDOM_DELAY_IN_MILLISECONDS = 5000L;
    private static final Long DEFAULT_MINIMUM_REQUEST_RETRY_RANDOM_DELAY_IN_MILLISECONDS = 1000L;
    private static final long DEFAULT_READ_TIMEOUT_IN_MILLISECONDS = 120000L;
    private static final long DEFAULT_CONNECTION_TIMEOUT_IN_MILLISECONDS = 120000L;
    private static final Client CLIENT = buildClient();
    private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
    private String shopSubdomain;
    private String apiUrl;
    private String apiVersion;
    private WebTarget webTarget;
    private String accessToken;
    private long minimumRequestRetryRandomDelayMilliseconds;
    private long maximumRequestRetryRandomDelayMilliseconds;
    private long maximumRequestRetryTimeoutMilliseconds;

    protected ShoplazzaSdk(final Steps steps) {
        if (steps != null) {
            this.shopSubdomain = steps.subdomain;
            this.accessToken = steps.accessToken;
            this.apiUrl = steps.apiUrl;
            this.apiVersion = steps.apiVersion;
            this.minimumRequestRetryRandomDelayMilliseconds = steps.minimumRequestRetryRandomDelayMilliseconds;
            this.maximumRequestRetryRandomDelayMilliseconds = steps.maximumRequestRetryRandomDelayMilliseconds;
            this.maximumRequestRetryTimeoutMilliseconds = steps.maximumRequestRetryTimeoutMilliseconds;

            CLIENT.property(ClientProperties.CONNECT_TIMEOUT, Math.toIntExact(steps.connectionTimeoutMilliseconds));
            CLIENT.property(ClientProperties.READ_TIMEOUT, Math.toIntExact(steps.readTimeoutMilliseconds));
            validateConstructionOfShoplazzaSdk();
        }

    }

    public static SubdomainStep newBuilder() {
        return new Steps();
    }

    private static boolean shouldRetryResponse(final Response response) {
        return isServerError(response) || hasExceededRateLimit(response) || hasNotBeenSaved(response);
    }

    private static boolean hasExceededRateLimit(final Response response) {
        return TOO_MANY_REQUESTS_STATUS_CODE == response.getStatus()
                && response.getHeaders().containsKey(RETRY_AFTER_HEADER);
    }

    private static boolean isServerError(final Response response) {
        return (Status.Family.SERVER_ERROR == Status.Family.familyOf(response.getStatus()))
                || (LOCKED_STATUS_CODE == response.getStatus());
    }

    private static boolean hasNotBeenSaved(final Response response) {
        if ((UNPROCESSABLE_ENTITY_STATUS_CODE == response.getStatus()) && response.hasEntity()) {
            final String shoplazzaErrorResponse = ResponseEntityToStringMapper.map(response);
            LOGGER.debug(shoplazzaErrorResponse);
            return shoplazzaErrorResponse.contains(COULD_NOT_BE_SAVED_SHOPIFY_ERROR_MESSAGE);
        }
        return false;
    }

    private static Client buildClient() {
        final ObjectMapper mapper = ShoplazzaSdkObjectMapper.buildMapper();
        final JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
        provider.setMapper(mapper);
        Client client = ClientBuilder.newClient();
        return client.register(JacksonFeature.class).register(provider);
    }

    private void validateConstructionOfShoplazzaSdk() {
        if (this.minimumRequestRetryRandomDelayMilliseconds < TWO_HUNDRED_MILLISECONDS) {
            throw new IllegalArgumentException(INVALID_MINIMUM_REQUEST_RETRY_DELAY_MESSAGE);
        }
        if (minimumRequestRetryRandomDelayMilliseconds > maximumRequestRetryRandomDelayMilliseconds) {
            throw new IllegalArgumentException(
                    MINIMUM_REQUEST_RETRY_DELAY_CANNOT_BE_LARGER_THAN_MAXIMUM_REQUEST_RETRY_DELAY_MESSAGE);
        }
    }

    private Response get(final WebTarget webTarget) {
        log.info("request url : {} method: {}", webTarget.getUri(), "GET");
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2,SSLv3");
        final Callable<Response> responseCallable = () -> webTarget.request(MediaType.APPLICATION_JSON)
                .header(ACCESS_TOKEN_HEADER, accessToken).get();
        final Response response = invokeResponseCallable(responseCallable);
        return handleResponse(response, Status.OK);
    }

    private Response delete(final WebTarget webTarget) {
        log.info("request url : {} method: {}", webTarget.getUri(), "DELETE");
        final Callable<Response> responseCallable = () -> webTarget.request(MediaType.APPLICATION_JSON)
                .header(ACCESS_TOKEN_HEADER, accessToken).delete();
        final Response response = invokeResponseCallable(responseCallable);
        return handleResponse(response, Status.OK);
    }

    private <T> Response post(final WebTarget webTarget, final T object) {
        log.info("request url : {} method: {} paramaters : {}", webTarget.getUri(), "POST", JsonUtils.toJSONString(object));
        final Callable<Response> responseCallable = () -> {
            final Entity<T> entity = Entity.entity(object, MediaType.APPLICATION_JSON);
            return webTarget.request(MediaType.APPLICATION_JSON).header(ACCESS_TOKEN_HEADER, accessToken).post(entity);
        };
        final Response response = invokeResponseCallable(responseCallable);
        return handleResponse(response, Status.CREATED, Status.OK);
    }

    private <T> Response patch(final WebTarget webTarget, final T object) {
        log.info("request url : {} method: {} paramaters : {}", webTarget.getUri(), "PATCH", JsonUtils.toJSONString(object));
        final Callable<Response> responseCallable = () -> {
            final Entity<T> entity = Entity.entity(object, MediaType.APPLICATION_JSON);
            return webTarget.request(MediaType.APPLICATION_JSON).header(ACCESS_TOKEN_HEADER, accessToken).method("PATCH", entity);
        };
        final Response response = invokeResponseCallable(responseCallable);
        return handleResponse(response, Status.CREATED, Status.OK);
    }

    private <T> Response put(final WebTarget webTarget, final T object) {
        log.info("request url : {} method: {} paramaters : {}", webTarget.getUri(), "PUT", JsonUtils.toJSONString(object));
        final Callable<Response> responseCallable = () -> {
            final Entity<T> entity = Entity.entity(object, MediaType.APPLICATION_JSON);
            return webTarget.request(MediaType.APPLICATION_JSON).header(ACCESS_TOKEN_HEADER, accessToken).put(entity);
        };
        final Response response = invokeResponseCallable(responseCallable);
        return handleResponse(response, Status.OK);
    }

    private Response handleResponse(final Response response, final Status... expectedStatus) {

        final List<Integer> expectedStatusCodes = getExpectedStatusCodes(expectedStatus);
        if (expectedStatusCodes.contains(response.getStatus())) {
            return response;
        }

        throw new ShoplaazaErrorResponseException(response);
    }

    private List<Integer> getExpectedStatusCodes(final Status... expectedStatus) {
        return Arrays.asList(expectedStatus).stream().map(Status::getStatusCode).collect(Collectors.toList());
    }

    private Response invokeResponseCallable(final Callable<Response> responseCallable) {
        final Retryer<Response> retryer = buildResponseRetyer();
        try {
            return retryer.call(responseCallable);
        } catch (ExecutionException | RetryException e) {
            throw new ShoplazzaClientException(RETRY_FAILED_MESSAGE, e);
        }
    }

    private Retryer<Response> buildResponseRetyer() {
        return RetryerBuilder.<Response>newBuilder().retryIfResult(ShoplazzaSdk::shouldRetryResponse).retryIfException()
                .withWaitStrategy(WaitStrategies.randomWait(minimumRequestRetryRandomDelayMilliseconds,
                        TimeUnit.MILLISECONDS, maximumRequestRetryRandomDelayMilliseconds, TimeUnit.MILLISECONDS))
                .withStopStrategy(
                        StopStrategies.stopAfterDelay(maximumRequestRetryTimeoutMilliseconds, TimeUnit.MILLISECONDS))
                .withRetryListener(new ShoplazzaSdkRetryListener()).build();
    }

    private WebTarget getUnversionedWebTarget() {
        if (StringUtils.isNotBlank(this.shopSubdomain)) {
            return CLIENT
                    .target(new StringBuilder().append(HTTPS).append(this.shopSubdomain).append(API_TARGET).toString());
        }
        return CLIENT.target(this.apiUrl);
    }

    private WebTarget getWebTarget() {
        if (this.webTarget == null) {

            if (StringUtils.isNotBlank(this.shopSubdomain)) {
                this.webTarget = CLIENT.target(
                        new StringBuilder().append(HTTPS).append(this.shopSubdomain).append(API_TARGET).toString());

            } else {
                this.webTarget = CLIENT.target(this.apiUrl);
            }
            if (StringUtils.isNotBlank(this.apiVersion)) {
                this.webTarget = this.webTarget.path(API_VERSION_PREFIX).path(this.apiVersion);
            }

            final ShoplazzaShop shop = this.getShop().getShop();
            LOGGER.info(SHOP_RETRIEVED_MESSAGE, shop.getId(), shop.getName());
        }
        return webTarget;
    }

    private String getQueryParam(final URI uri, final String key) {
        final String[] params = uri.getQuery().split(AMPERSAND);
        for (final String param : params) {
            final String name = param.split(EQUALS)[0];
            final String value = param.split(EQUALS)[1];
            if (name.equals(key)) {
                return value;
            }
        }
        return null;
    }

    public interface OptionalsStep {

        OptionalsStep withMinimumRequestRetryRandomDelay(int duration, TimeUnit timeUnit);

        OptionalsStep withMaximumRequestRetryRandomDelay(int duration, TimeUnit timeUnit);

        OptionalsStep withMaximumRequestRetryTimeout(int duration, TimeUnit timeUnit);

        OptionalsStep withConnectionTimeout(int duration, TimeUnit timeUnit);

        OptionalsStep withReadTimeout(int duration, TimeUnit timeUnit);

        OptionalsStep withApiVersion(final String apiVersion);

        ShoplazzaSdk build();

    }

    public interface AuthorizationTokenStep {
        OptionalsStep withAuthorizationToken(final String authorizationToken);

    }

    public interface AccessTokenStep {
        OptionalsStep withAccessToken(final String accessToken);

    }

    public interface SubdomainStep {
        AccessTokenStep withSubdomain(final String subdomain);

        AccessTokenStep withApiUrl(final String apiUrl);
    }

    protected static class Steps
            implements SubdomainStep, AccessTokenStep, OptionalsStep {

        private String subdomain;
        private String accessToken;
        private String apiUrl;
        private String apiVersion;
        private long minimumRequestRetryRandomDelayMilliseconds = DEFAULT_MINIMUM_REQUEST_RETRY_RANDOM_DELAY_IN_MILLISECONDS;
        private long maximumRequestRetryRandomDelayMilliseconds = DEFAULT_MAXIMUM_REQUEST_RETRY_RANDOM_DELAY_IN_MILLISECONDS;
        private long maximumRequestRetryTimeoutMilliseconds = DEFAULT_MAXIMUM_REQUEST_RETRY_TIMEOUT_IN_MILLISECONDS;
        private long connectionTimeoutMilliseconds = DEFAULT_CONNECTION_TIMEOUT_IN_MILLISECONDS;
        private long readTimeoutMilliseconds = DEFAULT_READ_TIMEOUT_IN_MILLISECONDS;

        @Override
        public ShoplazzaSdk build() {
            return new ShoplazzaSdk(this);
        }

        @Override
        public OptionalsStep withAccessToken(final String accessToken) {
            this.accessToken = accessToken;
            return this;
        }

        @Override
        public AccessTokenStep withSubdomain(final String subdomain) {
            this.subdomain = subdomain;
            return this;
        }

        @Override
        public AccessTokenStep withApiUrl(final String apiUrl) {
            this.apiUrl = apiUrl;
            return this;
        }


        @Override
        public OptionalsStep withMinimumRequestRetryRandomDelay(final int duration, final TimeUnit timeUnit) {
            this.minimumRequestRetryRandomDelayMilliseconds = timeUnit.toMillis(duration);
            return this;
        }

        @Override
        public OptionalsStep withMaximumRequestRetryRandomDelay(final int duration, final TimeUnit timeUnit) {
            this.maximumRequestRetryRandomDelayMilliseconds = timeUnit.toMillis(duration);
            return this;
        }

        @Override
        public OptionalsStep withMaximumRequestRetryTimeout(final int duration, final TimeUnit timeUnit) {
            this.maximumRequestRetryTimeoutMilliseconds = timeUnit.toMillis(duration);
            return this;
        }

        @Override
        public OptionalsStep withConnectionTimeout(final int duration, final TimeUnit timeUnit) {
            this.connectionTimeoutMilliseconds = timeUnit.toMillis(duration);
            return this;
        }

        @Override
        public OptionalsStep withReadTimeout(final int duration, final TimeUnit timeUnit) {
            this.readTimeoutMilliseconds = timeUnit.toMillis(duration);
            return this;
        }

        @Override
        public OptionalsStep withApiVersion(final String apiVersion) {
            this.apiVersion = apiVersion;
            return this;
        }

    }

    public class ShoplazzaSdkRetryListener implements RetryListener {

        private static final String RETRY_EXCEPTION_ATTEMPT_MESSAGE = "An exception occurred while making an API call to shoplazza: {} on attempt number {} and {} seconds since first attempt";
        private static final String RETRY_INVALID_RESPONSE_ATTEMPT_MESSAGE = "Waited {} seconds since first retry attempt. This is attempt {}. Please review the following failed request information.\nRequest Location of {}\nResponse Status Code of {}\nResponse Body of:\n{}\nResponse Headers of:\n{}";

        @Override
        public <V> void onRetry(final Attempt<V> attempt) {
            if (attempt.hasResult()) {
                final Response response = (Response) attempt.getResult();

                final String responseBody = ResponseEntityToStringMapper.map(response);

                if (LOGGER.isWarnEnabled() && !hasExceededRateLimit(response) && shouldRetryResponse(response)) {

                    final long delaySinceFirstAttemptInSeconds = convertMillisecondsToSeconds(
                            attempt.getDelaySinceFirstAttempt());
                    LOGGER.warn(RETRY_INVALID_RESPONSE_ATTEMPT_MESSAGE, delaySinceFirstAttemptInSeconds,
                            attempt.getAttemptNumber(), response.getLocation(), response.getStatus(), responseBody,
                            response.getStringHeaders());

                }

            } else if (LOGGER.isWarnEnabled() && attempt.hasException()) {

                final long delaySinceFirstAttemptInSeconds = convertMillisecondsToSeconds(
                        attempt.getDelaySinceFirstAttempt());
                LOGGER.warn(RETRY_EXCEPTION_ATTEMPT_MESSAGE, attempt.getAttemptNumber(),
                        delaySinceFirstAttemptInSeconds, attempt.getExceptionCause());
            }
        }

        private long convertMillisecondsToSeconds(final long milliiseconds) {
            return TimeUnit.SECONDS.convert(milliiseconds, TimeUnit.MILLISECONDS);
        }

    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     * Api 对接开始
     **/

    public ShoplazzaShopRoot getShop() {
        final Response response = get(getWebTarget().path(SHOP).queryParam("fields", "id,name,email,country_code,country_code,province_code,address1,address2,zip,city,phone,primary_locale,currency,customer_email,timezone,domain,shop_owner,account,icon,created_at,updated_at"));
        ShoplazzaShopRoot shoplazzaShopRoot = response.readEntity(ShoplazzaShopRoot.class);
        return shoplazzaShopRoot;
    }

    public ShoplazzaShopRoot updateShop(final String shopId, final ShoplazzaShop shop) {
        final ShoplazzaShopRoot shoplazzaShopRootRequest = new ShoplazzaShopRoot();
        shoplazzaShopRootRequest.setShop(shop);
        final Response response = patch(getWebTarget().path(SHOP).path(shopId), shop);
        return response.readEntity(ShoplazzaShopRoot.class);
    }

    //商品相关API

    public ShoplazzaProduct getProduct(final String productId) {
        final Response response = get(getWebTarget().path(PRODUCTS).path(productId));
        final ShoplazzaProductRoot shopifyProductRootResponse = response.readEntity(ShoplazzaProductRoot.class);
        return shopifyProductRootResponse.getProduct();
    }

    public List<ShoplazzaProduct> getProducts(final GetProductsRequest request) {
        WebTarget webTarget = getWebTarget().path(PRODUCTS);
        if (request != null) {
            Map<String, String> map = JsonUtils.toJavaObject(JsonUtils.toJSONString(request), new TypeReference<Map<String, String>>() {
            });
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (StringUtils.isNotEmpty(entry.getKey())) {
                    webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
                }
            }
        }
        final Response response = get(webTarget);
        final ShoplazzaProductsRoot shoplazzaOrdersRoot = response.readEntity(ShoplazzaProductsRoot.class);
        return shoplazzaOrdersRoot.getProducts();
    }

    public ShoplazzaProduct createProduct(final ShoplazzaProduct shoplazzaProduct) {
        final ShoplazzaProductRoot shoplazzaProductRootRequest = new ShoplazzaProductRoot();
        shoplazzaProductRootRequest.setProduct(shoplazzaProduct);
        final Response response = post(getWebTarget().path(PRODUCTS), shoplazzaProductRootRequest);
        final ShoplazzaProductRoot shoplazzaProductRootResponse = response.readEntity(ShoplazzaProductRoot.class);
        final ShoplazzaProduct createdShoplazzaProduct = shoplazzaProductRootResponse.getProduct();
        return createdShoplazzaProduct;
    }

    public ShoplazzaProduct updateProduct(final String productId, final ShoplazzaProduct shoplazzaProduct) {
        final ShoplazzaProductRoot shoplazzaProductRootRequest = new ShoplazzaProductRoot();
        shoplazzaProductRootRequest.setProduct(shoplazzaProduct);
        final Response response = put(getWebTarget().path(PRODUCTS).path(productId), shoplazzaProductRootRequest);
        final ShoplazzaProductRoot shoplazzaProductRootResponse = response.readEntity(ShoplazzaProductRoot.class);
        final ShoplazzaProduct createdShoplazzaProduct = shoplazzaProductRootResponse.getProduct();
        return createdShoplazzaProduct;
    }

    public boolean deleteProduct(final String productId) {
        final Response response = delete(getWebTarget().path(PRODUCTS).path(productId));
        return Status.OK.getStatusCode() == response.getStatus();
    }

    public Integer getProductCount(final GetProductCountRequest request) {
        WebTarget webTarget = getWebTarget().path(PRODUCTS).path(COUNT);
        if (request != null) {
            Map<String, String> map = JsonUtils.toJavaObject(JsonUtils.toJSONString(request), new TypeReference<Map<String, String>>() {
            });
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (StringUtils.isNotEmpty(entry.getKey())) {
                    webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
                }
            }
        }
        final Response response = get(webTarget);
        final ShoplazzaCount shoplazzaCount = response.readEntity(ShoplazzaCount.class);
        return shoplazzaCount.getCount();
    }

    // webhook 相关api

    public ShoplazzaWebhook getWebhook(final String id) {
        final Response response = get(getWebTarget().path(WEBHOOKS).path(id));
        final ShoplazzaWebhookRoot root = response.readEntity(ShoplazzaWebhookRoot.class);
        return root.getWebhook();
    }

    public List<ShoplazzaWebhook> getWebhooks(final GetWebhookRequest request) {
        WebTarget webTarget = getWebTarget().path(WEBHOOKS);
        if (request != null) {
            Map<String, String> map = JsonUtils.toJavaObject(JsonUtils.toJSONString(request), new TypeReference<Map<String, String>>() {
            });
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (StringUtils.isNotEmpty(entry.getKey())) {
                    webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
                }
            }
        }
        final Response response = get(webTarget);
        final ShoplazzaWebhooksRoot root = response.readEntity(ShoplazzaWebhooksRoot.class);
        return root.getWebhooks();
    }

    public ShoplazzaWebhook createWebhook(final CreateWebhookRequest request) {
        final Response response = post(getWebTarget().path(WEBHOOKS), request);
        final ShoplazzaWebhookRoot root = response.readEntity(ShoplazzaWebhookRoot.class);
        final ShoplazzaWebhook obj = root.getWebhook();
        return obj;
    }

    public ShoplazzaWebhook updateWebhook(final String id,final UpdateWebhookRequest request) {
        final Response response = put(getWebTarget().path(WEBHOOKS).path(id), request);
        final ShoplazzaWebhookRoot root = response.readEntity(ShoplazzaWebhookRoot.class);
        final ShoplazzaWebhook obj = root.getWebhook();
        return obj;
    }

    public boolean deleteWebhook(final String id) {
        final Response response = delete(getWebTarget().path(WEBHOOKS).path(id));
        return Status.OK.getStatusCode() == response.getStatus();
    }

    public Integer getWebhookCount(final GetWebhookCountRequest request) {
        WebTarget webTarget = getWebTarget().path(WEBHOOKS).path(COUNT);
        if (request != null) {
            Map<String, String> map = JsonUtils.toJavaObject(JsonUtils.toJSONString(request), new TypeReference<Map<String, String>>() {
            });
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (StringUtils.isNotEmpty(entry.getKey())) {
                    webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
                }
            }
        }
        final Response response = get(webTarget);
        final ShoplazzaCount shoplazzaCount = response.readEntity(ShoplazzaCount.class);
        return shoplazzaCount.getCount();
    }

    //订单相关API


    public ShoplazzaOrder getOrder(final String orderId) {
        final Response response = get(getWebTarget().path(ORDERS).path(orderId));
        final ShoplazzaOrderRoot shopifyOrderRootResponse = response.readEntity(ShoplazzaOrderRoot.class);
        return shopifyOrderRootResponse.getOrder();
    }

    public ShoplazzaOrder updateOrder(final String orderId, final UpdateOrderRequest request) {
        final Response response = put(getWebTarget().path(ORDERS).path(orderId), request);
        final ShoplazzaOrderRoot shopifyOrderRootResponse = response.readEntity(ShoplazzaOrderRoot.class);
        return shopifyOrderRootResponse.getOrder();
    }

    public Integer getOrderCount(final GetOrderCountRequest request) {
        WebTarget webTarget = getWebTarget().path(ORDERS).path(COUNT);
        if (request != null) {
            Map<String, String> map = JsonUtils.toJavaObject(JsonUtils.toJSONString(request), new TypeReference<Map<String, String>>() {
            });
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (StringUtils.isNotEmpty(entry.getKey())) {
                    webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
                }
            }
        }
        final Response response = get(webTarget);
        final ShoplazzaCount shoplazzaCount = response.readEntity(ShoplazzaCount.class);
        return shoplazzaCount.getCount();
    }

    public List<ShoplazzaOrder> getOrders(final GetOrdersRequest request) {
        WebTarget webTarget = getWebTarget().path(ORDERS);
        if (request != null) {
            Map<String, String> map = JsonUtils.toJavaObject(JsonUtils.toJSONString(request), new TypeReference<Map<String, String>>() {
            });
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (StringUtils.isNotEmpty(entry.getKey())) {
                    webTarget = webTarget.queryParam(entry.getKey(), entry.getValue());
                }
            }
        }
        final Response response = get(webTarget);
        final ShoplazzaOrdersRoot shoplazzaOrdersRoot = response.readEntity(ShoplazzaOrdersRoot.class);
        return shoplazzaOrdersRoot.getOrders();
    }

    public boolean refund(final String orderId) {
        final Response response = post(getWebTarget().path(ORDERS).path(orderId).path(REFUND), null);
        return Status.OK.getStatusCode() == response.getStatus();
    }

    public ShoplazzaRefundList refundList(final String orderId) {
        final Response response = get(getWebTarget().path(ORDERS).path(orderId).path(REFUND));
        final ShoplazzaRefundList shoplazzaRefundList = response.readEntity(ShoplazzaRefundList.class);
        return shoplazzaRefundList;
    }

    public boolean partialRefund(final String orderId, final PartialRefundRequest partialRefundRequest) {
        final Response response = post(getWebTarget().path(ORDERS).path(orderId).path(PARTIAL_REFUND), partialRefundRequest);
        return Status.OK.getStatusCode() == response.getStatus();
    }

    public ShoplazzaFulfillment createFulfillment(final String orderId, final CreateFulfillmentRequest request) {
        final Response response = post(getWebTarget().path(ORDERS).path(orderId).path(FULFILLMENTS), request);
        final ShoplazzaCreateFulfillmentRoot shoplazzaCreateFulfillmentRoot = response.readEntity(ShoplazzaCreateFulfillmentRoot.class);
        return shoplazzaCreateFulfillmentRoot.getFulfillment();
    }


/**
 *
 * Api 对接结束
 *
 *
 **/

}
