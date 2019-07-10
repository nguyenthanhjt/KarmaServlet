<!DOCTYPE html>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Add user</title>
<link rel="stylesheet" href="css/style.css">

</head>
<body>
	<form class="form-group" action="/HelloServlet/user/add" method="post">
		<div>
			<label>Name:</label> <input type="text" name="yourname">
		</div>
		<div>
			<label>Username</label> <input type="text" name="username">
		</div>
		<div>
			<label>Password:</label> <input type="password"
				name="password">
		</div>
		<div>
			<label >Gender:</label> 
			<input type="radio" name="gender" value="Male" checked="checked">Nam 
			<input type="radio" name="gender" value="Female">Nu
		</div>		
		<div>
			<label>Role</label> 
			<select name="role">
				<option value="Admin">Admin</option>
				<option value="Member">Member</option>
			</select>
		</div>
		<div>
			<label>City</label> 
			<select name="address">
				<option value="HaNoi">Ha Noi</option>
				<option value="TP.HCM">TP Ho Chi Minh</option>
			</select>
		</div>
		<div>
			<button type="submit">Them</button>
		</div>
	</form>
</body>
</html>