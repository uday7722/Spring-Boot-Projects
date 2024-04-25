<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center" style="background-color: beige; border-color: black">
<h2>Add Students</h2>
<form action="addStudent" method="post">
<input type="number" placeholder="Enter studentId" name="studentId"><br>
<input type="text" placeholder="Enter studentName" name="studentName"><br>
<input type="text" placeholder="Enter studentEmail" name="studentEmail"><br>
<input type="text" placeholder="Eneter StudentClass" name="studentClass"><br>
<input type="submit" value="Add">
</form>
</div>
</body>
</html>