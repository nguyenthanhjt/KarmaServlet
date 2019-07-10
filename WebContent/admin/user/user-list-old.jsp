<!DOCTYPE html>
<%@page import="com.trungtamjava.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.trungtamjava.service.UserServiceImpl"%>
<%@page import="com.trungtamjava.service.UserService"%>
<%@page import="com.trungtamjava.dao.UserDao"%>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/HelloServlet/css/style.css">
<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3 col-sm-6">
				<ul class="list-group">
					<li class="list-group-item"><a href="http://localhost:8081/HelloServlet/user/list">Nguoi dung</a></li>
					<li class="list-group-item"><a href="http://localhost:8081/HelloServlet/product/list">San Pham</li>
					<li class="list-group-item"><a href="http://localhost:8081/HelloServlet/category/list">Danh muc SP</li>
					<li class="list-group-item"><a class="btn btn-success" href="http://localhost:8081/HelloServlet/user/add">Add User</a></li>
				</ul>
			</div>
			<div class="col-md-9 col-sm-12">

				<%
					Object obj = request.getAttribute("name");
					String name = (String) obj;
				%>
				<%
							Object objUser = request.getAttribute("userList");
							List<User> users = (List<User>) objUser;
				%>
				
				<h2><%=name%></h2>
				<table class="table table-bordered">
					<tr class='table-header'>
						<th>ID</th>
						<th>Name</th>
						<th>Gender</th>
						<th>UserName</th>
						<th>Pass</th>
						<th>Role</th>
						<th>City</th>
						<th>Action</th>
					</tr>
					<% for(User u: users){ %>
					<tr>		
						<td><%=u.getAd() %></td>				
						<td><%=u.getName() %></td>
						<td><%=u.getGender() %></td>
						<td><%=u.getUsername() %></td>
						<td><%=u.getPassword() %></td>
						<td><%=u.getRole() %></td>
						<td><%=u.getCity() %></td>
						<td>
							<a class="btn btn-success" href="/HelloServlet/user/update?uid=<%=u.getAd() %>">Edit</a> |
						 	<a class="btn btn-danger" href="/HelloServlet/user/delete?uid=<%=u.getAd() %>">Delete</a>
						 	
						</td>
					</tr>
					<% } %>
				</table>
			</div>
		</div>

	</div>
</body>
</html>