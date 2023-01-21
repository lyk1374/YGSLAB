<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<title>수정 리스트</title>
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
	<h1 class="h1">수필 리스트</h1>
	<ul>
		<c:forEach items="${writingList}" var="writingList">
			<li>
				<a href="writingModify.do?idx=${writingList.writing_idx}">
					<span>${writingList.writing_idx}</span>
					<span>${writingList.writing_title}</span>
				</a>
			</li>
		</c:forEach>
	</ul>
	<h1 class="h1">IT 리스트</h1>
	<ul>
		<c:forEach items="${ITList}" var="ITList">
			<li>
				<a href="ITModify.do?idx=${ITList.it_idx}">
					<span>${ITList.it_idx}</span>
					<span>${ITList.it_title}</span>
				</a>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
