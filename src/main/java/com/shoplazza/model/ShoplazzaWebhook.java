package com.shoplazza.model;

public class ShoplazzaWebhook {
	private String address;
	private String updatedAt;
	private String format;
	private String topic;
	private String createdAt;
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

	public String getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(String updatedAt) {
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

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
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
		private String updatedAt;
		private String format;
		private String topic;
		private String createdAt;
		private String id;

		private Builder() {
		}

		public Builder withAddress(String val) {
			address = val;
			return this;
		}

		public Builder withUpdatedAt(String val) {
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

		public Builder withCreatedAt(String val) {
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
