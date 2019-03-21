package com.neuedu.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.bean.Goods;
import com.neuedu.bean.Order;
import com.neuedu.bean.ShoppingCart;
import com.neuedu.bean.User;
import com.neuedu.dao.GoodsDao;
import com.neuedu.dao.OrderDao;
import com.neuedu.dao.ShoppingCartDao;
import com.neuedu.impl.GoodsDaoImpl;
import com.neuedu.impl.OrderDaoImpl;
import com.neuedu.impl.ShoppingCartDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;

@WebServlet("*.order")
public class OrderServlet extends HttpServlet {
    private ShoppingCartDao shoppingCartDao = new ShoppingCartDaoImpl();
    private OrderDao orderDao = new OrderDaoImpl();
    private GoodsDao goodsDao = new GoodsDaoImpl();
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
    public void addOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<ShoppingCart> list = shoppingCartDao.selectAll();
        if(list == null){
            resp.sendRedirect("shoppingcart.jsp");
        }
        for (int i = 0; i < list.size();i++){
            Order order = new Order();
            ShoppingCart shoppingCart = list.get(i);
            HttpSession session = req.getSession();
            User user = (User) session.getAttribute("user");
            Goods goods = goodsDao.select(shoppingCart.getGname());
            order.setGid(goods.getGid());
            order.setGnum(shoppingCart.getNum());
            order.setGphoto(goods.getGphoto());
            order.setoNum(String.valueOf(goods.getGname().hashCode()+goods.getGid()));
            order.setOcreatedate(new Date(System.currentTimeMillis()));
            order.setUid(user.getUid());
            orderDao.addOrder(order);
        }
        for (int i = 0;i<list.size();i++){
            shoppingCartDao.delete(list.get(i).getGname());
        }
        resp.sendRedirect("order.jsp");
    }
    public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> list = orderDao.selectAll();
        if(list == null){
            return;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        resp.getWriter().write(json);
    }
    public void selectByuid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        List<Order> list = orderDao.selectByUid(user.getUid());
        if(list == null){
            return;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        resp.getWriter().write(json);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int oid = Integer.valueOf(req.getParameter("oid"));

        orderDao.delete(oid);
        resp.sendRedirect("ordermanage.jsp");
    }
}
