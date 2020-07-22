<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>时代网络公司后台管理系统</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/jquery-ui.min.css" rel="stylesheet">
</head>
<body style="background:url('${pageContext.request.contextPath}/img/loginbg.jpg');">

<div class="container" style="margin-top: 8%">
    <form method="post" action="${pageContext.request.contextPath}/login">
        <div class="row">
            <div class="col-lg-4 col-lg-offset-4">

                <img src="${pageContext.request.contextPath}/img/logoko.png" width="100%">

            </div>
        </div>
        <div class="row" style="margin-top: 20px;">
            <div class="col-lg-4 col-lg-offset-4">
                <div class="form-group">
                    <label for="exampleInputEmail1">用户名</label>
                    <input type="text" class="form-control" name="loginName" id="exampleInputEmail1"
                           placeholder="Username">
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4 col-lg-offset-4">
                <div class="form-group">
                    <label for="exampleInputPassword1">密码</label>
                    <input type="password" class="form-control" name="loginPassword" id="exampleInputPassword1"
                           placeholder="Password">
                </div>
            </div>
        </div>
        <div class="row" style="margin-top: 20px;">
            <div class="col-lg-2 col-lg-offset-5">
                <p style="color: #ff3226">${prompt}</p>
                <button type="submit" class="btn btn-default " style="width: 100%">&nbsp;&nbsp;登&nbsp;&nbsp;陆&nbsp;&nbsp;</button>
            </div>
        </div>
    </form>
</div>


</div>


</body>
</html>
