<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>一-jd</title>
</head>
<body>
欢迎来到一-jd
<%--获取当前登录名--%>
<%=request.getRemoteUser()%><a href="http://localhost:9100/cas/logout?service=http://www.baidu.com">退出登录</a>
</body>
</html>
