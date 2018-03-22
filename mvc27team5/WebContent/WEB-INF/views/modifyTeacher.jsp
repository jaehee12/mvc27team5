<!-- [유국화] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<jsp:include page="teacherHeader.jsp"></jsp:include>
</head>
	<jsp:include page="teacherBody.jsp"></jsp:include>

<body>
	
	<div class="col-md-6 col-md-offset-3">
		<h1>Teacher 수정</h1>
		<form id="uTeacherForm" action="${pageContext.request.contextPath}/modifyTeacher.jjdev" method="post">
			
			<input type="hidden" name="teacherNo" value="${teacher.teacherNo}">
			<div class="form-group update-teacher-id">
				<label>아이디</label>
				<div class="input-group">
					<input type="text" class="form-control" id="uTeacherId" name="uTeacherId" value="${teacher.teacherId}" readonly>
				</div>
				<p></p>
			</div>
			<div class="form-group update-teacher-pw">
				<label>비밀번호</label>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="password" class="form-control" id="uTeacherPw" name="uTeacherPw" value="${teacher.teacherPw}">
				</div>
				<p >비밀번호를 4자 이상 입력 해 주세요</p>
			</div>
			<div class="form-group update-teacher-pw-check">
				<label>비밀번호 확인</label>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="password" class="form-control" id="uTeacherPwCheck" name="uTeacherPwCheck" value="${teacher.teacherPw}">
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
				<button type="button" id="updateTeacherBtn" class="btn btn-info">수정하기</button>
				<button type="button" id="calcelBtn" class="btn btn-warning">수정 취소</button>
			</div>
		</form>
	</div>
</body>
</html>