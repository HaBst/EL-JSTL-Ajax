<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"   %>
<%@ page import="member.model.vo.*" 
		import="member.model.service.*"
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String inputPass = request.getParameter("userPwd");
	String sessionPass = ((Member)session.getAttribute("user")).getMemberPwd();
	String id = ((Member)session.getAttribute("user")).getMemberId();
	if(inputPass.equals(sessionPass)){
	
			int result = new MemberService().deleteMember(id);
			if(result>0)
			{
				out.println("<h1>탈퇴 정상 처리 되었습니다.</h1>");
			}else
			{
				out.println("<h1>탈퇴 실패 하였습니다.</h1>");
			}
	}else
	{

	out.println("<h1>비밀번호가 같지 않습니다. 재확인 바랍니다.</h1>");
	}

%>


</body>
</html>











