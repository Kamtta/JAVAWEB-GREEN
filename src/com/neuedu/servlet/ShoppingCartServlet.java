package com.neuedu.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.bean.Goods;
import com.neuedu.bean.ShoppingCart;
import com.neuedu.dao.GoodsDao;
import com.neuedu.dao.ShoppingCartDao;
import com.neuedu.impl.GoodsDaoImpl;
import com.neuedu.impl.ShoppingCartDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("*.cart")
public class ShoppingCartServlet extends HttpServlet {
    private GoodsDao goodsDao = new GoodsDaoImpl();
    private ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String path = null;
        if(uri.lastIndexOf("/") > -1 && uri.indexOf(".") > -1){
            path = uri.substring(uri.lastIndexOf("/")+1,uri.indexOf("."));
        }
        try {
            Method method = this.getClass().getMethod(path,HttpServletRequest.class,HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
    public void addgoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Goods goods = goodsDao.select(req.getParameter("gname"));
        if(shoppingCartDao.selectByGname(goods.getGname()) == null){
            shoppingCartDao.addGoods(goods);
        }else {
            ShoppingCart shoppingCart = shoppingCartDao.selectByGname(goods.getGname());
            shoppingCart.setNum(shoppingCart.getNum()+1);
            shoppingCartDao.update(shoppingCart);
        }
        resp.sendRedirect("goods.jsp");
    }
    public void deleteGoods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gname = req.getParameter("gname");
        shoppingCartDao.delete(gname);
        resp.sendRedirect("shoppingcart.jsp");
    }
    public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ShoppingCart> list = shoppingCartDao.selectAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        resp.getWriter().write(json);
    }
}
