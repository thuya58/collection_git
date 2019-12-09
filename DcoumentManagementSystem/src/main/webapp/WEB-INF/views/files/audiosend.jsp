<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="<c:url value='/myFile.htm' />" class="btn btn-primary px-4">Back</a>
	<div class="container">
<audio id="myAudio" controls>
		<source src="<c:url value='${path}' />" type="audio/ogg">
		<source src="<c:url value='${path}' />" type="audio/mpeg">
		Your browser does not support the audio element.
	</audio>

	<p>
		Playback position: <span id="demo"></span>
	</p>

	<script>
		// Get the audio element with id="myAudio"
		var aud = document.getElementById("myAudio");

		// Assign an ontimeupdate event to the audio element, and execute a function if the current playback position has changed
		aud.ontimeupdate = function() {
			myFunction()
		};

		function myFunction() {
			// Display the current position of the audio in a p element with id="demo"
			document.getElementById("demo").innerHTML = aud.currentTime;
		}
	</script>
</body>
</html>