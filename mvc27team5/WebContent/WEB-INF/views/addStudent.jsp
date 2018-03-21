<!-- [김재희] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="studentHeader.jsp"></jsp:include>
</head>
</head>
<body>
<jsp:include page="studentBody.jsp"></jsp:include>
	<div class="col-md-6 col-md-offset-3">
			<h1>Student 추가</h1>
			<form id="studentForm" action="<%=request.getContextPath()%>/addStudent.jjdev" method="post">
				<div class="form-group student-id">
					<label>이름</label>
					<div class="input-group">
						<span class="input-group-addon"></span>
						<input type="text" class="form-control" id="studentId" name="studentId" placeholder="이름을 입력해 주세요">
					</div>
					<p></p>
				</div>
				<div class="form-group student-pw">
					<label>비밀번호</label>
					<div class="input-group">
						<span class="input-group-addon"></span>
						<input type="password" class="form-control" id="studentPw" name="studentPw" placeholder="비밀번호">
					</div>
					<p>비밀번호를 4자 이상 입력 해 주세요</p>
				</div>
				<div class="form-group student-pw-check">
					<label>비밀번호 확인</label>
					<div class="input-group">
						<span class="input-group-addon"></span>
						<input type="password" class="form-control" id="studentPwCheck" name="studentPwCheck" placeholder="비밀번호 확인">
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
					<button type="button" id="studentBtn" class="btn btn-info">회원가입</button>
					<button type="button" id="calcelBtn" class="btn btn-warning">가입취소</button>
				</div>
			</form>
		</div>
  </body>
  </html>