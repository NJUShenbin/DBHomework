package edu.nju.dbhomework.trainBusinese;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.nju.dbhomework.trainBusinese.vo.TicketSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.util.Date;

/**
 * Created by sbin on 2016/11/12.
 */
@Controller
public class TicketController {

    @Autowired
    TicketService service;

    ObjectMapper mapper = new ObjectMapper();

    public void searchTicket(Date date,
                             String startStation,
                             String endStation){
       TicketSearchResult result =
               service.searchTicket(date,startStation,endStation);

        try {
            String resultString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(result);
            System.out.println(resultString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }


}
