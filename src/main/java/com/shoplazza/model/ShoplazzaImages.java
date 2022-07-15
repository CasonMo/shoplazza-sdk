package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaImages implements Serializable {
    @XmlElement(name = "product_id")
    private String productId;
    private String id;
    private String src;
    private Integer width;
    private String alt;
    private Integer height;
    @XmlElement(name = "created_at")
    private Date createdAt;
    @XmlElement(name = "updated_at")
    private Date updatedAt;

    public ShoplazzaImages() {
    }

    public ShoplazzaImages(String src) {
        this.src = src;
    }

    private ShoplazzaImages(Builder builder) {
        setProductId(builder.productId);
        setId(builder.id);
        setSrc(builder.src);
        setWidth(builder.width);
        setAlt(builder.alt);
        setHeight(builder.height);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public static final class Builder {
        private String productId;
        private String id;
        private String src;
        private Integer width;
        private String alt;
        private Integer height;
        private Date createdAt;
        private Date updatedAt;

        private Builder() {
        }

        public Builder withProductId(String val) {
            productId = val;
            return this;
        }

        public Builder withId(String val) {
            id = val;
            return this;
        }

        public Builder withSrc(String val) {
            src = val;
            return this;
        }

        public Builder withWidth(Integer val) {
            width = val;
            return this;
        }

        public Builder withAlt(String val) {
            alt = val;
            return this;
        }

        public Builder withHeight(Integer val) {
            height = val;
            return this;
        }

        public Builder withCreatedAt(Date val) {
            createdAt = val;
            return this;
        }

        public Builder withUpdatedAt(Date val) {
            updatedAt = val;
            return this;
        }

        public ShoplazzaImages build() {
            return new ShoplazzaImages(this);
        }
    }
}