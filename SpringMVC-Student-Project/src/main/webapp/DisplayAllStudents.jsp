<%@page import="javax.persistence.Query"%>
<%@page import="com.jsp.springmvc.entity.Student"%>
<%@page import="java.util.List"%>
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
List<Student> students=(List) request.getAttribute("displayList");
%>
<div align="center">

<h2>Student Details</h2>

<table border="1">

<tr>
<th>StudentId</th>
<th>StudetnName</th>
<th>StudentEmail</th>
<th>StudentClasas</th>
<th>View</th>
<th>Update</th>
<th>Delete</th>
</tr>

<%for(Student student:students) {%>

<tr>
<td><%=student.getStudentId()%></td>
<td><%=student.getStudentName()%></td>
<td><%=student.getStudentEmail() %></td>
<td><%=student.getStudentClass() %></td>
<td><a href="View?studentId=<%=student.getStudentId()%>">View</a></td>
<td><a href="UpdateStudent?studentId=<%=student.getStudentId()%>">Update</a></td>
<td><a href="DeleteStudent?studentId=<%=student.getStudentId()%>">Delete</a></td>

</tr>

<%} %>

</table>
<h3><a href="index.jsp">Go Back to StudentDashBoard</a></h3>

</div>
</body>
</html>