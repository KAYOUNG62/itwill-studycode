<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style>
th, td, th {
padding : 5px;
}

</style>
</head>
<body>

    <h1>전체 글 목록</h1>
    <table>
        <thead>
            <tr>
                <th>글번호</th>
                <th>제목</th>
                <th>내용</th>
                <th>작성시간</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${list}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.title}</td>
                    <td>${p.content}</td>
                    <td>${p.createTime}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>