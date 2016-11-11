package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.*;
import java.sql.Time;

/**
 * Created by sbin on 2016/11/11.
 */
@Entity
@Table(name = "routestation")
public class RouteStationEntity {
    private int order;
    private int day;
    private String station;
    private int id;
    RouteEntity routeByRouteId;

    @ManyToOne
    @JoinColumn(name = "routeId", referencedColumnName = "id")
    public RouteEntity getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(RouteEntity routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }

    private Time departTime;


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
    @Column(name = "station")
    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Column
    public Time getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Time departTime) {
        this.departTime = departTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteStationEntity that = (RouteStationEntity) o;

        if (order != that.order) return false;
        if (day != that.day) return false;
        if (station != null ? !station.equals(that.station) : that.station != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = order;
        result = 31 * result + day;
        result = 31 * result + (station != null ? station.hashCode() : 0);
        return result;
    }
}
