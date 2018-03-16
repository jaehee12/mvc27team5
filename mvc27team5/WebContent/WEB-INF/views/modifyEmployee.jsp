<!-- [백지훈] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="model.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Employee employee = (Employee) request.getAttribute("employee");
	%>

		<form method="post" action="<%= request.getContextPath() %>/modifyEmployee.jjdev">
			<input type = "hidden" id="employeeNo" name="employeeNo" value=<%=employee.getEmployeeNo() %>><br>
		아이디 : <input type = "text" id="employeeId" name="employeeId" value=<%= employee.getEmployeeId() %> readonly><br>
		비밀번호 : <input type = "text" id="employeePw" name="employeePw" value=<%= employee.getEmployeePw() %> ><br>
		<input type = "submit" value="수정완료">	
	</form>
</body>
</html>