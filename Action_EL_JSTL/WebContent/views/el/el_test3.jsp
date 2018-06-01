<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<H1>EL을 이용한 배열처리</H1>
이름 : ${members[0].name} <br>
나이 : ${members[0].age} <br>
주소 : ${members[0].addr} <br><br>

이름 : ${members[1].name} <br>
나이 : ${members[1].age} <br>
주소 : ${members[1].addr} <br><br>

이름 : ${members[2].name} <br>
나이 : ${members[2].age} <br>
주소 : ${members[2].addr} <br><br>
</body>
</html>