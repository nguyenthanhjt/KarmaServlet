<!DOCTYPE html>
<%@page import="com.trungtamjava.model.User"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Update user</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<h2>Update User</h2>
	<c:url var="url" value="/user/update"></c:url>
	<form class="form-group" action="${url}" method="post">
		<div>
			<label>ID:</label> <input type="text" readonly="readonly" name="id" value="${user.ad }">
		</div>
		<div>
			<label>Name:</label> <input type="text" name="yourname" value="${user.name }">
		</div>
		<div>
			<label>Username</label> <input type="text" name="username" value="${user.username }">
		</div>
		<div>
			<label>Password:</label> <input type="password"	name="password" value="${user.password}">
		</div>
		<div>
			<label >Gender:</label> 
			<c:choose>
				<c:when test="${user.getGender().equals('Male')}">
					<input type="radio" name="gender" value="Male" checked="checked">Male
					<input type="radio" name="gender" value="Female">Female
				</c:when>
				<c:otherwise >	
					<input type="radio" name="gender" value="Male">Male
					<input type="radio" name="gender" value="Female" checked="checked">Female
				</c:otherwise>
			</c:choose>
		</div>		
		<div>
			<label>Role</label> 
			<select name="role" value="${user.role }">
				<option value="Admin">Admin</option>
				<option value="Member">Member</option>
			</select>
		</div>
		<div>
			<label>City</label> 
			<select name="address" value="${user.city }">
				<option value="HaNoi">Ha Noi</option>
				<option value="TP.HCM">TP Ho Chi Minh</option>
			</select>
		</div>
		<div>
			<button type="submit">Save</button>
		</div>
	</form>
</body>
</html>