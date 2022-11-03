<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<%--
String color = request.getParameter("color");
String colorValue = "";
switch (color) {
case "r":
    colorValue = "IndianRed";
    break;
case "g":
    colorValue = "MediumSeaGreen";
    break;
case "b":
    colorValue = "DodgerBlue";
    break;
default:
    colorValue = "Black";
}
--%>
<c:choose>
    <c:when test="${ param.color == 'r' }">
    <c:set var="colorValue" value="IndianRed"></c:set>
    </c:when>
    <c:when test="${ param.color == 'g' }">
    <c:set var="colorValue" value="MediumSeaGreen"></c:set>
    </c:when>
    <c:when test="${ param.color == 'b' }">
    <c:set var="colorValue" value="DodgerBlue"></c:set>
    </c:when>
    <c:otherwise>
        <c:set var="colorValue" value="Black"></c:set>
    </c:otherwise>
</c:choose>

<html>
<head>
<meta charset="UTF-8">
<title>JSTL</title>
<style>
span {
    color: ${colorValue
}
}
</style>
</head>
<body>
    <h1>JSTL &lt;c:choose&gt;</h1>
    <h2>
        username: <span>${param.username}</span>
    </h2>
    <%--
    <% String username = request.getParameter("username"); %>
    <% if (username.equals("admin")) {%>
    <h3> 관리자 페이지 </h3>
    <% } else { %>
    <h3> 일반 사용자 페이지 </h3>
    <% } %>
    --%>

    <c:choose> <%-- 로그인 로그아웃할때 활용 가능 --%>
        <c:when test="${ param.username == 'admin' }">
            <h3>관리자 페이지</h3>
        </c:when>
        <c:otherwise>
            <h3>일반 사용자 페이지</h3>
        </c:otherwise>

    </c:choose>

</body>
</html>
