<!-- [진경수] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	$(".guest-addr span").hide();
	
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
	
	$("#guestAddrBtn").click(function(e) {
		if($("#guestAddr").val().length < 3){
			
		} else{
			$("#guestAddrForm").submit();
		}
	});
	
	
	
	
	
	var percentTotal=0;
	var percentId=0;
	var percentPw=0;
	var percentPwCheck=0;
	$("#guestId").blur(function(){
		var guestIdCheck;
		$(".guest-id span").show();
/* 		$.post("guestIdCheck.jk",
			{
				guestId: $("#guestId").val(),
			},
			function(data, status){
				guestIdCheck = data;
			}
		); */
		if($("#guestId").val().length < 4){
			$(".guest-id").removeClass("text-success");
			$(".guest-id").removeClass("has-success");
			$(".guest-id span").removeClass("glyphicon glyphicon-ok");
			$(".guest-id").addClass("text-danger");
			$(".guest-id").addClass("has-error");
			$(".guest-id span").addClass("glyphicon glyphicon-remove-circle");
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
		//이거는 blur마다 있는데, 이부분 함수호출로 변경 해줘야할것같다.
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