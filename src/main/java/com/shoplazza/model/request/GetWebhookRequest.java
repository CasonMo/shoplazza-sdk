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
public class GetWebhookRequest {

    /**
     * Webhook notification URL, e.g. https://example.com/webhook
     */
    private String address;
    /**
     * The event name, e.g. orders/cancelled,orders/create
     */
    private String topic;
    /**
     * result per page, max: 250
     */
    private Integer limit = 50;
    /**
     * page number
     */
    private Integer page;
    /**
     * filter orders created at or after date, for example: 2016-01-18T23:41:00Z
     */

    @XmlElement(name = "created_at_min")
    private Date createdAtMin;
    /**
     * filter orders created at or before date, for example: 2016-01-18T23:41:00Z
     */

    @XmlElement(name = "created_at_max")
    private Date createdAtMax;
    /**
     * filter orders last updated at or after date, for example: "2016-01-18T23:41:00Z"
     */

    @XmlElement(name = "updated_at_min")
    private Date updatedAtMin;
    /**
     * filter orders last updated at or before date, for example: 2016-01-18T23:41:00Z
     */

    @XmlElement(name = "updated_at_max")
    private Date updatedAtMax;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
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

    private GetWebhookRequest(Builder builder) {
        address = builder.address;
        topic = builder.topic;
        limit = builder.limit;
        page = builder.page;
        createdAtMin = builder.createdAtMin;
        createdAtMax = builder.createdAtMax;
        updatedAtMin = builder.updatedAtMin;
        updatedAtMax = builder.updatedAtMax;
    }

    public static Builder builder() {
        return new Builder();
    }


    public static final class Builder {
        private String address;
        private String topic;
        private Integer limit;
        private Integer page;
        private Date createdAtMin;
        private Date createdAtMax;
        private Date updatedAtMin;
        private Date updatedAtMax;

        private Builder() {
        }

        public Builder withAddress(String val) {
            address = val;
            return this;
        }

        public Builder withTopic(String val) {
            topic = val;
            return this;
        }

        public Builder withLimit(Integer val) {
            limit = val;
            return this;
        }

        public Builder withPage(Integer val) {
            page = val;
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

        public GetWebhookRequest build() {
            return new GetWebhookRequest(this);
        }
    }
}
