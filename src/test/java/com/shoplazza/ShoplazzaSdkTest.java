package com.shoplazza;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.shoplazza.model.ShoplazzaOrder;
import com.shoplazza.model.ShoplazzaProduct;
import com.shoplazza.model.ShoplazzaRefundList;
import com.shoplazza.model.ShoplazzaShopRoot;
import com.shoplazza.model.request.GetOrderCountRequest;
import com.shoplazza.model.request.GetOrdersRequest;
import com.shoplazza.model.request.GetProductsRequest;
import com.shoplazza.utils.JsonUtils;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2022/6/6
 * Time: 15:25
 */
@RunWith(MockitoJUnitRunner.class)
public class ShoplazzaSdkTest extends TestCase {

    private final static Logger logger = LoggerFactory.getLogger(ShoplazzaSdkTest.class);

    private final static String ACCESS_TOKEN = "";
    private final static String SUB_DOMAIN = "";
    private final static String VERSION = "2022-01";

    private ShoplazzaSdk shoplazzaSdk;

    @Before
    public void setUp() throws JsonProcessingException {
        shoplazzaSdk = ShoplazzaSdk.newBuilder()
                .withSubdomain(SUB_DOMAIN)
                .withAccessToken(ACCESS_TOKEN)
                .withApiVersion(VERSION)
                .withReadTimeout(120, TimeUnit.SECONDS)
                .withConnectionTimeout(120, TimeUnit.SECONDS)
                .build();
    }

    @Test
    public void getOrder() {
        ShoplazzaOrder order = shoplazzaSdk.getOrder(" ");
        logger.info(JsonUtils.toJSONString(order));
        assertEquals(" ", order.getId());
    }

    @Test
    public void getOrderCount() {
        GetOrderCountRequest getOrderCountRequest = GetOrderCountRequest.builder().withCreatedAtMin(Date.from(LocalDateTime.now().minusDays(1).atZone(ZoneId.systemDefault()).toInstant())).withCreatedAtMax(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant())).build();
        Integer count = shoplazzaSdk.getOrderCount(getOrderCountRequest);
        logger.info("" + count);
        assertNotNull(count);
    }

    @Test
    public void getProductCount() {
        Integer count = shoplazzaSdk.getProductCount(null);
        logger.info("" + count);
        assertNotNull(count);
    }

    @Test
    public void getShop() {
        ShoplazzaShopRoot shop = shoplazzaSdk.getShop();
        logger.info(JsonUtils.toJSONString(shop.getShop()));
        assertEquals("".toLowerCase(), shop.getShop().getName().toLowerCase());
    }

    @Test
    public void getOrders() {
        GetOrdersRequest getOrdersRequest = new GetOrdersRequest();
        getOrdersRequest.setLimit(50);
        List<ShoplazzaOrder> orders = shoplazzaSdk.getOrders(getOrdersRequest);
        assertNotNull(orders.get(0));
    }

    @Test
    public void getProducts() {
        GetProductsRequest request = new GetProductsRequest();
        request.setLimit(50);
        List<ShoplazzaProduct> products = shoplazzaSdk.getProducts(request);
        assertNotNull(products.get(0));
    }

    @Test
    public void refundList() {
        ShoplazzaRefundList shoplazzaRefundList = shoplazzaSdk.refundList("");
        System.out.println(JsonUtils.toJSONString(shoplazzaRefundList));
    }
}