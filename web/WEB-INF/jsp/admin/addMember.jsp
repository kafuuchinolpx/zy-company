<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>添加成员</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <script>
        function jiancha() {
            var member_img = $("[name='member_img']").val();
            var member_name = $("[name='member_name']").val();
            var member_old = $("[name='member_old']").val();
            var member_work = $('[name="member_work"]').val();
            if (member_img == "" || member_name == "" || member_old == "" || member_work == "") {
                alert("请填写你的成员信息");
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
        <li><a href="#">公司成员管理</a></li>
        <li class="active">添加成员</li>

    </ol>
    <div class="container">
        <form method="post" action="addMember" enctype="multipart/form-data">

            <div class="row">

                <div class="form-group">

                    <label for="exampleInputEmail1">成员姓名：</label> <input type="text" maxlength="36" name="name"
                                                                         class="form-control" id="exampleInputEmail1"
                                                                         placeholder="成员姓名">

                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label>成员照片（建议上传100*100或200*200的图片）：</label> <input type="file" id="file" accept="image/*"
                                                                        class="form-control" name="image"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label>成员年龄：</label><input type="text" name="age" class="form-control" placeholder="成员年龄">
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label>工作类型：</label><input type="text" name="work" class="form-control" placeholder="成员工作类型">
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <button type="submit" class="btn btn-default" onclick="return jiancha()" style="width: 100%">添加成员
                    </button>
                </div>

            </div>
        </form>
    </div>
</div>
</body>
</html>
