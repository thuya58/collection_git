<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message Detail</title>
</head>
<body>
	<div class="container">
			<div class="card-body">
				<h3 class="title">Message Detail</h3>
				<p>${message.sendDate }</p>
				<p>Title</p>
				<div class="input-group mb-3">
					<div class="input-group-prepend"></div>
					${message.title}
					
				</div>
				<p><b>Description</b></p>
				
				<div class="input-group mb-3">
					<div class="input-group-prepend"></div>
					<p>
					${message.description }
					</p>
				</div>
				<div class="row">
					<a href="<c:url value='/messagesend.htm' />">Reply Message</a>
				</div>
			</div>
		</div>
	
</body>
</html>