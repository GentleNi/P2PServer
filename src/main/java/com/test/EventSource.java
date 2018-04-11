package com.test;

/**
 * Created by GentleNi
 * Date 2018/4/11.
 */
public class EventSource {
    private NetListener listener;
    private String status;

    public void setStatus(String status) {
        this.status = status;
    }

    public void setListener(NetListener listener) {
        this.listener = listener;
    }

    public void notifyListener(){
        if(listener != null){
            listener.updateUserStatus(status);
        }
    }

    public void setNetStatus(String status){
        this.status = status;
        notifyListener();
    }
}
