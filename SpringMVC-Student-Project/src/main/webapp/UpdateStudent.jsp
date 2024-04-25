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

<%
Student student=(Student)request.getAttribute("updateStudent");
%>


<div align="center" style="background-color: beige; border-color: black; border: 1" >
<h2>Update Student</h2>
<form action="SaveUpdatedStudent" method="get">
<input type="number" value="<%=student.getStudentId()%>" readonly="studentId" placeholder="Enter Studentid" name="studentId" ><br>
<input type="text" value="<%=student.getStudentName()%>" placeholder="Enter StudentName" name="studentName"><br>
<input type="text" value="<%=student.getStudentEmail()%>" placeholder="Enter StudentEmail" name="studentEmail"><br>
<input type="number" value="<%=student.getStudentClass() %>" placeholder="Enter StudentClass" name="studentClass"><br>
<input type="submit" value="Update">
</form>
<a href="DisplayAllStudents.jsp">Go Back to Student Details</a>
</div>

</body>
</html>