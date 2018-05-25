<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.service.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
	function check(){
		var checkId = document.getElementById('checkId').value; //입력된아이디를 checkID에 저장
		if(checkId==""){
			alert("아이디를 입력하세요");
			return;
		}
		location.href="idCheck.jsp?checkId="+checkId; //idCheck.jsp의 query문에 아이디값을 넣어서 다시 열기
	}
	window.onload = function(){
		<%
			String checkId = request.getParameter("checkId");
			if(checkId != null){ // checkId값이 null이 아닌 경우만 비즈니스 로직 처리
				boolean result = new MemberService().idCheck(checkId);
				
				if(result == true) // 해당 ID는 사용 중
				{
		%>
					document.getElementById('message').innerHTML="사용중인 ID 입니다.";
		<%
				}else{ // 해당 ID가 미사용일 때 (사용 가능할 때)
		%>
					var useYesNo = window.confirm("사용가능한 ID입니다. 사용하시겠습니까?");
					if(useYesNo == true){
						//자신(팝업)을 호출한 부모의 userID에 ID값을 넣어줌
						opener.document.getElementById('userId').value='<%=checkId%>';
						
						window.close(); // 해당 팝업창 종료
						
					}else{
						document.getElementById('checkId').value = "";
					}
		<%
				}
			}
		%>
	}
</script>

중복확인할 ID 입력 : <input type = "text" id="checkId"/>
<button onclick="check();">중복체크</button><br>
<span id = "message" style='color:red'></span>

</body>
</html>