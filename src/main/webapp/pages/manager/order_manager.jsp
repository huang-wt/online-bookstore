<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Management</title>
    <%-- base, css, jquery --%>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">Order Management</span>
    <%@ include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <table>
        <tr>
            <td>Date</td>
            <td>Price</td>
            <td>Details</td>
            <td>Status</td>

        </tr>
        <tr>
            <td>01/09/2022</td>
            <td>190.00</td>
            <td><a href="#">details</a></td>
            <td>Dispatched</td>
        </tr>
    </table>
</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>