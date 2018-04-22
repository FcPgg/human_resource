<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="static/assets/css/bootstrap-slider.min.css"/>

<script type="text/javascript" src="static/assets/address/js/distpicker.data.js"></script>
<script type="text/javascript" src="static/assets/address/js/distpicker.js"></script>

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
        .bMap{position: relative;}
		.bMap .map-warp{position: absolute;left:0;width:100%;height:400px;top:34px;display: none;}
		.bMap input{width:100%;height:40px;line-height: 30px;border:1px solid #d7d7d7;top:5px;}
		.tangram-suggestion-main{z-index: 9999}
</style>
	<script>
   $(function(){
	/* $("#address").bMap({name:"callback",callback:function(address,point){
	    $("#lng").val(point.lng);
	    $("#lat").val(point.lat);			
	}}); */
});
	</script>
				<ul class="nav nav-tabs" role="tablist">
					<li class="active"><a href="#basicSellerInfo" role="tab" data-toggle="tab">商家基本信息</a></li>
					<li><a href="#sellerInfo" role="tab" data-toggle="tab">商家基本信息</a></li>
					<li><a href="#sellerGalleryInfo" role="tab" data-toggle="tab">商家相册</a></li>
				</ul>
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="basicSellerInfo">
						<form class="form-horizontal" role="form">
							<!--   <input class="data-id" id="data-id" style="display: none;"/> -->
							<input type="text" style="display:none" id="sellerId" value="${entity.id }"/>
							<div class="form-group">
								<label for="firstname" class="col-sm-1 control-label">名称</label>
								<div class="col-sm-11">
									<input type="text" class="form-control" name="name" value="${entity.name }" id="name" placeholder="请输入商家名称" required>
								</div>
							</div>
							<div class="form-group">
								<label for="lastname" class="col-sm-1 control-label">分类</label>
								<div class="col-sm-11">
									<select id="category" name='categoryId' class="form-control" style="height: 38px;">
									</select>
								</div>
							</div>
								<div id="distpicker" data-toggle="distpicker">
								<div class="form-group">
									<label class="col-sm-1 control-label">省份</label>
									<div class="col-sm-11">
									<select class="form-control" id="province"  data-province="${entity != null ? entity.province : '---- 选择省 ----'}">
									</select>
									</div>
								</div>
								<div class="form-group">
									<label  class="col-sm-1 control-label">城市</label>
									<div class="col-sm-11">
									<select class="form-control" id="city"  data-city="${entity != null ? entity.city : '---- 选择城市 ----'}">
									</select>
									</div>
								</div>
								<div class="form-group">
									<label class="col-sm-1 control-label">地区</label>
									<div class="col-sm-11">
									<select class="form-control" id="district" data-district="${entity != null ? entity.district : '---- 选择地区 ----'}">
									</select>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="lastname" class="col-sm-1 control-label">详细地址</label>
								<div class="col-sm-11">
									<input type="text" class="form-control" id="address" value="${entity.address }" placeholder="详细地址" onchange="onAddressChange()">
								</div>
							</div>
							<div class="form-group" style="display: none">
								<label for="lastname" class="col-sm-1 control-label">经度</label>
								<div class="col-sm-11">
									<input type="text" class="form-control" id="lng" value="${entity.lng }" readonly="readonly">
								</div>
							</div>
							<div class="form-group" style="display: none">
								<label for="lastname" class="col-sm-1 control-label">纬度</label>
								<div class="col-sm-11">
									<input type="text" class="form-control" id="lat" value="${entity.lat }" readonly="readonly">
								</div>
							</div>
							
						</form>
					</div>
					<div role="tabpanel" class="tab-pane" id="sellerInfo">
						<form id="sellerInfo" class="form-horizontal" role="form">
							<div class="form-group">
								<label for="lastname" class="col-sm-1 control-label">负责人</label>
								<div class="col-sm-11">
									<input type="text" class="form-control" id="reaponsiblePeson" value="${entity.reaponsiblePeson }" name='vender' placeholder="请输入负责人">
								</div>
							</div>
							<div class="form-group">
								<label for="lastname" class="col-sm-1 control-label">身份证</label>
								<div class="col-sm-11">
									<input type="text" class="form-control" id="idNumber" value="${entity.idNumber }" placeholder="请输入负责人身份证">
								</div>
							</div>
							<div class="form-group">
								<label for="lastname" class="col-sm-1 control-label">银行账户</label>
								<div class="col-sm-11">
									<input type="text" class="form-control" id="bank" value="${entity.bankAccount }" placeholder="请输入银行账户">
								</div>
							</div>
							<div class="form-group">
								<label for="lastname" class="col-sm-1 control-label">联系电话</label>
								<div class="col-sm-11">
									<input type="text" class="form-control" id="tel" value="${entity.phoneNumber }" placeholder="请输入联系电话">
								</div>
							</div>
						
							<div class="form-group">
								<label for="lastname" class="col-sm-1 control-label">经营范围</label>
								<div class="col-sm-11">
									<textarea class="form-control" rows="2" id="business_scope">${entity.businessScope }</textarea>
								</div>
							</div>
							
							<div class="form-group">
								<label for="lastname" class="col-sm-1 control-label">商家简介</label>
								<div class="col-sm-11">
									<textarea class="form-control" rows="2" id="synopsis">${entity.synopsis }</textarea>
								</div>
							</div>
							
							<div class="form-group">
								<label for="lastname" class="col-sm-1 control-label">备注</label>
								<div class="col-sm-11">
									<input type="text" class="form-control" id="remark" value="${entity.remark }"  placeholder="备注">
								</div>
							</div>
						</form>
					</div>
					<!-- end of basicInfo -->
					<div role="tabpanel" class="tab-pane" id="sellerGalleryInfo" style="height: 200px;">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->
							<div class="row-fluid">
								<ul class="ace-thumbnails" id="ulSellerBanner">
									<li data-id="" seller-id="">
									<div>
										<img alt="商家logo" class="logo" resourceid="" style="height: 150px; width: 150px;" src="">
										<div class="text">
											<div class="inner">
												<a href="javascript:void(0);" data-rel="colorbox" class="cboxElement" onclick="doChooseResources($(this));">
												<i class="icon-zoom-in"></i>
												</a>
											</div>
										</div>
										<div style="text-align: center;">
											商家logo
										</div>
									</div>
									</li>
									<li data-id="" seller-id="">
									<div>
										<img alt="商家视频" class="logo" resourceid="" style="height: 150px; width: 150px;" src="">
										<div class="text">
											<div class="inner">
												<a href="javascript:void(0);" data-rel="colorbox" class="cboxElement" onclick="doChooseResources($(this));">
												<i class="icon-zoom-in"></i>
												</a>
											</div>
										</div>
										<div style="text-align: center;">
											商家视频
										</div>
									</div>
									</li>
									<li data-id="" seller-id="">
									<div>
										<img alt="轮播图一" class="logo" resourceid="" style="height: 150px; width: 150px;" src="">
										<div class="text">
											<div class="inner">
												<a href="javascript:void(0);" data-rel="colorbox" class="cboxElement" onclick="doChooseResources($(this));">
												<i class="icon-zoom-in"></i>
												</a>
											</div>
										</div>
										<div style="text-align: center;">
											轮播图一
										</div>
									</div>
									</li>
									<li data-id="" seller-id="">
									<div>
										<img alt="轮播图二" class="logo" resourceid="" style="height: 150px; width: 150px;" src="">
										<div class="text">
											<div class="inner">
												<a href="javascript:void(0);" data-rel="colorbox" class="cboxElement" onclick="doChooseResources($(this));">
												<i class="icon-zoom-in"></i>
												</a>
											</div>
										</div>
										<div style="text-align: center;">
											轮播图二
										</div>
									</div>
									</li>
									<li data-id="" seller-id="">
									<div>
										<img alt="轮播图三" class="logo" resourceid="" style="height: 150px; width: 150px;" src="">
										<div class="text">
											<div class="inner">
												<a href="javascript:void(0);" data-rel="colorbox" class="cboxElement" onclick="doChooseResources($(this));">
												<i class="icon-zoom-in"></i>
												</a>
											</div>
										</div>
										<div style="text-align: center;">
											轮播图三
										</div>
									</div>
									</li>
									<li data-id="" seller-id="">
									<div>
										<img alt="轮播图四" class="logo" resourceid="" style="height: 150px; width: 150px;" src="">
										<div class="text">
											<div class="inner">
												<a href="javascript:void(0);" data-rel="colorbox" class="cboxElement" onclick="doChooseResources($(this));">
												<i class="icon-zoom-in"></i>
												</a>
											</div>
										</div>
										<div style="text-align: center;">
											轮播图四
										</div>
									</div>
									</li>
									<li data-id="" seller-id="">
									<div>
										<img alt="轮播图五" class="logo" resourceid="" style="height: 150px; width: 150px;" src="">
										<div class="text">
											<div class="inner">
												<a href="javascript:void(0);" data-rel="colorbox" class="cboxElement" onclick="doChooseResources($(this));">
												<i class="icon-zoom-in"></i>
												</a>
											</div>
										</div>
										<div style="text-align: center;">
											轮播图五
										</div>
									</div>
									</li>
								</ul>
							</div>
							<!-- PAGE CONTENT ENDS -->
						</div>
						<!-- 商品相册 -->
					</div>
					<!-- #goodsDetailInfo -->
				</div>
				<!-- enf of tab content -->
<jsp:include page="../material_resources/choose_resources.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		//序列化商家附件图片
		var sellerGallery = ${gallery};
		if(sellerGallery != null && sellerGallery.length > 0){
			$.each(sellerGallery, function(i){
				var data = this;
				
				$.each($("#ulSellerBanner li"), function(){
					if($(this).index() == i){
						$(this).attr("data-id", data.id);
						$(this).attr("seller-id", data.sellerId);
						$(this).find(".logo").attr("resourceId", data.attId);
						$(this).find(".logo").attr("src", data.resourceAccessUrl);
					}
				})
			})
		}
		//获取分类
		$.post("mt/mtCategory/list", null, function(r) {
			if (r.success) {
				if (r.data) {
					$("#category").children().remove();
					$.each(r.data, function() {
						var option = '<option value="' + this.id + '"';
						option += '>' + this.catName + '</option>'
						$("#category").append(option);
						$(".category").append(option);
					});
					$("#category").val("${entity.categoryId}");
				}
			}
		});
		$("#rate").slider({
        	tooltip: 'always'
	    });
	});
	//选择资源文件
	function doChooseResources(e){
		var parent = e.parent().parent().parent();
		$("#btnChooseResources").off("click");
		$("#btnChooseResources").on("click", function(){
			$.each($(".check-resources"), function(){
				if($(this).is(":checked")){
					var resourceId = $(this).parent().parent().attr("data-id");
					var accessUrl = $(this).parent().parent().attr("access-url");
					parent.find(".logo").attr("src", accessUrl);
					parent.find(".logo").attr("resourceId", resourceId);
					$('#chooseResourcesDialog').modal("hide");
				}
			});
		});
		$('#chooseResourcesDialog').modal();
	}
	function onAddressChange(){
		if($("#address").val()){
			var myGeo = new BMap.Geocoder();
			// 将地址解析结果显示在地图上,并调整地图视野
			myGeo.getPoint($("#address").val(), function(point){
				if (point) {
					$("#lng").val(point.lng);
				    $("#lat").val(point.lat);
				} else {
					alert("您填写的地址没有解析到结果，请填写正确的地址");
				}
			}, $("#city").val());
		}
	}
</script>