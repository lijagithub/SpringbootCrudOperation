<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.error {
	color: #FF0000
}
</style>

 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('form[id="userRegForm"]').validate({
			rules : {
				username : {
					required: true
				},
				pwd :{
					required: true
				},
				email : {
					required : true,
					email : true
				},
				
				country :{
					required: true
				},
				phno : {
					required: true
				}
			},
			 messages: {
				 username: {
			          required: "Please Enter username"
			        },
			        pwd: {
			          required: "Please Enter password"
			        },
			        email: {
			          required: "Please Enter valid email"
			        },
			        country :{
			        	required: "Please Enter country name"
			        },
			        phno :{
				          required: "Please Enter phone number"
				        },
			 }
		});
	});
</script>

</head>
<body>

	<h2  style="color:blue;text-align:center">Register Here</h2>
	<form:form action="regUser" method="POST" modelAttribute="user"
		id="userRegForm">
		<table>
			<tr>
				<td>Username</td>
				<td><form:input path="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:password path="pwd" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><form:input path="phno" /></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><form:select path="country" items="${countriesList}" /></td>
			</tr>
			<tr>
				<td><input type="reset" value="Reset" /></td>
				<td><input type="submit" value="Register"/></td>
				
			</tr>
		</table>
	</form:form>&nbsp;&nbsp;
	<h2 style="color:green"><a href ="pagingViewUser?pn=1">ViewDetails</a></h2>
	
</body>
</html>