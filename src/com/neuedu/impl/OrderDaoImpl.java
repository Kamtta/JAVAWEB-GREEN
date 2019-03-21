package com.neuedu.impl;

import com.neuedu.bean.Order;
import com.neuedu.dao.OrderDao;
import com.neuedu.util.ResultObject;
import com.neuedu.util.UpdateQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {

    @Override
    public int addOrder(Order order) {
        String sql = "insert into ordertable(oNum,gphoto,uid,gid,gnum,ocreatedate) values(?,?,?,?,?,?)";
        int i = UpdateQuery.update(sql,order.getoNum(),order.getGphoto(),order.getUid(),order.getGid(),order.getGnum(),order.getOcreatedate());
        return i;
    }

    @Override
    public List<Order> selectAll() {
        String sql = "select * from ordertable";
        List<Object> objectList = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                Order order = new Order();
                order.setUid(resultSet.getInt("uid"));
                order.setOcreatedate(resultSet.getDate("ocreatedate"));
                order.setoNum(resultSet.getString("oNum"));
                order.setGphoto(resultSet.getString("gphoto"));
                order.setGnum(resultSet.getInt("gnum"));
                order.setGid(resultSet.getInt("gid"));
                order.setOid(resultSet.getInt("oid"));
                order.setIfupload(resultSet.getInt("ifupload"));
                return order;
            }
        });
        if(objectList == null){
            return null;
        }
        List<Order> list = new ArrayList<>();
        for (Object object:objectList) {
            list.add((Order)object);
        }
        return list;
    }

    @Override
    public int delete(int oid) {
        String sql = "delete from ordertable where oid = ?";
        int i = UpdateQuery.update(sql,oid);
        return i;
    }

    @Override
    public List<Order> selectByUid(int uid) {
        String sql = "select * from ordertable where uid = ?";
        List<Object> objectList = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                Order order = new Order();
                order.setUid(resultSet.getInt("uid"));
                order.setOcreatedate(resultSet.getDate("ocreatedate"));
                order.setoNum(resultSet.getString("oNum"));
                order.setGphoto(resultSet.getString("gphoto"));
                order.setGnum(resultSet.getInt("gnum"));
                order.setGid(resultSet.getInt("gid"));
                order.setOid(resultSet.getInt("oid"));
                order.setIfupload(resultSet.getInt("ifupload"));
                return order;
            }
        },uid);
        if(objectList == null){
            return null;
        }
        List<Order> list = new ArrayList<>();
        for (Object object:objectList) {
            list.add((Order)object);
        }
        return list;
    }
}
