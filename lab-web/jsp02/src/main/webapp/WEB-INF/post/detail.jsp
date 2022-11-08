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
        <h1>포스트 상세 페이지</h1>
            
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
                <li>
                    <c:url var="postModifyPage" value="/post/modify">
                        <c:param name="id" value="${post.id}"></c:param>
                    </c:url>
                    <a href="${postModifyPage}">포스트 수정 페이지</a>
                </li>
            </ul>
        </nav>
        <main>
            <form>
                <div>
                    <label for="id">번호</label>
                    <input id="id" type="text" value="${post.id}" readonly />
                </div>
                <div>
                    <label for="title">제목</label>
                    <input id="title" type="text" value="${post.title}" readonly autofocus/>
                </div>
                <div>
                    <label for="content">내용</label>
                    <textarea id="content" type="text" rows="10" cols="50" readonly>${post.content}</textarea>
                </div>
                <div>
                    <label for="author">작성자</label>
                    <input id="author" type="text" value="${post.author}" readonly />
                </div>
                <div>
                    <label id="createdTime">작성시간</label>
                    <input id="createdTime" type="text" value="${post.createdTime}" readonly />
                </div>
                <div>
                    <label id="modifiedTime">수정시간</label>
                    <input id="modifiedTime" type="text" value="${post.modifiedTime}" readonly />
                </div>                
                
            </form>
        </main>
        
    
    </div>
</body>
</html>