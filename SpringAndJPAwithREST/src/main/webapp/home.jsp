<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<form action = "addAvenger">
		<input type = "text" name = "aId"/><br>
		<input type = "text" name = "aName"/><br>
		<input type = "text" name = "aPower"/><br>
		<input type = "submit"/><br>
	</form>
	
	<h3>To retrieve/update an avenger</h3><br>
	
	<form action = "getAvenger">
		<input type =  "text" name = "aId"/><br>
		<input type = "submit" />
	</form>
	
</body>
</html>