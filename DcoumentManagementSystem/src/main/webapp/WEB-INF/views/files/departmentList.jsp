<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="card shadow mb-4">
	<div class="card-header py-3">
		<h6 class="m-0 font-weight-bold text-primary">My File</h6>
	</div>
	<div class="card-body">
		<div class="table-responsive">
			
						<table class="table table-bordered dataTable" id="dataTable"
							width="100%" cellspacing="0" role="grid"
							aria-describedby="dataTable_info" style="width: 100%;">
							<thead>
								<tr role="row">
									<th>No</th>
									<th>Department</th>
									<th>Details</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach var="department" items="${department}" varStatus="row">
									<tr>
										<td>${row.count }</td>
										<td>${department.department}</td>
										<td><a href='<c:url value="/viewByDepartment.htm/${department.id}" />'>View </a>
									</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>		
			</div>
		</div>
	</div>	
</body>
</html>