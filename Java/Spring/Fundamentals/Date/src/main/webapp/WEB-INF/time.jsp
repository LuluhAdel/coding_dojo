<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Time</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
  <script type="text/javascript" src="js/time.js"></script>
</head>
<body>
	<h1 id="time">
		<c:out value="${time}"/>
	</h1>
</body>
</html>