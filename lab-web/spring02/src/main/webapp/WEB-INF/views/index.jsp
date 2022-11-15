<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring 2</title>
</head>
<body>
    <div>
        <div>
            <h1>메인 페이지</h1>
        </div>
        
        <ul>
            <li>
                <c:url var="postList" value="/post/list" /> 
                <a href="${postList}">글 전체 목록</a>           
            </li>
        </ul>


    </div>
</body>
</html>