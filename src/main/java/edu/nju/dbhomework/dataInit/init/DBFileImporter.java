package edu.nju.dbhomework.dataInit.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.transaction.Transactional;
import java.io.File;

/**
 * Created by sbin on 2016/11/11.
 */
public class DBFileImporter {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void importFile(File file,String tableName){

        String deleteSql = "delete from "+tableName;
        jdbcTemplate.execute(deleteSql);

        String sql = "LOAD DATA LOCAL INFILE " +
                "'"+
                file.getAbsolutePath().replaceAll("\\\\","/") +
                "'"+
                " INTO TABLE " +
                tableName +
                " CHAR SET utf8" +
                " FIELDS TERMINATED BY '\\t'" +
                " LINES TERMINATED BY '\\n' ";
        System.out.println(sql);
        jdbcTemplate.execute(sql);
    }

}
