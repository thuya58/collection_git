<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Message</title>
<link rel='stylesheet'
	href='<c:url value="/resources/chosen/chosen.css"/>'>
	<script>
	window.console = window.console || function(t) {
	};
</script>
<script>
	if (document.location.search.match(/type=embed/gi)) {
		window.parent.postMessage("resize", "*");
	}
</script>
</head>
<body>
	<form:form class="send message" method="post" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/message_send.htm"
		modelAttribute="message">
		<div class="container">
			<div class="card-body">
				<h1 class="h4 text-gray-900 mb-4">Sending Message</h1>
				<p>To</p>
				<div class="input-group mb-4">
					<div class="input-group-prepend"></div>
					<form:select data-placeholder="Select Receiver Name" path="receiver_list"
						name="receiver_list" class="chosen-select col-sm-12" multiple="multiple">
						<c:forEach var="user" items="${userList}" varStatus="index">
							<form:option value="${user.id}">${user.name}</form:option>

						</c:forEach>
					</form:select>
				</div>				
				<p>Title</p>
				<div class="input-group mb-3">
					<div class="input-group-prepend"></div>
					<form:input class="form-control col-sm-9" path="title"
						type="text" />
				</div>
				<div class="input-group mb-3">
					<div class="input-group-prepend"></div>
					<form:textarea rows="10"  id="editor" class="form-control col-sm-12" path="description" placeholder="Description"></form:textarea>
				</div>
				<div class="row">
					<div class="col-6">
						<form:button class="btn btn-primary px-4" type="submit">Send</form:button>
						<form:button class="btn btn-primary px-4" type="reset" >Cancel</form:button>
					</div>
				</div>
			</div>
		</div>
	</form:form>
<%-- 	<script src="<c:url value='/resources/js/ckeditor.js' />"></script>
 --%>	
	<script src="https://cdn.ckeditor.com/4.12.1/standard/ckeditor.js"></script>
<script type="text/javascript">
   CKEDITOR.replace( 'editor' );
</script>
<script src='<c:url value="/resources/vendor/jquery/jquery.min.js" /> '></script>
<script src='<c:url value="/resources/chosen/chosen.jquery.js"/>'></script>
<script id="rendered-js">
	jQuery(function($) {
		$('.chosen-select').chosen()});
</script>
</body>
</html>