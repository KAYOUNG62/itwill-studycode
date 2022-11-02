<%@page import="edu.web.jsp01.domain.Contact"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
    <h1>JSP Action Tag</h1>
    <%-- scriptlet에서 사용되는 자바 코드들을 HTML과 비슷한 태그로 대체하기 위해서 정의된 태그들. 
    <jsp:태그이름> ... </jsp:태그이름>
    o. <jsp:forward>
    o. <jsp:include>
    o. <jsp:useBean>
    --%>

    <% 
    // 좋은 코드가 아님
    // scriptlet
    Contact contact = new Contact(); // 기본생성자 호출. 객체 생성
    // setter를 사용해서 필드의 값들을 초기화
    contact.setName("오쌤");
    contact.setPhone("010-0000-0000");
    contact.setEmail("jake@itwill.co.kr");

    // 내장객체 out을 사용해서 HTML로 출력
    out.println(contact.getName() + "<br/>");
    out.println(contact.getPhone() + "<br/>");
    out.println(contact.getEmail() + "<br/>");
    %>

    <h2>useBean</h2>
    <jsp:useBean id="contact2" class="edu.web.jsp01.domain.Contact"></jsp:useBean>
    <%-- 같은 코드 Contact contact2 = new Contact(); --%>
    
    <jsp:setProperty name="contact2" property="name" value="홍길동" />
    <%-- 같은 코드 contact2.setName("홍길동"); --%>
    
    <jsp:setProperty name="contact2" property="phone" value="010-0000-0000" />
    <jsp:setProperty name="contact2" property="email" value="hong@naver.com" />

    <jsp:getProperty name="contact2" property="name"/>
    <br/>
    <jsp:getProperty name="contact2" property="phone"/>
    <br/>
    <jsp:getProperty name="contact2" property="email"/>
</body>
</html>