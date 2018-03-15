<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="guestHeader.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="guestBody.jsp"></jsp:include>
	<% System.out.println(request.getAttribute("guestNo")); %>
	<div class="col-md-6 col-md-offset-3">
		<h1>GuestAddr 추가</h1>
		<form id="guestAddrForm" action="<%=request.getContextPath()%>/addGuestAddr.jk" method="post">
			<input type="hidden" id="guestNo" name="guestNo" value="<%=request.getAttribute("guestNo")%>">
			<div class="form-group guest-addr">
				<label>주소</label>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="text" class="form-control" id="guestAddr" name="guestAddr">
				</div>
			<br>
			<div class="form-group text-center">
				<button type="button" id="guestAddrBtn" class="btn btn-info">주소 추가</button>
				<button type="button" id="calcelAddrBtn" class="btn btn-warning">취소</button>
			</div>
		</form>
	</div>
	
</body>
</html>