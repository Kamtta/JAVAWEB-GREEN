<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录界面</title>
      <link rel="shortcut icon" type="image/x-icon" href="favicon.ico" media="screen" />
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css"/>
      <link rel="stylesheet" href="css/font-awesome.css">
      <link rel="stylesheet" href="css/style.css">
    <script type="text/javascript" language="JavaScript" src="js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
  </head>
  <body  onload="document.getElementById('telephone').focus();getCookies();" style="background: url('img/loginImg.jpg') no-repeat left center;">
        <img src="img/logo.jpg" alt="logo" style="width: 100px;height: 100px;position: fixed;top: 0;right: 0;border-radius: 50%;box-shadow: 2px 4px 4px;">
      <div class="login-content">
            <div class="shop-title">
                <h2>Login In</h2>
            </div>
            <div>
                <form action="login.user" method="post">
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">
                                <i class="fa fa-phone-square"></i>
                            </span>
                        </div>
                        <input type="text" id="telephone" class="form-control" name="telephone" placeholder="telephone">
                    </div>
                    <div class="input-group mb-3">
                        <div class="input-group-prepend">
                            <span class="input-group-text">
                                <i class="fa fa-key"></i>
                            </span>
                        </div>
                        <input type="password" id="password" class="form-control" name="password" placeholder="password">
                    </div>
                    <div class="form-check">
                        <label class="form-check-label">
                            <input type="checkbox" class="form-check-input" id="rememberPwd">记住密码
                        </label>
                    </div>
                    <div class="btn-style" >
                        <button type="submit" class="btn btn-outline-success" onclick="checkInCorrect()">登录</button>
                        &nbsp&nbsp&nbsp&nbsp&nbsp
                        <button class="btn btn-outline-info" onclick="window.open('register.jsp')">注册</button>
                        <%--<script></script>--%>
                    </div>
                </form>

            </div>
      </div>
        <script language="JavaScript" type="text/javascript">
            function checkInCorrect() {
                if( "" == $("input[id='telephone']").val()){
                    alert("请输入账号")
                    document.getElementById("telephone").focus()
                    return false
                }
                if("" == $("input[id='password']").val()){
                    alert("请输入密码")
                    document.getElementById("password").focus()
                    return false
                }
                else{
                    saveInfo();
                    return true;
                }
            }
            saveInfo = function () {
                try{
                    var issave = document.getElementById("rememberPwd").checked;
                    if(issave){
                        var username = $("input[id='telephone']").val();
                        var password = $("input[id='password']").val();
                        if(username != "" && password !=""){
                            setCookies(username,password);
                        }
                    }else{
                        setCookies("","");
                    }
                }catch (e) {
                    e.print()
                }
            }
            function setCookies(username,password) {
                var date = new Date();
                date.setTime(date.getTime()+1866240000000);
                document.cookie = "username=" + username + "%%" + password + ";expires"+date.toTimeString()
            }
            function getCookies(){
                var username;
                var password;
                var index;
                var cookiesString = new String(document.cookie)
                var cookieHeader = "username=";
                var begin = cookiesString.indexOf(cookieHeader);
                var end = cookiesString.indexOf(";");
                cookiesString = cookiesString.substring(begin);
                if(end != -1){
                    cookiesString = cookiesString.substring(0,end);
                }
                if(begin > -1){
                    index = cookiesString.substring(cookieHeader.length)
                    if(index != ""){
                        begin = index.indexOf("%%");
                        username = index.substring(0,begin);
                        password = index.substring(begin+2);
                        $("input[id='telephone']").val(username)
                        $("input[id='password']").val(password)
                        if(username != "" && password != ""){
                            document.getElementById("rememberPwd").checked = true;
                        }
                    }
                }
            }

        </script>
  </body>
</html>