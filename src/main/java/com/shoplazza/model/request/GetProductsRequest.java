package com.shoplazza.model.request;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2022/6/6
 * Time: 15:36
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GetProductsRequest {
    /**
     * Product's IDs, separated by comma, for example: 9e79ca1f-9ff2-409b-976f-98be343d38a3,9e79ca1f-9ff2-409b-976f-98be343d38ae
     */
    private String ids;
    /**
     * product's title
     */
    private String title;
    /**
     * Collection ID, for example: 9e79ca1f-9ff2-409b-976f-98be343d38a3
     */
    @XmlElement(name = "collection_id")
    private String collectionId;
    /**
     * filter products created at or after date, for example: 2018-10-01T16:15:47-04:00
     */

    @XmlElement(name = "created_at_min")
    private Date createdAtMin;
    /**
     * filter products created at or before date, for example: 2018-10-01T16:15:47-04:00
     */

    @XmlElement(name = "created_at_max")
    private Date createdAtMax;
    /**
     * filter products last updated at or after date, for example: 2018-10-01T16:15:47-04:00
     */

    @XmlElement(name = "updated_at_min")
    private Date updatedAtMin;
    /**
     * filter products last updated at or before date, for example: 2018-10-01T16:15:47-04:00
     */

    @XmlElement(name = "updated_at_max")
    private Date updatedAtMax;
    /**
     * filter products published at or after date, for example: 2018-10-01T16:15:47-04:00
     */

    @XmlElement(name = "published_at_min")
    private Date publishedAtMin;
    /**
     * filter products published at or before date, for example: 2018-10-01T16:15:47-04:00
     */

    @XmlElement(name = "published_at_max")
    private Date publishedAtMax;
    /**
     * filter by published status: published, unpublished, any
     */
    @XmlElement(name = "published_status")
    private String publishedStatus;
    /**
     * Product's SPUs, separated by comma, for example: spu1,spu2
     */
    private String spus;
    /**
     * page number
     */
    private Integer page;
    /**
     * limit per page
     */
    private Integer limit;
    /**
     * filter fields return in responses, separated by comma, for example: title, id
     */
    private String fields;

    public GetProductsRequest() {
    }

    private GetProductsRequest(Builder builder) {
        setIds(builder.ids);
        setTitle(builder.title);
        setCollectionId(builder.collectionId);
        setCreatedAtMin(builder.createdAtMin);
        setCreatedAtMax(builder.createdAtMax);
        setUpdatedAtMin(builder.updatedAtMin);
        setUpdatedAtMax(builder.updatedAtMax);
        setPublishedAtMin(builder.publishedAtMin);
        setPublishedAtMax(builder.publishedAtMax);
        setPublishedStatus(builder.publishedStatus);
        setSpus(builder.spus);
        setPage(builder.page);
        setLimit(builder.limit);
        setFields(builder.fields);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(String collectionId) {
        this.collectionId = collectionId;
    }

    public Date getCreatedAtMin() {
        return createdAtMin;
    }

    public void setCreatedAtMin(Date createdAtMin) {
        this.createdAtMin = createdAtMin;
    }

    public Date getCreatedAtMax() {
        return createdAtMax;
    }

    public void setCreatedAtMax(Date createdAtMax) {
        this.createdAtMax = createdAtMax;
    }

    public Date getUpdatedAtMin() {
        return updatedAtMin;
    }

    public void setUpdatedAtMin(Date updatedAtMin) {
        this.updatedAtMin = updatedAtMin;
    }

    public Date getUpdatedAtMax() {
        return updatedAtMax;
    }

    public void setUpdatedAtMax(Date updatedAtMax) {
        this.updatedAtMax = updatedAtMax;
    }

    public Date getPublishedAtMin() {
        return publishedAtMin;
    }

    public void setPublishedAtMin(Date publishedAtMin) {
        this.publishedAtMin = publishedAtMin;
    }

    public Date getPublishedAtMax() {
        return publishedAtMax;
    }

    public void setPublishedAtMax(Date publishedAtMax) {
        this.publishedAtMax = publishedAtMax;
    }

    public String getPublishedStatus() {
        return publishedStatus;
    }

    public void setPublishedStatus(String publishedStatus) {
        this.publishedStatus = publishedStatus;
    }

    public String getSpus() {
        return spus;
    }

    public void setSpus(String spus) {
        this.spus = spus;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getFields() {
        return fields;
    }

    public void setFields(String fields) {
        this.fields = fields;
    }

    public static final class Builder {
        private String ids;
        private String title;
        private String collectionId;
        private Date createdAtMin;
        private Date createdAtMax;
        private Date updatedAtMin;
        private Date updatedAtMax;
        private Date publishedAtMin;
        private Date publishedAtMax;
        private String publishedStatus;
        private String spus;
        private Integer page;
        private Integer limit;
        private String fields;

        private Builder() {
        }

        public Builder withIds(String val) {
            ids = val;
            return this;
        }

        public Builder withTitle(String val) {
            title = val;
            return this;
        }

        public Builder withCollectionId(String val) {
            collectionId = val;
            return this;
        }

        public Builder withCreatedAtMin(Date val) {
            createdAtMin = val;
            return this;
        }

        public Builder withCreatedAtMax(Date val) {
            createdAtMax = val;
            return this;
        }

        public Builder withUpdatedAtMin(Date val) {
            updatedAtMin = val;
            return this;
        }

        public Builder withUpdatedAtMax(Date val) {
            updatedAtMax = val;
            return this;
        }

        public Builder withPublishedAtMin(Date val) {
            publishedAtMin = val;
            return this;
        }

        public Builder withPublishedAtMax(Date val) {
            publishedAtMax = val;
            return this;
        }

        public Builder withPublishedStatus(String val) {
            publishedStatus = val;
            return this;
        }

        public Builder withSpus(String val) {
            spus = val;
            return this;
        }

        public Builder withPage(Integer val) {
            page = val;
            return this;
        }

        public Builder withLimit(Integer val) {
            limit = val;
            return this;
        }

        public Builder withFields(String val) {
            fields = val;
            return this;
        }

        public GetProductsRequest build() {
            return new GetProductsRequest(this);
        }
    }
}
