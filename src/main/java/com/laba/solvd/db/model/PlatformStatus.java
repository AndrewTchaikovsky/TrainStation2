package com.laba.solvd.db.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class PlatformStatus {
    @JsonProperty("id")
    @XmlAttribute
    private Integer id;
    @JsonProperty("status")
    @XmlElement
    private String status;

    public PlatformStatus() {
    }

    public PlatformStatus(String status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlatformStatus)) return false;

        PlatformStatus that = (PlatformStatus) o;

        if (!getId().equals(that.getId())) return false;
        return getStatus().equals(that.getStatus());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getStatus().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "PlatformStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                '}';
    }
}
