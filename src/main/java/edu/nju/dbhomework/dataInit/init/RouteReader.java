package edu.nju.dbhomework.dataInit.init;

import com.google.common.io.CharStreams;
import edu.nju.dbhomework.dataInit.crawler.TrainSchedule;
import edu.nju.dbhomework.dataInit.crawler.TrainScheduleCrawler;
import edu.nju.dbhomework.dataInit.entity.RouteEntity;
import edu.nju.dbhomework.dataInit.entity.RouteStationEntity;
import edu.nju.dbhomework.util.Increaser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by sbin on 2016/11/10.
 */
public class RouteReader {

    @Autowired
    TrainScheduleCrawler crawler;

    private List<String> lines = null;
    private List<String> trainNumList = null;

    public RouteReader(){

        ClassPathResource resource = new ClassPathResource("routes.txt");
        try {
            lines = CharStreams.readLines
                    (new InputStreamReader(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        trainNumList = lines.stream()
                .map(l -> l.split(" ")[0])
                .collect(Collectors.toList());

    }

    public Set<String> getStations(){
        Set<String> stationSet = new HashSet<>();
        lines.forEach(line->{
            stationSet.addAll(Arrays.asList(
                    line.split(" ")[1].split("-")));
        });

        return stationSet;
    }

    public List<RouteEntity> getRoutes(){

        return trainNumList.stream()
                .map(num -> getOneEntity(num))
                .filter(e -> e != null)
                .collect(Collectors.toList());

    }

    private RouteEntity getOneEntity(String trainNum){

        List<TrainSchedule> schedules = crawler.getSchedule(trainNum);

        if(schedules.isEmpty()){
            return null;
        }

        RouteEntity route = new RouteEntity();
        Increaser increaser = new Increaser(0);


        route.setRouteStations(schedules
                .stream()
                .map(s -> {
                    RouteStationEntity station = new RouteStationEntity();
                    station.setStation(s.getStation());
                    station.setDepartTime(s.getTime());
                    station.setDay(s.getDay());
                    station.setRouteByRouteId(route);
                    station.setOrder(increaser.increase());
                    return station;
                })
                .collect(Collectors.toList())
        );

        return route;
    }



}
