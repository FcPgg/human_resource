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
			<input id="sellerId" style="display: none;" value="<%= currentUser != null ? currentUser.getSellerId() : null%>"/>
			
			<div class="am-panel am-panel-default">
			  <div class="am-panel-hd">商家账户
			  </div>  	
			
		<div class=" admin-content">     
			<div class="am-panel am-panel-default">
			  <div class="am-panel-bd">
			  	<hr/>
		          <table class="am-table am-table-bordered am-table-radius am-table-striped table-condensed  table-striped">
		            <thead >
		              <tr class="am-default " id="apply-table-head">
			                <th class="name" style="width: 150px;">商家名称</th>
			                <th class="catName" style="width: 150px;">商家分类</th>
			                <th class="reaponsiblePeson" style="width: 150px;">负责人</th>
			                <th class="idNumber" style="width: 150px;">身份证号</th>
		                 	<th class="bankAccount" style="width: 150px;">银行卡号</th>
		                  	<th class="province" style="width: 150px;">省份</th>		
		                 	<th class="city" style="width: 150px;">城市</th>
		                    <th class="district" style="width: 150px;">县份</th>
		                    <th class="address" style="width: 150px;">地址</th>
		                    <th class="phoneNumber" style="width: 150px;">电话</th>
		                    <th class="applyTime" style="width: 150px;">申请时间</th>
		                    <th class="remark" style="width: 150px;">备注</th>
		                    <th class="statusName" style="width: 150px;">状态</th>
		                    <th class="failReason" style="width: 150px;">不通过原因</th>
		                    <th width="163px">操作</th>
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
	
	$.post("mt/sellerSettledApply/listNormalSellerApply", params, function(r){				
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

//构建商品列表
function applyList(d){
	 $.each(d, function(){
	 	var tr = "<tr class='"+(this.status == 3 ? 'am-danger' : (this.status == 0 ? 'am-warning':'am-primary'))+"'>"
		var item = this; 
	 	$.each($("#apply-table-head").children(), function(){
	 		if($(this).attr("class") != null){
		 		var td = "<td style='" + ($(this).attr("style") != null ? $(this).attr("style") : "") + "' class='" + $(this).attr("class") + "'>"
		 		td += (item[$(this).attr("class")] != null ? item[$(this).attr("class")] : "");
		 		td += "</td>";
		 		tr += td;
	 		}
	 	});
	 	tr += '<td><div class="am-btn-group am-btn-group-xs">';
	 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-success am-round" onclick="Examination(id = '+this.id+')" title="商家审核"><span class="am-icon-pencil-square-o"></span> </button>';
	 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="移除" );"><span class="am-icon-times"></span></button>';
	 	tr += '</div></td>';
	 	tr += "</tr>";
		$("#applyList").append(tr);
	  });
}

function Examination(id){
	$.post("mt/sellerSettledApply/getApplyInfo", {"id":id}, function(r){	
		   $("#applyId").val(r.data.id)
		   $("#name").text(r.data.name);
		   $("#catName").text(r.data.catName);
		   $("#responsiblePeson").text(r.data.reaponsiblePeson);
		   $("#idNumber").text(r.data.idNumber);
		   $("#bankAccount").text(r.data.bankAccount);
		   $("#province").text(r.data.province);
		   $("#city").text(r.data.city);
		   $("#district").text(r.data.district);
		   $("#address").text(r.data.address);
		   $("#phoneNumber").text(r.data.phoneNumber);
		   $("#applyTime").text(r.data.applyTime);
		   $("#lng").text(r.data.lng);
		   $("#lat").text(r.data.lat);
		   $("#synopsis").text(r.data.synopsis);
		   
           $("#returnOrderPhoto").children().remove();
			$.each(r.data.applyAttachment, function(i){
 				var data = this;
 				list ='<div class="example col-xs-3 col-md-3" onclick="showPhoto()">'
 				+'<p><img src="showMaterials?uuid='+this.attachementsFile+'&fileType='+this.fileType+'"  class="img-rounded" alt=""></p>'
 				+'</div>'
				$("#returnOrderPhoto").prepend(list);
 			});
			if(r.data.status == '0'){
				 $("#agree").show();
				 $("#disagree").show();
				 $("#Content").show();
			}else{
				 $("#agree").hide();
				 $("#disagree").hide();
				 $("#Content").hide();
			}
		
	});	
	
	$("#dialog").modal('show');
    $("#dialogLabel").html('商家入驻申请详情');
}

</script>

<jsp:include page="./apply_info.jsp"></jsp:include>	
</html>