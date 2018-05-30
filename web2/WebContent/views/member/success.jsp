<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "member.model.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
	window.onload = function(){
		if(opener!=null){ // 자신이 팝업창 일때(팝업창일경우opener는 null 일반 창일경우 opener는 !null)
			opener.location.reload(); // 페이지 새로고침(opener는 부모 -> 팝업창을 뜨게 하는 매개체)
			window.close();
		}
	}
</script>
<body>
<%Member m = (Member)session.getAttribute("user"); %>
<h1>성공페이지</h1>
<%=m.getUserName() %> 님 환영합니다.
<a href="/index.jsp">메인페이지로 이동</a>
</body>
</html>