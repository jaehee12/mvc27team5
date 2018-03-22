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
}
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
	
	$(".update-guest-pw span").hide();
	$(".update-guest-pw-check span").hide();
	
	$("#guestIdCheckHelp").hide();
	$("p").hide();
	
	$("#guestBtn").click(function(e) {
		if ($("#guestId").val().length < 4) {
			$("#guestId").focus();
		} else if ($("#guestPw").val().length < 4) {
			$("#guestPw").focus();
		} else if ($("#guestPw").val() != $("#guestPwCheck").val()) {
			$("#guestPwCheck").focus();
		} else {
			$("#guestForm").submit();
		}
	});
	
	$("#updateGuestBtn").click(function(e) {
		if ($("#uGuestPw").val().length < 4) {
			$("#uGuestPw").focus();
		} else if ($("#uGuestPw").val() != $("#uGuestPwCheck").val()) {
			$("#uGuestPwCheck").focus();
		} else {
			$("#uGuestForm").submit();
		}
	});
	
	//아래서 원래 사용하던 코드의 내용이중복되기때문에, 함수형태로 만들어줬다. 이건 나중에 keyup이벤트할때도 쓸것임!
	var guestSuccess = function(guestSuccessForm){
		guestSuccessForm.removeClass("text-danger");
		guestSuccessForm.removeClass("has-error");
		guestSuccessForm.find("span").removeClass("glyphicon glyphicon-remove-circle");
		guestSuccessForm.find("p").hide();
		guestSuccessForm.find("span").addClass("glyphicon glyphicon-ok");
		guestSuccessForm.addClass("text-success");
		guestSuccessForm.addClass("has-success");
	}
	
	var guestFail = function(guestFailForm){
		guestFailForm.removeClass("text-success");
		guestFailForm.removeClass("has-success");
		guestFailForm.find("span").removeClass("glyphicon glyphicon-ok");
		guestFailForm.addClass("text-danger");
		guestFailForm.addClass("has-error");
		guestFailForm.find("span").addClass("glyphicon glyphicon-remove-circle");
		guestFailForm.find("p").show();
	}
	var percentTotal=0;
	var percentId=0;
	var percentPw=0;
	var percentPwCheck=0;
	
	var percentMerge = function(){
		percentTotal = percentId+percentPw+percentPwCheck;
		$(".progress div").width(percentTotal+"%");
	}
	
	//ajax로 키를 누를때만다 해당 함수를 비동기호출하여, 리턴값을통해 아이디가 존재하는지 하지않는지를 추출하려고함.
	$("#guestId").keyup(function(){
		$.post("guestIdCheck.jk",
			{
				guestId: $("#guestId").val(),
			},
			function(data, status){
				$(".guest-id span").show();
				if($("#guestId").val().length < 4){
					$(".guest-id").find("p").text("아이디를 4자 이상 입력 해 주세요.");
					guestFail($(".guest-id"));
					percentId = 0;
				} else if(data == 1){
					$(".guest-id").find("p").text("이미 존재하는 이름 입니다.");
					guestFail($(".guest-id"));
					percentId = 0;
				} else{
					guestSuccess($(".guest-id"));
					percentId = 33;
				}
				percentMerge();
			}
		);
	});
	
// 이걸 지운 이유는 keyup이벤트와 blur이벤트가 중복으로 사용되었을때, blur이 나중에 일어나기때문에 keyup에서 중복에대한 데이터처리를
/* 	$("#guestId").blur(function(){
		$(".guest-id span").show();
		if($("#guestId").val().length < 4){
			guestFail($(".guest-id"));
			percentId = 0;
		} else {
			guestSuccess($(".guest-id"));
			percentId = 33;
		}
		//이거는 blur마다 있는데, 이부분 함수호출로 변경 해줘야할것같다.
		percentMerge();
	}); */
	
	$("#guestPw").blur(function(){
		$(".guest-pw span").show();
		if($("#guestPw").val().length < 4){
			guestFail($(".guest-pw"));
			percentPw = 0;
		} else {
			guestSuccess($(".guest-pw"));
			percentPw = 33;
		}
		percentMerge();
	});
	
	$("#guestPwCheck").blur(function(){
		$(".guest-pw-check span").show();
		if(($("#guestPw").val() != $("#guestPwCheck").val()) || ($("#guestPwCheck").val().length < 4)){
			guestFail($(".guest-pw-check"));
			percentPwCheck = 0;
		} else {
			guestSuccess($(".guest-pw-check"));
			percentPwCheck = 34;
		}
		percentMerge();
	});
	
	$("#uGuestPw").blur(function(){
		$(".update-guest-pw span").show();
		if($("#uGuestPw").val().length < 4){
			guestFail($(".update-guest-pw"));
			percentPw = 0;
		} else {
			guestSuccess($(".update-guest-pw"));
			percentPw = 50;
		}
		percentMerge();
	});
	
	$("#uGuestPwCheck").blur(function(){
		$(".update-guest-pw-check span").show();
		if(($("#uGuestPw").val() != $("#uGuestPwCheck").val()) || ($("#uGuestPwCheck").val().length < 4)){
			guestFail($(".update-guest-pw-check"));
			percentPwCheck = 0;
		} else {
			guestSuccess($(".update-guest-pw-check"));
			percentPwCheck = 50;
		}
		percentMerge();
	});
	
	
	
	
	
	
	
	$("#checkAddr").click(function(){ 
		if($("#checkAddr").prop("checked")) {
			$("input[type=checkbox]").prop("checked",true);
		} else {
			$("input[type=checkbox]").prop("checked",false); 
		} 
	});

	$("#guestAddrBtn").click(function(){ 
		if($("#guestAddress").val().length < 1) {
			
		} else {
			console.log($("#guestAddrCount").val());
			if($("#guestAddrCount").val() >= 5){
				$("p").show();
			} else{
				$("p").hide();
				$("#guestAddrForm").submit();
			}
		}
	});
	
	$("#removeAddrBtn").click(function(){ 
		$(".form-check").attr("action", "removeGuestAddr.jk?guestNo=<%= request.getParameter("guestNo") %>");
		
		$(".form-check").submit();
	});
	
	$(".removeGuestList").click(function(){
		var count = $(this).attr("value");
 		if(count > 0){
		} else{
			$(this).attr("href", "removeGuest.jk?guestNo="+$(this).attr("name"));
			$(this).submit();
		}
		
		
	});
	
	
	
	
});
</script>