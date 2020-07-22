<%@ page contentType="text/html;charset=UTF-8"  %>
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
<div style="height: 80px;width: 100%">
    <img src="${pageContext.request.contextPath}/img/logoko.png" style="height: 80px;">
    <div class="pull-right" style="line-height: 80px;margin-right: 20px">
        <p><b>欢迎您 ${loginUser.loginName}&nbsp;&nbsp;&nbsp;&nbsp;<a href="${pageContext.request.contextPath}/logout">注销</a></b></p>
    </div>
</div>

