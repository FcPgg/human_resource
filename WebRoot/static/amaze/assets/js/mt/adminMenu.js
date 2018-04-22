$(document).ready(function(){
  $("#saveCat").click(function(){
	  var catName = $("#cat_name").val(); //获取分类
	  var sortOrder = $("#sort_order").val();
	  var pid = -1;
	  $.ajax({
          type: "GET",
          url: "mt/mtCategory/update",
          data: {'catName':catName,'sortOrder':sortOrder,'pid':pid},
          dataType: "json",
          success: function(data){
                 if(data = "true"){
                	 alert("添加成功！")
                	 window.location.reload();
                 }
            }
      });
	  
  });
});
