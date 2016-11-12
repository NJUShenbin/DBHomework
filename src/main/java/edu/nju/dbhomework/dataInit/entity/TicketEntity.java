package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by sbin on 2016/11/11.
 */
@Entity
@Table(name = "ticket")
public class TicketEntity {
    private String userId;
    private int id;
    private Date arriveDate;
    private Date departDate;
    private String seat;
    private String startStation;
    private String endStation;
    private String trainNum;
    private String seatType;

    @Basic
    @Column(name = "userId")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "seat")
    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
    }

    @Basic
    @Column(name = "startStation")
    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    @Basic
    @Column(name = "endStation")
    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    @Basic
    @Column(name = "trainNum")
    public String getTrainNum() {
        return trainNum;
    }

    public void setTrainNum(String trainNum) {
        this.trainNum = trainNum;
    }

    @Basic
    @Column(name = "seatType")
    public String getSeatType() {
        return seatType;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    @Column
    public Date getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(Date arriveDate) {
        this.arriveDate = arriveDate;
    }

    @Column
    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketEntity that = (TicketEntity) o;

        if (id != that.id) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (seat != null ? !seat.equals(that.seat) : that.seat != null) return false;
        if (startStation != null ? !startStation.equals(that.startStation) : that.startStation != null) return false;
        if (endStation != null ? !endStation.equals(that.endStation) : that.endStation != null) return false;
        if (trainNum != null ? !trainNum.equals(that.trainNum) : that.trainNum != null) return false;
        if (seatType != null ? !seatType.equals(that.seatType) : that.seatType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + id;
        result = 31 * result + (seat != null ? seat.hashCode() : 0);
        result = 31 * result + (startStation != null ? startStation.hashCode() : 0);
        result = 31 * result + (endStation != null ? endStation.hashCode() : 0);
        result = 31 * result + (trainNum != null ? trainNum.hashCode() : 0);
        result = 31 * result + (seatType != null ? seatType.hashCode() : 0);
        return result;
    }
}
