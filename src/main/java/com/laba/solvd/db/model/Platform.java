package com.laba.solvd.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Platform {
    @JsonProperty("id")
    @XmlAttribute
    private Integer id;
    @JsonProperty("number")
    @XmlElement
    private int number;
    @JsonProperty("platformStatus")
    @XmlElement
    private PlatformStatus platformStatus;

    public Platform() {
    }

    public Platform(int number) {
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public PlatformStatus getPlatformStatus() {
        return platformStatus;
    }

    public void setPlatformStatus(PlatformStatus platformStatus) {
        this.platformStatus = platformStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Platform)) return false;

        Platform platform = (Platform) o;

        if (getNumber() != platform.getNumber()) return false;
        if (!getId().equals(platform.getId())) return false;
        return getPlatformStatus().equals(platform.getPlatformStatus());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getNumber();
        result = 31 * result + getPlatformStatus().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Platform{" +
                "id=" + id +
                ", number=" + number +
                ", platformStatus=" + platformStatus +
                '}';
    }
}
