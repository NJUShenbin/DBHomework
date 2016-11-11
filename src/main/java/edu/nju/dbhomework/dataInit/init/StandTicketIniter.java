package edu.nju.dbhomework.dataInit.init;

import edu.nju.dbhomework.dataInit.entity.CoachEntity;
import edu.nju.dbhomework.dataInit.entity.CoachType;
import edu.nju.dbhomework.dataInit.entity.SeatEntity;
import edu.nju.dbhomework.dataInit.entity.TrainEntity;
import edu.nju.dbhomework.dataInit.repository.RouteStationRepository;
import edu.nju.dbhomework.dataInit.repository.ScheduleRepository;
import edu.nju.dbhomework.dataInit.repository.SeatRepository;
import edu.nju.dbhomework.dataInit.repository.TrainRepository;
import edu.nju.dbhomework.util.FileUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import javax.transaction.Transactional;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by sbin on 2016/11/11.
 */
public class StandTicketIniter {

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Autowired
    private RouteStationRepository routeStationRepository;

    @Autowired
    private TrainRepository trainRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private DBFileImporter importer;

    private Logger logger = Logger.getLogger(this.getClass());

    @Transactional
    public void initStandingTicket(){

        FileUtil.forceCreateFile("standingTicketData.txt");

        scheduleRepository.findAll().forEach(scheduleEntity -> {
            TrainEntity trainEntity = trainRepository.findOne(scheduleEntity.getTrainId());
            saveOneTrain(trainEntity,scheduleEntity.getId());
            logger.info("schedule id "+scheduleEntity.getId()
                    +" standing ticket init"
                    +" completed");
        });

        File standingFile = new File("standingTicketData.txt");
        importer.importFile(standingFile,"standingticketremain");

    }

    public void saveOneTrain(TrainEntity trainEntity, int scheduleId){

        File standingFile = new File("standingTicketData.txt");
        BufferedWriter writer = null;
        try {
            FileWriter fw = new FileWriter(standingFile, true);
            writer = new BufferedWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(CoachEntity coachEntity : trainEntity.getCoachesById()){
            saveOneCoach(coachEntity,scheduleId,writer);
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveOneCoach
            (CoachEntity coachEntity,int scheduleId,BufferedWriter writer){
        if(! coachEntity.getType().equals(CoachType.s)){
            return;
        }
        try {
            writer.write(scheduleId+"\t"
                    +coachEntity.getId()+"\t"
                    +coachEntity.getOrder()+"\t"
                    +(coachEntity.getColumn()*coachEntity.getRow()/10)
                    +"\n"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
