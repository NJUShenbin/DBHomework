package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sbin on 2016/11/11.
 */
public class StandingticketremainEntityPK implements Serializable {
    private int scheduleId;
    private int coachId;
    private String remain;

    @Column(name = "scheduleId")
    @Id
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Column(name = "coachId")
    @Id
    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    @Column(name = "remain")
    @Id
    public String getRemain() {
        return remain;
    }

    public void setRemain(String remain) {
        this.remain = remain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StandingticketremainEntityPK that = (StandingticketremainEntityPK) o;

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
