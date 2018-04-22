<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="static/assets/css/bootstrap-slider.min.css"/>
<link rel="stylesheet" href="static/assets/PhotoOpen/css/bootstrap-grid.min.css">
<link rel="stylesheet" href="static/assets/PhotoOpen/dist/zoomify.min.css">
<link rel="stylesheet" href="static/assets/PhotoOpen/css/style.css">
<link rel="stylesheet" href="static/assets/logistics/logistics.css">
<script src="static/assets/PhotoOpen/dist/zoomify.min.js"></script>
<style type='text/css'>
/* Example 1 custom styles */
#ex1Slider .slider-selection {
	background: #BABABA;
}
/* Example 3 custom styles */
#RGB {
	height: 20px;
	background: rgb(128, 128, 128);
}
#RC .slider-selection {
	background: #FF8282;
}
#RC .slider-handle {
	background: red;
}
#GC .slider-selection {
	background: #428041;
}
#GC .slider-handle {
	background: green;
}
#BC .slider-selection {
	background: #8283FF;
}
#BC .slider-handle {
	border-bottom-color: blue;
}
#R, #G, #B {
	width: 300px;
}
</style>
<div class="modal fade" id="dialog" tabindex="-1" role="dialog" aria-labelledby="dialogLabel" aria-hidden="true">
	<div class="modal-dialog " style="width: 1500px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="dialogLabel"></h4>
			</div>
			<input type="hidden" id="createOrderId" value=""/>
			<div class="modal-body">
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="orderInfo">
						<table class="am-table am-table-bordered am-table-striped am-table-compact0" id="orderInfo">
						<thead class="am-text-center">
						<tr>
							<tb>原订单基本信息</tb>
						</tr>
						</thead>
						<tbody>
						<tr class="am-warning">
							<td class="am-text-right am-serif">
								订单号
							</td>
							<td id="orderCodes">
							</td>
							<td class="am-text-right am-serif">
								支付状态
							</td>
							<td id="payStatusNames">
							</td>
							<td class="am-text-right am-serif">
								物流状态
							</td>
							<td id="streamStatusNames">
							</td>
						</tr>
						<tr class="am-warning">
							<td class="am-text-right am-serif">
								订单状态
							</td>
							<td id="orderStatusNames">
							</td>
							<td class="am-text-right am-serif">
								支付单号
							</td>
							<td id="paryNos">
							</td>
							<td class="am-text-right am-serif">
								物流公司
							</td>
							<td id="streamCompanyNos">
							</td>
						</tr>
						<tr class="am-warning">
							<td class="am-text-right am-serif">
								创建时间
							</td>
							<td id="createTimes">
							</td>
							<td class="am-text-right am-serif">
								支付时间
							</td>
							<td id="paiedTime">
							</td>
							<td class="am-text-right am-serif">
								物流单号
							</td>
							<td id="trackingNos">
							</td>
						</tr>
						<tr class="am-warning">
							<td class="am-text-right am-serif">
								收货人
							</td>
							<td id="consignees">
							</td>
							<td class="am-text-right am-serif">
								收货人电话
							</td>
							<td id="phoneNumbers" colspan="4">
							</td>
						</tr>
						<tr class="am-warning">
							<td class="am-text-right am-serif">
								配送地址
							</td>
							<td id="addresss" colspan="6">
							</td>
						</tr>
						<tr class="am-warning">
							<td class="am-text-right am-serif">
								备注
							</td>
							<td id="remarks" colspan="6">
							</td>
						</tr>
						</tbody>
						</table>
						<table class="am-table am-table-bordered am-table-striped am-table-compact0" id="orderInfo">
						<thead class="am-text-center">
						<tr>
							<tb>退货订单信息</tb>
						</tr>
						</thead>
						<tbody>
						<tr class="am-primary">
							<td class="am-text-right am-serif">
								申请退货时间：
							</td>
							<td id="createTime">
							</td>
							<td class="am-text-right am-serif">
								申请人
							</td>
							<td id="applicant">
							</td>
							<td class="am-text-right am-serif">
								退货理由
							</td>
							<td id="reason">
							</td>
						</tr>
						<tr class="am-primary">
							<td class="am-text-right am-serif">
								商品状态
							</td>
							<td id="statusName">
							</td>
							<td class="am-text-right am-serif">
								退货快递
							</td>
							<td id="streamCompanyName">
							</td>
							<td class="am-text-right am-serif">
								退货快递单号
							</td>
							<td id="streamNo">
							</td>
						</tr>
						<tr class="am-primary">
							<td class="am-text-right am-serif">
								物流状态
							</td>
							<td id="expressState" colspan="6">
								<div class="hovertree-trackrcol">
									<div class="hovertree-trackrcol">
										<div class="hovertree-tracklist">
											<ul id="logistics">
											</ul>
										</div>
									</div>
								</div>
							</td>
						</tr>
						<tr class="am-primary">
							<td class="am-text-right am-serif">
								图片
							</td>
							<td id="photo" colspan="6">
								<div class="container">
									<div class="examples">
										<div class="row" id="returnOrderPhoto">
											<div class="example col-xs-3 col-md-3">
												<p>
													<img src="static/assets/PhotoOpen/img/4.jpg" class="img-rounded" alt="">
												</p>
											</div>
										</div>
									</div>
								</div>
							</td>
						</tr>
						</tbody>
						</table>
						<table class="am-table am-table-bordered am-table-striped am-table-compact" id="goodsInfo">
						<thead class="am-text-center">
						<tr>
							<tb>退货商品信息</tb>
						</tr>
						</thead>
						<thead>
						<tr class="am-success">
							<th>
								商品编号
							</th>
							<th>
								商品名称
							</th>
							<th>
								退货数量
							</th>
							<th>
								价格(单价)
							</th>
							<th>
								规格
							</th>
							<th>
								应退金额
							</th>
						</tr>
						</thead>
						<tbody id="goodsList">
						</tbody>
						</table>
						<!-- 订单操作-->
						<table class="am-table am-table-bordered am-table-striped am-table-compact" id="goodsInfo">
						<thead class="am-text-center">
						<tr>
							<tb>退货单操作</tb>
						</tr>
						</thead>
						<thead>
						<tr>
							<td>
								<div class="form-group">
									<label for="lastname" class="col-sm-1 control-label">不同意原因</label>
									<div class="col-sm-11">
										<textarea class="form-control" rows="2" id="reasonContent"></textarea>
									</div>
								</div>
							</td>
						</tr>
						<tr class="am-success">
							<th>
								<button onclick="agree()" id="agrees"class="am-btn am-btn-warning" href="javascript:void(0)"style="display: none;">
								<i class="am-icon-check "></i> 同意退货
								</button>
								<button onclick="disagree()" id="disagrees"class="am-btn am-btn-danger" href="javascript:void(0)"style="display: none;">
								<i class="am-icon-times"></i> 不同意退货
								</button>
								<button onclick="confirm()" id="confirm" class="am-btn am-btn-primary" href="javascript:void(0)"style="display: none;">
								<i class="am-icon-check"></i> 确认收货
								</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							</th>
						</tr>
						</thead>
						</table>
					</div>
					<!-- end of basicInfo -->
				</div>
				<!-- enf of tab content -->
			</div>
			<!-- /.modal-body -->
		</div>
		<!-- /.modal -->
	</div>
	<script>
		function agree() {
			data = {
				'createOrderId' : $("#createOrderId").val(),
				'statusUpdate' : 1
			}
			$.post("mt/mtCreditOrder/agreeReturnOfGoods", data, function(r) {
				if (r.success) {
					alert("操作成功！")
					window.location = window.location;
				}
			})
		}
		//不同意
		function disagree() {
			if ($("#reasonContent").val() == "") {
				alert("请输入不同意原因！")
				return;
			}
			data = {
				'createOrderId' : $("#createOrderId").val(),
				'statusUpdate' : 2,
				'disaggreeReason' : $("#reasonContent").val()
			}
			$.post("mt/mtCreditOrder/disagreeReturnOfGoods", data, function(r) {
				if (r.success) {
					alert("操作成功！")
					window.location = window.location;
				}
			})
		}
		//卖家确认收货
		function confirm() {
			data = {
				'createOrderId' : $("#createOrderId").val(),
				'statusUpdate' : 3
			}
			$.post("mt/mtCreditOrder/goodsReceipt", data, function(r) {
				if (r.success) {
					alert("操作成功！")
					window.location = window.location;
				}
			})
		}
		function showPhoto() {
			$('.example img').zoomify();
		}
	</script>