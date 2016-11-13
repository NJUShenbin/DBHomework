package edu.nju.dbhomework.trainBusinese;

import org.junit.Test;

import java.sql.Time;
import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Created by sbin on 2016/11/13.
 */
public class TicketServiceTest {

    @Test
    public void testTime(){
        Date date = new Date(System.currentTimeMillis());
        Time time = new Time(date.getTime());
        System.out.println(time);
    }

}