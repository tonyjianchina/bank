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
        String windowName = "��" + windowId + "��" + type + "����";
        System.out.println(windowName + "���ڻ�ȡ��ͨ����");
        Integer num = numberMachine.getInstance().getCommonManager().fitchNumber();
        if (num != null) {
            System.out.println(windowName + "��ʼΪ" + num + "����ͨ�ͻ�����");
            int maxRandomTime = constance.MAX_SERVICE_TIME - constance.MIN_SERVICE_TIME;
            int serviceTime = new Random().nextInt(maxRandomTime) +1+ constance.MIN_SERVICE_TIME;

            try {
                Thread.sleep(serviceTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(windowName + "�����˵�" + num + "����ͨ�ͻ�������ʱ" + serviceTime / 1000 + "s");
        } else {
            System.out.println("û��ȡ�����񣬿���1��");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void expressService() {
        Integer num = numberMachine.getInstance().getExpressManager().fitchNumber();
        String windowName = "��" + windowId + "��" + type + "����";
        System.out.println(windowName + "���ڻ�ȡ��ݷ���");

        if (num != null) {
            System.out.println(windowName + "��ʼΪ" + num + "�ſ�ݿͻ�����");
            long serviceTime = constance.MIN_SERVICE_TIME;
            try {
                Thread.sleep(serviceTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(windowName + "�����˵�" + num + "����ͨ�ͻ�������ʱ" + serviceTime / 1000 + "s");
        } else {
            System.out.println(windowName+"û��ȡ������");
            commonService();
            }
        }


    private void vipService() {
        Integer num = numberMachine.getInstance().getVipManager().fitchNumber();
        String windowName = "��" + windowId + "��" + type + "����";
        System.out.println(windowName + "���ڻ�ȡvip����");

        if (num != null) {
            System.out.println(windowName + "��ʼΪ" + num + "��vip�ͻ�����");
            long serviceTime = constance.MIN_SERVICE_TIME;

            try {
                Thread.sleep(serviceTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long costTime = System.currentTimeMillis() - serviceTime;
            System.out.println(windowName + "�����˵�" + num + "��vip�ͻ�������ʱ" + costTime / 1000 + "s");
        } else {
            System.out.println(windowName+"û��ȡ������");
            commonService();
        }
    }
}



