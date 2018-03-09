<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "model.Guest" %>
<%@ page import = "java.util.ArrayList" %>
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

	<%
	ArrayList<Guest> list = (ArrayList<Guest>) request.getAttribute("list");
	%>
	<div align="center">
		<h1>guestList</h1>
		<table border="1" class="table">
			<thead>
				<tr>
					<th>게스트 순서</th>
					<th>게스트 이름</th>
					<th>게스트 비번</th>
					<th>수정</th>
					<th>삭제</th>
	
				</tr>
			</thead>
			<tbody>
				<%
					for(Guest guest : list){
					%>
				<tr>
					<td><%= guest.getGuestNo() %></td>
					<td><%= guest.getGuestId() %></td>
					<td><%= guest.getGuestPw() %></td>
					<td><a href="#">수정</a></td>
					<td><a href="#">삭제</a></td>
				</tr>
				<%
					}
					%>
			</tbody>
		</table>
	</div>
</body>
</html>