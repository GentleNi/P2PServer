package com.p2p.server;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.p2p.common.Const;
import com.p2p.entity.BaseRequest;
import com.p2p.entity.User;
import com.p2p.service.UserService;

import javax.xml.bind.util.JAXBSource;
import java.io.*;
import java.net.Socket;
import java.util.Map;

/**
 * Created by GentleNi
 * Date 2018/4/10.
 */
public class ServerThread implements Runnable{

    private Socket client = null;

    public ServerThread(Socket client){
        this.client = client;
    }

    @Override
    public void run() {

        UserService userService = new UserService();
        ObjectMapper mapper = new ObjectMapper();
        try {
            // 获取Socket的输出流，用来向客户端发送数据
            PrintStream out = new PrintStream(client.getOutputStream());
            // 获取Socket的输入流，用来接收从客户端发送过来的数据
            BufferedReader buf  = new BufferedReader(new InputStreamReader(client.getInputStream()));
            boolean flag = true;
            while (flag) {
                // 接收从客户端发送过来的数据
                String str = buf.readLine();
                //Json转成Java类
                //BaseRequest request = mapper.readValue(str, new TypeReference<BaseRequest<Map<String, String>>>() {});
                BaseRequest request = mapper.readValue(str, new TypeReference<BaseRequest<User>>() {});
                if ("bye".equals(str)) {// 读到bye字符串时退出循环
                    flag = false;
                }else if(request.getRequestCode()== Const.Request.REGISTER){
                    //TODO REGISTER
                    out.println("Server回复: 注册成功");
                }else if(request.getRequestCode()== Const.Request.LOGIN){
                    //TODO LOGIN
                    userService.login((User) request.getData());
                    out.println("Server回复: 登录成功");
                }else if(request.getRequestCode()== Const.Request.USERLIST){
                    //TODO GET USERLIST
                    out.println("Server回复: 获取用户状态列表");
                }
                else {
                    // Thread.sleep(20000);
                    // 将接收到的字符串前面加上“Server回复”，发送到对应的客户端
                    out.println("Server回复:" + str);
                    //TODO RETURN ERROR RESPONSE
                }
            }
            out.close();
            client.close();
            System.out.println("关闭连接");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
