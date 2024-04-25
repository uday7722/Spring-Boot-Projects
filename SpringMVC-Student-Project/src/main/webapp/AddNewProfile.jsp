<%@page import="com.jsp.springmvc.entity.Student"%>
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

<%
Integer studentId=(Integer) request.getAttribute("addProfile");
%>


<form action="AddSocialProfile" method="get">
<input type="number" value="<%=studentId%>" readonly="readonly" name="studentId"><br>
<input type="number" placeholder="Enter profileId" name="profileId"><br>
<input type="text" placeholder="Enter profileName" name="profileName"><br>
<input type="text" placeholder="Enter url" name="url"><br>

<input type="submit" value="Add">
</form>
</div>

</body>
</html>