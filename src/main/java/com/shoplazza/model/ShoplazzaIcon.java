package com.shoplazza.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ShoplazzaIcon {
    private String path;
    private String src;
    private String alt;

    public ShoplazzaIcon() {
    }

    private ShoplazzaIcon(Builder builder) {
        setPath(builder.path);
        setSrc(builder.src);
        setAlt(builder.alt);
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public static final class Builder {
        private String path;
        private String src;
        private String alt;

        private Builder() {
        }

        public Builder withPath(String val) {
            path = val;
            return this;
        }

        public Builder withSrc(String val) {
            src = val;
            return this;
        }

        public Builder withAlt(String val) {
            alt = val;
            return this;
        }

        public ShoplazzaIcon build() {
            return new ShoplazzaIcon(this);
        }
    }
}