package edu.nju.dbhomework.crawler;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by sbin on 2016/11/8.
 */
public class TrainSchedule implements Comparable<TrainSchedule>{

    String station;
    Calendar time;

    public TrainSchedule(String station,String timeString){
        this.station = station;

        int hour = Integer.parseInt
                (timeString.split(":")[0]);

        int minute = Integer.parseInt
                (timeString.split(":")[1]);

        time = Calendar.getInstance();
        time.set(Calendar.HOUR_OF_DAY,hour);
        time.set(Calendar.MINUTE,minute);

    }

    @Override
    public String toString() {
        return "TrainSchedule{" +
                "station='" + station + '\'' +
                '}';
    }

    @Override
    public int compareTo(TrainSchedule o) {
        return time.compareTo(o.time);
    }
}
