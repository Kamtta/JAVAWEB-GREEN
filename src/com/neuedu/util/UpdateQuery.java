package com.neuedu.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UpdateQuery {
//    单表增删改
    public static int update(String sql,Object ...objects){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        int i = -1;
        try {
            connection = SqlUtil.getConn();
            preparedStatement = connection.prepareStatement(sql);
            SqlUtil.insertData(preparedStatement,objects);
            i = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            SqlUtil.close(connection,preparedStatement);
        }
        return i;
    }
//    单表的查找
    public static List<Object> query(String sql,ResultObject resultObject,Object ...objects){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Object> result = new ArrayList<>();
        try {
            connection = SqlUtil.getConn();
            preparedStatement = connection.prepareStatement(sql);
            SqlUtil.insertData(preparedStatement,objects);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Object object = resultObject.getByResultSet(resultSet);
                result.add(object);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            SqlUtil.close(connection,preparedStatement,resultSet);
        }
        return result;
    }
}
