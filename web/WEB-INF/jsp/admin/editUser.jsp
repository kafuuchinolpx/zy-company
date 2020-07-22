<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改用户</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <style>
        .breadcrumb {
            padding: 8px 15px;
            margin-bottom: 20px;
            list-style: none;
            background-color: #EDF6FA;
            border: 1px solid #D7E4EA;
            border-radius: 4px
        }
    </style>
    <script>
        function jiancha() {
            var useranme = $("[name='username']").val();
            var password = $("[name='password']").val();

            if (useranme == "" && password == "") {
                alert("请填写要求改的信息，如果不想修改，请返回上一级")
                return false;
            } else {

            }
        }

    </script>
</head>
<body>
<div style="height: 80px;width: 100%;overflow: hidden">

    <jsp:include page="inc/top.jsp"></jsp:include>
</div>
<div style="float: left;width: 187px;height: calc(100% - 80px);overflow: hidden">
    <jsp:include page="inc/left.jsp"></jsp:include>
</div>
<div style="float: left;width: calc(100% - 187px);height: calc(100% - 80px);overflow: scroll">
    <ol class="breadcrumb">
        位置：
        <li><a href="#">用户管理</a></li>
        <li class="active">修改用户</li>
    </ol>
    <div class="container">
        <form action="editUser" method="post">
            <div class="row">
                <div class="form-group">
                    <input hidden="hidden" type="hidden" name="id" value="${users.id}"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="exampleInputPassword1">用户名：</label>
                    <input type="text" name="loginName" class="form-control" id="exampleInputPassword1"
                           placeholder="${users.loginName}" value="${users.loginName}">
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="exampleInputPassword2">密码：</label>
                    <input type="text" name="loginPassword" class="form-control" id="exampleInputPassword2"
                           placeholder="${users.loginPassword}" value="${users.loginPassword}">
                </div>
            </div>
            <div class="row">
                <button type="submit" onclick="return jiancha()" class="btn btn-default">修改用户</button>
                <a href="${pageContext.request.contextPath}/admin/showUser" class="btn btn-info">返回上一级</a>
            </div>
        </form>
    </div>
</div>
</body>
</html>
