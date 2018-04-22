<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html class="no-js">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<%@ include file="../../common.jsp"%>
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
	
</head>
<body>
<div class=" admin-content">     
			<input id="sellerId" style="display: none;" value="<%= currentUser != null ? currentUser.getSellerId() : null%>"/>
         <div class=" admin-content"> 
         <!-- 7天交易金额 -->    
			<div class="am-panel am-panel-default">
			  <div class="am-panel-hd" style="height: 40px;">7天交易金额分析</div>
			  <div class="am-panel-bd">
			  	<hr/>
                 <div id="main" style="height:400px"></div>
 				
			  </div>
			</div>
	 	<!-- 30天 成交数-->	
			<div class="am-panel am-panel-default">
			  <div class="am-panel-hd" style="height: 40px;">30天交易笔数分析</div>
			  <div class="am-panel-bd">
			  	<hr/>
                 <div id="successNumber" style="height:400px"></div>
 				
			  </div>
			</div>
		</div>
		</div>
</body>

<script>
	/* 七天交易量 */
	var datas = [];
	$.post("mt/mtSeller/getSellerSevenDayAchievement",{"id":$("#sellerId").val()},function(r){
		if(r.success){
			datas = r.data;
		}
	})
	
	var label = []; 
	for(var i = 6 ; i>=0 ;i--){
		//获取三十天前日期
		var myDate = new Date();
		var lw = new Date(myDate - 1000 * 60 * 60 * 24 * i);//最后一个数字30可改，30天的意思
		var lastY = lw.getFullYear();
		var lastM = lw.getMonth()+1;
		var lastD = lw.getDate();
		var startdate=(lastM<10 ? "0" + lastM : lastM)+"-"+(lastD<10 ? "0"+ lastD : lastD);//三十天之前日期
		label.push(startdate);
		}
	
	
	// 路径配置
	require.config({
	    paths: {
	        echarts: 'http://echarts.baidu.com/build/dist'
	    }
	});
	
	// 使用
	require(
	    [
	        'echarts',
	        'echarts/chart/line' // 使用柱状图就加载bar模块，按需加载
	    ],
	    function (ec) {
	        // 基于准备好的dom，初始化echarts图表
	        var myChart = ec.init(document.getElementById('main')); 
	        
	        var option = {
	   		  title : {
	   		    text: '最近7日交易情况',
	   	        subtext: '单位：元'
	   		    },	
	            tooltip: {
	                show: true,
	            },
	            legend: {
	                data:['交易成功金额']
	            },
	            xAxis : [
	                {
	                    type : 'category',
	                    data : label
	                }
	            ],
	            yAxis : [
	                {
	                    type : 'value'
	                }
	            ],
	            series : [
	                {
	                    "name":"交易成功金额",
	                    "type":"line",
	                    "data":datas
	                }
	            ]
	        };
	
	        // 为echarts对象加载数据 
	        myChart.setOption(option); 
	    }
	);
	
	
	  /*30天 成交数*/
	var data = [];
	$.post("mt/mtSeller/getSellerAchievement",{"id":$("#sellerId").val()},function(r){
		if(r.success){
			data = r.data;
		}
	})

	var labels = []; 
	for(var i = 29 ; i>=0 ;i--){
	//获取三十天前日期
	var myDate = new Date();
	var lw = new Date(myDate - 1000 * 60 * 60 * 24 * i);//最后一个数字30可改，30天的意思
	var lastY = lw.getFullYear();
	var lastM = lw.getMonth()+1;
	var lastD = lw.getDate();
	var startdate=(lastM<10 ? "0" + lastM : lastM)+"-"+(lastD<10 ? "0"+ lastD : lastD);//三十天之前日期
	labels.push(startdate);
	}
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/bar' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var chart = ec.init(document.getElementById('successNumber')); 
                
                var option = {
              		title : {
          	   		    text: '最近30日交易笔数情况',
          	   	        subtext: '单位：笔'
          	   		    },	
                    tooltip: {
                        show: true
                    },
                    legend: {
                        data:['成功交易笔数']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            data :labels
                        }
                    ],
                    yAxis : [
                        {
                            type : 'value'
                        }
                    ],
                    series : [
                        {
                            "name":"成功交易笔数",
                            "type":"bar",
                            "data":data
                        }
                    ]
                };
        
                // 为echarts对象加载数据 
                chart.setOption(option); 
            }
        );
    </script>
	
	
</script>
</html>