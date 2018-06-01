<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>forward 태그가 동작하면, 이 글은 보이지 않고 다른 페이지로 forward 됨</h1>
<jsp:forward page = "/views/action/dstPage.html"/>
</body>
</html>