<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
				<form:form method="post" action="${pageContext.request.contextPath}/changefileType.htm" modelAttribute="fileType">
					<form:input path="id" type="hidden" value="${file_type.id}"/>
					<table class="table table-borderless" id="dataTable" width="100%"
						cellspacing="0">
						<tr>
							<td>Old File Extension</td>
							<td><div class="custom-file col-sm-6">
									<form:input path="type" type="text" class="form-control form-control-user" value="${file_type.type}"/>
								</div></td>
						</tr>
						<tr>
							<td>Old Folder Name</td>
							<td><div class="custom-file col-sm-6">
									<form:input path="name" type="text" class="form-control form-control-user" value="${file_type.name}"/>
								</div></td>
						</tr>
						<tr>
							<td>New File Extension</td>
							<td><div class="custom-file col-sm-6">
									<form:input path="newType" type="text" class="form-control form-control-user"/>
								</div></td>
						</tr>
						<tr>
							<td>new Folder Name</td>
							<td><div class="custom-file col-sm-6">
									<form:input path="newName" type="text" class="form-control form-control-user"/>
								</div></td>
						</tr>
						<tr>
							<td> </td>
							<td>
							<input type="submit" value="Save" class="btn btn-primary px-4"/>
							<input type="reset" value="Cancel" class="btn btn-primary px-4"/></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
</body>
</html>