<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>添加用户</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script>
        function jiancha() {
            var username = $('[name="username"]').val();
            var password = $('[name="password"]').val();
            if (username == '' || password == '') {
                alert("账号或密码不能为空");
                return false;
            } else if (password.indexOf(" ") != -1 || password.indexOf(" ") != -1) {
                alert("账号或密码不能包含空格");
                return false;
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
        <li class="active">添加用户</li>

    </ol>
    <div class="container-fluid">


        <form action="${pageContext.request.contextPath}/admin/addUser" method="post">
            <div class="col-md-4 col-md-offset-4" style="margin-top: 50px">
                <div class="form-group">
                    <label for="exampleInputEmail1">用户名</label>
                    <input type="text" name="loginName" class="form-control" id="exampleInputEmail1"
                           placeholder="useranme">
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <div class="form-group">
                        <label for="exampleInputPassword1">密码</label>
                        <input type="password" name="loginPassword" class="form-control" id="exampleInputPassword1"
                               placeholder="Password">
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <button type="submit" class="btn btn-default" onclick=" return jiancha()" style="width: 100%">添加用户
                    </button>
                </div>

            </div>

        </form>
    </div>
</div>
</body>
</html>
