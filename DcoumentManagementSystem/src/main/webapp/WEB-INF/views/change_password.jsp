<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href='<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" />'>
<link rel="stylesheet"
	href='<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />'>
<link rel="stylesheet"
	href='<c:url value="/webjars/jquery/3.4.1/js/jquery.min.js" />'>
</head>
<body class="app flex-row align-items-center">
	<form:form method="post"
		action="${pageContext.request.contextPath}/change.htm"
		modelAttribute="change_password">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6">
					<div class="card mx-4">
						<div class="card-body p-4">
							<h2>Changing Password</h2>
							<div class="form-group">
								Your Email:
								<form:input type="text" class="form-control " path="email"
									value="${email }" readonly="true" />
							</div>
							<div class="form-group">
								Current Password::
								<form:input type="Password"
									class="form-control form-control-user" path="current_password" />
							</div>
							<div class="form-group">
								New Password:
								<form:input type="Password"
									class="form-control form-control-user" path="new_password" />
							</div>
							<div class="form-group">
								Confirm Password:
								<form:input type="Password"
									class="form-control form-control-user" path="confirm_password" />
							</div>
							<div class="row">
								<div class="col-10">
									<button class="btn btn-primary px-4" type="submit">Save</button>
									<button class="btn btn-primary px-4" type="reset">Cancel</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form:form>
</body>
</html>