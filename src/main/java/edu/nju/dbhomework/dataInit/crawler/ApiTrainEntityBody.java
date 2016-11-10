package edu.nju.dbhomework.dataInit.crawler;

import java.util.List;

/**
 * Created by sbin on 2016/11/8.
 */
public class ApiTrainEntityBody {
    List<String> content;

    public List<String> getContent() {
        return content;
    }
    public void setContent(List<String> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "ApiTrainEntityBody{" +
                "content=" + content +
                '}';
    }

    public TrainSchedule toTrainSchedule(){
        String time = content.get(4);
        if(time.equals("终到站")){
            time = content.get(3);
        }
        return new TrainSchedule(content.get(1),time);
    }
}
