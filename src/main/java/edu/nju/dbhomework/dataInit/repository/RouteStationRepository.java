package edu.nju.dbhomework.dataInit.repository;

import edu.nju.dbhomework.dataInit.entity.RouteStationEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.Temporal;
import javax.transaction.Transactional;

/**
 * Created by sbin on 2016/11/10.
 */
public interface RouteStationRepository extends
        CrudRepository<RouteStationEntity,Integer>{



}
