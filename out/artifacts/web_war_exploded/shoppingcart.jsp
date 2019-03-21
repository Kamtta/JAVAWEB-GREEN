<%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/11/5 0005
  Time: 18:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>菜篮</title>
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
        <th>商品图片</th>
        <th>商品名</th>
        <th>商品价格</th>
        <th>数量</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody id="data-content">

    </tbody>
</table>
<p style="height: 38px;width: 100%;position: fixed;bottom: 0;margin:0px ;border-top: 1px solid green;background-color: white;padding: 0;display: flex">
    <label style="color: green;font-size: 16px;margin-top: 10px">总价为：</label><span id="sumshow"></span>
    <button type="button" class="btn btn-success" onclick="uploadOrder()" style="position: fixed;bottom: 0;right: 0">提交订单</button>
</p>
<script>
    $(function () {
        $.ajax({
            url:"show.cart",
            dataType:"json",
            success:function (result) {
                var str = "";
                var sum = 0;
                var temp = "";
                $(result).each(function () {
                    str += "<tr><td><img src='onload/"+this.gphoto+"' style=\"width:80px;height: 50px\"></td>"+
                        "<td>"+this.gname+"</td>"+
                        "<td>"+this.gprice+"</td>"+
                        "<td>"+this.num+"</td>"+
                        "<td><button type='button' class='btn btn-success' onclick='deleteGoods(\""+this.gname+"\")'>删除</button></td>"+"</tr>"
                    sum += this.gprice * this.num;
                })
                temp += "<h5 style='color: green;margin-top: 10px'>"+sum+"</h5>"
                $("#data-content").html(str)
                $("#sumshow").html(temp)
            }
        })
    })
    function deleteGoods(gname) {
        window.location.href = "deleteGoods.cart?gname="+gname;
    }
    function uploadOrder() {
        window.location.href = "addOrder.order";
    }
</script>
</body>
</html>
