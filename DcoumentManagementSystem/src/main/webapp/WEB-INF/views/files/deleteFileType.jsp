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
			<h6 class="m-0 font-weight-bold text-primary">Delete File</h6>
		</div>
		<div class="card-body">
				<form:form method="post" action="${pageContext.request.contextPath}/deletefileType.htm" modelAttribute="fileType">
					<form:input path="id" type="hidden" value="${file_type.id}"/>
					<form:input path="location" type="hidden" value="${file_type.location}"/>
					<table class="table table-borderless" id="dataTable" width="100%" cellspacing="0">
						<tr>
							<td>File Extension</td>
							<td><div class="custom-file col-sm-6">
									<form:input path="type" type="text" class="form-control form-control-user" value="${file_type.type}"/>
								</div></td>
						</tr>
						<tr>
							<td>Folder Name</td>
							<td><div class="custom-file col-sm-6">
									<form:input path="name" type="text" class="form-control form-control-user" value="${file_type.name}"/>
								</div></td>
						</tr>
						<tr>
							<td> </td>
							<td> <input type="checkbox" id="myCheckbox"/>Are you want to Sure Check this box</td>
						</tr>
						<tr>
							<td> </td>
							<td>
							<input type="submit" value="Delete" class="btn btn-primary px-4" disabled="disabled"/>
							<input type="reset" value="Cancel" class="btn btn-primary px-4"/></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
		<script type="text/javascript">
	$(function(){
			$('#myCheckbox').on("change", function (){
				var ckbox= $('#myCheckbox');
				 if (ckbox.is(':checked')) {
					 $('input[type="submit"]').removeAttr('disabled'); 
			        } else {
			        	$('input:Submit').attr('disabled',true);
			        }
			});
		    });
</script>
</body>
</html>