<%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/11/2 0002
  Time: 19:52
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
    <title>添加商品</title>
</head>
<body>
    <img src="img/logo.jpg" alt="logo" style="width: 100px;height: 100px;position: fixed;top: 0;right: 0;border-radius: 50%;box-shadow: 2px 4px 4px;">
    <div style="display: flex">
        <img src="img/style.jpg" style="width: 450px;height: 400px;position: fixed;left: 0;top: 150px">
        <div style="width: 600px;height: 850px;;color: green;margin: 50px auto;padding: 10px;border: none;">
            <form action="add.goods" method="post" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="gname">商品名:</label>
                    <input type="text" class="form-control" id="gname" name="gname">
                </div>
                <div class="form-group">
                    <label for="gprice">商品价格:</label>
                    <input type="number" class="form-control" id="gprice" name="gprice">
                </div>
                <div class="form-group">
                    <label for="grepertory">商品存量:</label>
                    <input type="number" class="form-control" id="grepertory" name="grepertory">
                </div>
                <div class="form-group">
                    <label for="gsalevolume">商品销售量:</label>
                    <input type="number" class="form-control" id="gsalevolume" name="gsalevolume">
                </div>
                <div class="form-group">
                    <label for="gstandard">商品规格:</label>
                    <input type="text" class="form-control" id="gstandard" name="gstandard">
                </div>
                <div class="form-group">
                    <label for="gphoto">商品照片:</label>
                    <input type="file" class="form-control" id="gphoto" name="gphoto" style="color: white;background-color: green">
                </div>
                <div class="form-group">
                    <label for="gremarks">商品说明:</label>
                    <div class="form-group">
                        <textarea class="form-control" rows="5" id="gremarks" name="gremarks"></textarea>
                    </div>
                </div>
                <div class="form-group">
                    <label for="tname">商品型号:</label>
                    <select class="form-control" id="tname" name="tname">

                    </select>
                </div>
                <button type="submit" class="btn btn-success" style="width: 100px;">提交</button>
            </form>
        </div>
        <div style="display: flex;flex-direction: column;font-family: 方正舒体;color: green;font-size: 60px;position: fixed;right: 50px;top: 200px">
            <p>ADD</p>
           <p> &nbsp&nbsp&nbsp&nbspGOODS</p>
        </div>
    </div>
    <script>
        $(function () {
            $.ajax({
                url:"select.type",
                dataType:"json",
                success:function (result) {
                    var str = "";
                    $(result).each(function () {
                        str += "<option>"+this.tname+"</option>";
                    })
                    $("#tname").html(str);
                }
            })
        })
    </script>
</body>
</html>
