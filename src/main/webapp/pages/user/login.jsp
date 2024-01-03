<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <style>
        body{
             background-image: linear-gradient(to right top ,
            rgba(225,0,0,0),
            rgb(249, 227, 139));
        }
        .login{
            text-align: center;
            border: 2px solid black;
            border-radius: 20px;
            font-size: 20px;
            margin: 80px 350px 280px 350px;
            padding: 80px;
            background-image: linear-gradient(to top,
            rgba(225,0,0,0),
            rgb(249, 227, 139));
            
            
            
        }
        
        .login>form input{
            height: 30px;
            width: 200px;
            border: 2px solid black;
            border-radius: 10px;
            font-size: 20px;
           
        }
        .login>form button{
            width: 80px;
            height: 30px;
            font-size: 20px;
            border: 2px solid black;
            border-radius: 10px;

        }
        
    </style>
</head>
<body>
    <div class="login">
        <h1>Login Here..</h1>
        <form action="user/login" method="post">
        <span><label>User Id:</label><input type="text" placeholder="Enter userId" name="userId"></span><br><br>
        <span><label>Password:</label> <input type="password" placeholder="Enter password" name="password"></span>
        
        <br><br>
        <button type="submit">Login</button>
	    </form>
    </div>
</body>
</html>