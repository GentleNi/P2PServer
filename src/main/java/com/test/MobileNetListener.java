package com.test;

/**
 * Created by GentleNi
 * Date 2018/4/11.
 */
public class MobileNetListener implements NetListener {
    @Override
    public void updateUserStatus(String status) {
        if(status.equals("offline")){
            System.out.println("用户下线");
        }
    }
}
