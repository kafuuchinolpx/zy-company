<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>时代网络科技公司</title>

    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jquery-ui.min.js"></script>
    <link href="${pageContext.request.contextPath}/css/jquery-ui.min.css" rel="stylesheet">
    <style>
        #teamdt div a:link {
            color: black;
        }

        #teamdt div a:visited {
            color: #555555
        }

        /* 已访问的链接 */
        #teamdt div a:hover {
            color: deepskyblue
        }

        /* 鼠标移动到链接上 */
        #teamdt div a:active {
            color: burlywood
        }
    </style>

</head>
<body>

<%@include file="top.jsp" %>
<div class="container">

    <div class="row">

        <div class=" col-lg-12 ">

            <div id="myCarousel" class="carousel slide">
                <!-- 轮播（Carousel）指标 -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                </ol>
                <!-- 轮播（Carousel）项目 -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="${pageContext.request.contextPath}/img/lunbo1.jpg" width="100%" alt="First slide">
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/img/lunbo2.jpg" width="100%" alt="Second slide">
                    </div>
                </div>
                <!-- 轮播（Carousel）导航 -->
                <a class="carousel-control left" href="#myCarousel"
                   data-slide="prev"></a>
                <a class="carousel-control right" href="#myCarousel"
                   data-slide="next"></a>
            </div>
        </div>
    </div>

    <fieldset id="tdcy" style="margin-top: 30px">
        <div class="row">

            <legend>公司动态</legend>
            <div class="col-lg-12">
                <div class="list-group">
                    <c:forEach items="${news.list}" var="n">
                        <a href="showNews?id=${n.id}" class="list-group-item">
                            <font color="#555555" size="3pt">
                                <c:out value="${n.date}"/>&nbsp;&nbsp;&nbsp;&nbsp;<c:out
                                    value="${n.name}"/></font>
                        </a>
                    </c:forEach>
                </div>
            </div>
            <div class="row">
                <div class="col-col-4 col-md-4 col-sm-4 col-xs-4">
                    <p>当前第${users.page}页/共${users.pageCount}页 总记录数共${users.count}条</p>
                </div>
                <div class="col-lg-4 col-md-5 col-sm-5 col-xs-5">
                    <nav aria-label="Page navigation">
                        <nav aria-label="...">
                            <ul class="pagination">
                                <li class=""><a href="newsList?page=1" aria-label="Previous"><span
                                        aria-hidden="true">首页</span></a></li>
                                <c:forEach begin="1" end="${users.pageCount}" step="1" var="index">
                                    <li class="${users.page==index?'active':''}"><a
                                            href="newsList?page=${index}">${index}<span
                                            class="sr-only">(current)</span></a>
                                    </li>
                                </c:forEach>
                                <li><a href="newsList?page=${users.pageCount}" aria-label="Next"><span
                                        aria-hidden="true">末尾</span></a></li>
                            </ul>
                        </nav>
                    </nav>
                </div>
            </div>
        </div>
    </fieldset>
    <%@include file="footer.jsp" %>
</div>

</body>
</html>
