package edu.nju.dbhomework.dataInit.init;

import edu.nju.dbhomework.dataInit.entity.*;
import edu.nju.dbhomework.dataInit.repository.RouteRepository;
import edu.nju.dbhomework.dataInit.repository.RouteStationRepository;
import edu.nju.dbhomework.dataInit.repository.StationRepository;
import edu.nju.dbhomework.dataInit.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sbin on 2016/11/10.
 */
public class TrainDataInitializer {

    @Autowired
    RouteReader routeReader;

    @Autowired
    CoachFactory coachFactory;

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
//        initRoutes();
//        initTrains();

    }

    private void initTrains() {
        List<String> nameList = Arrays.asList("富强","民主","文明","和谐","公正","法制","诚信","友爱");


        for (int i=0;i<100;i++){
            TrainEntity train = new TrainEntity();
            int num = i%nameList.size();
            train.setName(nameList.get(num)+(i/nameList.size()));

            coachFactory.createTrainCoach(train);
            trainRepository.save(train);
        }

    }

    private void initStations(){
        stationRepository.save(routeReader.getStations()
                .stream()
                .map(s->new StationEntity(s))
                .collect(Collectors.toList())
        );
    }

    private void initRoutes(){

        List<RouteEntity> entities = routeReader.getRoutes();
        routeRepository.save(entities);
        entities.forEach(route -> routeStationRepository.save(route.getRouteStations()));

    }

}
