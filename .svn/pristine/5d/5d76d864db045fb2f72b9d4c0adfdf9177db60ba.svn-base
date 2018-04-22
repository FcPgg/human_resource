<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html class="no-js">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<%@ include file="../../common.jsp"%>
	<link href="static/assets/countDate/css/jquery.circliful.css" rel="stylesheet" type="text/css" />
    <script src="static/assets/countDate/js/jquery.circliful.min.js"></script>
    <script src="static/assets/countDate/js/count.js"></script>
    <script type="text/javascript" src="static/amaze/assets/js/jquery.tips.js"></script>
	<style>
			.allMoneys{
				margin:0 auto;
				font-family:"Microsoft Yahei";
				font-size:60px;
				color:#333;
				margin-top:20px;
				text-align:center;
			}
			.amountMoney{
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
					<h4 class="lighter"><i class="icon-signal"></i> 账户统计</h4>
					<div class="widget-toolbar">
						<a href="#" data-action="collapse"><i class="icon-chevron-up"></i>
						</a>
					</div>
				</div>
				<div class="infobox infobox-blue2" style="width: 380px; height: 220px;">
					<div class="infobox-data" style="left: 60px; top:10px;">
						<span class="infobox-text" style="font-size:30px;">平台全部金额(元)</span>
						<input type="text" style="display:none" value="" id="allMoneys"/>
					</div>
					<div class="allMoneys">
					</div>
				</div>
				<div class="infobox infobox-blue2" style="width: 380px; height: 220px;">
					<div class="infobox-data" style="left: 60px; top:10px;">
						<span class="infobox-text" style="font-size:30px;">平台可提现金额(元)</span>
						<input type="text" style="display:none" value="" id="amountMoney"/>
					</div>
					<div class="amountMoney">
					</div>
					<button type="button" style="margin-left: 150px; margin-top:15px;" class="am-btn am-btn-secondary"onclick="withdrawalsPage()">提现</button>
				</div>
			</div>
			<div class="am-btn-group am-btn-group-xs">
				<button type="button" id="reload" class="am-btn am-btn-default">
				<span class="am-icon-plus"></span> 刷新
				</button>
			</div>
		</div>
	</div>
 </body>
   <script>
	   /**
		 *平台账户全部余额
		 */
		$.post("mt/mtPlatformCapitalTradeLog/platformAllMoney", null,function(r) {
		    $(".allMoneys").numberRock({
		        speed: 5,
		        count: r.data
		    })
		})
		/**
		 *平台账户可提现余额
		 */
		$.post("mt/mtPlatformCapitalTradeLog/platformWithdrawalsMoney", null,function(r) {
		    $(".amountMoney").numberRock({
		        speed: 5,
		        count: r.data
		    })
		    if (r.success) {
		        $("#moneyAccount").val(r.data);
		    } 
		})
		
		$(document).ready(function() {
		    $('#sellerStat').circliful();
		    $('#goodsStat').circliful();
		});
		
		//商家提现page
		function withdrawalsPage() {
		    $("#withdrawals").modal("show");
		    $("#dialogLabel").html('平台提现');
		}
		
		//刷新当前页
		$(document).ready(function() {
		    $("#reload").click(function() {
		        location.reload();
		    });
		});
   </script>
    <jsp:include page="./platform_withdrawals.jsp"></jsp:include>
</html>