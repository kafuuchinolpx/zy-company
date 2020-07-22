<%@ page contentType="text/html;charset=UTF-8"  %>
<html>
<head>
    <title>时代网络公司管理系统</title>
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<div style="height: 80px;width: 100%;overflow: hidden;border-bottom: 1px solid #eee">

    <jsp:include page="inc/top.jsp"></jsp:include>
</div>
<div style="float: left;width: 187px;height: calc(100% - 80px);overflow: hidden">
    <jsp:include page="inc/left.jsp"></jsp:include>
</div>
<div style="float: left;width: calc(100% - 187px);height: calc(100% - 80px);overflow-y: scroll">
    <div class="container" style="text-align: center">
        <h1>时代网络公司管理系统</h1>
        <p>致力于企业实际管理需求与先进信息技术完美结合，打造企业全程一体化管理体系，打破各部门、各区域、各系统之间沟通和协作的壁垒，建立规范、灵捷、高效的业务流程，实现销售、客户、项目、生产、库存、采购、人资、财务、办公等所有环节全程无缝管理，确保了数据信息在传递过程中的准确性、时效性和有效性，帮助企业快速反应、紧密协作、良好运营，更快推进业务发展，全面提升核心竞争力。</p>
    </div>
</div>

</html>
