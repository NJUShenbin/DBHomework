package edu.nju.dbhomework.dataInit.init;

import edu.nju.dbhomework.dataInit.entity.RouteEntity;
import edu.nju.dbhomework.dataInit.entity.RouteStationEntity;
import edu.nju.dbhomework.dataInit.entity.StationEntity;
import edu.nju.dbhomework.dataInit.repository.RouteRepository;
import edu.nju.dbhomework.dataInit.repository.RouteStationRepository;
import edu.nju.dbhomework.dataInit.repository.StationRepository;
import edu.nju.dbhomework.dataInit.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sbin on 2016/11/10.
 */
public class TrainDataInitializer {

    @Autowired
    RouteReader routeReader;

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private StationRepository stationRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private RouteStationRepository routeStationRepository;

    @PersistenceContext
    EntityManager manager;

    @PostConstruct
    public void init(){

        //初始化车站
//        initStations();
        initRoutes();

    }

    private void initStations(){
        stationRepository.save(routeReader.getStations()
                .stream()
                .map(s->new StationEntity(s))
                .collect(Collectors.toList())
        );
    }

    private void initRoutes(){
//        System.out.println(routeReader.getRoutes());
//        routeRepository.save(routeReader.getRoutes().get(0));
//        List<RouteEntity> entities = routeReader.getRoutes();
//        routeRepository.save(entities);
//        System.out.println(routeStationRepository.findAll());
//        RouteStationEntity routeStation = entities.get(0).getRouteStations().iterator().next();
//        routeStationRepository.save(routeStation);
//        routeStationRepository.findAll();
//        RouteStationEntity routeStationEntity = new RouteStationEntity();
//        routeStationEntity.setOrder(1);
//        routeStationEntity.setId(100);
//        routeStationRepository.save(routeStationEntity);
        StationEntity stationEntity = new StationEntity();
        stationEntity.setName("aaa");
        stationRepository.save(stationEntity);
        RouteStationEntity routeStation = routeStationRepository.findAll().iterator().next();
        routeStation.setOrder(15);
        routeStation.setId(100);
        routeStationRepository.save(routeStation);
//        routeStationRepository.save(new RouteStationEntity());
//        routeRepository.save(new RouteEntity());
    }

}
