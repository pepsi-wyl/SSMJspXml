<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍</title>
    <%--bootStrop美化界面--%>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">

    <div class="row clearfix">
        <div class="col-md-12 column">
            <h1>
                <small>修改书籍</small>
            </h1>
        </div>
    </div>

    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">
        <input type="hidden" name="bookID" value="${book.bookID}" >
        <div class="form-group">
            <label for="bookName">书籍名称</label>
            <input type="text" class="from-control" id="bookName" name="bookName" value="${book.bookName}"
                   required>
        </div>
        <div class="form-group">
            <label for="bookCounts">书籍数量</label>
            <input type="text" class="from-control" id="bookCounts" name="bookCounts" value="${book.bookCounts}"
                   required>
        </div>
        <div class="form-group">
            <label for="detail">书籍描述</label>
            <input type="text" class="from-control" id="detail" name="detail" value="${book.detail}"
                   required>
        </div>
        <div class="form-group">
            <input type="submit" class="from-control" id="submit" value="修改">
        </div>
    </form>

</div>

</body>
</html>
