<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="a" value="100"/>
값출력 : ${pageScope.a}<br><br>

<%int value = 999; %>
<c:set var="b" value="<%=value %>"/>
값출력 : ${pageScope.b}<br><br>

<c:set var="c" value = "100"/>
<c:set var="d" value = "200"/>

${c} + ${d} = ${c+d}<br><br>

<c:set var = "num" value = "100"/><!-- page 영역에 저장 -->
<c:set var = "num" value = "200" scope = "request"/><!-- request 영역에 저장 -->
<c:set var = "num" value = "300" scope = "session"/><!-- session 영역에 저장 -->

값1 : ${pageScope.num}<br>
값2 : ${requestScope.num}<br>
값3 : ${sessionScope.num}<br><br>

<c:out value="${num}"/><br>
<c:out value="999"/><br>
<c:out value = "${data}" default = "없음"/><br><br>

<c:out value = "<br>태그는 줄행입니다." escapeXml = "true"/>
<c:out value = "<br>태그는 줄행입니다." escapeXml = "false"/><br>
<br><br>
<%
	String desc1 = "br태그는 줄개행을 진행함<br>";
	String desc2 = "label태그는 글씨를 표현하고 감싸는 태그 <br>";
%>
<c:out value = "<%=desc1 %>" escapeXml="false"/><br>
<c:out value = "<%=desc2 %>"/><br>
<br>

<c:remove var = "num" scope = "request"/>
값1 : ${pageScope.num}<br>
값2 : ${requestScope.num}<br>
값3 : ${sessionScope.num}<br><br>

<c:remove var = "num"/>
값1 : ${pageScope.num}<br>
값2 : ${requestScope.num}<br>
값3 : ${sessionScope.num}<br><br>


<c:set var = "num1" value = "100" />
<c:set var = "num2" value = "200" />

<c:if test="${num1<num2}" var = "result">
	num1이 더 작습니다.
</c:if>

결과 : ${result}<br><br>


<c:set var="choice" value="1"/>


<c:choose>
	<c:when test="${choice==1}">
	1을 선택하였습니다.<br>
	</c:when>
	
	<c:when test="${choice==2}">
	2를 선택하였습니다.<br>
	</c:when>
	<c:otherwise>
	그외를 선택하였습니다.<br>
	</c:otherwise>
</c:choose>
<br>


<c:forEach begin="1" end="10" var="i">
	${i}
</c:forEach>
<br>










</body>
</html>