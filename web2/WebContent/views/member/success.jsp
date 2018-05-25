<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "member.model.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Member m = (Member)session.getAttribute("user"); %>
<h1>성공페이지</h1>
<%=m.getUserName() %> 님 환영합니다.
<a href="/index.jsp">메인페이지로 이동</a>
</body>
</html>