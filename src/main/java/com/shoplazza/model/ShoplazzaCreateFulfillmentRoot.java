package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2022/6/6
 * Time: 17:21
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaCreateFulfillmentRoot {
    private ShoplazzaFulfillment fulfillment;

    public ShoplazzaCreateFulfillmentRoot() {
    }

    private ShoplazzaCreateFulfillmentRoot(Builder builder) {
        setFulfillment(builder.fulfillment);
    }

    public static Builder builder() {
        return new Builder();
    }

    public ShoplazzaFulfillment getFulfillment() {
        return fulfillment;
    }

    public void setFulfillment(ShoplazzaFulfillment fulfillment) {
        this.fulfillment = fulfillment;
    }

    public static final class Builder {
        private ShoplazzaFulfillment fulfillment;

        private Builder() {
        }

        public Builder withFulfillment(ShoplazzaFulfillment val) {
            fulfillment = val;
            return this;
        }

        public ShoplazzaCreateFulfillmentRoot build() {
            return new ShoplazzaCreateFulfillmentRoot(this);
        }
    }
}
