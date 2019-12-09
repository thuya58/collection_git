<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>pdf view </title>
</head>
<body>
<a href="<c:url value='/myFile.htm' />" class="btn btn-primary px-4">Back</a>
<div>
	<object
		data='<c:url value='${path}'/>'
		type="application/pdf" width="1250" height="500">
		</object>
		</div>
</body>
</html>