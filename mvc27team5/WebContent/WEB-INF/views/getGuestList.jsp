<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- prefix 는 uri부분을 치환해줌. 그래서 중복되는 것 일때는 <c:img> 이런식으로 쓰면됨. --%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="guestHeader.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="guestBody.jsp"></jsp:include>
	<input id = "noDap" type="hidden" value="<%= request.getAttribute("noDap") %>">
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
				<c:forEach var = "guest" items = "${list}">
					<tr>
						<td>${guest.guestNo}</td>
						<td>${guest.guestId}</td>
						<td>****</td>
						<td><a href="${pageContext.request.contextPath}/modifyGuest.jk?guestNo=${guest.guestNo}">수정</a></td>
						<td><a href="${pageContext.request.contextPath}/removeGuestAddr.jk?guestNo=${guest.guestNo}">삭제</a></td>
						<td><a href="${pageContext.request.contextPath}/getGuestAddrList.jk?guestNo=${guest.guestNo}">주소추가</a></td>
					</tr>
				
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>