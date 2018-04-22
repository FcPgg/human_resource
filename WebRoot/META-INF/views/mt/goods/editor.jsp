<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link rel="stylesheet" href="static/assets/css/bootstrap-slider.min.css"/>

<script type="text/javascript" src="static/assets/wangEditor-3.0.8/release/wangEditor.js"></script>
<script src="static/assets/laydate/laydate.js"></script>
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
	<div class="modal-dialog " style="width:900px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="dialogLabel">
				</h4>
			</div>
			<div class="modal-body">				
				<ul class="nav nav-tabs" role="tablist">
                    <li class="active"><a href="#basicInfo" role="tab" data-toggle="tab">基本信息</a></li>
                    <li><a href="#jobInfo" role="tab" data-toggle="tab">工作简历</a></li>
                </ul>
                <div class="tab-content" >
                    <div role="tabpanel" class="tab-pane active" id="basicInfo">
                    
                    	<form id="basicForm" class="form-horizontal" role="form">
                    		
                    	  <input class="data-id" id="data-id" style="display: none;"/>
                    		
						  <div class="form-group">
						    <label for="firstname" class="col-sm-1 control-label">姓名</label>
						    <div class="col-sm-11">
						      <input type="text" class="form-control" name="name" id="name" placeholder="请输入名称" required>
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
						    <label for="lastname" class="col-sm-1 control-label">部门</label>
						    <div class="col-sm-11">
						      <select id="category" name='category' class="form-control" style="height: 38px;"></select>
						    </div>
						  </div>
						  
				  	     <div class="form-group">
							<label for="lastname" class="col-sm-1 control-label">出生日期</label>
							<div class="col-sm-11">
								<input type="text" class="demo-input" placeholder="请选择日期"
									id="birthday">
							</div>
						 </div>
						  
						  <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">民族</label>
						    <div class="col-sm-11">
						       <input type="text" class="form-control" id="nation" placeholder="请输入民族">
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">政治面貌</label>
						    <div class="col-sm-11">
						       <input type="text" class="form-control" id="politics" placeholder="请输入政治面貌">
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">爱好</label>
						    <div class="col-sm-11 ">
						       <input id="hobby" type="text" style="height: 34px;" class="form-control" placeholder="请输入爱好"/>
						    </div>
						  </div>
						  
					      <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">学历</label>
						    <div class="col-sm-11 ">
						       <input id="education" style="height: 34px;" class="form-control" placeholder="请输入学历"/>
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">备注</label>
						     <div class="col-sm-11">
						       <textarea class="form-control" rows="2" id="description" ></textarea>
						    </div>
						  </div>
						  
						  
						</form>
                    </div> <!-- end of basicInfo -->
                    
						<!-- #goodsParamsInfo -->
						
						<!-- #goodsDetailInfo -->
						<div role="tabpanel" class="tab-pane" id="jobInfo">
							<div id="titleDiv" class="toolbar"></div>
							<div id="contentDiv" class="text">
							</div>
							
						    <script type="text/javascript">

						    var EditorFactory = (function(){
						    		var instance = null;
						    		
						    		function createEditor(){
						    			var E = window.wangEditor
						    			var eidtor = null;
						    			editor = new E('#titleDiv', '#contentDiv')  // 两个参数也可以传入 elem 对象，class 选择器
						    			editor.customConfig.menus = [
						    		                                    'head',  // 标题
						    		                                    'bold',  // 粗体
						    		                                    'italic',  // 斜体
						    		                                    'underline',  // 下划线
						    		                                    'strikeThrough',  // 删除线
						    		                                    'foreColor',  // 文字颜色
						    		                                    'backColor',  // 背景颜色
						    		                                    'justify',  // 对齐方式
						    		                                    'image',  // 插入图片
						    		                                    'table',  // 表格
						    		                                    'undo',  // 撤销
						    		                                    'redo'  // 重复
						    		                                ];
						    		       editor.customConfig.uploadImgServer = 'fileUpload'; //上传地址
						    		       editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;//图片大小
						    		       editor.customConfig.uploadFileName = 'file';//上传图片属性名
						    		       editor.customConfig.uploadImgHooks = {
						    		   	    success: function (xhr, editor, result) {
						    		   	        // 图片上传并返回结果，图片插入成功之后触发
						    		   	        // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
						    		   	        console.log("success");
						    		   	        
						    		   	    },
						    		   	    fail: function (xhr, editor, result) {
						    		   	        // 图片上传并返回结果，但图片插入错误时触发
						    		   	        // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
						    		   	    	console.log("fail");
						    		   	    },
						    		   	    error: function (xhr, editor) {
						    		   	        // 图片上传出错时触发
						    		   	        // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
						    		   	    	console.log("error");
						    		   	    },
						    		   	    timeout: function (xhr, editor) {
						    		   	        // 图片上传超时时触发
						    		   	        // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
						    		   	    	console.log("timeout");
						    		   	    },

						    		   	    // 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
						    		   	    // （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
						    		   	    customInsert: function (insertImg, result, editor) {
						    		   	        // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
						    		   	        // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果

						    		   	        // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
						    			   	    var data = result.data
						    	     	        if(data){
						    	     	        	$.each(data, function(){
						    			        	        insertImg("/Web/showImage?uuid=" + this.uuid + "." + this.srcFileType);
						    	     	        	});
						         	        	}


						    		   	        // result 必须是一个 JSON 格式字符串！！！否则报错
						    		   	    }
						    		    }
						    		    editor.create();
						    		    return editor;
						    		};
						    		
						    		function createInstance(){
						    			return new createEditor();
						    		};
						    		
						    		return{
						    			getInstance : function(){
						    				if(!instance){
						    					instance = createInstance();
						    				}
						    				return instance;
						    			}
						    		}
						    })();
						    </script>
						</div>
						<!-- #goodsDetailInfo -->
                </div><!-- enf of tab content -->
			</div> <!-- /.modal-body -->
			 <div class="modal-footer">
                <button type="button" id="btnSubmit" class="btn btn-primary" onclick="doSaveGoods();">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<%-- <jsp:include page="../material_resources/choose_resources.jsp"></jsp:include> --%>

<script type="text/javascript">
$(function() {
	if($("#logoAttId").val()){
		$("#imageDiv").children().remove();
		$("#imageDiv").append("<img style='width:120px;height:120px;' src='showImage?uuid=" + $("#logoAttUrl").val() + "&fileType=jpg'><img>");
	}
	
	lay('#version').html('-v'+ laydate.v);

	//执行一个laydate实例
	laydate.render({
		  elem: '#birthday', //指定元素
		  theme: '#FF5722',
		  max: 0,
		  format: 'yyyy年MM月dd日'
		});
	$("#rate").slider({
    	tooltip: 'always'
    });
});
	
   
   
	
function iframeCallBack(atts) {
	if (atts != null) {
		$("#imageDiv").children().remove();
		$("#imageDiv").append("<img style='width:120px;height:120px;' src='showImage?uuid=" + atts[0].uuid + "&fileType=" + atts[0].srcFileType + "'><img>");
		$("#logoAttId").val(atts[0].id);
	}
}	


	$(function() {
	/* 	$.post("mt/mtSecondLevelCategory/getCategoryBySellerId", {"sellerId":$("#sellerId").val()}, function(r) {
			if (r.success) {
				if (r.data) {
					$("#category").children().remove();
					$.each(r.data, function() {
						var option = '<option value="' + this.id + '"'
						 option += '>' + this.categoryName + '</option>'
						$("#category").append(option);
						$(".category").append(option);
					});
				}
			}
		});
		$("#rate").slider({
        	tooltip: 'always'
	    }); */
		$.post("mt/mtCategory/listNormalSystemCategory","",function(r){
			if (r.success) {
				if (r.data) {
					$("#category").children().remove();
					$.each(r.data.data, function() {
						var option = '<option value="' + this.id + '"'
						    option += '>' + this.catName + '</option>'
						$("#category").append(option);
						$(".category").append(option);
					});
				}
			}
		});
		$("#rate").slider({
        	tooltip: 'always'
	    });
	});
	
	function showErrorAlert (reason, detail) {
		var msg='';
		if (reason==='unsupported-file-type') { msg = "Unsupported format " +detail; }
		else {
			console.log("error uploading file", reason, detail);
		}
		$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'+ 
		 '<strong>File upload error</strong> '+msg+' </div>').prependTo('#alerts');
	}
	
	//是否包邮操作
	function doPostage(){
		var hasChk = $('#ifPostage').is(':checked');
		if(hasChk){
			 $("#postage").attr("readOnly",true);
			 $("#postage").val(0);
		}else{
			 $("#postage").attr("readOnly",false);
			 $("#postage").val("");
		}
	}
	
	//添加参数
	function addParams(){
		var row = '<tr><td widtd="163px"><a href="javascript:void(0);" onclick="removeParams($(this));">[-]</a></td>'
		row += '<td style="display: none"><input class="id" value="0"/></td>';
           row += '<td style="display: none"><input class="goodsId" value="0"/></td>';
           row += '<td><input class="paramName"/></td>';
           row += '<td><input class="paramValue"/></td></tr>';
           $("#paramsTable tbody").append(row);
	}
	
	//删除参数
	function removeParams(e){
		var tr = e.parent().parent();
		if($(tr).find(".id").val() > 0){
			if(confirm("确定删除这条参数吗？此操作不可恢复！")){
				$.post("mt/mtGoodsParams/remove", {id: tr.find(".id").val()}, function(r){
					if(r.success){
						tr.remove();
					} else {
						console.log(r.error);
						alert(r.message);
					}
				});
			}
		} else {
			tr.remove();
		}
	}

	

	//保存商品
	function doSaveGoods(){
		var entity = {
				id: $("#data-id").val(),
				name: $("#name").val(),
				categroy: $("#category").val(),
				attId: $("#logoAttId").val(),
				birthday: $("#birthday").val(),
				description: $("#description").val(),
				nation: $("#nation").val(),
				politics: $("#politics").val(),
				detailDescription: editor.txt.html(),
				hobby : $("#hobby").val(),
				creator : $("#creator").val(),
				status : $("#status").val(),
				undercarriagor : $("#undercarriagor").val(),
				updator : $("#updator").val(),
				cashback : $("#cashback").val() != null ? $("#cashback").val() : 0 
		};
		
		
		if(entity.name == null && entity.name == ""){
			alert("请填写商品名称");
			return;
		}
		if(entity.secondLevelCategory == null && entity.secondLevelCategory == ""){
			alert("请填选择商品分类");
			return;
		}
		if(entity.vender == null && entity.vender == ""){
			alert("请填写生产厂家");
			return;
		}
		/* var x = entity.rate;
		if(isNaN(x) || x<0 || x>1){
			alert("折扣率请设置0~1的两位小数,如:0.85");
			return;
		} */
		if(entity.postage == null && entity.postage == ""){
			alert("请填写邮费，若包邮请勾选是否包邮");
			return;
		}
		
		$.post("mt/mtGoods/updateGoods", {entity: JSON.stringify(entity)}, function(r){
			if(r.success){
				window.location = window.location;
			} else {
				console.log(r.error);
				alert(r.message);
			}
		});
	}
</script>