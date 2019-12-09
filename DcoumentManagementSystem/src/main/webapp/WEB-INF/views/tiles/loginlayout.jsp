<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>   
<!DOCTYPE html>    
   
<html>    
<head>    
<meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
<title><tiles:insertAttribute name="title" /></title>
 	<link href='<c:url value="/resources/vendor/fontawesome-free/css/all.min.css" />' rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
  <link href='<c:url value="/resources/css/sb-admin-2.min.css" />' rel="stylesheet" type="text/css">
</head>    
<body><br><br><br><br><br><br><br>
  <tiles:insertAttribute name="body" />   
  <script src='<c:url value="/resources/vendor/jquery/jquery.min.js" /> '></script>
  <script src='<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />'></script>
  <script src='<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" />'></script>
  <script src='<c:url value="/resources/js/sb-admin-2.min.js" />'></script> 
</body>    
</html>    