package com.laba.solvd.db.model;

public class TicketType {
    private Integer id;
    private String type;

    public TicketType() {
    }

    public TicketType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(o instanceof TicketType)) return false;

        TicketType that = (TicketType) o;

        if (getId() != that.getId()) return false;
        return getType().equals(that.getType());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getType().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TicketType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
