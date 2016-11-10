package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.*;

/**
 * Created by sbin on 2016/11/10.
 */
@Entity
@Table(name = "coach")
public class CoachEntity {
    private int id;
    private Integer capacity;
    private Integer order;
    private CoachType type;

    private TrainEntity trainByTrainId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "capacity")
    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Basic
    @Column(name = "order")
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Column(name = "type")
    public CoachType getType() {
        return type;
    }

    public void setType(CoachType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CoachEntity that = (CoachEntity) o;

        if (id != that.id) return false;
        if (capacity != null ? !capacity.equals(that.capacity) : that.capacity != null) return false;
        if (order != null ? !order.equals(that.order) : that.order != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (capacity != null ? capacity.hashCode() : 0);
        result = 31 * result + (order != null ? order.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "trainId", referencedColumnName = "id")
    public TrainEntity getTrainByTrainId() {
        return trainByTrainId;
    }

    public void setTrainByTrainId(TrainEntity trainByTrainId) {
        this.trainByTrainId = trainByTrainId;
    }
}
