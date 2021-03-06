package edu.nju.dbhomework.dataInit;

import edu.nju.dbhomework.dataInit.crawler.TrainScheduleCrawler;
import edu.nju.dbhomework.dataInit.init.*;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sbin on 2016/11/10.
 */
@Configuration
@ConditionalOnExpression("${dbhomework.initByCode}")
public class DataInitConfig {

    @Bean
    TrainDataInitializer initializer(){
        return new TrainDataInitializer();
    }

    @Bean
    RouteReader routeReader(){
        return new RouteReader();
    }

    @Bean
    TrainScheduleCrawler trainScheduleCrawler(){
        return new TrainScheduleCrawler();
    }

    @Bean
    CoachFactory coachFactory(){
        return new CoachFactory();
    }

    @Bean
    SeatIniter seatIniter() {
        return new SeatIniter();
    }

    @Bean
    StandTicketIniter standTicketIniter(){
        return new StandTicketIniter();
    }

    @Bean
    DBFileImporter dbFileImporter(){
        return new DBFileImporter();
    }
}
