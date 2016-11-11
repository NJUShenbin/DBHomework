package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.*;

/**
 * Created by sbin on 2016/11/11.
 */
@Entity
@Table(name = "reserveseat")
@IdClass(ReserveseatEntityPK.class)
public class ReserveSeatEntity {
    private int scheduleId;
    private String station;
    private Integer order;
    private Integer reserve;

    @Id
    @Column(name = "scheduleId")
    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    @Id
    @Column(name = "station")
    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    @Basic
    @Column(name = "`order`")
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Basic
    @Column(name = "reserve")
    public Integer getReserve() {
        return reserve;
    }

    public void setReserve(Integer reserve) {
        this.reserve = reserve;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReserveSeatEntity that = (ReserveSeatEntity) o;

        if (scheduleId != that.scheduleId) return false;
        if (station != null ? !station.equals(that.station) : that.station != null) return false;
        if (order != null ? !order.equals(that.order) : that.order != null) return false;
        if (reserve != null ? !reserve.equals(that.reserve) : that.reserve != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = scheduleId;
        result = 31 * result + (station != null ? station.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (reserve != null ? reserve.hashCode() : 0);
        return result;
    }
}
