<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignIn</title>
</head>
<body>
    <div>
        <div>
            <h1>Sign In</h1>
        </div> 
        
        <div>
            <form method="post">
                <div>
                    <input type="text" name="username" placeholder="ID" required autofocus />
                </div>
                <div>
                    <input type="password" name="password" placeholder="password" required />
                </div>
                <div>
                    <input type="submit" value="Sign In">
                </div>
            </form>        
        </div>
    </div>

</body>
</html>