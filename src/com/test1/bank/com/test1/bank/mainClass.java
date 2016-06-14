package com.test1.bank;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by 123 on 2016/6/13.
 */
public class mainClass {

    public static void main(String[] args) {
        for (int i=1;i<5;i++){
            serviceWindow commonWindow = new serviceWindow();
            commonWindow.setWindowId(i);
            commonWindow.start();
        }

        serviceWindow vipWindow = new serviceWindow();
        vipWindow.setType(customerType.VIP);
        vipWindow.start();

        serviceWindow expressWindow = new serviceWindow();
        expressWindow.setType(com.test1.bank.customerType.EXPRESS);
        expressWindow.start();

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        Integer num = numberMachine.getInstance().getCommonManager().generateNewNumber();
                        System.out.println(num+"号普通客户等待服务");
                    }
                },
                0,
                constance.COMMON_CUSTOMER_TIME,
                TimeUnit.SECONDS
        );


        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        Integer num = numberMachine.getInstance().getExpressManager().generateNewNumber();
                        System.out.println(num+"号快速客户等待服务");
                    }
                },
                0,
                constance.COMMON_CUSTOMER_TIME*6,
                TimeUnit.SECONDS
        );


        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(
                new Runnable() {
                    @Override
                    public void run() {
                        Integer num = numberMachine.getInstance().getVipManager().generateNewNumber();
                        System.out.println(num+"号VIP客户等待服务");
                    }
                },
                0,
                com.test1.bank.constance.COMMON_CUSTOMER_TIME*2,
                TimeUnit.SECONDS
        );




    }
}
