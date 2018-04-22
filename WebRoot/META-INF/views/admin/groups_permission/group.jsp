<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html class="no-js">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<%@ include file="../../common.jsp"%>
</head>
<body>
		<div class=" admin-content">     
			<div class="am-panel am-panel-default">
			  <div class="am-panel-hd">分组列表<button class="btn btn-primary btn-app btn-xs pull-right" style="margin-top: -10px;" data-toggle="modal" onclick="doAddGroups();">创建分组</button></div>
			  <div class="am-panel-bd">
			  	<hr/>
		          <table class="am-table am-table-bordered am-table-radius am-table-striped table-condensed  table-striped">
		            <thead >
		              <tr class="am-default" id="group-table-head">
		                <th class="groupName">分组名称</th>
		                <th class="groupInfo">分组描述</th>
		                <th class="createTime">创建时间</th>
		                <th class="masterName">创建人</th>
		                <th width="163px">操作</th>
		              </tr>
		            </thead>
		            <tbody id="groupList">
		            </tbody>
		          </table>
      				<div id="example" style="text-align: center"> <ul id="pageLimit" class="pagination"></ul> </div>
			  </div>
			</div>
		</div>
	
<script type="text/javascript">
$(function(){
	loadData(1);
});

function loadData(page){
	
	var params = {page: page, rows: 10};
	$.post("mt/userGroups/listNormalGroups", params, function(r){				
		if(r.success){
			if(r.data){
				$("#groupList").children().remove();
				groupList(r.data.data);
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
	});
}

//构建分组列表
function groupList(d){
	 $.each(d, function(){
		var tr = "<tr>"
		var item = this; 
	 	$.each($("#group-table-head").children(), function(){
	 		if($(this).attr("class") != null){
		 		var td = "<td style='" + ($(this).attr("style") != null ? $(this).attr("style") : "") + "' class='" + $(this).attr("class") + "'>"
		 		td += (item[$(this).attr("class")] != null ? item[$(this).attr("class")] : "");
		 		td += "</td>";
		 		tr += td;
	 		}
	 	});
	 	tr += '<td><div class="am-btn-group am-btn-group-xs">';
	 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-success am-round" onclick="doAddGroups(id = '+this.id+')" title="编辑"><span class="am-icon-pencil-square-o"></span> </button>';
	 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="移除" onclick="doDelGroups(id = '+this.id+')"><span class="am-icon-times"></span></button>';
	 	tr += '</div></td>';
	 	tr += "</tr>";
			$("#groupList").append(tr);
	  });
}


/**
 * 获取该分组所有权限
 */
 function doAddGroups(id){
	$("#groupPermission").children().remove();
	$("#groupName").val("");
	$("#groupInfo").val("");
	$.post("mt/permissions/getPermissionTree",null,function(r){			
		if(r.success){
			$.each(r.data[0].children,function(r){
				permission(this);
			});
		}
});
	
//构建权限树
function permission(d){
    List ="<tr class='am-success pclass-"+d.id+"'>"
    +'<td colspan="6"><label class="am-checkbox"><input type="checkbox" id="bx'+d.id+'" name="permissionID" value="'+d.id+'" >'+d.actionName+'</label>'
	+'</td></tr>'
	$("#groupPermission").append(List);
    	 if(d.children && d.children.length > 0){
    		$.each(d.children,function(){
    		List ='<td><label class="am-checkbox children-'+this.id+'" ><input type="checkbox" onclick="checkPbox(id='+this.pid+')" name="permissionID" id="bx'+this.id+'" value="'+this.id+'" >'+this.actionName+'</label>'
   			+'</td>'
   			$("#groupPermission").append(List);
    		});
    	}  
}
	
/**
 * 查看分组权限
 */
 if(id != null){
	data={'id':id}
	$.post("mt/userGroups/selGroupInfo",data,function(r){
		$("#groupName").val(r.data.groupName);
		$("#groupInfo").val(r.data.groupInfo);
		$.each(r.data.groupPermission,function(i,value){
			if(value.permissionId != "1"){
			$("#bx"+value.permissionId).attr("checked",true);
			}
		})
	})
 }
	
  $("#dialog").modal('show');
  $("#dialogLabel").html('创建分组');
}

/**
 * 选中子选项框后父选项框被选中
 */
 function checkPbox(pid){
		var obj=document.getElementsByName('permissionID'); 
	    check_val = [];
	    for(k in obj){
	        check_val.push(obj[k].value);
	    }
	    $.each(check_val,function(i,permission){
	    	if(pid == permission){
	    		$("#bx"+permission).attr("checked",true);
	    	}
	    })
}

/**
 * 删除权限组
 */
function doDelGroups(id){
	$.post("mt/userGroups/remove",{'id':id},function(r){
		if(r.success){
			alert("操作成功！")
    		window.location.reload();
		}else{
			alert("操作失败！")
		}
	});
}
 
 
</script>
<jsp:include page="./editor.jsp"></jsp:include>
</body>
</html>