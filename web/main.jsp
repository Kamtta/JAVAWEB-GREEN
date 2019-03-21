<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/10/30 0030
  Time: 20:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" language="JavaScript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/popper.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <title>主界面</title>
</head>
<body>
    <div class="page-content">
        <div id="left" class="col-2">
            <div id="tit-style">
                <i class="fa fa-user-secret fa-4x"></i>
                <p style="color: white;font-family: 方正舒体;font-size: 20px;margin-top: 10px">欢迎管理员：<%= request.getAttribute("uname").toString()%></p>
                <p style="color: white;font-family: 方正舒体;font-size: 20px;margin-top: 10px">登录时间：<%= new Date(System.currentTimeMillis())%></p>
            </div>
            <nav class="navbar ">
                <!-- Links -->
                <ul class="ul-style" >
                    <li class="nav-item">
                        <a class="nav-link" href="user.jsp" target="content" style="color: green"><i class="fa fa-users fa-2x"></i>&nbsp;&nbsp;用户管理</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="managegoods.jsp" target="content" style="color: green"><i class="fa fa-shopping-bag fa-2x"></i>&nbsp;&nbsp;商品管理</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="ordermanage.jsp"  style="color: green" target="content"><i class="fa fa-book fa-2x"></i>&nbsp;&nbsp;订单管理</a>
                    </li>
                    <li class="nav-item" id="li-end">
                        <a class="nav-link" href="#"  style="color: green"><i class="fa fa-pagelines fa-2x"></i>&nbsp;&nbsp;报表管理</a>
                    </li>
                </ul>

            </nav>
        </div>
        <div class="col-10" style="width: 100%;margin: 0;">
            <div class="col-12">
                <h1 style="color: darkgreen;font-family: 方正舒体;font-size: 50px">WELCOME 绿蔬人管家</h1>
                <a href="login.jsp" style="text-decoration: none;color: green"><div style="position:absolute;right: 0px;top:10px;"><i class="fa fa-times"></i>退出</div></a>
            </div>
            <div id="ifr-style">
                <iframe name="content" class="framestyle" src="welcome.jsp"></iframe>
            </div>
            <div class="foot">
                <p>@CopyRight; CJR制作，公司：东软
                    电话：15822869305</p>
            </div>
        </div>
    </div>
</body>
</html>
