<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<meta charset="utf-8" />
<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>관리자 페이지</title>
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${pageContext.request.contextPath}/resources/css/styles.css" rel="stylesheet" />
<body>
	<div class="container px-4 px-lg-5">
        <div class="row gx-4 gx-lg-5 justify-content-center" style="border: 1px solid;">
            <div class="col-md-10 col-lg-8 col-xl-7">
				<div style="margin-top: 100px;"></div>
				<h1 class="h1"><a href="write.do">글 쓰기</a></h1>
				<div style="margin-top: 100px;"></div>
				<h1 class="h1"><a href="modifyList.do">글 수정</a></h1>
				<div style="margin-top: 100px;"></div>
				<h1 class="h1"><a href="deleteList.do">글 삭제</a></h1>
				<div style="margin-top: 100px;"></div>
			</div>
		</div>
	</div>			
</body>
</html>