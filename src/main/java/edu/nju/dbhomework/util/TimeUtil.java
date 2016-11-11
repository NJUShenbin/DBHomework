package edu.nju.dbhomework.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * Created by sbin on 2016/11/10.
 */
public class TimeUtil {

    public String format(Date date,String format){
        return new SimpleDateFormat(format).format(date);
    }

}
