<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
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
<body>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Add New User</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable"
					cellspacing="0">
					<form:form class="form-horizontal" method="post"
						enctype="multipart/form-data"
						action="${pageContext.request.contextPath}/user_register.htm"
						modelAttribute="user_registerDTO">
						<div class="form-group row">
							<label class="control-label col-sm-2">Name</label>
							<div class="col-sm-5">
								<form:input type="text" class="form-control form-control-user"
									id="name" path="name" placeholder="Enter Your name" pattern="([A-Za-z\s]){2,}" title="Must contain only characters"/>
							</div>
						</div>
						<div class="form-group row">
							<label class="control-label col-sm-2">Address</label>
							<div class="col-sm-5">
								<form:input type="text" class="form-control form-control-user"
									id="address" path="address" placeholder="Enter Your Address" />
							</div>
						</div>
						<div class="form-group row">
							<label class="control-label col-sm-2">Phone Number</label>
							<div class="col-sm-5">
								<form:input type="text" class="form-control form-control-user"
									id="phone" path="phno" placeholder="Enter Your Phone" pattern="09([0-9]){9}" title="Please check your phone number"/>
							</div>
						</div>
						<div class="form-group row">
							<label class="control-label col-sm-2">NRC number</label>
							<div class="col-sm-5">
								<form:input type="text" class="form-control form-control-user"
									id="nrc" path="nrc" placeholder="Enter Your Nrc NO" pattern="([0-9]){1}\/([A-Za-z]){3,}\(N\)([0-9]{6})" title="Please enter nrc number like 9/ThaPaKa(N)067078"/>
							</div>
						</div>
						<div class="form-group row">
							<label class="control-label col-sm-2">Photo</label>
							<div class="col-sm-10">
								<form:input type="file" id="photo" path="photo"
									class="col-sm-12" />
							</div>
						</div>
						<div class="form-group row">
							<label class="control-label col-sm-2">Email</label>
							<div class="col-sm-5">
								<form:input type="text" class="form-control form-control-user"
									id="email" path="email" placeholder="Enter Your Email Address" pattern="[A-Za-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" title="Enter fromat of email"/>
									<c:if test="${not empty errorMsg}">
										<font color='red'>${errorMsg}</font>
									</c:if>
							</div>
						</div>
						<div class="form-group row">
							<label class="control-label col-sm-2">Password</label>
							<div class="col-sm-5">
								<form:password class="form-control form-control-user"
									id="password" path="password" placeholder="Enter Your Password" pattern=".{8,}" title="Password must contain 8 or more characters"/>
							</div>
						</div>
						<div class="form-group row">
							<label class="control-label col-sm-2">Department</label>
							<div class="col-sm-5">
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
						<div class="form-group row">
							<label class="control-label col-sm-2">User Role</label>
							<div class="col-sm-5">
								<form:select path="role_id" class="custom-select">
									<option value="">Select</option>
									<c:forEach var="role" items="${role_list}">
										<form:option value="${role.id}">
											<c:out value="${role.role_level}" />
										</form:option>
									</c:forEach>
								</form:select>
							</div>
						</div>
						<button class="btn btn-primary px-4" type="submit">Submit</button>&nbsp;&nbsp;
				<button class="btn btn-primary px-4" type="reset">Cancel</button>
					</form:form>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
