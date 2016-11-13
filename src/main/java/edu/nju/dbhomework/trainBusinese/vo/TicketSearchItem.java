package edu.nju.dbhomework.trainBusinese.vo;

import java.sql.Time;

/**
 * Created by sbin on 2016/11/12.
 */
public class TicketSearchItem {

    String trainNum;
    Time startTime;
    Time endTime;
    int businessSeat;
    int firstClassSeat;
    int secondClassSeat;

    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public int getBusinessSeat() {
        return businessSeat;
    }

    public void setBusinessSeat(int businessSeat) {
        this.businessSeat = businessSeat;
    }

    public int getFirstClassSeat() {
        return firstClassSeat;
    }

    public void setFirstClassSeat(int firstClassSeat) {
        this.firstClassSeat = firstClassSeat;
    }

    public int getSecondClassSeat() {
        return secondClassSeat;
    }

    public void setSecondClassSeat(int secondClassSeat) {
        this.secondClassSeat = secondClassSeat;
    }

    @Override
    public String toString() {
        return "TicketSearchItem{" +
                "trainNum='" + trainNum + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", businessSeat=" + businessSeat +
                ", firstClassSeat=" + firstClassSeat +
                ", secondClassSeat=" + secondClassSeat +
                '}';
    }
}
