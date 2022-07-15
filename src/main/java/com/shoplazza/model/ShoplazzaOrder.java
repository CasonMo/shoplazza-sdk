package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaOrder {
    private String note;
    @XmlElement(name = "fulfillment_status")
    private String fulfillmentStatus;
    @XmlElement(name = "total_discount")
    private String totalDiscount;
    @XmlElement(name = "canceled_at")
    private Date canceledAt;
    @XmlElement(name = "total_refund_tax")
    private String totalRefundTax;
    @XmlElement(name = "discount_applications")
    private String discountApplications;
    @XmlElement(name = "created_at")
    private Date createdAt;
    @XmlElement(name = "billing_address")
    private ShoplazzaBillingAddress billingAddress;
    @XmlElement(name = "customer_note")
    private String customerNote;
    @XmlElement(name = "line_items")
    private List<ShoplazzaLineItem> lineItems;
    @XmlElement(name = "buyer_accepts_marketing")
    private Boolean buyerAcceptsMarketing;
    @XmlElement(name = "line_item_discount_total")
    private String lineItemDiscountTotal;
    @XmlElement(name = "landing_site")
    private String landingSite;
    @XmlElement(name = "payment_line")
    private ShoplazzaPaymentLine paymentLine;
    private String number;
    private List<ShoplazzaFulfillment> fulfillments;
    @XmlElement(name = "total_refund_discount")
    private String totalRefundDiscount;
    @XmlElement(name = "updated_at")
    private Date updatedAt;
    @XmlElement(name = "total_shipping")
    private String totalShipping;
    private String currency;
    private String id;
    @XmlElement(name = "shipping_address")
    private ShoplazzaShippingAddress shippingAddress;
    @XmlElement(name = "payment_method")
    private String paymentMethod;
    @XmlElement(name = "browser_ip")
    private String browserIp;
    @XmlElement(name = "refund_status")
    private String refundStatus;
    @XmlElement(name = "total_price")
    private String totalPrice;
    @XmlElement(name = "code_discount_total")
    private String codeDiscountTotal;
    @XmlElement(name = "discount_code")
    private String discountCode;
    @XmlElement(name = "total_refund_price")
    private String totalRefundPrice;
    @XmlElement(name = "total_tax")
    private String totalTax;
    @XmlElement(name = "placed_at")
    private Date placedAt;
    @XmlElement(name = "deleted_at")
    private Date deletedAt;
    private String tags;
    @XmlElement(name = "cancel_reason")
    private String cancelReason;
    @XmlElement(name = "customer_deleted_at")
    private Date customerDeletedAt;
    @XmlElement(name = "financial_status")
    private String financialStatus;
    @XmlElement(name = "sub_total")
    private String subTotal;
    @XmlElement(name = "shipping_line")
    private ShoplazzaShippingLine shippingLine;
    private String status;
    private ShoplazzaCustomer customer;

    public ShoplazzaOrder() {
    }

    private ShoplazzaOrder(Builder builder) {
        setNote(builder.note);
        setFulfillmentStatus(builder.fulfillmentStatus);
        setTotalDiscount(builder.totalDiscount);
        setCanceledAt(builder.canceledAt);
        setTotalRefundTax(builder.totalRefundTax);
        setDiscountApplications(builder.discountApplications);
        setCreatedAt(builder.createdAt);
        setBillingAddress(builder.billingAddress);
        setCustomerNote(builder.customerNote);
        setLineItems(builder.lineItems);
        setBuyerAcceptsMarketing(builder.buyerAcceptsMarketing);
        setLineItemDiscountTotal(builder.lineItemDiscountTotal);
        setLandingSite(builder.landingSite);
        setPaymentLine(builder.paymentLine);
        setNumber(builder.number);
        setFulfillments(builder.fulfillments);
        setTotalRefundDiscount(builder.totalRefundDiscount);
        setUpdatedAt(builder.updatedAt);
        setTotalShipping(builder.totalShipping);
        setCurrency(builder.currency);
        setId(builder.id);
        setShippingAddress(builder.shippingAddress);
        setPaymentMethod(builder.paymentMethod);
        setBrowserIp(builder.browserIp);
        setRefundStatus(builder.refundStatus);
        setTotalPrice(builder.totalPrice);
        setCodeDiscountTotal(builder.codeDiscountTotal);
        setDiscountCode(builder.discountCode);
        setTotalRefundPrice(builder.totalRefundPrice);
        setTotalTax(builder.totalTax);
        setPlacedAt(builder.placedAt);
        setDeletedAt(builder.deletedAt);
        setTags(builder.tags);
        setCancelReason(builder.cancelReason);
        setCustomerDeletedAt(builder.customerDeletedAt);
        setFinancialStatus(builder.financialStatus);
        setSubTotal(builder.subTotal);
        setShippingLine(builder.shippingLine);
        setStatus(builder.status);
        setCustomer(builder.customer);
    }

    public static Builder builder() {
        return new Builder();
    }

    public enum StatusEnum {
        OPENED("opened"), PLACED("placed"), FINISHED("finished"), CANCELLED("cancelled");
        private final String value;

        StatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum FinancialStatusEnum {
        WAITING("waiting"), PAYING("paying"), PAID("paid"), CANCELLED("cancelled"), FAILED("failed"), REFUNDING("refunding"), REFUND_FAILED("refund_failed"), REFUNDED("refunded"), PARTIALLY_REFUNDED("partially_refunded");
        private final String value;

        FinancialStatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum FulfillmentStatusEnum {
        INITIALLED("initialled"), WAITING("waiting"), PARTIALLY_SHIPPED("partially_shipped"), SHIPPED("shipped"), PARTIALLY_FINISHED("partially_finished"), FINISHED("finished"), CANCELLED("cancelled"), RETURNING("returning"), RETURNED("returned");
        private final String value;

        FulfillmentStatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getFulfillmentStatus() {
        return fulfillmentStatus;
    }

    public void setFulfillmentStatus(String fulfillmentStatus) {
        this.fulfillmentStatus = fulfillmentStatus;
    }

    public String getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(String totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public Date getCanceledAt() {
        return canceledAt;
    }

    public void setCanceledAt(Date canceledAt) {
        this.canceledAt = canceledAt;
    }

    public String getTotalRefundTax() {
        return totalRefundTax;
    }

    public void setTotalRefundTax(String totalRefundTax) {
        this.totalRefundTax = totalRefundTax;
    }

    public String getDiscountApplications() {
        return discountApplications;
    }

    public void setDiscountApplications(String discountApplications) {
        this.discountApplications = discountApplications;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public ShoplazzaBillingAddress getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(ShoplazzaBillingAddress billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getCustomerNote() {
        return customerNote;
    }

    public void setCustomerNote(String customerNote) {
        this.customerNote = customerNote;
    }

    public List<ShoplazzaLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<ShoplazzaLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Boolean getBuyerAcceptsMarketing() {
        return buyerAcceptsMarketing;
    }

    public void setBuyerAcceptsMarketing(Boolean buyerAcceptsMarketing) {
        this.buyerAcceptsMarketing = buyerAcceptsMarketing;
    }

    public String getLineItemDiscountTotal() {
        return lineItemDiscountTotal;
    }

    public void setLineItemDiscountTotal(String lineItemDiscountTotal) {
        this.lineItemDiscountTotal = lineItemDiscountTotal;
    }

    public String getLandingSite() {
        return landingSite;
    }

    public void setLandingSite(String landingSite) {
        this.landingSite = landingSite;
    }

    public ShoplazzaPaymentLine getPaymentLine() {
        return paymentLine;
    }

    public void setPaymentLine(ShoplazzaPaymentLine paymentLine) {
        this.paymentLine = paymentLine;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public List<ShoplazzaFulfillment> getFulfillments() {
        return fulfillments;
    }

    public void setFulfillments(List<ShoplazzaFulfillment> fulfillments) {
        this.fulfillments = fulfillments;
    }

    public String getTotalRefundDiscount() {
        return totalRefundDiscount;
    }

    public void setTotalRefundDiscount(String totalRefundDiscount) {
        this.totalRefundDiscount = totalRefundDiscount;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getTotalShipping() {
        return totalShipping;
    }

    public void setTotalShipping(String totalShipping) {
        this.totalShipping = totalShipping;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ShoplazzaShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShoplazzaShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getBrowserIp() {
        return browserIp;
    }

    public void setBrowserIp(String browserIp) {
        this.browserIp = browserIp;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCodeDiscountTotal() {
        return codeDiscountTotal;
    }

    public void setCodeDiscountTotal(String codeDiscountTotal) {
        this.codeDiscountTotal = codeDiscountTotal;
    }

    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }

    public String getTotalRefundPrice() {
        return totalRefundPrice;
    }

    public void setTotalRefundPrice(String totalRefundPrice) {
        this.totalRefundPrice = totalRefundPrice;
    }

    public String getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(String totalTax) {
        this.totalTax = totalTax;
    }

    public Date getPlacedAt() {
        return placedAt;
    }

    public void setPlacedAt(Date placedAt) {
        this.placedAt = placedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCancelReason() {
        return cancelReason;
    }

    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    public Date getCustomerDeletedAt() {
        return customerDeletedAt;
    }

    public void setCustomerDeletedAt(Date customerDeletedAt) {
        this.customerDeletedAt = customerDeletedAt;
    }

    public String getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(String financialStatus) {
        this.financialStatus = financialStatus;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public ShoplazzaShippingLine getShippingLine() {
        return shippingLine;
    }

    public void setShippingLine(ShoplazzaShippingLine shippingLine) {
        this.shippingLine = shippingLine;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ShoplazzaCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(ShoplazzaCustomer customer) {
        this.customer = customer;
    }

    public static final class Builder {
        private String note;
        private String fulfillmentStatus;
        private String totalDiscount;
        private Date canceledAt;
        private String totalRefundTax;
        private String discountApplications;
        private Date createdAt;
        private ShoplazzaBillingAddress billingAddress;
        private String customerNote;
        private List<ShoplazzaLineItem> lineItems;
        private Boolean buyerAcceptsMarketing;
        private String lineItemDiscountTotal;
        private String landingSite;
        private ShoplazzaPaymentLine paymentLine;
        private String number;
        private List<ShoplazzaFulfillment> fulfillments;
        private String totalRefundDiscount;
        private Date updatedAt;
        private String totalShipping;
        private String currency;
        private String id;
        private ShoplazzaShippingAddress shippingAddress;
        private String paymentMethod;
        private String browserIp;
        private String refundStatus;
        private String totalPrice;
        private String codeDiscountTotal;
        private String discountCode;
        private String totalRefundPrice;
        private String totalTax;
        private Date placedAt;
        private Date deletedAt;
        private String tags;
        private String cancelReason;
        private Date customerDeletedAt;
        private String financialStatus;
        private String subTotal;
        private ShoplazzaShippingLine shippingLine;
        private String status;
        private ShoplazzaCustomer customer;

        private Builder() {
        }

        public Builder withNote(String val) {
            note = val;
            return this;
        }

        public Builder withFulfillmentStatus(String val) {
            fulfillmentStatus = val;
            return this;
        }

        public Builder withTotalDiscount(String val) {
            totalDiscount = val;
            return this;
        }

        public Builder withCanceledAt(Date val) {
            canceledAt = val;
            return this;
        }

        public Builder withTotalRefundTax(String val) {
            totalRefundTax = val;
            return this;
        }

        public Builder withDiscountApplications(String val) {
            discountApplications = val;
            return this;
        }

        public Builder withCreatedAt(Date val) {
            createdAt = val;
            return this;
        }

        public Builder withBillingAddress(ShoplazzaBillingAddress val) {
            billingAddress = val;
            return this;
        }

        public Builder withCustomerNote(String val) {
            customerNote = val;
            return this;
        }

        public Builder withLineItems(List<ShoplazzaLineItem> val) {
            lineItems = val;
            return this;
        }

        public Builder withBuyerAcceptsMarketing(Boolean val) {
            buyerAcceptsMarketing = val;
            return this;
        }

        public Builder withLineItemDiscountTotal(String val) {
            lineItemDiscountTotal = val;
            return this;
        }

        public Builder withLandingSite(String val) {
            landingSite = val;
            return this;
        }

        public Builder withPaymentLine(ShoplazzaPaymentLine val) {
            paymentLine = val;
            return this;
        }

        public Builder withNumber(String val) {
            number = val;
            return this;
        }

        public Builder withFulfillments(List<ShoplazzaFulfillment> val) {
            fulfillments = val;
            return this;
        }

        public Builder withTotalRefundDiscount(String val) {
            totalRefundDiscount = val;
            return this;
        }

        public Builder withUpdatedAt(Date val) {
            updatedAt = val;
            return this;
        }

        public Builder withTotalShipping(String val) {
            totalShipping = val;
            return this;
        }

        public Builder withCurrency(String val) {
            currency = val;
            return this;
        }

        public Builder withId(String val) {
            id = val;
            return this;
        }

        public Builder withShippingAddress(ShoplazzaShippingAddress val) {
            shippingAddress = val;
            return this;
        }

        public Builder withPaymentMethod(String val) {
            paymentMethod = val;
            return this;
        }

        public Builder withBrowserIp(String val) {
            browserIp = val;
            return this;
        }

        public Builder withRefundStatus(String val) {
            refundStatus = val;
            return this;
        }

        public Builder withTotalPrice(String val) {
            totalPrice = val;
            return this;
        }

        public Builder withCodeDiscountTotal(String val) {
            codeDiscountTotal = val;
            return this;
        }

        public Builder withDiscountCode(String val) {
            discountCode = val;
            return this;
        }

        public Builder withTotalRefundPrice(String val) {
            totalRefundPrice = val;
            return this;
        }

        public Builder withTotalTax(String val) {
            totalTax = val;
            return this;
        }

        public Builder withPlacedAt(Date val) {
            placedAt = val;
            return this;
        }

        public Builder withDeletedAt(Date val) {
            deletedAt = val;
            return this;
        }

        public Builder withTags(String val) {
            tags = val;
            return this;
        }

        public Builder withCancelReason(String val) {
            cancelReason = val;
            return this;
        }

        public Builder withCustomerDeletedAt(Date val) {
            customerDeletedAt = val;
            return this;
        }

        public Builder withFinancialStatus(String val) {
            financialStatus = val;
            return this;
        }

        public Builder withSubTotal(String val) {
            subTotal = val;
            return this;
        }

        public Builder withShippingLine(ShoplazzaShippingLine val) {
            shippingLine = val;
            return this;
        }

        public Builder withStatus(String val) {
            status = val;
            return this;
        }

        public Builder withCustomer(ShoplazzaCustomer val) {
            customer = val;
            return this;
        }

        public ShoplazzaOrder build() {
            return new ShoplazzaOrder(this);
        }
    }
}