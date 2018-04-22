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



<div class="modal fade" id="integralWithdrawalsPage" tabindex="-1" role="dialog" aria-labelledby="dialogLabel" aria-hidden="true">
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
                    <li class="active"><a href="#category" role="tab" data-toggle="tab">e币提现</a></li>
                </ul>
                <div class="tab-content" >
                    <div role="tabpanel" class="tab-pane active" id="category">
                    	<form id="category" class="form-horizontal" role="form">
                    	<input type="text" style="display:none" id="integralBalance" value=""/>
                    	<!--   <input class="data-id" id="data-id" style="display: none;"/> -->
                    	  <input type="text" style="display:none"  id="sellerId" value=""/>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-1 control-label">提现账户</label>
						    <div class="col-sm-11">
						      <input type="text" class="form-control" name="name" id="accountNumbers" placeholder="请输入支付宝账户" required>
						       <input type="text" class="am-input-sm" id="alipayAccount" value="" style="display:none">
						    </div>
						  </div>
						  <div class="form-group">
						    <label for="firstname" class="col-sm-1 control-label">提现e币（个）</label>
						    <div class="col-sm-11">
						      <input type="text" class="form-control" name="name" id="integralNumber" placeholder="请输入提现e币的个数" required>
						    </div>
						  </div>
						</form>
                    </div> <!-- end of basicInfo -->
                </div>
						<!-- #goodsDetailInfo -->
                </div><!-- enf of tab content -->
			</div> <!-- /.modal-body -->
			 <div class="modal-footer">
                <button type="button" id="saveCategory" class="btn btn-primary" onclick="integralWithdrawals();">确认提现</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<script>
//余额提现
function integralWithdrawals(){	
	  if($("#accountNumbers").val()==""){
			$("#accountNumbers").tips({
			side:3,
            msg:'请输入e掌柜个人账号',
            bg:'#AE81FF',
            time:2
        });
		
		$("#accountNumbers").focus();
		return false;
	}
   var myreg = /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/; // 验证130-139,150-159,180-189号码段的手机号码
   if(myreg.test($("#accountNumbers").val()) == false){
		$("#accountNumbers").tips({
		  side:3,
	      msg:'请输入正确的e掌柜个人账号',
	      bg:'#AE81FF',
	      time:2
	    });
		
		$("#accountNumbers").focus();
		return false;
	}     
	  
	  if($("#integralNumber").val()==""){
			$("#integralNumber").tips({
			side:3,
          msg:'请输入提现e币个数',
          bg:'#AE81FF',
          time:2
      });
		
		$("#integralNumber").focus();
		return false;
	}
	 
   var r = /^[0-9]*[1-9][0-9]*$/;//正整数
   if(r.test($("#integralNumber").val()) == false){
		$("#integralNumber").tips({
		  side:3,
	      msg:'提现e币请为整数',
	      bg:'#AE81FF',
	      time:2
	    });
		
		$("#integralNumber").focus();
		return false;
	}   
	
    /* if($("#integralNumber").val() > $("#integralBalance").val()){
		$("#integralNumber").tips({
			side:3,
	        msg:'e币不足',
	        bg:'#AE81FF',
	        time:2
	    });
		
		$("#integralNumber").focus();
		return false;
	}  */
	  var sellerId = $("#sellerId").val();
	  var accountNumbers = $("#accountNumbers").val();
	  var integralNumber = $("#integralNumber").val();
	     
     $.post("mt/sellerAccountTradeLog/sellerIntegrateToUserAccount",{"sellerId":sellerId,"accountNumbers":accountNumbers,"integralNumber":integralNumber},function(r){
    	 if(r.data == true){
			alert("操作成功！")
			window.location = window.location;
		 }else{
			alert("账户不存在！") 
		 }
     });
	} 
</script>

