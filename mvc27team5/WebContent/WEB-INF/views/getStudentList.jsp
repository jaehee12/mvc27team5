<!-- [김재희] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "model.Student" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>getStudentList</title>
</head>
<body>
	<h1>Student List</h1>
	<table>
		<thead>
			<th>학생 순서</th>
			<th>학생 이름</th>
			<th>학생 비번</th>
			<th>수정</th><!-- 넘버값을  ?studentNo 로 넘긴다 / StudentDao.updateStudent() -->
			<th>삭제</th><!-- StudentDao.deleteStudent() -->
			<th>학생 주소록 추가</th><!-- StudentAddrDao.insertStudentAddr -->
		</thead>
		<tbody>
			<%
				ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("list");
				for(Student student : list) {
			%>
					<tr>
						<td><%=student.getStudentNo() %></td>
						<td><%=student.getStudentId() %></td>
						<td>****</td><!-- 비밀번호 아예가지고 오지 말기 셀렉트에 넣지 말기 -->
						<td><a href="<%= request.getContextPath()%>/modifyStudent.jjdev?studentNo=<%= student.getStudentNo()%>">수정</a></td>
						<td><a href="<%= request.getContextPath()%>/removeStudent.jjdev?studentNo=<%= student.getStudentNo()%>">삭제</a></td>
						<td><a href="<%= request.getContextPath()%>/addStudentAddr.jjdev?studentNo=<%= student.getStudentNo()%>">주소추가</a></td>
					</tr>
			<%
			
				}
			%>
		</tbody>
	</table>
</body>
</html>