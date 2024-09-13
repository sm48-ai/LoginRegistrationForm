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
   <h3>Register Here</h3>
   
   <c:if test="${not empty succMsg}">
       <h2 style='color:green'>${succMsg}</h2>
   </c:if>
   
      <c:if test="${not empty errMsg}">
       <h2 style='color:red'>${errMsg}</h2>
   </c:if>
   
   <form action="regForm" method="post">
      Name : <input type="text" name="name"> <br><br>
      Email : <input type="text" name="email"> <br><br>
      Password : <input type="password" name="password"> <br><br>
      Phone No: <input type="text" name="phoneno"> <br><br>
      <input type="submit" value="Register">
   </form>
   If already registered ......<a href="loginPage">Click Here</a>

</body>
</html>