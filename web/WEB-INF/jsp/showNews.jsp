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
    <script>
        $(function () {

            $("[name='juan']").val(${juan});

        })
        var juan =${juan};
        var juansum =${juansum};

    </script>
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
                        <img src="${pageContext.request.contextPath}/img/lunbo1.jpg" width="100%"  alt="First slide">
                    </div>
                    <div class="item">
                        <img src="${pageContext.request.contextPath}/img/lunbo2.jpg" width="100%"  alt="Second slide">
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

    <div class="row" style="text-align: center;margin-top: 30px">
        <h2><c:out value="${news.name}" escapeXml="false"></c:out></h2>
        <p>发布日期：<c:out value="${news.date}" escapeXml="false"></c:out></p>
        <p>发布人：<c:out value="${news.users.loginName}"></c:out></p>
    </div>

    <hr>
    <div class="row"><c:out value="${news.value}" escapeXml="false;"></c:out></div>


    <%@include file="footer.jsp" %>
</div>
</body>
</html>
