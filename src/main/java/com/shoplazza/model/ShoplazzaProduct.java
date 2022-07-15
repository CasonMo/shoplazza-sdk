package com.shoplazza.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaProduct implements Serializable {

    private String id;
    /**
     * 商品副标题
     */
    private String brief;
    /**
     * 虚拟销量
     */
    @XmlElement(name = "fake_sales")
    private Integer fakeSales;
    /**
     * 备注
     */
    private String note;
    /**
     * 图片
     */
    private List<ShoplazzaImages> images;
    /**
     * 是否显示虚拟销量
     */
    @XmlElement(name = "display_fake_sales")
    private boolean displayFakeSales;
    /**
     * 对此商品收税
     */
    private boolean taxable;
    /**
     * SEO标题
     */
    @XmlElement(name = "meta_title")
    private String metaTitle;
    /**
     * 是否需要发货
     */
    @XmlElement(name = "requires_shipping")
    private boolean requiresShipping;
    /**
     * 跟踪库存
     */
    @XmlElement(name = "inventory_tracking")
    private boolean inventoryTracking;
    /**
     * 商品描述
     */
    private String description;
    /**
     * product's handle
     */
    private String handle;
    /**
     * 是否发布
     */
    private boolean published;
    /**
     * SKU / 款式
     */
    private List<ShoplazzaVariant> variants;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 库存策略
     * inventory policy: continue, deny, auto_unpublished, required while inventory_tracking is true
     */
    @XmlElement(name = "inventory_policy")
    private String inventoryPolicy;
    /**
     * 标签
     */
    private String tags;
    /**
     * 款式配置 - 需要配图
     */
    @XmlElement(name = "need_variant_image")
    private boolean needVariantImage;
    /**
     * SEO描述
     */
    @XmlElement(name = "meta_description")
    private String metaDescription;
    /**
     * 供应商
     */
    private String vendor;
    /**
     * SEO关键词
     */
    @XmlElement(name = "meta_keyword")
    private String metaKeyword;
    /**
     * 属性
     */
    private List<ShoplazzaOption> options;
    /**
     * SPU(Standard ShoplazzaProduct Unit)：标准化产品单元。是商品信息聚合的最小单位，是一组可复用、易检索的标准化信息的集合，该集合描述了一个产品的特性。通俗点讲，属性值、特性相同的商品就可以称为一个SPU。
     */
    private String spu;
    /**
     * 供应商URL
     */
    @XmlElement(name = "vendor_url")
    private String vendorUrl;
    /**
     * 单独款式
     */
    @XmlElement(name = "has_only_default_variant")
    private boolean hasOnlyDefaultVariant;
    @XmlElement(name = "created_at")
    private Date createdAt;
    @XmlElement(name = "updated_at")
    private Date updatedAt;

    public ShoplazzaProduct() {
    }

    private ShoplazzaProduct(Builder builder) {
        setId(builder.id);
        setBrief(builder.brief);
        setFakeSales(builder.fakeSales);
        setNote(builder.note);
        setImages(builder.images);
        setDisplayFakeSales(builder.displayFakeSales);
        setTaxable(builder.taxable);
        setMetaTitle(builder.metaTitle);
        setRequiresShipping(builder.requiresShipping);
        setInventoryTracking(builder.inventoryTracking);
        setDescription(builder.description);
        setHandle(builder.handle);
        setPublished(builder.published);
        setVariants(builder.variants);
        setTitle(builder.title);
        setInventoryPolicy(builder.inventoryPolicy);
        setTags(builder.tags);
        setNeedVariantImage(builder.needVariantImage);
        setMetaDescription(builder.metaDescription);
        setVendor(builder.vendor);
        setMetaKeyword(builder.metaKeyword);
        setOptions(builder.options);
        setSpu(builder.spu);
        setVendorUrl(builder.vendorUrl);
        setHasOnlyDefaultVariant(builder.hasOnlyDefaultVariant);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
    }

    public static Builder builder() {
        return new Builder();
    }

    public enum PublishedStatusEnum {
        PUBLISHED("published"), UNPUBLISHED("unpublished"), ANY("any");
        private final String value;

        PublishedStatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public Integer getFakeSales() {
        return fakeSales;
    }

    public void setFakeSales(Integer fakeSales) {
        this.fakeSales = fakeSales;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<ShoplazzaImages> getImages() {
        return images;
    }

    public void setImages(List<ShoplazzaImages> images) {
        this.images = images;
    }

    public boolean isDisplayFakeSales() {
        return displayFakeSales;
    }

    public void setDisplayFakeSales(boolean displayFakeSales) {
        this.displayFakeSales = displayFakeSales;
    }

    public boolean isTaxable() {
        return taxable;
    }

    public void setTaxable(boolean taxable) {
        this.taxable = taxable;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public boolean isRequiresShipping() {
        return requiresShipping;
    }

    public void setRequiresShipping(boolean requiresShipping) {
        this.requiresShipping = requiresShipping;
    }

    public boolean isInventoryTracking() {
        return inventoryTracking;
    }

    public void setInventoryTracking(boolean inventoryTracking) {
        this.inventoryTracking = inventoryTracking;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public List<ShoplazzaVariant> getVariants() {
        return variants;
    }

    public void setVariants(List<ShoplazzaVariant> variants) {
        this.variants = variants;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInventoryPolicy() {
        return inventoryPolicy;
    }

    public void setInventoryPolicy(String inventoryPolicy) {
        this.inventoryPolicy = inventoryPolicy;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public boolean isNeedVariantImage() {
        return needVariantImage;
    }

    public void setNeedVariantImage(boolean needVariantImage) {
        this.needVariantImage = needVariantImage;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getMetaKeyword() {
        return metaKeyword;
    }

    public void setMetaKeyword(String metaKeyword) {
        this.metaKeyword = metaKeyword;
    }

    public List<ShoplazzaOption> getOptions() {
        return options;
    }

    public void setOptions(List<ShoplazzaOption> options) {
        this.options = options;
    }

    public String getSpu() {
        return spu;
    }

    public void setSpu(String spu) {
        this.spu = spu;
    }

    public String getVendorUrl() {
        return vendorUrl;
    }

    public void setVendorUrl(String vendorUrl) {
        this.vendorUrl = vendorUrl;
    }

    public boolean isHasOnlyDefaultVariant() {
        return hasOnlyDefaultVariant;
    }

    public void setHasOnlyDefaultVariant(boolean hasOnlyDefaultVariant) {
        this.hasOnlyDefaultVariant = hasOnlyDefaultVariant;
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
        private String id;
        private String brief;
        private Integer fakeSales;
        private String note;
        private List<ShoplazzaImages> images;
        private boolean displayFakeSales;
        private boolean taxable;
        private String metaTitle;
        private boolean requiresShipping;
        private boolean inventoryTracking;
        private String description;
        private String handle;
        private boolean published;
        private List<ShoplazzaVariant> variants;
        private String title;
        private String inventoryPolicy;
        private String tags;
        private boolean needVariantImage;
        private String metaDescription;
        private String vendor;
        private String metaKeyword;
        private List<ShoplazzaOption> options;
        private String spu;
        private String vendorUrl;
        private boolean hasOnlyDefaultVariant;
        private Date createdAt;
        private Date updatedAt;

        private Builder() {
        }

        public Builder withId(String val) {
            id = val;
            return this;
        }

        public Builder withBrief(String val) {
            brief = val;
            return this;
        }

        public Builder withFakeSales(Integer val) {
            fakeSales = val;
            return this;
        }

        public Builder withNote(String val) {
            note = val;
            return this;
        }

        public Builder withImages(List<ShoplazzaImages> val) {
            images = val;
            return this;
        }

        public Builder withDisplayFakeSales(boolean val) {
            displayFakeSales = val;
            return this;
        }

        public Builder withTaxable(boolean val) {
            taxable = val;
            return this;
        }

        public Builder withMetaTitle(String val) {
            metaTitle = val;
            return this;
        }

        public Builder withRequiresShipping(boolean val) {
            requiresShipping = val;
            return this;
        }

        public Builder withInventoryTracking(boolean val) {
            inventoryTracking = val;
            return this;
        }

        public Builder withDescription(String val) {
            description = val;
            return this;
        }

        public Builder withHandle(String val) {
            handle = val;
            return this;
        }

        public Builder withPublished(boolean val) {
            published = val;
            return this;
        }

        public Builder withVariants(List<ShoplazzaVariant> val) {
            variants = val;
            return this;
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withInventoryPolicy(String val) {
            inventoryPolicy = val;
            return this;
        }

        public Builder withTags(String val) {
            tags = val;
            return this;
        }

        public Builder withNeedVariantImage(boolean val) {
            needVariantImage = val;
            return this;
        }

        public Builder withMetaDescription(String val) {
            metaDescription = val;
            return this;
        }

        public Builder withVendor(String val) {
            vendor = val;
            return this;
        }

        public Builder withMetaKeyword(String val) {
            metaKeyword = val;
            return this;
        }

        public Builder withOptions(List<ShoplazzaOption> val) {
            options = val;
            return this;
        }

        public Builder withSpu(String val) {
            spu = val;
            return this;
        }

        public Builder withVendorUrl(String val) {
            vendorUrl = val;
            return this;
        }

        public Builder withHasOnlyDefaultVariant(boolean val) {
            hasOnlyDefaultVariant = val;
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

        public ShoplazzaProduct build() {
            return new ShoplazzaProduct(this);
        }
    }
}