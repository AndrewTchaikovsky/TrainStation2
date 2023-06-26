package com.laba.solvd.db.model;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "trainstation")
@XmlAccessorType(XmlAccessType.FIELD)
public class TrainStation {
    @XmlAttribute
    private Integer id;
    @XmlElement
    private String name;
    @XmlElement
    private String location;
    @XmlElementWrapper(name = "employees")
    @XmlElement(name = "employee")
    private List<Employee> employees;
    @XmlElementWrapper(name = "platforms")
    @XmlElement(name = "platform")
    private List<Platform> platforms;
    private List<TrainSchedule> trainSchedules;

    public TrainStation() {
    }

    public TrainStation(String name, String location) {
        this.name = name;
        this.location = location;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Platform> getPlatforms() {
        return platforms;
    }

    public void setPlatforms(List<Platform> platforms) {
        this.platforms = platforms;
    }

    public List<TrainSchedule> getTrainSchedules() {
        return trainSchedules;
    }

    public void setTrainSchedules(List<TrainSchedule> trainSchedules) {
        this.trainSchedules = trainSchedules;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrainStation)) return false;

        TrainStation that = (TrainStation) o;

        if (getId() != that.getId()) return false;
        if (!getName().equals(that.getName())) return false;
        if (!getLocation().equals(that.getLocation())) return false;
        if (getEmployees() != null ? !getEmployees().equals(that.getEmployees()) : that.getEmployees() != null)
            return false;
        if (getPlatforms() != null ? !getPlatforms().equals(that.getPlatforms()) : that.getPlatforms() != null)
            return false;
        return getTrainSchedules() != null ? getTrainSchedules().equals(that.getTrainSchedules()) : that.getTrainSchedules() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getLocation().hashCode();
        result = 31 * result + (getEmployees() != null ? getEmployees().hashCode() : 0);
        result = 31 * result + (getPlatforms() != null ? getPlatforms().hashCode() : 0);
        result = 31 * result + (getTrainSchedules() != null ? getTrainSchedules().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TrainStation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", employees=" + employees +
                ", platforms=" + platforms +
                ", trainSchedules=" + trainSchedules +
                '}';
    }

    public void setEmployee(TrainStation trainStation, Employee platform) {
    }
}
