<%@page import="com.vivek.master.service.CityService"%>
<%@page import="com.vivek.master.model.City"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<title>Insert title here</title>

<% 
	CityService service = (CityService) request.getAttribute("cityService"); 
	List<City> cityList= service.getallCities();
%>
</head>
<body>

	<h1>City List <button> <a href="CityController/showaddpage"> Add </a> </button>  </h1>
	
	<table>
		<tr>
			 <td>Sr</td> 
			 <td>State</td> 
			 <td>City</td> 
			 <td>Edit</td> 
			 <td>Delete</td>
		 </tr>
		 <%
		 int index=1;
		 for(City city: cityList){
		 %>
		 <tr>
			 <td><%=index %></td>
			 <td><%=city.getState().getName() %></td>
			 <td><%=city.getName() %></td>
			 <td><button> <a href="/studentCRUD/CityController/edit?id=<%=city.getId()%>"> Edit </a></button></td>
			 <td>delete</td>
		 </tr>
		 <%index++;
		 }
		 %>
	</table>
</body>
</html>