<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Avenger Info</title>
</head>
<body>
	<h1>Here is your requested avenger:</h1><br>
	${avenger}
	<br>
	<h3>>Update an avenger</h3>
	
	<form action = "updateAvenger">
		<input type = "text" name = "aId"/>enter avenger id:<br>
		<input type = "text" name = "aPower"/>enter their updated power <br>
		<input type = "submit"/>
	</form>
</body>
</html>