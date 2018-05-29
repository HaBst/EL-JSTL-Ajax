<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="notice.model.vo.*" import="java.util.*"
		import = "member.model.vo.*" %>
<% 
	PageData pd = (PageData)request.getAttribute("pageData"); 
	ArrayList<Notice> list = pd.getNoticeList(); // PageData(vo)에 저장된 현재 페이지 리스트
	String pageNavi = pd.getPageNavi();// PageData(vo)에 저장된 navi 리스트
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 목록</title>
</head>
<body>
<center>
<H1> 공지사항 </H1>
<table border="1">
	<tr><th>글번호</th><th>글제목</th><th>작성자</th><th>작성일</th></tr>
<% for(Notice n : list){ %>
	<tr>
		<td><%=n.getNoticeNo()%></td>
		<td><a href="/noticeSelect?noticeNo=<%=n.getNoticeNo()%>"><%=n.getSubject()%></a></td>
		<td><%=n.getUserId()%></td>
		<td><%=n.getRegDate()%></td>
	</tr>
<%} %>
</table>
<label><%=pageNavi %></label><br>
<form action = "searchSub" method = "get" style = "display:inline">
<input type = "text" name = "searchSub">
<input type = "submit" value = "검색">
</form>
<%if(session.getAttribute("user")!=null && ((Member)session.getAttribute("user")).getUserId().equals("admin")) {%>
<form action = "/views/notice/noticeWriteReady.jsp" method = "post" style = "display:inline">
<input type = "submit" value = "글 쓰기">
</form>
<%} %>

</center>
</body>
</html>