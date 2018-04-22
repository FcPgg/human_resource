<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="static/assets/css/bootstrap-slider.min.css"/>
<%@include file="../../common.jsp" %>
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
<input id="currentUserId" style="display: none;" value="<%= currentUser != null ? currentUser.getSellerId() : null%>"/>
<div class="modal-content">
	<div class="modal-body">
		<ul class="nav nav-tabs" role="tablist">
			<li class="active"><a href="#sellerInfo" role="tab" data-toggle="tab">商家基本信息</a></li>
			<li><a href="#sellerGalleryInfo" role="tab" data-toggle="tab">商家相册</a></li>
		</ul>
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane active" id="sellerInfo">
				<form id="sellerInfo" class="form-horizontal" role="form">
					<table class="am-table am-table-bordered am-table-striped am-table-compact0" id="orderInfo">
					<thead class="am-text-center">
					<tr>
						<tb>基本信息</tb>
					</tr>
					</thead>
					<tbody>
					<tr class="am-success">
						<td class="am-text-right am-serif">
							商家名称
						</td>
						<td id="name">
						</td>
						<td class="am-text-right am-serif">
							商家分类
						</td>
						<td id="catName">
						</td>
						<td class="am-text-right am-serif">
							负责人
						</td>
						<td id="peson">
						</td>
					</tr>
					<tr class="am-success">
						<td class="am-text-right am-serif">
							负责人身份证号
						</td>
						<td id="idNumber">
						</td>
						<td class="am-text-right am-serif">
							银行账号
						</td>
						<td id="bank">
						</td>
						<td class="am-text-right am-serif">
							商家电话
						</td>
						<td id="tel">
						</td>
					</tr>
					<tr class="am-success">
						<td class="am-text-right am-serif">
							商家地址
						</td>
						<td id="address" colspan="6">
						</td>
					</tr>
					<tr class="am-success">
						<td class="am-text-right am-serif">
							经营范围
						</td>
						<td id="business_scope" colspan="6">
						</td>
					</tr>
					<tr class="am-success">
						<td class="am-text-right am-serif">
							备注
						</td>
						<td id="postage" colspan="6">
						</td>
					</tr>
					</tbody>
					</table>
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
	</div>
	<!-- /.modal-body -->
	<div class="modal-footer">
		<button type="button" id="btnSubmit" class="btn btn-primary" onclick="editSeller();">保存</button>
		<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	</div>
</div>
<!-- /.modal-content -->
</div>

<jsp:include page="../material_resources/choose_resources.jsp"></jsp:include>
 

 
<script type="text/javascript">

$(function(){
	data={"id":$("#currentUserId").val()}
	$.post("mt/mtSeller/getComplexSeller",data,function(r){
		if(r.success){
			$("#sellerId").text(r.data.id);
			$("#name").text(r.data.name);
			$("#catName").text(r.data.catName);
			$("#peson").text(r.data.reaponsiblePeson);
			$("#idNumber").text(r.data.idNumber);
			$("#bank").text(r.data.bankAccount);
			$("#tel").text(r.data.phoneNumber);
			$("#business_scope").text(r.data.businessScope);
			$("#address").text(r.data.address);
		    $("#lng").text(r.data.lng);
		    $("#lat").text(r.data.lat);
		}
		
		//序列化商家附件图片
		if(r.data.sellerGallery != null && r.data.sellerGallery.length > 0){
			$.each(r.data.sellerGallery, function(i){
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
		/* else{
			$.each($("#ulSellerBanner li"), function(){
				$(this).attr("data-id", r.data.catalogId);
			})
			
		} */
		
	})		
	
})

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

	//保存商家
	function editSeller(){
		var entity = {
				id: $("#currentUserId").text(),
				name: $("#name").text(),
				/* categoryId: $("#category").text(), */
				phoneNumber: $("#tel").text(),
				address: $("#address").text(),
				reaponsiblePeson: $("#peson").text(),
				idNumber: $("#idNumber").text(),
				bankAccount: $("#bank").text(),
				lng:$("#lng").text(),
				lat:$("#lat").text(),
				remark:$("#postage").text(),
				businessScope:$("#business_scope").text(),
		        reviewed:0
		};
		
		entity.sellerGallery = [];
		$.each($("#ulSellerBanner li"), function(){
			if($(this).find(".logo").attr("resourceId") != null && $(this).find(".logo").attr("resourceId") > 0){
				var galler = {
						id: $(this).attr("data-id") <= 0 ? null : $(this).attr("data-id"),
						/* 	sellerId: $(this).attr("sellerId") <= 0 ? null : $(this).attr("sellerId"), */
						sellerId:$("#currentUserId").val(),
						attId: $(this).find(".logo").attr("resourceId"),
						sort: $(this).index()
				}
				entity.sellerGallery.push(galler);
			}
		});
		$.post("mt/mtSeller/updateData", {entity: JSON.stringify(entity)}, function(r){
			if(r.success){
				window.location = window.location;
			} else {
				console.log(r.error);
				alert(r.message);
			}
		});
	}
</script>


