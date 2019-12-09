<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- Earnings (Monthly) Card Example -->
			<div class="col-xl-3 col-md-4 mb-2">
				<div class="card border-left-primary shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<img width="80%" height="80%"
									src='<c:url value='/resources/icon/image.png'/>' alt="image">
								<div class="text-gray-800">
								<input type="hidden" value=>
									Quantity :${imageList.size()}
								</div>
								<div class=" font-weight-bold">
									Type<a href='<c:url value="/view_types.htm/${imageList[0].type }"/>'>Image</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
				<div class="col-sm-1"></div>
			<!-- Earnings (Monthly) Card Example -->
			<div class="col-xl-3 col-md-4 mb-2">
				<div class="card border-left-primary shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<img width="80%" height="80%"
									src='<c:url value='/resources/icon/audio.jpg'/>' alt="image">
								<div class="text-gray-800">
									Quantity :${audioList.size()}
								</div>
								<div class=" font-weight-bold">
									Type<a href='<c:url value='/view_types.htm/${audioList[0].type}'/>'>Audio</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
				<div class="col-sm-1"></div>
			<!-- Earnings (Monthly) Card Example -->
			<div class="col-xl-3 col-md-4 mb-2">
				<div class="card border-left-success shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<img width="80%" height="80%"
									src='<c:url value='/resources/icon/video.jpg'/>' alt="image">
								<div class="text-gray-800">
									Quantity :${videoList.size()}
								</div>
								<div class=" font-weight-bold">
									Type<a href='<c:url value='/view_types.htm/${videoList[0].type}'/>'>Video</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<br><br>
				<div class="row">
			<!-- Earnings (Monthly) Card Example -->
			<div class="col-xl-3 col-md-4 mb-2">
				<div class="card border-left-primary shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<img width="80%" height="80%"
									src='<c:url value='/resources/icon/pdf.jpg'/>' alt="image">
								<div class="text-gray-800">
									Quantity :${pdfList.size()}
								</div>
								<div class=" font-weight-bold">
									Type<a href='<c:url value='/view_types.htm/${pdfList[0].type}'/>'>Pdf</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
				<div class="col-sm-1"></div>
			<!-- Earnings (Monthly) Card Example -->
			<div class="col-xl-3 col-md-4 mb-2">
				<div class="card border-left-primary shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<img width="80%" height="80%"
									src='<c:url value='/resources/icon/excel.png'/>' alt="image">
								<div class="text-gray-800">
									Quantity :${execlList.size()}
								</div>
								<div class=" font-weight-bold">
									Type<a href='<c:url value='/view_types.htm/${execlList[0].type}'/>'>Excel</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
				<div class="col-sm-1"></div>
			<!-- Earnings (Monthly) Card Example -->
			<div class="col-xl-3 col-md-4 mb-2">
				<div class="card border-left-success shadow h-100 py-2">
					<div class="card-body">
						<div class="row no-gutters align-items-center">
							<div class="col mr-2">
								<img width="80%" height="80%"
									src='<c:url value='/resources/icon/word.jpg'/>' alt="image">
								<div class="text-gray-800">
									Quantity :${wordList.size()}
								</div>
								<div class=" font-weight-bold">
									Type<a href='<c:url value='/view_types.htm/${wordList[0].type}'/>'>Word</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>