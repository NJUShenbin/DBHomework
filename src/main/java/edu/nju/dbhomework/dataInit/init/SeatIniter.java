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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import javax.transaction.Transactional;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

    @Transactional
    public void initSeats(){

        scheduleRepository.findAll().forEach(scheduleEntity -> {

            TrainEntity trainEntity = trainRepository.findOne(scheduleEntity.getTrainId());
            saveOneTrain(trainEntity,scheduleEntity.getId());
            System.out.println(scheduleEntity.getId() +" completed");
        });

//        ScheduleEntity scheduleEntity = scheduleRepository.findOne(2);
//        TrainEntity trainEntity = trainRepository.findOne(scheduleEntity.getTrainId());
//        saveOneTrain(trainEntity,scheduleEntity.getId());

    }

    public void saveOneTrain(TrainEntity trainEntity, int scheduleId){
        for(CoachEntity coachEntity : trainEntity.getCoachesById()){
            saveOneCoach(coachEntity,scheduleId);
        }
    }

    public void saveOneCoach(CoachEntity coachEntity,int scheduleId){

        String[] columnCode = {"A","B","C","D","E","F"};

        Resource resource = new FileSystemResource("seatData.txt");
        BufferedWriter writer = null;
        try {
            writer =
                    Files.newWriter(resource.getFile(), Charsets.UTF_8);
            writer.
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
