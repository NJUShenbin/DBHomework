package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sbin on 2016/11/10.
 */
@Entity
@Table(name = "routestation")
@Embeddable
public class RoutestationEntity implements Serializable{
    private int routeId;
    private int order;
    private int day;
    private RouteEntity routeByRouteId;

    @Id
    @Column(name = "routeId")
    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    @Id
    @Column(name = "order")
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoutestationEntity that = (RoutestationEntity) o;

        if (routeId != that.routeId) return false;
        if (order != that.order) return false;
        if (day != that.day) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = routeId;
        result = 31 * result + order;
        result = 31 * result + day;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "routeId", referencedColumnName = "id", nullable = false)
    public RouteEntity getRouteByRouteId() {
        return routeByRouteId;
    }

    public void setRouteByRouteId(RouteEntity routeByRouteId) {
        this.routeByRouteId = routeByRouteId;
    }
}
