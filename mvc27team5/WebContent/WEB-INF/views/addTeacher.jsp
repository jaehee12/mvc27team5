<!-- [유국화] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addTeacher.jsp</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"	crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<script>
		$(document).ready(function() {
			
			$("#signYes").click(function() {
				if ($("#teacherId").val().length < 4) {
					alert('아이디를 4자 이상 입력하세요');
					return;
				} else if ($("#teacherPw").val().length < 4) {
					alert('비밀번호를 4자 이상 입력하세요.');
					return;
				} else if ($("#teacherPwChk").val().length < 4) {
					alert('비밀번호확인을 4자 이상입력하세요.');
					return;
				} else if ($("#teacherPw").val() != $("#teacherPwChk").val()) {
					alert('비밀번호와 비밀번호 확인이 다릅니다.');
					return;
				} else {
					$("#addTeacher").submit();
				}
			});
		});
	</script>
</head>
<body>
	<form id="addTeacher" class="form-horizontal">
		<fieldset>
			<div class="control-group" style="width: 60%;">
				<div class="form-group">
					<label for="teacherId">아이디</label>
					<input type="text" class="form-control" id="teacherId" placeholder="아이디를 입력하세요">
				</div>
				<div class="form-group">
					<label for="teacherPw">비밀번호</label>
					<input type="password" class="form-control" id="teacherPw" placeholder="비밀번호를 입력하세요">
				</div>
				<div class="form-group">
					<label for="teacherPwChk">비밀번호 확인</label>
					<input type="password" class="form-control" id="teacherPwChk" placeholder="비밀번호를 다시 입력하세요">
				</div>
					  
				<div class="checkbox">
					<input type="checkbox"> 비밀번호 표시			
				</div>
				<button type="button" class="btn btn-default" id="signYes">가입</button>
			</div>
		</fieldset>
	</form>
</body>
</html>