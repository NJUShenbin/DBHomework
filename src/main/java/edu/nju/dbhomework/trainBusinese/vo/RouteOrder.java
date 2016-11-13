package edu.nju.dbhomework.trainBusinese.vo;

import java.sql.Time;

/**
 * Created by sbin on 2016/11/13.
 */
public class RouteOrder {


    private int routeId;
    private int order;
    private Time departTime;

    public Time getDepartTime() {
        return departTime;
    }

    public void setDepartTime(Time departTime) {
        this.departTime = departTime;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
