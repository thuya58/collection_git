<%@ include file="/WEB-INF/views/common/include.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">

<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial, Helvetica, sans-serif;
}

/* Float four columns side by side */
.column {
  float: left;
  width: 20%;
  padding: 0 10px;
}

/* Remove extra left and right margins, due to padding */
.row {margin: 0 -5px;}

/* Clear floats after the columns */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Responsive columns */
@media screen and (max-width: 600px) {
  .column {
    width: 100%;
    display: block;
    margin-bottom: 20px;
  }
}

/* Style the counter cards */
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  padding: 16px;
  text-align: center;
  background-color: #f1f1f1;
}
</style>
</head>
<body>
<c:forEach var="files" items="${ownFile}" varStatus="index">
  <div class="column"  style="width: 215px;height: 305px;">
    <div class="card" width="195" height="281">
    <a href='<c:url value='/imagesend.htm/${files.id }'/>'>
    	<c:if test="${files.type=='jpg'}">
    	<img class="card-img-top" width="161" height="185" src="<c:url value='${files.path}'/>"  alt="Card image cap">
    	</c:if>
    	<c:if test="${files.type=='mp4'}">
      <video width="161" height="185" controls>
        <source src="<c:url value='${files.path}' />" type="video/ogg" />
        <a href="/images/myw3schoolsimage.jpg" download>
      </video>
    	</c:if>
    	<c:if test="${files.type=='mp3'}">
    	<img class="card-img-top" width="161" height="185" src="<c:url value='/resources/icon/audio.jpg'/>" alt="Card image cap">
    	</c:if>
    	<c:if test="${files.type=='docx'||files.type=='doc'}">
    	<img class="card-img-top" width="161" height="185" src="<c:url value='/resources/icon/word.jpg'/>" alt="Card image cap">
    	</c:if>
    	<c:if test="${files.type=='pdf'}">
    	<img class="card-img-top" width="161" height="185" src="<c:url value='/resources/icon/pdf.jpg'/>" alt="Card image cap">
    	</c:if>
    	<c:if test="${files.type=='xlsx'}">
    	 <img class="card-img-top" src='<c:url value='/resources/icon/excel.png'/>' alt="Card image cap">
    	</c:if>
    	<c:if test="${files.type=='png'}">
    	 <img class="card-img-top" width="161" height="185" src='<c:url value='${files.path}'/>' alt="Card image cap">
    	</c:if>
      <div class="row">${files.name }</div></a>
    <a href='<c:url value='${files.path}'/>' download="pitcure" class="btn btn-primary">Download</a>
    </div>
    <br><br><br>
  </div>
  </c:forEach>
</body>
</html>