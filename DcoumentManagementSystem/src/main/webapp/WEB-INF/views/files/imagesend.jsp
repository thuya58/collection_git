<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>image view </title>
</head>
<body>
<a href="<c:url value='/myFile.htm' />" class="btn btn-primary px-4">Back</a>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class=" mx-4">
					<div class=" p-4">
						<img class="user-avatar " src='<c:url value='${path}'/>'
							height="100%" width="100%">
						<div class=" font-weight-bold">
							${imageName}
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>