<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.model.vo.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if((Member)session.getAttribute("user")!=null)
	{
		session.invalidate(); //세션 파기
	
%>
<h1>로그아웃 되었습니다.</h1>
<%}else{%>
	<h1>로그인 정보가 없습니다.</h1>
<%}%>

<a href = "/web1/views/member/memberIndex.html">로그인 페이지로 이동</a><br>

<%--Servlet -> session 객체
request.getSession(); -> 서블리셍서 사용하는 코드

jsp에서는 해당 jsp 페이지를 로딩하게 되면 자동으로 session 객체가 사용됨
getSession(); 해당 코드가 자동으로 되어 있음 --%>




</body>
</html>