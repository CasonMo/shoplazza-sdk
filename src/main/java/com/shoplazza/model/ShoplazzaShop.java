package com.shoplazza.model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by IntelliJ IDEA.
 * User: 贝先 [ Cason mo ]
 * Date: 2022/5/20
 * Time: 10:56
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaShop {
    private String zip;
    private String address2;
    private String city;
    private String address1;
    private String timezone;
    @XmlElement(name = "primary_locale")
    private String primaryLocale;
    private ShoplazzaIcon icon;
    @XmlElement(name = "created_at")
    private String createdAt;
    @XmlElement(name = "province_code")
    private String provinceCode;
    @XmlElement(name = "country_code")
    private String countryCode;
    @XmlElement(name = "updated_at")
    private String updatedAt;
    private String phone;
    @XmlElement(name = "customer_email")
    private String customerEmail;
    private String domain;
    private String name;
    private String currency;
    private String id;
    @XmlElement(name = "shop_owner")
    private String shopOwner;
    private String email;
    private String account;

    public ShoplazzaShop() {
    }

    private ShoplazzaShop(Builder builder) {
        setZip(builder.zip);
        setAddress2(builder.address2);
        setCity(builder.city);
        setAddress1(builder.address1);
        setTimezone(builder.timezone);
        setPrimaryLocale(builder.primaryLocale);
        setIcon(builder.icon);
        setCreatedAt(builder.createdAt);
        setProvinceCode(builder.provinceCode);
        setCountryCode(builder.countryCode);
        setUpdatedAt(builder.updatedAt);
        setPhone(builder.phone);
        setCustomerEmail(builder.customerEmail);
        setDomain(builder.domain);
        setName(builder.name);
        setCurrency(builder.currency);
        setId(builder.id);
        setShopOwner(builder.shopOwner);
        setEmail(builder.email);
        setAccount(builder.account);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getPrimaryLocale() {
        return primaryLocale;
    }

    public void setPrimaryLocale(String primaryLocale) {
        this.primaryLocale = primaryLocale;
    }

    public ShoplazzaIcon getIcon() {
        return icon;
    }

    public void setIcon(ShoplazzaIcon icon) {
        this.icon = icon;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShopOwner() {
        return shopOwner;
    }

    public void setShopOwner(String shopOwner) {
        this.shopOwner = shopOwner;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public static final class Builder {
        private String zip;
        private String address2;
        private String city;
        private String address1;
        private String timezone;
        private String primaryLocale;
        private ShoplazzaIcon icon;
        private String createdAt;
        private String provinceCode;
        private String countryCode;
        private String updatedAt;
        private String phone;
        private String customerEmail;
        private String domain;
        private String name;
        private String currency;
        private String id;
        private String shopOwner;
        private String email;
        private String account;

        private Builder() {
        }

        public Builder withZip(String val) {
            zip = val;
            return this;
        }

        public Builder withAddress2(String val) {
            address2 = val;
            return this;
        }

        public Builder withCity(String val) {
            city = val;
            return this;
        }

        public Builder withAddress1(String val) {
            address1 = val;
            return this;
        }

        public Builder withTimezone(String val) {
            timezone = val;
            return this;
        }

        public Builder withPrimaryLocale(String val) {
            primaryLocale = val;
            return this;
        }

        public Builder withIcon(ShoplazzaIcon val) {
            icon = val;
            return this;
        }

        public Builder withCreatedAt(String val) {
            createdAt = val;
            return this;
        }

        public Builder withProvinceCode(String val) {
            provinceCode = val;
            return this;
        }

        public Builder withCountryCode(String val) {
            countryCode = val;
            return this;
        }

        public Builder withUpdatedAt(String val) {
            updatedAt = val;
            return this;
        }

        public Builder withPhone(String val) {
            phone = val;
            return this;
        }

        public Builder withCustomerEmail(String val) {
            customerEmail = val;
            return this;
        }

        public Builder withDomain(String val) {
            domain = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withCurrency(String val) {
            currency = val;
            return this;
        }

        public Builder withId(String val) {
            id = val;
            return this;
        }

        public Builder withShopOwner(String val) {
            shopOwner = val;
            return this;
        }

        public Builder withEmail(String val) {
            email = val;
            return this;
        }

        public Builder withAccount(String val) {
            account = val;
            return this;
        }

        public ShoplazzaShop build() {
            return new ShoplazzaShop(this);
        }
    }
}
