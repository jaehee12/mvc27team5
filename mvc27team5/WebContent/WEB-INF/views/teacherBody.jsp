<!-- [유국화] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
			<a class="navbar-brand" href="#">Teacher</a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li><a href="#" data-toggle="tooltip" data-placement="bottom"
					title="어떤">메뉴1</a></li>
				<li><a href="#" data-toggle="tooltip" data-placement="bottom"
					title="기능을">메뉴2</a></li>
				<li><a href="#" data-toggle="tooltip" data-placement="bottom"
					title="넣으면">메뉴3</a></li>
				<li><a href="#" data-toggle="tooltip" data-placement="bottom"
					title="좋을까?">메뉴4</a></li>
			</ul>
			<form class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="아이디">
				</div>
				<button type="submit" class="btn btn-default">검색</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<% if(session.getAttribute("teacherId") == null){ %>
					<li><a href="<%= request.getContextPath() %>/addTeacher.jjdev">회원가입</a></li>
					<li><a href="#" data-toggle="modal" data-target="#login-modal">로그인</a></li>
				<% } else if(!session.getAttribute("teacherId").equals("admin")){ %>
					<li><a href="<%= request.getContextPath() %>/login/logout.jsp">로그아웃</a></li>
				<% } else { %>
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown" role="button" aria-expanded="false">관리<span
							class="caret"></span></a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="#">기능1</a></li>
							<li><a href="#">기능2</a></li>
							<li class="divider"></li>
							<li><a href="#">Teacher 정보 수정</a></li>
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