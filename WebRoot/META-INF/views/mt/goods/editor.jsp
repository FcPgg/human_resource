<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link rel="stylesheet" href="static/assets/css/bootstrap-slider.min.css"/>

<script type="text/javascript" src="static/assets/wangEditor-3.0.8/release/wangEditor.js"></script>

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
                    <li><a href="#goodsGalleryInfo" role="tab" data-toggle="tab">商品相册</a></li>
                    <li><a href="#goodsSpecsInfo" role="tab" data-toggle="tab">规格设置</a></li>
                    <li><a href="#goodsParamsInfo" role="tab" data-toggle="tab">产品参数</a></li>
                    <li><a href="#goodsDetailInfo" role="tab" data-toggle="tab">图文详情</a></li>
                </ul>
                <div class="tab-content" >
                    <div role="tabpanel" class="tab-pane active" id="basicInfo">
                    
                    	<form id="basicForm" class="form-horizontal" role="form">
                    		
                    	  <input class="data-id" id="data-id" style="display: none;"/>
                    		
						  <div class="form-group">
						    <label for="firstname" class="col-sm-1 control-label">名称</label>
						    <div class="col-sm-11">
						      <input type="text" class="form-control" name="name" id="name" placeholder="请输入名称" required>
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">分类</label>
						    <div class="col-sm-11">
						      <select id="category" name='category' class="form-control" style="height: 38px;"></select>
						    </div>
						  </div>
						  
				  	     <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">厂家</label>
						    <div class="col-sm-11">
						       <input type="text" class="form-control" id="vender" name='vender' placeholder="请输入厂家">
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">产地</label>
						    <div class="col-sm-11">
						       <input type="text" class="form-control" id="address" placeholder="请输入产地">
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">邮费</label>
						    <div class="col-sm-9">
						       <input type="text" class="form-control" id="postage" placeholder="请输入邮费">
						    </div>
						     <div class="col-sm-2">
						     	<label class="am-checkbox am-secondary" onclick="doPostage()">
		                         <input type="checkbox" value="" id="ifPostage" >是否包邮 </label>
						     </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">折扣率</label>
						    <div class="col-sm-3 ">
						       <input id="rate" style="height: 34px;" class="form-control" data-slider-id='ex1Slider' type="text" data-slider-min="0" data-slider-max="1" data-slider-step="0.01" data-slider-value="0"/>
						    </div>
						    <div class="col-sm-8">
						    	<p class="red">注：折扣率最小为0,最大为1,(0 或者 1都为不打折) </br>即：计算价格公式： 最终价格=价格*折扣率 (最终价格85元= 原价100元 * 折扣率0.85)</p>
						    </div>
						  </div>
						  
					      <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">返现金额</label>
						    <div class="col-sm-3 ">
						       <input id="cashback" style="height: 34px;" class="form-control" placeholder="请输入返现金额"/>
						    </div>
						    <div class="col-sm-8">
						    	<p class="red">注：若无返现则填写0</p>
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">备注</label>
						    <div class="col-sm-11">
						       <input type="text" class="form-control" id="remark" placeholder="请输入备注">
						    </div>
						  </div>
						  
						  <div class="form-group">
						    <label for="lastname" class="col-sm-1 control-label">描述</label>
						    <div class="col-sm-11">
						       <textarea class="form-control" rows="2" id="description" ></textarea>
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
                    
                    <div role="tabpanel" class="tab-pane" id="goodsGalleryInfo" style="height: 200px;"> 
                    	<div class="col-xs-12">
								<!-- PAGE CONTENT BEGINS -->

								<div class="row-fluid">
									<ul class="ace-thumbnails" id="ulGoodsGallery">
										<li data-id="" goodsId="">
											<div>
												<img alt="首页图" class="logo" resourceId="" style="height: 150px; width: 150px;" src="">
												<div class="text">
													<div class="inner">
														<a href="javascript:void(0);" data-rel="colorbox" class="cboxElement" onclick="doChooseResource($(this));">
															<i class="icon-zoom-in"></i>
														</a>
													</div>
												</div>
												<div style="text-align: center;">首页图</div>
											</div>
										</li>
										<li data-id="" goodsId="">
											<div>
												<img alt="第二页" class="logo" resourceId="" style="height: 150px; width: 150px;" src="">
												<div class="text">
													<div class="inner">
														<a href="javascript:void(0);" data-rel="colorbox" class="cboxElement" onclick="doChooseResource($(this));">
															<i class="icon-zoom-in"></i>
														</a>
													</div>
												</div>
												<div style="text-align: center;">第二页</div>
											</div>
										</li>
										<li data-id="" goodsId="">
											<div>
												<img alt="第三页" class="logo" resourceId="" style="height: 150px; width: 150px;" src="">
												<div class="text">
													<div class="inner">
														<a href="javascript:void(0);" data-rel="colorbox" class="cboxElement" onclick="doChooseResource($(this));">
															<i class="icon-zoom-in"></i>
														</a>
													</div>
												</div>
												<div style="text-align: center;">第三页</div>
											</div>
										</li>
										<li data-id="" goodsId="">
											<div>
												<img alt="第四页" class="logo" resourceId="" style="height: 150px; width: 150px;" src="">
												<div class="text">
													<div class="inner">
														<a href="javascript:void(0);" data-rel="colorbox" class="cboxElement" onclick="doChooseResource($(this));">
															<i class="icon-zoom-in"></i>
														</a>
													</div>
												</div>
												<div style="text-align: center;">第四页</div>
											</div>
										</li>
										<li data-id="" goodsId="">
											<div>
												<img alt="第五页" class="logo" resourceId="" style="height: 150px; width: 150px;" src="">
												<div class="text">
													<div class="inner">
														<a href="javascript:void(0);" data-rel="colorbox" class="cboxElement" onclick="doChooseResource($(this));">
															<i class="icon-zoom-in"></i>
														</a>
													</div>
												</div>
												<div style="text-align: center;">第五页</div>
											</div>
										</li>
									</ul>
								</div><!-- PAGE CONTENT ENDS -->
							</div> <!-- 商品相册 -->
						 </div>
						 
						<!-- start of goods specs info -->
						 <div role="tabpanel" class="tab-pane" id="goodsSpecsInfo"> 
							<table class="table table-bordered" id="spacesTable">
				            <thead >
				              <tr class="am-success" id="goods-table-head">
				                <th width="163px"><a href="javascript:void(0);" onclick="addSpaces()">[+]</a></th>
				                <th class="id" style="display: none">编号</th>
				                <th class="goodsId" style="display: none">商品编号</th>
				                <th class="description">名称</th>
				                <th class="price">价格</th>
				                <th class="Inventory">库存</th>
				                <th class="warnNumber">报警数量</th>
				                <th class="logo">展示图</th>
				              </tr>
				            </thead>
				            <tbody>
				            </tbody>
					          </table>
	                    </div> <!-- enf of goodsSpecsInfo -->
		                    
						<!-- #goodsParamsInfo -->
						<div role="tabpanel" class="tab-pane" id="goodsParamsInfo">
							<table class="table table-bordered" id="paramsTable">
				            <thead >
				              <tr class="am-success" id="goods-table-head">
				                <th width="163px"><a href="javascript:void(0);" onclick="addParams();">[+]</a></th>
				                <th class="id" style="display: none">编号</th>
				                <th class="goodsId" style="display: none">商品编号</th>
				                <th class="paramsName">名称</th>
				                <th class="paramsValue">描述</th>
				              </tr>
				            </thead>
				            <tbody>
				            </tbody>
					          </table>
						</div>
						<!-- #goodsParamsInfo -->
						
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
                <button type="button" id="btnSubmit" class="btn btn-primary" onclick="doSaveGoods();">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<jsp:include page="../material_resources/choose_resources.jsp"></jsp:include>

<script type="text/javascript">
	$(function() {
		$.post("mt/mtSecondLevelCategory/getCategoryBySellerId", {"sellerId":$("#sellerId").val()}, function(r) {
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
	
	//添加规格
	function addSpaces(){
		var row = "<tr>"
           row += '<td><a href="javascript:void(0);" onclick="removeSpaces($(this))">[-]删除 </a></div></td>';
		row += '<td style="display: none"><input class="id" value="0"/></td>';
           row += '<td style="display: none"><input class="goodsId" value="0"/></td>';
           row += '<td><input class="description"/></td>';
           row += '<td><input class="price"/></td>';
           row += '<td><input class="inventory"/></td>';
           row += '<td><input class="warnNumber"/></td>';
           row += '<td ><img class="logo" style="width:70px;height:70px;" src=""/><a class="btn btn-link openResourcesDialog" href="javascript:void(0);">选择展示图</a></td>';
		row += "</tr>";
		row = $(row).appendTo($("#spacesTable tbody"));
		
		$(".openResourcesDialog").off("click");
		$(".openResourcesDialog").on("click", $(".openResourcesDialog:last"), function (){
			
			var td = $(this).parent();
			
			$('#chooseResourcesDialog').modal();
			
			$("#btnChooseResources").off("click");
			
			$("#btnChooseResources").on("click", function(){
				$.each($(".check-resources"), function(){
					if($(this).is(":checked")){
						var resourceId = $(this).parent().parent().attr("data-id");
						var accessUrl = $(this).parent().parent().attr("access-url");
						
						td.find(".logo").attr("src", accessUrl);
						td.find(".logo").attr("resourceId", resourceId);
						
						$('#chooseResourcesDialog').modal("hide");
					}
				});
			});
		});
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

	//删除规格
	function removeSpaces(e) {
		var tr = e.parent().parent();
		if($(tr).find(".id").val() > 0){
			if(confirm("确定删除这条规格数据吗？此操作不可恢复！")){
				$.post("mt/mtGoodsSpec/remove", {id: tr.find(".id").val()}, function(r){
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
	
	//选择资源文件
	function doChooseResource(e){
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

	//保存商品
	function doSaveGoods(){
		var entity = {
				id: $("#data-id").val(),
				name: $("#name").val(),
				secondLevelCategory: $("#category").val(),
				vender: $("#vender").val(),
				address: $("#address").val(),
				description: $("#description").val(),
				rate: parseInt($("#rate").val()),
				postage: $("#postage").val(),
				detailDescription: editor.txt.html(),
				clickCount : $("#clickCount").val(),
				creator : $("#creator").val(),
				sellerId : $("#sellerId").val(),
				status : $("#status").val(),
				undercarriagor : $("#undercarriagor").val(),
				updator : $("#updator").val(),
				cashback : $("#cashback").val() != null ? $("#cashback").val() : 0 
		};
		
		entity.goodsSpecs = [];
		
		$.each($("#spacesTable tbody").children(), function(){
			var spec = {
				id: $(this).find(".id").val(),
				goodsId: $(this).find(".goodsId").val(),
				description: $(this).find(".description").val(),
				price: $(this).find(".price").val(),
				inventory: $(this).find(".inventory").val(),
				warnNumber: $(this).find(".warnNumber").val(),
				resourceId: $(this).find(".logo").attr("resourceId")
			}
			entity.goodsSpecs.push(spec);
		});
		
		entity.goodsParams = [];
		$.each($("#paramsTable tbody").children(), function(){
			var param = {
				id: $(this).find(".id").val(),
				goodsId: $(this).find(".goodsId").val(),
				paramName: $(this).find(".paramName").val(),
				paramValue: $(this).find(".paramValue").val()
			}
			entity.goodsParams.push(param);
		});
		
		entity.goodsGallery = [];
		$.each($("#ulGoodsGallery li"), function(){
			if($(this).find(".logo").attr("resourceId") != null && $(this).find(".logo").attr("resourceId") > 0){
				var galler = {
						id: $(this).attr("data-id") <= 0 ? null : $(this).attr("data-id"),
						goodsId: $(this).attr("goodsId") <= 0 ? null : $(this).attr("goodsId"),
						resourceId: $(this).find(".logo").attr("resourceId"),
						sort: $(this).index()
				}
				entity.goodsGallery.push(galler);
			}
		});
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
		var x = entity.rate;
		if(isNaN(x) || x<0 || x>1){
			alert("折扣率请设置0~1的两位小数,如:0.85");
			return;
		}
		if(entity.postage == null && entity.postage == ""){
			alert("请填写邮费，若包邮请勾选是否包邮");
			return;
		}
		if(entity.goodsSpecs.length <= 0){
			alert("请至少设置一种规格");
			return;
		}
		if(entity.goodsGallery.length <= 0){
			alert("请至少设置一张展示图");
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