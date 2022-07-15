package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaProductRoot {

    private ShoplazzaProduct product;

    public ShoplazzaProductRoot() {
    }

    private ShoplazzaProductRoot(Builder builder) {
        setProduct(builder.product);
    }

    public static Builder builder() {
        return new Builder();
    }

    public ShoplazzaProduct getProduct() {
        return product;
    }

    public void setProduct(ShoplazzaProduct product) {
        this.product = product;
    }

    public static final class Builder {
        private ShoplazzaProduct product;

        private Builder() {
        }

        public Builder withProduct(ShoplazzaProduct val) {
            product = val;
            return this;
        }

        public ShoplazzaProductRoot build() {
            return new ShoplazzaProductRoot(this);
        }
    }
}
