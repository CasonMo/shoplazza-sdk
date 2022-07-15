package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaOrderRoot {
    private ShoplazzaOrder order;

    public ShoplazzaOrderRoot() {
    }

    private ShoplazzaOrderRoot(Builder builder) {
        setOrder(builder.order);
    }

    public static Builder builder() {
        return new Builder();
    }

    public ShoplazzaOrder getOrder() {
        return order;
    }

    public void setOrder(ShoplazzaOrder order) {
        this.order = order;
    }

    public static final class Builder {
        private ShoplazzaOrder order;

        private Builder() {
        }

        public Builder withOrder(ShoplazzaOrder val) {
            order = val;
            return this;
        }

        public ShoplazzaOrderRoot build() {
            return new ShoplazzaOrderRoot(this);
        }
    }
}