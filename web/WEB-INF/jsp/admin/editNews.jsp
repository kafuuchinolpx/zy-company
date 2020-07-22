<%@ page contentType="text/html;charset=UTF-8"  %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>编辑新闻</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>

    <script>

        function jiancha() {

            var newname = $("[name='new_name']").val();
            var newvalue = $("[name='new_value']").val();

            if (newname == "" && newvalue == "") {
                alert("请填写要求改的信息，如果不想修改，请返回上一级")
                return false;
            } else {

            }
        }

        $(function () {
            var ue = UE.getEditor('editor');
        })

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
        <li><a href="#">新闻管理</a></li>
        <li class="active">编辑新闻</li>
    </ol>
    <div class="container">
        <form action="editNews" method="post">


            <div class="row">
                <div class="form-group">
                    <label>新闻ID：${data.id}</label>
                    <input type="hidden" name="id" value="${data.id}"/>
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label for="exampleInputPassword1">新闻标题：</label>
                    <input type="text" name="name" class="form-control" id="exampleInputPassword1"
                           value="${data.name}">
                </div>
            </div>
            <div class="row">
                <div class="form-group">

                    <label>新闻内容：</label>
                    <script id="editor" name="value" type="text/plain"
                            style="width:100%;height:200px;">${data.value}</script>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <button type="submit" onclick="return jiancha()" class="btn btn-default" style="width: 100%;">修改新闻
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
