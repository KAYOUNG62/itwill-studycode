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
input {
    margin : 5px;
}
a {
    color: black;
    text-decoration: none;
}
label {
    margin : 3px;
}
.nav-link {
    font-weight: bold;
}
</style>
</head>
<body>
    <div class="mainDiv">
        <h1>포스트 상세 페이지</h1>
        <nav>
        <ul>
            <c:if test="${not empty signInUser }">
                <li class="nav-item">
                    <c:url var="signOutPage" value="/user/signout"></c:url>
                    <h6><samp style="color: blue">${signInUser}</samp>님 환영합니다</h6>
                    <a class="nav-link active" aria-current="page" href="${signOutPage}" style="font-size: 15px; text-decoration: none;">로그아웃</a>
                </li>
            </c:if>
        </ul>
            <ul class="nav justify-content-center">
                <li class="nav-item">
                    <c:url var="mainPage" value="/"></c:url>
                    <a class="nav-link" href="${mainPage}" style="color: gray;">메인페이지</a>
                </li>
                <li class="nav-item">
                    <c:url var="postList" value="/post"></c:url>
                    <a class="nav-link" href="${postList}" style="color: gray;">목록페이지</a>
                </li>
                <c:if test="${signInUser == post.author && signInUser == 'admin'}">
                <li class="nav-item">
                    <c:url var="postModifyPage" value="/post/modify">
                        <c:param name="id" value="${post.id}"></c:param>
                    </c:url>
                    <a class="nav-link" href="${postModifyPage}" style="color: gray;">수정페이지</a>
                </li>
                </c:if>              
            </ul>
        </nav>
        <main>
            <form>
                <div>
                    <label for="id">번호</label>
                    <input id="id" type="text" name='id' value="${post.id}" readonly size=48/>
                </div>
                <div>
                    <label for="title">제목</label>
                    <input id="title" type="text" value="${post.title}" readonly autofocus size=48 />
                </div>
                <div>
                    <label for="content">내용</label>
                    <textarea id="content" type="text" rows="10" cols="50" readonly>${post.content}</textarea>
                </div>
                <div>
                    <label for="author">작성자</label>
                    <input id="author" type="text" value="${post.author}" readonly size=46/>
                </div>
                <div>
                    <label id="createdTime">작성시간</label>
                    <input id="createdTime" type="text" value="${post.createdTime}" readonly size=45 />
                </div>
                <div>
                    <label id="modifiedTime">수정시간</label>
                    <input id="modifiedTime" type="text" value="${post.modifiedTime}" readonly size=45 />
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