package edu.nju.dbhomework.trainBusinese;

import edu.nju.dbhomework.trainBusinese.vo.RouteOrder;
import edu.nju.dbhomework.trainBusinese.vo.TicketSearchItem;
import edu.nju.dbhomework.trainBusinese.vo.TicketSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * Created by sbin on 2016/11/12.
 */
@Service
public class TicketService {

    @Value("${dbhomework.searchRoute}")
    String searchRouteSql;

    @Value("${dbhomework.searchSeat}")
    String searchSeatSql;

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init(){
    }

    public TicketSearchResult searchTicket(Date date,
                                           String startStation,
                                           String endStation){
        Time time = new Time(date.getTime());
        List<RouteOrder> routeOrderList =
                searchRouteWithOccupation(startStation,endStation,time);

        TicketSearchResult result = new TicketSearchResult();
        result.setStartStation(startStation);
        result.setEndStation(endStation);
        result.setDepartDate(new java.sql.Date(date.getTime()));
        result.setItems(new ArrayList<>());


        Map<String,Object> param = new HashMap<>();
        param.put("date",date);

        for(int i=0;i<routeOrderList.size();i+=2){
            RouteOrder start = routeOrderList.get(i);
            RouteOrder end = routeOrderList.get(i+1);

            int routeId = start.getRouteId();
            int occupation = computeOcc(start.getOrder(),end.getOrder());

            param.put("occupation",occupation);
            param.put("routeId",routeId);

            TicketSearchItem item = new TicketSearchItem();
            item.setStartTime(start.getDepartTime());
            item.setEndTime(end.getDepartTime());

            jdbcTemplate.query(searchSeatSql,param,rs -> {

                item.setTrainNum(rs.getString("trainNum"));
               switch (rs.getString("type")){
                   case "b":
                       item.setBusinessSeat(rs.getInt("seatNum"));
                       break;
                   case "f":
                       item.setFirstClassSeat(rs.getInt("seatNum"));
                       break;
                   case "s":
                       item.setSecondClassSeat(rs.getInt("seatNum"));
               }
            });

            result.getItems().add(item);
        }

        result.getItems().sort((i1,i2)->{
            return i1.getStartTime().compareTo(i2.getStartTime());
        });


        return result;
    }

    private List<RouteOrder> searchRouteWithOccupation
            (String startStation, String endStation, Time time){

        Map<String,Object> param = new HashMap<>();
        param.put("startStation",startStation);
        param.put("endStation",endStation);
        param.put("time",time);

        List<RouteOrder> result = new ArrayList<>();
        jdbcTemplate.query(searchRouteSql,param,rs->{
            RouteOrder order = new RouteOrder();
            order.setRouteId(rs.getInt("routeId"));
            order.setDepartTime(rs.getTime("departTime"));
            order.setOrder(rs.getInt("stationOrder"));
            result.add(order);
        });


        return result;
//        Map<Integer,Integer> routeOccupationMap = new LinkedHashMap<>();
//
//        assert result.size()%2 == 0;
//
//        for(int i=0;i<result.size();i+=2){
//            int routeId = result.get(i).getRouteId();
//            assert routeId == result.get(i+1).getRouteId();
//
//            int startOrder = result.get(i).getOrder();
//            int endOrder = result.get(i+1).getOrder();
//
//            int occupation = 0;
//
//            //计算从开始站到结束站,座位占用的二进制串.最低位表示0号站
//            for(int occIndex = startOrder;occIndex<endOrder;occIndex++){
//                occupation += (1 << occIndex);
//            }
//
//            assert occupation>0;
//
//            routeOccupationMap.put(routeId,occupation);
//        }
//
//        return routeOccupationMap;
    }

    private int computeOcc(int start,int end){
        int occupation = 0;

        //计算从开始站到结束站,座位占用的二进制串.最低位表示0号站
        for(int occIndex = start;occIndex<end;occIndex++){
            occupation += (1 << occIndex);
        }
        assert occupation>0;
        return occupation;
    }

}
