package com.p2p.service;

import com.p2p.common.Const;
import com.p2p.dao.UserMapper;
import com.p2p.entity.BaseResponse;
import com.p2p.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by GentleNi
 * Date 2018/4/10.
 */
public class UserService {

    public BaseResponse login(User user) throws IOException {
        String resource = "sqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = factory.openSession();
        //---------------
        UserMapper userMapper = session.getMapper(UserMapper.class);
        int count = userMapper.selectByIpAndName(user.getIp(),user.getName());
        System.out.println(user);
        //--------------
        if(count == 0){
            userMapper.insert(user);
        }else{
            userMapper.updateByPrimaryKey(user);
        }
        session.commit();
        session.close();
        return BaseResponse.createResponse(Const.Type.REGISTER,Const.Response.SUCCESS,"登陆成功");
    }
}
