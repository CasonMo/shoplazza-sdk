package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2022/6/7
 * Time: 16:47
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaCount {
    private Integer count;

    public ShoplazzaCount() {
    }

    private ShoplazzaCount(Builder builder) {
        setCount(builder.count);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public static final class Builder {
        private Integer count;

        private Builder() {
        }

        public Builder withCount(Integer val) {
            count = val;
            return this;
        }

        public ShoplazzaCount build() {
            return new ShoplazzaCount(this);
        }
    }
}
