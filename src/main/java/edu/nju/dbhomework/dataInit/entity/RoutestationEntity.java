package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by sbin on 2016/11/11.
 */
@Entity
@Table(name = "routestation")
public class RouteStationEntity {
    private int id;
    private int order;
    private int day;
    private Time departTime;
    private String station;

    private RouteEntity routeByRouteId;

    @ManyToOne
    @JoinColumn(name = "routeId", referencedColumnName = "id")
    public RouteEntity getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(RouteEntity routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "`order`")
    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    @Basic
    @Column(name = "day")
    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Basic
    @Column(name = "departTime")
    public Time getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Time departTime) {
        this.departTime = departTime;
    }

    @Basic
    @Column(name = "station")
    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteStationEntity that = (RouteStationEntity) o;

        if (id != that.id) return false;
        if (order != that.order) return false;
        if (day != that.day) return false;
        if (departTime != null ? !departTime.equals(that.departTime) : that.departTime != null) return false;
        if (station != null ? !station.equals(that.station) : that.station != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + order;
        result = 31 * result + day;
        result = 31 * result + (departTime != null ? departTime.hashCode() : 0);
        result = 31 * result + (station != null ? station.hashCode() : 0);
        return result;
    }
}
