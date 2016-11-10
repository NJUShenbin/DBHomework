package edu.nju.dbhomework.dataInit;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by sbin on 2016/11/10.
 */
@Configuration
@ConditionalOnExpression("${spring.datasource.initialize}")
public class DataInitConfig {

}
