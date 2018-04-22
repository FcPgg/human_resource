$(document).ready(function(){
  $("#saveSeller").click(function(){
	  if($("#name").val()==""){
			$("#name").tips({
				side:3,
	            msg:'请输入商家名称',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#name").focus();
			return false;
		}
	  if($("#peson").val()==""){
			$("#peson").tips({
				side:3,
	            msg:'请输入商家负责人',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#peson").focus();
			return false;
		}
	  
	  if($("#idNumber").val()==""){
			$("#idNumber").tips({
				side:3,
	            msg:'请输入负责人身份证号',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#idNumber").focus();
			return false;
		}
	  if($("#bank").val()==""){
			$("#bank").tips({
				side:3,
	            msg:'请输入商家银行账户',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#bank").focus();
			return false;
		}
	  
	  if($("#Map_input_callback").val()==""){
			$("#Map_input_callback").tips({
				side:3,
	            msg:'请输入商家地址',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#Map_input_callback").focus();
			return false;
		}
	  if($("#tel").val()==""){
			$("#tel").tips({
				side:3,
	            msg:'请输入商家电话',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#tel").focus();
			return false;
		}
	  
	  if($("#business_scope").val()==""){
			$("#business_scope").tips({
				side:3,
	            msg:'请输入经营范围',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#business_scope").focus();
			return false;
		}
	  var province = $("#province").val();
	  var city = $("#city").val();
	  var district = $("#district").val();
	  var id = $.session.get("sellerId");
	  var name = $("#name").val();
	  var categoryId = $("#cat").val();
	  var address = $("#Map_input_callback").val();
	  var phoneNumber = $("#tel").val();
	  var remark = $("#remark").val();
	  var businessScope = $("#business_scope").val();
	  var lng = $("#lng").val();
	  var lat = $("#lat").val();
	  var reaponsiblePeson = $("#peson").val();
	  var idNumber = $("#idNumber").val();
	  var bankAccount = $("#bank").val();
	  var password = 123456;
	  if(typeof($.session.get('sellerId')) == "undefined"){
	  data = {
			  'name':name,
			  'categoryId':categoryId,
			  'address':address,
			  'phoneNumber':phoneNumber,
			  'remark':remark,
			  'businessScope':businessScope,
			  'lng':lng,
			  'lat':lat,
			  'reaponsiblePeson':reaponsiblePeson,
			  'idNumber':idNumber,
			  'bankAccount':bankAccount,
			  'reviewed':0,
			  'province':province,
			  'city':city,
			  'district':district,
			  'operator':$("#currentUserId").val(),
			  'userInfo':[{'userName':name,'password':md5(password)}]
	  }
	  $.get("mt/mtSeller/updateData", {entity: JSON.stringify(data)}, function(r){
		 if (r.success) {
			 alert("添加成功！");
				window.location = window.location;
		 }else{
			 alert("添加失败！");
		 }
       })
	  }else{
		  data = {'id':id,'name':name,'categoryId':categoryId,'address':address,'phoneNumber':phoneNumber,'remark':remark,'businessScope':businessScope,'lng':lng,'lat':lat}
		  $.get("mt/mtSeller/updateData", data, function(r){
			 if (r.success) {
				 alert("更新成功！");
				 $.session.remove('sellerId');
			     window.location.reload();
			 }else{
				 alert("更新失败！");
			 }
	       })
	  }
  });
});


function editSellerPage(id){
	$.session.set('sellerId', id);
	 location.href = "mt/mtSeller/page?title=商家修改&pagePath=mt/seller/save_seller"
}

//判断商家名称是否重名
$(function(){
$("#name").focusout(function(){
	var name = $("#name").val();
	if(name != '' && name != null){
		checkName(name);
	}
	function checkName(name){
	data = {"name":name}
	$.post("mt/mtSeller/getSellerBySellerName",data,function(r){
		
		if(r.data.name != null){
			alert("商家名重复！");			
		}
		
	});
	}
  });
});
