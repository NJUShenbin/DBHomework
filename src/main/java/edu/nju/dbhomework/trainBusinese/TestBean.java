package edu.nju.dbhomework.trainBusinese;

import edu.nju.dbhomework.dataInit.repository.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by sbin on 2016/11/10.
 */
@Component
public class TestBean {

    @Autowired
    TrainRepository repository;

}
