<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href='<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" />'>
<link rel="stylesheet" href='<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />'>
<link rel="stylesheet" href='<c:url value="/webjars/jquery/3.4.1/js/jquery.min.js" />'>
</head>
<body>
<h2>Welcome</h2><br>
<form:form method="post" action="${pageContext.request.contextPath}/role.htm" modelAttribute="role">
	Role level:<form:input path="role_level" type="text" /><br>
	<input type="submit" class="button" name="save" value="Save" />
	<input type="submit" class="button" name="update" value="Update" />
	<input type="submit" class="button" name="delete" value="Delete" />
	<input type="submit" class="button" name="search" value="Search" />
</form:form>
</body>
</html>
