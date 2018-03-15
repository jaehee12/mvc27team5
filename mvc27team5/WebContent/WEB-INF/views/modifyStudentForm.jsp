<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modifyStudentForm</title>
</head>
<body>
<%
	int studentNo = Integer.parseInt(request.getParameter("student_no"));
	System.out.println(studentNo + "<-- studentNo");
%>
	<form action="<%= request.getContextPath() %>/modifyStudentPro.jjdev" method="post">
		<table>
			<thead>
				<tr>
					<th>학생 순서</th>
					<th>학생 아이디</th>
					<th>학생 비번</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<input type="text" name="student_no" value="" readonly>					
					</td>
					<td>
						<input type="text" name="student_id" value="" readonly>
					</td>
					<td>
						<input type="text" name="student_pw" valued="">
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