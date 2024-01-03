<%@page import="com.vivek.master.model.State"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit page</title>
<%
State state = (State)request.getAttribute("state");
%>
</head>
<body>
	<form action="StateController/update" method="post">
	<input type="hidden" name="id" value="<%=state.getId()%>"/>
	<label>Name :</label><input type="text" name="name" value="<%=state.getName()%>"/>
	<button type="submit" value="Update">update </button>
	</form>

</body>
</html>