package com.test1.bank;

/**
 * Created by 123 on 2016/6/12.
 */
public class numberMachine {
    private com.test1.bank.numberManager vipManager = new com.test1.bank.numberManager();
    private com.test1.bank.numberManager expressManager = new com.test1.bank.numberManager();
    private com.test1.bank.numberManager commonManager = new com.test1.bank.numberManager();

    public com.test1.bank.numberManager getVipManager() {
        return vipManager;
    }

    public com.test1.bank.numberManager getExpressManager() {
        return expressManager;
    }

    public com.test1.bank.numberManager getCommonManager() {
        return commonManager;
    }

    private  numberMachine(){}
    public   static  numberMachine getInstance(){
        return  instance;
    }
    private  static  numberMachine instance = new numberMachine();

}
