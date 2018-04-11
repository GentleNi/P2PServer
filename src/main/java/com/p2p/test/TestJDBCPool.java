package com.p2p.test;

import com.p2p.dao.JdbcUtil;

import java.sql.*;

/**
 * Created by GentleNi
 * Date 2018/4/10.
 */
public class TestJDBCPool {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{
            //获取数据库连接
            conn = JdbcUtil.getConnection();
            String sql = "insert into p_user(name,password,ip,port) values(?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1, "jack");
            st.setString(2, "password");
            st.setString(3, "127.0.0.1");
            st.setString(4, "7880");
            st.executeUpdate();
            //获取数据库自动生成的主键
            st = conn.prepareStatement(sql,st.RETURN_GENERATED_KEYS);
            rs = st.getGeneratedKeys();
            if(rs.next()){
                System.out.println(rs.getInt(1));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally{
            //释放资源
            JdbcUtil.release(conn, st, rs);
        }
    }
}
