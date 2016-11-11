package edu.nju.dbhomework.dataInit.crawler;

import java.sql.Time;
import java.util.Calendar;

/**
 * Created by sbin on 2016/11/8.
 */
public class TrainSchedule implements Comparable<TrainSchedule>{

    String station;
    Time time;
    int day;

    public TrainSchedule(String station,String timeString,int day){
        this.station = station;

        int hour = Integer.parseInt
                (timeString.split(":")[0]);

        int minute = Integer.parseInt
                (timeString.split(":")[1]);

        time = new Time(hour,minute,0);

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

    public String getStation() {
        return station;
    }

    public Time getTime() {
        return time;
    }

    public int getDay() {
        return day;
    }
}
