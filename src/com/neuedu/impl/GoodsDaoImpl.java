package com.neuedu.impl;



import com.neuedu.bean.Goods;
import com.neuedu.dao.GoodsDao;
import com.neuedu.util.ResultObject;
import com.neuedu.util.UpdateQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl implements GoodsDao {

    @Override
    public int sumCount() {
        String sql = "select count(*) from goods";
        List<Object> objects = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                return resultSet.getInt(1);
            }
        });
        return Integer.valueOf((Integer)objects.get(0));
    }

    @Override
    public List findContent(int offset, int num) {
        String sql = "select * from goods limit ?,?";
        List<Object> objects = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                Goods goods = new Goods();
                goods.setGid(resultSet.getInt("gid"));
                goods.setGname(resultSet.getString("gname"));
                goods.setGprice(resultSet.getDouble("gprice"));
                goods.setGremarks(resultSet.getString("gremarks"));
                goods.setGrepertory(resultSet.getInt("grepertory"));
                goods.setGsalevolume(resultSet.getInt("gsalevolume"));
                goods.setGstandard(resultSet.getString("gstandard"));
                goods.setGphoto(resultSet.getString("gphoto"));
                goods.setTName(resultSet.getString("tname"));
                return goods;
            }
        },offset,num);
        List<Goods> result = new ArrayList<>();
        for (int i = 0;i < objects.size();i++) {
            result.add((Goods)objects.get(i));
        }
        return result;
    }

    @Override
    public int addGoods(Goods goods) {
        int i = -1;
        String sql = "insert into goods(gname,gprice,grepertory,gsalevolume,gstandard,gphoto,gremarks,tname) values(?,?,?,?,?,?,?,?)";
        i = UpdateQuery.update(sql,goods.getGname(),goods.getGprice(),goods.getGrepertory(),goods.getGsalevolume(),goods.getGstandard(),goods.getGphoto(),goods.getGremarks(),goods.getTName());
        return i;
    }

    @Override
    public int deletegoods(int gid) {
        String sql = "delete from goods where gid = ?";
        int i = UpdateQuery.update(sql,gid);
        return i;
    }

    @Override
    public int updategoods(Goods goods) {
        String sql = "update goods set gprice = ?,grepertory = ?,gsalevolume = ?,gstandard = ?,gphoto = ?,gremarks = ?,tname = ? where gname = ?";
        int i = UpdateQuery.update(sql,goods.getGprice(),goods.getGrepertory(),goods.getGsalevolume(),goods.getGstandard(),goods.getGphoto(),goods.getGremarks(),goods.getTName(),goods.getGname());
        return i;
    }

    @Override
    public Goods select(String gname) {
        String sql = "select * from goods where gname like ?";
        List<Object> objectList = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                Goods goods = new Goods();
                goods.setGid(resultSet.getInt("gid"));
                goods.setGname(resultSet.getString("gname"));
                goods.setGprice(resultSet.getDouble("gprice"));
                goods.setTName(resultSet.getString("tname"));
                goods.setGphoto(resultSet.getString("gphoto"));
                goods.setGstandard(resultSet.getString("gstandard"));
                goods.setGsalevolume(resultSet.getInt("gsalevolume"));
                goods.setGremarks(resultSet.getString("gremarks"));
                goods.setGrepertory(resultSet.getInt("grepertory"));
                return goods;
            }
        },"%"+gname+"%");
        if(objectList == null || objectList.size() == 0){
            return null;
        }
        Goods goods = (Goods)objectList.get(0);
        return goods;
    }

    @Override
    public List<Goods> selectAll(String gname) {
        String sql = "select * from goods where gname like ?";
        List<Object> objectList = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                Goods goods = new Goods();
                goods.setGid(resultSet.getInt("gid"));
                goods.setGname(resultSet.getString("gname"));
                goods.setGprice(resultSet.getDouble("gprice"));
                goods.setTName(resultSet.getString("tname"));
                goods.setGphoto(resultSet.getString("gphoto"));
                goods.setGstandard(resultSet.getString("gstandard"));
                goods.setGsalevolume(resultSet.getInt("gsalevolume"));
                goods.setGremarks(resultSet.getString("gremarks"));
                goods.setGrepertory(resultSet.getInt("grepertory"));
                return goods;
            }
        },"%"+gname+"%");
        if(objectList == null || objectList.size() == 0){
            return null;
        }
        List<Goods> list = new ArrayList<>();
        for (Object object:objectList) {
            list.add((Goods)object);
        }
        return list;
    }
}
