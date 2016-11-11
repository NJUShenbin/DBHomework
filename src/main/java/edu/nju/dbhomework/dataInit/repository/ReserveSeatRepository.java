package edu.nju.dbhomework.dataInit.repository;

import edu.nju.dbhomework.dataInit.entity.ReserveSeatEntity;
import edu.nju.dbhomework.dataInit.entity.ReserveseatEntityPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sbin on 2016/11/11.
 */
public interface ReserveSeatRepository extends CrudRepository<ReserveSeatEntity,ReserveseatEntityPK> {
}
