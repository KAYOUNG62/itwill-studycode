<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>User</title>
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
    font-size: 35px;
    font-weight: bold;
    margin: 15px;
    padding: 10px;
}

</style>
</head>
<body>
    <div class="mainDiv">
        <h1 class="title">회원 가입</h1>
        <nav>
            <ul class="nav justify-content-center">
                <li class="nav-item">
                    <c:url var="mainPage" value="/"></c:url>
                    <a class="nav-link" href="${mainPage}" style="color: gray;">메인페이지</a>
                </li>
            </ul>       
        </nav>
        <main>
            <form method="post">
                <div>
                <!-- name은 요청 파라미터의 이름이 됨 -->
                    <input type="text" name="username" placeholder="아이디" autofocus required/>            
                </div>
                <div>
                    <input type="password" name="password" placeholder="비밀번호" required/>            
                </div>
                <div>
                    <input type="email" name="email" placeholder="이메일" required/>            
                </div>
                <div>
                    <input type="submit" value="회원가입" />            
                </div>
            </form>
        </main>
    </div>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous">
    </script>
</body>
</html>