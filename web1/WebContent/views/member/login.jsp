<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "member.model.service.*" import = "member.model.vo.*"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  String userId = request.getParameter("userId");
	String userPwd = request.getParameter("userPw");
	Member m = new MemberService().selectMember(userId, userPwd);	
%>

<%
	if(m!=null){
		
		session.setAttribute("user", m);
		//user라는 키값에 객체m을 저장하겠다
%>
<%="<h2>["+m.getMemberName()+"]님 환영합니다.</h2><br>" %>
<a href="myinfo.jsp">마이페이지</a>
<a href="logout.jsp">로그아웃</a>
<form action = "memberDel.jsp" method = "post" style = "display:inline;">
<label id = "pwL" style="display:none;">비밀번호 입력</label>
<input type = "hidden" name = "userPwd" id = "userPwd"/>
<input type = "submit" id = "delBtn" value = "회원탈퇴" onclick = "return check();"/>
</form>

<script>
var swi = false; //탈퇴 입력창 확성화 (true:활성/false:비활성)
	function check(){
		
		if(swi == false){
		var result = window.confirm("정말 탈퇴 하시겠습니까?");
		
			if(result){
			document.getElementById("pwL").style="display:inline";
			document.getElementById("userPwd").type = "password";
			document.getElementById("delBtn").value = "확인";
			swi =true;
			}else{
			alert("탈퇴를 취소하였습니다.");
			}
		}else{
			return true;
		}
		return false;
	}
</script>


<%}else{ %>
	로그인에 실패하였습니다.<br>
	ID 또는 PW를 확인해주세요<br>
	<a href="memberIndex.html">로그인 페이지로 이동</a>
<%} %>

</body>
</html>