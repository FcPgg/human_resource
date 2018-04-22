$(function(){
	loadData(currentPage);
})
var currentPage = 1;
var baseURL = "mt/mtUserInfo/";

function loadData(page, phoneNumber){
	var params = {page: page, rows: 10, category: "app", phoneNumber: phoneNumber};
	
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
				 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-success am-round"  title="查看消费记录" onclick="checkUserConsumption($(this))"><span class="am-icon-search"></span> </button>';
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
//查看消费记录
function checkUserConsumption(e){
	var row = $(e).parent().parent().parent();
	var id = row.find(".id").html();
	
	$("#userConsumptionDialog").modal();
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