package com.shoplazza.model;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2022/6/28
 * Time: 20:08
 */

public class ShoplazzaLineItemRoot {
    @XmlElement(name = "line_item")
    private List<ShoplazzaLineItem> lineItem;

    public ShoplazzaLineItemRoot() {
    }

    private ShoplazzaLineItemRoot(Builder builder) {
        setLineItem(builder.lineItem);
    }

    public static Builder builder() {
        return new Builder();
    }

    public List<ShoplazzaLineItem> getLineItem() {
        return lineItem;
    }

    public void setLineItem(List<ShoplazzaLineItem> lineItem) {
        this.lineItem = lineItem;
    }

    public static final class Builder {
        private List<ShoplazzaLineItem> lineItem;

        private Builder() {
        }

        public Builder withLineItem(List<ShoplazzaLineItem> val) {
            lineItem = val;
            return this;
        }

        public ShoplazzaLineItemRoot build() {
            return new ShoplazzaLineItemRoot(this);
        }
    }
}
