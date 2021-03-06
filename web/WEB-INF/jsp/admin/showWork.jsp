<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>作品管理</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <script>
        var chekedi = 1;
        $(function () {

            $("[name='juan']").val(${juan});
            $("[name='work_date']").val("${condition.work_date}")
            $('[name="user_id"]').val(${user_id});

        })
        var juan =${juan};
        var juansum =${juansum};


        function qx() {
            if (chekedi == 1) {

                $('[name="new"]').prop("checked", true);
                chekedi = 0;
            } else if (chekedi == 0) {
                $('[name="new"]').prop("checked", false);
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
                location.href = "delwork?id=" + str;
            } else {
                alert("请选中你要删除的数据，可多选");
            }

            /*   if($('[type="checkbox"]')[i].is(":checked")){
             str+=$('[type="checkbox"]')[i].val().toString()+",";
             }*/


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
        <li><a href="#">作品管理</a></li>
        <li class="active">作品管理</li>


    </ol>
    <div class="container-fluid">

        <div class="row">
            <center>
                <form id="frm" class="form-inline" action="showWork" method="post">
                    <div class="form-group">
                        <label for="exampleInputName2">作品ID：</label>
                        <input type="text" class="form-control" id="exampleInputName2" name="id"
                              placeholder="请填写整数的作品ID">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputEmail2">作品标题：</label>
                        <input type="text" class="form-control" id="exampleInputEmail2" name="name"
                               placeholder="可模糊查询">
                    </div>
                    <div class="form-group">
                        <label>发布人：</label>
                        <select name="usersId" class="form-control">
                            <option></option>
                            <c:forEach var="n" items="${user}">
                                <option value="${n.id}">${n.loginName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>发布日期：</label>
                        <input type="date" class="form-control" name="date" placeholder="请选择发布日期">
                    </div>
                    <input type="hidden" name="juan" value="1" class="form-control">
                    <input type="hidden" name="page" value="1" class="form-control">
                    <button type="submit" class="btn btn-default">查询</button>
                </form>
            </center>
        </div>
        <div class="row" style="margin-bottom: 10px">
            <div class="col-md-1 col-md-offset-9">
                <a href="addWork">
                    <button type="button" class="btn btn-success">添加作品</button>
                </a>
            </div>
            <div class="col-md-1" style="margin-left: 20px">
                <button type="button" class="btn btn-danger" onclick="delall()">删除作品</button>
            </div>
        </div>

        <div style="height: 60%">
            <table style="text-align: center" class="table table-bordered table-hover">

                <tr>
                    <th style="text-align: center"><input type="checkbox" id="全选" onclick="qx()"></th>
                    <th style="text-align: center">作品ID</th>
                    <th style="text-align: center">作品名称</th>
                    <th style="text-align: center">作品发布时间</th>
                    <th style="text-align: center">作品发布人</th>
                    <th style="text-align: center"><span class="glyphicon glyphicon-pencil"></span>&nbsp;编辑</th>
                    <th style="text-align: center"><span class="glyphicon glyphicon-trash"></span>&nbsp;删除</th>
                </tr>
                <c:forEach var="n" items="${works.list}">
                    <tr>
                        <td><input type="checkbox" name="new" value="${n.id}"></td>
                        <td><c:out value="${n.id}" escapeXml="false"></c:out></td>
                        <td><c:out value="${n.name}" escapeXml="false"></c:out></td>
                        <td><c:out value="${n.date}" escapeXml="false"></c:out></td>
                        <td><c:out value="${n.users.loginName}" escapeXml="false"></c:out></td>

                        <td><a href="editWork?id=${n.id}" style="text-decoration: none"><span
                                class="glyphicon glyphicon-pencil"></span>&nbsp;编辑</a>
                        </td>
                        <td><a href="deleteWork?id=${n.id}" style="text-decoration: none"><span
                                class="glyphicon glyphicon-trash"></span>&nbsp;删除</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>

        </div>
        <div class="row">
            <div class="col-col-4 col-md-4 col-sm-4 col-xs-4">
                <p>当前第${works.page}页/共${works.pageCount}页 总记录数共${works.count}条</p>
            </div>
            <div class="col-lg-4 col-md-5 col-sm-5 col-xs-5">
                <nav aria-label="Page navigation">
                    <nav aria-label="...">
                        <ul class="pagination">
                            <li class=""><a href="showWork?page=1" aria-label="Previous"><span
                                    aria-hidden="true">首页</span></a></li>
                            <c:forEach begin="1" end="${works.pageCount}" step="1" var="index">
                                <li class="${works.page==index?'active':''}"><a
                                        href="showWork?page=${index}">${index}<span
                                        class="sr-only">(current)</span></a>
                                </li>
                            </c:forEach>
                            <li><a href="showWork?page=${works.pageCount}" aria-label="Next"><span
                                    aria-hidden="true">末尾</span></a></li>
                        </ul>
                    </nav>
                </nav>
            </div>
        </div>
    </div>
</div>
</body>
</html>
