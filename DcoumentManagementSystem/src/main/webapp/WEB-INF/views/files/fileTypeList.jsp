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
		<h6 class="m-0 font-weight-bold text-primary">Received File</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			
						<table class="table table-bordered dataTable" id="dataTable"
							width="100%" cellspacing="0" role="grid"
							aria-describedby="dataTable_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th>No</th>
									<th>File Extension</th>
									<th>Folder Name</th>
									<th>Update</th>
									<th>Delete</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="fileType" items="${fileTypeList}" varStatus="row">
									<tr>
										<td>${row.count }</td>
										<td>${fileType.type}</td>
										<td>${fileType.name}</td>
										<td><a href='<c:url value="updateFileType.htm/${fileType.id }"/>'>Update</a></td>
										<td><a href='<c:url value="deleteFileType.htm/${fileType.id }"/>'>Delete</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
</body>
</html>