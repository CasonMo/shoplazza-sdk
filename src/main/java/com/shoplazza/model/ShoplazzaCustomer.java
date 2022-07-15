package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaCustomer {
    @XmlElement(name = "total_spent")
    private String totalSpent;
    @XmlElement(name = "orders_count")
    private Integer ordersCount;
    @XmlElement(name = "updated_at")
    private Date updatedAt;
    private String phone;
    @XmlElement(name = "last_name")
    private String lastname;
    @XmlElement(name = "created_at")
    private Date createdAt;
    @XmlElement(name = "first_name")
    private String firstName;
    private String email;

    public ShoplazzaCustomer() {
    }

    private ShoplazzaCustomer(Builder builder) {
        setTotalSpent(builder.totalSpent);
        setOrdersCount(builder.ordersCount);
        setUpdatedAt(builder.updatedAt);
        setPhone(builder.phone);
        setLastname(builder.lastname);
        setCreatedAt(builder.createdAt);
        setFirstName(builder.firstName);
        setEmail(builder.email);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getTotalSpent() {
        return totalSpent;
    }

    public void setTotalSpent(String totalSpent) {
        this.totalSpent = totalSpent;
    }

    public Integer getOrdersCount() {
        return ordersCount;
    }

    public void setOrdersCount(Integer ordersCount) {
        this.ordersCount = ordersCount;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static final class Builder {
        private String totalSpent;
        private Integer ordersCount;
        private Date updatedAt;
        private String phone;
        private String lastname;
        private Date createdAt;
        private String firstName;
        private String email;

        private Builder() {
        }

        public Builder withTotalSpent(String val) {
            totalSpent = val;
            return this;
        }

        public Builder withOrdersCount(Integer val) {
            ordersCount = val;
            return this;
        }

        public Builder withUpdatedAt(Date val) {
            updatedAt = val;
            return this;
        }

        public Builder withPhone(String val) {
            phone = val;
            return this;
        }

        public Builder withLastname(String val) {
            lastname = val;
            return this;
        }

        public Builder withCreatedAt(Date val) {
            createdAt = val;
            return this;
        }

        public Builder withFirstName(String val) {
            firstName = val;
            return this;
        }

        public Builder withEmail(String val) {
            email = val;
            return this;
        }

        public ShoplazzaCustomer build() {
            return new ShoplazzaCustomer(this);
        }
    }
}