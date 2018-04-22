<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link rel="stylesheet" href="static/assets/css/bootstrap-slider.min.css"/>

<link rel="stylesheet" href="static/assets/PhotoOpen/css/bootstrap-grid.min.css">
<link rel="stylesheet" href="static/assets/PhotoOpen/dist/zoomify.min.css">
<link rel="stylesheet" href="static/assets/PhotoOpen/css/style.css">

<script src="static/assets/PhotoOpen/dist/zoomify.min.js"></script>


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
			<input type="hidden"  id="applyId" value=""/>
			<div class="modal-body">				
                <div class="tab-content" >
                    <div role="tabpanel" class="tab-pane active" id="orderInfo">
						<table class="am-table am-table-bordered am-table-striped am-table-compact0" id="orderInfo">
						  <thead class="am-text-center">
						  <tr><tb>商家入驻申请基本信息</tb></tr>
						  </thead>
						  <tbody>
						  <tr class="am-warning">
						    <td class="am-text-right  am-serif">商家名称</td>
						    <td id="name"></td>
						    <td class="am-text-right  am-serif">商家分类</td>
						    <td id="catName"></td>
						     <td class="am-text-right  am-serif">负责人</td>
						    <td id="responsiblePeson"></td>
						  </tr>
						  <tr class="am-warning">
						    <td class="am-text-right  am-serif">负责人身份证号</td>
						    <td id="idNumber"></td>
						    <td class="am-text-right  am-serif">银行卡号</td>
						    <td id="bankAccount"></td>
						     <td class="am-text-right  am-serif">省份</td>
						    <td id="province"></td>
						  </tr>
						  <tr class="am-warning">
						    <td class="am-text-right  am-serif">城市</td>
						    <td id="city"></td>
						    <td class="am-text-right  am-serif">县份</td>
						    <td id="district"></td>
						     <td class="am-text-right  am-serif">地址</td>
						    <td id="address"></td>
						  </tr>
						   <tr class="am-warning">
						    <td class="am-text-right  am-serif">电话</td>
						    <td id="phoneNumber"></td>
						    <td class="am-text-right  am-serif">申请时间</td>
						    <td id="applyTime"></td>
						     <td class="am-text-right  am-serif">经度</td>
						    <td id="lng"></td>
						  </tr>
						   <tr class="am-warning">
						    <td class="am-text-right  am-serif">纬度</td>
						    <td id="lat"></td>
						    <td class="am-text-right  am-serif">简介</td>
						    <td id="synopsis"  colspan="4"></td>
						  </tr>
						   </tr>
						   <tr class="am-warning">
						    <td class="am-text-right  am-serif">经营范围</td>
						    <td id="businessScope" colspan="6"></td>
						  </tr>
						    <tr class="am-primary">
						    <td class="am-text-right  am-serif">图片</td>
						    <td id="photo" colspan="6">
						    
						    <div class="container">		
								<div class="examples">	
									<div class="row" id="returnOrderPhoto">
										<div class="example col-xs-3 col-md-3">
											<p><img src="static/assets/PhotoOpen/img/4.jpg" class="img-rounded" alt=""></p>
										</div>
									</div>
								</div>	
							</div>
							
						    </td>
						  </tr>
						  </tbody>
						</table>
						
						<!-- 订单操作-->
						<table class="am-table am-table-bordered am-table-striped am-table-compact" id="goodsInfo">
						 <thead class="am-text-center">
						   <tr><tb>退货单操作</tb></tr>
						 </thead>
						  <thead>
						  <tr>
						    <td id="Content" style="display:none;">
						    <div class="form-group">
						    <label for="lastname"  class="col-sm-1 control-label">审核不通过原因</label>
						    <div class="col-sm-11">
						       <textarea class="form-control" rows="2" id="reasonContent" ></textarea>
						    </div>
						  </div>
						  </td>
						  </tr>
						  <tr class="am-success">
						    <th>
						    <button onclick="agree()" id="agree"  class="am-btn am-btn-warning" href="javascript:void(0)"  style="display:none;"> 
							  <i class="am-icon-check "></i>
							    审核通过
							</button>
							<button onclick="disagree()" id="disagree" class="am-btn am-btn-danger" href="javascript:void(0)"  style="display:none;">
							  <i class="am-icon-times"></i>
							   审核不通过
							</button>
							 <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							</th>
						  </tr>
						  </thead>
						</table>
                    </div> <!-- end of basicInfo -->
                </div><!-- enf of tab content -->
			</div> <!-- /.modal-body -->
	</div><!-- /.modal -->
</div>

<script>

//审核
 function agree(){
	var data = { 'id':$("#applyId").val()};
	$.post("mt/sellerSettledApply/agreeExamine", data, function(r){	
		if(r.success){
			window.location = window.location;
		} else {
			alert("审核不通过，商家重名！");
			console.log("apply exanmine error:" + r.error);
		}
	})
		
 }

 //审核不通过
 function disagree(){
	 if($("#reasonContent").val() == ""){
		 alert("请输入审核不通过原因！")
		 return;
	 }
		data={
				'id':$("#applyId").val(),
				'failReason':$("#reasonContent").val()
			}
		$.post("mt/sellerSettledApply/disagreeExamine",data,function(r){		
			if(r.success){
				alert("操作成功！")
				window.location = window.location;
			}
		})
 }
 
</script>

<script type="text/javascript">	
    	function showPhoto(){
			$('.example img').zoomify();
		}
</script>
