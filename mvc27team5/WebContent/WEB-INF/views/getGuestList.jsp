<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.Guest" %>
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="guestHeader.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="guestBody.jsp"></jsp:include>
	<%
	ArrayList<Guest> list = (ArrayList<Guest>) request.getAttribute("list");
	%>
	<div align="center">
		<h1>guestList</h1>
		<table border="1" class="table">
			<thead>
				<tr>
					<th>게스트 순서</th>
					<th>게스트 이름</th>
					<th>게스트 비번</th>
					<th>수정</th>
					<th>삭제</th>
					<th>ADD GUEST_ADDR</th>
				</tr>
			</thead>
			<tbody>
				<%
				for(Guest guest : list){
				%>
					<tr>
						<td><%= guest.getGuestNo() %></td>
						<td><%= guest.getGuestId() %></td>
						<td>****</td>
						<td><a href="<%= request.getContextPath() %>/modifyGuest.jk?guestNo=<%= guest.getGuestNo() %>">수정</a></td>
						<td><a href="<%= request.getContextPath() %>/removeGuest.jk?guestNo=<%= guest.getGuestNo() %>">삭제</a></td>
						<td><a href="<%= request.getContextPath() %>/addGuestAddr.jk?guestNo=<%= guest.getGuestNo() %>">주소추가</a></td>
					</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>