package edu.nju.dbhomework.trainBusinese;

import edu.nju.dbhomework.trainBusinese.vo.TicketSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Created by sbin on 2016/11/12.
 */
@Service
public class TicketService {

    @Value("${dbhomework.searchSql}")
    String searchSql;

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @PostConstruct
    void init(){
        System.out.println(searchSql);
    }

    public TicketSearchResult searchTicket(Date date,
                                           String startStation,
                                           String endStation){
        return null;
    }

}
