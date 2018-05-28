<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="refresh" content="5 url=/index.jsp"><!-- 5초후에 /index.jsp로 이동 -->
<title>삭제 에러페이지</title>
</head>
<script>
	alert("삭제를 실패하였습니다.\n관리자에게 문의하세요\n5초후 로그인창으로 이동합니다.");
	location.href="/index.jsp";
</script>
<body>

</body>
</html>