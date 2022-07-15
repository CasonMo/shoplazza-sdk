package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaRefundsItem {
    private String note;
    @XmlElement(name = "refund_line_items")
    private List<ShoplazzaRefundLineItems> refundLineItems;
    private String currency;
    private String id;
    @XmlElement(name = "order_id")
    private String orderId;
    @XmlElement(name = "refund_price")
    private String refundPrice;

    public ShoplazzaRefundsItem() {
    }

    private ShoplazzaRefundsItem(Builder builder) {
        setNote(builder.note);
        setRefundLineItems(builder.refundLineItems);
        setCurrency(builder.currency);
        setId(builder.id);
        setOrderId(builder.orderId);
        setRefundPrice(builder.refundPrice);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<ShoplazzaRefundLineItems> getRefundLineItems() {
        return refundLineItems;
    }

    public void setRefundLineItems(List<ShoplazzaRefundLineItems> refundLineItems) {
        this.refundLineItems = refundLineItems;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getRefundPrice() {
        return refundPrice;
    }

    public void setRefundPrice(String refundPrice) {
        this.refundPrice = refundPrice;
    }

    public static final class Builder {
        private String note;
        private List<ShoplazzaRefundLineItems> refundLineItems;
        private String currency;
        private String id;
        private String orderId;
        private String refundPrice;

        private Builder() {
        }

        public Builder withNote(String val) {
            note = val;
            return this;
        }

        public Builder withRefundLineItems(List<ShoplazzaRefundLineItems> val) {
            refundLineItems = val;
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

        public Builder withOrderId(String val) {
            orderId = val;
            return this;
        }

        public Builder withRefundPrice(String val) {
            refundPrice = val;
            return this;
        }

        public ShoplazzaRefundsItem build() {
            return new ShoplazzaRefundsItem(this);
        }
    }
}