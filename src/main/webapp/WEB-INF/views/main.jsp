<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>YGSLAB</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" />
</head>
<body>
	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/nav.jsp"></jsp:include>
    <header class="masthead">
	    <div class="container position-relative px-4 px-lg-4">
	        <div class="row gx-4 gx-lg-5 justify-content-center">
	            <div class="col-md-10 col-lg-8 col-xl-7">
	                <div class="site-heading">
	                    <h1>YGSLAB</h1>
	                    <span class="subheading">Welcome to YGSLAB!</span>
	                </div>
	            </div>
	        </div>
	    </div>
	</header>
    <!-- Main Content-->
    <div class="container px-4 px-lg-5">
        <div class="row gx-4 gx-lg-5 justify-content-center">
            <div class="col-md-10 col-lg-8 col-xl-7">
                <!-- Post preview-->
                <h1 class="h1" style="margin-bottom: 60px;">Recent</h1>
                <c:forEach items="${list}" var="list">
					<div class="post-preview">
						<c:choose>
							<c:when test="${list.type eq 'writing'}">
								<a href="writing.do?idx=${list.idx}">
									<h2 class="post-title">${list.title}</h2>
								</a>
							</c:when>
							<c:when test="${list.type eq 'IT'}">
								<a href="IT.do?idx=${list.idx}">
									<h2 class="post-title">${list.title}</h2>
								</a>
							</c:when>	
						</c:choose>
						
						<c:set var="date" value="${list.date}" />
						<p class="post-meta">
							<fmt:formatDate value="${date}" pattern="y-M-d" type="date"/>
						</p>
					</div>
					<div style="margin-top: 50px;"></div>
                </c:forEach>
                <!-- Divider-->
                <hr class="my-4" />
            </div>
        </div>
	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/footer.jsp"></jsp:include>
    </div>
</body>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
</html>
