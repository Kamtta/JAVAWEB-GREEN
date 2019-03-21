<%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/11/6 0006
  Time: 22:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单管理</title>
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
        <th>订单号</th>
        <th>商品图片</th>
        <th>用户id</th>
        <th>商品id</th>
        <th>商品数量</th>
        <th>提交时间</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="data-content">

    </tbody>
</table>
<script>
    $(function () {
        $.ajax({
            url:"select.order",
            dataType:"json",
            success:function (result) {
                var str = "";
                $(result).each(function () {
                    var date = new Date(this.ocreatedate);
                    date = date.toLocaleDateString();
                    str += " <tr>\n" +
                        "            <td>"+this.oNum+"</td>\n" +
                        "            <td><img src='onload/"+this.gphoto+"' style=\"width:80px;height: 50px\"></td>\n" +
                        "            <td>"+this.uid+"</td>\n" +
                        "            <td>"+this.gid+"</td>\n" +
                        "            <td>"+this.gnum+"</td>\n" +
                        "            <td>"+date+"</td>\n" +
                        "            <td><button type='button' class='btn btn-success' onclick='deleteorder(\""+this.oid+"\")'>删除</button></td>\n" +
                        "        </tr>"
                })
                $("#data-content").html(str)
            }
        })
    })
    function deleteorder(oid) {
        window.location.href = "delete.order?oid="+oid;
    }
</script>
</body>
</html>
