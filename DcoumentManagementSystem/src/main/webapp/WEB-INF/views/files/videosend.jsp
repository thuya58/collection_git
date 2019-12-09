<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Video view </title>
</head>
<body>
	<a href="<c:url value='/myFile.htm' />" class="btn btn-primary px-4">Back</a>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class=" mx-4">
					<div class=" p-4">
					<p> ${Name}</p>
						<video controls="controls">
							<p> ${Name}</p>
							<source src="<c:url value='${path}' />" type="video/ogg"  width="100%" height="100%"/>
						</video>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>