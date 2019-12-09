<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<script type="text/javascript" src="jquery-1.2.6.min.js"></script>
<title>Spring MVC file upload</title>
</head>
<body>
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<h6 class="m-0 font-weight-bold text-primary">Upload File</h6>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<form:form method="post" enctype="multipart/form-data"
					modelAttribute="uploadedFile" action="${pageContext.request.contextPath}/uploadFile.htm">
					<table class="table table-borderless" id="dataTable" width="100%"
						cellspacing="0">
						<tr>
							<td>Insert For Title</td>
							<td><div class="custom-file col-sm-6">
									<form:input type="text" name="text" path="title" width="100%" class="form-control form-control-user"/> 
										<form:errors 
									path="file" />
								</div></td>
						</tr>
						<tr>
							<td>Upload File: </td>
							<td><div class="custom-file col-sm-6">
									<form:input type="file"  path="file"
										name="file"/>
										<form:errors
									path="file" />
								</div></td>
						</tr>
						<tr>
							<td> </td>
							<td>
							<input type="Submit" value="Upload"
								class="btn btn-primary px-4 col-sm-3" />
							<input type="reset" value="Cancel"
								class="btn btn-primary px-4 col-sm-3" /></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	$(document).ready(
		    function(){
		        $('input[type="submit"]').attr('disabled',true);
		        $('input:file').change(
		            function(){
		                if ($(this).val()){
		                    $('input[type="submit"]').removeAttr('disabled'); 
		                }
		                else {
		                    $('input:Submit').attr('disabled',true);
		                }
		            });
		    });
</script>
</body>
</html>

