<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<%@include file="../../common.jsp" %>
	<title>素材资源</title>
	
	<script src="static/assets/js/jquery.nestable.min.js"></script>
	
	<link type="text/css" rel="stylesheet" href="static/assets/bootstrap-file-upload/css/fileinput.css" />
	<script type="text/javascript" src="static/assets/bootstrap-file-upload/js/fileinput.js"></script>
	<script type="text/javascript" src="static/assets/bootstrap-file-upload/js/locales/zh.js"></script>
	
	<script type="text/javascript" src="static/assets/bootstrap-file-upload/ajaxfileupload.js"></script>
	
	<script type="text/javascript">
	
	var baseURL = "mt/mtMaterialCatalog/";
	
	jQuery(function($){
		loadCatalogData();
	});
	
	function loadCatalogData(){
		$.post(baseURL + "getMaterialCatalogBySellerId",{sellerId:$("#currentUserId").val()}, function(r){
			if(r.success){
				if(r.data != null){
					$("#nestable").children().remove();
					$("#nestable").append('<ol class="dd-list">'
							+'<li id="rootNode" class="dd-item dd-nodrag" pid="'  + r.data.pid + '" data-id="' + r.data.id + '">'
							+'<div class="dd-handle">'
							+'<span class="catalog-name">' + r.data.name + '</span>'
							+'<span>'
								+ '<input type="text" class="input-catalog-rename" style="display:none;">' 
								+ '<button class="btn btn-default btn-rounded btn-sm input-catalog-rename" onclick="doSaveCatalog($(this));" style="display: none">保存</button>'
								+ '<button class="btn btn-danger btn-rounded btn-sm input-catalog-rename" onclick="doCalcelRename($(this));" style="display: none">取消</button>'
							+ '</span>'
							+'<div class="pull-right action-buttons edit-botton">'
								+'<a class="green btnAddSubCatalog" href="javascript:void(0);" data-toggle="tooltip" title="添加子级目录" >'
								+'	<i class="icon-plus-sign bigger-130"></i>'
							+'</div>'
						+'</div>'
							+'</li></ol>');
					
					
					$(".btnAddSubCatalog").off("click");
					$(".btnAddSubCatalog").click(function(e){
						doAddSubCatalog($(this).parent().parent().parent());
					});
					
					if(r.data.children != null){
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
	
	function createChildren(parentElement, children){
		var ol = '<ol class="dd-list"></ol>';
		var parent = $(ol).appendTo(parentElement);
		$.each(children, function(){
			var li = $(
			'<li class="dd-item" data-id="' + this.id + '" seller-id="' + this.sellerId + '">'
				+'<div class="dd-handle">'
					+'<span class="catalog-name">' + this.name + '</span>'
					+'<span>'
						+ '<input type="text" class="input-catalog-rename" style="display:none;">' 
						+ '<button class="btn btn-default btn-rounded btn-sm input-catalog-rename" onclick="doSaveCatalog($(this));" style="display: none">保存</button>'
						+ '<button class="btn btn-danger btn-rounded btn-sm input-catalog-rename" onclick="doCalcelRename($(this));" style="display: none">取消</button>'
					+ '</span>'
					+'<div class="pull-right action-buttons edit-botton">'
						+'<a class="green btnAddCatalog" href="javascript:void(0);" data-toggle="tooltip" title="添加同级目录">'
						+'	<i class="icon-plus bigger-130"></i>'
						+'</a>'
						+'<a class="green btnAddSubCatalog" href="javascript:void(0);" data-toggle="tooltip" title="添加子级目录" >'
						+'	<i class="icon-plus-sign bigger-130"></i>'
						+'</a>'
						+'<a class="blue btnEditCatalog" href="javascript:void(0);" data-toggle="tooltip" title="修改名称" ">'
						+'	<i class="icon-pencil bigger-130"></i>'
						+'</a>'
						+'<a class="red btnRemoveCatalog" href="javascript:void(0);" data-toggle="tooltip" title="删除同级和子级目录" ">'
						+'	<i class="icon-trash bigger-130"></i></a>'
					+'</div>'
				+'</div>'
			+'</li>').appendTo(parent);
			bindEventHanderls();
			
			if(this.children != null && this.children.length > 0){
				createChildren($(li), this.children);
			}
		});
	}

	//创建目录结构
	function createMenu(){
		$('#nestable').nestable();
		$('.dd-handle ').on('mousedown', function(e){
            e.stopPropagation();
        });
		
		$(".dd-handle").on("click", function(e){
			var current = $(this);
			$.each($(".catalog-name"), function(){
				$(this).removeClass("orange");
			});
			
			current.find(".catalog-name").addClass("orange");
			
			$("#title-bar").html(current.find(".catalog-name").html());
			
			$("#catalogId").val(current.parent().attr("data-id"));
			
			$("#materialResources").children().remove();
			
			//目录点击时加载资源
			$.post("mt/mtMaterialResources/getResourceByCatalogId", {catalogId: current.parent().attr("data-id")}, function(r){
				if(r.success){
					if(r.data){
						$.each(r.data, function(){
							var row = '<li data-id="' + this.id + '">';
								row += '<a href="' + this.accessUrl + '" data-rel="colorbox">';
								row += '	<img alt="150x150" style="height: 150px;width: 150px;" src="' + this.accessUrl + '">';
								row += '<div class="text">';
								row += '<div class="inner">' + this.srcFileName + '</div>';
								row += '</div>';
								row += '</a>';
								row += '<div class="tools tools-bottom">';
								row += '	<a href="javascript:void(0);" onclick="doRemoveResources($(this));">';
								row += '	<i class="icon-remove red"></i>';
								row += '</a>';
								row += '</div>';
								row += '</li>';
								$("#materialResources").append(row);
						});
					}
				} else{
					console.log(r.error);
					alert(r.message);
				}
			})
		});

		$("[data-toggle='tooltip']").tooltip(); 
	}
	
	function bindEventHanderls(){
		$(".btnAddCatalog").off("click");
		$(".btnAddCatalog").on("click", doAddCatalog);
		
		$(".btnAddSubCatalog").off("click");
		$(".btnAddSubCatalog").click(doAddSubCatalog);
	}
	
	//开启编辑模式
	function editMaterialCatalog(){
		$("#btnEdit").hide();
		$("#btnCancel").show();
		$(".edit-botton").show();
	}
	
	//取消编辑
	function doCancel(){
		$("#btnEdit").show();
		$("#btnCancel").hide();
		$(".edit-botton").hide();
		/* window.location = window.location; */
	}
	
	//添加同级目录
	function doAddCatalog(e){
		var li = $(
				'<li class="dd-item" data-id="0" seller-id="0">'
					+'<div class="dd-handle">'
						+'<span class="catalog-name">' + '新建目录' + '</span>'
						+'<span>'
							+ '<input type="text" class="input-catalog-rename" value="新建目录" style="display:none;">' 
							+ '<button class="btn btn-default btn-rounded btn-sm input-catalog-rename" onclick="doSaveCatalog($(this));" style="display: none">保存</button>'
							+ '<button class="btn btn-danger btn-rounded btn-sm input-catalog-rename" onclick="doCalcelRename($(this));" style="display: none">取消</button>'
						+ '</span>'
						+'<div class="pull-right action-buttons edit-botton">'
							+'<a class="green btnAddCatalog" href="javascript:void(0);" data-toggle="tooltip" title="添加同级目录">'
							+'	<i class="icon-plus bigger-130"></i>'
							+'</a>'
							+'<a class="green btnAddSubCatalog" href="javascript:void(0);" data-toggle="tooltip" title="添加子级目录" >'
							+'	<i class="icon-plus-sign bigger-130"></i>'
							+'</a>'
							+'<a class="blue btnEditCatalog" href="javascript:void(0);" data-toggle="tooltip" title="修改名称" ">'
							+'	<i class="icon-pencil bigger-130"></i>'
							+'</a>'
							+'<a class="red btnRemoveCatalog" href="javascript:void(0);" data-toggle="tooltip" title="删除同级和子级目录" ">'
							+'	<i class="icon-trash bigger-130"></i></a>'
						+'</div>'
					+'</div>'
				+'</li>').appendTo($(this).parent().parent().parent().parent());
		
		bindEventHanderls();
		
		li.find(".catalog-name").hide();
		li.find(".input-catalog-rename").show();
		li.find(".edit-botton").show();
	}
	
	//添加子目录
	function doAddSubCatalog(){
		var li = $(this).parent().parent().parent();
		var parent = null;
		if(li.find(".dd-list").length > 0){
			parent = li.children(".dd-list"); 
		} else {
			parent = $('<ol class="dd-list"></ol>').appendTo(li);
		}
		var sub = $(
				'<li class="dd-item" data-id="0" seller-id="0">'
					+'<div class="dd-handle">'
						+'<span class="catalog-name">' + '新建目录' + '</span>'
						+'<span>'
							+ '<input type="text" class="input-catalog-rename" style="display:none;">' 
							+ '<button class="btn btn-default btn-rounded btn-sm input-catalog-rename" onclick="doSaveCatalog($(this));" style="display: none">保存</button>'
							+ '<button class="btn btn-danger btn-rounded btn-sm input-catalog-rename" onclick="doCalcelRename($(this));" style="display: none">取消</button>'
						+ '</span>'
						+'<div class="pull-right action-buttons edit-botton">'
							+'<a class="green btnAddCatalog" href="javascript:void(0);" data-toggle="tooltip" title="添加同级目录">'
							+'	<i class="icon-plus bigger-130"></i>'
							+'</a>'
							+'<a class="green btnAddSubCatalog" href="javascript:void(0);" data-toggle="tooltip" title="添加子级目录" >'
							+'	<i class="icon-plus-sign bigger-130"></i>'
							+'</a>'
							+'<a class="blue btnEditCatalog" href="javascript:void(0);" data-toggle="tooltip" title="修改名称" ">'
							+'	<i class="icon-pencil bigger-130"></i>'
							+'</a>'
							+'<a class="red btnRemoveCatalog" href="javascript:void(0);" data-toggle="tooltip" title="删除同级和子级目录" ">'
							+'	<i class="icon-trash bigger-130"></i></a>'
						+'</div>'
					+'</div>'
				+'</li>').appendTo(parent);
		
		
		bindEventHanderls(); 
		
		sub.find(".catalog-name").hide();
		sub.find(".input-catalog-rename").show();
		sub.find(".edit-botton").show();
	}
	
	//重命名
	function doReNameCatalog(e){
		var parent = e.parent().parent().parent(); 
		parent.find(".catalog-name").hide();
		parent.find(".input-catalog-rename").show();
	}
	
	//保存重命名
	function doSaveCatalog(e){
		var parent = e.parent().parent().parent();
		parent.find(".catalog-name").html(parent.find(".input-catalog-rename").val());
		parent.find(".catalog-name").show();
		parent.find(".input-catalog-rename").hide();
		var pid = parent.attr("data-id") == 0 ?  parent.parent().parent().attr("data-id") :  parent.attr("data-id");
		var sellerId = 1;
		var catalog = {id: parent.attr("data-id"), sellerId: sellerId, name:parent.find(".catalog-name").html(), pid: pid};
		$.post(baseURL + "update", catalog, function(r){
			if(r.success){
				window.location = window.location;
			} else {
				console.log(r.error);
				alert(r.message);
			}
		});
	}
	
	//取消重命名
	function doCalcelRename(e){
		var parent = e.parent().parent().parent(); 
		parent.find(".catalog-name").show();
		parent.find(".input-catalog-rename").hide();
	}
	
	//删除目录
	function doRemoveCatalog(e){
		var id = $(this).parent().parent().parent().attr("data-id");
		if(confirm("确定删除这个以及子目录吗？此操作不可恢复！")){
			if(id != null && id  > 0){
					$.post(baseURL + "remove",{id:id}, function(r){
						if(r.success){
							window.location = window.location;
						} else {
							console.log(r.error);
							alert(r.message);
						}
					});
				
			} else {
				e.parent().parent().parent().remove();
			}
		}
	}
	
	function doRemoveResources(e){
		var id = e.parent().parent().attr("data-id");
		if(confirm("确定删除这个资源？此操作不可恢复！")){
			$.post("mt/mtMaterialResources/" + "remove",{id:id}, function(r){
					if(r.success){
						e.parent().parent().remove();
					} else {
						console.log(r.error);
						alert(r.message);
					}
				});
		}
	}
	</script>
	
	<style type="text/css">
		.edit-botton{
			display: none;
		}
	</style>
</head>
<body>

<div class="am-cf admin-main">
  <input id="currentUserId" style="display: none;" value="<%= currentUser != null ? currentUser.getSellerId() : null%>"/>
  <div class=" admin-content">
    <div class="admin-biaogelist" style="top: 0px; left: 0px;">
    	<div class="row">
    	
    		<div class="col-xs-4">
    			
	    		<div class="widget-box">
					<div class="widget-header header-color-blue2">
						<h4 class="lighter smaller">目录
							<button id="btnCancel" class="btn btn-app btn-danger btn-sm pull-right" onclick="return doCancel();" style="display: none">取消</button>
							<button id="btnEdit" class="btn btn-app btn-default btn-sm pull-right" onclick="return editMaterialCatalog();">编辑</button>
						</h4>
					</div>
	
					<div class="widget-body">
						<div class="dd" id="nestable">
							
						</div>
					</div>
	   			</div>
    		</div> <!-- end of col-sm-4 -->
    		<div class="col-xs-8">
    			<div class="page-content">
						<div class="page-header" style="display: inline;">
							<h1>
								<span id="seller-name"></span>
								<span>&gt;</span>
								<span id="title-bar"></span>
								<button class="btn btn-app btn-primary btn-sm pull-right" style="margin-top: -5px;" data-toggle="modal" onclick="openUploadDialog();">上传文件</button>
							</h1>
						</div><!-- /.page-header -->

						<div class="row">
							<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->
								<div class="row-fluid">
									<ul class="ace-thumbnails" id="materialResources">
										
									</ul>
								</div><!-- PAGE CONTENT ENDS -->
							</div><!-- /.col -->
						</div><!-- /.row -->
					</div><!-- /.page-content -->
    		</div>
    	</div> <!-- end of row -->
      </div>
    </div>
</div>
<!-- 模态框（Modal） -->
<script type="text/javascript">
$(function(){
	var projectfileoptions = {
        showUpload : false,
        showRemove : false,
        language : 'zh',
        allowedPreviewTypes : [ 'image' ],
        allowedFileExtensions : [ 'jpg', 'png', 'gif' ],
        maxFileSize : 1024
    }
	// 文件上传框
	$('input[class=projectfile]').each(function() {
	    var imageurl = $(this).attr("value");
	
	    if (imageurl) {
	        var op = $.extend({
	            initialPreview : [ // 预览图片的设置
	            "<img src='" + imageurl + "' class='file-preview-image'>", ]
	        }, projectfileoptions);
	
	        $(this).fileinput(op);
	    } else {
	        $(this).fileinput(projectfileoptions);
	    }
	});
});

function openUploadDialog(){
	 if(!$("#catalogId").val()){
		 alert("请先选择目录再上传");
	 } else {
		$("#uploadFileDialog").modal();
	 }
}

</script>
<div class="modal fade" id="uploadFileDialog" tabindex="-1" role="dialog" aria-labelledby="uploadFileDialogLabel" aria-hidden="true">
	<div class="modal-dialog modal-lg" >
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="uploadFileDialogLabel">
					上传文件
				</h4>
			</div>
			<div class="modal-body">
				<form  id="fileForm" class="form-horizontal required-validate" action="fileUpload" enctype="multipart/form-data" method="post" onsubmit="return iframeCallback(this, pageAjaxDone)">
				    <div class="form-group">
				        <div class="col-md-12 tl th">
				            <input id="file" type="file" name="image" multiple="multiple" class="projectfile" value="${deal.image}" />
				            <input id="catalogId" name="catalogId" type="text" class="hidden"/>
				            <p class="help-block">支持jpg、jpeg、png、gif格式，大小不超过1.0M</p>
				        </div>
				    </div>  
				    <div class="form-group text-right">
				        <div class="col-md-10 col-md-offset-1">
				            <button type="button" class="btn btn-primary" onclick="ajaxFileUpload();">上传</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
				        </div>
				    </div>
				</form>    
				<script type="text/javascript">
				 function ajaxFileUpload() {
		            $.ajaxFileUpload({
		                    url: 'qiNiuFileUpload', //用于文件上传的服务器端请求地址
		                    secureuri: false, //是否需要安全协议，一般设置为false
		                    fileElementId: 'file', //文件上传域的ID
		                    dataType: 'JSON', //返回值类型 一般设置为json
		                    data:{catalogId:$("#catalogId").val()},
		                    success: function (r, status){  
			                    //服务器成功响应处理函数
			                    r = JSON.parse(r);
			                    if(r.success){
			                    	window.location = window.location;
			                    } else {
			                    	console.log(r.error);
			                    	alert(r.message);
			                    }
		                    }, error: function (data, status, e)//服务器响应失败处理函数
		                    {
		                        alert(e);
		                    }
		                }
		            )
		        }
				</script>       
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
</body>
</html>
