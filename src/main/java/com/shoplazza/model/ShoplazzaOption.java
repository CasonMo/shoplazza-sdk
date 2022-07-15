package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaOption implements Serializable {
    private String name;
    private List<String> values;

    public ShoplazzaOption() {
    }

    private ShoplazzaOption(Builder builder) {
        setName(builder.name);
        setValues(builder.values);
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

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public static final class Builder {
        private String name;
        private List<String> values;

        private Builder() {
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withValues(List<String> val) {
            values = val;
            return this;
        }

        public ShoplazzaOption build() {
            return new ShoplazzaOption(this);
        }
    }
}