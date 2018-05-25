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
	int val1 = Integer.parseInt(request.getParameter("val1"));
	char yun = request.getParameter("yun").charAt(0);
	int val2 = Integer.parseInt(request.getParameter("val2"));
	int sum = 0;
%>

입력한 첫번재 값 : <%=val1 %><br>
입력한 연산자 : <%=yun %><br>
입력한 두번째 값 : <%=val2 %><br>

<%if(yun=='+'){
	sum = val1+val2;
} else if(yun=='-'){
	sum = val1-val2;
} else if(yun=='*'){
	sum = val1*val2;
} else if(yun=='/'){
	sum = val1/val2;
}
%>
결과<br>
<%=val1%><%=yun%><%=val2%>=<%=sum%>
</body>
</html>