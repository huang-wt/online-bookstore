<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Books</title>
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

        input {
            text-align: center;
        }
    </style>
</head>
<body>
    <div id="header">
        <img class="logo_img" alt="" src="static/img/logo.gif" >
        <span class="wel_word">Edit Books</span>
        <%@ include file="/pages/common/manager_menu.jsp"%>
    </div>

    <div id="main">
        <form action="manage/bookServlet" method="post">
            <input type="hidden" name="pageNo" value="${param.pageNo}">
            <input type="hidden" name="id" value="${param.id}"> <%--requestScope.book.id--%>
            <input type="hidden" name="action" value="${param.method}">
    <%--    <input type="hidden" name="action" value="${empty param.id ? "add" : "update"}">--%>
    <%--    <input type="hidden" name="action" value="${empty requestScope.book ? "add" : "update"}">--%>
            <table>
                <tr>
                    <td>Name</td>
                    <td>Price</td>
                    <td>Author</td>
                    <td>Sales</td>
                    <td>Stock</td>
                    <td colspan="2">Operations</td>
                </tr>
                <tr>
                    <td><input name="name" type="text" value="${requestScope.book.name}"/></td>
                    <td><input name="price" type="text" value="${requestScope.book.price}"/></td>
                    <td><input name="author" type="text" value="${requestScope.book.author}"/></td>
                    <td><input name="sales" type="text" value="${requestScope.book.sales}"/></td>
                    <td><input name="stock" type="text" value="${requestScope.book.stock}"/></td>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form>


    </div>

    <%@include file="/pages/common/footer.jsp"%>
</body>
</html>