package com.test1.bank;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 123 on 2016/6/12.
 */
public class numberManager {

    private  int lastNumber = 0;
    private List queneNumber = new ArrayList<>();


    public synchronized Integer generateNewNumber(){
        queneNumber.add(++lastNumber);
        return  lastNumber;
    }

    public synchronized Integer fitchNumber(){
        if(queneNumber.size()>0){
            return (Integer)queneNumber.remove(0);
        }else{
            return null;
        }
    }

//    public synchronized Integer generateNewNumber(){
//        queueNumbers.add(++lastNumber);
//        return lastNumber;
//    }
//
//    public synchronized Integer fetchNumber(){
//        if(queueNumbers.size()>0){
//            return (Integer)queueNumbers.remove(0);
//        }else{
//            return null;
//        }
//    }




}
