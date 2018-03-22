<!-- [유국화] -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<meta charset="UTF-8">
<!-- 사이트가 IE에서 올바로 표시되지 않는다면, 가장 최신 웹 표준 지원을 위해 사이트를 업데이터하거나,(권장)
IE를  이전 버전의 브라우저에서 보는 것처럼 내용을 표시하도록 할 수 있습니다. 하지만 기능들이 정상적으로 작동하지 않을수도 있습니다.
화면에 보이는 것만 정상적으로 보일수 있다. -->
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- 어떤 디바이스에서든 해당 디바이스에 맞는 화면크기를 보여주기위하여 사용. -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 위 3개의 메타 태그는 *반드시* head 태그의 처음에 와야합니다; 어떤 다른 콘텐츠들은 반드시 이 태그들 *다음에* 와야 합니다 -->
<title>addTeacher</title>
<!-- 부트스트랩 기본 css-->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<!-- 로그인 모달부분 css-->
<link href="${pageContext.request.contextPath}/css/login.css" rel="stylesheet">
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요합니다.) -->
<style>
	.addTeacherForm{width:300px;}
	.input-group{width:100%;}
	.input-group-addon{top:0 !important;}
</style>
<script src="${pageContext.request.contextPath}/js/jquery-3.3.1.min.js"></script>
<!-- 로그인 버튼 submit -->
<script src="${pageContext.request.contextPath}/js/topMenu.js"></script>
<!-- 모든 컴파일된 플러그인을 포함합니다 -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script>
// 가입할때 유효성 검사
$(document).ready(function(){
	$(".teacher-id span").hide();
	$(".teacher-pw span").hide();
	$(".teacher-pw-check span").hide();
	$(".teacher-addr span").hide();	
	$(".update-teacher-pw span").hide();
	$(".update-teacher-pw-check span").hide();	
	$("#teacherIdCheckHelp").hide();
	$("p").hide();
	
	// 가입버튼 눌렀을 때 입력칸에 다 입력되있는지 안되있으면 포커스가 가게 하는 유효성검사
	$("#teacherBtn").click(function(e) {
		if ($("#teacherId").val().length < 4) {
			$("#teacherId").focus();
		} else if ($("#teacherPw").val().length < 4) {
			$("#teacherPw").focus();
		} else if ($("#teacherPw").val() != $("#teacherPwCheck").val()) {
			$("#teacherPwCheck").focus();
		} else {
			$("#teacherForm").submit();
		}
	});
	
	// 회원리스트에서 수정눌러서 입력하고 수정완료버튼 눌렀을때 유효성검사
	$("#updateTeacherBtn").click(function(e) {
		if ($("#uTeacherPw").val().length < 4) {
			$("#uTeacherPw").focus();
		} else if ($("#uTeacherPw").val() != $("#uTeacherPwCheck").val()) {
			$("#uTeacherPwCheck").focus();
		} else {
			$("#uTeacherForm").submit();
		}
	});
	
	// 가입화면 유효성검사의 결과가 success인지 fail인지 변수에 함수를 담음.
	var teacherSuccess = function(teacherSuccessForm){
		teacherSuccessForm.removeClass("text-danger");
		teacherSuccessForm.removeClass("has-error");
		teacherSuccessForm.find("span").removeClass("glyphicon glyphicon-remove-circle");
		teacherSuccessForm.find("p").hide();
		teacherSuccessForm.find("span").addClass("glyphicon glyphicon-ok");
		teacherSuccessForm.addClass("text-success");
		teacherSuccessForm.addClass("has-success");
	}
	
	var teacherFail = function(teacherFailForm){
		teacherFailForm.removeClass("text-success");
		teacherFailForm.removeClass("has-success");
		teacherFailForm.find("span").removeClass("glyphicon glyphicon-ok");
		teacherFailForm.addClass("text-danger");
		teacherFailForm.addClass("has-error");
		teacherFailForm.find("span").addClass("glyphicon glyphicon-remove-circle");
		teacherFailForm.find("p").show();
	}
	
	// 입력상태에 따라 프로세스 게이지 바의 변수선언
	var percentTotal=0;
	var percentId=0;
	var percentPw=0;
	var percentPwCheck=0;
	
	// progress클래스의 div속성의 너비는 100+"%"
	var percentMerge = function(){
		percentTotal = percentId+percentPw+percentPwCheck;
		$(".progress div").width(percentTotal+"%");
	}
	
	//ajax로 키를 누를때만다 해당 함수를 비동기호출하여, 리턴값을통해 아이디가 존재하는지 하지않는지를 추출하려고함.
	$("#teacherId").keyup(function(){
		$.post("teacherIdCheck.ykh",
			{
				teacherId: $("#teacherId").val(),
			},
			function(data, status){
				$(".teacher-id span").show();
				if($("#teacherId").val().length < 4){
					$(".teacher-id").find("p").text("아이디를 4자 이상 입력 해 주세요.");
					teacherFail($(".teacher-id"));
					percentId = 0;
				} else if(data == 1){
					$(".teacher-id").find("p").text("이미 존재하는 이름 입니다.");
					teacherFail($(".teacher-id"));
					percentId = 0;
				} else{
					teacherSuccess($(".teacher-id"));
					percentId = 33;
				}
				percentMerge();
			}
		);
	});
	

	$("#teacherPw").blur(function(){
		$(".teacher-pw span").show();
		if($("#teacherPw").val().length < 4){
			teacherFail($(".teacher-pw"));
			percentPw = 0;
		} else {
			teacherSuccess($(".teacher-pw"));
			percentPw = 33;
		}
		percentMerge();
	});
	
	$("#teacherPwCheck").blur(function(){
		$(".teacher-pw-check span").show();
		if(($("#teacherPw").val() != $("#teacherPwCheck").val()) || ($("#teacherPwCheck").val().length < 4)){
			teacherFail($(".teacher-pw-check"));
			percentPwCheck = 0;
		} else {
			teacherSuccess($(".teacher-pw-check"));
			percentPwCheck = 34;
		}
		percentMerge();
	});
	
	$("#uTeacherPw").blur(function(){
		$(".update-teacher-pw span").show();
		if($("#uTeacherPw").val().length < 4){
			teacherFail($(".update-teacher-pw"));
			percentPw = 0;
		} else {
			teacherSuccess($(".update-teacher-pw"));
			percentPw = 50;
		}
		percentMerge();
	});
	
	$("#uTeacherPwCheck").blur(function(){
		$(".update-teacher-pw-check span").show();
		if(($("#uTeacherPw").val() != $("#uTeacherPwCheck").val()) || ($("#uTeacherPwCheck").val().length < 4)){
			teacherFail($(".update-teacher-pw-check"));
			percentPwCheck = 0;
		} else {
			teacherSuccess($(".update-teacher-pw-check"));
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

	$("#teacherAddrBtn").click(function(){ 
		if($("#teacherAddress").val().length < 1) {			
		} else {
			if($("#teacherAddrCount").val() >= 5){
				$("p").show();
			} else{
				$("p").hide();
				$("#teacherAddrForm").submit();
			}
		}
	});
	
	$("#removeAddrBtn").click(function(){ 
		$(".form-check").attr("action", "removeTeacherAddr.ykh?teacherNo=<%= request.getParameter("teacherNo") %>");
		
		$(".form-check").submit();
	});	
});
</script>