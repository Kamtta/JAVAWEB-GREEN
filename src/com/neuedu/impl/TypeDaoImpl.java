package com.neuedu.impl;

import com.neuedu.bean.Type;
import com.neuedu.dao.TypeDao;
import com.neuedu.util.ResultObject;
import com.neuedu.util.UpdateQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypeDaoImpl implements TypeDao {

    @Override
    public List<Type> selectAll() {
        String sql = "select * from typetable";
        List<Object> objectList = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                Type type = new Type();
                type.setTid(resultSet.getInt("tid"));
                type.setTname(resultSet.getString("tname"));
                return type;
            }
        });
        if(objectList == null || objectList.size() == 0){
            return null;
        }
        List<Type> list = new ArrayList<>();
        for (Object object:objectList) {
            list.add((Type)object);
        }
        return list;
    }
}
