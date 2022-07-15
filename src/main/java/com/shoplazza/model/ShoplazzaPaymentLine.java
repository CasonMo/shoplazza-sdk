package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaPaymentLine {
    @XmlElement(name = "merchant_email")
    private String merchantEmail;
    @XmlElement(name = "payment_channel")
    private String paymentChannel;
    @XmlElement(name = "merchant_id")
    private String merchantId;
    @XmlElement(name = "payment_method")
    private String paymentMethod;
    @XmlElement(name = "transaction_no")
    private String transactionNo;

    public ShoplazzaPaymentLine() {
    }

    private ShoplazzaPaymentLine(Builder builder) {
        setMerchantEmail(builder.merchantEmail);
        setPaymentChannel(builder.paymentChannel);
        setMerchantId(builder.merchantId);
        setPaymentMethod(builder.paymentMethod);
        setTransactionNo(builder.transactionNo);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getMerchantEmail() {
        return merchantEmail;
    }

    public void setMerchantEmail(String merchantEmail) {
        this.merchantEmail = merchantEmail;
    }

    public String getPaymentChannel() {
        return paymentChannel;
    }

    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getTransactionNo() {
        return transactionNo;
    }

    public void setTransactionNo(String transactionNo) {
        this.transactionNo = transactionNo;
    }

    public static final class Builder {
        private String merchantEmail;
        private String paymentChannel;
        private String merchantId;
        private String paymentMethod;
        private String transactionNo;

        private Builder() {
        }

        public Builder withMerchantEmail(String val) {
            merchantEmail = val;
            return this;
        }

        public Builder withPaymentChannel(String val) {
            paymentChannel = val;
            return this;
        }

        public Builder withMerchantId(String val) {
            merchantId = val;
            return this;
        }

        public Builder withPaymentMethod(String val) {
            paymentMethod = val;
            return this;
        }

        public Builder withTransactionNo(String val) {
            transactionNo = val;
            return this;
        }

        public ShoplazzaPaymentLine build() {
            return new ShoplazzaPaymentLine(this);
        }
    }
}