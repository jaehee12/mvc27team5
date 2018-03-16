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
			/* $("#checkbox").on("change", function() {
				if ($(this).is(":checked")){
					$("#teacherPw").type("text").change();
				}
			} */
			
		});
	</script>
</head>
<body>
	<form id="addTeacher" action="<%= request.getContextPath() %>/addTeacher.jjdev" method="post">
		
		<label for="teacherId">아이디</label>
		<input type="text" id="teacherId" name="teacherId" placeholder="아이디를 입력하세요">	
		
		<label for="teacherPw">비밀번호</label>
		<input type="password" id="teacherPw" name="teacherPw" placeholder="비밀번호를 입력하세요">
	
		<label for="teacherPwChk">비밀번호 확인</label>
		<input type="password" id="teacherPwChk" name="teacherPwChk" placeholder="비밀번호를 다시 입력하세요">
	  
		<input type="checkbox" id="checkbox"> 비밀번호 표시

		<button type="button" id="signYes">가입</button>
		<button type="button" id="signCancel">취소</button>
	</form>
</body>
</html>