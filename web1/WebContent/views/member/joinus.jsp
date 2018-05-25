<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="member.model.service.*" import="member.model.vo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%
		Member m = new Member();
		m.setMemberId(request.getParameter("userId"));
		m.setMemberPwd(request.getParameter("userPwd"));
		m.setMemberName(request.getParameter("userName"));
		m.setMemberAge(Integer.parseInt(request.getParameter("userAge")));
		m.setMemberAddr(request.getParameter("userAddr"));

		int result = new MemberService().insertMember(m);

		if (result > 0) {
	%>
	<h2>회원가입을 축하드립니다</h2>
	<%
		} else {
	%>
	<h2>회원가입을 실패하였습니다</h2>
	<%
		}
	%>
	<a href="memberIndex.html">로그인페이지로 이동</a>
</body>
</html>