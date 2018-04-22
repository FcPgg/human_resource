<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link rel="stylesheet" href="static/assets/css/bootstrap-slider.min.css" />
<script src="static/assets/laydate/laydate.js"></script>

<link rel="stylesheet" href="static/dropdown/jquery.dorpdown.min.css" />
<script src="static/dropdown/jquery.drowdown.js"></script>
<script src="static/dropdown/mock.js"></script>

<link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/bootstrap-3.3.4.css">

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

<div class="modal fade" id="dialog" tabindex="-1" role="dialog"
	aria-labelledby="dialogLabel" aria-hidden="true">
	<div class="modal-dialog " style="width: 950px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="dialogLabel"></h4>
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
							<label for="firstname" class="col-sm-1 control-label">标题</label>
							<div class="col-sm-11">
								<input type="text" class="form-control" name="name" id="name"
									placeholder="请输入标题" required>
							</div>
						</div>
						
						<div class="form-group">
							<label for="firstname" class="col-sm-1 control-label">分类</label>
							<div class="col-sm-11">
								<select id="cat" style="width: 150px; height: 26px; padding-bottom: 0px; padding-top: 0px; margin-left: -11px;">
								</select>
							</div>
						</div>
						<div class="form-group">
								<label class="col-sm-1 control-label" >图片</label>
								<div class="col-sm-11">
									<iframe style="width: 100%; height: 40px;" src="file-upload/page" name="file-upload-iframe"></iframe>
									<div id="imageDiv"></div>
									<input name="logoAttId" id="logoAttId" style="display: none;" value=""/>
									<input name="logoAttUrl" id="logoAttUrl" style="display: none;" value=""/>
								</div>
							</div>

						<div class="form-group">
							<label for="firstname" class="col-sm-1 control-label">症状</label>
							<div class="col-sm-11">
								<input type="text" class="form-control" name="symptom" id="symptom"
									placeholder="请输入症状" required>
							</div>
						</div>
						
						<div class="form-group">
							<label for="firstname" class="col-sm-1 control-label">治疗方案</label>
							<div class="col-sm-1">
                                 <textarea class="" rows="5" id="programme" style="width:810px"></textarea>
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
					onclick="updateAd();">保存</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>

<script>

$(function() {
	if($("#logoAttId").val()){
		$("#imageDiv").children().remove();
		$("#imageDiv").append("<img style='width:120px;height:120px;' src='showImage?uuid=" + $("#logoAttUrl").val() + "&fileType=jpg'><img>");
	}
});
	
   
   
	
function iframeCallBack(atts) {
	if (atts != null) {
		$("#imageDiv").children().remove();
		$("#imageDiv").append("<img style='width:120px;height:120px;' src='showImage?uuid=" + atts[0].uuid + "&fileType=" + atts[0].srcFileType + "'><img>");
		$("#logoAttId").val(atts[0].id);
	}
}	


//更新广告
function updateAd(){
	var data = {
		 name:$("#name").val(),
		 attId : $("#logoAttId").val(),
		 symptom : $("#symptom").val(),
		 programme : $("#programme").val(),
		 category : $("#cat").val()
 		 
	}
	 $.post("mt/systemAd/updateAdvertisement", data, function(r){
		if (r.success) {
			window.location = window.location;
		} else {
			console.log("update integrate goods error:" + r.error);
		}
	}) 
}

//治疗方案分类
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
</script>
