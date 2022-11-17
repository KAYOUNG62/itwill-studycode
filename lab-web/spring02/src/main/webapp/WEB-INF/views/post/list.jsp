<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Spring 2</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
    crossorigin="anonymous">
</head>
<body>
    <div class="container-fluid">
        <!-- m: margin, y: y축, p:pading-->
        <header class="my-2 p-5 text-center text-bg-secondary">
            <h1>Spring MVC &amp; MyBatis</h1>
            <h2>Post List</h2>
        </header>

        <nav class="bg-light">
                <ul class="nav ">
                    <li class="nav-item">
                        <c:url var="mainPage" value="/" />
                        <a class="nav-link active" href="${mainPage}">Main</a>
                    </li>
                    <li class="nav-item">
                        <c:url var="postList" value="/post/list" />
                        <a class="nav-link" href="${postList}">Post List</a>
                    </li>
                    <li class="nav-item">
                        <c:url var="postCreatePage" value="/post/create" />
                        <a class="nav-link" href="${postCreatePage}">New Post</a>
                    </li>
                    <c:if test="${not empty signInUser}">
                    <li>
                        <c:url var="userSignOut" value="/uset/signOut"></c:url>
                        <h6>${signInUser}님</h6>
                        <a href="${userSignOut}">로그아웃</a>
                    </li>
                    </c:if>
                    <c:if test="${empty signInUser}">
                    <li>
                        <c:url var="userSignIn" value="/user/signIn"></c:url>
                        <a class="nav-link" href="${userSignIn}">SignIn</a>
                    </li>
                    </c:if>                    
                </ul>
        </nav>
        <main class="my-2">
            <div class="bg-light my-2 p-2">
                <c:url var="postSearchPage" value="/post/search"></c:url>
                <form action="${postSearchPage}" method="get">
                    <div class="row"> <!-- div의 합이 12면 한줄에 div가 놓여지는 class -->
                        <div class="col-2">
                            <select class="form-control" name="type">
                                <option value="t">제목</option>
                                <option value="c">내용</option>
                                <option value="tc">제목 + 내용</option>
                                <option value="a">작성자</option>
                            </select>
                        </div>
                        <div class="col-5">
                            <input class="form-control" type="text" name="keyword" placeholder="검색어" required autofocus/>
                        </div>
                        <div class="col-1">
                            <input class="form-control btn btn-outline-success" type="submit" value="검색" />
                        </div>
                    </div>
                </form>
            </div>
            
            <div class="card my-2">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>NUMBER</th>
                            <th>TITLE</th>
                            <th>AUTHOR</th>
                            <th>MODIFIED_TIME</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="post" items="${list}">
                            <tr>
                                <td>${post.id}</td>
                                <td>
                                    <c:url var="postDetailPage" value="/post/detail" >
                                        <c:param name="id" value="${post.id}"></c:param>
                                    </c:url>
                                    <a href="${postDetailPage}">${post.title}</a>
                                    
                                </td>
                                <td>${post.author}</td>
                                <td>${post.modified_time}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </main>
    </div>

    <script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

    <script src="https://code.jquery.com/jquery-3.6.1.min.js"
        integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ="
        crossorigin="anonymous"></script>
</body>
</html>