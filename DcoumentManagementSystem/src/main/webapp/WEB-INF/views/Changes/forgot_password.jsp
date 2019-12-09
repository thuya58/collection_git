<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Forget Password</title>
</head>
<body>
	<div class="container">

		<form:form class="form-horizontal" method="post"
			action="${pageContext.request.contextPath}/add_password.htm"
			modelAttribute="User_registerDto">
		<div class="row justify-content-center">

			<div class="col-xl-5 col-lg-6 col-md-8">

				<div class="card o-hidden border-0 shadow-lg my-5">
					<div class="card-body p-0">
						<!-- Nested Row within Card Body -->
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-2">Forgot Your Password?</h1>
								<p>Enter Your Email address</p>
							</div>
							<form class="user">
								<div class="input-group mb-12">
									<div class="input-group-prepend">
										<span class="input-group-text"> <i class="icon-user"></i>
										</span>
									</div>
									<form:input class="form-control" name="Email" type="text" path="email"
										placeholder="Enter Your Email" />
								</div>
								<br>
								<div class="col-12">
									<form:button class="btn btn-primary btn-user"
										type="submit">Reset Password</form:button>
								</div>
							</form>
							<hr>
						</div>
					</div>
				</div>
			</div>
		</div>
		</form:form>
	</div>
</body>
</html>