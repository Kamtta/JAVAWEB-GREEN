<%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/11/6 0006
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单</title>
    <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" media="screen" />
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" language="JavaScript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
<table class="table back">
    <thead>
    <tr style="font-family: 方正舒体;font-size: 20px;">
        <th>订单号</th>
        <th>商品图片</th>
        <th>商品数量</th>
        <th>订单创建时间</th>
    </tr>
    </thead>
    <tbody id="data-content">

    </tbody>
</table>
<script>
    $(function () {
        $.ajax({
            url:"selectByuid.order",
            dataType:"json",
            success:function (result) {
                var str = "";
                $(result).each(function () {
                    var date = new Date(this.ocreatedate);
                    date = date.toLocaleDateString()
                    str += "<tr><td>"+this.oNum+"</td>"+
                        "<td><img src='onload/"+this.gphoto+"' style=\"width:80px;height: 50px\"></td>"+
                        "<td>"+this.gnum+"</td>"
                        +"<td>"+date+"</td>"+"</tr>"
                })
                $("#data-content").html(str)
            }
        })
    })
</script>
</body>
</html>
