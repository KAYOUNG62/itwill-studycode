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
            <h2>UserList</h2>
        </header>
        
        <nav class="bg-light">
            <ul class="nav ">
                <li class="nav-item">
                    <c:url var="mainPage" value="/" />
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
         <div class="card my-2">
                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>NUMBER</th>
                            <th>USERNAME</th>
                            <th>PASSWORD</th>
                            <th>EMAIL</th>
                            <th>POINT</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${list}">
                            <tr>
                                <td>${user.id}</td>
                                <td>
                                    <c:url var="userDetailPage" value="/user/detail" >
                                        <c:param name="id" value="${user.id}"></c:param>
                                    </c:url>
                                    <a href="${userDetailPage}">${user.username}</a>
                                </td>
                                <td>${user.password}</td>
                                <td>${user.email}</td>
                                <td>${user.points}</td>
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