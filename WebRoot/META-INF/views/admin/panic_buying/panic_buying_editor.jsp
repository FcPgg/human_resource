<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link rel="stylesheet" href="static/assets/css/bootstrap-slider.min.css" />
<script src="static/assets/laydate/laydate.js"></script>
<script type="text/javascript" src="static/assets/bootstrap-file-upload/ajaxfileupload.js"></script>
<link rel="stylesheet" href="static/dropdown/jquery.dorpdown.min.css" />
<script src="static/dropdown/jquery.drowdown.js"></script>

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

<div class="modal fade" id="dialogs" tabindex="-1" role="dialog"
	aria-labelledby="dialogLabel" aria-hidden="true">
	<div class="modal-dialog " style="width: 1050px;">
		<div class="modal-content">
			<div class="modal-header">
				<h4 class="modal-title" id="dialogLabel"></h4>
			</div>
			<div class="modal-body">
				<ul class="nav nav-tabs" role="tablist">
					<li class="active"><a href="#basicInfo" role="tab"
						data-toggle="tab">基本信息</a></li>
				</ul>
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="basicInfo">

						<form id="basicForm" class="form-horizontal" role="form" />

						<input class="data-id" id="data-id" style="display: none;" />
						<input class="data-id" id="diseaseId" value="" style="display: none;" />
						<input class="data-id" id="attId" value="" style="display: none;" />
						<input class="data-id" id="categroy" value="" style="display: none;" />
              
                     
						<div class="form-group">
							<label for="firstname" class="col-sm-1 control-label">地区</label>
							<div class="col-sm-11">
								<input type="text" class="form-control" name="address" id="address"
									placeholder="请输入名称"   readonly="readonly" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="lastname" class="col-sm-1 control-label">分类名</label>
							<div class="col-sm-11">
								<input type="text" class="form-control" name="catName" id="catName"
									placeholder="请输入优惠价格"  readonly="readonly" />
							</div>
						</div>
						
						<div class="form-group">
							<label for="lastname" class="col-sm-1 control-label">季节</label>
							<div class="col-sm-11">
								<input type="text" class="form-control" name="season" id="season"
									placeholder="请输入抢购数量"  readonly="readonly" />
							</div>
						</div>
						                       
                       <div class="form-group">
							<label for="lastname" class="col-sm-1 control-label">症状</label>
							<div class="col-sm-11">
									<textarea class="form-control" rows="3" id="symptom"  readonly="readonly" ></textarea>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-1 control-label">描述</label>
							<div class="col-sm-11">
									<textarea class="form-control" rows="5" id="describe"  readonly="readonly" ></textarea>
							</div>
						</div>  
						<div class="form-group">
							<label for="lastname" class="col-sm-1 control-label">发布时间</label>
							<div class="col-sm-11">
								<input type="text" class="form-control" name="createTime" id="createTime"
									placeholder="请输入限购数量"  readonly="readonly"/>
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-sm-1 control-label">图片</label>
							<div class="col-sm-11">
							  <img  src="" id="imgValidateCode" alt="" class="am-u-sm-12" style="width:400px;height:200px;">
							</div>
						</div>
						
						
						<div data-am-widget="titlebar" class="am-titlebar am-titlebar-default" >
						    <h2 class="am-titlebar-title ">
						          医生诊断
						    </h2>
						</div></br>
						<div class="form-group">
							<label for="lastname" class="col-sm-1 control-label">诊断</label>
							<div class="col-sm-11">
									<textarea class="form-control" rows="3" id="name" placeholder="请输入诊断结果" ></textarea>
							</div>
						</div>
							<div class="form-group">
							<label for="lastname" class="col-sm-1 control-label">治疗方案</label>
							<div class="col-sm-11">
									<textarea class="form-control" rows="5" id="programme" placeholder="请输入治疗方案"></textarea>
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
					onclick="updateZd();">保存</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
			</div>
		</div>
		<!-- /.modal-content -->
	</div>
	<!-- /.modal -->
</div>

<script>

	//更新限时抢
	function updateZd(){
		data = {
			'id':$("#diseaseId").val(),
		    'name' : $("#name").val(),
		    'programme' : $("#programme").val(),
		    'address' : $("#address").val(),
	       	'catName' : $("#catName").val(),
	        'season' : $("#season").val(),
	       	'symptom' : $("#symptom").val(),
			'describe' : $("#describe").val(),
			'createTime' : $("#createTime").val(),
			'attId' : $("#attId").val(),
			'categroy' : $("#categroy").val()
		};
		
		$.post("mt/disease/update", data, function(r){
			if (r.success) {
				window.location = window.location;
			} else {
				console.log("update integrate goods error:" + r.error);
			}
		}) 
	}


</script>
