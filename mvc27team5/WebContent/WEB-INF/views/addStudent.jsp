<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>addStudent</title>
  <!-- Bootstrap core CSS-->
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Custom fonts for this template-->
  <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
  <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script>
  	$(document).ready(function(){
  		$("#submit").click(function(){
  			if($("#studentId").val() )
  		});
  		
  	});
  </script>
</head>

<body class="bg-dark">
  <div class="container">
    <div class="card card-login mx-auto mt-5">
      <div class="card-header">Insert Student</div>
      <div class="card-body">
      
        <form method="post" action="<%= request.getContextPath() %>/addStudent.jjdev" id="myInsertForm">
          <div>
          	 <span id="helper"></span>
          </div> 
          <div class="form-group">
            <label for="exampleInputEmail1">student ID</label>
            <input class="form-control" id="studentId" type="text" aria-describedby="emailHelp" placeholder="Enter student Id">
          </div>
         
          <div class="form-group">
            <label for="exampleInputPassword1">student Password</label>
            <input class="form-control" id="studentPw" type="password" placeholder="Enter student Password">
          </div>
          
          <div class="form-group">
            <label for="exampleInputPassword1">Password Check</label>
            <input class="form-control" id="studentPwCheck" type="password" placeholder="Enter student Password Check">
          </div>
          <a class="btn btn-primary btn-block" href="index.html" id="submit">Insert</a>
        </form>
        <div class="text-center">
          <a class="d-block small mt-3" href="register.html">Register an Account</a>
          <a class="d-block small" href="forgot-password.html">Forgot Password?</a>
        </div>
      </div>
    </div>
  </div>
  <!-- Bootstrap core JavaScript-->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- Core plugin JavaScript-->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
</body>

</html>
