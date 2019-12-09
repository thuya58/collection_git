<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
table, td, th {
border: 1px solid black;
}

table {
border-collapse: collapse;
width: 100%;
}

th {
height: 50px;
}
</style>
<title>User List</title>
</head>
<body>
<h1 class="h4 text-gray-900 mb-4">User List:</h1>
<table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
<thead>
<tr>
<th>No</th>
<th>User Id</th>
<th>User name</th>
<th>Address </th>
<th>Department</th>
<th>Role</th>
<th>action</th>
</tr>
</thead>
<tbody>
<c:forEach var="user" items="${User_info}" varStatus="row">
<tr>
<td>${row.count }</td>
<td>${user.id }</td>
<td>${user.name }</td>
<td>${user.address }</td>
<td>${user.department .department}</td>	
<td>${user.user_login.role.role_level}</td>	
<td>
<a href='<c:url value='/changedepartment.htm/${user.id}' />'>Update</a></td>
</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>