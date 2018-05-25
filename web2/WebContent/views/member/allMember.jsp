<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ page import = "member.model.vo.*" import = "java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script>
function back(){
	location.href="/index.jsp";
}
</script>


<body>
<%ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("userList"); %>
<H1>관리자 : 회원 관리 페이지</H1>
<table border = "1px">

<tr align = "center" font size = "5"><th>ID</th><th>이름</th><th>나이</th><th>이메일</th>
<th>휴대폰</th><th>주소</th><th>성별</th><th>취미</th><th>가입날짜</th><th>활성여부</th>

<%for(Member m : list){ %>
<tr>
<td><%=m.getUserId() %></td>
<td><%=m.getUserName() %></td>
<td><%=m.getUserAge() %></td>
<td><%=m.getUserEmail() %></td>
<td><%=m.getUserPhone() %></td>
<td><%=m.getUserAddr() %></td>
<%if(m.getUserGender().equals("M")){ %>
<td>남자</td>
<%}else{ %>
<td>여자</td>
<%} %>
<td><%=m.getUserHobby() %></td>
<td><%=m.getEnrolldate() %></td>
<td>
<form action = "memberActivation" method = "post">
<input type = "hidden" name = "userId" value = "<%=m.getUserId() %>">
<input type = "hidden" name = "memberActivation" value = "<%=m.getActivation() %>">
<input type = "submit" value = "<%=m.getActivation() %>" style ="width : 100%">
</form>
</td>
</tr>
<%} %>
</table>
<br>
<button onclick = "back();">뒤로</button>

</body>
</html>