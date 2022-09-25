<%--
  Created by IntelliJ IDEA.
  User: huangwentao
  Date: 21/09/2022
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div>
  <span>Welcome<span class="um_span">${sessionScope.user.username}</span>to our Bookstore!</span>
  <a href="pages/order/order.jsp">Orders</a>
  <a href="userServlet?action=logout">Logout</a>&nbsp;&nbsp;
  <a href="index.jsp">Return</a>
</div>