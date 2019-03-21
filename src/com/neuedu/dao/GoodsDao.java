package com.neuedu.dao;



import com.neuedu.bean.Goods;

import java.util.List;

public interface GoodsDao {
    /**
     * 计算level中的总条数
     * @return
     */
    int sumCount();

    /**
     * 找出对应等级的相应信息
     * @param offset
     * @param num
     * @return
     */
    List findContent(int offset, int num);

    /**
     * 添加商品
     * @param goods
     * @return
     */
    int addGoods(Goods goods);

    /**
     * 删除商品
     * @param gid
     * @return
     */
    int deletegoods(int gid);

    /**
     * 更新商品
     * @param goods
     * @return
     */
    int updategoods(Goods goods);

    /**
     * 根据商品名进行查询
     * @param gid
     * @return
     */
    Goods select(String gname);

    /**
     * 根据商品名进行查询
     * @param gname
     * @return
     */
    List<Goods> selectAll(String gname);
}
