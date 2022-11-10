<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>JSP02</title>
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
.postDiv {
    }
    
input {
    margin : 10px;
}

</style>
</head>
<body>
    <div class="mainDiv">
        <h1>포스트 작성 페이지</h1>

        <nav>
            <ul class="nav justify-content-center">
                <li class="nav-item">
                    <c:url var="mainPage" value="/"></c:url>
                    <a class="nav-link" href="${mainPage}" style="color: gray;">메인페이지</a>
                </li>
                <li class="nav-item">
                    <c:url var="postList" value="/post"></c:url>
                    <a class="nav-link" href="${postList}" style="color: gray;">목록페이지</a>
                </li>
            </ul>
        </nav>
        <main>
        <!-- form의 action 속성: 요청을 보내는 주소. 생략된 경우에는 현재 페이지로 요청을 보냄 -->
            <form method="post">
            <div class="postDiv">
                <div>
                    <input type="text" name="title" placeholder="제목"
                        required autofocus size=48/>
                </div>
                <div>
                    <textarea rows="10" cols="50" name="content"
                        placeholder="내용" required></textarea>
                </div>
                <div>
                    <input type="text" name="author" placeholder="작성자" 
                    required size=48/>
                </div>
                <div>
                    <input type="submit" value="작성 완료" />
                </div>
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