<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href='<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" />'>
<link rel="stylesheet"
	href='<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />'>
<link rel="stylesheet"
	href='<c:url value="/webjars/jquery/3.4.1/js/jquery.min.js" />'>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card mx-4">
					<div class="card-body p-4">
						<h1 class="h4 text-gray-900 mb-4">Profile</h1>
						<img alt="profile" src="resources/profiles/${profile.photo}"
								height="220" width="220">
						
						<div class="input-group mb-4">
							
							<table>
								<tr>
									<td><i class=" 3x fas fa-user-circle"></i> :</td>
									<td>${profile.name}</td>
								</tr>
								<tr>
									<td><i class="3x fas fa-phone-square"></i> :</td>
									<td>${profile.phno}</td>
								</tr>
								<tr>
									<td><i class="fas fa-envelope-open"></i> :</td>
									<td>${profile.email}</td>
								</tr>
								<tr>
									<td><i class="3x fas fa-graduation-cap"></i> :</td>
									<td>${profile.nrc}</td>
								</tr>
								<tr>
									<td><i class="fas fa-building"></i> :</td>
									<td>${profile.department}</td>
								</tr>
								<tr>
									<td><i class="fas fa-user-tag"></i> :</td>
									<td>${profile.role}</td>
								</tr>
								<tr>
									<td><i class="3x fas fa-map-marker-alt"></i> :</td>
									<td>${profile.address}</td>
								</tr>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>

