package com.shoplazza.model.request;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2022/6/6
 * Time: 15:36
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateWebhookRequest {

    /**
     * Webhook notification URL, e.g. https://example.com/webhook
     */
    private String address;
    /**
     * The event name, e.g. orders/cancelled,orders/create
     */
    private String topic;

    private CreateWebhookRequest(Builder builder) {
        setAddress(builder.address);
        setTopic(builder.topic);
    }

    public static Builder builder() {
        return new Builder();
    }

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

    public CreateWebhookRequest() {
    }

    public static final class Builder {
        private String address;
        private String topic;

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

        public CreateWebhookRequest build() {
            return new CreateWebhookRequest(this);
        }
    }
}
