package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sbin on 2016/11/11.
 */
public class SeatEntityPK implements Serializable {
    private int scheduleId;
    private int coachOrder;
    private int row;

    @Column(name = "scheduleId")
    @Id
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Column(name = "coachOrder")
    @Id
    public int getCoachOrder() {
        return coachOrder;
    }

    public void setCoachOrder(int coachOrder) {
        this.coachOrder = coachOrder;
    }

    @Column(name = "row")
    @Id
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeatEntityPK that = (SeatEntityPK) o;

        if (scheduleId != that.scheduleId) return false;
        if (coachOrder != that.coachOrder) return false;
        if (row != that.row) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scheduleId;
        result = 31 * result + coachOrder;
        result = 31 * result + row;
        return result;
    }
}
