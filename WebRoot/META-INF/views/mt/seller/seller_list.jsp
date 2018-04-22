<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html class="no-js">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	
	<%@ include file="../../common.jsp"%>
    <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=EZPCgQ6zGu6hZSmXlRrUMTpr"></script>
    
    <style type="text/css">
    .category-dialog .modal-dialog {
	    width: 1500px;
	}
    </style>
</head>
<body >
<div class=" admin-content">     
			<input id="sellerId" style="display: none;" value="<%= currentUser != null ? currentUser.getSellerId() : null%>"/>
			
			<div class="am-panel am-panel-default">
			  <div class="am-panel-hd">商家列表
<!-- 			  <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus" id="SellerSavePage">添加商家</button>-->			
              </div>
			  <div class="am-panel-bd">
		          <table class="am-table am-table-bordered am-table-radius am-table-striped table-condensed  table-striped">
		            <thead >
		               <tr class="am-success" id="goods-table-head">
                        <th class="name">商家名称</th>
                        <th class="address">商家地址</th>
                        <th class="businessScope">经营范围</th>
                        <th class="catName">商家分类</th>
                        <th class="phoneNumber">商家电话</th>
                        <th width="163px">操作</th>
                      </tr>
		            </thead>
		            <tbody id="goodsList">
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
			
			$.post("mt/mtSeller/listNormalSeller", params, function(r){				
				if(r.success){
					if(r.data){
						$("#goodsList").children().remove();
						buildSellerList(r.data.data);
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
		
		//构建商家列表
		function buildSellerList(d){
			 $.each(d, function(){
				var tr = "<tr>"
				var item = this; "WebRoot/META-INF/views/admin/groups_permission/group.jsp"
			 	$.each($("#goods-table-head").children(), function(){
			 		if($(this).attr("class") != null){
				 		var td = "<td style='" + ($(this).attr("style") != null ? $(this).attr("style") : "") + "' class='" + $(this).attr("class") + "'>"
				 		if("status" == $(this).attr("class")){
				 			td += item["status"] == 0 ? '<i class="am-icon-check am-text-warning"></i>' : '<i class="am-icon-close am-text-primary"></i>';
				 		} else {
					 		td += (item[$(this).attr("class")] != null ? item[$(this).attr("class")] : "");
				 		}
				 		td += "</td>";
				 		tr += td;
			 		}
			 	});
			 	tr += '<td><div class="am-btn-group am-btn-group-xs">';
			 	
			 	tr += '<a class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" onclick="edit(sellerId = '+this.id+')" data-am-modal="{target: "#my-popups"}" title="修改商家"><span class="am-icon-paste"></span></a>';

			 	tr += '<a class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" onclick="openEidtor(sellerId = '+this.id+')"><span class="am-icon-pencil-square-o"></span></a>';

			 	tr += '</div></td>';
			 	tr += "</tr>";
					$("#goodsList").append(tr);
			  });
		}	
		
		/**
		*t添加商家
		*/
		$(document).ready(function(){
			  $("#SellerSavePage").click(function(){
				   $("#dialogs").modal("show");
				   $("#dialogLabel").html('添加商家信息');
			  });
		});
		
		/**
		*修改商家
		*/
		function openEidtor(id){
			var url = 'mt/mtSeller/openSellerEditor';
			if(id){
				url += '?id=' + id;
			}
			BootstrapDialog.show({
				title: "修改商家信息",
				width: "1500px",
				cssClass: 'category-dialog',
		           message: $('<div class="dialog-div"></div>').load(url),
		           buttons: [
		            {
		               id: 'btn-ok',   
		               icon: 'glyphicon glyphicon-check',       
		               label: '保存',
		               cssClass: 'btn-primary',
		               action: dialogSubmit
		            }, {
		               label: '关闭',
		               action: function(dialogRef) {
		                   dialogRef.close();//对于对话框内部的实例对象的引用
		               }
		           }]
		       });
		}

		function dialogSubmit(dialogRef){
		   	var form = dialogRef.getModalBody().find("form");
		   	var entity = {};
		  
		   	var entity = {
					id: form.find("#sellerId").val(),
					name: form.find("#name").val(),
					categoryId: form.find("#category").val(),
					phoneNumber: form.find("#tel").val(),
					province: form.find("#province").val(),
					city: form.find("#city").val(),
					district: form.find("#district").val(),
					address: form.find("#address").val(),
					reaponsiblePeson: form.find("#reaponsiblePeson").val(),
					idNumber: form.find("#idNumber").val(),
					bankAccount: form.find("#bank").val(),
					lng:form.find("#lng").val(),
					lat:form.find("#lat").val(),
					remark:form.find("#remark").val(),
					businessScope:form.find("#business_scope").val(),
					synopsis: form.find("#synopsis").val(),
			        reviewed:0
			};
		 
			entity.sellerGallery = [];
			$.each(dialogRef.getModalBody().find("#ulSellerBanner li"), function(){
				if($(this).find(".logo").attr("resourceId") != null && $(this).find(".logo").attr("resourceId") > 0){
					var galler = {
							id: $(this).attr("data-id") <= 0 ? null : $(this).attr("data-id"),
									/* 	sellerId: $(this).attr("sellerId") <= 0 ? null : $(this).attr("sellerId"), */
							sellerId: dialogRef.getModalBody().find("#sellerId").val(),
							attId: $(this).find(".logo").attr("resourceId"),
							sort: $(this).index()
					}
					entity.sellerGallery.push(galler);
				}
			});
			$.post("mt/mtSeller/updateData", {entity: JSON.stringify(entity)}, function(r){
				if(r.success){
					dialogRef.close();
					window.location = window.location;
				} else {
					console.log(r.error);
					alert(r.message);
				}
			});
		}
		</script>
</body>
</html>