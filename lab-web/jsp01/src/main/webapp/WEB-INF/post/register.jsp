<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
<style>
input {
    margin : 8px;
}

textarea {
    margin : 8px;
}
</style>
</head>
<body>
 
    <h1>글작성</h1>
    <form method="post">
        <input type="number" name="id" placeholder="번호" required autofocus/>
        <br/>
        <input type="text" name="title" placeholder="제목" />
        <br/>
        <textarea rows="10" cols="50" name="content" placeholder="내용"> </textarea>
        <br/>
        <input type="datetime-local" name="createTime" />
        <br/>
        <input type="submit" value="등록" />
    </form>
</body>
</html>