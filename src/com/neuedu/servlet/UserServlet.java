package com.neuedu.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.neuedu.bean.Page;
import com.neuedu.bean.User;
import com.neuedu.dao.UserDao;
import com.neuedu.impl.UserDaoImpl;
import com.neuedu.util.UpdateQuery;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.List;

@WebServlet("*.user")
public class UserServlet extends HttpServlet {
    private static UserDao userDao = new UserDaoImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        从*.user中获取相应的方法名，从而调用相关的方法
        String uri = req.getRequestURI();
        String path = null;
        if(uri.lastIndexOf("/") > -1 && uri.indexOf(".") >-1){
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
    public void vip(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String n = req.getParameter("n");
        int pagen = -1;
        if(n == null){
            pagen = 1;
        }else {
            pagen = Integer.parseInt(n);
        }
        Page page = new Page();
        page.setCount(userDao.sumCount(1));
        page.setCurrentPage(pagen);
        page.setContent(userDao.findContent(1,(pagen-1)*page.getPageCount(),page.getPageCount()));
//        使用json进行传输数据
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(page);
        resp.getWriter().write(json);
    }
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        int i = userDao.deleteAdmin(uname);
        if(i == 1){
            req.getRequestDispatcher("user.jsp").forward(req,resp);
        }
    }
    public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        List<User> list = userDao.selectByUname(uname,1);
        User user = list.get(0);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        resp.getWriter().write(json);
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
        String uname = req.getParameter("uname");
        List<User> list = userDao.selectByUname(uname,1);
        User user = list.get(0);
        user.setUpwd(req.getParameter("upwd"));
        if(req.getParameter("ubirthday") != "" && req.getParameter("ubirthday") != null){
            user.setUbirthday(DateFormat.getDateInstance().parse(req.getParameter("ubirthday")));
        }
        user.setReceiver(req.getParameter("receiver"));
        user.setRtelephone(req.getParameter("rtelephone"));
        user.setRaddress(req.getParameter("raddress"));
        userDao.updateAdmin(user);
        if(user.getRlevel() == 1){
            req.getRequestDispatcher("welcomeuser.jsp").forward(req,resp);
        }
        if(user.getRlevel() == 2){
            req.getRequestDispatcher("user.jsp").forward(req,resp);
        }
    }
    public void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        String usex = req.getParameter("usex");
        System.out.println(usex);
        String ubirthday = req.getParameter("ubirthday");
        String receiver = req.getParameter("receiver");
        String raddress = req.getParameter("raddress");
        String rtelephone = req.getParameter("rtelephone");
        User user = new User();
        user.setUname(uname);
        user.setUpwd(upwd);
        user.setRaddress(raddress);
        user.setRtelephone(rtelephone);
        user.setReceiver(receiver);
        user.setUbirthday(DateFormat.getDateInstance().parse(ubirthday));
        user.setUsex(Integer.valueOf(usex));
        userDao.insertUser(user);
        resp.sendRedirect("login.jsp");
    }
    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("telephone");
        String password = req.getParameter("password");
        User user = userDao.selectByName(username);
        if(user == null){
            req.getRequestDispatcher("login.jsp").forward(req,resp);

        }else {
            if(user.getUpwd().equals(password)){
                if(user.getRlevel() == 2){
                    req.setAttribute("uname",username);
                    req.getRequestDispatcher("main.jsp").forward(req,resp);
                    HttpSession session = req.getSession();
                    session.setAttribute("userManager",user);
                }
                if(user.getRlevel() == 1){
                    req.setAttribute("uname",username);
                    HttpSession session = req.getSession();
                    session.setAttribute("user",user);
                    req.getRequestDispatcher("usermain.jsp").forward(req,resp);
                }
            }else{
                resp.sendRedirect("login.jsp");
            }
        }
    }
    public void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("uname");
        List<User> list = userDao.selectByUname(uname,1);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(list);
        resp.getWriter().write(json);
    }
}
