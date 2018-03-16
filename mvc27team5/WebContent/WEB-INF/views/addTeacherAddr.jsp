<!-- [유국화] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.TeacherAddr" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
	<title>Insert title here</title>
</head>
<body>
	<%
		TeacherAddr teacheraddr = new TeacherAddr();
		teacheraddr = (TeacherAddr)request.getAttribute("teacheraddr");
		int teacherNo = teacheraddr.getTeacherNo();
	%>
	<%@ include file = "/WEB-INF/views/addTeacherAddrList.jsp" %>
	<h2>주소 추가</h2>
	<form action="<%= request.getContextPath() %>/addTeacherAddr.jjdev" method="post">
				<input type="hidden" name="teacherNo" value="<%= teacheraddr.getTeacherNo() %>">
		주소 :	<input type="text" name="teacherAddr" placeholder="주소를 입력해주세요.">
				<input type = "submit" value="추가완료">
	</form>
</body>
</html>