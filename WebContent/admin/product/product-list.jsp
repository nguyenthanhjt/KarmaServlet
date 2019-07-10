<%@page import="com.trungtamjava.model.Product"%>
<%@page import="com.trungtamjava.model.Category"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Catagory List</title>
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
	<h1>Danh sach</h1>

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-3 col-sm-6"></div>
			<div class="col-md-9 col-sm-12">
				<form class="form-group" action="/HelloServlet/product/search"
					method="post">
					<table class="table table-bordered">
						<tr class='table-header'>
							<th>Search</th>
							<th><input type="text" name="searchpost"
								placeholder="Enter name to search"></th>
							<th><button class="btn btn-success" type="submit">Search</button>
								|</th>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="row">
			<div class="col-md-3 col-sm-6">
				<ul class="list-group">
					<li class="list-group-item"><a
						href="http://localhost:8081/HelloServlet/user/list">Nguoi dung</a></li>
					<li class="list-group-item"><a
						href="http://localhost:8081/HelloServlet/product/list">San
							Pham</li>
					<li class="list-group-item"><a
						href="http://localhost:8081/HelloServlet/category/list">Danh
							muc SP</li>
					<li class="list-group-item"><a class="btn btn-success"
						href="http://localhost:8081/HelloServlet/product/add">Add
							Product</a></li>
				</ul>
			</div>
			<div class="col-md-9 col-sm-12">
				<%
					Object objCate = request.getAttribute("productList");
					List<Product> list = (List<Product>) objCate;
				%>
				<table class="table table-bordered">
					<tr class='table-header'>
						<th>ID</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Category ID</th>
						<th>Acion</th>
					</tr>
					<%
						for (Product p : list) {
					%>
					<tr>
						<td><%=p.getId()%></td>
						<td><%=p.getName()%></td>
						<td><%=p.getPrice()%></td>
						<td><%=p.getCate().getName()%></td>
						<td><a class="btn btn-success"
							href="/HelloServlet/product/edit?uid=<%=p.getId()%>">Edit</a> | <a
							class="btn btn-danger"
							href="/HelloServlet/product/delete?uid=<%=p.getId()%>">Delete</a></td>
					</tr>
					<%
						}
					%>
					<c:forEach items="${productList }" var="p">
						<tr>
							<td>${p.id }</td>
							<td>${p.name }</td>
							<td>${p.price }</td>
							<td>${p.getCate().getName() }</td>
							<td><a class="btn btn-success"
								href="/HelloServlet/product/edit?uid=${p.id }">Edit</a> | <a
								class="btn btn-danger"
								href="/HelloServlet/product/delete?uid=${p.id }">Delete</a> <a
								class="btn btn-danger"
								href="/HelloServlet/add-to-cart?productId=${p.id }">Add to
									cart</a></td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>

	</div>

</body>
</html>