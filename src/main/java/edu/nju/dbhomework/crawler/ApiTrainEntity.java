package edu.nju.dbhomework.crawler;

import java.util.List;
import java.util.Map;

/**
 * Created by sbin on 2016/11/8.
 */
public class ApiTrainEntity {

    List<ApiTrainEntityBody> trainScheduleBody;

    public List<ApiTrainEntityBody> getTrainScheduleBody() {
        return trainScheduleBody;
    }

    public void setTrainScheduleBody(List<ApiTrainEntityBody> trainScheduleBody) {
        this.trainScheduleBody = trainScheduleBody;
    }


}


