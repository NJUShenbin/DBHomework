package edu.nju.dbhomework.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Created by sbin on 2016/11/10.
 */
public class TimeUtil {

    public static String format(Date date,String format){
        return new SimpleDateFormat(format).format(date);
    }

    public static java.sql.Date afterDays(Date former,int offset){
        Calendar c = Calendar.getInstance();
        c.setTime(former);
        c.add(Calendar.DATE, offset);
        java.sql.Date date = new java.sql.Date(c.getTimeInMillis());
        return date;
    }

}
