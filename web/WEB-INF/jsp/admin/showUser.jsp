<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <script>
        var chekedi = 1;
        $(function () {

            $("[name='username']").val("${condition.username}");
            $("[name='juan']").val(${juan});
            $("[name='user_id']").val(${condition.user_id});

        })
        var juan =${juan};
        var juansum =${juansum};


        function qx() {
            if (chekedi == 1) {

                $('[name="user"]').prop("checked", true);
                chekedi = 0;
            } else if (chekedi == 0) {
                $('[name="user"]').prop("checked", false);
                chekedi = 1;
            }

        }

        function delall() {
            var str = "";
            for (var i = 0; i < $('[type="checkbox"]').length; i++) {
                if ($('[type="checkbox"]').get(i).checked) {
                    if ($('[type="checkbox"]').get(i).id != "全选") {
                        str += $('[type="checkbox"]').get(i).value.toString() + ","
                    }

                }

            }
            if (str != "") {
                location.href = "delUser?id=" + str;
            } else {
                alert("请选中你要删除的数据，可多选");
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
        <li class="active">用户管理</li>


    </ol>
    <div class="container-fluid">
        <div class="row">
            <center>
                <form id="frm" class="form-inline" action="showUser" method="post">
                    <div class="form-group">
                        <label for="exampleInputName2">用户ID：</label>
                        <input type="text" class="form-control" id="exampleInputName2" name="id"
                               placeholder="请填写用户整数ID">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">用户名：</label>
                        <input type="text" class="form-control" id="exampleInputEmail2" name="loginName"
                               placeholder="可模糊查询">
                    </div>
                    <input type="hidden" name="juan" value="1" class="form-control">
                    <input type="hidden" name="page" value="1" class="form-control">
                    <button type="submit" class="btn btn-default">查询</button>
                </form>
            </center>
        </div>
        <div class="row" style="margin-bottom: 10px">
            <div class="col-md-1 col-md-offset-9">
                <a href="addUser">
                    <button type="button" class="btn btn-success">添加用户</button>
                </a>
            </div>
            <div class="col-md-1" style="margin-left: 20px">
                <button type="button" class="btn btn-danger" onclick="delall()">删除用户</button>
            </div>
        </div>
        <div style="height: 60%">
            <table class="table table-bordered table-hover">

                <tr>
                    <th><input type="checkbox" id="全选" onclick="qx()"></th>
                    <th>用户ID</th>
                    <th>用户名</th>
                    <th>用户密码</th>
                    <th><span class="glyphicon glyphicon-pencil"></span>&nbsp;编辑</th>
                    <th><span class="glyphicon glyphicon-trash"></span>&nbsp;删除</th>
                </tr>
                <c:forEach items="${users.list}" var="n">
                    <tr>
                        <td><input type="checkbox" name="user" value="${n.id}"></td>
                        <td><c:out value="${n.id}" escapeXml="false"></c:out></td>
                        <td><c:out value="${n.loginName}" escapeXml="false"></c:out></td>
                        <td><c:out value="${n.loginPassword}" escapeXml="false"></c:out></td>
                        <td><a href="editUser?id=${n.id}" style="text-decoration: none"><span
                                class="glyphicon glyphicon-pencil"></span>&nbsp;编辑</a>
                        </td>
                        <td><a href="deleteUser?id=${n.id}" style="text-decoration: none"><span
                                class="glyphicon glyphicon-trash"></span>&nbsp;删除</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="row">
            <div class="col-col-4 col-md-4 col-sm-4 col-xs-4">
                <p>当前第${users.page}页/共${users.pageCount}页 总记录数共${users.count}条</p>
            </div>
            <div class="col-lg-4 col-md-5 col-sm-5 col-xs-5">
                <nav aria-label="Page navigation">
                    <nav aria-label="...">
                        <ul class="pagination">
                            <li class=""><a href="showUser?page=1" aria-label="Previous"><span
                                    aria-hidden="true">首页</span></a></li>
                            <c:forEach begin="1" end="${users.pageCount}" step="1" var="index">
                                <li class="${users.page==index?'active':''}"><a
                                        href="showUser?page=${index}">${index}<span
                                        class="sr-only">(current)</span></a>
                                </li>
                            </c:forEach>
                            <li><a href="showUser?page=${users.pageCount}" aria-label="Next"><span
                                    aria-hidden="true">末尾</span></a></li>
                        </ul>
                    </nav>
                </nav>
            </div>
        </div>
        <%--    </div>--%>
</body>
</html>
