<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addTeacher.jsp</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#addbutton").click(function(){				
				if($("#employeeID").val().length < 4){					
					alert('아이디를 4자 이상 입력하세요');
					return ;
				}else if($("#employeePW").val().length < 4){
					alert('비밀번호를 4자 이상 입력하세요.');					
					return ;						
				}else if($("#employeePW_check").val().length < 4){	
					alert('비밀번호확인을 4자 이상입력하세요.');				
					return ;
				}else if($("#employeePW").val() != $("#employeePW_check").val()){
						alert('입력하신 두 비밀번호가 다릅니다.');							
					return ;
				}else{		
					$("#addEmployee").submit();			
				}
			});
		});
	</script>
</head>
<body>
	<h1>addEmployee</h1>
	<form id="addEmployee" method="post" action="<%= request.getContextPath() %>/addEmployee.jjdev"> <!-- 액션 : 폼을 받을 주소 -->
		아이디 : <input type = "text" id="employeeID" name="employeeID"><br>
		비밀번호 : 	<input type = "password" id="employeePW" name="employeePW"><br>
		비밀번호 확인 : 	<input type = "password" id="employeePW_check" name="employeePW_check"><br>
		<input type="reset" value="다시입력">	<button type="button" id="addbutton">등록</button>
	</form>
</body>
</html>

