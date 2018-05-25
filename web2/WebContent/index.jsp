<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import= "member.model.vo.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Member m = (Member)session.getAttribute("user"); %>
<%if(m == null){ %>
<fieldset style = "width : 300px; height:100px;">
	
	<legend>로그인</legend>
	<form action = "login" method = "post" style = "display:inline;">
	ID : <input type = "text" placeholder = "ID를 입력하세요" name = "userId"/><br>
	PW : <input type = "password" placeholder = "PW를 입력하세요" name = "userPwd"/><br>
	<input type = "submit" value = "로그인"/>
	</form>
	<a href="/views/member/joinus.html">회원가입</a> <!-- 톰캣설정에서 web2를 '/'로 설정했기 때문에 '/'가 최상위가 됨 -->
	<a href="">ID 찾기</a>
	<a href="">PW 찾기</a>

</fieldset>
	<%}else{ %>
	<%if(m.getUserId().equals("admin")){ %>
	[<%=m.getUserName() %>]님 환영합니다<br>
	
	<a href = "">마이페이지</a><br>
	<a href = "/logout">로그아웃</a><br>
	<a href = "">회원탈퇴</a><br>
	<a href = "/searchAll">전체회원조회</a><br>
	<%}else{ %>

	[<%=m.getUserName() %>]님 환영합니다<br>
	<label onclick="myInfo();" id="infoBtn">마이페이지</label>
	<form action = "/mypage" method = "post" style = "display:none;" id = "myInfo">
	<label style = "color:red:">비밀번호 입력:</label>
	<input type = "password" name = "userPwd"/><input type = "submit" value="확인"/>
	</form><br>
	<a href = "/mypage">마이페이지</a><br>
	<a href = "/logout">로그아웃</a><br>
	<a href = "">회원탈퇴</a><br>
	
	<%}} %>
</body>
<style>
	#infoBtn{
	cursor:poiinter;
	text-decoration: underline;
	color:blue;
	}
</style>
<script>
function myInfo(){
	document.getElementById("myInfo").style="display:inline";
}
</script>
</html>