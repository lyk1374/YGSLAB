<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>${IT.it_title}</title>
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
	<header class="masthead" style="background-image: url('assets/img/home-bg.jpg')">
	    <div class="container position-relative px-4 px-lg-4">
	        <div class="row gx-4 gx-lg-5 justify-content-center">
	            <div class="col-md-10 col-lg-8 col-xl-7">
	                <div class="site-heading">
	                    <h1>${IT.it_title}</h1>
	                	<span class="subheading">${IT.it_date}</span>
	                </div>
	            </div>
	        </div>
	    </div>
	</header>
	<div class="container px-4 px-lg-5">
        <div class="row gx-4 gx-lg-5 justify-content-center">
            <div class="col-md-10 col-lg-8 col-xl-7">
            	${IT.it_content }
            	<div style="margin-bottom: 50px;"></div>
            	<a class="btn btn-primary float-end" href="ITList.do?curPageNum=${curPageNum}">목록</a>
            	<c:if test="${nextIT.it_title ne null}">
            		<a class="h4 d-inline-block col-7 text-truncate" href="IT.do?idx=${nextIT.it_idx}">next: ${nextIT.it_title}</a>
            	</c:if>
            	<div class="mt-4"></div>
            	<c:if test="${prevIT.it_title ne null}">
            		<a class="h4 d-inline-block col-7 text-truncate" href="IT.do?idx=${prevIT.it_idx}">prev: ${prevIT.it_title}</a>
            	</c:if>
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