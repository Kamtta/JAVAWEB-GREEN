package com.neuedu.util;

import java.io.IOException;
import java.sql.*;

public class SqlUtil {
    static {
        try {
            Class.forName(ParaUtil.DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
//   获取数据库连接
    public static Connection getConn() throws  SQLException {
        return DriverManager.getConnection(ParaUtil.URL,ParaUtil.USERNAME,ParaUtil.PASSWORD);
    }
//    向SQL语句中插入数据
    public static void insertData(PreparedStatement preparedStatement,Object ...objects) throws SQLException {
        if(objects != null && objects.length > 0){
            for (int i = 0;i < objects.length;i++){
                preparedStatement.setObject(i+1,objects[i]);
            }
        }
    }
//   关闭相关的流
    public static void close(Object ...objects){
        if(objects != null && objects.length > 0){
            try{
                for (Object obeject:objects) {
                    if(obeject != null){
                        if(obeject instanceof  Connection){
                            ((Connection)obeject).close();
                        }
                        if(obeject instanceof Statement){
                            ((Statement)obeject).close();
                        }
                        if(obeject instanceof ResultSet){
                            ((ResultSet)obeject).close();
                        }
                    }
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
