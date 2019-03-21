<%@ page import="com.neuedu.bean.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/11/4 0004
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户主界面</title>
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" media="screen" />
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" language="JavaScript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body style="display: flex">
    <img src="img/logo.jpg" alt="logo" style="width: 100px;height: 100px;position: fixed;top: 0;right: 0;border-radius: 50%;box-shadow: 2px 4px 4px;">
    <a href="login.jsp" style="text-decoration: none;color: green;position: fixed;top: 100px;right: 25px;"><div style="position:absolute;right: 0px;top:10px;"><i class="fa fa-times"></i>退出</div></a>
    <div class="col-2" style="background-color: green;height: 100%;">
        <div style="padding: 10px">
            <img src="img/user.jpg" style="width: 80px;height: 80px;border-radius: 50%;box-shadow: 2px 4px 4px;">
            <p style="color: white;font-family: 方正舒体;font-size: 20px;margin-top: 10px">欢迎用户：<%= request.getAttribute("uname").toString()%></p>
            <p style="color: white;font-family: 方正舒体;font-size: 20px;margin-top: 10px">登录时间：<%= new Date(System.currentTimeMillis())%></p>
        </div>
        <div class="container" style="margin-top: 50px">
            <ul class="list-group">
                <li class="list-group-item">
                    <a href="goods.jsp" target="data-content" style="font-family: 方正舒体;font-size: 25px;color: darkgreen;text-decoration: none;margin: auto auto">菜市场</a>
                </li>
                <li class="list-group-item">
                    <a href="shoppingcart.jsp" target="data-content" style="font-family: 方正舒体;font-size: 25px;color: darkgreen;text-decoration: none;margin: auto auto">菜篮</a>
                </li>
                <li class="list-group-item">
                    <a href="order.jsp" target="data-content" style="font-family: 方正舒体;font-size: 25px;color: darkgreen;text-decoration: none;margin: auto auto">订单管理</a>
                </li>
                <li class="list-group-item">
                    <a href="update.jsp?uname=<%= ((User)request.getSession().getAttribute("user")).getUname()%>" target="data-content" style="font-family: 方正舒体;font-size: 25px;color: darkgreen;text-decoration: none;margin: auto auto">修改个人信息</a>
                </li>
            </ul>
        </div>
    </div>
    <div class="store-style col-10">
        <div style="height: 100px;text-align: center;line-height: 100px;border: 1px solid green;">
            <h1 style="color: darkgreen;font-family: 方正舒体;font-size: 50px">WELCOME TO 绿蔬人 </h1>
        </div>
        <iframe src="welcomeuser.jsp" frameborder="0" name="data-content" id="framework"></iframe>
    </div>
    <div class="foot">
        <p>@CopyRight; CJR制作，公司：东软
            电话：15822869305</p>
    </div>
</body>
</html>
