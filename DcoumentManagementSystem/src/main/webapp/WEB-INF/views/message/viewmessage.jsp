<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style>
table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th {
	height: 50px;
}
<
title
>
Insert
 
title
 
here
</title
>
</style>
</head>
<body>
<div class="card shadow mb-4">
            <div class="card-header py-3">
              <h6 class="m-0 font-weight-bold text-primary">Message List<a class="btn btn-outline-primary float-right" href="<c:url value='/messagesend.htm' />">New Message</a></h6>
              
            </div>
            <div class="card-body">
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                 <thead>
			<tr>
				<th>No</th>
				<th>Title</th>
				<th>Description </th>
				<th>SendDate</th>
				<th>Action</th>
			</tr>
		</thead>
                  <!-- <tfoot>
                  <th>No</th>
				<th>Title</th>
				<th>Description </th>
				<th>SendDate</th>
				<th>Action</th>
                  </tfoot> -->
                  <tbody>
                    <c:forEach var="message" items="${messageList}" varStatus="row">
				<tr>
					<td>${row.count }</td>
					<td>${message.title }</td>
					<td>${message.description }</td>
					<td>${message.sendDate }</td>
					<td>
					<a href="<c:url value='/message_detail.htm/${message.id}' />">View</a></td>
		</tr>
	</c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>	


</body>
</html>