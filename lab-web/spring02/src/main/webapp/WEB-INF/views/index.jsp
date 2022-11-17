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
            <h2>Main</h2>
        </header>
        
        <nav class="bg-light">
                <ul class="nav ">
                    <li class="nav-item">
                        <c:url var="postListPage" value="/post/list"></c:url>
                        <a class="nav-link active" href="${postListPage}">Post List</a>
                    </li>
                    <li class="nav-item">
                        <c:url var="signInPage" value="/user/signIn"></c:url>
                        <a class="nav-link active" href="${signInPage}">SignIn</a>
                    </li>
                    <li class="nav-item">
                        <c:url var="signUpPage" value="/user/signUp"></c:url>
                        <a class="nav-link active" href="${signUpPage}">SignUp</a>
                    </li>
                    <li class="nav-item">
                        <c:url var="userList" value="/user/userList"></c:url>
                        <a class="nav-link active" href="${userList}">UserList</a>
                    </li>                    
                </ul>
        </nav>
        <main> <!-- TODO: main content -->
                    
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