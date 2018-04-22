<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<script type="text/javascript" src="static/assets/js/jqueryui/jquery-ui-1.10.4.custom.min.js"></script>
<link rel="stylesheet" href="static/assets/js/jqueryui/jquery-ui-1.10.4.custom.min.css" />

<style type='text/css'>
.demo{width:560px; margin:20px auto 0 auto; }
.demo h4{padding:10px 2px; font-size:14px; font-weight:bold}
.demo p{line-height:32px}
@media screen and (max-width: 360px) {.demo {width:340px}}

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

#R,#G,#B {
	width: 300px;
}

.demo-input {
	padding-left: 10px;
	height: 38px;
	min-width: 262px;
	line-height: 38px;
	border: 1px solid #e6e6e6;
	background-color: #fff;
	border-radius: 2px;
}

.demo-footer {
	padding: 50px 0;
	color: #999;
	font-size: 14px;
}

.demo-footer a {
	padding: 0 5px;
	color: #01AAED;
}
</style>

<div class="modal fade" id="updateCategory" tabindex="-1" role="dialog" aria-labelledby="dialogLabel" aria-hidden="true">
	<div class="modal-dialog " style="width: 1500px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="dialogLabel"></h4>
				<input name="systemCategoryId" id="systemCategoryId" style="display: none;" value=""/>
			</div>
			<div class="modal-body">
				<ul class="nav nav-tabs" role="tablist">
					<li class="active"><a href="#basicInfo" role="tab"
						data-toggle="tab">基本信息</a></li>
				</ul>
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="basicInfo">

						<form id="basicForm" class="form-horizontal" role="form" >

						<input class="data-id" id="data-id" style="display: none;" />

						<div class="form-group">
							<label for="firstname" class="col-sm-1 control-label">首页分类名称</label>
							<div class="col-sm-11">
								<input type="text" class="form-control" name="name" id="name"
									placeholder="请输入名称" required>
							</div>
						</div>

                        <div class="form-group">
							<label for="firstname" class="col-sm-1 control-label">序号</label>
							<div class="col-sm-4">
							      <input type="text" id="categorySort" value="0"/>
							</div>
							<div class="col-sm-4 text-danger">
							      <span>（注:序号越大越靠后）</span>
							</div>
						</div>
                        

						<div class="form-group">
								<label class="col-sm-1 control-label" >图片</label>
								<div class="col-sm-11">
									<iframe style="width: 100%; height: 40px;" src="file-upload/page" name="file-upload-iframe"></iframe>
									<div id="imageDiv"></div>
									<input name="logoAttId" id="logoAttId" style="display: none;" value="">
				                	<input name="logoAttUrl" id="logoAttUrl" style="display: none;" value="">
								</div>
							</div>

						

						</form>
					</div>
					<!-- end of basicInfo -->

					<!-- #goodsDetailInfo -->
				</div>
				<!-- enf of tab content -->
			</div>
			<!-- /.modal-body -->
			<div class="modal-footer">
				<button type="button" id="btnSubmit" class="btn btn-primary"
					onclick="updateSystemCategory();">保存</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>

<script>	

//更新系统分类
function updateSystemCategory(){
	var categoryId = $("#systemCategoryId").val()
	if(categoryId == ''){
     var data = {
    		    'name':$("#name").val(),
    		    'sortOrder':$("#categorySort").val(),
    		    'logo': $("#logoAttId").val()
    		    }
 	} else {
	 var data = {
			    'id':categoryId,
    		    'name':$("#name").val(),
    		    'sortOrder':$("#categorySort").val(),
    		    'logo': $("#logoAttId").val()
    		    }
    
	}
	$.post("mt/mtCategory/updateSystemCategory",data,function(r){
		if (r.success) {
			window.location = window.location;
		} else {
			console.log("update integrate goods error:" + r.error);
		}
	});  
}
	
function iframeCallBack(atts) {
	if (atts != null) {
		$("#imageDiv").children().remove();
		$("#imageDiv").append("<img style='width:120px;height:120px;' src='showImage?uuid=" + atts[0].uuid + "&fileType=" + atts[0].srcFileType + "'><img>");
		$("#logoAttId").val(atts[0].id);
	}
}	

</script>

