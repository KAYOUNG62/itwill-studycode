<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>
    <div>
        <h1>회원 상세 정보</h1>
        <nav>
            <ul>
                <li>
                    <c:url var="mainPage" value="/"></c:url>
                    <a href="${mainPage}">메인페이지</a>
                </li>
                <li>
                    <c:url var="userList" value="/user"></c:url>
                    <a href="${userList}">회원 목록</a>
                </li>
                <li>
                    <c:url var="userModify" value="/user/userModify">
                        <c:param name="id" value="${user.id}"></c:param>                    
                    </c:url>
                    <a href="${userModify}">회원 정보 수정</a>
                </li>
            </ul>        
        </nav>
        <main>
            <div>
                <label for="id">회원번호</label>
                <input id="id" type="text" value="${user.id}" readonly/>
           </div>
            <div>
                <label for="username">아이디</label>
                <input id="username" type="text" value="${user.username}" readonly/>
           </div>
           <div>
                <label for="password">비밀번호</label>
                <input id="password" type="text" value="${user.password}" readonly/>
           </div>
           <div>
                <label for="email">이메일</label>
                <input id="email" type="text" value="${user.email}" readonly/>
           </div>
           <div>
                <label for="points">포인트</label>
                <input id="points" type="text" value="${user.points}" readonly/>
           </div>
        </main>
    </div>
</body>
</html>