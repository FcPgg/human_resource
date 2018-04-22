<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@include file="../../common.jsp"%>
<title>选择素材资源</title>

<script src="static/assets/js/jquery.nestable.min.js"></script>

<script type="text/javascript">
	var baseURL = "mt/mtMaterialCatalog/";

	jQuery(function($) {
		loadCatalogData();
	});

	function loadCatalogData() {
		$.post(baseURL + "getMaterialCatalogBySellerId", {
			sellerId : $("#currentUserId").val()
		}, function(r) {
			if (r.success) {
				if (r.data != null) {
					$("#nestable").children().remove();
					$("#nestable").append(
							'<ol class="dd-list"><li id="rootNode" class="dd-item dd-nodrag" pid="' 
							+ r.data.pid + '" data-id="' 
							+ r.data.id + '"><div class="dd-handle catalog-name">'
									+ r.data.name + '</div></ol></li></ol>');

					if (r.data.children != null) {
						createChildren($("#rootNode"), r.data.children);
					}
					createMenu();
				}
			} else {
				console.log(r.error);
				alert(r.message);
			}
		});
	}

	function createChildren(parentElement, children) {
		var ol = '<ol class="dd-list"></ol>';
		var parent = $(ol).appendTo(parentElement);
		$.each(children, function() {
			var li = $(
					'<li class="dd-item" data-id="' + this.id + '" seller-id="' + this.sellerId + '">' + '<div class="dd-handle">' + '<span class="catalog-name">' + this.name + '</span>' + '<span>'
							+ '<input type="text" class="input-catalog-rename" style="display:none;">' + '</span>' + '</div>' + '</li>').appendTo(parent);

			if (this.children != null && this.children.length > 0) {
				createChildren($(li), this.children);
			}
		});
	}

	//创建目录结构
	function createMenu() {
		$('#nestable').nestable();
		$('.dd-handle ').on('mousedown', function(e) {
			e.stopPropagation();
		});

		$(".dd-handle").on("click", function(e) {
			var current = $(this);
			$.each($(".catalog-name"), function() {
				$(this).removeClass("orange");
			});

			current.find(".catalog-name").addClass("orange");

			$("#title-bar").html(current.find(".catalog-name").html());

			$("#catalogId").val(current.parent().attr("data-id"));

			$("#materialResources").children().remove();

			//目录点击时加载资源
			$.post("mt/mtMaterialResources/getResourceByCatalogId", {
				catalogId : current.parent().attr("data-id")
			}, function(r) {
				if (r.success) {
					if (r.data) {
						$.each(r.data, function() {
							var row = '<li data-id="' + this.id + '" access-url = "' + this.accessUrl + '">';
							row += '<a href="javacript:void(0);" data-rel="colorbox">';
							row += '<img class="access-url" alt="150x150" style="height: 150px;width: 150px;" src="' + this.accessUrl + '">';
							row += '</a>';
							row += '<div style="text-align:center;"><input type="radio" name="resources" class="check-resources"/></div>'
							row += '</li>';
							$("#materialResources").append(row);
						});
					}
				} else {
					console.log(r.error);
					alert(r.message);
				}
			})
		});
	}
</script>
  <input id="currentUserId" style="display: none;" value="<%= currentUser != null ? currentUser.getSellerId() : null%>"/>
<div class="modal fade" id="chooseResourcesDialog" tabindex="-1" role="dialog"
	aria-labelledby="dialogLabel" aria-hidden="true">
	<div class="modal-dialog " style="width: 1200px;">
	
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="dialogLabel">选择资源文件</h4>
			</div>
			<div class="modal-body">
				<div class="row">

					<div class="col-xs-4">

						<div class="widget-box">
							<div class="widget-header header-color-blue2">
								<h4 class="lighter smaller">目录</h4>
							</div>

							<div class="widget-body">
								<div class="dd" id="nestable"></div>
							</div>
						</div>
					</div>
					<!-- end of col-sm-4 -->
					<div class="col-xs-8">
						<div class="page-content">
							<div class="page-header" style="display: inline;">
								<h1>
									<span id="title-bar"></span>
								</h1>
							</div>
							<!-- /.page-header -->

							<div class="row">
								<div class="col-xs-12">
									<!-- PAGE CONTENT BEGINS -->
									<div class="row-fluid">
										<ul class="ace-thumbnails" id="materialResources">

										</ul>
									</div>
									<!-- PAGE CONTENT ENDS -->
								</div>
								<!-- /.col -->
							</div>
							<!-- /.row -->
						</div>
						<!-- /.page-content -->
					</div>
				</div>
				<!-- end of row -->
			</div>
			<!-- /.modal-body -->
			<div class="modal-footer">
				<button id="btnChooseResources" type="button" class="btn btn-primary">确定</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>