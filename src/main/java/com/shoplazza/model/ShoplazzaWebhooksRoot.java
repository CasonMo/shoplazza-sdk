package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaWebhooksRoot{
	private List<ShoplazzaWebhook> webhooks;

	private ShoplazzaWebhooksRoot(Builder builder) {
		setWebhooks(builder.webhooks);
	}

	public static Builder builder() {
		return new Builder();
	}

	public ShoplazzaWebhooksRoot() {
	}

	public List<ShoplazzaWebhook> getWebhooks(){
		return webhooks;
	}

	public void setWebhooks(List<ShoplazzaWebhook> webhooks) {
		this.webhooks = webhooks;
	}

	public static final class Builder {
		private List<ShoplazzaWebhook> webhooks;

		private Builder() {
		}

		public Builder withWebhooks(List<ShoplazzaWebhook> val) {
			webhooks = val;
			return this;
		}

		public ShoplazzaWebhooksRoot build() {
			return new ShoplazzaWebhooksRoot(this);
		}
	}
}