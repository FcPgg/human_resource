<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <ul class="am-icon-flag on">退款单列表</ul>
      
    </div>
	
	<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
</div>

<input id="currentUserId" style="display: none;" value="<%= currentUser != null ? currentUser.getId() : null%>"/>
    <form class="am-form am-g">
          <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
              <tr class="am-success" id="goods-table-head">
                <th class="goodsName">退款商品</th>
                <th class="count">数量</th>
                <th class="createTime">创建时间</th>
                <th class="statusName">状态</th>
                <th width="163px">操作</th>
              </tr>
            </thead>
            <tbody id="refundList">
            </tbody>
          </table>
          <div id="example" style="text-align: center"> <ul id="pageLimit" class="pagination"></ul> </div>
            <div class="am-btn-group am-btn-group-xs">
              <button type="button" id="reload" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 刷新</button>
            </div>
          
          <hr/>
        </form> 

   </div>
</div>

	<script>
		
		//退款列表
	       $(function(){
				loadData(1);
			});

			function loadData(page){
				
				var params = {page: page, rows: 10};
				
				params.sellerId = $("#sellerId").val();
				
				$.post("mt/mtCreditOrder/listNormalRefundList", params, function(r){				
					if(r.success){
						if(r.data){
							$("#refundList").children().remove();
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
				 	tr += '<a class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="查看退款单详情" onclick="selReturnOrderInfo(creditId = '+this.id+',orderId='+this.orderId+')" data-am-modal="{target: "#my-popups"}" ><span class="am-icon-pencil-square-o"></span></a>';
				 	tr += '</div></td>';
				 	tr += "</tr>";
						$("#refundList").append(tr);
				  });
			}	
		
		 //退货单详情
		 function selReturnOrderInfo(creditId, orderId){
				var data = {"creditId":creditId,"orderId":orderId}
			   $.post("mt/mtCreditOrder/getCreditOrderInfo",data,function(r){
					if (r.success){
						$("#orderCodes").text(r.data.orderInfo.orderCode);
						$("#orderStatusNames").text(r.data.orderInfo.orderStatusName);
						$("#createTimes").text(r.data.orderInfo.createTime);
						$("#payStatusNames").text(r.data.orderInfo.payStatusName);
						$("#paryNos").text(r.data.orderInfo.payNo);
						$("#streamStatusNames").text(r.data.orderInfo.streamStatusName);
						$("#streamCompanyNos").text(r.data.orderInfo.streamCompanyNo);
						$("#trackingNos").text(r.data.orderInfo.trackingNo);
						$("#consignees").text(r.data.orderInfo.consignee);
						$("#addresss").text(r.data.orderInfo.address);
						$("#phoneNumbers").text(r.data.orderInfo.phoneNumber);
						$("#remarks").text(r.data.orderInfo.remark);
						$("#goodsList").children().remove();
						$("#returnOrderPhoto").children().remove();
						
						if(r.data){
							$("#createOrderId").val(r.data.id);
							$("#applicant").text(r.data.applicant);
							$("#createsTime").text(r.data.createTime);
							$("#reason").text(r.data.reason);
							$("#statusName").text(r.data.statusName);
							$("#streamNo").text(r.data.streamNo);
							$("#streamCompany").text(r.data.streamCompany);
							$("#sellerName").text(r.data.sellerName);
							$("#responsiblePeson").text(r.data.responsiblePeson);
							$("#phoneNumber").text(r.data.phoneNumber)
							list = '<tr><td>' + r.data.orderGoodsId+ '</td>'
						        + '<td>'+ r.data.goodsName + '</td>'
								+ '<td id="number">'+ r.data.count + '</td>'
								+ '<td id="price">'+ r.data.price + '</td>'
								+ '<td id="rate">'+ r.data.spec + '</td>'
								+ '<td id="spec">' + r.data.sum+ '</td>'
					    	$("#goodsList").append(list);
							$.each(r.data.attachements,function(i){
								var data = this;
								list = '<div class="example col-xs-3 col-md-3" onclick="showPhoto()">'
										+ '<p><img src="http://www.yiwke.com/Web/showImage?uuid='+ this.photoName+ '&fileType='+ this.photoType+ '" class="img-rounded" alt=""></p>'
										+ '</div>'
								$("#returnOrderPhoto").prepend(list);
							});
						}
						if(r.data.status == '5'){
			 				 $("#refund").show();
			 			}else{
			 				 $("#refund").hide();
			 			}
					}
				})
			$("#dialog").modal('show');
		    $("#dialogLabel").html('退款详情');
		 }
		 
		//刷新当前页
			$(document).ready(function(){
			  $("#reload").click(function(){
				  location.reload();
			  });
			});
			
		 </script>
		
		 <jsp:include page="./refund_info.jsp"></jsp:include>	
</body>
</html>