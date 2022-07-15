package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaLineItem {
    @XmlElement(name = "variant_title")
    private String variantTitle;
    private String note;
    private String image;
    private Integer quantity;
    @XmlElement(name = "fulfillment_status")
    private String fulfillmentStatus;
    @XmlElement(name = "product_url")
    private String productUrl;
    @XmlElement(name = "compare_at_price")
    private BigDecimal compareAtPrice;
    private String weight;
    @XmlElement(name = "product_title")
    private String productTitle;
    @XmlElement(name = "refund_quantity")
    private Integer refundQuantity;
    private String total;
    @XmlElement(name = "variant_id")
    private String variantId;
    @XmlElement(name = "weight_unit")
    private String weightUnit;
    private String vendor;
    private String price;
    @XmlElement(name = "product_id")
    private String productId;
    @XmlElement(name = "product_handle")
    private String productHandle;
    private String id;
    private String sku;
    private List<ShoplazzaProperties> properties;
    @XmlElement(name = "refund_total")
    private String refundTotal;

    public ShoplazzaLineItem() {
    }

    private ShoplazzaLineItem(Builder builder) {
        setVariantTitle(builder.variantTitle);
        setNote(builder.note);
        setImage(builder.image);
        setQuantity(builder.quantity);
        setFulfillmentStatus(builder.fulfillmentStatus);
        setProductUrl(builder.productUrl);
        setCompareAtPrice(builder.compareAtPrice);
        setWeight(builder.weight);
        setProductTitle(builder.productTitle);
        setRefundQuantity(builder.refundQuantity);
        setTotal(builder.total);
        setVariantId(builder.variantId);
        setWeightUnit(builder.weightUnit);
        setVendor(builder.vendor);
        setPrice(builder.price);
        setProductId(builder.productId);
        setProductHandle(builder.productHandle);
        setId(builder.id);
        setSku(builder.sku);
        setProperties(builder.properties);
        setRefundTotal(builder.refundTotal);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getVariantTitle() {
        return variantTitle;
    }

    public void setVariantTitle(String variantTitle) {
        this.variantTitle = variantTitle;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getFulfillmentStatus() {
        return fulfillmentStatus;
    }

    public void setFulfillmentStatus(String fulfillmentStatus) {
        this.fulfillmentStatus = fulfillmentStatus;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public BigDecimal getCompareAtPrice() {
        return compareAtPrice;
    }

    public void setCompareAtPrice(BigDecimal compareAtPrice) {
        this.compareAtPrice = compareAtPrice;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getProductTitle() {
        return productTitle;
    }

    public void setProductTitle(String productTitle) {
        this.productTitle = productTitle;
    }

    public Integer getRefundQuantity() {
        return refundQuantity;
    }

    public void setRefundQuantity(Integer refundQuantity) {
        this.refundQuantity = refundQuantity;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getVariantId() {
        return variantId;
    }

    public void setVariantId(String variantId) {
        this.variantId = variantId;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductHandle() {
        return productHandle;
    }

    public void setProductHandle(String productHandle) {
        this.productHandle = productHandle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public List<ShoplazzaProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<ShoplazzaProperties> properties) {
        this.properties = properties;
    }

    public String getRefundTotal() {
        return refundTotal;
    }

    public void setRefundTotal(String refundTotal) {
        this.refundTotal = refundTotal;
    }

    public static final class Builder {
        private String variantTitle;
        private String note;
        private String image;
        private Integer quantity;
        private String fulfillmentStatus;
        private String productUrl;
        private BigDecimal compareAtPrice;
        private String weight;
        private String productTitle;
        private Integer refundQuantity;
        private String total;
        private String variantId;
        private String weightUnit;
        private String vendor;
        private String price;
        private String productId;
        private String productHandle;
        private String id;
        private String sku;
        private List<ShoplazzaProperties> properties;
        private String refundTotal;

        private Builder() {
        }

        public Builder withVariantTitle(String val) {
            variantTitle = val;
            return this;
        }

        public Builder withNote(String val) {
            note = val;
            return this;
        }

        public Builder withImage(String val) {
            image = val;
            return this;
        }

        public Builder withQuantity(Integer val) {
            quantity = val;
            return this;
        }

        public Builder withFulfillmentStatus(String val) {
            fulfillmentStatus = val;
            return this;
        }

        public Builder withProductUrl(String val) {
            productUrl = val;
            return this;
        }

        public Builder withCompareAtPrice(BigDecimal val) {
            compareAtPrice = val;
            return this;
        }

        public Builder withWeight(String val) {
            weight = val;
            return this;
        }

        public Builder withProductTitle(String val) {
            productTitle = val;
            return this;
        }

        public Builder withRefundQuantity(Integer val) {
            refundQuantity = val;
            return this;
        }

        public Builder withTotal(String val) {
            total = val;
            return this;
        }

        public Builder withVariantId(String val) {
            variantId = val;
            return this;
        }

        public Builder withWeightUnit(String val) {
            weightUnit = val;
            return this;
        }

        public Builder withVendor(String val) {
            vendor = val;
            return this;
        }

        public Builder withPrice(String val) {
            price = val;
            return this;
        }

        public Builder withProductId(String val) {
            productId = val;
            return this;
        }

        public Builder withProductHandle(String val) {
            productHandle = val;
            return this;
        }

        public Builder withId(String val) {
            id = val;
            return this;
        }

        public Builder withSku(String val) {
            sku = val;
            return this;
        }

        public Builder withProperties(List<ShoplazzaProperties> val) {
            properties = val;
            return this;
        }

        public Builder withRefundTotal(String val) {
            refundTotal = val;
            return this;
        }

        public ShoplazzaLineItem build() {
            return new ShoplazzaLineItem(this);
        }
    }
}