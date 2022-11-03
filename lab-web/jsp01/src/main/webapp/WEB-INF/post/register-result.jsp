<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style>
div {
    margin : 8px;
}
</style>
</head>
<body>
    <h1>글 상세보기</h1>
    <div>
        <input type="number" value=" ${post.id}" readonly/>
    </div>
    <div>
        <input type="text" value=" ${post.title}" readonly/>
    </div>
    <div>
        <textarea rows="10" cols="50" >${post.content}</textarea>
    </div>
    <div>
        <input type="datetime-local" value="${post.createTime}" readonly/>
    </div>
</body>
</html>