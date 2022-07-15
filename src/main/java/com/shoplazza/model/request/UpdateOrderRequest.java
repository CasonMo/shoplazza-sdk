package com.shoplazza.model.request;

import com.shoplazza.model.ShoplazzaShippingAddress;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateOrderRequest {
    private String note;
    @XmlElement(name = "buyer_accespts_marketing")
    private boolean buyerAccesptsMarketing;
    @XmlElement(name = "shipping_address")
    private ShoplazzaShippingAddress shippingAddress;
    private String tags;

    public UpdateOrderRequest() {
    }

    private UpdateOrderRequest(Builder builder) {
        setNote(builder.note);
        setBuyerAccesptsMarketing(builder.buyerAccesptsMarketing);
        setShippingAddress(builder.shippingAddress);
        setTags(builder.tags);
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

    public boolean isBuyerAccesptsMarketing() {
        return buyerAccesptsMarketing;
    }

    public void setBuyerAccesptsMarketing(boolean buyerAccesptsMarketing) {
        this.buyerAccesptsMarketing = buyerAccesptsMarketing;
    }

    public ShoplazzaShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShoplazzaShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }


    public static final class Builder {
        private String note;
        private boolean buyerAccesptsMarketing;
        private ShoplazzaShippingAddress shippingAddress;
        private String tags;

        private Builder() {
        }

        public Builder withNote(String val) {
            note = val;
            return this;
        }

        public Builder withBuyerAccesptsMarketing(boolean val) {
            buyerAccesptsMarketing = val;
            return this;
        }

        public Builder withShippingAddress(ShoplazzaShippingAddress val) {
            shippingAddress = val;
            return this;
        }

        public Builder withTags(String val) {
            tags = val;
            return this;
        }

        public UpdateOrderRequest build() {
            return new UpdateOrderRequest(this);
        }
    }
}