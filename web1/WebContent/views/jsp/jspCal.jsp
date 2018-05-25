<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%int firstNum = Integer.parseInt(request.getParameter("firstNum")); %>
<%int secondNum = Integer.parseInt(request.getParameter("secondNum")); %>

<%String val = request.getParameter("oper");%>

<%
switch(val){ 
case "+" : out.print(firstNum+"+"+secondNum+"="+(firstNum+secondNum)); break;
case "-" : out.print(firstNum+"-"+secondNum+"="+(firstNum-secondNum)); break;
case "*" : out.print(firstNum+"*"+secondNum+"="+(firstNum*secondNum)); break;
case "/" : out.print(firstNum+"/"+secondNum+"="+(firstNum/secondNum)); break;
}
%>


</body>
</html>