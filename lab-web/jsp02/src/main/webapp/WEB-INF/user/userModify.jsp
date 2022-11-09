<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>
    <div>
        <h1>회원 정보 수정</h1>
        <nav>
            <ul>
                <li>
                    <c:url var="mainPage" value="/"></c:url>
                    <a href="${mainPage}">메인페이지</a>
                </li>
                <li>
                    <c:url var="userList" value="/user"></c:url>
                    <a href="${userList}">회원 목록</a>
                </li>
                <li>
                    <c:url var="userDetail" value="/user/userDetail"></c:url>
                    <a href="${userDetail}">회원 상세 페이지</a>
                </li>
            </ul>        
        </nav>
        <main>
            <form id="userForm">
            <div>
                <label for="id">회원번호</label>
                <input id="id" type="text" name="id" value="${user.id}" readonly/>
           </div>
            <div>
                <label for="username">아이디</label>
                <input id="username" type="text" name="username" value="${user.username}" readonly/>
           </div>
           <div>
                <label for="password">비밀번호</label>
                <input id="password" type="text" name="password" value="${user.password}" required/>
           </div>
           <div>
                <label for="email">이메일</label>
                <input id="email" type="text" name="email" value="${user.email}" required/>
           </div>
           <div>
                <button id="btnUserDelete">회원 삭제</button>
                <button id="btnUserUpdate">정보 수정</button>
           </div>
           </form>
        </main>
    </div>
    <c:url var="userDelete" value="/user/userDelete"></c:url>
    <c:url var="userModify" value="/user/userModify"></c:url>
    <script>
    const form = document.querySelector('#userForm');
    
    const btnUserDelete = document.querySelector('#btnUserDelete');
    btnUserDelete.addEventListener('click', function(event){
        event.preventDefault();
        const check = confirm('정말 탈퇴하시겠습니까?');
        if(check) {
            form.action ='${userDelete}';
            form.method ='post';
            form.submit();
        }
    });
    
    
    
    const btnUserUpdate = document.querySelector('#btnUserUpdate');
    btnUserUpdate.addEventListener('click', function(event){
        event.preventDefault();
        
        const password = document.querySelector('#password');
        const email = document.querySelector('#email');
        
        if(password == '' || email == ''){
        	alert('내용을 입력하세요');
        	return;
        }
        
        const check = confirm('수정하시겠습니까?');
        if(check) {
        	form.action ='${userModify}';
        	form.method ='post';
        	form.submit();
        }
    });
    </script>
</body>
</html>