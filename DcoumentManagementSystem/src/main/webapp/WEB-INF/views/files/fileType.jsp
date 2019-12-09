<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Upload File</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<form:form method="post"
					action="${pageContext.request.contextPath}/savefileType.htm"
					modelAttribute="fileType">
					<table class="table table-borderless" id="dataTable" width="100%"
						cellspacing="0">
						<tr>
							<td>Insert File Extension</td>
							<td><div class="custom-file col-sm-6">
									<form:input path="type" type="text"
										class="form-control form-control-user" />

									<c:if test="${not empty errorMsg}">
										<font color='red'>${errorMsg}</font>
									</c:if>
								</div></td>
						</tr>
						<tr>
							<td>Folder Name</td>
							<td><div class="custom-file col-sm-6">
									<form:input path="name" type="text"
										class="form-control form-control-user" />
								</div></td>
						</tr>
						<tr>
							<td> </td>
							<td><input type="submit" value="Save"
								class="btn btn-primary px-4" /> <input type="reset"
								value="Cancel" class="btn btn-primary px-4" /></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>