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
li {
    font-size: 20px;
    font-weight: bold;
}
.title {
    font-size: 40px;
    font-weight: bold;
    margin: 20px;
    padding: 10px;
}
nav{
    margin: 30px auto;
    max-width: 500px;
}
table {
    margin: 30px auto;
    max-width: 1000px;
}
a {
    color: black;
    text-decoration: none;
}
.nav-link active {
    display: inline-block;
}
</style>
</head>
<body>
    <div class="mainDiv">
        <c:if test="${searchPage}">
            <h1 class="title">포스트 검색 결과</h1>
        </c:if>
        <c:if test="${not searchPage}">
            <h1 class="title">포스트 전체 목록</h1>
        </c:if>
        <!-- 웹서버 내에서 이동 메뉴 -->
        <nav>
        <ul class="nav justify-content-center">
        <%-- 로그인 정보가 있는 경우 --%>
        <%-- EL not empty 연산자: not null , 빈 문자열이 아닌 경우 --%>    
            <c:if test="${not empty signInUser }">
                <li class="nav-item">
                    <c:url var="signOutPage" value="/user/signout"></c:url>
                    <h6><samp style="color: blue">${signInUser}</samp>님 환영합니다</h6>
                    <a class="nav-link active" aria-current="page" href="${signOutPage}" style="font-size: 15px;">로그아웃</a>
                </li>
            </c:if>
            <%-- 로그인 정보가 없는 경우 --%>
            <c:if test="${empty signInUser}">
                <li class="nav-item" >
                    <c:url var="signInPage" value="/user/signin"></c:url>
                    <a class="nav-link active" aria-current="page" href="${signInPage}" style="font-size: 15px;">로그인</a>            
                </li>
                <li class="nav-item">
                    <c:url var="signUpPage" value="/user/signup"></c:url>
                    <a class="nav-link active" aria-current="page" href="${signUpPage}" style="font-size: 15px;">회원가입</a>
                </li>
            
            </c:if>
            
        </ul>
            <ul class="nav justify-content-center">
                <li class="nav-item">
                    <c:url var="mainPage" value="/"></c:url>
                    <a class="nav-link" href="${mainPage}" style="color: gray;">메인페이지</a>
                </li>
                <c:if test="${searchPage }">
                <li class="nav-item">
                    <c:url var="postList" value="/post"></c:url>
                    <a class="nav-link" href="${postList}" style="color: gray;">목록페이지</a>
                </li></c:if>
                 <li class="nav-item">
                    <c:url var="postCreatePage" value="/post/create"></c:url>
                    <a class="nav-link" href="${postCreatePage}" style="color: gray;">포스트 작성</a>
                </li>
            </ul>
        </nav>
        <main>
            <div class = "search">
                <c:url var="postSearchPage" value="/post/search"></c:url>
                <form method="get" action="${postSearchPage}">
                    <select name="type">
                        <option value="t">제목</option>
                        <option value="c">내용</option>
                        <option value="tc">제목+내용</option>
                        <option value="a">작성자</option>
                    </select> 
                    <input type="text" name="keyword" placeholder="검색어" required />
                    <input type="submit" value="검색" />
                </form>
            </div>

            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>수정 시간</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="p" items="${posts}">
                        <tr>
                            <td>${p.id}</td>
                            <td><c:url var="PostDetailPage" value="/post/detail">
                                    <c:param name="id" value="${p.id}"></c:param>
                                </c:url> 
                                <a href="${PostDetailPage}">${p.title}</a>
                            </td>
                            <td>${p.author}</td>
                            <td>${p.modifiedTime}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </main>
    </div>
    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous">
    </script>


</body>
</html>