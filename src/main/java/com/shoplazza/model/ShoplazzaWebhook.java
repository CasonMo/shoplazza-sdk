package com.shoplazza.model;

import java.util.Date;

public class ShoplazzaWebhook {
	private String address;
	private Date updatedAt;
	private String format;
	private String topic;
	private Date createdAt;
	private String id;

	private ShoplazzaWebhook(Builder builder) {
		setAddress(builder.address);
		setUpdatedAt(builder.updatedAt);
		setFormat(builder.format);
		setTopic(builder.topic);
		setCreatedAt(builder.createdAt);
		setId(builder.id);
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

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static final class Builder {
		private String address;
		private Date updatedAt;
		private String format;
		private String topic;
		private Date createdAt;
		private String id;

		private Builder() {
		}

		public Builder withAddress(String val) {
			address = val;
			return this;
		}

		public Builder withUpdatedAt(Date val) {
			updatedAt = val;
			return this;
		}

		public Builder withFormat(String val) {
			format = val;
			return this;
		}

		public Builder withTopic(String val) {
			topic = val;
			return this;
		}

		public Builder withCreatedAt(Date val) {
			createdAt = val;
			return this;
		}

		public Builder withId(String val) {
			id = val;
			return this;
		}

		public ShoplazzaWebhook build() {
			return new ShoplazzaWebhook(this);
		}
	}
}
