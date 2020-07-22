<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>添加公司新闻</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script>
        function jiancha() {
            var new_name = $('[name="new_name"]').val();
            if (new_name == "" || new_name == " ") {
                alert("新闻标题不能为空");
                return false;
            }
        }

        $(function () {
            var ue = UE.getEditor('editor');
        });
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
        <li class="active">添加新闻</li>

    </ol>
    <div class="container">
        <form method="post" action="addNews">
            <div class="row">
                <div class="form-group">

                    <label for="exampleInputEmail1"></label> <input name="id" placeholder="${loginUser.id}"
                                                                    value="${loginUser.id}" hidden="hidden">

                    <label for="exampleInputEmail1">新闻标题：</label> <input type="text" maxlength="36" name="name"
                                                                         class="form-control" id="exampleInputEmail1"
                                                                         placeholder="新闻标题">
                </div>
            </div>
            <div class="row">
                <div class="form-group">
                    <label>新闻内容：</label>
                    <script id="editor" name="value" type="text/plain" style="width:100%;height:200px;">请添加你的新闻内容


                    </script>
                </div>
            </div>

            <div class="row">
                <div class="col-md-offset-4 col-md-4">
                    <button type="submit" class="btn btn-default" onclick="return jiancha()" style="width: 100%">添加公司新闻
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>


</body>
</html>

