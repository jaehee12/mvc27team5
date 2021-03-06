<!-- [김재희] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>modifyStudent</title>
<jsp:include page="studentHeader.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="studentBody.jsp"></jsp:include>
	${student}
	<%-- <% Student student = (Student)request.getAttribute("student"); %> ${student} --%>
		<div class="col-md-6 col-md-offset-3">
			<h1>Student 추가</h1>
			<form id="uStudentForm" action="${pageContext.request.contextPath}/modifyStudent.jjdev" method="post">
				<input type="hidden" name="studentNo" value="${student.studentNo}">
					<div class="form-group update-student-id">
						<label>이름</label>
						<div class="input-group">
							<input type="text" class="form-control" id="uStudentId" name="uStudentId" value="${student.studentId}" readonly>
						</div>
						<p></p>
					</div>
					<div class="form-group update-student-pw">
						<label>비밀번호</label>
						<div class="input-group">
							<span class="input-group-addon"></span>
							<input type="password" class="form-control" id="uStudentPw" name="uStudentPw" value="${student.studentPw}">
						</div>
						<p >비밀번호를 4자 이상 입력 해 주세요</p>
					</div>
					<div class="form-group update-student-pw-check">
						<label>비밀번호 확인</label>
						<div class="input-group">
							<span class="input-group-addon"></span>
							<input type="password" class="form-control" id="uStudentPwCheck" name="uStudentPwCheck" value="${student.studentPw}">
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
						<button type="button" id="updateStudentBtn" class="btn btn-info">수정하기</button>
						<button type="button" id="calcelBtn" class="btn btn-warning">수정 취소</button>
					</div>
			</form>
		</div>
	
</body>
</html>