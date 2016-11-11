package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by sbin on 2016/11/10.
 */
@Entity
@Table(name = "route")
public class RouteEntity {
    private int id;
    private Collection<RouteStationEntity> routeStations;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RouteEntity that = (RouteEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToMany(mappedBy = "routeByRouteId")
    public Collection<RouteStationEntity> getRouteStations() {
        return routeStations;
    }

    public void setRouteStations(Collection<RouteStationEntity> routestations) {
        this.routeStations = routestations;
    }

}
