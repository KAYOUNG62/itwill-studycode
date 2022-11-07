<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP02</title>
</head>
<body>
    <div>
        <h1>포스트 작성 페이지</h1>

        <nav>
            <ul>
                <li><a href="/jsp02">메인페이지</a></li>
                <li><a href="/jsp02/post">목록페이지</a></li>
            </ul>
        </nav>
        <main>
            <form method="post">
                <div>
                    <input type="text" name="title" placeholder="제목"
                        required autofocus />
                </div>
                <div>
                    <textarea rows="5" cols="80" name="content"
                        placeholder="내용" required></textarea>
                </div>
                <div>
                    <input type="text" name="author" placeholder="작성자" required/>
                </div>
                <div>
                    <input type="submit" value="작성 완료" />
                </div>
            </form>
        </main>
    </div>
</body>
</html>