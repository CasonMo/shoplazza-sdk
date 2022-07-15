package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaOrdersRoot {
    private List<ShoplazzaOrder> orders;

    public ShoplazzaOrdersRoot() {
    }

    private ShoplazzaOrdersRoot(Builder builder) {
        setOrders(builder.orders);
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<ShoplazzaOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<ShoplazzaOrder> orders) {
        this.orders = orders;
    }

    public static final class Builder {
        private List<ShoplazzaOrder> orders;

        private Builder() {
        }

        public Builder withOrders(List<ShoplazzaOrder> val) {
            orders = val;
            return this;
        }

        public ShoplazzaOrdersRoot build() {
            return new ShoplazzaOrdersRoot(this);
        }
    }
}