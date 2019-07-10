<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Haluuuuuu</title>
</head>
<body>
	<h2>Hello Java Servlet</h2>
	<%
		String name = "halo";
		int x = 10;
		int y = 30;
		int tong = x + y;
	%>
	<p>
		Ten toi la:
		<%=name%></p>
	<%
		for (int i = 0; i < 10; i++) {
	%>
	<h1>
		Loop
		<%=i%></h1>
	<%
		}
	%>
	<a href="/HelloServlet/hello">Say Hello</a>
</body>
</html>