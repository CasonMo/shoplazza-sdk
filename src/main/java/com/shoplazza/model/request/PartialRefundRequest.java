package com.shoplazza.model.request;

import com.shoplazza.model.ShoplazzaLineItem;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2022/6/6
 * Time: 16:12
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PartialRefundRequest {
    /**
     * Whether to return the fulfillments, for example: true or false
     */
    @XmlElement(name = "is_return")
    private Boolean isReturn;
    /**
     * Refund Amount, for example: 10.00
     */
    private BigDecimal price;

    @XmlElement(name = "line_items")
    private List<ShoplazzaLineItem> lineItems;

    public PartialRefundRequest() {
    }

    private PartialRefundRequest(Builder builder) {
        isReturn = builder.isReturn;
        setPrice(builder.price);
        setLineItems(builder.lineItems);
    }

    public static Builder builder() {
        return new Builder();
    }


    public Boolean getReturn() {
        return isReturn;
    }

    public void setReturn(Boolean aReturn) {
        isReturn = aReturn;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<ShoplazzaLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<ShoplazzaLineItem> lineItems) {
        this.lineItems = lineItems;
    }


    public static final class Builder {
        private Boolean isReturn;
        private BigDecimal price;
        private List<ShoplazzaLineItem> lineItems;

        private Builder() {
        }

        public Builder withIsReturn(Boolean val) {
            isReturn = val;
            return this;
        }

        public Builder withPrice(BigDecimal val) {
            price = val;
            return this;
        }

        public Builder withLineItems(List<ShoplazzaLineItem> val) {
            lineItems = val;
            return this;
        }

        public PartialRefundRequest build() {
            return new PartialRefundRequest(this);
        }
    }
}
