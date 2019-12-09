<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body class="bg-gradient-primary">
	<form action="login.htm" method="post">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-xl-5 col-lg-6 col-md-3">
					<div class="card-group">
						<div class="card o-hidden border-0 shadow-lg-my-5 p-4">
							<div class="card-body p-0">
								<div class="text-center">
									<h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
									<p class="text-muted">Sign In to your account</p>
								</div>
								<div class="input-group mb-3">
									<div class="input-group-prepend">
										<span class="input-group-text"> <i class="icon-user"></i>
										</span>
									</div>
									<input class="form-control" name="username" type="text"
										placeholder="Enter Your Email" />
								</div>
								<div class="input-group mb-4">
									<div class="input-group-prepend">
										<span class="input-group-text"> <i class="icon-lock"></i>
										</span>
									</div>
									<input class="form-control" name="password" type="password"
										placeholder="Enter Your Password" />
									
								</div>
								<div class="input-group mb-4">
									<c:if test="${param.error != null}">
									<font color='red'>Invalid user name and password</font>
									</c:if>
								</div>
								
								<div class="row">
									<div class="col-6">
										<button class="btn btn-primary btn-user btn-block"
											type="submit">Login</button>

									</div>
									<div class="col-6 text-right">
										<a class="small" href='<c:url value='forgot_password.htm'/>'>
											Forgot password?</a>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>