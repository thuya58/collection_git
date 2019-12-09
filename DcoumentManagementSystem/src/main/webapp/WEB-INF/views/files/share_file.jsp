<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv="x-ua-compatible" content="ie=edge">
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
<body translate="no">

	<form:form
		action="${pageContext.request.contextPath}/savesharefile.htm"
		modelAttribute="share_fileDto">
		<div class="card shadow mb-4">
			<div class="card-body">
				<div class="table-responsive">
					<table class="table table-borderless" id="dataTable" width="100%"
						cellspacing="0">
						<tr><td>Choose Name You want to share</td>
						<td >
										<form:select data-placeholder="Choose user name"
									path="receiver" name="fileList"
									class="chosen-select col-sm-12 form-control form-control-user"
									multiple="multiple">
									<c:forEach var="user" items="${userList }"
										varStatus="index">
										<form:option value="${user.id}">${user.name}</form:option>
									</c:forEach>
									</form:select>
						</td>
						</tr>
						<tr>
							<td >Choose File You want to share</td>
							<td> <form:select data-placeholder="Choose file name"
									path="fileList" name="fileList"
									class="chosen-select col-sm-12 form-control form-control-user"
									multiple="multiple">
									<c:forEach var="ownfile" items="${details_list }"
										varStatus="index">
										<form:option value="${ownfile.id}">${ownfile.name}</form:option>
									</c:forEach>
								</form:select></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="submit" class="btn btn-primary px-4"
								value="Submit"> <input type="button"
								class="btn btn-primary px-4" value="Cancel"></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<br>
		<br>
		<br>
		<br>
		<input type="hidden" id="pageContext"
			value="${pageContext.request.contextPath}" />
	</form:form>
	<script src='<c:url value="/resources/vendor/jquery/jquery.min.js" /> '></script>
	<script src='<c:url value="/resources/chosen/chosen.jquery.js"/>'></script>
	<script id="rendered-js">
		jQuery(function($) {
			$('.chosen-select').chosen();

		});
	</script>
</body>
</html>

