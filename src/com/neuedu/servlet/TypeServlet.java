package com.neuedu.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.bean.Type;
import com.neuedu.dao.TypeDao;
import com.neuedu.impl.TypeDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@WebServlet("*.type")
public class TypeServlet extends HttpServlet {
    private TypeDao typeDao = new TypeDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String path = null;
        if(uri.lastIndexOf("/") > -1 && uri.indexOf(".")>-1){
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
    public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Type> list = new ArrayList<>();
        list = typeDao.selectAll();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        resp.getWriter().write(json);
    }
}
