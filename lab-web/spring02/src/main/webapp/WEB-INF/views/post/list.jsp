<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring </title>
</head>
<body>
    <div>
        <div>
            <h1>Post List</h1>
        </div>
        
        <ul>
            <li>
                <c:url var="mainPage" value="/"/>
                <a href="${mainPage}">메인페이지</a>
            </li>
            <li>
                <c:url var="postCreate" value="/post/create"/>
                <a href="${postCreate}">글 작성</a>
            </li>
        </ul>
        
        <div>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>수정 시간</th>
                    </tr>
                </thead>      
                <tbody>
                    <c:forEach var="post" items="${post}">
                        <tr>
                            <td>${post.id}</td>
                            <td><c:url var="postDetail" value="/post/detail">
                                    <c:param name="id" value="${post.id}"></c:param>
                                </c:url>
                                <a href="${postDetail}"> ${post.title}</a>
                            </td>
                            <td>${post.author}</td>
                            <td>${post.modified_time}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>