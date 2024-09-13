<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="CSS/style.css">
</head>
<body class="body_bg">
   <h3>Login Here</h3>
   
   
      <c:if test="${not empty errMsg}">
       <h2 style='color:red'>${errMsg}</h2>
   </c:if>
   
   <form action="loginForm" method="post">
     
      Email : <input type="text" name="email"> <br><br>
      Password : <input type="password" name="password"> <br><br>
      
      <input type="submit" value="Login">
   </form>
   If not registered ......<a href="regPage">Click Here</a>

</body>
</html>