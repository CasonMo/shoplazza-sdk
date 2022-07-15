package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaShippingLine {
    private String name;

    public ShoplazzaShippingLine() {
    }

    private ShoplazzaShippingLine(Builder builder) {
        setName(builder.name);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static final class Builder {
        private String name;

        private Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public ShoplazzaShippingLine build() {
            return new ShoplazzaShippingLine(this);
        }
    }
}