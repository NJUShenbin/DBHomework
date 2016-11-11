package edu.nju.dbhomework.dataInit.init;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import edu.nju.dbhomework.dataInit.entity.CoachEntity;
import edu.nju.dbhomework.dataInit.entity.ScheduleEntity;
import edu.nju.dbhomework.dataInit.entity.SeatEntity;
import edu.nju.dbhomework.dataInit.entity.TrainEntity;
import edu.nju.dbhomework.dataInit.repository.RouteStationRepository;
import edu.nju.dbhomework.dataInit.repository.ScheduleRepository;
import edu.nju.dbhomework.dataInit.repository.SeatRepository;
import edu.nju.dbhomework.dataInit.repository.TrainRepository;
import edu.nju.dbhomework.util.FileUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.transaction.Transactional;
import java.io.*;
import java.util.List;

/**
 * Created by sbin on 2016/11/11.
 */

public class SeatIniter {

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

    Logger logger = Logger.getLogger(this.getClass());

    @Transactional
    public void initSeats(){

        File seatFile = FileUtil.forceCreateFile("seatData.txt");
        scheduleRepository.findAll().forEach(scheduleEntity -> {

            TrainEntity trainEntity = trainRepository.findOne(scheduleEntity.getTrainId());
            saveOneTrain(trainEntity,scheduleEntity.getId());
            logger.info("schedule id "+scheduleEntity.getId()
                    +" seats init"
                    +" completed");
        });

        importer.importFile(seatFile,"seat");

    }

    public void saveOneTrain(TrainEntity trainEntity, int scheduleId){
        for(CoachEntity coachEntity : trainEntity.getCoachesById()){
            saveOneCoach(coachEntity,scheduleId);
        }
    }

    public void saveOneCoach(CoachEntity coachEntity,int scheduleId){

        String[] columnCode = {"A","B","C","D","E","F"};

        File seatFile = new File("seatData.txt");
        BufferedWriter writer = null;
        try {
            FileWriter fw = new FileWriter(seatFile, true);
            writer = new BufferedWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int row=1; row<= coachEntity.getRow();row++){
            for(int column=0;column<coachEntity.getColumn();column++){
                SeatEntity seatEntity = new SeatEntity();
                seatEntity.setScheduleId(scheduleId);
                seatEntity.setCoachOrder(coachEntity.getOrder());
                seatEntity.setRow(row);
                seatEntity.setColumn(columnCode[column]);
                seatEntity.setOccupation(0);
                seatEntity.setCoachId(coachEntity.getId());

                writeOneSeat(writer,seatEntity);
//                seatRepository.save(seatEntity);
            }
        }

        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void writeOneSeat(BufferedWriter writer,SeatEntity entity){
        try {
            writer.append(entity.getScheduleId()+"\t"
                    +entity.getCoachId()+"\t"
                    +entity.getCoachOrder()+"\t"
                    +entity.getRow()+"\t"
                    +entity.getColumn()+"\t"
                    +entity.getOccupation()+"\n"
            );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
