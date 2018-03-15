<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modifyStudentForm</title>
</head>
<body>
<%
	Student student = (Student)request.getAttribute("student");
%>
	<form action="<%= request.getContextPath() %>/modifyStudent.jjdev" method="post">
		<table>
			<thead>
				<tr>
					<th></th>
					<th>학생 아이디</th>
					<th>학생 비번</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<input type="hidden" name="studentNo" value="<%= student.getStudentNo() %>" readonly>					
					</td>
					<td>
						<input type="text" name="studentId" value="<%= student.getStudentId() %>" readonly>
					</td>
					<td>
						<input type="password" name="studentPw" value="<%= student.getStudentPw() %>">
					</td>
					<td>
						<input type="submit" value="학생정보수정">
					</td>
				</tr>
			</tbody>
		</table>
	</form>	
</body>
</html>