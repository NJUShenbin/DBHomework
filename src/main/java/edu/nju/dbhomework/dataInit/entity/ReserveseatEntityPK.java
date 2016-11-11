package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by sbin on 2016/11/11.
 */
public class ReserveseatEntityPK implements Serializable {
    private int scheduleId;
    private String station;

    @Column(name = "scheduleId")
    @Id
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Column(name = "station")
    @Id
    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReserveseatEntityPK that = (ReserveseatEntityPK) o;

        if (scheduleId != that.scheduleId) return false;
        if (station != null ? !station.equals(that.station) : that.station != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scheduleId;
        result = 31 * result + (station != null ? station.hashCode() : 0);
        return result;
    }
}
