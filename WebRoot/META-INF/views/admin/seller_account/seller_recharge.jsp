<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link rel="stylesheet" href="static/assets/sellerRecharge/css/base.css" />
<link rel="stylesheet" href="static/assets/sellerRecharge/css/help.css" />

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



<div class="modal fade" id="dialogs" tabindex="-1" role="dialog"
	aria-labelledby="dialogLabel" aria-hidden="true">
	<div class="modal-dialog " style="width: 1200px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">&times;</button>
				<h4 class="modal-title" id="dialogLabel"></h4>
			</div>
			<div class="modal-body">
				<!--内容开始------------------------------>
				<div class="bzzx_bt">
					<strong>充值中心</strong>企业购买e币后可以对已发布的商品进行<span>置顶</span>等管理
				</div>
				<table width="100%" border="0" cellspacing="0" cellpadding="0"
					class="zwfb_shop_table">
					<tr valign="top">
						<td align="right" width="10%">服务名称：</td>
						<td><ul class="fwmc_xxk">
								
							</ul></td>
					</tr>

					<tr>
						<td align="right">购买数量：</td>
						<td><ul class="nmb_jj">
								<li class="jian">-</li>
								<li><input name="" id="number" type="text" value="1" class="srkk"
									style="height: 26px;" /></li>
								<li class="jia">+</li>
							</ul></td>
					</tr>

					<tr>
						<td height="20"></td>
						<td></td>
					</tr>

					<tr>
						<td align="right">支付方式：</td>
						<td>
							<div class=" zwsl_num">
							 <!--  <input type="radio" id="weChatPay" name="bank" /> <label id="weChatPay_label" for="weChatPay" class="bank weChatPay">微信支付</label>  -->
							  <input type="radio" id="zfbPay" name="bank" /> <label id="zfbPay_label" for="zfbPay" class="bank zfbPay">支付宝支付</label>
							</div>
						</td>
					</tr>
					<tr>
						<td height="20"></td>
						<td></td>
					</tr>
					<tr>
						<td align="right">价格：</td>
						<td><div class="zwfb_zje">
								<span>100</span> <i>元</i>
							</div></td>
					</tr>
					<tr>
						<td height="20"></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td><a class="ty_but ml20" href="javascript:void(0)"
							onclick="rechargePay()">购 买</a></td>
					</tr>
					 <tbody id="alipay">
		            </tbody>
				</table>
				<div class="gmxz_tip">
					购买须知：
					<p>本次服务购买后立即即生效，不支持退费服务。</p>
				</div>

				<!--内容结束------------------------------>

				<!-- #goodsDetailInfo -->
			</div>
			<!-- enf of tab content -->
		</div>
		<!-- /.modal-body -->
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		</div>
	</div>
	<!-- /.modal-content -->
</div>
<!-- /.modal -->
</div>

<script>

	$(document).on('click',".fwmc_xxk li",function(){  
		$(this).addClass("on").siblings().removeClass("on");
		tola();
	});
	 
	$(document).ready(function(e) {
		//加
		$(".jia").click(function() {
			var fw_numb = $(".srkk").val();
			fw_numb++;
			$(".srkk").val(fw_numb);
			tola();
		})

		//减
		$(".jian").click(function() {
			var fw_numb = $(".srkk").val();
			if (fw_numb <= 1) {
				alert("数量不足了，请住手！")
			} else {
				fw_numb--;
				$(".srkk").val(fw_numb);
			}
			tola();
		})

	});

	function tola() {
		var $li = $(".fwmc_xxk").children("li.on");
		var money = $li.children("i").text();
		var count = $(".srkk").val();
		$(".zwfb_zje span").text(money * count);
	}

	/**
	 * 支付方式
	 */

	ra = document.getElementsByName('bank');
	len = ra.length;
	for (i = 0; i < len; i++) {
		ra[i].onclick = function() {
			la = document.getElementsByTagName('label');
			len2 = la.length;
			for (j = 0; j < len2; j++) {
				la[j].className = la[j].className.replace('checked', '');
			}
			var label_id = this.getAttribute('id') + '_label';
			var label_obj = document.getElementById(label_id);
			label_obj.className += " checked";
		}
	}

	function rechargePay() {
		//购买金额
		var $li = $(".fwmc_xxk").children("li.on");
		var money = $li.children("i").text();
		var count = $(".srkk").val();
		var pay = money * count;
		
		var packageNumber = $li.children("p").text();
		var id = $li.attr("id"); 
		var sellerId = $("#sellerId").val();

		
		if($("#weChatPay").get(0).checked) {
			 $.post("mt/sellerAccountTradeLog/ECoinRecharge",{'sellerId':sellerId,'voucherCenterId':id,'number':count},function(r){
				if(r.success){
					alert("操作成功！")
					window.location = window.location;
				}
			})  
		} 
		if($("#zfbPay").get(0).checked) {
			var WIDout_trade_no = new Date().getTime();    
			var WIDsubject = "e币充值";
			$.post("alipay/base/alipayPc",{'WIDout_trade_no':WIDout_trade_no,'WIDtotal_amount':pay,'WIDsubject':WIDsubject,'sellerId':sellerId,'setMealId':id,'number':count},function(r){
				if(r.success){
					$("#alipay").append(r.data);
				}
			})  
			

		}
		if($("#zfbPay").get(0).checked == false){
            alert("请选择支付方式")
		}
	};
</script>

