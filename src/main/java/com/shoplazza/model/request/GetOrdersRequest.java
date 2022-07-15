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
public class GetOrdersRequest {
    /**
     * Order's IDs, please use comma as separator, for example 701670d5-4afd-40b5-8d4f-7e0e55683849,da1bb9af-2489-40df-a15e-f54abdf7fd86
     */
    private String ids;
    /**
     * limit per page, default: 10, maximum: 250
     */
    private Integer limit = 10;
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
    /**
     * filter order placed at or after date, for example: 2016-01-18T23:41:00Z
     */

    @XmlElement(name = "placed_at_min")
    private Date placedAtMin;
    /**
     * filter order placed at or before date, for example: 2016-01-18T23:41:00Z
     */

    @XmlElement(name = "placed_at_max")
    private Date placedAtMax;
    /**
     * filter orders by status: opened, placed, finished, cancelled
     */
    private String status;
    /**
     * filter orders by financial status: waiting, paying, paid, cancelled, failed, refunding, refund_failed, refunded, partially_refunded
     */
    @XmlElement(name = "financial_status")
    private String financialStatus;
    /**
     * filter orders by fulfillment_status: initialled, waiting, partially_shipped, shipped, partially_finished, finished, cancelled
     */
    @XmlElement(name = "fulfillment_status")
    private String fulfillmentStatus;

    public GetOrdersRequest() {
    }

    private GetOrdersRequest(Builder builder) {
        setIds(builder.ids);
        setLimit(builder.limit);
        setPage(builder.page);
        setCreatedAtMin(builder.createdAtMin);
        setCreatedAtMax(builder.createdAtMax);
        setUpdatedAtMin(builder.updatedAtMin);
        setUpdatedAtMax(builder.updatedAtMax);
        setPlacedAtMin(builder.placedAtMin);
        setPlacedAtMax(builder.placedAtMax);
        setStatus(builder.status);
        setFinancialStatus(builder.financialStatus);
        setFulfillmentStatus(builder.fulfillmentStatus);
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

    public Date getPlacedAtMin() {
        return placedAtMin;
    }

    public void setPlacedAtMin(Date placedAtMin) {
        this.placedAtMin = placedAtMin;
    }

    public Date getPlacedAtMax() {
        return placedAtMax;
    }

    public void setPlacedAtMax(Date placedAtMax) {
        this.placedAtMax = placedAtMax;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFinancialStatus() {
        return financialStatus;
    }

    public void setFinancialStatus(String financialStatus) {
        this.financialStatus = financialStatus;
    }

    public String getFulfillmentStatus() {
        return fulfillmentStatus;
    }

    public void setFulfillmentStatus(String fulfillmentStatus) {
        this.fulfillmentStatus = fulfillmentStatus;
    }


    public static final class Builder {
        private String ids;
        private Integer limit;
        private Integer page;
        private Date createdAtMin;
        private Date createdAtMax;
        private Date updatedAtMin;
        private Date updatedAtMax;
        private Date placedAtMin;
        private Date placedAtMax;
        private String status;
        private String financialStatus;
        private String fulfillmentStatus;

        private Builder() {
        }

        public Builder withIds(String val) {
            ids = val;
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

        public Builder withPlacedAtMin(Date val) {
            placedAtMin = val;
            return this;
        }

        public Builder withPlacedAtMax(Date val) {
            placedAtMax = val;
            return this;
        }

        public Builder withStatus(String val) {
            status = val;
            return this;
        }

        public Builder withFinancialStatus(String val) {
            financialStatus = val;
            return this;
        }

        public Builder withFulfillmentStatus(String val) {
            fulfillmentStatus = val;
            return this;
        }

        public GetOrdersRequest build() {
            return new GetOrdersRequest(this);
        }
    }

}
