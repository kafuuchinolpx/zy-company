<%@ page contentType="text/html;charset=UTF-8" %>
<div class="left" style="width: 187px;background-color: #F0F9FD;height: 100%; border: 1px #CCE2EA solid;">
    <div onclick="zk(this)" id="用户管理" style="background:#D4E7F0;height: 30px;border: 1px #CCE2EA solid;">
        &nbsp;&nbsp;<span class="glyphicon glyphicon-user"></span>&nbsp;&nbsp;<font style="font-size: 13pt"><b>用户管理</b></font>
    </div>

    <ul style="list-style: none;padding: 0px;margin-left: 0px" name="用户管理">
        <li><a href="${pageContext.request.contextPath}/admin/addUser"
               style="text-decoration: none;padding-left: 30px;margin-top: 5px;">
            <button type="button" class="btn btn-link"><font style="font-size: 10pt;color: black"><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;添加用户</font></button>
        </a></li>
        <li><a href="${pageContext.request.contextPath}/admin/showUser"
               style="text-decoration: none;padding-left: 30px;margin-top: 5px;">
            <button type="button" class="btn btn-link"><font style="font-size: 10pt;color: black"><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;用户管理</font></button>
        </a></li>
    </ul>

    <div onclick="zk(this)" id="公司新闻管理"
         style="background:#D4E7F0;height: 30px;padding-left: 10px;border: 1px #CCE2EA solid;"><span
            class="glyphicon glyphicon-bullhorn"></span>&nbsp;&nbsp;<font style="font-size: 13pt"><b>公司新闻管理</b></font>
    </div>
    <ul style="list-style: none;padding: 0px;margin-left: 0px;" name="公司新闻管理">
        <li><a href="${pageContext.request.contextPath}/admin/addNews"
               style="text-decoration: none;padding-left: 30px;margin-top: 5px;">
            <button type="button" class="btn btn-link"><font style="font-size: 10pt;color: black"><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;添加新闻</font></button>
        </a></li>
        <li><a href="${pageContext.request.contextPath}/admin/showNews"
               style="text-decoration: none;padding-left: 30px;margin-top: 5px;">
            <button type="button" class="btn btn-link"><font style="font-size: 10pt;color: black"><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;新闻管理</font></button>
        </a></li>

    </ul>
    <div onclick="zk(this)" id="公司作品管理"
         style="background:#D4E7F0;height: 30px;padding-left: 10px;border: 1px #CCE2EA solid;"><span
            class="glyphicon glyphicon-film"></span>&nbsp;&nbsp;<font style="font-size: 13pt"><b>公司作品管理</b></font></div>
    <ul style="list-style: none;padding: 0px;margin-left: 0px" name="公司作品管理">
        <li><a href="${pageContext.request.contextPath}/admin/addWork"
               style="text-decoration: none;padding-left: 30px;margin-top: 5px;">
            <button type="button" class="btn btn-link"><font style="font-size: 10pt;color: black"><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;添加作品</font></button>
        </a></li>
        <li><a href="${pageContext.request.contextPath}/admin/showWork"
               style="text-decoration: none;padding-left: 30px;margin-top: 5px;">
            <button type="button" class="btn btn-link"><font style="font-size: 10pt;color: black"><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;作品管理</font></button>
        </a></li>

    </ul>
    <div onclick="zk(this)" id="公司成员管理"
         style="background:#D4E7F0;height: 30px;padding-left: 10px;border: 1px #CCE2EA solid;"><span
            class="glyphicon glyphicon-sunglasses"></span>&nbsp;&nbsp;<font style="font-size: 13pt"><b>公司成员管理</b></font>
    </div>
    <ul style="list-style: none;padding: 0px;margin-left: 0px" name="公司成员管理">
        <li><a href="${pageContext.request.contextPath}/admin/addMember"
               style="text-decoration: none;padding-left: 30px;margin-top: 5px;">
            <button type="button" class="btn btn-link"><font style="font-size: 10pt;color: black"><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;添加成员</font></button>
        </a></li>
        <li><a href="${pageContext.request.contextPath}/admin/showMember"
               style="text-decoration: none;padding-left: 30px;margin-top: 5px;">
            <button type="button" class="btn btn-link"><font style="font-size: 10pt;color: black"><span
                    class="glyphicon glyphicon-tint"></span>&nbsp;成员管理</font></button>
        </a></li>

    </ul>
</div>
<script>

    //$(".left ul").hide();

    function zk(a) {
        if ($("[name='" + a.id + "']").is(":hidden")) {
            $("[name='" + a.id + "']").show(1000);
        } else {
            $("[name='" + a.id + "']").hide(1000);
        }
    }
</script>

