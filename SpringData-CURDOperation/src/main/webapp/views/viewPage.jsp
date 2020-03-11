<%@page import="org.springframework.web.bind.annotation.ModelAttribute"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
	<html>
		<head>
			<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	

<!-- This script used for when we click delete button,its immideatly not delete.
 pop up msg will show to user -->
	<script>
		function deleteConfirm(){
			 return confirm("Are you sure, you want to delete ?");
		}
	</script>
		</head>
<body>
	<h3><a href="regUser">+ AddUser</a></h3>
	
	<table border="1" >
   		<thead>
   			<tr>
   				<th>SL.No</th>
   				<th>UserName</th>
   				<th>Email</th>
   				<th>Pnno</th>
   				<th>Country</th>
   				<th>Action</th>
   			</tr>
   		</thead>
  
  	<tbody>
   		<c:forEach items="${userList}" var="user" varStatus="index"> 
   			<tr>  			
   				<td>${index.count}</td>
   				<td>${user.username}</td>
   				<td>${user.email}</td>
   				<td>${user.phno}</td>
   				<td>${user.country}</td>
   				<td><a href="editUser?uid=${user.userid}">Edit</a>&nbsp;
   				<a href="deleteUser?userid=${user.userid}" 
   				onclick="return deleteConfirm()">Delete</a></td>
   				</tr>
   		</c:forEach>
   </tbody>
</table>

<c:if test="${cp > 1}">
		<a href ="pagingViewUser?pn= ${cp-1}">Previous</a>
	</c:if>
	<c:forEach begin="1" end="${tp}" var="i">
	<c:choose>
		<c:when test="${cp == i}">
			<c:out value="${i }"/>
		</c:when>
		<c:otherwise>
			<a href ="pagingViewUser?pn=${i}"><c:out value ="${i}"/></a> &nbsp;&nbsp;
		</c:otherwise>
		</c:choose>
	</c:forEach>
<c:if test="${cp < tp }">
	<a href ="pagingViewUser?pn= ${cp+1}">Next</a>
		</c:if>
</body>
</html>