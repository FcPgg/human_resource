<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%@ include file="../../common.jsp"%>


<script src="https://cdn.bootcss.com/socket.io/1.4.5/socket.io.min.js"></script>
<script src="http://cdn.bootcss.com/angular.js/1.5.7/angular.min.js"></script>

<script type="text/javascript" src="static/chatroom/jmessage-sdk-web/jmessage-sdk-web.js"></script>

<style>
*,*:before,*:after {
	box-sizing: border-box;
}

.body,html {
	height: 100%;
	overflow: hidden;
}

.body,ul {
	margin: 0;
	padding: 0;
}

.body {
	color: #4d4d4d;
	font: 14px/1.4em 'Helvetica Neue', Helvetica, 'Microsoft Yahei', Arial,
		sans-serif;
	background: #f5f5f5 url('static/chatroom/dist/images/bg.jpg') no-repeat
		center;
	background-size: cover;
	font-smoothing: antialiased;
}

ul {
	list-style: none;
	margin: 0;
	padding: 0;
}

.m-list li.active {
	background-color: hsla(0, 0%, 100%, .1);
}

.sidebar {
	float: left;
	width: 200px;
	color: #f4f4f4;
	height: 100%;
	background-color: #2e3238;
}

.m-list li {
	padding: 9pt 15px;
	border-bottom: 1px solid #292c33;
	cursor: pointer;
	-webkit-transition: background-color .1s;
	transition: background-color .1s;
}

.m-card {
	padding: 9pt;
	border-bottom: 1px solid #24272c;
}

.m-list .name {
	display: inline-block;
	margin: 0 0 0 15px;
	width: 110px;
}

.m-card .name {
	display: inline-block;
	margin: 0 0 0 15px;
	font-size: 1pc;
}

.m-card .search {
	padding: 0 10px;
	width: 100%;
	font-size: 9pt;
	color: #fff;
	height: 30px;
	line-height: 30px;
	border: 1px solid #3a3a3a;
	border-radius: 4px;
	outline: 0;
	background-color: #26292e;
}

.m-card footer {
	margin-top: 10px;
}

header img {
	margin-left: 3px;
}

.main-message {
	position: relative;
	overflow: hidden;
	background-color: #eee;
	height: 100%;
}

.m-message li {
	margin-bottom: 15px;
}

.m-message .time {
	margin: 7px 0;
	text-align: center;
}

.m-message {
	height: calc(100% -     10pc);
	padding: 10px 15px;
	overflow-y: scroll;
	border-right: 1px solid;
	border-top: 1px solid;
}

.m-message .text {
	display: inline-block;
	position: relative;
	padding: 0 10px;
	max-width: calc(100% -     40px);
	min-height: 30px;
	line-height: 2.5;
	font-size: 9pt;
	text-align: left;
	word-break: break-all;
	background-color: #fafafa;
	border-radius: 4px;
}

.m-message .avatar {
	float: left;
	margin: 0 10px 0 0;
	border-radius: 3px;
}

.m-message .self {
	text-align: right;
}

.m-message .self .avatar {
	float: right;
	margin: 0 0 0 10px;
}

.m-message .self .text {
	background-color: #b2e281;
}

.m-message .time>span {
	display: inline-block;
	padding: 0 18px;
	font-size: 9pt;
	color: #fff;
	border-radius: 2px;
	background-color: #dcdcdc;
}

.m-text {
	position: absolute;
	width: 100%;
	left: 0;
	border-bottom: 1px solid;
	border-right: 1px solid;
	height: 10pc;
}

.m-text textarea {
	padding: 10px;
	width: 95%;
	border: none;
	outline: 0;
	font-family: Micrsofot Yahei;
	resize: none;
	height: 100%;
}
.m-text button {
	padding: 10px;
	width: 5%;
	border: none;
	outline: 0;
	font-family: Micrsofot Yahei;
	resize: none;
	height: 100%;
	float:right;
}
.m-message .text:before {
	content: " ";
	position: absolute;
	top: 9px;
	right: 100%;
	border: 6px solid transparent;
	border-right-color: #fafafa;
}

.m-message .self .text:before {
	right: inherit;
	left: 100%;
	border-right-color: transparent;
	border-left-color: #b2e281;
}
.dot {
    width: 10px;
    height: 10px;
    background: red;
    float: right;
    margin-top:5px;
    border-radius: 50%;
}
</style>
<div class="body" ng-app="app" ng-controller="myController">
	<div class="sidebar">
		<div class="m-card">
			<header>
				<img class="avatar" width="40" height="40" alt="Coffce" src="/Web/showImage?uuid=${currentUser.headImgUrl != null ? currentUser.headImgUrl : "default.jpg"}">
				<p class="name">${currentUser.nickName }</p>
				<input class="hide" value="${currentUser.id}" id="currentUserId"/>
				<input class="hide" value="${currentUser.headImgUrl}" id="headImgUrl"/>
			</header>
			<footer>
				<input class="search" placeholder="查找....." ng-model="userNickName">
			</footer>
		</div>
		<div class="m-list">
			<ul id="conversationsList">
				<li ng-repeat="item in conversations | filter : userNickName" ng-click="conversationItemClick({item}, $event)">
					<img class="avatar" width="30" height="30" alt="item.userNickName" ng-src="/Web/showImage?uuid={{item.headImgUrl != null ? item.headImgUrl : 'default.jpg'}}">
					<div class="name">{{item.userNickName}}<div class="dot" style="display: none;"></div></div>
				</li>
			</ul>
		</div>
	</div>
	<div class="main-message">
		<div class="m-message" id="m-message">
			<div style="text-align: center; " ><button class="btn-link" ng-click="loadNextPage()" style="display: none;" id="btnShowPage" >加载更多...</button></div>
			<ul>
				<!--v-for-start-->
				<li ng-repeat="content in contents">
					<p class="time">
						<span>{{content.createTime}}</span>
					</p>
					<div class="{{content.clazz}}">
						<img class="avatar" width="30" height="30" ng-src="/Web/showImage?uuid={{content.headImgUrl  != null ? content.headImgUrl : 'default.jpg'}}">
						<div class="text">{{content.content}}</div>
					</div>
				</li>
				<!--v-for-end-->
			</ul>
		</div>
		<!--v-component-->
		<div class="m-text">
			<textarea id="textarea" placeholder="按 Ctrl + Enter 发送" ng-keyup="sendSingleMsg($event)" ng-click="scrollBottom()"></textarea>
			<button id="sendMessage" class="btn btn-info" ng-click="sendSingleMessage();">发送</button>
		</div>
		<!--v-component-->
	</div>
</div>
<script type="text/javascript">
$("#sendMessage").height($("#textarea").height());

angular.module('app', []).controller('myController', ['$scope', function($scope) {
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

  $scope.conversations = [];
  
  $scope.contents = [];
  
  $scope.targetUserId = null;
  
  //当前页
  $scope.page = 1;
  
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
		  
		  $scope.getConversations();
	  } else {
		  console.log("login failed: " + data.message);
	  }
  }
  
  //加载会话列表
  $scope.getConversations = function(){
	  $.post("mt/mtMessageConversations/getConversations", {userId: $("#currentUserId").val()}, function(result){
          if(result.success){
        	  $scope.conversations = result.data;
        	  $scope.$apply($scope.conversations);  
          } else {
        	  console.log("get conversations error:" + result.error);
          }
      });
  }
  
  //接收消息
  $scope.onMsgReceive = function(data){
	  
	  if(data.msg_body.text){
		  var content = JSON.parse(data.msg_body.text);
		  
		 
		  
		  content.clazz = "content";
		  
		  var targetConversation = null;
		  if($scope.conversations && $scope.conversations.length){
			  var newConversation = true;
			  $.each($scope.conversations, function(){
				  if(this.source == content.userId){
					  newConversation = false;  
					  targetConversation = this;
					  return;
				  }
			  });
			  
			  if(newConversation){
				  var conversation = {
						  source: content.userId,
						  headImgUrl: content.headImgUrl,
						  createTime: content.createTime,
						  userNickName: content.userNickName,
						  newMessage: true,
						  target: $("#currentUserId").val()
				  }
				  
				  $scope.conversations.splice(0, 0, conversation);
			  } else {
				  if(targetConversation){
					  targetConversation.newMessage = true;
				  }
			  }
		  } else {
			  $scope.conversations = [];
			  var conversation = {
					  source: content.userId,
					  headImgUrl: content.headImgUrl,
					  createTime: content.createTime,
					  userNickName: content.userNickName,
					  newMessage: true,
					  target: $("#currentUserId").val()
			  }
			  targetConversation = conversation;
			  $scope.conversations.push(conversation);
		  }
		  $scope.$apply($scope.conversations);
		  
		  var index = $scope.conversations.indexOf(targetConversation);
		  $(".dot:eq(" + index + ")").show();
		  
		  if(content.userId != $scope.targetUserId){
			  return;
		  } else {
			  $scope.contents.push(content);
			  $scope.$apply($scope.contents);
		  }
	  }
  }
  
  //获取聊天记录
  $scope.conversationItemClick = function(data, $event){
	  var source = data.item.source;
	  if(source){
		  //设置回复人
		  $scope.targetUserId = source;
		  $($event.target).find(".dot").hide();
	  	  $scope.page = 1;
	  	  $scope.showPage(source, $scope.page, false);
	  }
		  
	  $("#btnShowPage").show();
	  $("#btnShowPage").removeAttr("disabled");
	  $("#btnShowPage").html("加载更多...");
  }
  
  //加载下一页
  $scope.loadNextPage = function(){
	  $scope.showPage($scope.targetUserId, $scope.page, true);
  }
  
  $scope.scrollBottom = function(){
	  var div = document.getElementById("m-message");
	  div.scrollTop = div.scrollHeight;
  }
  
  $scope.showPage = function(source, page, append){
	  $.post("mt/mtMessageContents/getContents",{source: source, target: $("#currentUserId").val(), page: page, rows : 10}, function(r){
		  if(r.success){
			  if(!append){
				  $scope.contents = [];
			  }
			  $.each(r.data.data, function(){
				  if(this.userId == $("#currentUserId").val()){
					  this.clazz = "self";
				  } else {
					  this.clazz = "content";
				  }
				  $scope.contents.splice(0, 0, this); 
			  })
			  
			  if(r.data.totalPageNum == $scope.page){
				  $("#btnShowPage").attr({"disabled":"disabled"});
				  $("#btnShowPage").html("没有更多了...");
			  } else {
				  $scope.page +=1;
			  }
			  
			  
			  $scope.$apply($scope.contents);
		  }
	  });
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
  
  $scope.sendSingleMessage = function(){
	  var text = $("#textarea").val();
	  if(text && text.length > 0){
		  $scope.respData.type = 'singleMsg';

			var message = { 
				userId : $("#currentUserId").val(),
				headImgUrl : $("#headImgUrl").val(),
				createTime : (new Date()).format("yyyy-MM-dd HH:mm"),
				content : text
			};
		    
		    JIM.sendSingleMsg("app_user_" + $scope.targetUserId, JSON.stringify(message), function(data){
				if(data.code == 0){
					var param = {
						source: $("#currentUserId").val(), 
						target: $scope.targetUserId, 
						messageId: data.msg_id, 
						type:"text",
						content: text
					}
					$.post("mt/mtMessageContents/addContents", param, function(r){
						if(r.success){
							$("#textarea").val("");
							//绑定class控制样式
							r.data.clazz = "self";
							$scope.contents.push(r.data);
							$scope.$apply($scope.contents);
						} else {
							console.log("create message error:" + r.message);
						}
					});
				} else {
					console.log("sendMessageError:" + data.message);
				}
			}, $scope.ack, $scope.timeout);
	  }
  }
  
  $scope.sendSingleMsg = function(e) {
	  var text = $("#textarea").val();
	  if(e.ctrlKey && e.keyCode === 13 && text.length){
	    $scope.respData.type = 'singleMsg';

		var message = { 
			userId : $("#currentUserId").val(),
			headImgUrl : $("#headImgUrl").val(),
			createTime : (new Date()).format("yyyy-MM-dd HH:mm"),
			content : text
		};
	    
	    JIM.sendSingleMsg("app_user_" + $scope.targetUserId, JSON.stringify(message), function(data){
			if(data.code == 0){
				var param = {
					source: $("#currentUserId").val(), 
					target: $scope.targetUserId, 
					messageId: data.msg_id, 
					type:"text",
					content: text
				}
				$.post("mt/mtMessageContents/addContents", param, function(r){
					if(r.success){
						$("#textarea").val("");
						//绑定class控制样式
						r.data.clazz = "self";
						$scope.contents.push(r.data);
						$scope.$apply($scope.contents);
					} else {
						console.log("create message error:" + r.message);
					}
				});
			} else {
				console.log("sendMessageError:" + data.message);
			}
		}, $scope.ack, $scope.timeout);
	  }
  }

}]);


// 对Date的扩展，将 Date 转化为指定格式的String  
// 月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符，   
// 年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字)   
/* Date.prototype.format = function (fmt) { //author: meizz   
    var o = {  
        "M+": this.getMonth() + 1, //月份   
        "d+": this.getDate(), //日   
        "H+": this.getHours(), //小时   
        "m+": this.getMinutes(), //分   
        "s+": this.getSeconds(), //秒   
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度   
        "S": this.getMilliseconds() //毫秒   
    };  
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));  
    for (var k in o)  
    if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));  
    return fmt;  
}   */
</script>