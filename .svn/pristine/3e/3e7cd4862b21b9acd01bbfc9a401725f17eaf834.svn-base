<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ include file="../../common.jsp"%>
<link href="static/assets/countDate/css/jquery.circliful.css" rel="stylesheet" type="text/css"/>
<script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
<script src="static/assets/countDate/js/jquery.circliful.min.js"></script>
<script src="static/assets/countDate/js/count.js"></script>
<style>
		.surplusMoneys{
			margin:0 auto;
			font-family:"Microsoft Yahei";
			font-size:60px;
			color:#333;
			margin-top:20px;
			text-align:center;
		}
</style>
</head>
<body>
<div class=" admin-content">
	<input id="sellerId" style="display: none;" value="<%= currentUser != null ? currentUser.getSellerId() : null%>"/>
	<div class="am-panel am-panel-default">
		<div class="am-panel-hd">
			商家账户
		</div>
		<div class="am-panel-bd">
			<div class="widget-header widget-header-flat">
				<h4 class="lighter">
				<i class="icon-signal"></i> 账户统计
				</h4>
				<div class="widget-toolbar">
					<a href="#" data-action="collapse"><i class="icon-chevron-up"></i>
					</a>
				</div>
			</div>
			<div class="infobox infobox-blue2" style="width: 380px; height: 220px;">
				<div class="infobox-progress">
					<div id="sellerStat" data-dimension="190" data-text="35%" data-info="剩余" data-width="15" data-fontsize="38" data-percent="15" data-fgcolor="#61a9dc" data-bgcolor="#eee" data-fill="#ddd">
					</div>
				</div>
				<div class="infobox-data" style="left: 140px; top: 75px;">
					<span class="infobox-text">商家置顶</span>
					<div class="infobox-content">
						<span class="bigger-110">~</span> 总次数 6000次，剩余25次
					</div>
				</div>
			</div>
			<div class="infobox infobox-blue2" style="width: 380px; height: 220px;">
				<div class="infobox-progress">
					<div id="goodsStat" data-dimension="190" data-text="79%" data-info="剩余" data-width="15" data-fontsize="38" data-percent="79" data-fgcolor="#7ea568" data-bgcolor="#eee" data-fill="#ddd">
					</div>
				</div>
				<div class="infobox-data" style="left: 140px; top: 75px;">
					<span class="infobox-text">商品置顶</span>
					<div class="infobox-content">
						<span class="bigger-110">~</span> 总次数 1000次，剩余25次
					</div>
				</div>
			</div>
			<div class="infobox infobox-blue2" style="width: 380px; height: 220px;">
				<div class="infobox-data" style="left: 70px; top:10px;">
					<span class="infobox-text" style="font-size:30px;">商家E币余额</span>
					<input type="text" style="display:none" value="" id="surplusMoney"/>
				</div>
				<div class="surplusMoneys">
				</div>
			</div>
		</div>
	</div>
	<div class=" admin-content">
		<div class="am-panel am-panel-default">
			<div class="am-panel-hd" style="height: 40px;">
				商家账户记录
			</div>
			<div class="am-panel-bd">
				<hr/>
				<table class="am-table am-table-bordered am-table-radius am-table-striped table-condensed table-striped">
				<thead>
				<tr class="am-default " id="goods-table-head">
					<th class="source am-text-center" style="width: 150px;">
						资金流向
					</th>
					<th class="amount am-text-center" style="width: 150px;">
						交易金额（E币）
					</th>
					<th class="tradeTime am-text-center" style="width: 150px;">
						交易时间
					</th>
					<th class="operator am-text-center" style="width: 150px;">
						操作人
					</th>
					<th class="remark am-text-center" style="width: 150px;">
						备注
					</th>
				</tr>
				</thead>
				<tbody id="accountLogList">
				</tbody>
				</table>
				<div id="example" style="text-align: center">
					<ul id="pageLimit" class="pagination">
					</ul>
				</div>
			</div>
		</div>
	</div>
</div>
</body>
<script>
$( document ).ready(function() {
	$('#sellerStat').circliful();
	$('#goodsStat').circliful();
 });
$(function(){
	loadData(1);
});
function loadData(page){
	var params = {page: page, rows: 10};
    params.sellerId = $("#sellerId").val();
	$.post("mt/sellerAccountTradeLog/getAccountTradeLogBySellerId", params, function(r){				
		if(r.success){
			if(r.data){
				$("#goodsList").children().remove();
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
	 $.each(d, function(i){
		 console.log(d.creditOrder);
		 var status = null;
		 var moneyFlow = null;
		 if(this.source != null){
			 moneyFlow = this.source;
		 }else{
			 moneyFlow = this.target;
		 }
		 list = '<tr class="am-text-center"><td><a>'+moneyFlow+'</a></td>'
		 +'<td>'+this.amount+'</td>'
		 +'<td>'+this.tradeTime+'</td>'
	        +'<td class="am-hide-sm-only">'+this.operator+'</td>'
	        +'<td class="am-hide-sm-only"></td>'
	        +'</td></tr>'
	        +'</tr>'
		 $("#accountLogList").append(list);
	  });
}
/**
 * 获取商家账户余额
 */
 $.post("mt/sellerAccountTradeLog/getAcountSurplusMoeny",{sellerId:$("#sellerId").val()},function(r){
	 $(".surplusMoneys").numberRock({
 	    speed:5,
 	    count:r.data
 	 })
 })
</script>
</html>