<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- 자바빈 객체 생성 -->
<!-- scope 범위 
    1. scope : 현재 page 내
    2. request : request가 최종 포워딩 되는 페이지까지
    3. session : 세션을 유지할 때 까지
    4. application : 웹 애플리케이션이 종료될 때까지
 -->
 
<jsp:useBean id="member" class = "member.model.vo.Member" scope = "request">
</jsp:useBean>
이름 : <jsp:getProperty property="name" name="member" /><br>
나이 : <jsp:getProperty property="age" name="member" /><br>
주소 : <jsp:getProperty property="addr" name="member" /><br>

</body>
</html>