<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign up</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/favicon.ico" type="image/x-icon">
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
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
            <%--                $("#userInfo").css("color", "green").html("账户已经存在!!!");--%>
            <%--            else if ("false" == date.toString())--%>
            <%--                $("#userInfo").css("color", "red").html("账户可以使用!!!");--%>
            <%--        },--%>
            <%--    });--%>
            <%--});--%>
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

<form action="${pageContext.request.contextPath}/user/register" method="post" class="login-form">
    <h1>Sign up</h1>
    <div class="txtb">
        <input type="text" id="userName" name="userName" placeholder="请输入userName:" required>
    </div>
    <div class="txtb">
        <input type="password" id="password" name="password" placeholder="请输入password:" required>
    </div>
    <input type="submit" value="submit" class="logbtn">
    <input type="reset" value="reset" class="logbtn"/>
    <div class="bottom-text">
        <a href="${pageContext.request.contextPath}/user/toLogin">Log In</a><br/>
        © 2021 Designed by @wyl
    </div>
</form>

</body>
</html>
