<%@ page pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<meta charset="utf-8" />
<title>${projectName } - 后台管理</title>
<%@ include file="../common.jsp"%>
<script type="text/javascript" src="static/admin/admin/login.js"></script>
<script type="text/javascript" src="static/js/md5.js"></script>
<style type="text/css">
body {
	background: url(static/images/login-bgs.jpg) no-repeat;
	background-size: cover;
	font-size: 16px;
}

.form {
	background: rgba(255, 255, 255, 1);
	width: 400px;
	margin: 100px auto;
}

#login_form {
	display: block;
}

#register_form {
	display: none;
}

.fa {
	display: inline-block;
	top: 27px;
	left: 6px;
	position: relative;
	color: #ccc;
}

input[type="text"],input[type="password"] {
	padding-left: 26px;
}

.checkbox {
	padding-left: 21px;
}

ul,ol {
	margin: 0;
	padding: 0;
}
</style>
</head>
<body>
	<div class="container">
		<div class="form row" style="margin-top: 250px;width: 500px;"">
			<h1 class="text-center">${projectName }后台管理系统</h1>
			<div class="am-tabs-bd">
				<div class="am-tab-panel am-active" id="tab-panel-login">
					<form class="am-form">
						<div class="am-g">
							<div class="am-form-group">
								<input id="input-user-name-login"  type="text" class="am-radius" placeholder="用户名"  onkeydown="KeyDown()">
							</div>

							<div class="am-form-group form-horizontal m-t-20">
								<input id="input-password-login" type="password" class="am-radius" placeholder="密码" onkeydown="KeyDown()">
							</div>

							<div class="am-form-group ">
								<button type="button" class="am-btn am-btn-primary am-btn-block  am-radius"
									style="width: 100%; height: 100%;" onclick="return doLogin();">登录</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
