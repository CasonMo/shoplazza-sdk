package com.shoplazza.model.request;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2022/6/6
 * Time: 16:18
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateFulfillmentRequest {
    @XmlElement(name = "line_item_ids")
    private List<String> lineItemIds;
    @XmlElement(name = "tracking_number")
    private String trackingNumber;
    @XmlElement(name = "tracking_company")
    private String trackingCompany;
    @XmlElement(name = "tracking_company_code")
    private String trackingCompanyCode;

    public CreateFulfillmentRequest() {
    }

    private CreateFulfillmentRequest(Builder builder) {
        setLineItemIds(builder.lineItemIds);
        setTrackingNumber(builder.trackingNumber);
        setTrackingCompany(builder.trackingCompany);
        setTrackingCompanyCode(builder.trackingCompanyCode);
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<String> getLineItemIds() {
        return lineItemIds;
    }

    public void setLineItemIds(List<String> lineItemIds) {
        this.lineItemIds = lineItemIds;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingCompany() {
        return trackingCompany;
    }

    public void setTrackingCompany(String trackingCompany) {
        this.trackingCompany = trackingCompany;
    }

    public String getTrackingCompanyCode() {
        return trackingCompanyCode;
    }

    public void setTrackingCompanyCode(String trackingCompanyCode) {
        this.trackingCompanyCode = trackingCompanyCode;
    }

    public static final class Builder {
        private List<String> lineItemIds;
        private String trackingNumber;
        private String trackingCompany;
        private String trackingCompanyCode;

        private Builder() {
        }

        public Builder withLineItemIds(List<String> val) {
            lineItemIds = val;
            return this;
        }

        public Builder withTrackingNumber(String val) {
            trackingNumber = val;
            return this;
        }

        public Builder withTrackingCompany(String val) {
            trackingCompany = val;
            return this;
        }

        public Builder withTrackingCompanyCode(String val) {
            trackingCompanyCode = val;
            return this;
        }

        public CreateFulfillmentRequest build() {
            return new CreateFulfillmentRequest(this);
        }
    }

}
