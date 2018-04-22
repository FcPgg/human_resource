<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link rel="stylesheet" href="static/assets/css/bootstrap-slider.min.css"/>
 
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
			<input type="hidden"  id="orderId"/>
			<div class="modal-body">				
                <div class="tab-content" >
                    <div role="tabpanel" class="tab-pane active" id="orderInfo">
						<table class="am-table am-table-bordered am-table-striped am-table-compact0" id="orderInfo">
						  <thead class="am-text-center">
						  <tr><tb>基本信息</tb></tr>
						  </thead>
						  <tbody>
						  <tr class="am-warning">
						    <td class="am-text-right  am-serif">订单状态</td>
						    <td id="orderStatusName"></td>
						    <td class="am-text-right  am-serif">创建时间</td>
						    <td id="createTime"></td>
					         <td class="am-text-right  am-serif">物流单号</td>
					        <td id="trackingNo"></td>
						  </tr>
						  <tr class="am-warning">
						    <td class="am-text-right  am-serif">物流公司</td>
						    <td id="streamCompanyNo"></td>
						    <td class="am-text-right  am-serif">收货人</td>
						    <td id="consignee"></td>
						    <td class="am-text-right  am-serif">配送地址</td>
						    <td id="address"></td>
						  </tr>
						   <tr class="am-warning">
						    <td class="am-text-right  am-serif">收货人电话</td>
						    <td id="phoneNumber"></td>
						    <td class="am-text-right  am-serif" >备注</td>
						    <td id="remark" colspan="4"></td>
						  </tr>
						  </tbody>
						</table>
						
						<table class="am-table am-table-bordered am-table-striped am-table-compact" id="goodsInfo">
						 <thead class="am-text-center">
						   <tr><tb>商品信息</tb></tr>
						 </thead>
						  <thead>
						  <tr class="am-success">
						    <th>商品编号</th>
						    <th>商品名称</th>
						    <th>商品数量</th>
						    <th>价格</th>
						    <th>小计</th>
						  </tr>
						  </thead>
						  <tbody id = "goodsList">
						  </tbody>
						   <tbody>
						  <tr class="am-warning">
						    <td>合计</td>
						    <td id="sum"></td>
						    <td></td>
						    <td></td>
						    <td></td>
						  </tr>
						  </tbody>
						</table>
						
						<!-- 物流 -->
						<table class="am-table am-table-bordered am-table-striped am-table-compact" id="expFrom">
						 <thead class="am-text-center">
						  <tr class="am-warning">
						    <td class="am-text-right  am-serif">物流公司</td>
						    <td>
						       <form>
							        <div class="typeahead__container">
							            <div class="typeahead__field">
							            <span class="typeahead__query">
							                <input class="js-typeahead" id="experss"  name="q" type="search" autofocus autocomplete="off">
							            </span>
    						           </div>
							        </div>
							    </form>

						    </td>
						    <td class="am-text-right  am-serif">物流单号</td>
						    <td><input type="text" id="trackingsNo" class="am-form-field" placeholder="物流单号"></td>
						    <input type="hidden" id="experssCode" value=""/>
						  </tr>
						  </thead>
						</table>
						<!-- 订单操作-->
						<table class="am-table am-table-bordered am-table-striped am-table-compact" id="goodsInfo">
						 <thead class="am-text-center">
						   <tr><tb>订单操作</tb></tr>
						 </thead>
						  <thead>
						  <tr class="am-success">
						    <th>
						    <button onclick="delivery()"  id="delivery" class="am-btn am-btn-warning" href="javascript:void(0)">
							  <i class="am-icon-paper-plane"></i>
							       发货
							</button>
							 <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							</th>
						  </tr>
						  </thead>
						</table>
                    </div> <!-- end of basicInfo -->
                </div><!-- enf of tab content -->
			</div> <!-- /.modal-body -->
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<script>

function delivery(){
	 var experss = $("#experss").val();
	 var trackingNo = $("#trackingsNo").val();
	 var id = $("#orderId").val();
	 
	 data = {'orderId':id,
			 'streamCompanyNo':experss,
			 'trackingNo':trackingNo,
			 }
 	 $.post("mt/mtIntegrateExchangeLog/updateIntegrateExchangeLogStatus",data,function(r){
 		 if(r.success){
 			 alert("发货成功！");
 			window.location = window.location;
 		 }

 	})
}




</script>
