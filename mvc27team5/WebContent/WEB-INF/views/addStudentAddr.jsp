<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addStudentAddr</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
</script>
</head>
<body>
<%
%>
<h1>Student Addr Insert</h1>
	<form action="<%= request.getContextPath() %>/addStudentAddr.jjdev" method="post">
		<table>
			<thead>
				<tr>
					<th></th>
					<th>학생 주소</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>
						<input type="hidden" name="studentNo" id="studentNo" value="<%= request.getParameter("studentNo") %>">
					</td>
					<td>
						<input type="text" name="studentAddr" id="studentAddr">
					</td>
					<td>
						<input type="submit" id="insertStudentAddrForm" value="학생 주소 등록하기">
					</td>
				</tr>
			</tbody>
		</table>
	
	</form>
</body>
</html>