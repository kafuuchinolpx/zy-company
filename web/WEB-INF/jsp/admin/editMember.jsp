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

            var member_name = $("[name='member_name']").val();
            var member_work = $("[name='member_work']").val();
            var member_old = $("[name='member_old']").val();
            var member_img = $("[name='member_img']").val();


            if (member_name == "" && member_old == "" && member_work == "" && member_img == "") {
                alert("请填写要求改的信息，如果不想修改，请返回上一级")
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
        <li class="active">修改用户</li>
    </ol>
    <div class="container">
        <form action="editMember" enctype="multipart/form-data" method="post">


            <div class="row">
                <div class="form-group">
                    <label>成员ID：${members.id}</label>
                    <input type="hidden" name="id" value="${members.id}"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="exampleInputPassword1">成员姓名：</label>
                    <input type="text" name="name" class="form-control" id="exampleInputPassword1"
                           placeholder="${members.name}" value="${members.name}">
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="exampleInputPassword3">成员照片：</label>
                    <input type="file" name="image" class="form-control" id="exampleInputPassword3">
                </div>
            </div>

            <div class="row">
                <div class="form-group">
                    <label for="exampleInputPassword2">成员年龄：</label>
                    <input type="text" name="age" class="form-control" id="exampleInputPassword2"
                           placeholder="${members.age}" value="${members.age}">
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="exampleInputPassword2">成员工作类型：</label>
                    <input type="text" name="work" class="form-control" id="exampleInputPassword4"
                           placeholder="${members.work}" value="${members.work}">
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <button type="submit" onclick="return jiancha()" class="btn btn-default" style="width:100%">修改用户
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
