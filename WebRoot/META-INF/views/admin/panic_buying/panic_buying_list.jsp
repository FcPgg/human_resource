<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html class="no-js">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<%@ include file="../../common.jsp"%>
 
    
</head>
<body >
<div class=" admin-content">     
			<input id="currentUserId" style="display: none;" value="<%= currentUser != null ? currentUser.getId() : null%>"/>
			
			<div class="am-panel am-panel-default">
			  <div class="am-panel-hd">疾病诊断
			  </div>  	
			
			
		 <div class=" admin-content">     
			<div class="am-panel am-panel-default">
			  <div class="am-panel-bd">
			  	<hr/>
		          <table class="am-table am-table-bordered am-table-radius am-table-striped table-condensed  table-striped">
		            <thead >
		              <tr class="am-default " id="apply-table-head">
			            <th class="address">地区</th>
                        <th class="catName">分类名称</th>
                        <th class="season">季节</th>
                        <th class="symptom">症状</th>
                        <th class="describe">描述</th>
                        <th class="name">诊断</th>
                        <th class="programme">治疗方案</th>
                        <th class="createTime">发布时间</th>
                        <th width="103px">操作</th>
		              </tr>
		            </thead>
		            <tbody id="applyList">
		            </tbody>
		          </table>
      				<div id="example" style="text-align: center"> <ul id="pageLimit" class="pagination"></ul> </div>
			  </div>
			</div>
		</div>
	  </div>
	</div>

</body>
<script>
  
	
	
$(function(){
	loadData(1);
});

function loadData(page){
	
	var params = {page: page, rows: 10};
	
	$.post("mt/disease/listNormalDisease", params, function(r){				
		if(r.success){
			if(r.data){
				$("#applyList").children().remove();
				applyList(r.data.data);
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

//构建限时抢商品列表
function applyList(d){
	 $.each(d, function(){
		var tr = "<tr>"
		var item = this; 
	 	$.each($("#apply-table-head").children(), function(){
	 		if($(this).attr("class") != null){
		 		var td = "<td style='" + ($(this).attr("style") != null ? $(this).attr("style") : "") + "' class='" + $(this).attr("class") + "'>"
		 		td += (item[$(this).attr("class")] != null ? (item[$(this).attr("class")].length>20 ? item[$(this).attr("class")].substring(0,10)+"...": item[$(this).attr("class")]) : "");
		 		td += "</td>";
		 		tr += td;
	 		}
	 	});
	 	tr += '<td><div class="am-btn-group am-btn-group-xs">';
	 	tr += '<a class="am-btn am-btn-default am-btn-xs am-text-success am-round" onclick="doUpdatePanicBuying(id = '+this.id+')" title="修改"><span class="am-icon-pencil-square-o"></span> </a>';
	 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="移除" );"><span class="am-icon-times"></span></button>';
	 	tr += '</div></td>';
	 	tr += "</tr>";
		$("#applyList").append(tr);
	  });
}


/**
*t添加商家
*/
$(document).ready(function(){
	  $("#savePanicPage").click(function(){
		   $("#dialogs").modal("show");
		   $("#dialogLabel").html('疾病诊断');
	  });
});


/**
 * 修改限时抢
 */
function doUpdatePanicBuying(id){
	$.post("mt/disease/get",{'id':id},function(r){
		if(r.success){
	       	 $("#address").val(r.data.address),
	       	 $("#catName").val(r.data.catName),
	         $("#season").val(r.data.season),
	       	 $("#symptom").val(r.data.symptom),
			 $("#describe").val(r.data.describe),
			 $("#createTime").val(r.data.createTime),
			 $("#diseaseId").val(r.data.id),
			 $("#attId").val(r.data.attId),
			 $("#categroy").val(r.data.categroy)
			 $('#imgValidateCode').attr("src", 'showImage?uuid='+r.data.logoAttUrl);
			 $("#dialogs").modal("show");
			 $("#dialogLabel").html('疾病诊断');
		}
	})
}
</script>

<jsp:include page="./panic_buying_editor.jsp"></jsp:include>	
</html>