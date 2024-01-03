<%@page import="com.vivek.master.service.StateService"%>
<%@page import="com.vivek.master.model.City"%>
<%@page import="java.util.List"%>
<%@page import="com.vivek.commonutils.SessionKeys"%>
<%@page import="com.vivek.master.service.CityService"%>
<%@page import="com.vivek.master.model.State"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
 StateService service = (StateService) request.getAttribute(SessionKeys.STATELIST);
 List<State> list = service.searchAll();
%>
<body>

	<form action="/studentCRUD/CityController/add" method="post">
	<div>
	<span>    
	<label>State</label>:
	<select name="stateId">
	<option value="0">SELECT STATE </option>
	
	<%for(State s : list){ %>
	<option value="<%=s.getId()%>"><%=s.getName()%></option>
	<%} %>
	
	</select>
	
	</span>
	<span>
	<label>City Name</label>: <input type="text" name="name" />
	</span>
	<button type="submit"> Save</button>
	 
	</div>

	</form>
	
</body>
</html>