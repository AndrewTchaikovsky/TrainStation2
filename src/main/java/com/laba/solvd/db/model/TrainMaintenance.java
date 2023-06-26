package com.laba.solvd.db.model;

import com.laba.solvd.db.parsers.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;


@XmlAccessorType(XmlAccessType.FIELD)
public class TrainMaintenance {
    @XmlAttribute
    private Integer id;
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date date;
    @XmlElement
    private String type;

    public TrainMaintenance() {
    }

    public TrainMaintenance(Date date, String type) {
        this.date = date;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainMaintenance)) return false;

        TrainMaintenance that = (TrainMaintenance) o;

        if (getId() != that.getId()) return false;
        if (!getDate().equals(that.getDate())) return false;
        return getType().equals(that.getType());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getDate().hashCode();
        result = 31 * result + getType().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TrainMaintenance{" +
                "id=" + id +
                ", date=" + date +
                ", type='" + type + '\'' +
                '}';
    }
}
