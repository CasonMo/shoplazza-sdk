package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaRefundLineItems {
    @XmlElement(name = "line_item_id")
    private String lineItemId;
    @XmlElement(name = "line_item")
    private ShoplazzaLineItem lineItem;
    @XmlElement(name = "refund_quantity")
    private int refundQuantity;

    public ShoplazzaRefundLineItems() {
    }

    private ShoplazzaRefundLineItems(Builder builder) {
        setLineItemId(builder.lineItemId);
        setLineItem(builder.lineItem);
        setRefundQuantity(builder.refundQuantity);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getLineItemId() {
        return lineItemId;
    }

    public void setLineItemId(String lineItemId) {
        this.lineItemId = lineItemId;
    }

    public ShoplazzaLineItem getLineItem() {
        return lineItem;
    }

    public void setLineItem(ShoplazzaLineItem lineItem) {
        this.lineItem = lineItem;
    }

    public int getRefundQuantity() {
        return refundQuantity;
    }

    public void setRefundQuantity(int refundQuantity) {
        this.refundQuantity = refundQuantity;
    }

    public static final class Builder {
        private String lineItemId;
        private ShoplazzaLineItem lineItem;
        private int refundQuantity;

        private Builder() {
        }

        public Builder withLineItemId(String val) {
            lineItemId = val;
            return this;
        }

        public Builder withLineItem(ShoplazzaLineItem val) {
            lineItem = val;
            return this;
        }

        public Builder withRefundQuantity(int val) {
            refundQuantity = val;
            return this;
        }

        public ShoplazzaRefundLineItems build() {
            return new ShoplazzaRefundLineItems(this);
        }
    }
}