package com.p2p.server;

import com.sun.istack.internal.localization.NullLocalizable;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by GentleNi
 * Date 2018/4/10.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(20184);
        System.out.println("服务器开始监听---");
        Socket client = null;
        boolean f = true;
        while (f) {//循环监听
            // 等待客户端的连接
            client = server.accept();
            System.out.println("与客户端连接成功！");
            // 为每个客户端连接开启一个线程
            new Thread(new ServerThread(client)).start();
        }
        server.close();
    }
}
