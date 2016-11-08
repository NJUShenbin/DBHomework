package edu.nju.dbhomework;

import edu.nju.dbhomework.crawler.TrainScheduleCrawler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DbHomeworkApplication {

	public static void main(String[] args) {
		System.out.println(new TrainScheduleCrawler().getSchedule(164));
	}
}
