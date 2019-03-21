<%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/11/6 0006
  Time: 19:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" language="JavaScript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/popper.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
<table class="table back">
    <thead>
    <tr style="font-family: 方正舒体;font-size: 25px;">
        <th>账号</th>
        <th>密码</th>
        <th>生日</th>
        <th>收货人</th>
        <th>收货人电话</th>
        <th>收货地址</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="data-content">

    </tbody>
</table>
<script>
    $(function () {
        var uname = '<%= request.getParameter("search")%>'
        fun(uname);
    })
    function fun(uname) {
        $.ajax({
            url:"search.user",
            data:{"uname":uname},
            dataType:"json",
            success:function (result) {
                var str = "";
                $(result).each(function () {
                    var date = new Date(this.ubirthday);
                    date = date.toLocaleDateString();
                    str += "<tr><td>"+this.uname+"</td>"+
                        "<td>"+this.upwd+"</td>"+
                        "<td>"+date+"</td>"+"<td>"+this.receiver+"</td>"
                        +"<td>"+this.rtelephone+"</td>"
                        +"<td>"+this.raddress+"</td>"+
                        "<td>" +
                    "                <div class=\"dropdown\">\n" +
                    "                    <button type=\"button\" class=\"btn btn-success dropdown-toggle\" data-toggle=\"dropdown\">\n" +
                    "                        <i class=\"fa fa-cogs\"></i>\n" +
                    "                    </button>\n" +
                    "                    <div class=\"dropdown-menu\">\n" +
                    "                        <a class=\"dropdown-item\" href=\""+"delete.user?uname="+this.uname+"\" style='color: green'>删除</a>\n" +
                    "                        <a class=\"dropdown-item\" href=\""+"update.jsp?uname="+this.uname+"\" style='color: green'>修改</a>\n" +
                    "                    </div>\n" +
                    "                </div>\n" +
                    "            </td>"+"</tr>"
                })
                $("#data-content").html(str)
            }
        })
    }
</script>
</body>
</html>
