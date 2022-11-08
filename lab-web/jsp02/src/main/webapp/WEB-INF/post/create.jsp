<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP02</title>
</head>
<body>
    <div>
        <h1>포스트 작성 페이지</h1>

        <nav>
            <ul>
                <li>
                    <c:url var="mainPage" value="/"></c:url>
                    <a href="${mainPage}">메인페이지</a>
                </li>
                <li>
                    <c:url var="listPage" value="/post"></c:url>
                    <a href="${listPage}">목록페이지</a>
                </li>
            </ul>
        </nav>
        <main>
        <!-- form의 action 속성: 요청을 보내는 주소. 생략된 경우에는 현재 페이지로 요청을 보냄 -->
            <form method="post">
                <div>
                    <input type="text" name="title" placeholder="제목"
                        required autofocus />
                </div>
                <div>
                    <textarea rows="10" cols="50" name="content"
                        placeholder="내용" required></textarea>
                </div>
                <div>
                    <input type="text" name="author" placeholder="작성자" required/>
                </div>
                <div>
                    <input type="submit" value="작성 완료" />
                </div>
            </form>
        </main>
    </div>
</body>
</html>