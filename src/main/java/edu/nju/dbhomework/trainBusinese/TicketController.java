package edu.nju.dbhomework.trainBusinese;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

/**
 * Created by sbin on 2016/11/12.
 */
@Controller
public class TicketController {

    @Autowired
    TicketService service;



}
