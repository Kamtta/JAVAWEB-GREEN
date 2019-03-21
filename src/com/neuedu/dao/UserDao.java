package com.neuedu.dao;

import com.neuedu.bean.User;

import java.util.List;

public interface UserDao {
    /**
     * 计算level中的总条数
     * @param rlevel
     * @return
     */
    int sumCount(int rlevel);

    /**
     * 找出对应等级的相应信息
     * @param rlevel
     * @param offset
     * @param num
     * @return
     */
    List findContent(int rlevel,int offset,int num);
    /**
     * 根据rlevel进行查询，0为普通用户，1为VIP，2为管理员
     * */
    List<User> selectByRlevel(int rlevel);

    /**
     * 根据用户名和level进行查询
     * @param uname
     * @return
     */
    List<User> selectByUname(String uname,int rlevel);

    /**
     * 根据用户名进行查询
     * @param uname
     * @return
     */
    User selectByName(String uname);
    /**
     * 添加管理员
     */
    int insertAdmin(User user);

    /**
     * 根据账号进行删除
     * 对ifdelete进行修改
     * @param uname
     * @return
     */
    int deleteAdmin(String uname);

    /**
     * 根据账号进行更新
     * @param user
     * @return
     */
    int updateAdmin(User user);

    /**
     * 添加用户
     * @param user
     * @return
     */
    int insertUser(User user);
}
