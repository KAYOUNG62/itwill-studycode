<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>MVC</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
    crossorigin="anonymous">
<style>
.mainDiv {
    text-align: center;
}

.title {
    font-size: 40px;
    font-weight: bold;
    margin: 20px;
    padding: 10px;
}
.card {
    margin : 30px auto;
    max-width: 500px;
}
ul {
    list-style: none;
}
a {
    text-decoration: none;
    color: black;
}
</style>
</head>
<body>
    <div class="mainDiv">
        <div>
            <h1 class="title">메인 페이지</h1>
        </div>
        
        <ul class="nav justify-content-center">
        <%-- 로그인 정보가 있는 경우 --%>
        <%-- EL not empty 연산자: not null , 빈 문자열이 아닌 경우 --%>    
            <c:if test="${not empty signInUser }">
                <li class="nav-item">
                    <c:url var="signOutPage" value="/user/signout"></c:url>
                    <h6><samp style="color: blue">${signInUser}</samp>님 환영합니다</h6>
                    <a class="nav-link active" aria-current="page" href="${signOutPage}">로그아웃</a>
                </li>
            </c:if>
            <%-- 로그인 정보가 없는 경우 --%>
            <c:if test="${empty signInUser}">
                <li class="nav-item" >
                    <c:url var="signInPage" value="/user/signin"></c:url>
                    <a class="nav-link active" aria-current="page" href="${signInPage}">로그인</a>            
                </li>
                <li class="nav-item">
                    <c:url var="signUpPage" value="/user/signup"></c:url>
                    <a class="nav-link active" aria-current="page" href="${signUpPage}">회원가입</a>
                </li>
            
            </c:if>
            
        </ul>
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Post List</h4>
                </div>
                <div class="card-footer text-muted">
                    <a href="post" class="btn btn-primary">View</a>
                </div>
            </div>
                <c:if test="${signInUser eq 'admin'}">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">User List</h4>
                </div>
                <div class="card-footer text-muted">
                    <a href="user" class="btn btn-primary">View</a>
                </div>
            </div>
                </c:if>
        </div>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>