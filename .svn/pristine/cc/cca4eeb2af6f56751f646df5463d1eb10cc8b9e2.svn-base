<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="../../common.jsp"%>
   <link rel="stylesheet" href="static/suggest/src/jquery.typeahead.css">
    <script src="static/suggest/src/jquery.typeahead.js"></script>
</head>
<body>
</head>
<body>
<div class="am-cf admin-main"> 
<div class=" admin-content">     
</div>
<div class="admin-biaogelist" style="left :0;top:0">
	
    <div class="listbiaoti am-cf">
      <ul class="am-icon-flag on">积分商品订单列表</ul>
    </div>
	
	<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
</div>
    <form class="am-form am-g">
          <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
              <tr class="am-success" id="goods-table-head">
                        <th class="receivor">收货人</th>
                        <th class="address">收货地址</th>
                        <th class="phoneNumber">收货人电话</th>
                        <th class="statusName">状态</th>
                        <th class="price">d单价(E币)</th>
                        <th class="exchangeTime">创建时间</th>
                        <th width="163px">操作</th>
              </tr>
            </thead>
            <tbody id="orderList">
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
		
	<script>
		 //积分兑换订单列表
		 $(function(){
			loadData(1);
		});

		function loadData(page){
			
			var params = {page: page, rows: 10};
			
			$.post("mt/mtIntegrateExchangeLog/listNormalIntegrateExchangeLogOrderList", params, function(r){				
				if(r.success){
					if(r.data){
						$("#orderList").children().remove();
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
			 	tr += '<a class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" onclick="selOrderInfo(id = '+this.id+')" title="查看订单详情" data-am-modal="{target: "#my-popups"}"><span class="am-icon-pencil-square-o"></span></a>';
			 	tr += '</div></td>';
			 	tr += "</tr>";
					$("#orderList").append(tr);
			  });
		}	
		 
		 
		 //积分兑换订单详情
		 function selOrderInfo(id){
				data={"id":id}
			 	$.post("mt/mtIntegrateExchangeLog/get",data,function(r){				
			 		if(r.success){
			 			if(r.data){
			 			   $("#orderId").val(id);
                           $("#orderStatusName").text(r.data.statusName);
                           $("#createTime").text(r.data.exchangeTime);
                           $("#trackingNo").text(r.data.trackingNo);
                           $("#streamCompanyNo").text(r.data.trackingCompany);
                           $("#consignee").text(r.data.receivor);
                           $("#address").text(r.data.address);
                           $("#phoneNumber").text(r.data.phoneNumber);
                           $("#remark").text(r.data.remark);
                           $("#goodsList").children().remove();
			 			}
			 			   list ='<tr><td>'+r.data.goodsId+'</td>'
			 			          +'<td>'+r.data.goodName+'</td>'
			 			          +'<td id="number">'+r.data.count+'</td>'
			 			          +'<td id="price">'+r.data.price+'</td>'
			 			          +'<td id="subtotal">'+r.data.price * r.data.count+'</td></tr>'
							$("#goodsList").append(list);
			 		
			 			if(r.data.status == '0'){
			 				 $("#delivery").show();
			 				 $("#expFrom").show();
			 			}else{
			 				$("#delivery").hide();
			 				$("#expFrom").hide();
			 				}
			 		}
			  })
			$("#dialog").modal('show');
		    $("#dialogLabel").html('订单详情');
		 }
		 </script>
		<script>
        data = {"dictionaryId":7}
		$.post("admin/sysDictionaryDatas/getDictionaryByDictId",data,function(r){
		    var datas = [];
			$.each(r.data, function(i){
				datas.push(this.description)
			}) 
				typeof $.typeahead === 'function' && $.typeahead({
					input: ".js-typeahead",
					minLength: 1,
					maxItem: 15,
					order: "asc",
					hint: true,
					group: {
						template: "{{group}} beers!"
					},
					maxItemPerGroup: 5,
					backdrop: {
						"background-color": "#fff"
					},
					href: "/beers/{{group}}/{{display}}/",
					emptyTemplate: '没有此结果 "{{query}}"',
					source: {
						
						"快递结果":{
							data:datas
						}
					},
					callback: {
						onClickAfter: function (node, a, item, event) {
							event.preventDefault();
						}
					},
					debug: true
				});
		})
		</script>
		
		<!-- 展开table -->
            <script type="text/javascript">
          /*   $(function(){
            	 $('tr.parent').click(function(){   // 获取所谓的父行
            	   $(this)
            	    .toggleClass("selected")   // 添加/删除高亮
            	    .siblings('.child_'+this.id).toggle();  // 隐藏/显示所谓的子行
            	 }).click();
            	}) */
            	function toggle(id){
             	  $("#child_"+id).toggle(3);
          }
		</script>
            
     <jsp:include page="./info.jsp"></jsp:include>	
</body>
</html>