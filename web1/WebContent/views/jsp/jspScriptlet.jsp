<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int value = Integer.parseInt(request.getParameter("value"));
%>
당신이 입력한 값(표현태그는 변수를 출력할때 사용) : <%=value %><br>
<%if(value==10){%>
	10과 같습니다.
<%}else{ %>
	10과 다릅니다.
<%} %>

</body>
</html>