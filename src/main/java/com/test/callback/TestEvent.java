package com.test.callback;

/**
 * Created by GentleNi
 * Date 2018/4/11.
 */
public class TestEvent {
    public static void main(String[] args) {
        Button button = new Button();
        button.setOnClickListener(new ClickListener() {
            @Override
            public void onClick() {
                System.out.println("回调成功");
            }
        });

        button.click();
    }
}
