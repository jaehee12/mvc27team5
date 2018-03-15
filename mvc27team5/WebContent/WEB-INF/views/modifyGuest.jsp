<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.Guest" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="guestHeader.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="guestBody.jsp"></jsp:include>
	<% Guest guest = (Guest)request.getAttribute("guest"); %>
	<div class="col-md-6 col-md-offset-3">
		<h1>Guest 추가</h1>
		<form id="guestForm" action="<%=request.getContextPath()%>/modifyGuest.jk" method="post">
		<input type="hidden" name="guestNo" value="<%= guest.getGuestNo() %>">
			<div class="form-group guest-id">
				<label>이름</label>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="text" class="form-control" id="guestId" name="guestId" value="<%= guest.getGuestId() %>" readonly>
				</div>
				<p></p>
			</div>
			<div class="form-group guest-pw">
				<label>비밀번호</label>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="password" class="form-control" id="guestPw" name="guestPw" value="<%= guest.getGuestPw() %>">
				</div>
				<p >비밀번호를 4자 이상 입력 해 주세요</p>
			</div>
			<div class="form-group guest-pw-check">
				<label>비밀번호 확인</label>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="password" class="form-control" id="guestPwCheck" name="guestPwCheck" value="<%= guest.getGuestPw() %>">
				</div>
				<p>비밀번호가 일치하지 않습니다</p>
			</div>
			<div class="progress">
				<div class="progress-bar progress-bar-striped active"
					role="progressbar" aria-valuenow="0" aria-valuemin="0"
					aria-valuemax="100" style="width: 0%">
					<span class="sr-only">0% Complete</span>
				</div>
			</div>
			<div class="form-group text-center">
				<button type="button" id="guestBtn" class="btn btn-info">수정하기</button>
				<button type="button" id="calcelBtn" class="btn btn-warning">수정 취소</button>
			</div>
		</form>
	</div>
	
</body>
</html>