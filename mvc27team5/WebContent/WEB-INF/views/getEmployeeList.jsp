<!-- [백지훈] -->
<%@page import="java.util.Set"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="model.Employee" %>
<%@page import="java.util.ArrayList" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<title>getEmployeeList.jsp</title>
</head>
<body>
<div class="col-sm-3"></div>
<div class="col-sm-6">

		<%
		ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("list");
		
		%>
		
		<h1>EmployeeList</h1>
		<table border="1">
			<thead>
				<tr>
					<th>직원 순서</th>
					<th>직원 아이디</th>
					<th>직원 비번</th>
					<th>수정</th>
					<th>삭제</th>
					<th>주소</th>
					
				</tr>
			</thead>
			<tbody>
				<%
				for(Employee employee : list){
				%>
					<tr>
						<td><%= employee.getEmployeeNo() %></td>
						<td><%= employee.getEmployeeId() %></td>
						<td><%= employee.getEmployeePw() %></td>
						<td><a href="<%= request.getContextPath() %>/modifyEmployee.jjdev?employeeNo=<%= employee.getEmployeeNo() %>">수정</a></td>
						<td><a href="<%= request.getContextPath() %>/removeEmployee.jjdev?employeeNo=<%= employee.getEmployeeNo() %>">삭제</a></td>
						<td><a href="<%= request.getContextPath() %>/addEmployeeAddr.jjdev?employeeNo=<%= employee.getEmployeeNo() %>">주소추가</a></td>
					</tr>
				<%
				}
				%>
			</tbody>
		</table>
</div>
<div class="col-sm-3"></div>
</body>
</html>