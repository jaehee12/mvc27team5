$("#loginBtn").click(function(e) {
	if( $("#guestId").val().length < 4 ){
		
	} else if( $("#guestPw").val().length < 4 ){
		
	} else if( $("#guestPw").val() != $("#guestPwCheck").val() ){
		
	} else{
		$("#loginForm").submit();
	}
});

$(function() {
	$('[data-toggle="tooltip"]').tooltip()
});