<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>添加作品</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/ueditor.config.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/ueditor.all.min.js"></script>
    <script src="${pageContext.request.contextPath}/ueditor/lang/zh-cn/zh-cn.js"></script>

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
        <li><a href="#">作品管理</a></li>
        <li class="active">添加作品</li>

    </ol>
    <div class="container">
        <form method="post" action="addWork" enctype="multipart/form-data">
            <div class="row">
                <div class="form-group">
                    <label for="exampleInputEmail1">作品名称：</label> <input type="text" maxlength="36" name="name"
                                                                         class="form-control" id="exampleInputEmail1"
                                                                         placeholder="作品名称">
                    <label for="exampleInputEmail1"></label> <input name="id" placeholder="${loginUser.id}"
                                                                    value="${loginUser.id}" hidden="hidden">
                </div>

            </div>
            <div class="row">

                <div class="form-group">

                    <label>首页缩略图（建议上传100*100或200*200的图片）：</label> <input type="file" id="file" accept="image/*"
                                                                         class="form-control" name="image"/>
                </div>
            </div>

            <div class="row">

                <div class="form-group">

                    <label>展示内容：</label>
                    <script id="editor" name="value" type="text/plain" style="width:100%;height:200px;">请添加你的展示内容









                    </script>
                </div>

            </div>
            <div class="row">
                <div class="col-md-4 col-md-offset-4">
                    <button type="submit" class="btn btn-default" style="width: 100%">添加作品</button>
                </div>

            </div>
        </form>
    </div>
</div>
<script>

    var ue = UE.getEditor('editor');
</script>
</body>
</html>
