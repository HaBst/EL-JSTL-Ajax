<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="m" class = "member.model.vo.Member" scope = "page">
<jsp:setProperty name = "m" property = "name" value = "홍길동"/>
<jsp:setProperty name = "m" property = "age" value = "20"/>
<jsp:setProperty name = "m" property = "addr" value = "경기도"/>
</jsp:useBean>

<H1>Action Tag 사용</H1>
이름 : <jsp:getProperty property = "name" name = "m"/><br>
나이 : <jsp:getProperty property = "age" name = "m"/><br>
주소 : <jsp:getProperty property = "addr" name = "m"/><br>
</body>
</html>