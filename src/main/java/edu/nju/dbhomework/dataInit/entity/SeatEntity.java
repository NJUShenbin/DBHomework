package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.*;

/**
 * Created by sbin on 2016/11/11.
 */
@Entity
@Table(name = "seat")
@IdClass(SeatEntityPK.class)
public class SeatEntity {
    private int scheduleId;
    private int coachOrder;
    private int row;
    private int occupation;
    private String column;

    @Id
    @Column(name = "scheduleId")
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Id
    @Column(name = "coachOrder")
    public int getCoachOrder() {
        return coachOrder;
    }

    public void setCoachOrder(int coachOrder) {
        this.coachOrder = coachOrder;
    }

    @Id
    @Column(name = "`row`")
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Id
    @Column(name = "`column`")
    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    @Basic
    @Column(name = "occupation")
    public int getOccupation() {
        return occupation;
    }

    public void setOccupation(int occupation) {
        this.occupation = occupation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SeatEntity that = (SeatEntity) o;

        if (scheduleId != that.scheduleId) return false;
        if (coachOrder != that.coachOrder) return false;
        if (row != that.row) return false;
        if (occupation != that.occupation) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scheduleId;
        result = 31 * result + coachOrder;
        result = 31 * result + row;
        result = 31 * result + occupation;
        return result;
    }
}
