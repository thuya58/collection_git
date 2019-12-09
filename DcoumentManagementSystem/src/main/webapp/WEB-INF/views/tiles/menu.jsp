<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
</head>
<body>
		<ul class="nav">
			<li class="nav-item"><a class="nav-link" href="<c:url value='/index.htm' />">
					<i class="3x fas fa-envelope-square"></i>Home
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" data-toggle="dropdown" href="#"
				role="button" aria-haspopup="true" aria-expanded="false"> 
				<i class="fas fa-caret-square-down"></i>File 
			</a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="<c:url value='/file_upload.htm' />">File Upload</a> <a
						class="dropdown-item"href="<c:url value='/sharefile.htm' />">Sharing File with name</a>
					<a class="dropdown-item" href="<c:url value='/shareFile_department.htm'/>" >Sharing File with department</a>
					<a class="dropdown-item" href="<c:url value='/sharefile_another.htm' />"> Received File</a>
					<a class="dropdown-item" href="<c:url value='/sharefile_to_another.htm'/>" >Send File</a>
					<div role="separator" class="dropdown-divider"></div>
					<a class="dropdown-item" href="<c:url value='/myFile.htm' />">My File</a>
				</div></li>
			<li class="nav-item"><a class="nav-link" href='<c:url value='/messagesend.htm' />'>
					<i class="fas fa-star"></i>New Message
			</a></li>
			<li class="nav-item"><a class="nav-link" href='<c:url value='/view_message.htm' />'>
					<i class="fas fa-share-square"></i>Outbox
			</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value='/view_receivedMessage.htm'/>">
					<i class="fas fa-file-alt"></i>Inbox
			</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value='/departmentList.htm'/>">
					<i class="fas fa-file-alt"></i>DepartmentList
			</a></li>
			<security:authorize access="hasAuthority('Role_Admin')">
			<li class="nav-item"><a class="nav-link" href="<c:url value='/userlist.htm'/>">
					<i class="fas fa-file-alt"></i>UserList
			</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value='/fileType.htm'/>">
					<i class="fas fa-file-alt"></i>New Extension
			</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value='/fileTypeList.htm'/>">
					<i class="fas fa-file-alt"></i> Extension List
			</a></li>
			<li class="nav-item"><a class="nav-link" href="<c:url value='/user_register.htm' />">
					<i class="fas fa-registered"></i>New Member
			</a></li>
			</security:authorize>
		</ul>
</body>
</html>
