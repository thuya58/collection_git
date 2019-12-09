<%@page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">Send File</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			
						<table class="table table-bordered dataTable" id="dataTable"
							width="100%" cellspacing="0" role="grid"
							aria-describedby="dataTable_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th>No</th>
									<th>File Name</th>
									<th>Receiver</th>
									<th>Send Date</th>
									<th>Receive Date</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="file" items="${sharefile_to_another_list}"
									varStatus="row">
									<tr>
										<td>${row.count }</td>
										<td>${file.file_detail.name}</td>
										<td>${file.receiver_info.name}</td>
										<td>${file.send_date}</td>
										<td>${file.receive_date}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					
			</div>
		</div>
	</div>	
</body>
</html>