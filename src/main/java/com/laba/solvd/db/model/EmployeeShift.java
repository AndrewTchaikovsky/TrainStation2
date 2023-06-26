package com.laba.solvd.db.model;

import com.laba.solvd.db.parsers.DateAdapter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;


@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeShift {
    @XmlAttribute
    private Integer id;
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date startDate;
    @XmlElement
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date endDate;

    public EmployeeShift() {
    }

    public EmployeeShift(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeShift)) return false;

        EmployeeShift that = (EmployeeShift) o;

        if (getId() != that.getId()) return false;
        if (!getStartDate().equals(that.getStartDate())) return false;
        return getEndDate().equals(that.getEndDate());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getStartDate().hashCode();
        result = 31 * result + getEndDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "EmployeeShift{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
