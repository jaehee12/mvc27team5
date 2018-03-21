<!-- [김재희] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta charset="utf-8">
<!-- 사이트가 IE에서 올바로 표시되지 않는다면, 가장 최신 웹 표준 지원을 위해 사이트를 업데이터하거나,(권장)
IE를  이전 버전의 브라우저에서 보는 것처럼 내용을 표시하도록 할 수 있습니다. 하지만 기능들이 정상적으로 작동하지 않을수도 있습니다.
화면에 보이는 것만 정상적으로 보일수 있다. -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 어떤 디바이스에서든 해당 디바이스에 맞는 화면크기를 보여주기위하여 사용. -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>addStudent</title>
<!-- 부트스트랩 기본 css-->
<link href="<%=request.getContextPath()%>/css/bootstrap.min.css" rel="stylesheet">
<!-- 로그인 모달부분 css 처리하기~ -->
<link href="<%=request.getContextPath()%>/css/login.css" rel="stylesheet">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다.) 그런데 나는 자바스크랩트 최신버전으로 새로 받은거임~ -->
<style>
	.addStudentForm{width:300px;}
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
	$(".student-id span").hide();
	$(".student-pw span").hide();
	$(".student-pw-check span").hide();
	$(".student-addr span").hide();
	
	$(".update-student-pw span").hide();
	$(".update-student-pw-check span").hide();
	
	$("#studentIdCheckHelp").hide();
	$("p").hide();
	
	$("#studentBtn").click(function(e) {
		if ($("#studentId").val().length < 4) {
			$("#studentId").focus();
		} else if ($("#studentPw").val().length < 4) {
			$("#studentPw").focus();
		} else if ($("#studentPw").val() != $("#studentPwCheck").val()) {
			$("#studentPwCheck").focus();
		} else {
			$("#studentForm").submit();
		}
	});
	
	$("#updateStudentBtn").click(function(e) {
		if ($("#uStudentPw").val().length < 4) {
			$("#uStudentPw").focus();
		} else if ($("#uStudentPw").val() != $("#uStudentPwCheck").val()) {
			$("#uStudentPwCheck").focus();
		} else {
			$("#uStudentForm").submit();
		}
	});
	
	//아래서 원래 사용하던 코드의 내용이중복되기때문에, 함수형태로 만들어줬다. 이건 나중에 keyup이벤트할때도 쓸것임!
	var studentSuccess = function(studentSuccessForm){
		studentSuccessForm.removeClass("text-danger");
		studentSuccessForm.removeClass("has-error");
		studentSuccessForm.find("span").removeClass("glyphicon glyphicon-remove-circle");
		studentSuccessForm.find("p").hide();
		studentSuccessForm.find("span").addClass("glyphicon glyphicon-ok");
		studentSuccessForm.addClass("text-success");
		studentSuccessForm.addClass("has-success");
	}
	
	var studentFail = function(studentFailForm){
		studentFailForm.removeClass("text-success");
		studentFailForm.removeClass("has-success");
		studentFailForm.find("span").removeClass("glyphicon glyphicon-ok");
		studentFailForm.addClass("text-danger");
		studentFailForm.addClass("has-error");
		studentFailForm.find("span").addClass("glyphicon glyphicon-remove-circle");
		studentFailForm.find("p").show();
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
	$("#studentId").keyup(function(){
		$.post("studentIdCheck.jjdev",
			{
				studentId: $("#studentId").val(),
			},
			function(data, status){
				$(".student-id span").show();
				if($("#studentId").val().length < 4){
					$(".student-id").find("p").text("아이디를 4자 이상 입력 해 주세요.");
					studentFail($(".student-id"));
					percentId = 0;
				} else if(data == 1){
					$(".student-id").find("p").text("이미 존재하는 이름 입니다.");
					studentFail($(".student-id"));
					percentId = 0;
				} else{
					studentSuccess($(".student-id"));
					percentId = 33;
				}
				percentMerge();
			}
		);
	});
	
	$("#studentPw").blur(function(){
		$(".student-pw span").show();
		if($("#studentPw").val().length < 4){
			studentFail($(".student-pw"));
			percentPw = 0;
		} else {
			studentSuccess($(".student-pw"));
			percentPw = 33;
		}
		percentMerge();
	});
	
	$("#studentPwCheck").blur(function(){
		$(".student-pw-check span").show();
		if(($("#studentPw").val() != $("#studentPwCheck").val()) || ($("#studentPwCheck").val().length < 4)){
			studentFail($(".student-pw-check"));
			percentPwCheck = 0;
		} else {
			studentSuccess($(".student-pw-check"));
			percentPwCheck = 34;
		}
		percentMerge();
	});
	
	$("#uStudentPw").blur(function(){
		$(".update-student-pw span").show();
		if($("#uStudentPw").val().length < 4){
			studentFail($(".update-student-pw"));
			percentPw = 0;
		} else {
			studentSuccess($(".update-student-pw"));
			percentPw = 50;
		}
		percentMerge();
	});
	
	$("#uStudentPwCheck").blur(function(){
		$(".update-student-pw-check span").show();
		if(($("#uStudentPw").val() != $("#uStudentPwCheck").val()) || ($("#uStudentPwCheck").val().length < 4)){
			studentFail($(".update-student-pw-check"));
			percentPwCheck = 0;
		} else {
			studentSuccess($(".update-student-pw-check"));
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

	$("#studentAddrBtn").click(function(){ 
		if($("#studentAddress").val().length < 1) {
			
		} else {
			console.log($("#studentAddrCount").val());
			if($("#studentAddrCount").val() >= 5){
				$("p").show();
			} else{
				$("p").hide();
				$("#studentAddrForm").submit();
			}
		}
	});
	
	$("#removeAddrBtn").click(function(){ 
		$(".form-check").attr("action", "removeStudentAddr.jjdev?studentNo=<%= request.getParameter("studentNo") %>");
		
		$(".form-check").submit();
	});	
});
</script>