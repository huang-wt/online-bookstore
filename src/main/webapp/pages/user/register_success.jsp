<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Account Created</title>
    <%-- base, css, jquery --%>
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }

        h1 a {
            color:red;
        }
    </style>
</head>
<body>
<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word"></span>
    <%@ include file="/pages/common/login_success_menu.jsp"%>
</div>

<div id="main">

    <h1>Register Successfully! <a href="index.jsp">Home Page</a></h1>

</div>

<%@include file="/pages/common/footer.jsp"%>

</body>
</html>