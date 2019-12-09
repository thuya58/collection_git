<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.dms.services.SecurityUtil"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<h2 style="color: #3b58ed; font-weight: bold;">Document Management System</h2>
<!-- o Navbar -->
<input type="hidden" id="pageContext"
	value="${pageContext.request.contextPath}" />
<ul class="navbar-nav ml-auto">
	<li class="nav-item dropdown no-arrow d-sm-none"><a
		class="nav-link dropdown-toggle" href="#" id="searchDropdown"
		role="button" data-toggle="dropdown" aria-haspopup="true"
		aria-expanded="false"> <i class="fas fa-search fa-fw"></i>
	</a> <!-- Dropdown - Messages -->
		<div
			class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
			aria-labelledby="searchDropdown">
			<form class="form-inline mr-auto w-100 navbar-search">
				<div class="input-group">
					<input type="text" class="form-control bg-light border-0 small"
						placeholder="Search for..." aria-label="Search"
						aria-describedby="basic-addon2">
					<div class="input-group-append">
						<button class="btn btn-primary" type="button">
							<i class="fas fa-search fa-sm"></i>
						</button>
					</div>
				</div>
			</form>
		</div></li>

	<!-- Nav Item - Alerts -->
	<li class="nav-item dropdown no-arrow mx-1"><a
		class="nav-link dropdown-toggle" href="#" id="alertsDropdown"
		role="button" data-toggle="dropdown" aria-haspopup="true"
		aria-expanded="false"> <i class="fas fa-bell fa-fw"></i> <!-- Counter - Alerts -->
			<span class="badge badge-danger badge-counter" id="countfile"></span>
			
	</a> <!-- Dropdown - Alerts -->
		<div
			class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
			aria-labelledby="alertsDropdown" id="data-dropdown">
		</div>
		</li>

	<!-- Nav Item - Messages -->
	<li class="nav-item dropdown no-arrow mx-1"><a
		class="nav-link dropdown-toggle" href="#" id="messagesDropdown"
		role="button" data-toggle="dropdown" aria-haspopup="true"
		aria-expanded="false"> <i class="fas fa-envelope fa-fw"></i> <!-- Counter - Messages -->
			<span class="badge badge-danger badge-counter" id="messageNumber"></span>
	</a> <!-- Dropdown - Messages -->
		<div
			class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" id="message"
			aria-labelledby="messagesDropdown">
		</div></li>

	<div class="topbar-divider d-none d-sm-block"></div>

	<!-- Nav Item - User Information -->
	<li class="nav-item dropdown no-arrow"><a
		class="nav-link dropdown-toggle" href="#" id="userDropdown"
		role="button" data-toggle="dropdown" aria-haspopup="true"
		aria-expanded="false"> <span
			class="mr-2 d-none d-lg-inline text-gray-600 small"> <security:authentication
					var="user" property="principal" /> <security:authorize
					access="isAuthenticated()">

					<b style="color: #3b58ed;">${user.name }</b></span> <img
			class="img-profile rounded-circle" src="<c:url value='/resources/profiles/${user.photo}'/>"> </security:authorize>
	</a> <!-- Drop down - User Information -->
		<div
			class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
			aria-labelledby="userDropdown">
			<a class="dropdown-item" href='<c:url value='profile.htm'/>'> <i
				class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i> Profile
			</a> <a class="dropdown-item" href='<c:url value='change_password.htm'/>'>
				<i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i> Change
				Password
			</a>
			<div class="dropdown-divider"></div>
			<a class="dropdown-item" href="<c:url value='/logout.htm' />"> <i
				class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
				Logout
			</a>
		</div></li>
</ul>
<script src='<c:url value="/resources/vendor/jquery/jquery.min.js" /> '></script>
<script>

	jQuery( setTimeout(function() {
		$.ajax({
			type : "GET",
			url : $("#pageContext").val() + "/ajax/getNotiList", //this is my servlet
			contentType : 'application/json',
			success : function(data) {
			var fileList ='';
			var documentData= $("#data-dropdown");
			var countfile= $("#countfile");
			var nfile=0;
			var mData= $("#message");
			var countM= $("#messageNumber");
			var mList='';
			var nMessage=0;
			if(data.length!=0){
			for (var i= 0; i< data.length;i++){
				if(data[i].notitype=="sharefile"){
					fileList+='<a class="dropdown-item d-flex align-items-center" href="<c:url value="/viewFileDetail.htm/'+data[i].id+'"/>">'
					+'<div class="mr-3">'
					+'<div class="icon-circle bg-primary">'
					+'<i class="fas fa-file-alt text-white"></i>'
					+'</div></div>'
					+'<div>'
					+'<div class="small text-gray-500">'+data[i].send_date+'</div>'+data[i].title+'</div>'
					+'</a>';
				nfile+=1;
					}
				if(data[i].notitype=="message"){
					mList+='<a class="dropdown-item d-flex align-items-center" href="<c:url value="/message_detail.htm/'+data[i].id+'"/>"> <div class="dropdown-list-image mr-3">'
					+'<img class="rounded-circle" src="<c:url value="/resources/profiles/'+data[i].senderName+'"/>" alt="profile">'
					+'<div class="status-indicator bg-success"></div>'
					+'</div><div class="font-weight-bold"><div class="text-truncate">'
					+data[i].title
					+'</div><div class="small text-gray-500">'
					+data[i].send_date+data[i].senderName+'</div></div></a>';
					nMessage+=1;
				}
				}
			}
				countfile.append(nfile);
				documentData.html(fileList);
				mData.html(mList);
				countM.html(nMessage);
			}
		});
	},3000));
</script>