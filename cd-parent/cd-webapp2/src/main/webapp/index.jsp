<%@page pageEncoding="UTF-8" language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Bank System</title>
</head>
<body>
<form action="login.do" method="POST">
	Username: <input type="text" name="username"/>
	Password: <input type="text" name="password"/>
	<input type="submit" value="Login"/>
</form>
</body>
</html>