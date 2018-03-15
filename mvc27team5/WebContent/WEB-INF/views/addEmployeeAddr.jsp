<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Employee 주소추가</h1>
	<form id="employeeAddrForm" method="post" action="<%= request.getContextPath() %>/addEmployeeAddr.jjdev"> <!-- 액션 : 폼을 받을 주소 -->
		<input type = "hidden" name="employeeNo" value="<%=request.getParameter("employeeNo")%>">
		주소 : <input type = "text" name="employeeAddr"><br>
		<input type="reset" value="다시입력">	<button type="submit" id="addbutton">추가</button>
	</form>
</body>
</html>