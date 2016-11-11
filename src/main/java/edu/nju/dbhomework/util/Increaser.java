package edu.nju.dbhomework.util;

/**
 * Created by sbin on 2016/11/10.
 */
public class Increaser {
    private int init;
    public Increaser(int first){
        this.init = first-1;
    }

    public int increase(){
        init++;
        return init;
    }

}
