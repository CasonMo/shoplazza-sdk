package com.shoplazza.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaVariant implements Serializable {
    @XmlElement(name = "inventory_quantity")
    private Integer inventoryQuantity;
    private ShoplazzaImages image;
    private String note;
    @XmlElement(name = "product_id")
    private String productId;
    private String id;
    /**
     * 原价 original price
     */
    @XmlElement(name = "compare_at_price")
    private BigDecimal compareAtPrice;
    @XmlElement(name = "weight_unit")
    private String weightUnit;
    private BigDecimal price;
    private Double weight;
    private String option1;
    private String option2;
    private String option3;
    private String sku;
    private String barcode;
    @XmlElement(name = "created_at")
    private Date createdAt;
    @XmlElement(name = "updated_at")
    private Date updatedAt;

    public ShoplazzaVariant() {
    }

    private ShoplazzaVariant(Builder builder) {
        setInventoryQuantity(builder.inventoryQuantity);
        setImage(builder.image);
        setNote(builder.note);
        setProductId(builder.productId);
        setId(builder.id);
        setCompareAtPrice(builder.compareAtPrice);
        setWeightUnit(builder.weightUnit);
        setPrice(builder.price);
        setWeight(builder.weight);
        setOption1(builder.option1);
        setOption2(builder.option2);
        setOption3(builder.option3);
        setSku(builder.sku);
        setBarcode(builder.barcode);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
    }

    public static Builder builder() {
        return new Builder();
    }

    public Integer getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Integer inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public ShoplazzaImages getImage() {
        return image;
    }

    public void setImage(ShoplazzaImages image) {
        this.image = image;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public BigDecimal getCompareAtPrice() {
        return compareAtPrice;
    }

    public void setCompareAtPrice(BigDecimal compareAtPrice) {
        this.compareAtPrice = compareAtPrice;
    }

    public String getWeightUnit() {
        return weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
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
        private Integer inventoryQuantity;
        private ShoplazzaImages image;
        private String note;
        private String productId;
        private String id;
        private BigDecimal compareAtPrice;
        private String weightUnit;
        private BigDecimal price;
        private Double weight;
        private String option1;
        private String option2;
        private String option3;
        private String sku;
        private String barcode;
        private Date createdAt;
        private Date updatedAt;

        private Builder() {
        }

        public Builder withInventoryQuantity(Integer val) {
            inventoryQuantity = val;
            return this;
        }

        public Builder withImage(ShoplazzaImages val) {
            image = val;
            return this;
        }

        public Builder withNote(String val) {
            note = val;
            return this;
        }

        public Builder withProductId(String val) {
            productId = val;
            return this;
        }

        public Builder withId(String val) {
            id = val;
            return this;
        }

        public Builder withCompareAtPrice(BigDecimal val) {
            compareAtPrice = val;
            return this;
        }

        public Builder withWeightUnit(String val) {
            weightUnit = val;
            return this;
        }

        public Builder withPrice(BigDecimal val) {
            price = val;
            return this;
        }

        public Builder withWeight(Double val) {
            weight = val;
            return this;
        }

        public Builder withOption1(String val) {
            option1 = val;
            return this;
        }

        public Builder withOption2(String val) {
            option2 = val;
            return this;
        }

        public Builder withOption3(String val) {
            option3 = val;
            return this;
        }

        public Builder withSku(String val) {
            sku = val;
            return this;
        }

        public Builder withBarcode(String val) {
            barcode = val;
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

        public ShoplazzaVariant build() {
            return new ShoplazzaVariant(this);
        }
    }
}