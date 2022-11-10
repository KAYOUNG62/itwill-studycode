<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>UserList</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
    crossorigin="anonymous">
<style>
.mainDiv {
    text-align: center;
}
h1 {
    font-size: 36px;
    font-weight: bold;
    margin: 16px;
    padding: 10px;
}
table {
    margin: 30px auto;
    max-width: 1000px;
}
a {
    color: black;
    text-decoration: none;
}
</style>
</head>
<body>
    <div class="mainDiv">
        <h1>회원 전체 목록</h1>
    <nav>
        <ul class="nav justify-content-center">
            <li class="nav-item">
                <c:url var="mainPage" value="/"></c:url>
                <a class="nav-link" href="${mainPage}" style="color: gray;">메인페이지</a>
            </li>
            <li class="nav-item">
                <c:url var="userCreatePage" value="/user/signup"></c:url>
                <a class="nav-link" href="${userCreatePage}" style="color: gray;">User 추가</a>
            </li>
        </ul>
    </nav>
    <main>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>회원번호</th>
                    <th>아이디</th>
                    <th>비밀번호</th>
                    <th>이메일</th>
                    <th>포인트</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="u" items="${users}">
                <tr>
                    <td>${u.id}</td>
                    <td>
                        <c:url var="userDetailPage" value="/user/userDetail">
                            <c:param name="id" value="${u.id}"></c:param>
                        </c:url>
                        <a href="${userDetailPage}">${u.username}</a>
                    </td>
                    <td>${u.password}</td>
                    <td>${u.email}</td>
                    <td>${u.points}</td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
    </main>
    </div>
</body>
</html>