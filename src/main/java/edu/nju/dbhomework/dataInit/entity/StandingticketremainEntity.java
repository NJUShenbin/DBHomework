package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.*;

/**
 * Created by sbin on 2016/11/11.
 */
@Entity
@Table(name = "standingticketremain", schema = "dbh", catalog = "")
@IdClass(StandingticketremainEntityPK.class)
public class StandingticketremainEntity {
    private int scheduleId;
    private int coachId;
    private String remain;
    private int coachOrder;

    @Id
    @Column(name = "scheduleId")
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Id
    @Column(name = "coachId")
    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    @Id
    @Column(name = "remain")
    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    @Column
    public int getCoachOrder() {
        return coachOrder;
    }

    public void setCoachOrder(int coachOrder) {
        this.coachOrder = coachOrder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StandingticketremainEntity that = (StandingticketremainEntity) o;

        if (scheduleId != that.scheduleId) return false;
        if (coachId != that.coachId) return false;
        if (remain != null ? !remain.equals(that.remain) : that.remain != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scheduleId;
        result = 31 * result + coachId;
        result = 31 * result + (remain != null ? remain.hashCode() : 0);
        return result;
    }
}
