<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
	  <%@ include file="common.jsp"%>
		<meta charset="utf-8" />
		<title>${projectName } - 后台管理</title>
        <style type="text/css">
        	iframe {
				height: 800px;
			}
        </style>
        <script src="https://cdn.bootcss.com/socket.io/1.4.5/socket.io.min.js"></script>
		<script src="http://cdn.bootcss.com/angular.js/1.5.7/angular.min.js"></script>
		
		<script type="text/javascript" src="static/chatroom/jmessage-sdk-web/jmessage-sdk-web.js"></script>
		        
	</head>

	<body  ng-app="app" ng-controller="indexController">
		
		<div class="navbar navbar-default" id="navbar">
			<script type="text/javascript">
				try{ace.settings.check('navbar' , 'fixed')}catch(e){}
			</script>

			<div class="navbar-container" id="navbar-container">
				<div class="navbar-header pull-left">
					<a href="#" class="navbar-brand">
						<small>
							<i class="icon-leaf"></i>
							${projectName }后台管理系统
						</small>
					</a><!-- /.brand -->
				</div><!-- /.navbar-header -->

				<div class="navbar-header pull-right" role="navigation">
					<ul class="nav ace-nav">
						<li id="message-li" class="purple">
							<a data-toggle="dropdown" class="dropdown-toggle" href="#">
								<i class="icon-bell-alt icon-animated-bell"></i>
								<span class="badge badge-important message-count">0</span>
							</a>

							<ul id="message-ul" style="width: 600px;" class="pull-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
								<li class="dropdown-header">
									<i class="icon-warning-sign"></i>
									<span class="message-count">0</span>条通知
								</li>
							</ul>
						</li>

						<li class="light-blue">
							<a data-toggle="dropdown" href="javascript:void(0);" class="dropdown-toggle">
								<img class="nav-user-photo" src="static/assets/avatars/user.jpg" alt="Jason's Photo" />
								<span class="user-info">
									<input id="currentUserId" style="display: none;" value="<%= currentUser != null ? currentUser.getId() : null%>"/>
									<small>欢迎光临,</small>
									${currentUser.nickName }
								</span>

								<i class="icon-caret-down"></i>
							</a>

							<ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
								<li>
									<a href="javascript:void(0);" onclick="doResetPassword();">
										<i class="icon-cog"></i>
										修改密码
									</a>
								</li>

								<li>
									<a href="javascript:void(0);" onclick="doUpdateUserInfo();">
										<i class="icon-user"></i>
										个人资料
									</a>
								</li>
								<li>
									<a href="javascript:void(0);" onclick="doUpdateUserInfo();">
										<i class="glyphicon glyphicon-adjust"></i>
										头像修改
									</a>
								</li>

								<li class="divider"></li>

								<li>
									<a href="javascript:void(0);" onclick="doLogOut();">
										<i class="icon-off"></i>
										安全退出
									</a>
								</li>
							</ul>
						</li>
					</ul><!-- /.ace-nav -->
				</div><!-- /.navbar-header -->
			</div><!-- /.container -->
		</div>

		<div class="main-container" id="main-container">
		
		
			<script type="text/javascript">
				try{ace.settings.check('main-container' , 'fixed')}catch(e){}
			</script>

			<div class="main-container-inner">
				<a class="menu-toggler" id="menu-toggler" href="#">
					<span class="menu-text"></span>
				</a>

				<div class="sidebar" id="sidebar">
					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
					</script>

					<div class="sidebar-shortcuts" id="sidebar-shortcuts">
						<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
							<button class="btn btn-success">
								<i class="icon-signal"></i>
							</button>

							<button class="btn btn-info">
								<i class="icon-pencil"></i>
							</button>

							<button class="btn btn-warning">
								<i class="icon-group"></i>
							</button>

							<button class="btn btn-danger">
								<i class="icon-cogs"></i>
							</button>
						</div>

						<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
							<span class="btn btn-success"></span>

							<span class="btn btn-info"></span>

							<span class="btn btn-warning"></span>

							<span class="btn btn-danger"></span>
						</div>
					</div><!-- #sidebar-shortcuts -->

					<ul class="nav nav-list" id="ul-menu-list">
				
					</ul><!-- /.nav-list -->

					<div class="sidebar-collapse" id="sidebar-collapse">
						<i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
					</div>

					<script type="text/javascript">
						try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
					</script>
				</div>


               <div class="main-content"><div class="page-content">
                    <div class="row">
                        <div class="col-xs-12" style="padding-left:5px;">
                            <ul class="nav nav-tabs" role="tablist">
                                <!-- <li class="active"><a href="#Index" role="tab" data-toggle="tab">首页</a></li> -->
                            </ul>
                            <div class="tab-content" >
                                <!-- <div role="tabpanel" style="height:100%" class="tab-pane active" id="Index"> -->
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
           </div>
		<div class="main-content">
		</div><!-- /.main-container -->

		<script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='static/assets/js/jquery.mobile.custom.min.js'>"+"<"+"script>");
		</script>
<script type="text/javascript">
$(function(){
	$.post("admin/sysMenus/getSysMenusWithTreeStructure",{id:$("#currentUserId").val()},function(result){
		if(result.success){
			$.each(result.data[0].children,function(r){
				buildMenu(this, $("#ul-menu-list"));
			});
		}
	});
	//构建菜单
	function buildMenu(d, ele){
		if(d){
			var li = $("<li><a href='javascript:void(0);' class='dropdown-toggle'><i class='icon-dashboard'></i><span class='menu-text'>" + d.name + "</span></a></li>").appendTo(ele);
			if(d.children && d.children.length > 0){
				var subUl = $("<ul class='submenu'>").appendTo(li);
				$.each(d.children, function(){
					var subLi = $("<li class='active'><a href='javascript:void(0);' id='li-menu-item' class='li-menu-item'><i class='icon-dashboard'></i><span class='menu-text'>" + this.name + "</span></a></li>").appendTo(subUl);
					
					/* javascript:addTabs({id:'21',title: 'jqgrid表单',close: true,url: 'jqgrid.html'}); */
					if(this.children && this.children.length > 0){
						buildMenu(this, subUl);
					}
					 $(subLi).children("#li-menu-item").bind('click',{id:this.id ,uri: this.uri, pagePath : this.pagePath, name: this.name,level: this.level,title: this.title},function(e){
						    $('.li-menu-item').attr('href','javascript:addTabs({id:\'' + e.data.id + '\',title: \'' + e.data.title + '\',close: ' + true + ',url: \'' + e.data.uri+'?title='+e.data.title+'&pagePath='+e.data.pagePath+'\'})');
					  });	 
				});
				$("</ul>").appendTo(li);
			}
			li.append("</li>");
		}
	}
	function onMenuItemClick(e){
	    $('.li-menu-item').attr('href','javascript:addTabs({id:\'' + e.data.level + '\',title: \'' + e.data.title + '\',close: ' + true + ',url: \'' + e.data.uri+'?title='+e.data.title+'&pagePath='+e.data.pagePath+'\'})');
    }
});
	
//修改个人信息
function doUpdateUserInfo(){
	 BootstrapDialog.show({
		title: "个人信息设置",
		cssClass: 'user-info-dialog',
           message: $('<div></div>').load('mt/mtUserInfo/showEditor?editor=admin/userInfo/app-user-editor'),
           buttons: [
            {
               id: 'btn-ok',   
               icon: 'glyphicon glyphicon-check',       
               label: '保存',
               cssClass: 'btn-primary',
               action: function(dialogRef){
               	var form = dialogRef.getModalBody().find("form");
               	var items = $(form).find("input");
               	var user = {};
               	$.each(items, function(){
               		if($(this).attr("name")){
               			user[$(this).attr("name")] = $(this).val();
               		}
               	});
               	user.sex = $(form).find("#sex").val();
               	$.post("mt/mtUserInfo/updateUserInfo", user, function(r){
               		if(r.success){
	                    $.showSuccessTimeout("修改成功", 3000);
	                    dialogRef.close();
               		} else {
               			console.log(r.error);
               			$.showErr(r.message);
               		}
               	});
              	}
               }, {
               label: '关闭',
               action: function(dialogRef) {
                   dialogRef.close();//对于对话框内部的实例对象的引用
               }
           }]
       });
}

function doResetPassword(){
	/* var row = $(e).parent().parent().parent();
	var id = row.find(".id").html(); */
	BootstrapDialog.show({
		title: "重置密码",
		cssClass: 'user-info-dialog',
           message: $('<div></div>').load('mt/mtOpenEditor/showResetPasswordEditor'),
           buttons: [
            {
               id: 'btn-ok',   
               icon: 'glyphicon glyphicon-check',       
               label: '保存',
               cssClass: 'btn-primary',
               action: function(dialogRef){
	               	var form = dialogRef.getModalBody().find("form");
	               	var items = $(form).find("input");
	               	if($("#input-password").val()){
	            		if( $("#input-comfrm-password").val() == $("#input-password").val()){
	            			$.post("mt/mtUserInfo/resetPassword", {id: $("#currentUserId").val() , password: md5($("#input-password").val())}, function(r){
	            				if(r.success){
	            					dialogRef.close();
	            					$.showSuccessTimeout("操作成功", 3000);
	            				} else {
	            					$.showErr(r.message);
	            					console.log(r.info);
	            				}
	            			});
	            		} else {
	            			$.showErr("两次输入密码不一致");
	            		}
	            	}
              	}
               }, {
               label: '关闭',
               action: function(dialogRef) {
                   dialogRef.close();//对于对话框内部的实例对象的引用
               }
           }]
       });
}

function doLogOut(){
	if(window.confirm("是否安全退出系统?")){
		$.post("login/logOut", {userId: $("#currentUserId").val()}, function(r){
			if(r.success){
				window.location = "./";
			} else {
				alert(r.message);
				console.log(r.info);
			}
		});
	}
}

angular.module('app', []).controller('indexController', ['$scope', function($scope) {
	  $scope.respData = {};
	  $scope.auth_platform = {
	    "appkey": "f6ad14f134cddffa22da3079",
	    "random_str": "022cd9fd995849b58b3ef0e943421ed9",
	    "secret" : "9e4516c9b6cce34d914609b6",
	    "timestamp": Date.parse(new Date())
	  };
	  
	  $scope.auth_platform.signature = md5(
			  "appkey=" + $scope.auth_platform.appkey + "&" + 
			  "timestamp=" + $scope.auth_platform.timestamp + "&" +  
			  "random_str=" + $scope.auth_platform.random_str + "&" +
			  "key=" + $scope.auth_platform.secret); 
	  
	  $scope.username = "admin_user_" + $("#currentUserId").val();
	  $scope.password = "123456";

	  JIM.init();
	  
	  JIM.register($scope.username, $scope.password, $scope.auth_platform, function(data){
	  	if(data.code == 0 || data.code == 882002){
			JIM.login($scope.username, $scope.password, $scope.auth_platform, $scope.loginResp, $scope.ack, $scope.timeout);
		} else {
			console.log("Register failed:" + data.message);
		}
	 	
	  }, $scope.ack, $scope.timeout);
	  
	  $scope.loginResp = function(data){
		  if(data.code == 0){
			  console.log("login success: ");
			  
			  //注册监听
			  JIM.onMsgReceive($scope.onMsgReceive);
			  
		  } else {
			  console.log("login failed: " + data.message);
		  }
	  }
	  
	  
	  //接收消息
	  $scope.onMsgReceive = function(data){
		  
		  if(data.msg_body.text){
			  //TODO: 播放提示音;
			  var content = JSON.parse(data.msg_body.text);
			  $("#message-ul").children(".chat-message").remove();
			  $(".message-count").html(parseInt($(".message-count").html()) + 1);
			  $("#message-ul").append('<li class="chat-message" onclick="messgaeClick($(this));">'+
						'<a href="'+'javascript:addTabs({id:10000,title:\'在线客服\',close: ' + true + ',url: \'mt/mtOpenEditor/customerService?title=在线客服&pagePath=admin/customer_service/customer_service\'})'+'">'+
						'<div class="clearfix">'+
						'	<span class="pull-left">'+
						'		<i class="btn btn-xs no-hover btn-pink icon-comment"></i>'+
						'		您收到了一条来自[' + content.userNickName + ']的消息，请在[商家管理 -> 在线客服] 中打开'+
						'	</span>'+
						'	<span class="pull-right badge badge-info">' + $(".message-count").html() + '</span>'+
						'</div>'+
					'</a>'+
				'</li>');
			  $("#message-li").addClass("open");
		  }
	  }
	  
	  $scope.resp = function(data) {
	    console.log("resp : " + JSON.stringify(data));
	    $scope.respData[$scope.respData.type] = JSON.stringify(data);
	    $scope.$apply($scope.respData);
	  }
	  
	  $scope.ack = function(data) {
	    console.log("ack : " + JSON.stringify(data));
	  }

	  $scope.timeout = function(data) {
	    console.log("timeout : " + JSON.stringify(data));
	  }
}]);

//点击消息删除消息
function messgaeClick(e){
	$(".message-count").html(parseInt($(".message-count").html()) - 1);
	e.remove();
}
</script>
		
</body>
<style>
 .user-info-dialog .modal-dialog {
      width: 600px;
  }
  .tab-content{
  	  border:0;
  }
 </style>
</html>

