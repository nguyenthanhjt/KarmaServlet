<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<form class="form-group" action="/HelloServlet/category/add" method="post">
		
		
		<div>
			<label>ID:</label> <input type="text" name="id">
		</div>
		<div>
			<label>Category name</label> <input type="text" name="category-name">
		</div>					
		<div>
			<label>Count</label> 
			<select name="count">
				<option value="1">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
				<option value="6">6</option>
			</select>
		</div>
		<div>
			<button type="submit">Add</button>
		</div>
	</form>

</body>
</html>