package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaRefundList {
    @XmlElement(name = "order_status")
    private String orderStatus;
    @XmlElement(name = "refund_discount_total")
    private String refundDiscountTotal;
    @XmlElement(name = "refund_status")
    private String refundStatus;
    @XmlElement(name = "refund_quantity")
    private boolean allRefunded;
    @XmlElement(name = "refund_tax_total")
    private String refundTaxTotal;
    @XmlElement(name = "refund_total")
    private String refundTotal;
    private List<ShoplazzaRefundsItem> refunds;

    public ShoplazzaRefundList() {
    }

    private ShoplazzaRefundList(Builder builder) {
        setOrderStatus(builder.orderStatus);
        setRefundDiscountTotal(builder.refundDiscountTotal);
        setRefundStatus(builder.refundStatus);
        setAllRefunded(builder.allRefunded);
        setRefundTaxTotal(builder.refundTaxTotal);
        setRefundTotal(builder.refundTotal);
        setRefunds(builder.refunds);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getRefundDiscountTotal() {
        return refundDiscountTotal;
    }

    public void setRefundDiscountTotal(String refundDiscountTotal) {
        this.refundDiscountTotal = refundDiscountTotal;
    }

    public String getRefundStatus() {
        return refundStatus;
    }

    public void setRefundStatus(String refundStatus) {
        this.refundStatus = refundStatus;
    }

    public boolean isAllRefunded() {
        return allRefunded;
    }

    public void setAllRefunded(boolean allRefunded) {
        this.allRefunded = allRefunded;
    }

    public String getRefundTaxTotal() {
        return refundTaxTotal;
    }

    public void setRefundTaxTotal(String refundTaxTotal) {
        this.refundTaxTotal = refundTaxTotal;
    }

    public String getRefundTotal() {
        return refundTotal;
    }

    public void setRefundTotal(String refundTotal) {
        this.refundTotal = refundTotal;
    }

    public List<ShoplazzaRefundsItem> getRefunds() {
        return refunds;
    }

    public void setRefunds(List<ShoplazzaRefundsItem> refunds) {
        this.refunds = refunds;
    }

    public static final class Builder {
        private String orderStatus;
        private String refundDiscountTotal;
        private String refundStatus;
        private boolean allRefunded;
        private String refundTaxTotal;
        private String refundTotal;
        private List<ShoplazzaRefundsItem> refunds;

        private Builder() {
        }

        public Builder withOrderStatus(String val) {
            orderStatus = val;
            return this;
        }

        public Builder withRefundDiscountTotal(String val) {
            refundDiscountTotal = val;
            return this;
        }

        public Builder withRefundStatus(String val) {
            refundStatus = val;
            return this;
        }

        public Builder withAllRefunded(boolean val) {
            allRefunded = val;
            return this;
        }

        public Builder withRefundTaxTotal(String val) {
            refundTaxTotal = val;
            return this;
        }

        public Builder withRefundTotal(String val) {
            refundTotal = val;
            return this;
        }

        public Builder withRefunds(List<ShoplazzaRefundsItem> val) {
            refunds = val;
            return this;
        }

        public ShoplazzaRefundList build() {
            return new ShoplazzaRefundList(this);
        }
    }
}