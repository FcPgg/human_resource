<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="../../common.jsp"%>
<script src="static/amaze/assets/js/mt/category.js"></script>
<script type="text/javascript" src="static/amaze/assets/js/jquery.tips.js"></script>
</head>
<body>

<input id="sellerId" style="display: none;" value="<%= currentUser != null ? currentUser.getSellerId() : null%>"/>
<div class="am-cf admin-main">
  
  <div class=" admin-content">
    
    <div class="am-popup am-popup-inner" id="my-popup" >
      <div class="am-popup-hd" >
        <h4 class="am-popup-title">添加商品分类</h4>
        <span data-am-modal-close class="am-close">&times;</span> </div>
      <div class="am-popup-bd">
        <forms class="am-form tjlanmu">
          <div class="am-form-group">
            <div class="zuo">分类名称：</div>
            <div class="you">
              <input type="text" class="am-input-sm" id="categoryName" value="" placeholder="分类名称">
            </div>
          </div>
        
          <div class="am-form-group am-cf">
            <div class="you">
              <p>
                <button id="saveCategory">提交</button>
              </p>
            </div>
          </div>
        </form>
      </div>
    </div>
    </div>
    <div class="admin-biaogelist" style="top: 0px; left: 0px;">
      <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on">
                               商品分类管理
        </ul>
        <dl>
          <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus" onclick="saveCategory()" >添加商品分类</button>
        </dl>
      </div>
      <form class="am-form am-g">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
          <thead>
            <tr class="am-success" id="goods-table-head">
              <th class="categoryName">分类名称</th>
              <th width="163px">操作</th>
            </tr>
          </thead>
          <tbody id="catList">
            
          </tbody>
        </table>
        	<div id="example" style="text-align: center"> <ul id="pageLimit" class="pagination"></ul> </div>
        <hr/>
      </form>
    </div>
  </div>
</div>
<script type="text/javascript">
	
	function saveCategory(){
		  $("#edit").modal("show");
	}
		
		$(function(){
			loadData(1);
		});

		function loadData(page){
			
			var params = {page: page, rows: 10};
			
			params.sellerId = $("#sellerId").val();
			
			$.post("mt/mtSecondLevelCategory/listNormalSellerCategory", params, function(r){				
				if(r.success){
					if(r.data){
						$("#catList").children().remove();
						createGoodsList(r.data.data);
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
		
		//构建商分类列表
		function createGoodsList(d){
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
			 	tr += '<a class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" onclick="editPage(catId = '+this.id+')" data-am-modal="{target: "#my-popups"}" title="修改分类"><span class="am-icon-pencil-square-o"></span></a>';
			 	tr += '<a class="am-btn am-btn-default am-btn-xs am-text-danger am-round"  onclick="deleteCat(catId = '+this.id+')" title="删除分类"><span class="am-icon-trash-o"></span></a>';
			 	tr += '</div></td>';
			 	tr += "</tr>";
					$("#catList").append(tr);
			  });
		}	
		
	//修改分类
	function editPage(id){
		$.post("mt/mtSecondLevelCategory/getCategoryById",{'id':id},function(r){
			$.each(r.data,function(){
				$("#categoryNames").val(r.data.categoryName);
				$("#categoryId").val(r.data.id);
			})
		});
		 $("#edit").modal("show");
	}
	
	//删除分类
	function deleteCat(id){
		$.post("mt/mtSecondLevelCategory/remove",{'id':id},function(r){
			if(r.success){
				alert("操作成功！")
	    		window.location.reload();
			}else{
				alert("操作失败！")
			}
		});
		
	}
</script>
<jsp:include page="./edit.jsp"></jsp:include>
</body>
</html>