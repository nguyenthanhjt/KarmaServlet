<%@page import="com.trungtamjava.model.Product"%>
<%@page import="com.trungtamjava.model.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.trungtamjava.service.CategoryServiceImpl"%>
<%@page import="com.trungtamjava.service.CategoryService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<form class="form-group" action="/HelloServlet/product/edit"	method="post">
		<%
			Product p = (Product) request.getAttribute("product");
		%>
		<div>
			<label>ID:</label> <input type="text" readonly="readonly" name="id"	value="${product.id}">
		</div>
		<div>
			<label>Name</label> <input type="text" name="name"	value="${product.name}">
		</div>
		<div>
			<label>Price</label> <input type="text" name="price" value="${product.price }">
		</div>
		<div>
			<label>Category</label>
			<select name="category">
				<%
					List<Category> listCate = (List<Category>) request.getAttribute("category");
					for (Category cate : listCate) {
				%>
				<%
					if (cate.getId().equals(p.getCate().getId())) {
				%>
				<option value="<%=cate.getId()%>" selected><%=cate.getName()%></option>
				<%
					} else {
				%>
				<option value="<%=cate.getId()%>"><%=cate.getName()%></option>
				<%
					}
					}
				%>
			</select>
		</div>
		<div>
			<label>Category</label>
			<select name="category" value="${p.getCate().getId() }">
				<c:forEach items="${ category}" var="c">
					<c:choose>
						<c:when test="${p.getCate().getId().equals(c.getId()) }">
							<option value="${c.getId()}" selected >${c.getName()}</option>
						</c:when>
						<c:otherwise>
							<option value="${c.getId()}" >${c.getName()}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</select>
		</div>
		<div>
			<button type="submit">Update</button>
		</div>
	</form>

</body>
</html>