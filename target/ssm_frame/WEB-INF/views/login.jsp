<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%--<html>--%>
<%--<script src="../js/jquery-3.2.1.js"></script>--%>
<%--<head>--%>
<%--    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">--%>
<%--    <title>登录界面</title>--%>
<%--</head>--%>
<%--<body >--%>

<%--    <table>--%>
<%--        <tr>--%>
<%--            <td>用户名:</td>--%>
<%--            <td><input id="username" name="username" type="text"></td>--%>
<%--        </tr>--%>
<%--        <tr>--%>
<%--            <td>密码:</td>--%>
<%--            <td><input id="password" name="password" type="password"></td>--%>
<%--        </tr>--%>
<%--        <tr >--%>
<%--            <td><input  id = "commit" type="button" value="登录"  onclick="checkLoginFun()" ></td>--%>
<%--        </tr>--%>

<%--    </table>--%>
<%--<script>--%>



<%--    function checkLoginFun() {--%>
<%--        var usn = $("#username").val();--%>
<%--        var psd = $("#password").val();--%>
<%--        var user={--%>

<%--            username:usn,--%>
<%--            password:psd--%>
<%--        };--%>
<%--        console.log(user);--%>
<%--        $.ajax({--%>
<%--            url: "checkLogin.action",--%>
<%--            type: "post",--%>
<%--            contentType: "application/json",--%>
<%--            data: JSON.stringify(user),--%>
<%--            dataType: "json",--%>
<%--            success: function (data) {--%>
<%--                console.log(data);--%>
<%--                switch (data) {--%>
<%--                    case 1:--%>
<%--                        window.location.href = "login";--%>
<%--                    case 2:--%>
<%--                        alert("密码错误！");--%>
<%--                        break;--%>

<%--                    case 3:--%>
<%--                        alert("用户名不存在！");--%>
<%--                        break;--%>

<%--                    case 4:--%>
<%--                        alert("用户名或密码不能为空！");--%>
<%--                        break;--%>
<%--                }--%>
<%--            }--%>
<%--        })--%>
<%--    }--%>
<%--</script>--%>
<%--</body>--%>
<%--</html>--%>
<html>
<head>
    <meta charset="utf-8" />
    <title>bootstrap案例</title>
    <!--用百度的静态资源库的cdn安装bootstrap环境-->
    <!-- Bootstrap 核心 CSS 文件 -->
    <link src="../css/bootstrap.min.css" rel="stylesheet">
    <!--font-awesome 核心我CSS 文件-->
<%--    <link href="//cdn.bootcss.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">--%>
    <!-- 在bootstrap.min.js 之前引入 -->
    <script src="../js/jquery-3.2.1.js"></script>
    <!-- Bootstrap 核心 JavaScript 文件 -->
    <script src="../js/bootstrap.min.js"></script>

    <style type="text/css">
        body{background: no-repeat;background-size:cover;font-size: 16px;}
        .form{background: rgba(255,255,255,0.2);width:400px;margin:100px auto;}
        #login_form{display: block;}
        #register_form{display: none;}
        .fa{display: inline-block;top: 27px;left: 6px;position: relative;color: #ccc;}
        input[type="text"],input[type="password"]{padding-left:26px;}
        .checkbox{padding-left:21px;}
    </style>
</head>
<body>
<!--
    基础知识：
    网格系统:通过行和列布局
    行必须放在container内
    手机用col-xs-*
    平板用col-sm-*
    笔记本或普通台式电脑用col-md-*
    大型设备台式电脑用col-lg-*
    为了兼容多个设备，可以用多个col-*-*来控制；
-->
<div class="container">
    <div class="form row">
        <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="login_form">
            <h3 class="form-title">Login to your account</h3>
            <div class="col-md-9 col-md-9">
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="Username" name="username" autofocus="autofocus" maxlength="20"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg"></i>
                    <input class="form-control required" type="password" placeholder="Password" name="password" maxlength="8"/>
                </div>
                <div class="form-group">
                    <label class="checkbox">
                        <input type="checkbox" name="remember" value="1"/> Remember me
                    </label>
                    <hr />
                    <a href="javascript:;" id="register_btn" class="">Create an account</a>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-success pull-right" value="Login "/>
                </div>
            </div>
        </form>
    </div>

    <div class="form row">
        <form class="form-horizontal col-sm-offset-3 col-md-offset-3" id="register_form">
            <h3 class="form-title">Login to your account</h3>
            <div class="col-sm-9 col-md-9">
                <div class="form-group">
                    <i class="fa fa-user fa-lg"></i>
                    <input class="form-control required" type="text" placeholder="Username" name="username" autofocus="autofocus"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-lock fa-lg"></i>
                    <input class="form-control required" type="password" placeholder="Password" id="register_password" name="password"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-check fa-lg"></i>
                    <input class="form-control required" type="password" placeholder="Re-type Your Password" name="rpassword"/>
                </div>
                <div class="form-group">
                    <i class="fa fa-envelope fa-lg"></i>
                    <input class="form-control eamil" type="text" placeholder="Email" name="email"/>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-success pull-right" value="Sign Up "/>
                    <input type="submit" class="btn btn-info pull-left" id="back_btn" value="Back"/>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
