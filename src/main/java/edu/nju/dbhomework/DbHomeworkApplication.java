package edu.nju.dbhomework;

import edu.nju.dbhomework.dataInit.crawler.TrainScheduleCrawler;
import edu.nju.dbhomework.dataInit.repository.TrainRepository;
import edu.nju.dbhomework.trainBusinese.TicketController;
import edu.nju.dbhomework.util.TimeUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Date;

@SpringBootApplication
@EnableTransactionManagement
public class DbHomeworkApplication {

	public static void main(String[] args) {
		ApplicationContext context =
				SpringApplication.run(DbHomeworkApplication.class);

		TicketController ticketController =
				context.getBean(TicketController.class);

		Date date = TimeUtil.parse("yyyy-MM-dd","2016-11-13");
		System.out.println(date);
		String startStation = "北京南";
		String endStation = "宜兴";

		long begin = System.currentTimeMillis();
		ticketController.searchTicket(date,startStation,endStation);
		long end = System.currentTimeMillis();
		System.out.println("耗时"+(end-begin)+"ms");
	}
}
