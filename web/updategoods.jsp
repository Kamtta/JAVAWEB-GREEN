<%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/11/5 0005
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新商品</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>
    <link rel="stylesheet" href="css/font-awesome.css">
    <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" language="JavaScript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/popper.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
    <div style="width: 600px;height: 750px;color: green;margin: 0px;padding: 10px;border: none;">
        <form action="update.goods" method="post" enctype="multipart/form-data">
            <input type="hidden" id="gname" name="gname">
            <div class="form-group">
                <label for="gprice">商品价格:</label>
                <input type="number" class="form-control" id="gprice" name="gprice">
            </div>
            <div class="form-group">
                <label for="grepertory">商品存量:</label>
                <input type="number" class="form-control" id="grepertory" name="grepertory">
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
    <script>
        $(function () {
            var gname = '<%= request.getParameter("gname")%>';
            intial(gname);
        })
        function intial(gname) {
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
            $.ajax({
                url:"select.goods",
                data:{"gname":gname},
                dataType:"json",
                success:function (result) {
                    console.log(result)
                    $("input[id='gprice']").val(result.gprice);
                    $("input[id='grepertory']").val(result.grepertory);
                    $("input[id='gstandard']").val(result.gstandard);
                    $("#gremarks").val(result.gremarks);
                    $("#gname").val(gname)
                }
            })
        }
    </script>
</body>
</html>
