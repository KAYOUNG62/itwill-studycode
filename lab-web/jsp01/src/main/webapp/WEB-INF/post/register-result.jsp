<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
    <h1>글 상세보기</h1>
    <div>
        <label>아이디</label>
        <input type="number" value=" ${post.id}" readonly/>
    </div>
    <div>
        <label>제목</label>
        <input type="text" value=" ${post.title}" readonly/>
    </div>
    <div>
        <label>본문</label>
        <textarea rows="5" cols="50" > ${post.content} </textarea>
    </div>
    <div>
        <label>날짜</label>
        <input type="datetime" value="${post.createTime}" readonly/>
    </div>
</body>
</html>