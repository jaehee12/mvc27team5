<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>Guest</title>

<!-- 부트스트랩 -->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet">

<!-- IE8 에서 HTML5 요소와 미디어 쿼리를 위한 HTML5 shim 와 Respond.js -->
<!-- WARNING: Respond.js 는 당신이 file:// 을 통해 페이지를 볼 때는 동작하지 않습니다. -->
<!--[if lt IE 9]>
   <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
   <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
   <![endif]-->
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
								<li><a href="<%= request.getContextPath() %>/clan/insertClan.jsp">Guest 정보 수정</a></li>
							</ul>
						</li>
						<li><a href="<%= request.getContextPath() %>/login/logout.jsp">로그아웃</a></li>				
					<% } %>					
				</ul>
				<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true"
					style="display: none;">
					<div class="modal-dialog">
						<div class="loginmodal-container">
							<h1>로그인</h1>
							<br>
							<form id="loginForm" action="<%= request.getContextPath() %>/login/loginAction.jsp" method="post">
								<input type="text" id="guestId" name="guestId" placeholder="Id"> 
								<input type="password" id="guestPw" name="guestPw" placeholder="Password">
								<input type="button" id="loginBtn" name="loginBtn" class="login loginmodal-submit" value="로그인">
							</form>
						</div>
					</div>
				</div>


			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel" align="center">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>

		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img src="<%= request.getContextPath() %>/img/main.png">
				<div class="carousel-caption"></div>
			</div>
			<div class="item">
				<img src="<%= request.getContextPath() %>/img/main_black.png">
				<div class="carousel-caption"></div>
			</div>
			...
		</div>

		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>




	<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다.) 그런데 나는 자바스크랩트 최신버전으로 새로 받은거임~ -->
	<script src="<%= request.getContextPath() %>/js/jquery-3.3.1.min.js"></script>
	<!-- 로그인 버튼 누르면 submit시키려고~ -->
	<script src="<%= request.getContextPath() %>/js/topMenu.js"></script>
	<!-- 모든 컴파일된 플러그인을 포함합니다 (아래), 원하지 않는다면 필요한 각각의 파일을 포함하세요 -->
	<script src="<%= request.getContextPath()%>/js/bootstrap.min.js"></script>
</body>
</html>