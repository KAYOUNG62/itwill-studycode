<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserList</title>
</head>
<body>
    <div>
        <h1>회원 전체 목록</h1>
    <nav>
        <ul>
            <li>
                <c:url var="mainPage" value="/"></c:url>
                <a href="${mainPage}">메인페이지</a>
            </li>
            <li>
                <c:url var="userCreatePage" value="/user/userCreate"></c:url>
                <a href="${userCreatePage}">User 추가</a>
            </li>
        </ul>
    </nav>
    <main>
        <table>
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