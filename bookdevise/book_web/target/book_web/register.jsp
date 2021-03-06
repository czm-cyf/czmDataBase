<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>
        数据 - AdminLTE2定制版 | Log in</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- Theme style -->
    <!-- iCheck -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
</head>

<body class="hold-transition register-page">
<div class="register-box">
    <div class="register-logo">


        <a href="all-admin-index.html">图书租赁信息管理系统</a>


    </div>

    <div class="register-box-body">
        <p class="login-box-msg">新用户注册</p>

        <form action="${pageContext.request.contextPath}/user/register.do" method="post">
            <div class="form-group has-feedback">
                <input type="text" class="form-control" id="username" placeholder="用户名" name="username" >
                <span id="s_username" class="glyphicon glyphicon-user form-control-feedback"></span>
            </div>


            <div class="form-group has-feedback">
                <input type="password" class="form-control" id="password" placeholder="密码">
                <span id="s_password" class="glyphicon glyphicon-lock form-control-feedback"></span>
            </div>
            <div class="form-group has-feedback">
                <input type="password" class="form-control" id="repassword" placeholder="确认密码" name="password">
                <span id="s_repassword" class="glyphicon glyphicon-log-in form-control-feedback"></span>
            </div>

            <div class="form-group has-feedback">
                <input type="text" class="form-control" placeholder="联系电话" id="phone" name="phone">
                <span class="glyphicon glyphicon-user form-control-feedback" id="s_phone"></span>
            </div>
            <div class="row">
                <div class="col-xs-8">
                    <div class="checkbox icheck">
                        <label>
                            <input type="checkbox"> 我同意 <a href="#">协议</a>
                        </label>
                    </div>
                </div>
                <!-- /.col -->
                <div class="col-xs-4">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">注册</button>
                </div>
                <!-- /.col -->
            </div>
        </form>

        <div class="social-auth-links text-center">
            <p>- 或者 -</p>
            <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-qq"></i> 腾讯QQ用户登录</a>
            <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-weixin"></i> 微信用户登录</a>
        </div>

        <a href="${pageContext.request.contextPath}/login.jsp" class="text-center">我有账号，现在就去登录</a>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.2.3 -->
<!-- Bootstrap 3.3.6 -->
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function() {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
       $("#username").blur(function () {
            //获取username文本输入框的值
            var username = $(this).val();
            //发送ajax请求
            //期望服务器响应回的数据格式：{"userExsit":true,"msg":"此用户名太受欢迎,请更换一个"}
            //                         {"userExsit":false,"msg":"用户名可用"}
            $.get("${pageContext.request.contextPath}/user/findUser.do",{username:username},function (data) {
                //判断userExsit键的值是否是true
                // alert(data);
                var span = $("#s_username");
                if(data.userExsit){
                    span.css("color","red");
                    span.html(data.msg);
                }else{
                    span.css("color","green");
                    span.html(data.msg);
                }
            },"json");
        });
        
    });

    document.getElementById("repassword").onblur=equals;
    function equals() {
        var val1 = document.getElementById("password").value;
        var val2 = document.getElementById("repassword").value;
        if (val1==val2){
            document.getElementById("s_password").style.color="green";
            document.getElementById("s_repassword").style.color="green";
        }else {
            document.getElementById("s_password").style.color="red";
            document.getElementById("s_repassword").style.color="red";

        }
    }

    document.getElementById("phone").onblur=phone;
    function phone() {
        //1.获取用户名的值
        var username=document.getElementById("phone").value;
        //2.定义正则表达式
        var reg_username=/^\d{11}$/;
        //3.判断值是否符合正则的规则
        var flag=reg_username.test(username);
        //4.提示信息
        var s_username=document.getElementById("s_phone");
        if(flag){
            //提示绿色对勾
            s_username.style.color="green";
        }else{
            //提示红色用户名有误
            s_username.style.color="red";
        }
        return flag;
    }

</script>
</body>

</html>
