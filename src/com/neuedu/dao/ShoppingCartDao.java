package com.neuedu.dao;

import com.neuedu.bean.Goods;
import com.neuedu.bean.ShoppingCart;

import java.util.List;

public interface ShoppingCartDao {
    /**
     * 添加商品
     * @param goods
     * @return
     */
    int addGoods(Goods goods);

    /**
     * 删除菜篮选项
     * @param gname
     * @return
     */
    int delete(String gname);

    /**
     * 查询菜篮中所有的商品
     * @return
     */
    List<ShoppingCart> selectAll();

    /**
     * 通过商品名进行寻找
     * @param gname
     * @return
     */
    ShoppingCart selectByGname(String gname);

    /**
     * 更新shoppingcart
     * @param shoppingCart
     * @return
     */
    int update(ShoppingCart shoppingCart);
}
