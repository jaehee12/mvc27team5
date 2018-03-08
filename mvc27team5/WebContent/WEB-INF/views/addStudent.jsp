<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
	<meta http-equiv="Context-Type" content="text/html; charset=UTF-8">
	<title>addStudent</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(documnet).ready(function (){
			$("#insertStudent").click(function (){
				if($("#studentId").val().length < 4) {
					$("#helper").text("아이디를 4자이상 입력해주세요")
					return;
				}else if($("#studentPw").val().length < 4){
					$("#helper").text("비밀번호를 4자이상 입력해주세요")
					
				}
				
			});
		});
	</script>
</head>
<body>
	<h1>addStudent</h1>
	<form method="post" action="<%= request.getContextPath() %>/addStudent.jjdev" id="myInsertForm">
	student_Id :
	<input type="text" name="studentId" id="studentId" class="">
	student_pw :
	<input type="password" name="studentPw" id="studentPw" class="">
	student_pw :
	<input type="password" name="studentPwCheck" id="studentPwCheck" class="">
	<button type="button" id="insertStudent">학생 입력</button>
	</form>
	<div><span id="helper"></span></div>
</body>
</html>

