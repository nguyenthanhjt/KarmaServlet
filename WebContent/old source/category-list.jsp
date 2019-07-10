<%@page import="com.trungtamjava.model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catagory List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" href="/HelloServlet/css/style.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Danh sach </h1>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-3 col-sm-6">
			<ul class="list-group">
				<li class="list-group-item"><a href="http://localhost:8081/HelloServlet/user/list">Nguoi dung</a></li>
				<li class="list-group-item"><a href="http://localhost:8081/HelloServlet/product/list">San Pham</li>
				<li class="list-group-item"><a href="http://localhost:8081/HelloServlet/category/list">Danh muc SP</li>
				<li class="list-group-item"> <a class="btn btn-success" href="http://localhost:8081/HelloServlet/category/add">Add Category</a></li>
			</ul>
		</div>
		<div class="col-md-9 col-sm-12">
		<%
			Object objCate = request.getAttribute("categoryList");
			List<Category> list = (List<Category>) objCate; 
		%>
			<table class="table table-bordered">
				<tr class='table-header'>					
					<th>ID</th>
					<th>Category Name</th>
					<th>Quantity of Product</th>
					<th>Category Products</th>			
					<th>Acion</th>		
				</tr>
				<% 
					for(Category cate : list ){
						
				%>
				<tr>
					<td><%=cate.getId() %></td>
					<td><%=cate.getName() %></td>
					<td><%=cate.getCount() %></td>		
					<td><a class="btn btn-success" href="/HelloServlet/product/list2?uid=<%=cate.getId() %>">List</a> |</td>								
					<td>
							<a class="btn btn-success" href="/HelloServlet/category/edit?uid=<%=cate.getId() %>">Edit</a> |
						 	<a class="btn btn-danger" href="/HelloServlet/category/delete?uid=<%=cate.getId() %>">Delete</a></td>
				</tr>
				<% } %>	
			</table>
		</div>
	</div>
	
</div>

</body>
</html>