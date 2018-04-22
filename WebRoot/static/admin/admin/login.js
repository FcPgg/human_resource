var validation = false;

function doLogin(){
	var userName = $("#input-user-name-login").val();
	var password = $("#input-password-login").val();
	if(userName && password){
		$.post("login/doLogin",{userName: userName, password: md5(password)}, function(r){
			if(r.success){
				window.location.href = "./";
			} else {
				alert(r.message);
				console.log(r.error);
			}
		});
	} else {
		alert("请输入用户名或密码");
	}
}

function checkUserExists(){
	$.post("login/checkUserExists", {userName:  $("#input-user-name-register").val()}, function(r){
		if(r.success){
			if(r.data){
				alert("该用户名已被注册，请重新输入");
				$("#input-user-name-register").val("");
				validation = false;
			} else {
				validation = true;
			}
		} else {
			alert(r.message);
			console.log(r.error);
		}
	});
}

function KeyDown(){  
    if (event.keyCode == 13){  
        event.returnValue=false;  
        event.cancel = true;  
        doLogin();
    }  
}  
