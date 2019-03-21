package com.neuedu.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.neuedu.bean.Goods;
import com.neuedu.bean.Page;
import com.neuedu.dao.GoodsDao;
import com.neuedu.impl.GoodsDaoImpl;
import com.neuedu.util.ImgUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("*.goods")
@MultipartConfig
public class GoodsServlet extends HttpServlet {
    private GoodsDao goodsDao = new GoodsDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String path = null;
        if(uri.lastIndexOf("/") > -1&& uri.indexOf(".")>-1){
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
    public void show(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String n = req.getParameter("n");
        int pagen = -1;
        if(n == null){
            pagen = 1;
        }else {
            pagen = Integer.parseInt(n);
        }
        Page page = new Page();
        page.setCount(goodsDao.sumCount());
        page.setCurrentPage(pagen);
        page.setContent(goodsDao.findContent((pagen-1)*page.getPageCount(),page.getPageCount()));
//        使用json进行传输数据
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(page);
        resp.getWriter().write(json);
    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取servlet服务器的路径
        String servletPath = req.getServletContext().getRealPath("/")+"onload\\";
//        获取图片对象
        Part part = req.getPart("gphoto");
        String path = ImgUtil.imgControl(part,servletPath);
        Goods goods = new Goods();
        goods.setGphoto(path);
        goods.setTName(req.getParameter("tname"));
        goods.setGstandard(req.getParameter("gstandard"));
        goods.setGsalevolume(Integer.valueOf(req.getParameter("gsalevolume")));
        goods.setGrepertory(Integer.valueOf(req.getParameter("grepertory")));
        goods.setGremarks(req.getParameter("gremarks"));
        goods.setGprice(Integer.valueOf(req.getParameter("gprice")));
        goods.setGname(req.getParameter("gname"));
        goodsDao.addGoods(goods);
        resp.sendRedirect("managegoods.jsp");
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int gid = Integer.valueOf(req.getParameter("gid"));
        goodsDao.deletegoods(gid);
        resp.sendRedirect("managegoods.jsp");
    }
    public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gname = req.getParameter("gname");
        Goods goods = goodsDao.select(gname);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(goods);
        resp.getWriter().write(json);
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Goods goods = goodsDao.select(req.getParameter("gname"));
        goods.setGprice(Double.valueOf(req.getParameter("gprice")));
        goods.setGrepertory(Integer.valueOf(req.getParameter("grepertory")));
        goods.setGremarks(req.getParameter("gremarks"));
        String servletPath = req.getServletContext().getRealPath("/")+"onload\\";
//        获取图片对象
        Part part = req.getPart("gphoto");
        if(part.getSize() != 0){
            String path = ImgUtil.imgControl(part,servletPath);
            goods.setGphoto(path);
        }
        goods.setGstandard(req.getParameter("gstandard"));
        goods.setTName(req.getParameter("tname"));
        goodsDao.updategoods(goods);
        resp.sendRedirect("managegoods.jsp");
    }
    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gname = req.getParameter("gname");
        List<Goods> list = goodsDao.selectAll(gname);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        resp.getWriter().write(json);
    }
}
