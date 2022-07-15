package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2022/6/6
 * Time: 17:14
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaFulfillment {
    private String id;
    @XmlElement(name = "order_id")
    private String orderId;
    private String status;
    @XmlElement(name = "created_at")
    private Date createdAt;
    @XmlElement(name = "updated_at")
    private Date updatedAt;
    @XmlElement(name = "tracking_company")
    private String trackingCompany;
    @XmlElement(name = "tracking_number")
    private String trackingNumber;
    @XmlElement(name = "tracking_company_code")
    private String trackingCompanyCode;
    @XmlElement(name = "line_items")
    private List<ShoplazzaLineItem> lineItems;

    public ShoplazzaFulfillment() {
    }

    private ShoplazzaFulfillment(Builder builder) {
        setId(builder.id);
        setOrderId(builder.orderId);
        setStatus(builder.status);
        setCreatedAt(builder.createdAt);
        setUpdatedAt(builder.updatedAt);
        setTrackingCompany(builder.trackingCompany);
        setTrackingNumber(builder.trackingNumber);
        setTrackingCompanyCode(builder.trackingCompanyCode);
        setLineItems(builder.lineItems);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getTrackingCompany() {
        return trackingCompany;
    }

    public void setTrackingCompany(String trackingCompany) {
        this.trackingCompany = trackingCompany;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingCompanyCode() {
        return trackingCompanyCode;
    }

    public void setTrackingCompanyCode(String trackingCompanyCode) {
        this.trackingCompanyCode = trackingCompanyCode;
    }

    public List<ShoplazzaLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<ShoplazzaLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public static final class Builder {
        private String id;
        private String orderId;
        private String status;
        private Date createdAt;
        private Date updatedAt;
        private String trackingCompany;
        private String trackingNumber;
        private String trackingCompanyCode;
        private List<ShoplazzaLineItem> lineItems;

        private Builder() {
        }

        public Builder withId(String val) {
            id = val;
            return this;
        }

        public Builder withOrderId(String val) {
            orderId = val;
            return this;
        }

        public Builder withStatus(String val) {
            status = val;
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

        public Builder withTrackingCompany(String val) {
            trackingCompany = val;
            return this;
        }

        public Builder withTrackingNumber(String val) {
            trackingNumber = val;
            return this;
        }

        public Builder withTrackingCompanyCode(String val) {
            trackingCompanyCode = val;
            return this;
        }

        public Builder withLineItems(List<ShoplazzaLineItem> val) {
            lineItems = val;
            return this;
        }

        public ShoplazzaFulfillment build() {
            return new ShoplazzaFulfillment(this);
        }
    }
}
