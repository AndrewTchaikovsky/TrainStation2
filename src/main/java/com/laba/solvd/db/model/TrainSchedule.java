package com.laba.solvd.db.model;

import java.util.Date;

public class TrainSchedule {
    private Integer id;
    private Date date;

    public TrainSchedule() {
    }

    public TrainSchedule(Date date) {
        this.date = date;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainSchedule)) return false;

        TrainSchedule that = (TrainSchedule) o;

        if (getId() != that.getId()) return false;
        return getDate().equals(that.getDate());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getDate().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TrainSchedule{" +
                "id=" + id +
                ", date='" + date + '\'' +
                '}';
    }
}
