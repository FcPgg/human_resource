<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="../../common.jsp"%>
<script src="static/amaze/assets/js/mt/adminMenu.js"></script>
</head>
<body>

</head>

<body>
<div class="am-cf admin-main">
  <div class=" admin-content">
    
    <div class="admin-biaogelist" style="top: 0px; left: 0px;">
      <div class="listbiaoti am-cf">
        <ul class="am-icon-flag on">
                           商品分类管理
        </ul>
        
        <dl>
          <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus" onclick="updateCategory()"  style="margin-left:92.5%;">添加商品分类</button>
        </dl>
        
      </div>
      <form class="am-form am-g">
        <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped am-table-hover">
          <thead>
            <tr class="am-success" id="ad-table-head">
              <th class="id" style="display: none;">ID</th>
              <th class="catName">分类名称</th>
              <th class="sortOrder">顺序</th>
              <th class="settlementFee">入驻费</th>
              <th class="logoAttUrl">图标展示</th>
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
      //系统分类列表
		$(function(){
			loadData(1);
			$( "#categorySort" ).spinner({
				max:1000,
				min:0,
				step:1
			});
		});

		function loadData(page){
			
			var params = {page: page, rows: 10};
			
			$.post("mt/mtCategory/listNormalSystemCategory", params, function(r){				
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

		//构建商品列表
		function createGoodsList(d){
			 $.each(d, function(){
				var tr = "<tr>"
				var item = this; "WebRoot/META-INF/views/admin/groups_permission/group.jsp"
			 	$.each($("#ad-table-head").children(), function(){
			 		if($(this).attr("class") != null){
				 		var td = "<td style='" + ($(this).attr("style") != null ? $(this).attr("style") : "") + "' class='" + $(this).attr("class") + "'>"
				 		if("status" == $(this).attr("class")){
				 			td += item["status"] == 0 ? '<i class="am-icon-check am-text-warning"></i>' : '<i class="am-icon-close am-text-primary"></i>';
				 		} else if("logoAttUrl" == $(this).attr("class")){
				 			td += item["logoAttUrl"] ? ("<img src='showImage?uuid=" + item["logoAttUrl"] + "' style='width:80px;height:80px;'/>") : "";
				 		} else {
					 		td += (item[$(this).attr("class")] != null ? item[$(this).attr("class")] : "");
				 		}
				 		td += "</td>";
				 		tr += td;
			 		}
			 	});
			 	tr += '<td><div class="am-btn-group am-btn-group-xs">';
			 	tr += '<a class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="修改系统分类" onclick="doUpdateSystemCategory(id='+this.id+');"><span class="am-icon-pencil-square-o"></span></a>';
			 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除商品" onclick="doDelGoods(id='+this.id+');"><span class="am-icon-trash-o" ></span></button>';
			 	tr += '</div></td>';
			 	tr += "</tr>";
					$("#catList").append(tr);
			  });
		}
		
		//更新APP首页分类
		function updateCategory(){
			$("#categorySort").val(0);
			$("#updateCategory").modal('show');
		    $("#dialogLabel").html('添加APP首页分类');
		}
		
		//修改App首页分类
		function doUpdateSystemCategory(e){
			$("#systemCategoryId").val(e);
			$.post("mt/mtCategory/get",{'id':e},function(r){
				$.each(r.data,function(){
					$("#name").val(r.data.catName);
					$("#categorySort").val(r.data.sortOrder);
					$("#logoAttUrl").val(r.data.logoAttUrl);
				 	$("#logoAttId").val(r.data.logo)
				})
			});
			$("#updateCategory").modal('show');
		    $("#dialogLabel").html('修改APP首页分类');
			
		}
</script>
 <jsp:include page="./editor.jsp"></jsp:include>	
</body>
</html>