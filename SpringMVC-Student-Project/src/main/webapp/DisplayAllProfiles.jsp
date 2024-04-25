<%@page import="org.springframework.context.annotation.Profile"%>
<%@page import="com.jsp.springmvc.entity.SocialProfile"%>
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
<div align="center">
<h2>Student Profiles</h2>

<%
Student student=(Student) request.getAttribute("displayProfile");
%>

<% 
List<SocialProfile> socialProfiles=(List) student.getList();
%>


<table border="1" >

<tr>
<th>ProfileId</th>
<th>ProfileName</th>
<th>ProfileURL</th>
<th>Update</th>
<th>Delete</th>
</tr>

<%
for(SocialProfile profile:socialProfiles){
%>

<tr>
<td><%=profile.getProfileId() %></td>
<td><%=profile.getProfileName() %></td>
<td><%=profile.getUrl() %></td>
<td><a href="UpdateProdile?profileId=<%=profile.getProfileId()%>">Update</a></td>
<td><a href="DeleteProfile?profileId=<%=profile.getProfileId()%>">Delete</a></td>
</tr>

<%} %>
<tr>
<td><a href="AddNewProfile?studentId=<%=student.getStudentId()%>">Add Profile</a></td>
</tr>
</table>

<h3><a href="index.jsp">Go Back to StudentDashBoard</a></h3>

</div>

</body>
</html>