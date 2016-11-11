package edu.nju.dbhomework.trainBusinese;

import edu.nju.dbhomework.dataInit.entity.RouteStationEntity;
import edu.nju.dbhomework.dataInit.entity.TicketEntity;
import edu.nju.dbhomework.dataInit.repository.RouteStationRepository;
import edu.nju.dbhomework.dataInit.repository.TicketRepository;
import edu.nju.dbhomework.dataInit.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by sbin on 2016/11/10.
 */
@Component
public class TestBean {

    @Autowired
    RouteStationRepository repository;


    @Autowired
    TicketRepository ticketRepository;




    @PostConstruct
    public void init(){
//        RouteStationEntity entity = new RouteStationEntity();
//        entity.setStation("南京南");
//        entity.setOrder(11);
//        repository.save(entity);
//        repository.findAll();
//        ticketRepository.save(new TicketEntity());

    }

}
