<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div>
        <div>
            <h1>글 작성</h1>
        </div>
        <nav>
            <ul>
                <li>
                    <c:url var="mainPage" value="/"/>
                    <a href="${mainPage}">메인페이지</a>
                </li>
                <li>
                    <c:url var="postList" value="/post/list"/>
                    <a href="${postList}">목록페이지</a>
                </li>
            </ul>
        </nav>
        <main>
            <c:url var="postCreate" value="/post/list" />
            <form action="${postCreate}" method="post">
                <div>
                    <input type="text" name="title" placeholder="제목" required autofocus/>
                </div>  
                <div>
                    <textarea rows="10" cols="50" name="content" placeholder="내용"></textarea>
                </div>     
                <div>
                    <input type="text" name="author" placeholder="작성자" required autofocus/>
                </div>
                <div>
                    <input type="submit" value="저장" />
                </div>              
            </form>
        </main>
    </div>
</body>
</html>