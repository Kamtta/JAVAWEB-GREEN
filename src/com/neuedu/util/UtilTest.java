package com.neuedu.util;

import com.neuedu.bean.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UtilTest {
    /*
    * 测试数据库工具
    * */
    public static void main(String[] args) {
//        insert();
        query();
    }
    public static int insert(){
        int i = -1;
        String sql = "insert into usertable(uname,upwd,receiver,raddress,rtelephone,rlevel) values(?,?,?,?,?,?)";
        User user = new User();
        user.setUname("15822869305");
        user.setUpwd("chenjingrong");
        user.setReceiver("陈景容");
        user.setRaddress("东软睿道");
        user.setRtelephone("15822869305");
        user.setRlevel(2);
        i = UpdateQuery.update(sql,user.getUname(),user.getUpwd(),user.getReceiver(),user.getRaddress(),user.getRtelephone(),user.getRlevel());
        return i;
    }
    public static List<Object> query(){
        List<Object> result = new ArrayList<>();
        String sql = "select * from usertable";
        result = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setUpwd(resultSet.getString("upwd"));
                user.setReceiver(resultSet.getString("receiver"));
                user.setRlevel(resultSet.getInt("rlevel"));
                user.setRtelephone(resultSet.getString("rtelephone"));
                user.setRaddress(resultSet.getString("raddress"));
                user.setRaids(resultSet.getString("raids"));
                user.setUsex(resultSet.getInt("usex"));
                user.setUbirthday(resultSet.getDate("ubirthday"));
                return user;
            }
        });
        for (Object object:result) {
            System.out.println(object);
        }
        return result;
    }
}
