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

        .carousel-control {
            line-height: 6;
            text-align: center;
            font-size: 50px;
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
        <div class="col-lg-5 " style="text-align: center;">
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
        <div class="col-lg-6  col-lg-offset-1">
            <fieldset id="teamdt">
                <legend><b>公司动态</b>

                    <span style="margin-left: 75%"><a href="${pageContext.request.contextPath}/newsList">更多</a></span>
                </legend>

                <c:forEach var="n" items="${news}">
                    <div class="row">
                        <a href="showNews?id=${n.id}" style="text-decoration: none;">
                            <div class="col-lg-12" style="list-style: none;">
                                <div class="col-lg-8 col-md-8 col-xs-8 col-sm-8">
                                    <font color="#555555" size="3pt"><c:out value="${n.name}"/></font>
                                </div>
                                <div class="col-lg-3 col-sm-3 col-xs-3 col-md-3 col-lg-offset-1 col-xs-offset-1 col-md-offset-1 col-sm-offset-1"
                                     style="text-align: right"><font color="#555555" size="3pt"><c:out
                                        value="${n.date}"/></font></div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
                </table>
            </fieldset>
        </div>
    </div>
    <div class="row" style="margin-top: 10px;">
        <fieldset id="alzs">
            <legend><b>作品展示</b> <span style="margin-left: 80%"><a
                    href="${pageContext.request.contextPath}/workList">更多</a></span></legend>
            <c:forEach var="n" items="${works}">
                <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6 ">
                    <a href="work?id=${n.id}" class="thumbnail">
                        <img src="${pageContext.request.contextPath}${n.image}" style="width: 280px;height: 240px"
                             alt="...">
                        <p style="text-align: center"><font style="color: #777;" size="4pt"><b><c:out
                                value="${n.name}"/></b></font></p>
                    </a>
                </div>
            </c:forEach>
        </fieldset>
    </div>
    <div class="row">
        <fieldset id="tdcy">
            <legend><b>公司成员</b> <span style="margin-left: 80%"><a href="${pageContext.request.contextPath}/memberList">更多</a></span>
            </legend>
            <c:forEach items="${members}" var="n">
            <div class="col-lg-3 col-md-3 col-sm-4 col-xs-6">
                <div class="thumbnail">
                    <img src="${pageContext.request.contextPath}${n.image}" alt="..."
                         style="width: 150px;height: 150px">
                    <div class="caption">
                        <center>
                            <h3><c:out value="${n.name}" escapeXml="false"></c:out></h3>
                            <p><c:out value=" ${n.age}"></c:out>&nbsp;岁</p>
                            <p><c:out value="${n.work}"/></p>
                        </center>
                    </div>
                </div>
            </div>
            </c:forEach>
    </div>
    </fieldset>

</div>
<%@include file="footer.jsp" %>
</body>
</html>
