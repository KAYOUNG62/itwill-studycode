<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>


    <%
    request.setCharacterEncoding("UTF-8");
    String username = request.getParameter("username");

    %>

    <h1>결과페이지</h1>
    <h2>username</h2>

</body>
</html>