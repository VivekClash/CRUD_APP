<%@page import="com.vivek.master.service.StateService"%>
<%@page import="com.vivek.master.service.impl.StateServiceImpl"%>
<%@page import="com.vivek.master.model.City"%>
<%@page import="com.vivek.commonutils.SessionKeys"%>
<%@page import="com.vivek.master.model.State"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
StateService service = (StateService) request.getAttribute(SessionKeys.STATELIST);
List<State> list = service.searchAll();
City city = (City)request.getAttribute(SessionKeys.CITY);
%>
</head>
<body>
	<form action="/studentCRUD/CityController/update" method="post">
		<input type="hidden" name="id" value="<%=city.getId()%>">
		<div>
			
			<span><label>State</label>: 
			<select name="stateId">
			<option value="0">SELECT STATE</option>
			<%for(State s : list){%>
				<%if(s.getId() == city.getState().getId()){ %>
						<option selected="selected" value="<%=s.getId()%>"><%=s.getName()%></option>
				<%}else{%>
						<option value="<%=s.getId()%>"><%=s.getName() %></option>
				<%}%>
			<%}%>
			
			</select>
			</span>
			<span>
			<label>City Name</label>: <input type="text" name="name" value="<%=city.getName()%>">
			<button type="submit" value="update">update</button>
			</span>
		</div>
	
	</form>
</body>
</html>