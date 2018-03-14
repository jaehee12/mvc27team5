<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<!-- 사이트가 IE에서 올바로 표시되지 않는다면, 가장 최신 웹 표준 지원을 위해 사이트를 업데이터하거나,(권장)
IE를  이전 버전의 브라우저에서 보는 것처럼 내용을 표시하도록 할 수 있습니다. 하지만 기능들이 정상적으로 작동하지 않을수도 있습니다.
화면에 보이는 것만 정상적으로 보일수 있다. -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 어떤 디바이스에서든 해당 디바이스에 맞는 화면크기를 보여주기위하여 사용. -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>addGuest</title>
<!-- 부트스트랩 기본 css-->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
<!-- 로그인 모달부분 css 처리하기~ -->
<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다.) 그런데 나는 자바스크랩트 최신버전으로 새로 받은거임~ -->
<style>
	.addGuestForm{width:300px;}
	.input-group{width:100%;}
	.input-group-addon{top:0 !important;}
</style>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<!-- 로그인 버튼 누르면 submit시키려고~ -->
<script src="<%=request.getContextPath()%>/js/topMenu.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 -->
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
	$(".guest-id span").hide();
	$(".guest-pw span").hide();
	$(".guest-pw-check span").hide();
	$("#guestIdCheckHelp").hide();
	$("p").hide();
	$("#guestBtn").click(function(e) {
		if ($("#guestId").val().length < 4) {
			
		} else if ($("#guestPw").val().length < 4) {
			
		} else if ($("#guestPw").val() != $("#guestPwCheck").val()) {
			
		} else {
			$("#guestForm").submit();
		}
	});
	

	var percentTotal=0;
	var percentId=0;
	var percentPw=0;
	var percentPwCheck=0;
	$("#guestId").blur(function(){
		var guestIdCheck;
		$(".guest-id span").show();
		if($("#guestId").val().length < 4){
			$(".guest-id").removeClass("text-success");
			$(".guest-id").removeClass("has-success");
			$(".guest-id span").removeClass("glyphicon glyphicon-ok");
			$(".guest-id").addClass("text-danger");
			$(".guest-id").addClass("has-error");
			$(".guest-id span").addClass("glyphicon glyphicon-remove-circle");
			$(".guest-id p").val("아이디를 4자 이상 입력 해 주세요");
			$(".guest-id p").show();
			percentId = 0;
		} else if(guestIdCheck == 1 ) {
			$(".guest-id").removeClass("text-success");
			$(".guest-id").removeClass("has-success");
			$(".guest-id span").removeClass("glyphicon glyphicon-ok");
			$(".guest-id").addClass("text-danger");
			$(".guest-id").addClass("has-error");
			$(".guest-id span").addClass("glyphicon glyphicon-remove-circle");
			$(".guest-id p").val("이미 해당 아이디가 존재합니다.");
			$(".guest-id p").show();
			percentId = 0;
		} else {
			$(".guest-id").removeClass("text-danger");
			$(".guest-id").removeClass("has-error");
			$(".guest-id span").removeClass("glyphicon glyphicon-remove-circle");
			$(".guest-id p").hide();
			$(".input-group span").addClass("glyphicon glyphicon-ok");
			$(".guest-id").addClass("text-success");
			$(".guest-id").addClass("has-success");
			percentId = 33;
		}
		percentTotal = percentId+percentPw+percentPwCheck;
		$(".progress div").width(percentTotal+"%");
	});
	
	$("#guestPw").blur(function(){
		$(".guest-pw span").show();
		if($("#guestPw").val().length < 4){
			$(".guest-pw").removeClass("text-success");
			$(".guest-pw").removeClass("has-success");
			$(".guest-pw span").removeClass("glyphicon glyphicon-ok");
			$(".guest-pw").addClass("text-danger");
			$(".guest-pw").addClass("has-error");
			$(".guest-pw span").addClass("glyphicon glyphicon-remove-circle");
			$(".guest-pw p").show();
			percentPw = 0;
		} else {
			$(".guest-pw").removeClass("text-danger");
			$(".guest-pw").removeClass("has-error");
			$(".guest-pw span").removeClass("glyphicon glyphicon-remove-circle");
			$(".guest-pw p").hide();
			$(".input-group span").addClass("glyphicon glyphicon-ok");
			$(".guest-pw").addClass("text-success");
			$(".guest-pw").addClass("has-success");
			percentPw = 33;
		}
		percentTotal = percentId+percentPw+percentPwCheck;
		$(".progress div").width(percentTotal+"%");
	});
	
	$("#guestPwCheck").blur(function(){
		$(".guest-pw-check span").show();
		if(($("#guestPw").val() != $("#guestPwCheck").val()) || ($("#guestPwCheck").val().length < 4)){
			$(".guest-pw-check").removeClass("text-success");
			$(".guest-pw-check").removeClass("has-success");
			$(".guest-pw-check span").removeClass("glyphicon glyphicon-ok");
			$(".guest-pw-check").addClass("text-danger");
			$(".guest-pw-check").addClass("has-error");
			$(".guest-pw-check span").addClass("glyphicon glyphicon-remove-circle");
			$(".guest-pw-check p").show();
			percentPwCheck = 0;
		} else {
			$(".guest-pw-check").removeClass("text-danger");
			$(".guest-pw-check").removeClass("has-error");
			$(".guest-pw-check span").removeClass("glyphicon glyphicon-remove-circle");
			$(".guest-pw-check p").hide();
			$(".input-group span").addClass("glyphicon glyphicon-ok");
			$(".guest-pw-check").addClass("text-success");
			$(".guest-pw-check").addClass("has-success");
			percentPwCheck = 34;
		}
		percentTotal = percentId+percentPw+percentPwCheck;
		$(".progress div").width(percentTotal+"%");
	});
});
</script>
</head>
<body>
	<nav class="navbar  navbar-inverse" style="margin-bottom: 0;">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">Guest</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li><a href="#" data-toggle="tooltip" data-placement="bottom" title="어떤">메뉴1</a></li>
					<li><a href="#" data-toggle="tooltip" data-placement="bottom" title="기능을">메뉴2</a></li>
					<li><a href="#" data-toggle="tooltip" data-placement="bottom" title="넣으면">메뉴3</a></li>
					<li><a href="#" data-toggle="tooltip" data-placement="bottom" title="좋을까?">메뉴4</a></li>
					<li><a href="#" data-toggle="tooltip" data-placement="bottom" title="흠">메뉴5</a></li>
				</ul>
				<form class="navbar-form navbar-left" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디">
					</div>
					<button type="submit" class="btn btn-default">검색</button>
				</form>
				<ul class="nav navbar-nav navbar-right">
					<% if(session.getAttribute("guestId") == null){ %> <li><a href="#" data-toggle="modal" data-target="#login-modal">로그인</a></li>
					<% } else if(!session.getAttribute("guestId").equals("admin")){ %> 
						<li><a href="<%= request.getContextPath() %>/login/logout.jsp">로그아웃</a></li>
					<% } else { %>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">관리<span class="caret"></span></a>
							<ul class="dropdown-menu" role="menu">
								<li><a href="#">기능1</a></li>
								<li><a href="#">기능2</a></li>
								<li class="divider"></li>
								<li><a href="#">Guest 정보 수정</a></li>
							</ul>
						</li>
						<li><a href="#">로그아웃</a></li>				
					<% } %>					
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<div class="col-md-6 col-md-offset-3">
		<h1>Guest 추가</h1>
		<form id="guestForm" action="<%=request.getContextPath()%>/addGuest.jk" method="post">
			<div class="form-group guest-id">
				<label>이름</label>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="text" class="form-control" id="guestId" name="guestId" placeholder="이름을 입력해 주세요">
				</div>
				<p></p>
			</div>
			<div class="form-group guest-pw">
				<label>비밀번호</label>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="password" class="form-control" id="guestPw" name="guestPw" placeholder="비밀번호">
				</div>
				<p >비밀번호를 4자 이상 입력 해 주세요</p>
			</div>
			<div class="form-group guest-pw-check">
				<label>비밀번호 확인</label>
				<div class="input-group">
					<span class="input-group-addon"></span>
					<input type="password" class="form-control" id="guestPwCheck" name="guestPwCheck" placeholder="비밀번호 확인">
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
				<button type="button" id="guestBtn" class="btn btn-info">회원가입</button>
				<button type="button" class="btn btn-warning">가입취소</button>
			</div>
		</form>
	</div>
</body>
</html>