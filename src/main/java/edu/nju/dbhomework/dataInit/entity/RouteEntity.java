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
    private Collection<RoutestationEntity> routestations;

    @Id
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
    public Collection<RoutestationEntity> getRoutestations() {
        return routestations;
    }

    public void setRoutestations(Collection<RoutestationEntity> routestations) {
        this.routestations = routestations;
    }
}
