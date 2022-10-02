<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Back-stage Management</title>
    <%-- base, css, jquery --%>
    <%@include file="/pages/common/head.jsp"%>
    <style type="text/css">
        h1 {
            text-align: center;
            margin-top: 200px;
        }
    </style>
</head>
<body>

    <div id="header">
        <img class="logo_img" alt="" src="static/img/logo.gif" >
        <span class="wel_word">Management System</span>
        <%@ include file="/pages/common/manager_menu.jsp"%>
    </div>

    <div id="main">
        <h1>Welcome to Management System</h1>
    </div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>