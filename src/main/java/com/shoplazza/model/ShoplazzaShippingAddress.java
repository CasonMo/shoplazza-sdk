package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaShippingAddress {
    private String zip;
    private String area;
    private String country;
    private String city;
    private String address2;
    private String address1;
    private String latitude;
    @XmlElement(name = "last_name")
    private String lastname;
    @XmlElement(name = "province_code")
    private String provinceCode;
    @XmlElement(name = "country_code")
    private String countryCode;
    @XmlElement(name = "extra_info")
    private Object extraInfo;
    private String province;
    private String phone;
    private String name;
    private String company;
    @XmlElement(name = "first_name")
    private String firstName;
    private String email;
    private String longitude;
    @XmlElement(name = "phone_area_code")
    private String phoneAreaCode;

    public ShoplazzaShippingAddress() {
    }

    private ShoplazzaShippingAddress(Builder builder) {
        setZip(builder.zip);
        setArea(builder.area);
        setCountry(builder.country);
        setCity(builder.city);
        setAddress2(builder.address2);
        setAddress1(builder.address1);
        setLatitude(builder.latitude);
        setLastname(builder.lastname);
        setProvinceCode(builder.provinceCode);
        setCountryCode(builder.countryCode);
        setExtraInfo(builder.extraInfo);
        setProvince(builder.province);
        setPhone(builder.phone);
        setName(builder.name);
        setCompany(builder.company);
        setFirstName(builder.firstName);
        setEmail(builder.email);
        setLongitude(builder.longitude);
        setPhoneAreaCode(builder.phoneAreaCode);
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

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public Object getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(Object extraInfo) {
        this.extraInfo = extraInfo;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPhoneAreaCode() {
        return phoneAreaCode;
    }

    public void setPhoneAreaCode(String phoneAreaCode) {
        this.phoneAreaCode = phoneAreaCode;
    }

    public static final class Builder {
        private String zip;
        private String area;
        private String country;
        private String city;
        private String address2;
        private String address1;
        private String latitude;
        private String lastname;
        private String provinceCode;
        private String countryCode;
        private Object extraInfo;
        private String province;
        private String phone;
        private String name;
        private String company;
        private String firstName;
        private String email;
        private String longitude;
        private String phoneAreaCode;

        private Builder() {
        }

        public Builder withZip(String val) {
            zip = val;
            return this;
        }

        public Builder withArea(String val) {
            area = val;
            return this;
        }

        public Builder withCountry(String val) {
            country = val;
            return this;
        }

        public Builder withCity(String val) {
            city = val;
            return this;
        }

        public Builder withAddress2(String val) {
            address2 = val;
            return this;
        }

        public Builder withAddress1(String val) {
            address1 = val;
            return this;
        }

        public Builder withLatitude(String val) {
            latitude = val;
            return this;
        }

        public Builder withLastname(String val) {
            lastname = val;
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

        public Builder withExtraInfo(Object val) {
            extraInfo = val;
            return this;
        }

        public Builder withProvince(String val) {
            province = val;
            return this;
        }

        public Builder withPhone(String val) {
            phone = val;
            return this;
        }

        public Builder withName(String val) {
            name = val;
            return this;
        }

        public Builder withCompany(String val) {
            company = val;
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

        public Builder withLongitude(String val) {
            longitude = val;
            return this;
        }

        public Builder withPhoneAreaCode(String val) {
            phoneAreaCode = val;
            return this;
        }

        public ShoplazzaShippingAddress build() {
            return new ShoplazzaShippingAddress(this);
        }
    }
}