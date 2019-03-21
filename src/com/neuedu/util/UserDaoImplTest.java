package com.neuedu.util;

import com.neuedu.bean.User;
import com.neuedu.dao.UserDao;
import com.neuedu.impl.UserDaoImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;

/**
 * 测试UserDao实现类
 */
public class UserDaoImplTest {
    private static UserDao userDao = new UserDaoImpl();
    public static void main(String[] args) throws ParseException {
//        query();
//        queryByUname();
//        insert();
//        delete();
        update();
    }

    /**
     *测试根据level进行查询的方法
     * @return
     */
    public static List<User> query(){
        int rlevel = 2;
        List<User> result = userDao.selectByRlevel(rlevel);
        for (User user:result) {
            System.out.println(user);
        }
        return result;
    }

    /**
     * 测试根据uname和level进行查询的功能
     * @return
     */
    public static List<User> queryByUname(){
        int level = 2;
        String uname = "869305";
        List<User> result = userDao.selectByUname(uname,level);
        for (User user:result) {
            System.out.println(user);
        }
        return result;
    }

    /**
     * 测试添加管理员的操作
     * @return
     * @throws ParseException
     */
    public static int insert() throws ParseException {
        User user = new User();
        user.setUname("15218177552");
        user.setUpwd("123466789");
        user.setUsex(1);
        user.setReceiver("cjr");
        user.setRaddress("Neuedu");
        user.setRtelephone("15218177552");
        user.setUbirthday(DateFormat.getDateInstance().parse("1995-07-01"));
        user.setRlevel(1);
        user.setRaids("root");
        int i = userDao.insertAdmin(user);
        return i;
    }

    /**
     * 测试delete的功能
     * @return
     */
    public static int delete(){
        String uname = "15822869305";
        int i = userDao.deleteAdmin(uname);
        return i;
    }
    public static int update() throws ParseException {
        User user = new User();
        user.setUname("15822869305");
        user.setUpwd("20155028");
        user.setUsex(1);
        user.setReceiver("steven");
        user.setRtelephone("15822869305");
        user.setRlevel(1);
        user.setRaddress("tjcu");
        user.setUbirthday(DateFormat.getDateInstance().parse("1995-07-01"));
        user.setRaids("Vip");
        int i = userDao.updateAdmin(user);
        return i;
    }
}
