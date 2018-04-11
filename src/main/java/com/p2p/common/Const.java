package com.p2p.common;

/**
 * Created by GentleNi
 * Date 2018/4/10.
 */
public interface Const {
    interface Request{
        //状态码
        int REGISTER = 1;
        int LOGIN = 2;
        int LOGOUT = 3;
        int ERROR = 4;
        int USERLIST =5;
    }

    interface Response{
        int SUCCESS = 20;
        int ERROR = 30;
    }
    //用户状态
    int OFFLINE = 0;
    int ONLINE = 10;

    //类型
    interface Type{
        String REGISTER = "register";
        String LOGIN = "login";
    }
    String IP = "ip";
    String PORT = "port";
}
