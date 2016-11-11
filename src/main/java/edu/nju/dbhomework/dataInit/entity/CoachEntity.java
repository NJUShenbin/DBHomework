package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.*;

/**
 * Created by sbin on 2016/11/10.
 */
@Entity
@Table(name = "coach")
public class CoachEntity {
    private int id;
    private int row;
    private int column;
    private Integer order;
    private CoachType type;

    private TrainEntity trainByTrainId;

    public CoachEntity(){}

    public CoachEntity(CoachType type,int row,int column,Integer order ) {
        this.order = order;
        this.column = column;
        this.row = row;
        this.type = type;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Column(name = "`column`")
    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


    @Basic
    @Column(name = "`order`")
    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
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
        if (order != null ? !order.equals(that.order) : that.order != null) return false;

        return true;
    }


    @ManyToOne
    @JoinColumn(name = "trainId", referencedColumnName = "id")
    public TrainEntity getTrainByTrainId() {
        return trainByTrainId;
    }

    public CoachEntity setTrainByTrainId(TrainEntity trainByTrainId) {
        this.trainByTrainId = trainByTrainId;
        return this;
    }
}
