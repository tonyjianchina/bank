package com.test1.bank;

/**
 * Created by 123 on 2016/6/13.
 */
public enum customerType {
    COMMOM,EXPRESS,VIP;

    @Override
    public String toString() {
        switch (this){
         case COMMOM:
             return "��ͨ";
         case EXPRESS:
             return "����";
         case VIP:
             return "VIP";

        }
        return null;
    }
}
