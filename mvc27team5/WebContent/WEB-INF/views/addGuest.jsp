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
	.addGuestForm{width:300px}
</style>
<script src="<%=request.getContextPath()%>/js/jquery-3.3.1.min.js"></script>
<!-- 로그인 버튼 누르면 submit시키려고~ -->
<script src="<%=request.getContextPath()%>/js/topMenu.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 -->
<script src="<%=request.getContextPath()%>/js/bootstrap.min.js"></script>
<script>
$(document).ready(function(){
	var guestId = $("#guestIdHelper");
	var guestPw = $("#guestPwHelper");
	var guestPwCheck = $("#guestPwCheckHelper");
	guestId.hide();
	guestPw.hide();
	guestPwCheck.hide();
	$("#guestBtn").click(function(e) {
		guestId.hide();
		guestPw.hide();
		guestPwCheck.hide();
		if ($("#guestId").val().length < 4) {
			guestId.css("color","#ff0000");
			guestId.show();
		} else if ($("#guestPw").val().length < 4) {
			guestId.css("color","#ff0000");
			guestPw.show();
		} else if ($("#guestPw").val() != $("#guestPwCheck").val()) {
			guestId.css("color","#ff0000");
			guestPwCheck.show();
		} else {
			$("#guestForm").submit();
		}
	});
});
</script>
<!-- 완전히 내껏으로 이해 한 다음 다른조꺼 참고할것!!!    
<script>
	$(document).ready(function(){
		$("p").hide();
		$("input.teacherId").blur(function(){
			if($("input.teacherId").val().length < 5){
				$("div.teacherId").addClass("has-error");
				$("span.teacherId").addClass("glyphicon glyphicon-alert");
				$("p.teacherId").show();
			}else {
				$("div.teacherId").removeClass("has-error");
				$("span.teacherId").removeClass("glyphicon glyphicon-alert");
				$("div.teacherId").addClass("has-success");
				$("span.teacherId").addClass("glyphicon glyphicon-ok");
				$("p.teacherId").hide();
			}
		});
		$("input.teacherPw").blur(function(){
			if($("input.teacherPw").val().length < 10){
				$("div.teacherPw").addClass("has-error");
				$("span.teacherPw").addClass("glyphicon glyphicon-alert");
				$("p.teacherPw").show();
			}else {
				$("div.teacherPw").removeClass("has-error");
				$("span.teacherPw").removeClass("glyphicon glyphicon-alert");
				$("div.teacherPw").addClass("has-success");
				$("span.teacherPw").addClass("glyphicon glyphicon-ok");
				$("p.teacherPw").hide();
			}
		});
		$("input.teacherPwCheck").blur(function(){
			if($("input.teacherPwCheck").val() === $("input.teacherPw").val()){
				$("div.teacherPwCheck").removeClass("has-error");
				$("span.teacherPwCheck").removeClass("glyphicon glyphicon-alert");
				$("div.teacherPwCheck").addClass("has-success");
				$("span.teacherPwCheck").addClass("glyphicon glyphicon-ok");
			}else {
				$("p.teacherPwCheck").hide();
				$("div.teacherPwCheck").addClass("has-error");
				$("span.teacherPwCheck").addClass("glyphicon glyphicon-alert");
				$("p.teacherPwCheck").show();
			}
		});
	});
</script> -->
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

<%--  	<div class="addGuestForm">
		<h1>addGuest</h1>
		<form action="<%=request.getContextPath()%>/addGuest.jk" method="post" id="guestForm">
			guestId : <input type="text" id="guestId" name="guestId"><span id="guestId"></span><br> 
			guestPw : <input type="password" id="guestPw" name="guestPw"><span id="guestPw"></span><br>
			guestPw 확인 : <input type="password" id="guestPwCheck" name="guestPwCheck"><span id="teacherPwCheck"></span><br>
			<button type="button" id="guestBtn">게스트 추가</button>
		</form>
	</div> --%>

        <div class="col-md-6 col-md-offset-3">
        <h1>Guest 추가</h1>
          <form id="guestForm" action="<%= request.getContextPath() %>/addGuest.jk" method="post">
            <div class="form-group">
              <label>이름</label>
              <input type="text" class="form-control" id="guestId" name="guestId" placeholder="이름을 입력해 주세요">
              <p id="guestIdHelper">아이디를 4자 이상 입력 해 주세요</p>
            </div>
            <div class="form-group">
              <label>비밀번호</label>
              <input type="password" class="form-control" id="guestPw" name="guestPw" placeholder="비밀번호">
              <p id="guestPwHelper">비밀번호를  4자 이상 입력 해 주세요</p>
            </div>
            <div class="form-group">
              <label>비밀번호 확인</label>
              <input type="password" class="form-control" id="guestPwCheck" name="guestPwCheck" placeholder="비밀번호 확인">
              <p id="guestPwCheckHelper">비밀번호가 일치하지 않습니다</p>
            </div>
            <div class="form-group text-center">
              <button type="button" id="guestBtn" class="btn btn-info">회원가입</button>
              <button type="button" class="btn btn-warning">가입취소</button>
            </div>
          </form>
        </div>

<%-- 완전히 이해한다음 다른조 껏 참조할것!
		<h2>addTeacher</h2>
			<div id="form">
			<form method="post" action="<%=request.getContextPath()%>/teacherController.team2" class="form-horizontal">
			<div class="teacherId form-group has-feedback">
				<label for="teacherId" class="col-sm-2 control-label">Teacher_id</label>
				<div class="col-sm-10">
					<input type="text" id="teacherId" name="teacherId" class="teacherId form-control" placeholder="아이디를 입력하세요.">
					<span class="teacherId form-control-feedback"></span>
					<p class="teacherId">아이디는 5글자 이상입니다</p>
				</div>
			</div>
			<div class="teacherPw form-group has-feedback">
				<label for="teacherPw" class="col-sm-2 control-label">Teacher_pw</label>
				<div class="col-sm-10">
					<input type="password" id="teacherPw" name="teacherPw" class="teacherPw form-control" placeholder="비밀번호를 입력하세요.">
					<span class="teacherPw form-control-feedback"></span>
					<p class="teacherPw">비밀번호는 10글자 이상입니다</p>
				</div>
			</div>
				<div class="teacherPwCheck form-group has-feedback">
				<label for="teacherPwCheck" class="col-sm-2 control-label">Teacher_pw확인</label>
				<div class="col-sm-10">
					<input type="password" id="teacherPwCheck" name="teacherPwCheck" class="teacherPwCheck form-control" placeholder="비밀번호를 재입력해주세요.">
					<span class="teacherPwCheck form-control-feedback"></span>
					<p class="teacherPwCheck">비밀번호가 일치하지않습니다</p>
				</div>
			</div>
			<button type="submit" class="btn btn-primary btn-lg btn-block">teacher추가</button>
		</form>
		</div>
 --%>
</body>
</html>