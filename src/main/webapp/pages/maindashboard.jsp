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
        .bodyMain{
           
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            margin-top: 80px;
            padding: 0px 0px 280px 0px;
          
            
        }
        .heading{
            display: flex;
            flex-direction: row;
            justify-content: center;
            align-items: center;
            margin-top: 50px;

        }
       
        .main,.main2{
            text-align: center;
            border: 10px solid rgb(247, 168, 20);
            height: 90px;
            width: 140px;

            margin: 30px;  
            padding: 30px
        }
    </style>
</head>
<body>
    <div class="heading">
        <h1>User Dashboard</h1>
    </div>
    <div class="bodyMain">
     <div class="main">
        <a href="MasterController"><h1>Master</h1></a>
     </div>
        <div class="main2">
        <a href="#"><h1>Student</h1></a>
     </div>
    </div>
</body>
</html>