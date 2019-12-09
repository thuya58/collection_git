<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
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
									<th>Title</th>
									<th>File Type</th>
									<th>Sender</th>
									<th>Send Date</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach var="file" items="${sharefile_list}" varStatus="row">
									<tr>
										<td>${row.count }</td>
										<td>${file.file_detail.title}</td>
										<td>${file.file_detail.name}</td>
										<td>${file.file_detail.user_info.name}</td>
										<td>${file.send_date}</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>