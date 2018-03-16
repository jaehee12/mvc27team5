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
<body>
	<% 
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		list = (ArrayList<Teacher>)request.getAttribute("list");
	%>
	<h1>Teacher List</h1>
	<table border="1">
		<thead>
			<tr>
				<th>티처 순서</th>
				<th>티처 이름</th>
				<th>티처 비번</th>
				<th>수정</th>
				<th>삭제</th>
				<th>티처 주소 추가</th>				
			</tr>
		</thead>
		<tbody>
			<%
				for(Teacher teacher : list){
			%>
			<tr>
				<td><%= teacher.getTeacherNo() %></td>
				<td><%= teacher.getTeacherId() %></td>
				<td>****</td>
				<td><a href="<%= request.getContextPath() %>/modifyTeacher.jjdev?teacherNo=<%= teacher.getTeacherNo() %>">수정</a></td>
				<td><a href="<%= request.getContextPath() %>/removeTeacher.jjdev?teacherNo=<%= teacher.getTeacherNo() %>">삭제</a></td>
				<td><a href="<%= request.getContextPath() %>/addTeacherAddr.jjdev?teacherNo=<%= teacher.getTeacherNo() %>">주소추가</a></td>
			</tr>	
			<%
				}
			%>	
		</tbody>	
	</table>
</body>
</html>