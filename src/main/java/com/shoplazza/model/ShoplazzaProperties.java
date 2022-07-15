package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaProperties {
    private String name;
    private String value;

    public ShoplazzaProperties() {
    }

    private ShoplazzaProperties(Builder builder) {
        setName(builder.name);
        setValue(builder.value);
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static final class Builder {
        private String name;
        private String value;

        private Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withValue(String val) {
            value = val;
            return this;
        }

        public ShoplazzaProperties build() {
            return new ShoplazzaProperties(this);
        }
    }
}