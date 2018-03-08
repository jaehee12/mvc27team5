<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addTeacher.jsp</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#addbutton").click(function(){				
				console.log("$('#teacherID').val() : " + jQuery.type($("#teacherID").val()));
				console.log("$('#teacherPW').val() : " + jQuery.type($("#teacherPW").val()));
				console.log("$('#teacherPW_check').val() : " + jQuery.type($("#teacherPW_check").val()));

				// 4자 미만 아이디 입력 막기
				if($("#teacherID").val().length < 4){					
					alert('아이디를 4자 이상 입력하세요');
					return ;
				}else if($("#teacherPW").val().length < 4){
					alert('비밀번호를 4자 이상 입력하세요.');					
					return ;						
				}else if($("#teacherPW_check").val().length < 4){	
					alert('비밀번호확인을 4자 이상입력하세요.');				
					return ;
				}else{
					if($("#teacherID").val() != $("#teacherPW_check").val()){
						alert('비밀번호와 비밀번호 확인이 다릅니다.');							
						return ;
					}else{
						$("#helper").text("");
						$("#addTeacher").submit();
					}
				}
			});
		});
	</script>
</head>
<body>
	<h1>addTeacher</h1>
	<form if="addTeacher" method="post" action="<%= request.getContextPath() %>/addTeacher.jjdev">
		teacher_id : 	<input type = "text" id="teacherID" name="teacherID">
		teacher_pw : 	<input type = "password" id="teacherPW" name="teacherPW">
		teacher_pw확인 : 	<input type = "password" id="teacherPW_check" name="teacherPW_check">
		<button type="button" id="addbutton">추가</button>		
	</form>
</body>


</html>