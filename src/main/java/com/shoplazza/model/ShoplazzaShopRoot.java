package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2022/5/20
 * Time: 10:56
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaShopRoot {
    private ShoplazzaShop shop;

    public ShoplazzaShopRoot() {
    }

    private ShoplazzaShopRoot(Builder builder) {
        setShop(builder.shop);
    }

    public static Builder builder() {
        return new Builder();
    }

    public ShoplazzaShop getShop() {
        return shop;
    }

    public void setShop(ShoplazzaShop shop) {
        this.shop = shop;
    }

    public static final class Builder {
        private ShoplazzaShop shop;

        private Builder() {
        }

        public Builder withShop(ShoplazzaShop val) {
            shop = val;
            return this;
        }

        public ShoplazzaShopRoot build() {
            return new ShoplazzaShopRoot(this);
        }
    }
}
