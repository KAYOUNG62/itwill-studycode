<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
</head>
<body>
    <div>
        <div>
            <h1>메인 페이지</h1>
        </div>

        <div>
            <ul>
                <li><a href="post">포스트 전체 목록</a></li>
            </ul>
            <ul>
                <!-- 포스트 전체 목록 페이지와 유사하게 회원 목록 테이블이 보일 수 있게 하기 
                    메인페이지로 돌아가기, 회원추가 li 작성,
                    회원추가 > 회원가입 페이지 : 회원 아이디, 회원 비밀번호, 이메일 등의 정보, 
                                가입이 끝나면 리스트 페이지로 이동
                    테이블에서 상세보기 설정 
                 -->
                <li><a href="user">User List</a></li>
            </ul>
        </div>
    </div>


</body>
</html>