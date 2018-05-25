<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "member.model.vo.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Member m = (Member)request.getAttribute("userInfo"); %>
<center>
<h1>회원가입정보</h1>

<form action = "update" method = "post">
Id : <input type = "text" value = "<%=m.getUserId() %>" name = "userId" readonly/><br>
Pw : <input type = "password" value = "<%=m.getUserPwd() %>" name = "userPwd"/><br>
Pw(re) : <input type = "password" value = "<%=m.getUserPwd() %>" name = "userPwd_re"/><br>
Name : <input type = "text" value = "<%=m.getUserName() %>" name = "userName" readonly/><br>
Age : <input type = "text" value = "<%=m.getUserAge() %>" name = "Age"/><br>
Email : <input type = "email" value = "<%=m.getUserEmail() %>" name = "Email"/><br>
Phone : <input type = "text" value = "<%=m.getUserPhone() %>" name = "Phone"/><br>
Addr : <input type = "text" value = "<%=m.getUserAddr() %>" name = "addr"/><br>

Gender : 
<%if(m.getUserGender().equals("M")){ %>
	<input type = "radio" name = "gender" value = "M"  checked = "checked"/>남
	<input type = "radio" name = "gender" value = "F" disabled/>여<br>
<%}else{%>
	<input type = "radio" name = "gender" value = "M" disabled/>남
	<input type = "radio" name = "gender" value = "F" checked = "checked"/>여<br>
<%} %>

취미 : <input type = "text" value = "<%=m.getUserHobby() %>" name = "hobby"/><br>
<input type = "submit" value = "수정하기"/>
<button type = "button" onclick = "back();">취소</button><br>
<a href = "/index.jsp">메인페이지로 이동</a>
</form>
</center>
<script>
function back(){
	location.href="/index.jsp";
}
</script>
</body>
</html>