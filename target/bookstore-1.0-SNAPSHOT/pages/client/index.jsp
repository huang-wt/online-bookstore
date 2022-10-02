<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Book Store</title>
    <%-- base, css, jquery --%>
    <%@include file="/pages/common/head.jsp"%>
    <script type="text/javascript">
        $(function () {
            // Search page button for directing to a specifc page when clicking
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

            // Add to Cart Button for calling cartServlet.addItem() method
            $("button.addToCart").click(function () {
                var bookId = $(this).attr("bookId");
                location.href = "http://localhost:8080/bookstore/cartServlet?action=addItem&id=" + bookId;
            });
        });
    </script>
</head>
<body>
    <div id="header">
        <img class="logo_img" alt="" src="static/img/logo.gif" >
        <!--			<span class="wel_word">Online Bookstore</span>-->
        <div>
            <!-- menu bar before user sign in -->
            <c:if test="${empty sessionScope.user}">
                <a href="pages/user/login.jsp">Sign in</a> |
                <a href="pages/user/register.jsp">Sign up</a> |
            </c:if>
            <!-- menu bar after user sign in -->
            <c:if test="${not empty sessionScope.user}">
                <span>Welcome<span class="um_span">${sessionScope.user.username}</span>to our Bookstore!</span> |
                <a href="userServlet?action=logout">Logout</a>&nbsp;|
                <a href="pages/order/order.jsp">Orders</a> |
            </c:if>
            <a href="pages/cart/cart.jsp">Basket</a> |
            <a href="pages/manager/manager.jsp">Management</a>
        </div>
    </div>

    <div id="main">
        <div id="book">
            <div class="book_cond">
                <form action="client/bookServlet" method="get">
                    <input type="hidden" name="action" value="pageByPrice">
                    Price Range：
                    £ <input id="min" type="text" name="min" value="${param.min}"> -
                    &nbsp;£ <input id="max" type="text" name="max" value="${param.max}">
                    <input type="submit" value="Search" />
                </form>
            </div>
            <div style="text-align: center">
                <span>There are ${sessionScope.cart.totalCount} items in your Basket.</span>
                <c:if test="${empty sessionScope.cart.items}">
                    <div>
                        Click [Add to Basket] button to add books.
                    </div>
                </c:if>
                <c:if test="${not empty sessionScope.cart.items}">
                    <div>
                        You just added <span style="color: red">${sessionScope.lastBookName}</span> to your Basket.
                    </div>
                </c:if>

            </div>

            <c:forEach items="${requestScope.page.items}" var="book">
                <div class="b_list">
                    <div class="img_div">
                        <img class="book_img" alt="" src="${book.imgPath}" />
                    </div>
                    <div class="book_info">
                        <div class="book_name">
                            <span class="sp1">&nbsp;&nbsp;&nbsp;Name:</span>
                            <span class="sp2">${book.name}</span>
                        </div>
                        <div class="book_author">
                            <span class="sp1">&nbsp;&nbsp;&nbsp;Author:</span>
                            <span class="sp2">${book.author}</span>
                        </div>
                        <div class="book_price">
                            <span class="sp1">&nbsp;&nbsp;&nbsp;Price:</span>
                            <span class="sp2">${book.price}</span>
                        </div>
                        <div class="book_sales">
                            <span class="sp1">&nbsp;&nbsp;&nbsp;Sales:</span>
                            <span class="sp2">${book.sales}</span>
                        </div>
                        <div class="book_amount">
                            <span class="sp1">&nbsp;&nbsp;&nbsp;Stock:</span>
                            <span class="sp2">${book.stock}</span>
                        </div>
                        <div></div>
                        <div class="book_add">
                            &nbsp;&nbsp;&nbsp;
                            <button bookId="${book.id}" class="addToCart">Add to Basket</button>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>

        <%@include file="/pages/common/page_nav.jsp"%>

    </div>

    <%@include file="/pages/common/footer.jsp"%>
</body>
</html>