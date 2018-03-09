<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addTeacher.jsp</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>	
		$(document).ready(function(){
			$("#SignUpModal").modal({backdrop: 'static', keyboard: false});
			$("#signYes").click(function(){				
				if($("#teacherId").val().length < 4){					
					alert('아이디를 4자 이상 입력하세요');
					return ;
				}else if($("#pwd").val().length < 4){
					alert('비밀번호를 4자 이상 입력하세요.');					
					return ;						
				}else if($("#pwd2").val().length < 4){	
					alert('비밀번호확인을 4자 이상입력하세요.');				
					return ;
				}else if($("#pwd").val() != $("#pwd2").val()){
					alert('비밀번호와 비밀번호 확인이 다릅니다.');							
					return ;
				}else{		
					$("#addTeacher").submit();			
				}
			});
		});
	</script>
</head>
<body>
	<div class="modal fade" id="SignUpModal" role="dialog"  tabindex="-1" aria-labelledby="modal-login-label" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header" style="padding: 30px 30px; width: 100%; text-align:center;">					
					<h4><span class="glyphicon glyphicon-user"></span> ADD Teacher</h4>
				</div>
				
				<form class="form-horizontal" method="POST" id="addTeacher" name="addTeacher" action="<%= request.getContextPath() %>/addTeacher.jjdev">
					<div class="modal-body" style="padding: 40px 50px; height: 360px;">
					
						<div class="form-group" style="float: left; width: 73%" id="teacherId" >
							<label for="ID"><span class="glyphicon glyphicon-user"></span> 아이디</label>
							<input type="text" class="id form-control" id="teacherId" name="teacherId" 
							onkeydown="inputIdChk()" placeholder="아이디를 입력하세요">
						</div>						
						<div class="form-group"	style="float: right; margin-top: 31px" id="divIdCheck">
							<button type="button" class="btn btn-primary btn-block" name="IdCheck" id="IdCheck">
							<span class="glyphicon glyphicon-off"></span> 중복확인
							</button>
						</div>							
						<div class="form-group" id="divPwd">
							<label for="psw"><span class="glyphicon glyphicon-eye-open"></span> 1차 비밀번호</label>
							<input type="password" class="pwd form-control" id="pwd" name="pwd"	placeholder="1차 비밀번호를 입력하세요(4자리 이상)">
						</div>
						<div class="form-group" id="divPwd2">
							<label for="psw"><span class="glyphicon glyphicon-eye-open"></span> 2차 비밀번호</label> 
							<input type="password" class="form-control" id="pwd2" name="pwd2" placeholder="2차 비밀번호를 입력하세요(4자리 이상)">
						</div>

					</div>
					<div class="modal-footer">
						<button type="button" id="signYes" name="signYes" class="btn btn-success btn-default pull-left"  value="Send" style="margin: 10px; margin-left: 35px">
							<span class="glyphicon glyphicon-plus"></span>완 료
						</button>
						<button type="button" class="btn btn-danger btn-default pull-left" data-dismiss="modal" value="Input Button" style="margin: 10px">
							<span class="glyphicon glyphicon-remove"></span>취 소
						</button>					
					</div>
				</form>
			</div>
		</div>
	</div>
</body>	
</html>