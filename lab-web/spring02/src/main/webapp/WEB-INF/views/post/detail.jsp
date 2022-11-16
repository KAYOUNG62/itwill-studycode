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
            <h2>Post Detail Page</h2>
        </header>
        
        <nav class="bg-light">
            <ul class="nav ">
                <li class="nav-item">
                    <c:url var="postMain" value="/"/>
                    <a class="nav-link active" href="${postMain}">Main</a>
                </li>
                <li class="nav-item">
                    <c:url var="postList" value="/post/list"/>
                    <a class="nav-link active" href="${postList}">Post List</a>
                </li>
                <li class="nav-item">
                    <c:url var="postModifyPage" value="/post/modify">
                        <c:param name="id" value="${post.id}" />
                    </c:url>
                    <a class="nav-link active" href="${postModifyPage}">Rewrites</a>
                </li>
            </ul>
        </nav>
        <main class="my-4">
            <div class="card">
                <div class="card-header"></div>
                <div class="card-body">
                    <form>
                        <div>
                            <label for="id" class="form-label">Post Number</label>
                            <input id="id" class="form-control" value="${post.id}" readonly/>
                        </div>
                        <div>
                            <label for="title" class="form-label">Title</label>
                            <input id="title" class="form-control" value="${post.title}" readonly/>
                        </div> 
                        <div>
                            <label for="content" class="form-label">Content</label>
                            <textarea id="content" class="form-control" rows="5" cols="40" readonly>${post.content}</textarea>
                        </div> 
                        <div>
                            <label for="author" class="form-label">Author</label>
                            <input id="author" class="form-control" value="${post.author}" readonly/>
                        </div> 
                        <div>
                            <label for="created_time" class="form-label">CreatedTime</label>
                            <input id="created_time" class="form-control" value="${post.created_time}" readonly/>
                        </div> 
                        <div>
                            <label for="modified_time" class="form-label">ModifiedTime</label>
                            <input id="modified_time" class="form-control" value="${post.modified_time}" readonly/>
                        </div>                  
                    </form>
                </div>
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