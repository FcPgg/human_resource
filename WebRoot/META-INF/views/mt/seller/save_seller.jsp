<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
<%@ include file="../../common.jsp"%>
<script type="text/javascript" src="static/js/md5.js"></script>
<meta charset="utf-8"/>
<title></title>
<script src="static/amaze/assets/js/mt/seller.js"></script>
<script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=8vr1qAB0Ld5z5BG1fVgWLHWMDNbN0Zrj"></script>
<script type="text/javascript" src="static/assets/Bmap/map.jquery.min.js"></script>
<script type="text/javascript" src="static/amaze/assets/js/jquery.tips.js"></script>
<script src="static/amaze/assets/js/jquery.session.js"></script>
<script src="static/assets/address/js/distpicker.data.js"></script>
<script src="static/assets/address/js/distpicker.js"></script>
<script src="static/assets/address/js/main.js"></script>
</head>
<body>
<style>
	.bMap{position: relative;}
	.bMap .map-warp{position: absolute;left:0;width:100%;height:400px;top:34px;display: none;}
	.bMap input{width:100%;height:40px;line-height: 30px;border:1px solid #d7d7d7;top:5px;}
	.tangram-suggestion-main{z-index: 9999}
</style>
<body>
<input id="currentUserId" style="display: none;" value="<%= currentUser != null ? currentUser.getId() : null%>"/>
<div class="am-cf admin-main">
	<div class=" admin-content">
		<div class="admin-biaogelist" style="left: 0; top: 0">
			<div class="listbiaoti am-cf">
				<ul class="am-icon-flag on">
					栏目名称
				</ul>
				<dl class="am-icon-home" style="float: right;">
						当前位置： 首页 >
					<a href="#">商品列表</a>
				</dl>
			</div>
			<div class="fbneirong">
				<forms class="am-form">
				<h2>商家基础信息</h2>
				<div class="am-u-sm-6">
					<div class="am-form-group am-cf">
						<div class="zuo">
							商家名称：
						</div>
						<div class="you">
							<input type="text" class="am-input-sm" id="name" placeholder="请输入名称（必填）">
						</div>
					</div>
				</div>
				<div class="am-u-sm-6">
					<div class="am-form-group am-cf">
						<div class="zuo">
							商家分类：
						</div>
						<div class="you">
							<div class="am-u-sm-8 am-u-md-10">
								<select id="cat" style="width: 150px; height: 26px; padding-bottom: 0px; padding-top: 0px; margin-left: -11px;">
								</select>
							</div>
						</div>
					</div>
				</div>
				<div class="am-u-sm-6">
					<div class="am-form-group am-cf" style="left: -20%;">
						<div class="zuo">
							负责人：
						</div>
						<div class="you">
							<input type="text" class="am-input-sm" id="peson" placeholder="请输入负责人（必填）">
						</div>
					</div>
				</div>
				<div class="am-u-sm-6">
					<div class="am-form-group am-cf" ">
						<div class="zuo">
							身份证：
						</div>
						<div class="you">
							<input type="text" class="am-input-sm" id="idNumber" placeholder="请输入负责人身份证号（必填）">
						</div>
					</div>
				</div>
				<div class="am-u-sm-6">
					<div class="am-form-group am-cf">
						<div class="zuo">
							银行账户：
						</div>
						<div class="you">
							<input type="text" class="am-input-sm" id="bank" placeholder="请输入银行账户（必填）">
						</div>
					</div>
				</div>
				<div class="am-u-sm-6">
					<div class="am-form-group am-cf">
						<div class="zuo">
							区域：
						</div>
						<div class="you">
							<form class="form-inline">
								<div data-toggle="distpicker">
									<div class="form-group">
										<label class="sr-only" for="province2">Province</label>
										<select class="form-control" id="province" data-province="---- 选择省 ----">
										</select>
									</div>
									<div class="form-group">
										<label class="sr-only" for="city2">City</label>
										<select class="form-control" id="city" data-city="---- 选择市 ----">
										</select>
									</div>
									<div class="form-group">
										<label class="sr-only" for="district2">District</label>
										<select class="form-control" id="district" data-district="---- 选择区 ----">
										</select>
									</div>
								</div>
							</form>
						</div>
					</div>
				</div>
				<div class="am-u-sm-6">
					<div class="am-form-group am-cf">
						<div class="zuo">
							地址：
						</div>
						<div class="you">
							<div class="bMap" id='address'>
							</div>
							<div id="callback">
							</div>
						</div>
					</div>
				</div>
				<div class="am-u-sm-6">
					<div class="am-form-group am-cf"style="left: -280%;">
						<div class="zuo">
							商家电话：
						</div>
						<div class="you">
							<input type="text" class="am-input-sm" id="tel" placeholder="请输入电话（必填）">
						</div>
					</div>
				</div>
				<div class="am-u-sm-6">
					<div class="am-form-group am-cf"style="left: -280%;">
						<div class="zuo">
							商家纬度：
						</div>
						<div class="you">
							<input type="text" class="am-input-sm" id="lat" readonly="true" placeholder="0">
						</div>
					</div>
				</div>
				<div class="am-u-sm-6">
					<div class="am-form-group am-cf"style="left: -280%;margin-top:-4%">
						<div class="zuo">
							商家经度：
						</div>
						<div class="you">
							<input type="text" class="am-input-sm" id="lng" readonly="true" placeholder="0">
						</div>
					</div>
				</div>
				<div class="am-u-sm-6">
					<div class="am-form-group am-cf" style="margin-left: -4%;">
						<div class="zuo">
							备注：
						</div>
						<div class="you" style="margin-left:4%;">
							<input type="text" class="am-input-sm" id="remark" placeholder="请输入备注（选填）">
						</div>
					</div>
				</div>
				<div class="am-g">
					<div class="am-u-sm-8 am-u-sm-centered am-u-lg-uncentered">
						<div class="am-form-group am-cf" style="margin-left: -6%;margin-top:-3%">
							<div class="zuo">
								经营范围：
							</div>
							<div class="you">
								<textarea class="" rows="2" id="business_scope" style="width: 530px;" placeholder="请输入经营范围（必填）"></textarea>
							</div>
						</div>
					</div>
				</div>
				<div class="am-form-group am-cf">
					<div class="you" style="margin-left: 11%;">
						<button type="submit" class="am-btn am-btn-success am-radius" id="saveSeller"style="margin-left: -46;">发布</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</div>
</div>
<script type="text/javascript">
	$(function () {
		$.post("mt/mtCategory/list", null, function (r) {
			if (r.success) {
				if (r.data) {
					$("#cat").children().remove();
					console.log(r.data[0]);
					goodsList(r.data);
				}
			}
		});
		//构建分类列表
		function goodsList(d) {
			$.each(d, function () {
				console.log(d);
				list = '<option value=' + this.id + '>' + this.catName + '</option>'
				$("#cat").append(list);
			});
		}
	});

	function romves() {
		$("#goodsSpaceCopy").remove();
	}
	
	$(function () {
		$("#address").bMap({
			name: "callback",
			callback: function (address, point) {
				$("#lng").val(point.lng);
				$("#lat").val(point.lat);
			}
		});
	});
</script>
</body>
</html>