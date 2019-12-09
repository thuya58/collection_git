<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href='<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" />'>
<link rel="stylesheet" href='<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />'>
<link rel="stylesheet" href='<c:url value="/webjars/jquery/3.4.1/js/jquery.min.js" />'>
</head>
<body>
<h1>Role table</h1>
<table  class="table table-dark">
	<thead>
		<tr>
		<th scope="col">Document-Id</th><th scope="col"> Decreption</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="role" items="${role_list }" varStatus="index">
		<tr>
		<td>${role.id}</td>
		<td>${role.role_level}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</body>
</html>