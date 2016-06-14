package com.test1.bank;

import java.util.Random;
import java.util.concurrent.Executors;

import static com.test1.bank.numberMachine.getInstance;

/**
 * Created by 123 on 2016/6/12.
 */
public class serviceWindow {


    private customerType type = customerType.COMMOM;
    private int windowId=1;

    public void setType(customerType type) {
        this.type = type;
    }

    public void setWindowId(int windowId) {
        this.windowId = windowId;
    }

    public void start() {
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    switch (type) {
                        case COMMOM:
                            commonService();
                            break;
                        case EXPRESS:
                            expressService();
                            break;
                        case VIP:
                            break;

                    }

                }
            }
        });

    }


    private void commonService() {
        String windowName = "第" + windowId + "号" + type + "窗口";
        System.out.println(windowName + "正在获取普通服务");
        Integer num = numberMachine.getInstance().getCommonManager().fitchNumber();
        if (num != null) {
            System.out.println(windowName + "开始为" + num + "号普通客户服务");
            int maxRandomTime = constance.MAX_SERVICE_TIME - constance.MIN_SERVICE_TIME;
            int serviceTime = new Random().nextInt(maxRandomTime) +1+ constance.MIN_SERVICE_TIME;

            try {
                Thread.sleep(serviceTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(windowName + "服务了第" + num + "号普通客户，共耗时" + serviceTime / 1000 + "s");
        } else {
            System.out.println("没有取到服务，空闲1秒");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void expressService() {
        Integer num = numberMachine.getInstance().getExpressManager().fitchNumber();
        String windowName = "第" + windowId + "号" + type + "窗口";
        System.out.println(windowName + "正在获取快捷服务");

        if (num != null) {
            System.out.println(windowName + "开始为" + num + "号快捷客户服务");
            long serviceTime = constance.MIN_SERVICE_TIME;
            try {
                Thread.sleep(serviceTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(windowName + "服务了第" + num + "号普通客户，共耗时" + serviceTime / 1000 + "s");
        } else {
            System.out.println(windowName+"没有取到服务");
            commonService();
            }
        }


    private void vipService() {
        Integer num = numberMachine.getInstance().getVipManager().fitchNumber();
        String windowName = "第" + windowId + "号" + type + "窗口";
        System.out.println(windowName + "正在获取vip服务");

        if (num != null) {
            System.out.println(windowName + "开始为" + num + "号vip客户服务");
            long serviceTime = constance.MIN_SERVICE_TIME;

            try {
                Thread.sleep(serviceTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long costTime = System.currentTimeMillis() - serviceTime;
            System.out.println(windowName + "服务了第" + num + "号vip客户，共耗时" + costTime / 1000 + "s");
        } else {
            System.out.println(windowName+"没有取到服务");
            commonService();
        }
    }
}



