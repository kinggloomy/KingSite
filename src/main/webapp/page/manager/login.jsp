<%@ page language="java" pageEncoding="UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    
    <base href=<%=basePath%>/>
    <title>Signin Template for Bootstrap</title>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <%-- <link href="../../assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">--%>
    <!-- Custom styles for this template -->
    <jsp:include page="/page/component/css.jsp"/>
    <jsp:include page="/page/component/script.jsp"/>
    <link href="static/css/login.css" rel="stylesheet">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container">
    <form class="form-signin" action="manager/login">
        <h2 class="form-signin-heading" align="center">Please sign in</h2>
        <br>
        <label for="userCode" class="sr-only">UserCode</label>
        <input type="text" id="userCode" name="userCode" class="form-control" placeholder="UserCode" required="" autofocus="">
        <br>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="">
        <%--<div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> Remember me
            </label>
        </div>--%>
        <br>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
</div>
</body>
</html>