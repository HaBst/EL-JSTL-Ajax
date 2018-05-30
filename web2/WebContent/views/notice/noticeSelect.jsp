<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.*" import="member.model.vo.*"
	import = "java.util.*"
%>


<% Notice n = (Notice)request.getAttribute("notice"); 
ArrayList<NoticeComment> list =(ArrayList<NoticeComment>)request.getAttribute("comment");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 내용</title>
</head>
<body>
글번호 : <%=n.getNoticeNo()%><br>
글쓴이 : <%=n.getUserId()%><br>
작성일 : <%=n.getRegDate()%><br>
글제목 : <%=n.getSubject()%><br>
<textarea rows="20" cols="100" readonly style="resize:none;"><%=n.getContents()%></textarea>
<br>
<script>
	function back(){
		location.href="/notice";		
	}
</script>
<button onclick="back()">목록</button>

<%if(session.getAttribute("user")!=null&&
		((Member)session.getAttribute("user")).getUserId().equals("admin")){ %>
<form action="noticeUpdateReady" style="display:inline;">
<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo()%>" />
<input type="submit" value="수정"/>
</form>
<form action="noticeDelete" method="post" style="display:inline;">
<input type="hidden" name="noticeNo" value="<%=n.getNoticeNo()%>"/>
<input type="submit" value="삭제"/>
</form>
<form action="/views/notice/noticeWriteReady.jsp" style="display:inline;">
<input type="submit" value="글쓰기"/>
</form>
<%} %>

<h1>댓글</h1>
<form action="/noticeCommentUpload" method="post">
<%if(((Member)session.getAttribute("user"))==null){ %>
<textarea rows="5" cols="100" name="comment" readonly placeholder="로그인 한 사용자만 댓글 작성이 가능합니다." style="resize:none;" onclick="login();"></textarea><br>
<%}else{ %>
<textarea rows="5" cols="100" name="comment" placeholder="댓글을 작성하세요" style="resize:none;"></textarea><br>
<input type="hidden" value="<%=n.getNoticeNo()%>" name="noticeNo"/>
<input type="submit" value="댓글작성"/>
<%} %>

</form>
<script>
	function login(){
		alert("로그인을 먼저 진행해주세요");
		window.open("/views/member/login_popup.html","_blank","width=400px,height=200px");
	}
</script>


<%for(NoticeComment nc : list){%>

	작성자 : <%=nc.getUserId()%> / 작성일 : <%=nc.getRegDate()%> / 
	<label id=<%=nc.getCommentNo()%>><%=nc.getContent()%></label>
	<%if(((Member)session.getAttribute("user"))!=null &&
			((Member)session.getAttribute("user")).getUserId().equals(nc.getUserId())
			){
		%>
	<form action="/commentUpdate" method="get" style="display:inline;">
	<input type="hidden" name="comment" id="<%=nc.getCommentNo()%>_input" value="<%=nc.getContent()%>"/>
	<input type="hidden" name="commentNo" value="<%=nc.getCommentNo()%>"/>
	<input type = "hidden" name = "noticeNo" value = "<%=nc.getNoticeNo() %>"/>
	<button type="button" id="<%=nc.getCommentNo()%>_btn" onclick="modify(<%=nc.getCommentNo()%>);">수정</button>
	<input type="hidden" id="<%=nc.getCommentNo()%>_submit" value="수정">
	<button type="button" id="<%=nc.getCommentNo()%>_reBtn" style="display:none;" onclick="cancle(<%=nc.getCommentNo()%>);">취소</button>
	</form>
	<form action = "/commentDelete"style = "display:inline;">
	<input type = "hidden" name = "commentNo" value = "<%=nc.getCommentNo()%>">
	<input type = "hidden" name = "noticeNo" value = "<%=nc.getNoticeNo() %>">
	<input type = "submit" value = "삭제"/>
	</form>
	<%} %>
	<br>
<%} %>
<script>
	function modify(id){
		document.getElementById(id).style="display:none";
		document.getElementById(id+"_input").type="text";
		document.getElementById(id+"_btn").style="display:none";
		document.getElementById(id+"_submit").type="submit";
		document.getElementById(id+"_reBtn").style="display:inline";
	}
	function cancle(id){
		document.getElementById(id).style="display:inline";
		document.getElementById(id+"_input").type="hidden";
		document.getElementById(id+"_btn").style="display:inline";
		document.getElementById(id+"_submit").type="hidden";
		document.getElementById(id+"_reBtn").style="display:none";
	}
</script>
</body>
</html>
