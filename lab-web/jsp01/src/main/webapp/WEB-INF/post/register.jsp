<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>

    <h1>글작성</h1>
    <form method="post">
        <input type="number" name="id" placeholder="아이디" />
        <br/>
        <input type="text" name="title" placeholder="제목" />
        <br/>
        <textarea rows="5" cols="50" name="content"> </textarea>
        <br/>
        <input type="datetime" name="creatTime" />
        <br/>
        <input type="submit" value="등록" />
    </form>
</body>
</html>