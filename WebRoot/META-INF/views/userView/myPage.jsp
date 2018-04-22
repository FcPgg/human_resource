<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../commons.jsp"%>
<base href="<%=basePath%>">
<!doctype html>
<html class="no-js">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<script src="static/admin/mt/assets/js/index.js"></script>
<script src="static/assets/chart/echarts.js"></script>
  
</head>
<body>

</head>

<body>
<header class="am-topbar admin-header">
  <div class="am-topbar-brand"><img src="static/amaze/assets/i/logo.jpg" style="width:100px;height:50px;"></div>

</header>

<div class="am-cf admin-main"> 

<div class="nav-navicon admin-main admin-sidebar">
    
    
    <div class="sideMenu am-icon-dashboard" style="color:#aeb2b7; margin: 10px 0 0 0;"> 欢迎系统管理员：清风抚雪</div>
    <div class="sideMenu">
      <h3 class="am-icon-flag"><em></em> <a href="JavaScript:void(0);">个人中心</a></h3>
      <ul>
        <li><a href="javascript:void(0);" onclick="sx()">个人中心</a></li>
        <li><a href="javascript:void(0);" onclick="tj()">疾病统计</a></li>
        <li><a href="javascript:void(0);" onclick="tj()">个人账户</a></li>
      </ul>
    </div>
    <!-- sideMenu End --> 
    
    <script type="text/javascript">
			jQuery(".sideMenu").slide({
				titCell:"h3", //鼠标触发对象
				targetCell:"ul", //与titCell一一对应，第n个titCell控制第n个targetCell的显示隐藏
				effect:"slideDown", //targetCell下拉效果
				delayTime:300 , //效果时间
				triggerTime:250, //鼠标延迟触发时间（默认150）
				defaultPlay:true,//默认是否执行效果（默认true）
				returnDefault:true //鼠标从.sideMen移走后返回默认状态（默认false）
				});
		</script> 

    
    
</div>

<div class=" admin-content">
	
<div class="daohang">
	<ul>
		<li><button type="button" class="am-btn am-btn-default am-radius am-btn-xs"> 首页 </li>				
	</ul>
</div>

	


<div class="admin-biaogelist">
	
    <div class="listbiaoti am-cf">
      <ul class="am-icon-flag on"> 个人中心</ul>
      
      <dl class="am-icon-home" style="float: right;"> 当前位置： 首页 > <a href="javascript:void(0);">个人中心</a></dl>
      
      <dl>
        <button type="button" class="am-btn am-btn-danger am-round am-btn-xs am-icon-plus" onclick="doAddProblem()">发布疾病</button>
      </dl>
      
      
    </div>
	<div id="tj">
    <form class="am-form am-g">
          <table width="100%" class="am-table am-table-bordered am-table-radius am-table-striped">
            <thead>
              <tr class="am-success" id="ad-table-head">
                        <th class="address">地区</th>
                        <th class="catName">分类名称</th>
                        <th class="logoAttUrl">展示图片</th>
                        <th class="season">季节</th>
                        <th class="symptom">症状</th>
                        <th class="describe">描述</th>
                        <th class="createTime">发布时间</th>
                        <th width="163px">操作</th>
              </tr>
            </thead>
            <tbody id="adList">
            </tbody>
          </table>
             <div id="example" style="text-align: center"> <ul id="pageLimit" class="pagination"></ul> </div>
                 <div class="am-btn-group am-btn-group-xs">
              <button type="button" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 刷新</button>
            </div>
          <hr/>
        </form> 
        
   </div>
 
 
 
 <div class="foods">
  <ul>
    版权所有@2015
  </ul>
  <dl>
    <a href="" title="返回头部" class="am-icon-btn am-icon-arrow-up"></a>
  </dl>
</div>




</div>

</div>




</div>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]--> 

<!--[if (gte IE 9)|!(IE)]><!--> 
<!-- <script src="assets/js/amazeui.min.js"></script> -->
<script type="text/javascript">
function sx(){
	window.location.reload();
}

$(function(){
	loadData(1);
});

function loadData(page){
	
	var params = {page: page, rows: 10};
	
	$.post("mt/mobile/diseaseManager/listNormalDisease", params, function(r){				
		if(r.success){
			if(r.data){
				$("#adList").children().remove();
				createGoodsList(r.data.data);
				$.jqPaginator('#pageLimit',{
					totalPages: r.data.totalPageNum,
			        visiblePages: 10,
			        currentPage: page,
			        prev: '<li class="prev"><a href="javascript:;">上一页</a></li>',
			        next: '<li class="next"><a href="javascript:;">下一页</a></li>',
			        page: '<li class="page"><a href="javascript:;">{{page}}</a></li>',
				    onPageChange: function (num, type) {
				    	if(type == "change"){
				    		loadData(num);
				    	}
				    }
				});
			}
		}
	});
}

//构建广告列表
function createGoodsList(d){
	 $.each(d, function(){
		var tr = "<tr>"
		var item = this; "WebRoot/META-INF/views/admin/groups_permission/group.jsp"
	 	$.each($("#ad-table-head").children(), function(){
	 		if($(this).attr("class") != null){
		 		var td = "<td style='" + ($(this).attr("style") != null ? $(this).attr("style") : "") + "' class='" + $(this).attr("class") + "'>"
		 		if("status" == $(this).attr("class")){
		 			td += item["status"] == 0 ? '<i class="am-icon-check am-text-warning"></i>' : '<i class="am-icon-close am-text-primary"></i>';
		 		} else if("logoAttUrl" == $(this).attr("class")){
		 			td += item["logoAttUrl"] ? ("<img src='showImage?uuid=" + item["logoAttUrl"] + "' style='width:80px;height:80px;'/>") : "";
		 		} else {
			 		td += (item[$(this).attr("class")] != null ? (item[$(this).attr("class")].length>40 ? item[$(this).attr("class")].substring(0,20)+"...": item[$(this).attr("class")]) : "");
		 		}
		 		td += "</td>";
		 		tr += td;
	 		}
	 	});
	 	tr += '<td><div class="am-btn-group am-btn-group-xs">';
	 	/* tr += '<a class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="修改" onclick="doEditAdvertisement(id='+this.id+');"><span class="am-icon-pencil-square-o"></span></a>'; */
	 	tr += '<a class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除" onclick="doDelAd(id='+this.id+');"><span class="am-icon-trash-o" ></span></a>';
	 	tr += '</div></td>';
	 	tr += "</tr>";
			$("#adList").append(tr);
	  });
}

function tj(){
	$("#tj").children().remove();
	$("#adList").children().remove();
	var html = '<div id="main" style="width: 900px;height:400px;"></div>'
	           +'<div id="line" style="width: 900px;height:400px;"></div>';
	$('#tj').append(html);  
	
	/*前10疾病*/
	var databar = [];
	$.post("mt/disease/getTopTenDisease",{"id":$("#sellerId").val()},function(r){
		if(r.success){
			data = r.data;
		}
	})
	
	// 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '2018前十疾病'
        },
        tooltip: {},
        legend: {
            data:['疾病']
        },
        xAxis: {
            data: ["测试感冒","发烧","咳嗽","拉肚子","测试","测试2"]
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: [5, 20, 36, 10, 10, 20]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
    
    /*前10疾病*/
	var dataLine = [];
	$.post("mt/disease/getTopTenDisease",{"id":$("#sellerId").val()},function(r){
		if(r.success){
			dataLine = r.data;
		}
	})
	// 基于准备好的dom，初始化echarts实例
    var line = echarts.init(document.getElementById('line'));

    // 指定图表的配置项和数据
    var optionLine = {
        title: {
            text: '2018前十疾病'
        },
        tooltip: {},
        legend: {
            data:['疾病']
        },
        xAxis: {
            data: ["测试感冒","发烧","咳嗽","拉肚子","测试","测试2"]
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'line',
            data: [5, 20, 36, 10, 10, 20]
        }]
    };

    // 使用刚指定的配置项和数据显示图表。
    line.setOption(optionLine); 
}
</script>



</body>
</html>