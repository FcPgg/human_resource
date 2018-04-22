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
<div class="admin-biaogelist" style="left :0;top:0">
	
    <div class="listbiaoti am-cf">
      <ul class="am-icon-flag on">平台资金记录表</ul>
    </div>
	
	<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
</div>

    <form class="am-form am-g">
          <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
              <tr class="am-success" id="ad-table-head">
                        <th class="source">来源</th>
                        <th class="target">去向</th>
                        <th class="amount">金额</th>
                        <th class="tradeTime">交易时间</th>
                        <th class="remark">备注</th>
              </tr>
            </thead>
            <tbody id="platformLog">
            </tbody>
          </table>
             <div id="example" style="text-align: center"> <ul id="pageLimit" class="pagination"></ul> </div>
               <div class="am-btn-group am-btn-group-xs">
                <button type="button" class="am-btn am-btn-default" id="reload"><span class="am-icon-plus"></span> 刷新</button>
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
	$.post("mt/mtPlatformCapitalTradeLog/listNormalPlatformCapitalTradeLog", params, function(r){				
		if(r.success){
			if(r.data){
				$("#platformLog").children().remove();
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

//构建平台资金记录列表
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
	 	tr += '</div></td>';
	 	tr += "</tr>";
			$("#platformLog").append(tr);
	  });
}

//刷新当前页
$(document).ready(function () {
	$("#reload").click(function () {
		location.reload();
	});
});
 </script>
            
</body>
</html>