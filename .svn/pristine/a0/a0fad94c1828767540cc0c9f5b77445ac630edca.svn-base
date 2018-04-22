$(function(){
	loadData(currentPage);
})
var currentPage = 1;
var baseURL = "mt/mtUserInfo/";

function loadData(page, phoneNumber){
	var params = {page: page, rows: 10, category: "sys", name: name};
	
	$.post(baseURL + "doPagination", params, function(r){
		if(r.success){
			if(r.data){
				$("#users-table tbody").children().remove();
				currentPage = r.data.page;
				$.each(r.data.data, function(){
					var tr = "<tr>"
					var item = this; 
				 	$.each($("#users-table-head").children(), function(){
				 		var clazz = $(this).attr("class");
				 		var style = $(this).attr("style");
				 		if(clazz != null){
					 		var td = "<td style='" + (style != null ? style : "") + "' class='" + clazz + "'>";
					 		
					 		if(clazz == "categoryName"){
					 			switch(item[clazz]){
					 				case "系统管理员" : td += '<span class="label label-info arrowed-right arrowed-in">' + item[clazz] + '</span>';
					 					break;
					 				case "商家" : td += '<span class="label label-success arrowed-in arrowed-in-right">' + item[clazz] + '</span>';
				 						break;
					 			}
					 		}
					 		
					 		
					 		if(clazz == "statusName"){
					 			switch(item[clazz]){
					 				case "未登录" : td += '<span class="label label-info arrowed-right arrowed-in">' + item[clazz] + '</span>';
					 					break;
					 				case "已登录" : td += '<span class="label label-success arrowed-in arrowed-in-right">' + item[clazz] + '</span>';
				 						break;
					 				case "已冻结" : td += '<span class="label label-danger arrowed">' + item[clazz] + '</span>';
			 							break;
					 			}
					 		} else {
						 		td += (item[clazz] != null ? item[clazz] : "");
					 		}
					 		
					 		td += "</td>";
					 		tr += td;
				 		}
				 	});
				 	tr += '<td><div class="am-btn-group am-btn-group-xs">';
				 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-info am-round" title="选择分组" onclick="choiceGroup($(this));"><i class="icon-user" ></i></button>';
				 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-info am-round" title="重置密码" onclick="resetPassword($(this));"><i class="icon-cog" ></i></button>';
				 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="冻结该账号" onclick="doForzenUser($(this));"><i class="am-icon-ban" ></i></button>';
				 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-primary am-round" title="解冻该账号" onclick="doThawUser($(this));"><span class="am-icon-reply" ></span></button>';
				 	tr += '</div></td>';
				 	tr += "</tr>";
					$("#users-table tbody").append(tr);
			    });
				if(r.data.totalPageNum > 0){
					$.jqPaginator('#pageLimit',{
						totalPages: r.data.totalPageNum,
						visiblePages: 10,
						currentPage: page,
						prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
						next: '<li class="next"><a href="javascript:;">下一页</a></li>',
						page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
						onPageChange: function (num, type) {
							if(type == "change"){
								loadData(num);
							}
						}
					});
				}
			}
		}
	})
}

function doAddUser(){
	BootstrapDialog.show({
		title: "添加用户",
		cssClass: 'user-info-dialog',
           message: $('<div></div>').load('mt/mtOpenEditor/showSysUserEditor'),
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
	               	var password = $("#password").val();
	               	user.sex = $(form).find("#sex").val();
	               	user.password = md5(password);
	               	$.post("login/doRegister", user, function(r){
	               		if(r.success){
		                    loadData(1);
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

//选择分组
function choiceGroup(e){
	var row = $(e).parent().parent().parent();
	var id = row.find(".id").html();
	BootstrapDialog.show({
		title: "选择分组（权限）",
		cssClass: 'user-info-dialog',
           message: $('<div></div>').load('mt/mtOpenEditor/showchoiceGroup'),
           buttons: [
            {
               id: 'btn-ok',   
               icon: 'glyphicon glyphicon-check',       
               label: '保存',
               cssClass: 'btn-primary',
               action: function(dialogRef){
	               	$.post("mt/choiceGroup/update",{"userId":id,"groupId":$("#group").val()},function(r){
	               		
	               	})
              	}
               }, {
               label: '关闭',
               action: function(dialogRef) {
                   dialogRef.close();//对于对话框内部的实例对象的引用
               }
           }]
       });
}


//修改密码
function resetPassword(e){
	var row = $(e).parent().parent().parent();
	var id = row.find(".id").html();
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
	            			$.post("mt/mtUserInfo/resetPassword", {id: id , password: md5($("#input-password").val())}, function(r){
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

//冻结用户账号
function doForzenUser(e){
	var row = $(e).parent().parent().parent();
	var id = row.find(".id").html();
	
	if(row.find(".status") != 9){
		$.showConfirm("是否冻结该用户账号？", function(){
			$.post(baseURL + "doForzenUser", {userId: id}, function(r){
				if(r.success){
					loadData(currentPage);
				} else {
					alert(r.message);
					console.log(r.error);
				}
			});
		});
	}
}

//解冻用户账号
function doThawUser(e){
	var row = $(e).parent().parent().parent();
	var id = row.find(".id").html();
	
	if(row.find(".status").html() == 9){
		$.showConfirm("是否冻结该用户账号？", function(){
			$.post(baseURL + "doThawUser", {userId: id}, function(r){
				if(r.success){
					loadData(currentPage);
				} else {
					alert(r.message);
					console.log(r.error);
				}
			});
		});
	}
}

function doQuery(){
	loadData(1, $("#phoneNumber").val());
}