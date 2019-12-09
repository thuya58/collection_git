<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ include file="/WEB-INF/views/common/include.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>   
<!DOCTYPE html>
<html lang="en">

<head>

  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title><tiles:insertAttribute name="title" /></title>

  <link href='<c:url value="/resources/vendor/fontawesome-free/css/all.min.css" />' rel="stylesheet" type="text/css">
  <link href='<c:url value="/resources/css/sb-admin-2.min.css" />' rel="stylesheet" type="text/css">
</head>

<body id="page-top">

  <div id="wrapper">
  
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
		<a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.html">
        <div class="sidebar-brand-icon rotate-n-15">
          <i class="fas fa-laugh-wink"></i>
        </div>
        <div class="sidebar-brand-text mx-3">Menu</div>
      </a>
		
		<tiles:insertAttribute name="menu" />
    </ul>
    <div id="content-wrapper" class="d-flex flex-column">
      <div id="content">
        <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

          <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
          </button>

          <!--  header -->
      <tiles:insertAttribute name="header" />
        </nav>
        <div class="container-fluid">
 		<tiles:insertAttribute name="body" />
        </div>

      </div>
      <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-center my-auto">
            <span> <tiles:insertAttribute name="footer" /></span>
          </div>
        </div>
      </footer>
    </div>

  </div>
 
<%-- <script src='<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js"/>'></script>
 --%> 
 <script src='<c:url value="/resources/vendor/jquery/jquery.min.js" /> '></script>
  <script src='<c:url value="/resources/vendor/bootstrap/js/bootstrap.bundle.min.js" />'></script>
  <script src='<c:url value="/resources/vendor/jquery-easing/jquery.easing.min.js" />'></script>
  <script src='<c:url value="/resources/js/sb-admin-2.min.js" />'></script>
  <script src='<c:url value="/resources/vendor/datatables/jquery.dataTables.min.js" />'></script>
  <script src='<c:url value="/resources/vendor/datatables/dataTables.bootstrap4.min.js" />'></script>
  <script src='<c:url value="/resources/js/demo/datatables-demo.js" />'></script>
 
</body>

</html>