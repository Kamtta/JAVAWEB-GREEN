package com.neuedu.dao;

import com.neuedu.bean.Type;

import java.util.List;

public interface TypeDao {
    /**
     * 查询所有的类型
     * @return
     */
    List<Type> selectAll();
}
