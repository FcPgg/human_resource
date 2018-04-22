<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="../../common.jsp"%>
</head>
<body>
</head>
<body>
<div class="am-cf admin-main"> 
<div class=" admin-content">     
</div>
<div class="admin-biaogelist" style="left :-5;top:0">
	
    <div class="listbiaoti am-cf">
      <ul class="">常见疾病治疗方案</ul>
        <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus"  style="margin-top: 1%; margin-left: 70%;"  onclick="saveSystemAd()">添加治疗方案</button>
    </div>
	
	<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
</div>

    <form class="am-form am-g">
          <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
              <tr class="am-success" id="ad-table-head">
                        <th class="adName">名称</th>
                        <th class="catName">分类名称</th>
                        <th class="logoAttUrl">展示图片</th>
                        <th class="symptom">症状</th>
                        <th class="programme">治疗方案</th>
                        <th width="163px">操作</th>
              </tr>
            </thead>
            <tbody id="adList">
            </tbody>
          </table>
             <div id="example" style="text-align: center"> <ul id="pageLimit" class="pagination"></ul> </div>
                 <div class="am-btn-group am-btn-group-xs">
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 刷新</button>
            </div>
          <hr/>
        </form> 

</div> 
</div>


<script type="text/javascript">
$(function(){
	loadData(1);
});

function loadData(page){
	
	var params = {page: page, rows: 10};
	
	$.post("mt/systemAd/listNormalAdvertisement", params, function(r){				
		if(r.success){
			if(r.data){
				$("#adList").children().remove();
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

//构建广告列表
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
		 			td += (item[$(this).attr("class")] != null ? (item[$(this).attr("class")].length>40 ? item[$(this).attr("class")].substring(0,40)+"...": item[$(this).attr("class")]) : "");
		 		}
		 		td += "</td>";
		 		tr += td;
	 		}
	 	});
	 	tr += '<td><div class="am-btn-group am-btn-group-xs">';
	 	/* tr += '<a class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="修改" onclick="doEditAdvertisement(id='+this.id+');"><span class="am-icon-pencil-square-o"></span></a>'; */
	 	tr += '<a class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除" onclick="doDelAd(id='+this.id+');"><span class="am-icon-trash-o" ></span></a>';
	 	tr += '</div></td>';
	 	tr += "</tr>";
			$("#adList").append(tr);
	  });
}

		
 function saveSystemAd(){
	$("#dialog").modal('show');
    $("#dialogLabel").html('发布治疗方案');
 }
 
 function doEditAdvertisement(id){
    data={'id':id}
    $.post("mt/systemAd/getAdvertisementInfoById",data,function(r){
    	if(r.success){
    		 $("#name").val(r.data.adName),
           	 $("#startTime").val(r.data.startTime),
           	 $("#endTime").val(r.data.endTime)
           	 $.each(r.data.adLink, function() {
           		 
           	 });
    		
    	}
    })
	$("#dialog").modal('show');
    $("#dialogLabel").html('发布治疗方案'); 
 }

 function doDelAd(id){
    $.post("mt/systemAd/remove",{"id":id},function(r){
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