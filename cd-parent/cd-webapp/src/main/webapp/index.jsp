<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>Bank System</title>
</head>
<body>
<s:form action="login">
	Username123: <s:textfield name="user.username"/>
	Password: <s:textfield name="user.password"/>
	<s:property value="message"/>
	<s:submit value="Login"/>
</s:form>
</body>
</html>
