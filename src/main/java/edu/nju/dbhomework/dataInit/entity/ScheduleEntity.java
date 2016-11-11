package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by sbin on 2016/11/11.
 */
@Entity
@Table(name = "schedule")
public class ScheduleEntity {
    private int id;
    private int trainId;
    private int routeId;
    private String trainNum;
    private Date departDate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "trainId")
    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    @Basic
    @Column(name = "routeId")
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Basic
    @Column(name = "trainNum")
    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    @Basic
    @Column(name = "departDate")
    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ScheduleEntity that = (ScheduleEntity) o;

        if (id != that.id) return false;
        if (trainId != that.trainId) return false;
        if (routeId != that.routeId) return false;
        if (trainNum != null ? !trainNum.equals(that.trainNum) : that.trainNum != null) return false;
        if (departDate != null ? !departDate.equals(that.departDate) : that.departDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + trainId;
        result = 31 * result + routeId;
        result = 31 * result + (trainNum != null ? trainNum.hashCode() : 0);
        result = 31 * result + (departDate != null ? departDate.hashCode() : 0);
        return result;
    }
}
