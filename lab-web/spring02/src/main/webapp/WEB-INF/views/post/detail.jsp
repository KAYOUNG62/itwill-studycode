<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <div>
        <div>
            <h1>상세 페이지</h1>
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
                <li>
                    <c:url var="postModify" value="/post/modify"/>
                    <a href="${postModify}">수정페이지</a>
                </li>                
            </ul>
        </nav>
        <main>
            <form>
                <div>
                    <label id="id">번호</label>
                    <input id="id" type="text" name="id" value="${post.id}" readonly/>
                </div>
                <div>
                    <label id="title">제목</label>
                    <input id="title" type="text" name="title" value="${post.title}" readonly/>
                </div>
                <div>
                    <label id="content">내용</label>
                    <textarea id="content" type="text" rows="10" cols="50" readonly>${post.content}</textarea>
                </div>
                <div>
                    <label id="author">작성자</label>
                    <input id="author" type="text" name="author" value="${post.author}" readonly/>
                </div>
                <div>
                    <label id="createdTime">작성시간</label>
                    <input id="createdTime" type="text" value="${post.created_time}" readonly/>
                </div>
                <div>
                    <label id="modifiedTime">수정시간</label>
                    <input id="modifiedTime" type="text" value="${post.modified_time}" readonly/>
                </div>                                
            </form>
        </main>
    </div>
</body>
</html>