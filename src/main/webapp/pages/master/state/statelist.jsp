<%@page import="com.vivek.master.service.impl.StateServiceImpl"%>
<%@page import="com.vivek.master.service.StateService"%>
<%@page import="com.vivek.master.model.State"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<%
	StateService service = (StateService) request.getAttribute("service");
	List<State> statelist = service.searchAll();
%>
<body>

	<h1>State List <button>  <a href="StateController/showaddpage"> Add </a></button> </h1>
	<table>
	<tr> <td>Sr</td> <td>Name</td> <td>Actions</td> </tr>
	<%
	int index = 1;
	for(State state: statelist){
		
	%>
	
	<tr>
	<td><%= index %></td>
	
	<td><%= state.getName() %></td>
	
	
	<td> <button> <a href="/studentCRUD/StateController/editpage?id=<%= state.getId() %>"> Edit </a> </button> , Delete</td>
	</tr>
	
	<%
	index++;
	}
	%>
	
	
	
	
	
	
	</table>


</body>
</html>