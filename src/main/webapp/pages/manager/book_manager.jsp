<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Management</title>
    <%-- base, css, jquery --%>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            $("a.deleteClass").click(function () {
                return confirm("Please confirm you want to delete ["
                    + $(this).parent().parent().find("td:first").text() + "].");
                // return false;
            });

            $("#searchPageBtn").click(function () {
                var pageNo = $("#pn_input").val();

                var pagesTotalNumber = ${requestScope.page.pagesTotalNumber};
                if (pageNo < 1) {
                    // alert()
                    pageNo = 1;
                } else if (pageNo > pagesTotalNumber) {
                    pageNo = pagesTotalNumber;
                }

                location.href = "http://localhost:8080/bookstore/${requestScope.page.url}&pageNo=" + pageNo;
            });
        });
    </script>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">Book Management System</span>
    <%@ include file="/pages/common/manager_menu.jsp"%>
</div>

<div id="main">
    <table>
        <tr>
            <td>Name</td>
            <td>Price</td>
            <td>Author</td>
            <td>Sales</td>
            <td>Stock</td>
            <td colspan="2">Operations</td>
        </tr>

        <c:forEach items="${requestScope.page.items}" var="book">
            <tr>
                <td>${book.name}</td>
                <td>${book.price}</td>
                <td>${book.author}</td>
                <td>${book.sales}</td>
                <td>${book.stock}</td>
                <td><a href="manage/bookServlet?action=getBook&id=${book.id}&method=update&pageNo=${requestScope.page.pageNo}">Modify</a></td>
<%--                <td><a href="manage/bookServlet?action=getBook&id=${book.id}">Modify</a></td>--%>
                <td><a class="deleteClass" href="manage/bookServlet?action=delete&id=${book.id}&pageNo=${requestScope.page.pageNo}">Delete</a></td>
            </tr>
        </c:forEach>


        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><a href="pages/manager/book_edit.jsp?method=add&pageNo=${requestScope.page.pagesTotalNumber}">Add Book</a></td>
<%--            <td><a href="pages/manager/book_edit.jsp">Add Book</a></td>&ndash;%&gt;--%>
        </tr>
    </table>

    <%@include file="/pages/common/page_nav.jsp"%>
</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>