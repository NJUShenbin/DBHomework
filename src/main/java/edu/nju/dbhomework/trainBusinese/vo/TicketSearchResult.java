package edu.nju.dbhomework.trainBusinese.vo;

import java.util.Date;
import java.util.List;

/**
 * Created by sbin on 2016/11/12.
 */
public class TicketSearchResult {

    private String startStation;
    private String endStation;
    private Date departDate;

    List<TicketSearchItem> items;

    public String getStartStation() {
        return startStation;
    }

    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    public String getEndStation() {
        return endStation;
    }

    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    public Date getDepartDate() {
        return departDate;
    }

    public void setDepartDate(Date departDate) {
        this.departDate = departDate;
    }

    public List<TicketSearchItem> getItems() {
        return items;
    }

    public void setItems(List<TicketSearchItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "TicketSearchResult{" +
                "startStation='" + startStation + '\'' +
                ", endStation='" + endStation + '\'' +
                ", departDate=" + departDate +
                ", items=" + items +
                '}';
    }
}
