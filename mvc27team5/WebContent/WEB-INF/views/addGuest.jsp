<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>addGuest</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script>
		$(document).ready(function() {
			// 폼 유효성 검사
			// guestId 4이상, guestPw 4자이상, guestPwCheck확인
			//폼 submit
		});
	</script>
</head>
<body>
	<h1>addGuest</h1>
	<form method="post" action="<%= request.getContextPath() %>/addGuest.jjdev">
		guest_id : 
		<input type="text" id="guestId" name="guestId" class="">
		guest_pw :
		<input type="password" id="guestPw" name="guestPw" class="">
		guest_pw확인 :
		<input type="password" id="guestPwCheck" name="guestPwCheck" class="">
		<button type="button">게스트 추가</button>
	</form>
		
</body>
</html>