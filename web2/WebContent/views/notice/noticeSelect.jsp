<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "notice.model.vo.*" 
	import = "member.model.vo.*"%>


<% Notice n = (Notice)request.getAttribute("notice"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 내용</title>
</head>
<body>
글번호 : <%=n.getNoticeNo() %><br>
글쓴이 : <%=n.getUserId() %><br>
작성일 : <%=n.getRegDate() %><br>
글제목 : <%=n.getSubject() %><br>
<textarea rows="20" cols = "100" readonly style = "resize:none;"><%=n.getContents() %></textarea>
<br>
<script>
	function back(){
		location.href="/notice";
	}
</script>

<script>
function deleteCheck() {
    if(window.confirm("정말로 삭제하시겠습니까?")) {
       return true;
    } else {
       return false;
    }
 }
</script>
<button onclick="back();">목록</button>
<%if(session.getAttribute("user")!=null && ((Member)session.getAttribute("user")).getUserId().equals("admin")) { %>
<form action = "/noticeUpdateReady" style="display : inline;">
<input type = "hidden" name = "noticeNo" value = "<%=n.getNoticeNo() %>" />
<input type = "submit" value = "수정"/>
</form>
<form action = "/noticeDelete "style="display : inline;">
<input type = "hidden" name = "noticeNo" value = "<%=n.getNoticeNo() %>" />
<input type = "submit" onclick = "return deleteCheck()"value = "삭제"/>
</form>
<form style="display : inline;">
<input type = "submit" value = "글쓰기"/>
<%} %>
</form>
</body>
</html>