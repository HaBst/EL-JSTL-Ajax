<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import= "member.model.vo.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>나의 정보 출력</title>
</head>
<body>
<% 	
		Member m = (Member)session.getAttribute("user");
	if(m != null)
	{
%>
<script>
function back(){
	history.go(-1);
}
</script>
	<center>
	나의 정보<br>
	<form action = "memberUpdate.jsp" method="post" style = "display:inline">
	ID : <input type = "text" name = "userId" readonly value = <%=m.getMemberId()%> /><br>
	PW : <input type = "password" name = "userPwd" value=<%=m.getMemberPwd()%> /><br>
	PW_re : <input type = "password" name = "userPWd_re"value = <%=m.getMemberPwd() %> /><br>
	Name : <input type = "text" name = "userName" readonly value = <%=m.getMemberName()%> /><br>
	Age : <input type = "text" name = "userAge" readonly value = <%=m.getMemberAge() %> /><br>
	Addr : <input type = "text" name = "userAddr" value = <%=m.getMemberAddr() %> /><br>
	<input type = "submit" value = "정보수정"/>
	
	</form>
	<button onclick = "back();">돌아가기</button>
	
	
	</center>
<% 	}else{
%>
		로그인후에 이용해주세요<br>
		<a href="/web1/views/member/memberIndex.html">로그인 페이지로 이동</a>
<%} %>




</body>
</html>