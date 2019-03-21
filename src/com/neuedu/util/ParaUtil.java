package com.neuedu.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/*
* 利用反射的技术封装连接数据库的属性
* */
public class ParaUtil {
    private static Properties properties = new Properties();
//    一初始化就加载相应的数据库属性文件
    static {
        InputStream is = ParaUtil.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static final String DRIVER = properties.getProperty("driver");
    public static final String URL = properties.getProperty("url");
    public static final String USERNAME = properties.getProperty("username");
    public static final String PASSWORD = properties.getProperty("password");
}
