<%@page import="com.trungtamjava.model.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.trungtamjava.service.CategoryServiceImpl"%>
<%@page import="com.trungtamjava.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<form class="form-group" action="/HelloServlet/product/add"	method="post">
		<div>
			<label>ID:</label> <input type="text" name="id">
		</div>
		<div>
			<label>Name</label> <input type="text" name="name">
		</div>
		<div>
			<label>Price</label> <input type="text" name="price">
		</div>
		<div>
			<label>Category</label>
			<%
				List<Category> listCate = (List<Category>) request.getAttribute("category");
			%>
			<select name="category">
				<%
					for (Category cate : listCate) {
				%>
				<option value="<%=cate.getId()%>"><%=cate.getName()%></option>
			<%
				}
			%>
			</select>
		</div>
		<div>
			<button type="submit">Add</button>
		</div>
	</form>

</body>
</html>