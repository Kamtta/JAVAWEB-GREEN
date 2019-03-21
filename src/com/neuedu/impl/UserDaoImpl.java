package com.neuedu.impl;

import com.neuedu.bean.User;
import com.neuedu.dao.UserDao;
import com.neuedu.util.ResultObject;
import com.neuedu.util.UpdateQuery;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDaoImpl implements UserDao {
    @Override
    public int sumCount(int rlevel) {
        String sql = "select count(*) from usertable where rlevel = ?";
        List<Object> objects = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                return resultSet.getInt(1);
            }
        },rlevel);
        return Integer.valueOf((Integer)objects.get(0));
    }

    @Override
    public List findContent(int rlevel, int offset, int num) {
        String sql = "select * from usertable where ifdelete = 0 and rlevel = ? limit ?,?";
        List<Object> objects = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setUpwd(resultSet.getString("upwd"));
                user.setUsex(resultSet.getInt("usex"));
                user.setUbirthday(resultSet.getDate("ubirthday"));
                user.setRaids(resultSet.getString("raids"));
                user.setRaddress(resultSet.getString("raddress"));
                user.setRtelephone(resultSet.getString("rtelephone"));
                user.setRlevel(resultSet.getInt("rlevel"));
                user.setReceiver(resultSet.getString("receiver"));
                user.setIfdelete(resultSet.getInt("ifdelete"));
                return user;
            }
        },rlevel,offset,num);
        List<User> result = new ArrayList<>();
        for (int i = 0;i < objects.size();i++) {
            result.add((User)objects.get(i));
        }
        return result;
    }

    @Override
    public List<User> selectByRlevel(int rlevel) {
        String sql = "select * from usertable where ifdelete = 0 and rlevel = ?";
        List<Object> result = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setUpwd(resultSet.getString("upwd"));
                user.setUsex(resultSet.getInt("usex"));
                user.setUbirthday(resultSet.getDate("ubirthday"));
                user.setRaids(resultSet.getString("raids"));
                user.setRaddress(resultSet.getString("raddress"));
                user.setRtelephone(resultSet.getString("rtelephone"));
                user.setRlevel(resultSet.getInt("rlevel"));
                user.setReceiver(resultSet.getString("receiver"));
                user.setIfdelete(resultSet.getInt("ifdelete"));
                return user;
            }
        }, rlevel);
        List<User> list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            list.add((User) result.get(i));
        }
        return list;
    }

    @Override
    public List<User> selectByUname(String uname, int rlevel) {
        String sql = "select * from usertable where ifdelete =  0 and uname like ? and rlevel = ?";
        List<Object> result = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setUpwd(resultSet.getString("upwd"));
                user.setUsex(resultSet.getInt("usex"));
                user.setUbirthday(resultSet.getDate("ubirthday"));
                user.setRaids(resultSet.getString("raids"));
                user.setRaddress(resultSet.getString("raddress"));
                user.setRtelephone(resultSet.getString("rtelephone"));
                user.setRlevel(resultSet.getInt("rlevel"));
                user.setReceiver(resultSet.getString("receiver"));
                user.setIfdelete(resultSet.getInt("ifdelete"));
                return user;
            }
        }, "%" + uname + "%", rlevel);
        if(result == null || result.size() == 0){
            return null;
        }
        List<User> list = new ArrayList<>();
        for (int i = 0; i < result.size(); i++) {
            list.add((User) result.get(i));
        }
        return list;
    }

    @Override
    public User selectByName(String uname) {
        String sql = "select * from usertable where ifdelete = 0 and uname like ?";
        List<Object> objectList = UpdateQuery.query(sql, new ResultObject() {
            @Override
            public Object getByResultSet(ResultSet resultSet) throws SQLException {
                User user = new User();
                user.setUid(resultSet.getInt("uid"));
                user.setUname(resultSet.getString("uname"));
                user.setUpwd(resultSet.getString("upwd"));
                user.setUsex(resultSet.getInt("usex"));
                user.setUbirthday(resultSet.getDate("ubirthday"));
                user.setRaids(resultSet.getString("raids"));
                user.setRaddress(resultSet.getString("raddress"));
                user.setRtelephone(resultSet.getString("rtelephone"));
                user.setRlevel(resultSet.getInt("rlevel"));
                user.setReceiver(resultSet.getString("receiver"));
                user.setIfdelete(resultSet.getInt("ifdelete"));
                return user;
            }
        },"%"+uname+"%");
        if(objectList == null || objectList.size() == 0){
            return null;
        }
        User user = (User)objectList.get(0);
        return user;
    }

    @Override
    public int insertAdmin(User user) {
        String sql = "insert into usertable(uname,upwd,usex,ubirthday,receiver,raddress,rtelephone,rlevel,raids) values(?,?,?,?,?,?,?,?,?)";
        int i = UpdateQuery.update(sql, user.getUname(), user.getUpwd(), user.getUsex(), user.getUbirthday(), user.getReceiver(), user.getRaddress(), user.getRtelephone(), user.getRlevel(), user.getRaids());
        return i;
    }

    @Override
    public int deleteAdmin(String uname) {
        String sql = "update usertable set ifdelete = 1 where uname = ?";
        int i = UpdateQuery.update(sql,uname);
        return i;
    }

    @Override
    public int updateAdmin(User user) {
        String sql = "update usertable set upwd = ?,usex = ?,ubirthday = ?,receiver = ?,raddress = ?,rtelephone = ?,rlevel = ?,raids =? where uname = ?";
        int i = UpdateQuery.update(sql,user.getUpwd(),user.getUsex(),user.getUbirthday(),user.getReceiver(),user.getRaddress(),user.getRtelephone(),user.getRlevel(),user.getRaids(),user.getUname());
        return i;
    }

    @Override
    public int insertUser(User user) {
        String sql = "insert into usertable(uname,upwd,usex,ubirthday,receiver,raddress,rtelephone) values(?,?,?,?,?,?,?)";
        int i = UpdateQuery.update(sql, user.getUname(), user.getUpwd(), user.getUsex(), user.getUbirthday(), user.getReceiver(), user.getRaddress(), user.getRtelephone());
        return i;
    }
}
