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
            <h2>Rewrites</h2>
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
                    <a class="nav-link active disabled" href="${postModifyPage}">LINK 3</a>
                </li>
            </ul>
        </nav>
        <main class="my-4">
            <div class="card">
                <div class="card-header"></div>
                <div class="card-body">
                    <form id="form">
                        <div>
                            <label for="id" class="form-label">Post Number</label>
                            <input id="id" class="form-control" name="id" value="${post.id}" readonly/>
                        </div>
                        <div>
                            <label for="title" class="form-label">Title</label>
                            <input id="title" class="form-control" name="title" value="${post.title}" required autofocus/>
                        </div> 
                        <div>
                            <label for="content" class="form-label">Content</label>
                            <textarea id="content" class="form-control" name="content" rows="5" cols="40">${post.content}</textarea> 
                        </div> 
                        <div>
                            <label for="author" class="form-label">Author</label>
                            <input id="author" class="form-control" value="${post.author}" readonly/>
                        </div> 
                        <div class="my-2" >
                            <button id="btnUpdate" class="btn btn-success">Update</button>
                            <button id="btnDelete" class="btn btn-danger">Delete</button>
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

    <c:url var="postDeletePage" value="/post/delete" />
    <c:url var="postUpdatePage" value="/post/update" />
    <script>
    	const form = document.querySelector('#form');
    	
    	const btnDelete = document.querySelector('#btnDelete');
    	btnDelete.addEventListener('click', function(event){ 
    		event.preventDefault(); // 버튼의 이벤트처리 기본동작(폼 제출)을 막음
    		const result = confirm('삭제하시겠습니까?');
    		if(result) {
    			form.action = '${postDeletePage}'; // EL
    			form.method = 'post';
    		    form.submit();
    		}
    	});
    	
    	const btnUpdate = document.querySelector('#btnUpdate');
    	btnUpdate.addEventListener('click', function(event) {
    		event.preventDefault(); // 폼 버튼의 기본동작(submit)을 막음.
    		
    	    
    		const result = confirm('수정하시겠습니까?');
    		if(result) {
    			
        	    const title = document.querySelector('#title').value;
        	    const content = document.querySelector('#content').value;
        	    
        	    if(title == '' || content == ''){
        	    	alert('내용을 입력하세요')
        	    	return;
        	    }
    			
    			form.action = '${postUpdatePage}'; // submit update 요청을 보낼 주소
    			form.method = 'post';  // submit 요청 방식
    			form.submit();
    		}
    	});
    
    
    
    </script>
</body>
</html>