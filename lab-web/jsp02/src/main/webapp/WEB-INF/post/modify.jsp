
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>JSP02</title>
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
    crossorigin="anonymous">
<style>
.mainDiv {
    text-align: center;
}
h1 {
    font-size: 36px;
    font-weight: bold;
    margin: 16px;
    padding: 10px;
}
input {
    margin : 5px;
}
</style>    
</head>
<body>
    <div class="mainDiv">
        <h1>포스트 수정 페이지</h1>
            
        <nav>
            <ul class="nav justify-content-center">
                <li class="nav-item">
                    <c:url var="mainPage" value="/"></c:url>
                    <a class="nav-link" href="${mainPage}" style="color: gray;">메인페이지</a>
                </li>
                <li class="nav-item">
                    <c:url var="listPage" value="/post"></c:url>
                    <a class="nav-link" href="${listPage}" style="color: gray;">목록페이지</a>
                </li>
                <li class="nav-item">
                    <c:url var="postDetailPage" value="/post/detail">
                        <c:param name="id" value="${post.id}" ></c:param>
                    </c:url>
                    <a class="nav-link" href="${postDetailPage}" style="color: gray;">포스트 상세 페이지</a>
                </li>
            </ul>
        </nav>
        <main>
            <form id="postForm">
            <!-- action: 제출(submit) 주소 기본값은 현재 페이지 주소, 
            method: 제출(submit)방식.  기본값은 get -->
                <div>
                    <label for="id">번호</label>
                    <input id="id" type="text" name="id" value="${post.id}" readonly size=48 />
                </div>
                <div>
                    <label for="title">제목</label>
                    <input id="title" type="text" name="title" value="${post.title}" required size=48 />
                </div>
                <div>
                    <label for="content">내용</label>
                    <textarea id="content" type="text" name="content" rows="10" cols="50" required>${post.content}</textarea>
                </div>
                <div style="display: none">
                    <label for="author" >작성자</label>
                    <input id="author" type="text" value="${post.author}" readonly size=46/>
                </div>
                <c:if test="${signInUser == post.author}">
                <div>
                    <button id="btnDelete">삭제</button>
                    <button id="btnUpdate">수정완료</button>
                    <!-- form 안에서 작성된 버튼들은 form의 action 주소로 method 방식의 요청을 보냄 -->
                </div>    
                </c:if>     
            </form>
        </main>
    </div>
    <c:url var="postDeletePage" value="/post/delete"></c:url>
    <c:url var="postModifyPage" value="/post/modify"></c:url>
    <script>
    //id ="postForm" 인 HTML 요소를 찾음.
    const form = document.querySelector('#postForm');
    
    //id="btnDelete" 인 버튼을 찾음
    const btnDelete = document.querySelector('#btnDelete');
    
    //버튼 클릭 이벤트 리스너 등록.
    btnDelete.addEventListener('click', function(event){
        event.preventDefault(); 
        // 이벤트 기본 처리방식을 막음(실행되지 않도록 함)
        // 폼양식이 서버로 제출(submit)되지 않도록 함 
        
        //사용자에게 확인
        const check = confirm('정말 삭제하시겠습니까?')
        console.log(check);
        // 사용자가 확인을 선택했을때
        if(check) {
        	form.action = '${postDeletePage}'; //제출 요청 주소
        	form.method = 'post';
        	form.submit(); // 서버로 제출(데이터 전송)
        }
     });
    
    //btnUpdate 버튼을 찾음
    const btnUpdate = document.querySelector('#btnUpdate');
    //btnUpdate 이벤트리스너 등록
    btnUpdate.addEventListener('click', function(event){
    	event.preventDefault();
    	
    	const title = document.querySelector('#title').value;
    	const content = document.querySelector('#content').value;
    	console.log(content);
    	if (title == '' || content == '') {
    		alert('제목과 내용을 입력해주세요.');
    		return;
    	}
    	
    	const checkUpdate = confirm('수정하시겠습니까?');
    	console.log(checkUpdate);
    	if(checkUpdate){
    		form.action = '${postModifyPage}';
    		form.method = 'post';
    		form.submit();
    	}
    });
    </script>

</body>
</html>