package edu.nju.dbhomework.dataInit.repository;

import edu.nju.dbhomework.dataInit.entity.SeatEntity;
import edu.nju.dbhomework.dataInit.entity.SeatEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sbin on 2016/11/11.
 */
public interface SeatRepository extends CrudRepository<SeatEntity,SeatEntityPK> {
    void flush();
}
