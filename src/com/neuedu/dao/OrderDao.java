package com.neuedu.dao;

import com.neuedu.bean.Order;

import java.util.List;

public interface OrderDao {
    /**
     * 创建一项订单
     * @param order
     * @return
     */
    int addOrder(Order order);

    /**
     * 查询所有的订单
     * @return
     */
    List<Order> selectAll();

    /**
     * 根据oid进行删除
     * @param oid
     * @return
     */
    int delete(int oid);

    /**
     * 通过UID进行查询
     * @param uid
     * @return
     */
    List<Order> selectByUid(int uid);
}
