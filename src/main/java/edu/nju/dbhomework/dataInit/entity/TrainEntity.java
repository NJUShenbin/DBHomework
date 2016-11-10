package edu.nju.dbhomework.dataInit.entity;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by sbin on 2016/11/10.
 */
@Entity
@Table(name = "train")
public class TrainEntity {
    private int id;
    private String name;
    private Collection<CoachEntity> coachesById;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainEntity that = (TrainEntity) o;

        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "trainByTrainId")
    public Collection<CoachEntity> getCoachesById() {
        return coachesById;
    }

    public void setCoachesById(Collection<CoachEntity> coachesById) {
        this.coachesById = coachesById;
    }
}
