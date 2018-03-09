<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>free login form -bootstrap</title>
    <!-- Bootstrap -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- font awesome -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    <!-- Custom Style -->
    <link href="css/style.css" rel="stylesheet">
 	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function (){
			$("#insertStudent").click(function(){
				if($("#studentId").val().length < 4) {
					$("#helper").text("*아이디를 4자이상 입력해주세요")
					return;
				}else if($("#studentPw").val().length < 4){
					$("#helper").text("*비밀번호를 4자이상 입력해주세요")
					return;
				}else if($("#studentPwCheck").val() !== $("#studentPw").val()){
					$("#helper").text("*비밀번호가 정확한지 확인해주세요")
					return;
				}else{
					$("#studentInsertForm").submit();
				}
			})
		});
	</script>
</head>
  <body>
    <div class="container">
      <div class="row">
        <div class="page-header">
          <h2>학생 회원가입</h2>
        </div>
        <div class="col-md-3">
          <div class="login-box well">
        <form accept-charset="UTF-8" id="studentInsertForm" method="post" action="<%= request.getContextPath()%>/addStudent.jjdev">
            <legend>Student Insert</legend>
            <div class="form-group">
                <label for="username-email">Student ID</label>
                <input name="studentId" value='' id="studentId" placeholder="Enter ID" type="text" class="form-control" />
            </div>
            <div class="form-group">
                <label for="password">비밀번호</label>
                <input name="studentPw" id="studentPw" value='' placeholder="Enter Password" type="password" class="form-control" />
            </div>
            <div class="form-group">
                <label for="password">비밀번호 확인</label>
                <input name="studentPw" id="studentPwCheck" value='' placeholder="Password Check" type="password" class="form-control" />
            </div>  
            <hr />
            <div class="form-group">
                <input type="button" id="insertStudent" class="btn btn-default btn-login-submit btn-block m-t-md" value="학생으로 회원가입" />
            </div>
            <div class="form-group">
                <a href="" class="btn btn-default btn-block m-t-md">학생으로 로그인</a>
            </div>
        </form>
        <div><span id="helper"></span></div>
          </div>
        </div>
      </div>
    </div>
 
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <!-- Include all compiled plugins (below), or include individual files as needed -->
  <script src="js/bootstrap.min.js"></script>
  </body>
  </html>