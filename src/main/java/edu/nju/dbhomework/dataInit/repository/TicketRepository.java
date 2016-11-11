package edu.nju.dbhomework.dataInit.repository;

import edu.nju.dbhomework.dataInit.entity.TicketEntity;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by sbin on 2016/11/11.
 */
public interface TicketRepository extends CrudRepository<TicketEntity,Integer>{
}
