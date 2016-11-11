package edu.nju.dbhomework.dataInit.crawler;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sbin on 2016/11/8.
 */
@Component
public class TrainScheduleCrawler {

    RestTemplate restTemplate;

    public TrainScheduleCrawler(){
        restTemplate = new RestTemplate();
    }

    public List<TrainSchedule> getSchedule(String trainNum){
        List<TrainSchedule> list = new ArrayList<>();
        ApiTrainEntity entity =
                restTemplate.getForObject(getUrl(trainNum),ApiTrainEntity.class);

        return entity.getTrainScheduleBody()
                .stream()
                .map(e -> e.toTrainSchedule())
                .sorted()
                .collect(Collectors.toList());
    }

    private String getUrl(String trainNum){
        return "http://train.qunar.com/qunar/checiInfo.jsp?" +
                "method_name=buy" +
                "&ex_track=bd_aladin_train_num_title" +
                "&q=" +
                trainNum +
                "&date=20161109" +
                "&format=json" +
                "&cityname=123456" +
                "&ver=1478572009295";
    }

}
