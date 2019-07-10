<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello HTML</title>
</head>
<body>
	<!-- THE TIEU DE -->
	<h1>TIEU DE H1</h1>
	<h2>TIEU DE H2</h2>
	<h3>TIEU DE H3</h3>
	<h4>TIEU DE H4</h4>
	<h5>TIEU DE H5</h5>
	<h6>TIEU DE H6</h6>
	<!-- THE BLOCK -->
	<p>Van ban 1</p>
	<p>
		Van ban 2 <br /> Van ban 3
	</p>
	<!-- the inline -->
	<div>
		<img width="100" height="100" src="img/spring04.jpg">
	</div>
	<div>
		<a href="http://trungtamjava.com" target="_blank">Trung Tam Java</a>
	</div>
	<div>
		<ul>		
			<li><a href="#">Cafe</a></li>
			<li>Tea</li>
			<li>Milk</li>
		</ul>
	</div>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Age</th>
		</tr>
		<tr>
			<td>1</td>
			<td>Kien</td>
			<td>25</td>
		</tr>
		<tr>
			<td>1</td>
			<td>Giang</td>
			<td>25</td>
		</tr>
	</table>
	
	<form action="#" method="post">
		<div>
			<label>Name:</label>
			<input type="text" name="yourname">
		</div>
		<div>
			<label>Password:</label>
			<input type="password" name="password">
		</div>
		<div>
<label>Gender:</label>
<input type="radio" name="gender" value="M" checked="checked">Nam
<input type="radio" name="gender" value="F">Nu
		</div>
		
		<div>
<label>Favourite:</label>
<input type="checkbox" name="fav" value="XP" checked="checked">Xem phim
<input type="checkbox" name="fav" value="BD">Bong da
<input type="checkbox" name="fav" value="DC">Di choi
		</div>
		<div>
			<label>Noi sinh:</label>
			<select name="address">
				<option>Hanoi</option>
				<option>TP.HCM</option>
				<option>Hai Phong</option>
			</select>
		</div>
		<div>
			<label>Gioi thieu:</label>
			<textarea name="about"></textarea>
		</div>
		<div>
			<label>Avatar File:</label>
			<input type="file" name="avatar-file">
		</div>
		<div>
			<input type="submit" value="Them">
			<input type="button" value="Khong lam gi ca">
			
			<button type="submit">Them</button>
			<button type="button">Khong lam gi ca</button>
		</div>
	</form>
	
	<iframe src="https://www.w3schools.com/html/html_iframe.asp" 
		height="500" width="800">
	</iframe>
</body>
</html>