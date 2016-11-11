package edu.nju.dbhomework;

import edu.nju.dbhomework.dataInit.crawler.TrainScheduleCrawler;
import edu.nju.dbhomework.dataInit.repository.TrainRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class DbHomeworkApplication {

	public static void main(String[] args) {
		ApplicationContext c = SpringApplication.run(DbHomeworkApplication.class);
	}
}
