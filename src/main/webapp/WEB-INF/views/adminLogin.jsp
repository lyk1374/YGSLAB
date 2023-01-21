<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>관리자 로그인</title>
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
	<div class="container">	
	<h2>관리자 로그인</h2>
		<form action="loginAction.do" method="post">
			<div class="mb-3">
				<label class="form-label" for="id">아이디</label> 
				<input class="form-control" type="text" name="id" id="id" />
			</div>
			<div class="mb-3">
				<label class="form-label" for="pwd">비밀번호</label> 
				<input class="form-control" type="password" name="pw" id="pw" />
			</div>
			<button class="btn btn-outline-primary btn-sm" type="submit">로그인</button>
		</form>
	</div>
</body>
</html>