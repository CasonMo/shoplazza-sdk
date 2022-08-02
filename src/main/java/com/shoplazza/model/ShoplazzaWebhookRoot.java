package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaWebhookRoot {
	private ShoplazzaWebhook webhook;

	private ShoplazzaWebhookRoot(Builder builder) {
		setWebhook(builder.webhook);
	}

	public static Builder builder() {
		return new Builder();
	}

	public ShoplazzaWebhook getWebhook() {
		return webhook;
	}

	public void setWebhook(ShoplazzaWebhook webhook) {
		this.webhook = webhook;
	}

	public static final class Builder {
		private ShoplazzaWebhook webhook;

		private Builder() {
		}

		public Builder withWebhook(ShoplazzaWebhook val) {
			webhook = val;
			return this;
		}

		public ShoplazzaWebhookRoot build() {
			return new ShoplazzaWebhookRoot(this);
		}
	}
}