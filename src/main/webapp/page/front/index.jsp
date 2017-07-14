<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <base href="<%=basePath%>"/>
    <title>${globals["PAGE_TITLE"].title} </title>
    <jsp:include page="/page/front/component/link.jsp"/>

    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <script type="application/x-javascript">
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);
        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
   <%-- <link rel="stylesheet" href="static/css/flexslider.css" type="text/css" media="screen"/>--%>
    <!--scrolling-->

    <script type="text/javascript">
        jQuery(document).ready(function ($) {
            $(".scroll").click(function (event) {
                event.preventDefault();
                $('html,body').animate({scrollTop: $(this.hash).offset().top}, 1200);
            });
        });
    </script>
    <!--scrolling-->
</head>
<body>
<!--top-header-->
<div id="home" class="top-header">
    <div class="container">
        <div class="logo">
            <h1><a href="#">Harlan Yasha</a></h1>
        </div>
        <div class="top-menu">
            <span class="menu"><img src="static/images/nav-icon.png" alt=""/></span>
            <ul>
                <li><a class="scroll" href="#home">Main</a></li>
                <li><a class="scroll" href="#about">Who I Am</a></li>
                <li><a class="scroll" href="#service">Reason</a></li>
                <li><a class="scroll" href="#gallery">Image</a></li>
                <li><a class="scroll" href="#blog">Article</a></li>
                <li><a class="scroll" href="#contact">Contact</a></li>
            </ul>
            <!-- script-for-menu -->
            <script>
                $("span.menu").click(function () {
                    $(".top-menu ul").slideToggle("slow", function () {
                    });
                });
            </script>
            <!-- script-for-menu -->
        </div>
    </div>
</div>
<!--header-->
<div class="header" style="background: url(${image_url}${banners[0]}.jpg) no-repeat 0px -127px;
  background-size: cover;
  min-height: 600px;">
    <div class="container">
        <div class="banner-info">
            <h2>${globals['BANNER_TEXT'].title}</h2>
            <p>${globals['BANNER_TEXT'].content}</p>
            <!-- <a href="#">Click</a> -->
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!--Service-->
<div id="service" class="service">
    <div class="container">
        <h3>${globals['REASON'].title}</h3>
        <div class="service-grids">
            <div class="icon-grids">
                <div class="col-md-6 futr-grid futr1">
                    <div class="icon-pic">
                        <div class="icon text-center">
                            <span class="glyphicon glyphicon-phone" aria-hidden="true"></span>
                        </div>
                    </div>
                    <div class="icon-info">
                        <h4>${globals['REASON_1'].title}</h4>
                        <p>${globals['REASON_1'].content}</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="col-md-6 futr-grid">
                    <div class="icon-pic">
                        <div class="icon text-center">
                            <span class="glyphicon glyphicon-thumbs-up" aria-hidden="true"></span>
                        </div>
                    </div>
                    <div class="icon-info">
                        <h4>${globals['REASON_2'].title}</h4>
                        <p>${globals['REASON_2'].content}</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
            <div class="icon-grids grids2">
                <div class="col-md-6 futr-grid futr1">
                    <div class="icon-pic">
                        <div class="icon text-center">
                            <span class="glyphicon glyphicon-picture" aria-hidden="true"></span>
                        </div>
                    </div>
                    <div class="icon-info">
                        <h4>${globals['REASON_3'].title}</h4>
                        <p>${globals['REASON_3'].content}</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="col-md-6 futr-grid">
                    <div class="icon-pic">
                        <div class="icon text-center">
                            <span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        </div>
                    </div>
                    <div class="icon-info">
                        <h4>${globals['REASON_4'].title}</h4>
                        <p>${globals['REASON_4'].content}</p>
                    </div>
                    <div class="clearfix"></div>
                </div>
                <div class="clearfix"></div>
            </div>
        </div>
    </div>
</div>
<!--about-->
<div id="about" class="about">
    <div class="about-left"></div>
    <div class="about-right">
        <h3>${globals["ABOUT_TITLE"].title}</h3>
        <h4>${globals["ABOUT_CONTENT"].title}</h4>
        <p>${globals["ABOUT_CONTENT"].content}</p>
    </div>
    <div class="clearfix"></div>
</div>

<!--light-box-files -->
<script type="text/javascript">
    $(function () {
        $('.moments-bottom a').Chocolat({
            leftImg               : 'static/images/left.gif',
            rightImg              : 'static/images/right.gif',
            closeImg              : 'static/images/close.gif',
            loadingImg            : 'static/images/loading.gif'
        });
    });
</script>
<!--gallery js-->
<div id="gallery" class="gallery">
    <div class="container">
        <h3>${globals["ALBUM_TITLE"].title}</h3>
        <div class="gallery-info">
            <c:forEach var="image" items="${albums}">
                <div class="col-md-4 galry-grids moments-bottom">
                    <a class="b-link-stripe b-animate-go" href="${image_url}${image}.jpg">
                        <img src="${image_url}${image}.jpg" class="img-responsive" alt="">
                        <div class="b-wrapper">
							<span class="b-animate b-from-left    b-delay03 ">
								<img class="img-responsive" src="static/images/e.png" alt=""/>
							</span>
                        </div>
                    </a>
                </div>
            </c:forEach>
           <%-- <div class="col-md-4 galry-grids moments-bottom">
                <a class="b-link-stripe b-animate-go" href="page/front/images/img15.jpg">
                    <img src="page/front/images/img15.jpg" class="img-responsive" alt="">
                    <div class="b-wrapper">
							<span class="b-animate b-from-left    b-delay03 ">
								<img class="img-responsive" src="static/images/e.png" alt=""/>
							</span>
                    </div>
                </a>
            </div>--%>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!---->
<div id="blog" class="blog">
    <div class="container">
        <h3>${globals["ARTICLE_TITLE"].title}</h3>
        <div class="blog-grids">
            <c:forEach items="${articles}" var="item">

                <div class="col-md-6 blog-grid">
                    <a href="#"><img src="static/images/b1.jpg" class="img-responsive" alt=""/></a>
                    <h4><a href="#"></a>${item.title}</h4>
                    <span>
					<fmt:formatDate value="${item.publishDate}" pattern="yyyy年MM月dd日 "/>
					</span>
                    <p>"${item.content}</p>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<!---->
<div class="map">
    <!--  <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d6632.248000703498!2d151.265683!3d-33.7832959!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x6b12abc7edcbeb07%3A0x5017d681632bfc0!2sManly+Vale+NSW+2093%2C+Australia!5e0!3m2!1sen!2sin!4v1433329298259" style="border:0"></iframe>
 --></div>
<!---->
<div id="contact" class="contact">
    <div class="container">
        <h3>Contact</h3>
        <div class="touch-top">
            <div class="col-md-8 touch-left">
                <form>
                    <input type="text" value="Name" onfocus="this.value = '';"
                           onblur="if (this.value == '') {this.value = 'Name';}"/>
                    <input type="text" value="Email" onfocus="this.value = '';"
                           onblur="if (this.value == '') {this.value = 'Email';}"/>
                    <textarea onfocus="this.value = '';"
                              onblur="if (this.value == '') {this.value = 'Message';}"></textarea>
                    <input type="submit" value="SUBMIT">
                </form>
            </div>
            <div class="col-md-4 touch-right">
                <div class="touch-right-top">
                    <span class="add"> </span>
                    <h4>123 MAIN STREET,<label>CITY, COUNTRY</label></h4>
                </div>
                <div class="touch-right-top">
                    <span class="mail"> </span>
                    <p><a href="mailto:me@jintienan.com">ME@JINTIENAN>COM</a></p>
                </div>
                <div class="touch-right-top">
                    <span class="num"> </span>
                    <p>+0123 456 789</p>
                </div>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- footer -->
<jsp:include page="component/footer.jsp"></jsp:include>
<!---->
<script type="text/javascript">
    $(document).ready(function () {
        /*
         var defaults = {
         containerID: 'toTop', // fading element id
         containerHoverID: 'toTopHover', // fading element hover id
         scrollSpeed: 1200,
         easingType: 'linear'
         };
         */
        $().UItoTop({easingType: 'easeOutQuart'});
    });
</script>
<a href="#to-top" id="toTop" style="display: block;"> <span id="toTopHover" style="opacity: 1;"> </span></a>
<!---->


</body>
</html>		
	