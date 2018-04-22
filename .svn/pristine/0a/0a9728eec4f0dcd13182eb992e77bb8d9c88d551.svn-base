$(document).ready(function(){
  $("#saveGoods").click(function(){
	 var goodsName = $("#goods_name").val(); //获取商品名
	  var secondLevelCategory = $("#cat").val();//获取分类
	  var address = $("#address").val();
	  var goodsRate = $("#goods_rate").val();
	  var goodsDesc = $("#goods_desc").val();
	  var goodsStatus = $("#goodsStatus").val();
	  var remark = $("#remark").val();
	  var freight = $("#goods_postage").val();
	  var create_time = new Date(+new Date()+8*3600*1000).toISOString().replace(/T/g,' ').replace(/\.[\d]{3}Z/,'') 
	  var creator = 1;
	  var indexImgUrl ="http://osrmg809g.bkt.clouddn.com/pic1.png";
	  var goodsSpecs = [];
	  var spce = [];
	  var price= [];
	  var goodsNumber = [];
	  var warnNumber = []
	  var i;
	  $("input[name='space']").each(function(index,item){
		 spce.push($(this).val());
	  });	
	  $("input[name='price']").each(function(index,item){
		  price.push($(this).val());
	  });
	  $("input[name='goods_number']").each(function(index,item){
		  goodsNumber.push($(this).val());
	  });
	  $("input[name='warn_number']").each(function(index,item){
		  warnNumber.push($(this).val());
	  });
	 
	  /*	 var data = {                           参数结果
	  address: "yirenguzhen",
	  goodsSpecs:[
	              {price:20, spce: ""},
	              {price:20, spce: ""}
	  ]
  }*/
	  
	  
	  for(i=0;i<spce.length;i++){
		  for(i=0;i<price.length;i++){
			var goods = {};
		    goods.spce =spce[i];
		    goods.price =price[i];
		    goods.goodsNumber = goodsNumber[i];
		    goods.warnNumber = warnNumber[i];
		    goodsSpecs[i]=goods;
		  }
	   
     } 
	  
	 var data = {'goodsName':goodsName,'secondLevelCategory':secondLevelCategory,'address':address,'goodsRate':goodsRate,
			     'goodsDesc':goodsDesc,'createTime':create_time,'creator':creator,'goodsStatus':goodsStatus,'goodsSpecs':goodsSpecs,
			     'remark':remark,'freight':freight,'indexImgUrl':indexImgUrl}
	 $.get("mt/mtGoods/updateData", {entity:JSON.stringify(data)}, function(r){
		 if (r.success) {
			 alert("添加成功！");
		     window.location.reload();
		 }else{
			 alert("添加失败！");
		 }
     })
	 
  });
});

//修改商品
function editGoodPage(id){
	alert(id)
}
