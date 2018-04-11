package com.test;

import java.net.Socket;

/**
 * Created by GentleNi
 * Date 2018/4/11.
 */
public class TestListener {
    public static void main(String[] args) {
        EventSource eventSource = new EventSource();
        eventSource.setListener(new MobileNetListener() {
            @Override
            public void updateUserStatus(String status) {
                if(status.equals("offline")){
                    System.out.println("用户下线了，我知道了");
                }else {
                    System.out.println("用户登录了，我知道了");

                }
            }
        });

        //手动触发事件源
        eventSource.setNetStatus("offline");
        eventSource.setNetStatus("online");
        eventSource.setNetStatus("offline");
        eventSource.setNetStatus("online");
    }
}
