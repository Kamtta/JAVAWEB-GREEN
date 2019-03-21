<%--
  Created by IntelliJ IDEA.
  User: cjr
  Date: 2018/11/2 0002
  Time: 08:26
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
    <title>更新</title>
</head>
<body>
    <form action="update.user" method="post" style="margin-top: 30px">
        <input type="hidden" name="uname" id="uname">
        <div class="form-group">
            <label for="upwd">密码:</label>
            <input type="text" class="form-control" id="upwd" name="upwd">
        </div>
        <div class="form-group">
            <label for="ubirthday">生日:</label>
            <input type="date" class="form-control" id="ubirthday" name="ubirthday">
        </div>
        <div class="form-group">
            <label for="receiver">收货人:</label>
            <input type="text" class="form-control" id="receiver" name="receiver">
        </div>
        <div class="form-group">
            <label for="raddress">地址:</label>
            <input type="text" class="form-control" id="raddress" name="raddress">
        </div>
        <div class="form-group">
            <label for="rtelephone">收货人电话:</label>
            <input type="text" class="form-control" id="rtelephone" name="rtelephone">
        </div>
        <button type="submit" class="btn btn-success">提交</button>
    </form>
    <script>
        $(function() {
            var uname = <%= request.getParameter("uname")%>
            fun(uname)
        })
        function fun(uname) {
            $.ajax({
                url:"select.user",
                data:{"uname":uname},
                dataType:"json",
                success:function (result) {
                    $("input[id='uname']").val(result.uname)
                    $("input[id='upwd']").val(result.upwd)
                    $("input[id='ubirthday']").val(result.ubirthday)
                    $("input[id='receiver']").val(result.receiver)
                    $("input[id='rtelephone']").val(result.rtelephone)
                    $("input[id='raddress']").val(result.raddress)
                }
            })
        }
    </script>
</body>
</html>
