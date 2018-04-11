package com.test.callback;

/**
 * Created by GentleNi
 * Date 2018/4/11.
 */
public class Button {
    private ClickListener clickListener;

    public void setOnClickListener(ClickListener clickListener){
        this.clickListener = clickListener;
    }

    void click(){
        clickListener.onClick();
    }


}
