<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "file.model.vo.*" import  = "java.util.*"%>
<%ArrayList<DataFile2>list = (ArrayList<DataFile2>)request.getAttribute("fileList"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>다운로드 페이지</title>
</head>
<body>
<h1>전체 파일 목록</h1>
<br><br>
<table border = "1">
<tr><th>파일이름</th><th>파일사이즈</th><th>업로더</th><th>업로드 시간</th><th>다운로드</th><th>삭제</th></tr>
<%for(DataFile2 df2 : list) {%>
<tr>
	<td><%=df2.getBeforeFileName() %></td>
	<td><%=df2.getFileSize() %></td>
	<td><%=df2.getFileUser() %></td>
	<td><%=df2.getUploadTime() %></td>
	<td><form action = "/fileDown2" method = "post">
	<input type = "hidden" name = "afterName" value = "<%=df2.getAfterFileName() %>" >
	<input type = "hidden" name = "uploadTime" value = "<%=df2.getUploadTime() %>" >
	<input type = "submit" value = "다운로드"></form></td>
	<td><form action = "/fileRemove" method = "post">
	
	<input type = "submit" value = "파일삭제"></form></td>
</tr>
<%} %>
</table>


<a href = "/index.jsp">메인페이지로 이동</a>
</body>
</html>