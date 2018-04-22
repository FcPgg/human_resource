<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link rel="stylesheet" href="static/assets/css/bootstrap-slider.min.css"/>
<script src="static/amaze/assets/js/mt/category.js"></script>
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



<div class="modal fade" id="withdrawals" tabindex="-1" role="dialog" aria-labelledby="dialogLabel" aria-hidden="true">
	<div class="modal-dialog " style="width:1100px;">
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
                    <li class="active"><a href="#category" role="tab" data-toggle="tab">平台提现</a></li>
                </ul>
                <div class="tab-content" >
                    <div role="tabpanel" class="tab-pane active" id="category">
                    	<form id="category" class="form-horizontal" role="form">
                    	<input type="text" style="display:none" id="moneyAccount" value=""/>
                    	<!--   <input class="data-id" id="data-id" style="display: none;"/> -->
                    	  <input type="text" style="display:none"  id="sellerId" value=""/>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-1 control-label">提现账户</label>
						    <div class="col-sm-11">
						      <input type="text" class="form-control" name="name" id="alipayAccountNumber" value="刘兰云的支付宝" disabled="disabled"  required>
						     <!--   <input type="text" class="am-input-sm" id="alipayAccount" value="" disabled="disabled" style="display:none"> -->
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-1 control-label">提现金额</label>
						    <div class="col-sm-11">
						      <input type="text" class="form-control" name="name" id="alipayAmount" placeholder="请输入提现金额" required>
						    </div>
						  </div>
						</form>
                    </div> <!-- end of basicInfo -->
                </div>
						<!-- #goodsDetailInfo -->
                </div><!-- enf of tab content -->
			</div> <!-- /.modal-body -->
			 <div class="modal-footer">
                <button type="button" id="saveCategory" class="btn btn-primary" onclick="withdrawals();">确认提现</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<script>
function withdrawals(){	
	  if($("#alipayAccountNumber").val()==""){
			$("#alipayAccountNumber").tips({
			side:3,
            msg:'请输入支付宝账户',
            bg:'#AE81FF',
            time:2
        });
		
		$("#alipayAccountNumber").focus();
		return false;
	}
	  if($("#alipayAmount").val()==""){
			$("#alipayAmount").tips({
			side:3,
          msg:'请输入提现金额',
          bg:'#AE81FF',
          time:2
      });
		
		$("#alipayAmount").focus();
		return false;
	}
    if($("#alipayAmount").val() >$("#moneyAccount").val()){
			$("#alipayAmount").tips({
			side:3,
        msg:'余额不足',
        bg:'#AE81FF',
        time:2
    });
		
		$("#alipayAmount").focus();
		return false;
	} 
	  var sellerId = $("#sellerId").val();
	  var alipayAccountNumber = "13398787900";
	  var alipayAmount = $("#alipayAmount").val();
	     
     $.post("mt/mtPlatformCapitalTradeLog/platformWithdrawals",{"alipayAccountNumber":alipayAccountNumber,"alipayAmount":alipayAmount},function(r){
    	 if(r.success){
			alert("操作成功！")
			window.location = window.location;
		 }else{
			alert("操作失败！") 
		 }
     });
	} 
</script>

