<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "model.StudentAddr" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>addStudentAddrList</title>
</head>
<body>
	<h1>add Student Address List</h1>
		<form>
			<table>
				<thead>
					<tr>
						<th>주소 순서</th>
						<th>학생 순서 </th>
						<th>학생 주소</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<StudentAddr> list = (ArrayList<StudentAddr>)request.getAttribute("list");
						for(StudentAddr studentAddr : list) {
					%>
					<tr>
						<td><%= studentAddr.getStudentAddrNo() %></td>
						<td><%= studentAddr.getStudentNo() %></td>
						<td><%= studentAddr.getAddress() %></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</form>
		<%@include file = "/WEB-INF/views/addStudentAddr.jsp" %>
</body>
</html>

