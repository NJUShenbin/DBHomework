package edu.nju.dbhomework.dataInit.repository;

import edu.nju.dbhomework.dataInit.entity.RouteEntity;
import edu.nju.dbhomework.dataInit.entity.RouteStationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import javax.persistence.Temporal;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by sbin on 2016/11/10.
 */
public interface RouteStationRepository extends
        CrudRepository<RouteStationEntity,Integer> {

    @Query("select e from RouteStationEntity e where e.routeByRouteId = ?1 and e.order=?2")
    RouteStationEntity findFirstStation(RouteEntity routeEntity,int order);

}
