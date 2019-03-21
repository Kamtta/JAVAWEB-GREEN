package com.neuedu.impl;

import com.neuedu.bean.Goods;
import com.neuedu.bean.ShoppingCart;
import com.neuedu.dao.ShoppingCartDao;
import com.neuedu.util.ResultObject;
import com.neuedu.util.UpdateQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDaoImpl implements ShoppingCartDao {
    @Override
    public int addGoods(Goods goods) {
        String sql = "insert into shoppingcart(gphoto,gname,gprice) values(?,?,?)";
        int i = UpdateQuery.update(sql,goods.getGphoto(),goods.getGname(),goods.getGprice());
        return i;
    }

    @Override
    public int delete(String gname) {
        String sql = "delete from shoppingcart where gname = ?";
        int i = UpdateQuery.update(sql,gname);
        return i;
    }

    @Override
    public List<ShoppingCart> selectAll() {
        String sql = "select * from shoppingcart where gifupload = 0";
        List<Object> objectList = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                ShoppingCart shoppingCart = new ShoppingCart();
                shoppingCart.setSid(resultSet.getInt("sid"));
                shoppingCart.setGname(resultSet.getString("gname"));
                shoppingCart.setGphoto(resultSet.getString("gphoto"));
                shoppingCart.setGprice(resultSet.getDouble("gprice"));
                shoppingCart.setNum(resultSet.getInt("num"));
                shoppingCart.setGifupload(resultSet.getInt("gifupload"));
                return shoppingCart;
            }
        });
        if(objectList == null || objectList.size() == 0){
            return null;
        }
        List<ShoppingCart> list = new ArrayList<>();
        for (Object object:objectList) {
            list.add((ShoppingCart)object);
        }
        return list;
    }

    @Override
    public ShoppingCart selectByGname(String gname) {
        String sql = "select * from shoppingcart where gname = ?";
        List<Object> objectList = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                ShoppingCart shoppingCart = new ShoppingCart();
                shoppingCart.setSid(resultSet.getInt("sid"));
                shoppingCart.setGname(resultSet.getString("gname"));
                shoppingCart.setGphoto(resultSet.getString("gphoto"));
                shoppingCart.setGprice(resultSet.getDouble("gprice"));
                shoppingCart.setNum(resultSet.getInt("num"));
                shoppingCart.setGifupload(resultSet.getInt("gifupload"));
                return shoppingCart;
            }
        },gname);
        if (objectList == null||objectList.size()==0){
            return null;
        }
        ShoppingCart shoppingCart = (ShoppingCart) objectList.get(0);
        return shoppingCart;
    }

    @Override
    public int update(ShoppingCart shoppingCart) {
        String sql = "update shoppingcart set gphoto = ?,gprice = ?,num = ? ,gifupload = ? where gname = ?";
        int i = UpdateQuery.update(sql,shoppingCart.getGphoto(),shoppingCart.getGprice(),shoppingCart.getNum(),shoppingCart.getGifupload(),shoppingCart.getGname());
        return i;
    }
}
