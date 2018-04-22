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
	<div class="modal-dialog " style="width:1500px;">
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
                    <li><a href="#goodsDetailInfo" role="tab" data-toggle="tab">图文详情</a></li>
                    <input name="integrateGoodsId" id="integrateGoodsId" style="display: none;" value=""/>
                </ul>
                <div class="tab-content" >
                    <div role="tabpanel" class="tab-pane active" id="basicInfo">
                    
                    	<form id="basicForm" class="form-horizontal" role="form">
                    		
                    	  <input class="data-id" id="data-id" style="display: none;"/>
                    		
						  <div class="form-group">
						    <label for="firstname" class="col-sm-1 control-label">名称</label>
						    <div class="col-sm-11">
						      <input type="text" class="form-control" name="name" id="goodsName" placeholder="请输入名称" required>
						    </div>
						  </div>
						  
						  
				  	     <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">价格（积分）</label>
						    <div class="col-sm-11">
						       <input type="text" class="form-control" id="price" name='price' placeholder="请输入价格（积分）">
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">数量</label>
						    <div class="col-sm-11">
						       <input type="text" class="form-control" id="count" placeholder="请输入数量">
						    </div>
						  </div>
						  
							<div class="form-group">
								<label class="col-sm-1 control-label" >图标</label>
								<div class="col-sm-11">
									<iframe style="width: 100%; height: 40px;" src="file-upload/page" name="file-upload-iframe"></iframe>
									<div id="imageDiv"></div>
									<input name="logoAttId" id="logoAttId" style="display: none;" value=""/>
									<input name="logoAttUrl" id="logoAttUrl" style="display: none;" value=""/>
								</div>
							</div>
												 	  
				  	     <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">开始时间</label>
						    <div class="col-sm-11">
						      <input type="text" class="demo-input" placeholder="请选择日期" id="startTime">
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">结束时间</label>
						    <div class="col-sm-11">
						       <input type="text" class="demo-input" placeholder="请选择日期" id="endTime">
						    </div>
						  </div>
						  
						  
						  <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">备注</label>
						    <div class="col-sm-11">
						       <input type="text" class="form-control" id="remark" placeholder="请输入备注">
						    </div>
						  </div>
						  
						  <div style="display: none;">
						  	<input type="text" id="clickCount" value="0"/>
						  	<input type="text" id="createTime" value="0"/>
						  	<input type="text" id="creator" value="0"/>
						  	<input type="text" id="sellerId" />
						  	<input type="text" id="status" value="0"/>
						  	<input type="text" id="updateTime" value="0"/>
						  	<input type="text" id="undercarriageTime" value="0"/>
						  	<input type="text" id="undercarriagor" value="0"/>
						  	<input type="text" id="updator" value="0"/>
						  </div>
						</form>
                    </div> <!-- end of basicInfo -->
                    
						 
						
						<!-- #goodsDetailInfo -->
						<div role="tabpanel" class="tab-pane" id="goodsDetailInfo">
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
                <button type="button" id="btnSubmit" class="btn btn-primary" onclick="updateIntegrateGoods();">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<jsp:include page="../material_resources/choose_resources.jsp"></jsp:include>

<script type="text/javascript">

$(function(){
	if($("#logoAttId").val()){
		$("#imageDiv").children().remove();
		$("#imageDiv").append("<img style='width:120px;height:120px;' src='showImage?uuid=" + $("#logoAttUrl").val() + "&fileType=jpg'><img>");
	}
	lay('#version').html('-v'+ laydate.v);

	//执行一个laydate实例
	laydate.render({
		elem: '#startTime', //指定元素
		theme: '#2177c7',
		min: 0,
		type: 'datetime',
		format:'yyyy-MM-dd HH:mm:ss'
	});
	
	//执行一个laydate实例
	laydate.render({
		elem: '#endTime', //指定元素
		min: 0,
		theme: '#393D49',
		type: 'datetime',
		format:'yyyy-MM-dd HH:mm:ss'
	});
 });
	
function showErrorAlert (reason, detail) {
	var msg='';
	if (reason==='unsupported-file-type') {
		msg = "Unsupported format " + detail; 
	} else {
		console.log("error uploading file", reason, detail);
	}
	$('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'+ 
	 '<strong>File upload error</strong> '+msg+' </div>').prependTo('#alerts');
}


//更新积分商品
function updateIntegrateGoods(){
    
	var data = {
		id : $("#integrateGoodsId").val(),
		name : $("#goodsName").val(),
		price : $("#price").val(),
		startTime : $("#startTime").val(),
		endTime : $("#endTime").val(),
		detailInfo : editor.txt.html(),
		creator : $("#currentUserId").val(),
		logoAttId : $("#logoAttId").val(),
		count : $("#count").val()
	}
	$.post("mt/integrateGoods/updateIntegrateGoods", data, function(r) {
		if (r.success) {
			window.location = window.location;
		} else {
			console.log("update integrate goods error:" + r.error);
		}
	})
}

function iframeCallBack(atts) {
	if (atts != null) {
		$("#imageDiv").children().remove();
		$("#imageDiv").append("<img style='width:120px;height:120px;' src='showImage?uuid=" + atts[0].uuid + "&fileType=" + atts[0].srcFileType + "'><img>");
		$("#logoAttId").val(atts[0].id);
	}
}
</script>