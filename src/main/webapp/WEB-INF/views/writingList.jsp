<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>수필</title>
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
	                    <h1>수필</h1>
	                    <span class="subheading">The Story of YG</span>
	                </div>
	            </div>
	        </div>
	    </div>
	</header>
	<div class="container px-4 px-lg-5">
        <div class="row gx-4 gx-lg-5 justify-content-center">
            <div class="col-md-10 col-lg-8 col-xl-7">
				<div class="post-preview">
					<c:forEach items="${list}" var="list">
						<a href="writing.do?idx=${list.writing_idx}" >
							<h2 class="post-title">${list.writing_title}</h2>
						</a>
						<p class="post-meta">
							${list.writing_date}
						</p>
						<div style="margin-top: 100px;"></div>
					</c:forEach>
				</div>
                <!-- Paging-->
				<ul class="pagination">
			    	<c:if test="${curPageNum ne 1}">
			    		<li class="page-item"><a class="page-link" href="writingList.do?curPageNum=1">처음</a></li>
					    <li class="page-item"><a class="page-link" href="writingList.do?curPageNum=${curPageNum-1}">이전</a></li>
			    	</c:if>
				    <c:forEach begin="${startPageNum}" end="${endPageNum}" var="navPageNum">
				    	<c:choose>
				    		<c:when test="${navPageNum eq curPageNum}">
				    			<li class="page-item active"><a class="page-link" href="writingList.do?curPageNum=${navPageNum}">${navPageNum}</a></li>
				    		</c:when>
				    		<c:when test="${navPageNum ne curPageNum}">
				    			<li class="page-item"><a class="page-link" href="writingList.do?curPageNum=${navPageNum}">${navPageNum}</a></li>
				    		</c:when>	
				    	</c:choose>
				    </c:forEach>
				    <c:if test="${curPageNum ne allPageCnt}">
					    <li class="page-item"><a class="page-link" href="writingList.do?curPageNum=${curPageNum+1}">다음</a></li>
					    <li class="page-item"><a class="page-link" href="writingList.do?curPageNum=${allPageCnt}">끝</a></li>
				    </c:if>
				</ul>
				<div style="margin-bottom: 50px;"></div>
				<!-- Divider-->
                <hr class="my-4" />
            </div>
        </div>
	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/views/footer.jsp"></jsp:include>
    </div>
</body>
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/scripts.js"></script>
</html>