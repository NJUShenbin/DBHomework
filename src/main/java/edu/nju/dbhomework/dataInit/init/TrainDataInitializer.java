package edu.nju.dbhomework.dataInit.init;

import com.google.common.collect.Lists;
import edu.nju.dbhomework.dataInit.entity.*;
import edu.nju.dbhomework.dataInit.entity.ReserveSeatEntity;
import edu.nju.dbhomework.dataInit.repository.*;
import edu.nju.dbhomework.util.Increaser;
import edu.nju.dbhomework.util.TimeUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.sql.Date;
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

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private ReserveSeatRepository reserveSeatRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private SeatIniter seatIniter;

    @Autowired
    private StandTicketIniter standTicketIniter;

    @PersistenceContext
    EntityManager manager;

    @PostConstruct
    public void init(){

        //初始化车站
//        initStations();
//        initRoutes();
//        initTrains();
//        initSchedule();
//        initReserve();
//        initSeats();
        initStandingTicket();

    }

    private void initSeats() {
        seatIniter.initSeats();
    }

    private void initStandingTicket(){
        standTicketIniter.initStandingTicket();
    }

    private void initReserve() {

        Map<Integer,String> firstStationMap = new HashMap<>();

        routeRepository.findAll().forEach(routeEntity -> {
            String station = routeStationRepository.findFirstStation(routeEntity,0).getStation();
            firstStationMap.put(routeEntity.getId(),station);
        });

        scheduleRepository.findAll().forEach(scheduleEntity -> {
            ReserveSeatEntity entity = new ReserveSeatEntity();
            entity.setOrder(0);
            entity.setReserve(100);
            entity.setScheduleId(scheduleEntity.getId());
            entity.setStation(firstStationMap.get(scheduleEntity.getRouteId()));
            reserveSeatRepository.save(entity);
        });


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

    private void initSchedule(){

        Map<String,Integer> trainNumMap = new HashMap<>();
        Increaser increaser = new Increaser(0);
        routeRepository.findAll().forEach(routeEntity -> {
            trainNumMap.put("G"+increaser.increase(),routeEntity.getId());
        });

        List<Integer> trainIds = Lists.newArrayList(trainRepository.findAll())
                .stream()
                .map(TrainEntity::getId)
                .collect(Collectors.toList());

        Increaser trainIdIncreaser = new Increaser(0);

        for(int i=0;i<7;i++){
            Date departDate = TimeUtil.afterDays(new java.util.Date(),i);

            List<ScheduleEntity> scheduleEntities = new ArrayList<>();
            trainNumMap.forEach((trainNum,routeId)->{
                ScheduleEntity scheduleEntity = new ScheduleEntity();

                scheduleEntity.setTrainNum(trainNum);
                scheduleEntity.setRouteId(routeId);
                scheduleEntity.setDepartDate(departDate);
                scheduleEntity.setTrainId(trainIds.get(increaser.increase()%trainIds.size()));

                scheduleEntities.add(scheduleEntity);

            });

            scheduleRepository.save(scheduleEntities);
        }
    }

}
