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
        <h1>포스트 전체 목록 페이지</h1>

        <nav>
            <!-- 웹서버 내에서 이동 메뉴 -->
            <ul>
                <li><a href="/jsp02">메인페이지</a></li>
                <li><a href="post/create">포스트 작성</a></li>
            </ul>
        </nav>

        <main>
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
                    <c:forEach var="p" items="${posts}">
                        <tr>
                            <td>${p.id}</td>
                            <td>${p.title}</td>
                            <td>${p.author}</td>
                            <td>${p.modifiedTime}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </main>

    </div>



</body>
</html>