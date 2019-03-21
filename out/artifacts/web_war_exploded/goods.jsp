<%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/11/2 0002
  Time: 18:15
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
    <title>商品</title>
</head>
<body>
    <table id="goodstable">
        <thead>
            <tr>
                <th class="th-style" style="font-family: 方正舒体;font-size: 30px">商品图片</th>
                <th class="th-style" style="font-family: 方正舒体;font-size: 30px">商品信息</th>
                <th class="th-style" style="font-family: 方正舒体;font-size: 30px">操作</th>
            </tr>
        </thead>
        <tbody id="data-content"class="th-style">

        </tbody>
    </table>
    <input type="hidden" name="current">
    <input type="hidden" name="pageNum">

    <p style="text-align: right">
        <button type="button" class="btn btn-success" onclick="pre()">上一页</button>&nbsp&nbsp&nbsp&nbsp
        <button type="button" class="btn btn-success" onclick="next()">下一页</button>
    </p>
    <script>
        $(function () {
            fun(1)
        })
        function pre() {
            var n = $("input[name='current']").val();
            if(n == 1){
                fun(1)
            }else{
                fun(n-1)
            }
        }
        function next() {
            var n = $("input[name='current']").val();
            var pagenum = $("input[name='pageNum']").val();
            if(n == pagenum){
                fun(n);
            }else{
                fun(parseInt(n)+1)
            }
        }
        function fun(n){
            $.ajax({
                url:"show.goods",
                data:{"n":n},
                dataType:"json",
                success:function (result) {
                    var str = "";
                    console.log(result)
                    $(result.content).each(function () {
                        str += "<tr>" +
                            "<td><img src= 'onload/"+this.gphoto+"' style='width: 300px;height: 200px'/></td>" +
                            "<td><h3>"+"商品名："+this.gname+"</h3><br/>"
                            +"商品价格："+this.gprice+"<br/>"
                            +"商品库存量："+this.grepertory+"<br/>"
                            +"商品销售量："+this.gsalevolume+"<br/>"
                            +"商品规格："+this.gstandard+"<br/>"
                            +"商品说明："+this.gremarks+"</td>"+"<td>"+
                            "<button type='button' class='btn btn-success' onclick='addGoods(\""+this.gname+"\")'><i class='fa fa-shopping-basket'></i>加入菜篮</button>"+
                            "</td></tr>"
                    })
                    $("#data-content").html(str);
                    $("input[name='current']").val(result.currentPage)
                    $("input[name='pageNum']").val(result.pageNum)
                }
            })
        }
        function addGoods(gname) {
            window.location.href="addgoods.cart?gname="+gname;
        }
    </script>
</body>
</html>
