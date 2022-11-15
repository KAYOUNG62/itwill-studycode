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
                    <input id="id" type="text" name="id" value="${post.id}" readonly />
                </div>
                <div>
                    <label id="title">제목</label>
                    <input id="title" type="text" name="title" value="${post.title}" />
                </div>
                <div>
                    <label id="content">내용</label>
                    <textarea id="content" type="text" rows="10" cols="50" >${post.content}</textarea>
                </div>
                <div>
                    <label id="author">작성자</label>
                    <input id="author" type="text" name="author" value="${post.author}" readonly />
                </div>
                <div>
                    <button id="btnDelete">삭제</button>
                    <button id="btnUpdate">수정완료</button>
                    <!-- form 안에서 작성된 버튼들은 form의 action 주소로 method 방식의 요청을 보냄 -->
                </div> 
            </form>
        </main>
    </div>
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