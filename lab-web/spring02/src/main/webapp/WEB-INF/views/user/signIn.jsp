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
            <h2>SignIn</h2>
        </header>
        
        <nav class="bg-light">
            <ul class="nav">
                <li class="nav-item">
                    <c:url var="mainPage" value="/"></c:url>
                    <a class="nav-link active" href="${mainPage}">Main</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">LINK 2</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link disabled" href="#">LINK 3</a>
                </li>
            </ul>
        </nav>
        <main>
            <div class="card w-25" >
                <form class="m-3" method="post">
                    <div class="my-2">
                        <label for="username" class="form-label">UserId</label>                
                        <input id="username" class="form-control" name="username" type="text"  required autofocus />
                    </div>
                    <div class="my-2">
                        <label for="password" class="form-label">Password</label>                
                        <input id="passsword" class="form-control" name="password" type="password" required/>
                    </div>             
                    <div>
                        <input class="form-control btn btn-primary" type="submit" value="signIn"/>
                    </div>
                </form>
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