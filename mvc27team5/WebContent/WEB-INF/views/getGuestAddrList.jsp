<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<jsp:include page="guestHeader.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="guestBody.jsp"></jsp:include>
	<div class="col-md-4 col-md-offset-4 text-center">
		<h1>GuestAddr 추가</h1>
		<ul class="list-group-item">
			<div class="input-group">
				<span class="input-group-addon"> <input type="checkbox" id="checkAddr" aria-label="..."></span>
				<li class="list-group-item">주소</li>
			</div>
			<form method="post" class="form-check">
				<c:forEach var = "guestAddr" items = "${list}">
					<div class="input-group">
						<span class="input-group-addon"> <input type="checkbox" name="guestAddrNoList" value="${guestAddr.guestAddrNo}" aria-label="..." class="checkList"></span>
						<input type = "text" style="width:100%" class="list-group-item" name="guestAddr" value="${guestAddr.address}" readonly>
					</div>
				</c:forEach>
			</form>
			<div class="btn-group btn-group-justified" role="group" aria-label="...">
				<div class="btn-group" role="group">
					<button type="button" id="removeAddrBtn" class="btn btn-default">삭제</button>
				</div>
				<div class="btn-group" id="updateAddrBtn" role="group">
					<button type="button" class="btn btn-default">수정</button>
				</div>
			</div>
		</ul>
		<form id="guestAddrForm" action="getGuestAddrList.jk" method="post">
			<div class="input-group">
				<!-- 요건 만약에 주소가 5개이상이면 삽입 못하게!! -->
				<input type="hidden" id="guestAddrCount" value="${guestAddrCount}">
				<input type="hidden" name="guestNo" value="${param.guestNo}">
				<input type="text" class="form-control" id = "guestAddress" name = "guestAddress" placeholder="주소">
				<span class="input-group-btn"><button class="btn btn-default" id="guestAddrBtn" type="button">추가</button></span>
			</div>
		</form>
		<p>주소의 개수가 5개 이상입니다.</p>
		<button type="button" id="calcelAddrBtn" class="btn btn-warning" onclick="location.href='getGuestList.jk' ">홈으로</button>
	</div>
</body>
</html>