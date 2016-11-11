package edu.nju.dbhomework.dataInit.init;

import edu.nju.dbhomework.dataInit.entity.CoachEntity;
import edu.nju.dbhomework.dataInit.entity.CoachType;
import edu.nju.dbhomework.dataInit.entity.TrainEntity;

/**
 * Created by sbin on 2016/11/11.
 */
public class CoachFactory {

    public CoachEntity createBusinessCoach(int order){
        return new CoachEntity(CoachType.b,8,3,order);
    }

    public CoachEntity createFirstCoach(int order){
        return new CoachEntity(CoachType.f,16,4,order);
    }

    public CoachEntity createSecondCoach(int order){
        return new CoachEntity(CoachType.s,16,5,order);
    }

    public CoachEntity createTrainCoach(TrainEntity trainEntity){
        for (int i=0;i<8;i++){

            if(i<1){
                trainEntity.getCoachesById().add(createBusinessCoach(i).setTrainByTrainId(trainEntity));
                continue;
            }

            if(i<2){
                trainEntity.getCoachesById().add(createFirstCoach(i).setTrainByTrainId(trainEntity));
                continue;
            }

            trainEntity.getCoachesById().add(createSecondCoach(i).setTrainByTrainId(trainEntity));

        }
        return null;
    }

}
