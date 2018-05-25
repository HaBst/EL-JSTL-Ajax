<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="member.model.vo.*" import="member.model.service.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 수정</title>
</head>
<body>
<%
	Member m = new Member();
	request.setCharacterEncoding("UTF-8");//인코딩
	m.setMemberId(request.getParameter("userId"));
	m.setMemberPwd(request.getParameter("userPwd"));
	m.setMemberAddr(request.getParameter("userAddr"));
	
	int result = new MemberService().updateMember(m);
	
	if(result > 0){
		m = new MemberService().selectMember(request.getParameter("userId"),
											request.getParameter("userPwd")); 
		// 변경된 member의 모든 정보를 다시 불러와서 객체m에 저장 
		session.setAttribute("user", m);
		// 새로 불러온 객체m으로 세션 갱신
%>
회원정보 수정 완료!<br>

<%}else{ %>
	회원 정보 수정 실패!<br>
	지속적으로 실패시 관리자에게 문의하세요<br>
<%} %>
<a href="/web1/views/member/myinfo.jsp">마이페이지로 이동</a><br>
<a href="/web1/views/member/memberIndex.jsp">로그인 페이지로 이동</a>


</body>
</html>