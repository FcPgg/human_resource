<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<ul class="am-icon-flag on">
				订单列表
			</ul>
		</div>
		<div class="am-btn-toolbars am-btn-toolbar am-kg am-cf">
		</div>
		<input id="sellerId" style="display: none;" value="<%= currentUser != null ? currentUser.getSellerId() : null%>"/>
		<input id="currentUserId" style="display: none;" value="<%= currentUser != null ? currentUser.getId() : null%>"/>
		<form class="am-form am-g">
			<table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
			<thead>
			<tr class="am-success" id="goods-table-head">
				<th class="orderCode">
					订单编号
				</th>
				<th class="consignee">
					收货人
				</th>
				<th class="address">
					收货地址
				</th>
				<th class="phoneNumber">
					收货人电话
				</th>
				<th class="orderStatusName">
					订单状态
				</th>
				<th class="payStatusName">
					付款状态
				</th>
				<th class="streamStatusName">
					物流状态
				</th>
				<th class="price">
					总金额
				</th>
				<th class="createTime">
					创建时间
				</th>
				<th width="163px">
					操作
				</th>
			</tr>
			</thead>
			<tbody id="orderList">
			</tbody>
			</table>
			<div id="example" style="text-align: center">
				<ul id="pageLimit" class="pagination">
				</ul>
			</div>
			<div class="am-btn-group am-btn-group-xs">
				<button type="button" id="reload" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 刷新</button>
			</div>
			<hr/>
		</form>
	</div>
</div>
<script>
	//订单列表
	$(function () {
		loadData(1);
	});

	function loadData(page) {
			var params = {
				page: page,
				rows: 10
			};
			params.sellerId = $("#sellerId").val();
			$.post("mt/mtOrderInfo/getComplexOrder", params, function (r) {
				if (r.success) {
					if (r.data) {
						$("#orderList").children().remove();
						createGoodsList(r.data.data);
						if(r.data.totalPageNum){
							$.jqPaginator('#pageLimit', {
								totalPages: r.data.totalPageNum,
								visiblePages: 10,
								currentPage: page,
								prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
								next: '<li class="next"><a href="javascript:;">下一页</a></li>',
								page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
								onPageChange: function (num, type) {
									if (type == "change") {
										loadData(num);
									}
								}
							});
						}
					}
				}
			});
		}
	//构建订单列表
	function createGoodsList(d) {
			$.each(d, function () {
				var tr = "<tr class='" + (this.orderStatus == 0 && this.payStatus == 1 && this.streamStatus == 0 ? 'am-danger' : (this.orderStatus == 0 && this.payStatus == 1 && this.streamStatus == 1 ? 'am-warning' : 'am-primary')) + "'>"
				var item = this;
				"WebRoot/META-INF/views/admin/groups_permission/group.jsp"
				$.each($("#goods-table-head").children(), function () {
					if ($(this).attr("class") != null) {
						var td = "<td style='" + ($(this).attr("style") != null ? $(this).attr("style") : "") + "' class='" + $(this).attr("class") + "'id='" + $(this).attr("class") + "'  onclick='"+'selOrderInfo(id = ' + this.id + ')'+"'>"
						if ("status" == $(this).attr("class")) {
							td += item["status"] == 0 ? '<i class="am-icon-check am-text-warning"></i>' : '<i class="am-icon-close am-text-primary"></i>';
						} else {
							td += (item[$(this).attr("class")] != null ? item[$(this).attr("class")] : "");
						}
						td += "</td>";
						tr += td;
					}
				});
				tr += '<td><div class="am-btn-group am-btn-group-xs">';
				tr += '<a class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" onclick="selOrderInfo(id = ' + this.id + ')" title="查看订单详情" data-am-modal="{target: "#my-popups"}" ><span class="am-icon-pencil-square-o"></span></a>';
				tr += '</div></td>';
				tr += "</tr>";
				$("#orderList").append(tr);
			});
		}
	
	 
	//订单详情
	function selOrderInfo(id) {
		data = {
			"id": id
		}
		$.post("mt/mtOrderInfo/getComplexOrder", data, function (r) {
			if (r.success) {
				if (r.data) {
					$("#orderId").val(r.data.id);
					$("#orderCodes").text(r.data.orderCode);
					$("#orderStatusNames").text(r.data.orderStatusName);
					$("#createTimes").text(r.data.createTime);
					$("#payStatusNames").text(r.data.payStatusName);
					$("#paryNos").text(r.data.payNo);
					$("#streamStatusNames").text(r.data.streamStatusName);
					$("#trackingNos").text(r.data.trackingNo);
					$("#consignees").text(r.data.consignee);
					$("#addresss").text(r.data.address);
					$("#phoneNumbers").text(r.data.phoneNumber);
					$("#remarks").text(r.data.remark);
					$("#streamCompanyNos").text(r.data.streamCompanyNo);
					$("#paiedTime").text(r.data.paiedTime);
					$("#goodsList").children().remove();
				}
				$.each(r.data.orderGoods, function (i) {
					var data = this;
					var sum = +this.price * this.number * this.rate + this.postage
					$("#sum").text(sum);
					list = '<tr><td>' + this.name + '</td>' + '<td id="number">' + this.number + '</td>' + '<td id="postage">' + this.postage + '</td>' + '<td id="price">' + this.price + '</td>' + '<td id="rate">' + (this.rate != 1 && this.rate != 0 ? this.rate : '无折扣') + '</td>' + '<td id="spec">' + this.spec + '</td>' + '<td id="subtotal">' + this.subtotal + '</td></tr>'
					$("#goodsList").append(list);
				});
				if (r.data.payStatus == '1' && r.data.streamStatus == '0') {
					$("#delivery").show();
					$("#expFrom").show();
				} else {
					$("#delivery").hide();
					$("#expFrom").hide();
				}
			}
		})
		$("#dialog").modal('show');
		$("#dialogLabel").html('订单详情');
	}
	data = {
		"dictionaryId": 7
	}
	$.post("admin/sysDictionaryDatas/getDictionaryByDictId", data, function (r) {
			var datas = [];
			$.each(r.data, function (i) {
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
					"快递结果": {
						data: datas
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
		//刷新当前页
	$(document).ready(function () {
		$("#reload").click(function () {
			location.reload();
		});
	});
</script>
<jsp:include page="./info.jsp"></jsp:include>
</body>
</html>