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
	  if($("#phoneNumber").val()==""){
			$("#phoneNumber").tips({
				side:3,
	            msg:'请输入商家电话',
	            bg:'#AE81FF',
	            time:2
	        });
			
			$("#phoneNumber").focus();
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
	  var id = $.session.get("sellerId");
	  var name = $("#name").val();
	  var categoryId = $("#cat").val();
	  var address = $("#Map_input_callback").val();
	  var phoneNumber = $("#phoneNumber").val();
	  var remark = $("#remark").val();
	  var businessScope = $("#business_scope").val();
	  var lng = $("#lng").val();
	  var lat = $("#lat").val();
	  if(typeof($.session.get('sellerId')) == "undefined"){
	  data = {'name':name,'categoryId':categoryId,'address':address,'phoneNumber':phoneNumber,'remark':remark,'businessScope':businessScope,'lng':lng,'lat':lat}
	  $.get("mt/mtSeller/update", data, function(r){
		 if (r.success) {
			 alert("添加成功！");
			 
		     window.location.reload();
		 }else{
			 alert("添加失败！");
		 }
       })
	  }else{
		  data = {'id':id,'name':name,'categoryId':categoryId,'address':address,'phoneNumber':phoneNumber,'remark':remark,'businessScope':businessScope,'lng':lng,'lat':lat}
		  $.get("mt/mtSeller/update", data, function(r){
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

/*
 * 编辑商家，回调数据
 */
$(document).ready(function(){
	var id = $.session.get('sellerId');
	if(typeof($.session.get('sellerId')) != "undefined"){
	//	alert($.session.get('sellerId'))
		 data = {'id':id}
		 $.get("mt/mtSeller/get", data, function(r){
			$("#name").val(r.data.name);
			$("#cat").val(r.data.categoryId);
			$("#Map_input_callback").val(r.data.address);
			$("#phoneNumber").val(r.data.phoneNumber);
			$("#lng").val(r.data.lng);
			$("#lat").val(r.data.lat);
		    $("#business_scope").val(r.data.businessScope);
		 });
	}
});
