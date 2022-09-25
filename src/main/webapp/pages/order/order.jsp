<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Orders</title>
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
    <span class="wel_word">My Orders</span>
    <%@ include file="/pages/common/login_success_menu.jsp"%>
</div>

<div id="main">

    <table>
        <tr>
            <td>Date</td>
            <td>Price</td>
            <td>Status</td>
            <td>Details</td>
        </tr>

        <tr>
            <td>01/09/2022</td>
            <td>190.00</td>
            <td>Completed</td>
            <td><a href="#">details</a></td>
        </tr>
    </table>


</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>