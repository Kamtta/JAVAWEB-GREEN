<%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/11/6 0006
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询商品</title>
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
    <tr style="font-family: 方正舒体;font-size: 20px;">
        <th>商品序号</th>
        <th>商品名</th>
        <th>商品价格</th>
        <th>商品存量</th>
        <th>商品销售量</th>
        <th>商品规格</th>
        <th>商品照片</th>
        <th>商品说明</th>
        <th>商品类型</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="data-content">

    </tbody>
</table>
<script>
    $(function () {
        var gname = '<%= request.getParameter("search")%>'
        fun(gname);
    })
    function fun(gname) {
        $.ajax({
            url:"search.goods",
            data:{"gname":gname},
            dataType:"json",
            success:function (result) {
                var str = "";
                $(result).each(function () {
                    str += "<tr>\n" +
                        "            <td>"+this.gid+"</td>\n" +
                        "            <td>"+this.gname+"</td>\n" +
                        "            <td>"+this.gprice+"</td>\n" +
                        "            <td>"+this.grepertory+"</td>\n" +
                        "            <td>"+this.gsalevolume+"</td>\n" +
                        "            <td>"+this.gstandard+"</td>\n" +
                        "            <td><img src='onload/"+this.gphoto+"' style=\"width:80px;height: 50px\"/></td>\n" +
                        "            <td>"+this.gremarks+"</td>\n" +
                        "            <td>"+this.tname+"</td>\n" +
                        "            <td>\n" +
                        "                <div class=\"dropdown\">\n" +
                        "                    <button type=\"button\" class=\"btn btn-success dropdown-toggle\" data-toggle=\"dropdown\">\n" +
                        "                        <i class=\"fa fa-cogs\"></i>\n" +
                        "                    </button>\n" +
                        "                    <div class=\"dropdown-menu\">\n" +
                        "                        <a class=\"dropdown-item\" href=\""+"delete.goods?gname="+this.gname+"\">删除</a>\n" +
                        "                        <a class=\"dropdown-item\" href=\""+"updategoods.jsp?gname="+this.gname+"\">修改</a>\n" +
                        "                    </div>\n" +
                        "                </div>\n" +
                        "            </td>\n" +
                        "        </tr>"
                })
                $("#data-content").html(str)
            }
        })
    }
</script>
</body>
</html>
