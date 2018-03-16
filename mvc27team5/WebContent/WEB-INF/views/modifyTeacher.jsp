<!-- [유국화] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "model.Teacher" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>
<%
	
	Teacher teacher = (Teacher)request.getAttribute("teacher");
	
%>
<body>
	<form method="post" action="<%= request.getContextPath() %>/modifyTeacher.jjdev">
				<input type = "hidden" id="teacherNo" name="teacherNo">
		아이디 : 	<input type = "text" id="teacherId" name="teacherId" value=<%= teacher.getTeacherId() %> readonly>
		비밀번호 : <input type = "text" id="teacherPw" name="teacherPw" value=<%= teacher.getTeacherPw() %> >
		주소 : 	<input type = "text" id="teacherAddr" name="teacherAddr">
		<input type = "submit" value="수정완료">	
	</form>
</body>
</html>