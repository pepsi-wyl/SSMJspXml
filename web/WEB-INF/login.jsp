
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOG IN</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon">
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/css/style.css"/>
    <script>
        $(function () {
            <%--let userName = $("#userName");--%>
            <%--userName.bind("blur", function () {--%>
            <%--    $.ajax({--%>
            <%--        type: "POST",--%>
            <%--        url: "${pageContext.request.contextPath}/user/userIsExist",--%>
            <%--        data: {"userName": userName.val()},--%>
            <%--        dataType: "json",--%>
            <%--        success: function (date) {--%>
            <%--            if ("true" == date.toString())--%>
            <%--                $("#userInfo").css("color", "green").html("账户可以登陆!!!");--%>
            <%--            else if ("false" == date.toString())--%>
            <%--                $("#userInfo").css("color", "red").html("账户不存在!!!");--%>
            <%--        },--%>
            <%--    });--%>
            <%--});--%>
            //点击图片切换验证码
            $("#vcodeImg").click(function () {
                $(this).prop("src", "${pageContext.request.contextPath}/cpacha/loginCpacha?t=" + new Date().getTime());    //为了避免浏览器的缓存机制，改变参数
            });
            $(".txtb input").on("focus", function () {
                $(this).addClass("focus");
            });
            $(".txtb input").on("blur", function () {
                if ($(this).val() == "")
                    $(this).removeClass("focus");
            });
        });
    </script>
</head>
<body>

<form action="${pageContext.request.contextPath}/user/login" method="post" class="login-form">
    <h1>Log In</h1>
    <div class="txtb">
        <input type="text" id="userName" name="userName" placeholder="请输入userName:" required>
    </div>
    <div class="txtb">
        <input type="password" id="password" name="password" placeholder="请输入password:" required>
    </div>
    <p>
    <div style="float: left">
        <img id="vcodeImg" src="${pageContext.request.contextPath}/cpacha/loginCpacha" width="100px">
    </div>
    <input type="text" name="vcode" placeholder="请输入验证码" style=" width: 130px; height: 30px; margin-left:50px;  "
           required>
    </p>
    <input type="submit" value="Log In" class="logbtn">
    <input type="reset" value="reset" class="logbtn"/>
    <div class="info" style="text-align: center">${error}</div>
    <div class="bottom-text">
        Don't have account?<a href="${pageContext.request.contextPath}/user/toRegister">Sign up</a><br/>
        © 2021 Designed by @wyl
    </div>
</form>

</body>
</html>

