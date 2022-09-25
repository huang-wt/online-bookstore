<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basket</title>
    <%-- base, css, jquery --%>
    <%@include file="/pages/common/head.jsp"%>
</head>
<body>

<div id="header">
    <img class="logo_img" alt="" src="static/img/logo.gif" >
    <span class="wel_word">Basket</span>
    <%@ include file="/pages/common/login_success_menu.jsp"%>
    <script type="text/javascript">
        $(function() {
            $("a.deleteItem").click(function () {
                return confirm("Please confirm you want to delete ["
                    + $(this).parent().parent().find("td:first").text() + "].");
                // return false;
            });

            $("#clearCart").click(function () {
                return confirm("Please confirm you want to clear the basket.");
                // return false;
            });

            $(".updateCount").change(function () {
                var name = $(this).parent().parent().find("td:first").text();
                var count = this.value;
                var id = $(this).attr("bookId");
                if (confirm("Update amount of book [" + name + "] to " + count + ".")) {
                    location.href = "http://localhost:8080/bookstore/cartServlet?action=updateCount" +
                        "&id=" + id + "&count=" + count;
                } else {
                    this.value = this.defaultValue;
                }
            });
        });

    </script>
</div>

<div id="main">

    <table>
        <tr>
            <td>Name</td>
            <td>Amount</td>
            <td>Price</td>
            <td>Total Price</td>
            <td>Operation</td>
        </tr>
        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">Empty Basket</a></td>
            </tr>
        </c:if>
        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>
                        <input class="updateCount" style="width: 80px"
                               bookId="${entry.value.id}"
                               type="text" value="${entry.value.count}">
                    </td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPriceAmount}</td>
                    <td><a class="deleteItem" href="cartServlet?action=deleteItem&id=${entry.value.id}">Delete</a></td>
                </tr>
            </c:forEach>
        </c:if>

    </table>

    <div class="cart_info">
        <c:if test="${not empty sessionScope.cart.items}">
            <span class="cart_span">Subtotal (<span class="b_count">${sessionScope.cart.totalCount}</span> items): </span>
            <span class="cart_span">£<span class="b_price">${sessionScope.cart.totalPriceAmount}</span></span>
            <span class="cart_span"><a id="clearCart" href="cartServlet?action=clear">Clear Basket</a></span>
            <span class="cart_span"><a href="orderServlet?action=createOrder">Proceed to Checkout</a></span>
        </c:if>
    </div>

</div>

<%@include file="/pages/common/footer.jsp"%>
</body>
</html>