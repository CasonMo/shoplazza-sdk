package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaProductsRoot {
    private List<ShoplazzaProduct> products;

    public ShoplazzaProductsRoot() {
    }

    private ShoplazzaProductsRoot(Builder builder) {
        setProducts(builder.products);
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<ShoplazzaProduct> getProducts() {
        return products;
    }

    public void setProducts(List<ShoplazzaProduct> products) {
        this.products = products;
    }

    public static final class Builder {
        private List<ShoplazzaProduct> products;

        private Builder() {
        }

        public Builder withProducts(List<ShoplazzaProduct> val) {
            products = val;
            return this;
        }

        public ShoplazzaProductsRoot build() {
            return new ShoplazzaProductsRoot(this);
        }
    }
}