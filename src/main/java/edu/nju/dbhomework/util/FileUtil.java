package edu.nju.dbhomework.util;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

/**
 * Created by sbin on 2016/11/11.
 */
public class FileUtil {

    public static File forceCreateFile(String path){
        File file = new File(path);
        if (file.exists()){
            file.delete();
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

}
