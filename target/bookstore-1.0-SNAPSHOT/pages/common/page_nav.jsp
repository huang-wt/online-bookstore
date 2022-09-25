<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: huangwentao
  Date: 25/09/2022
  Time: 00:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="page_nav">
    <c:if test = "${requestScope.page.pageNo > 1}">
        <a href="${requestScope.page.url}&pageNo=1">&lt;&lt;&nbsp;</a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo - 1}"> &nbsp;&lt;&nbsp;&nbsp; </a>
    </c:if>

    <c:choose>
        <%--            1-5--%>
        <c:when test="${requestScope.page.pagesTotalNumber <= 5}">
            <c:set var="begin" value="1"/>
            <c:set var="end" value="${requestScope.page.pagesTotalNumber}"/>
        </c:when>
        <%--            >5--%>
        <c:when test="${requestScope.page.pagesTotalNumber > 5}">
            <c:choose>
                <c:when test="${requestScope.page.pageNo <= 3}">
                    <c:set var="begin" value="1"/>
                    <c:set var="end" value="5"/>
                </c:when>
                <c:when test="${requestScope.page.pageNo > requestScope.page.pagesTotalNumber - 3}">
                    <c:set var="begin" value="${requestScope.page.pagesTotalNumber - 4}"/>
                    <c:set var="end" value="${requestScope.page.pagesTotalNumber}"/>
                </c:when>
                <c:otherwise>
                    <c:set var="begin" value="${requestScope.page.pageNo - 2}"/>
                    <c:set var="end" value="${requestScope.page.pageNo + 2}"/>
                </c:otherwise>
            </c:choose>
        </c:when>
    </c:choose>
    <c:forEach begin="${begin}" end="${end}" var="i">
        <c:if test="${i == requestScope.page.pageNo}">
            [${i}]&nbsp;
        </c:if>
        <c:if test="${i != requestScope.page.pageNo}">
            <a href="${requestScope.page.url}&pageNo=${i}">${i}&nbsp;</a>
        </c:if>
    </c:forEach>

    <c:if test = "${requestScope.page.pageNo < requestScope.page.pagesTotalNumber}">
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pageNo + 1}"> &nbsp;&gt;&nbsp; </a>
        <a href="${requestScope.page.url}&pageNo=${requestScope.page.pagesTotalNumber}">&nbsp;&gt;&gt;&nbsp;&nbsp;</a>
    </c:if>
    ${requestScope.page.pagesTotalNumber} pages, ${requestScope.page.itemsTotalNumber} books
    to page #<input value="${param.pageNo}" name="pn" id="pn_input"/>
    <input id="searchPageBtn" type="button" value="direct">
</div>