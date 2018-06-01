<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EL을 이용한 MAP 처리</h1>
<!-- 
이름 : ${member.name}<br>
나이 : ${member.age}<br>
주소 : ${member.addr}<br>
 -->

이름 : ${members.member1.name}<br>
나이 : ${members.member1.age}<br>
주소 : ${members.member1.addr}<br>
<br>
이름 : ${members.member2.name}<br>
나이 : ${members.member2.age}<br>
주소 : ${members.member2.addr}<br>
</body>
</html>