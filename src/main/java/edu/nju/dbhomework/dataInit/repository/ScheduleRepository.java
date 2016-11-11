package edu.nju.dbhomework.dataInit.repository;

import edu.nju.dbhomework.dataInit.entity.ScheduleEntity;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by sbin on 2016/11/11.
 */
public interface ScheduleRepository extends CrudRepository<ScheduleEntity,Integer> {
}
