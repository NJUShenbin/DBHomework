package edu.nju.dbhomework.dataInit.crawler;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by sbin on 2016/11/11.
 */
public class TrainScheduleCrawlerTest {
    @Test
    public void getSchedule() throws Exception {
        TrainScheduleCrawler crawler = new TrainScheduleCrawler();
        System.out.println(crawler.getSchedule("G75"));
    }

}