<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet"
	href='<c:url value="/webjars/bootstrap/4.3.1/css/bootstrap.min.css" />'>
<link rel="stylesheet"
	href='<c:url value="/webjars/bootstrap/4.3.1/js/bootstrap.min.js" />'>
<link rel="stylesheet"
	href='<c:url value="/webjars/jquery/3.4.1/js/jquery.min.js" />'>
</head>
<body class="app flex-row align-items-center">
	<form:form method="post"
		action="${pageContext.request.contextPath}/mychange.htm"
		modelAttribute="user_registerDTO">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6">
					<div class="card mx-4">
						<div class="card-body p-4">
							<h1 class="h4 text-gray-900 mb-4">Changing Department</h1>
							<div class="form-group row">
								<div class="input-group-prepend">
									<form:input type="hidden" 
										path="id" value="${user.id }"  />
								</div>
							</div>
							<div class="form-group row">
								<div class="input-group-prepend">
									<form:input type="text" class="form-control form-control-user"
										path="name" value="${user.name }" readonly="true" />
								</div>
							</div>
							<div class="form-group row">
								<div class="input-group-prepend">
									<form:input type="text" class="form-control form-control-user"
										path="nrc" value="${user.nrc }" readonly="true" />
								</div>
							</div>
							<div class="form-group row">
								<div class="input-group-prepend">
									<form:input type="text" class="form-control form-control-user"
										path="nrc" value="${user.photo }" readonly="true" />
								</div>
							</div>
							<div class="form-group row">
								<div class="input-group-prepend">
									<form:select path="department_id" class="custom-select">
										<option value="">Select</option>
										<c:forEach var="department" items="${department_list}">
											<form:option value="${department.id}">
												<c:out value="${department.department}" />
											</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<%-- <div class="form-group row">
								<div class="input-group-prepend">
									<form:select path="role_id" class="custom-select">
										<option value="">Select</option>
										<c:forEach var="role" items="${role_list}">
											<form:option value="${role.id}">
												<c:out value="${role.role_level}" />
											</form:option>
										</c:forEach>
									</form:select>
								</div>
							</div> --%>
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