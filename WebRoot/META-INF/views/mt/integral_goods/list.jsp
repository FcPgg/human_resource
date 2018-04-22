<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html class="no-js">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<%@ include file="../../common.jsp"%>
</head>
<body>
      <input id="currentUserId" style="display: none;" value="<%= currentUser != null ? currentUser.getId() : null%>"/>
		<div class=" admin-content">     
			<div class="am-panel am-panel-default">
			  <div class="am-panel-hd" style="height: 40px;">积分商品列表<button class="btn btn-primary btn-app btn-xs pull-right" style="margin-top: -5px;" data-toggle="modal" onclick="doAddGoods();">上架商品</button></div>
			  <div class="am-panel-bd">
			  	<form class="form-horizontal" role="form">
                    <fieldset>
                       <div class="form-group">
                          <label class="col-sm-1 control-label" for="ds_host">名称</label>
                          <div class="col-sm-2">
                             <input class="form-control" id="name" type="text" placeholder="商品名称"/>
                          </div>
                          <label class="col-sm-1 control-label" for="ds_username">状态</label>
                          <div class="col-sm-2">
                             <select class="form-control" id="goodsStatus">
                             	<option value="">--全部--</option>
                             	<option value="0">在售</option>
                             	<option value="9">已下架</option>
                             </select>
                          </div>
                          <button class="btn btn-primary btn-app btn-xs " type="button" style="margin-top: -2px;" onclick="loadData(1);">查询</button>
                          <button class="btn btn-warning btn-app btn-xs" type="reset" style="margin-top: -2px;">重置</button>
                       </div>
                    </fieldset>     
                  </form>
			  	<hr/>
		          <table class="am-table am-table-bordered am-table-radius am-table-striped table-condensed  table-striped">
		            <thead >
		              <tr class="am-default" id="goods-table-head">
		                <th class="name">名称</th>
		                <th class="price" style="width: 150px;">兑换所需e币/个</th>
		                <th class="count" style="display: none">数量</th>
		                <th class="startTime">开始时间</th>
		                <th class="endTime">结束时间</th>
		                <th class="creatorName">创建人</th>
		                <th class="createTime">创建时间</th>
		                <th class="remark">备注</th>
		                <th class="logoAttUrl">展示图片</th>
		                <th width="163px">操作</th>
		              </tr>
		            </thead>
		            <tbody id="goodsList">
		            </tbody>
		          </table>
      				<div id="example" style="text-align: center"> <ul id="pageLimit" class="pagination"></ul> </div>
			  </div>
			</div>
		</div>
	
<script type="text/javascript">


var EditorFactory = (function(){
		var instance = null;
		
		function createEditor(){
			var E = window.wangEditor
			var eidtor = null;
			editor = new E('#titleDiv', '#contentDiv')  // 两个参数也可以传入 elem 对象，class 选择器
			editor.customConfig.menus = [
		                                    'head',  // 标题
		                                    'bold',  // 粗体
		                                    'italic',  // 斜体
		                                    'underline',  // 下划线
		                                    'strikeThrough',  // 删除线
		                                    'foreColor',  // 文字颜色
		                                    'backColor',  // 背景颜色
		                                    'justify',  // 对齐方式
		                                    'image',  // 插入图片
		                                    'table',  // 表格
		                                    'undo',  // 撤销
		                                    'redo'  // 重复
		                                ];
		       editor.customConfig.uploadImgServer = 'fileUpload'; //上传地址
		       editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;//图片大小
		       editor.customConfig.uploadFileName = 'file';//上传图片属性名
		       editor.customConfig.uploadImgHooks = {
		   	    success: function (xhr, editor, result) {
		   	        // 图片上传并返回结果，图片插入成功之后触发
		   	        // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
		   	        console.log("success");
		   	        
		   	    },
		   	    fail: function (xhr, editor, result) {
		   	        // 图片上传并返回结果，但图片插入错误时触发
		   	        // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象，result 是服务器端返回的结果
		   	    	console.log("fail");
		   	    },
		   	    error: function (xhr, editor) {
		   	        // 图片上传出错时触发
		   	        // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
		   	    	console.log("error");
		   	    },
		   	    timeout: function (xhr, editor) {
		   	        // 图片上传超时时触发
		   	        // xhr 是 XMLHttpRequst 对象，editor 是编辑器对象
		   	    	console.log("timeout");
		   	    },

		   	    // 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
		   	    // （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
		   	    customInsert: function (insertImg, result, editor) {
		   	        // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
		   	        // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果

		   	        // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
		   	        console.log(result);
		   	        var data = result.data
			   	    if(data){
		     	        	$.each(data, function(){
				        	        insertImg("/Web/showImage?uuid=" + this.uuid + "." + this.srcFileType);
		     	        	});
	  	        	}
 

		   	        // result 必须是一个 JSON 格式字符串！！！否则报错
		   	    }
		    }
		    editor.create();
		    return editor;
		};
		
		function createInstance(){
			return new createEditor();
		};
		
		return{
			getInstance : function(){
				if(!instance){
					instance = createInstance();
				}
				return instance;
			}
		}
})();



$(function(){
	loadData(1);
});

function loadData(page){
	
	var params = {page: page, rows: 10};
	
	if($("#goodsName").val()){
		params.name = $("#goodsName").val();
	}
	
	if($("#goodsStatus").val()){
		params.status = $("#goodsStatus").val();
	}
	
	$.post("mt/integrateGoods/listNormalIntegrateGoods", params, function(r){				
		if(r.success){
			if(r.data){
				$("#goodsList").children().remove();
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

//构建商品列表
function createGoodsList(d){
	 $.each(d, function(){
		var tr = "<tr>"
		var item = this; 
	 	$.each($("#goods-table-head").children(), function(){
	 		if($(this).attr("class") != null){
		 		var td = "<td style='" + ($(this).attr("style") != null ? $(this).attr("style") : "") + "' class='" + $(this).attr("class") + "'>"
		 		if("status" == $(this).attr("class")){
		 			td += item["status"] == 0 ? '<i class="am-icon-check am-text-warning"></i>' : '<i class="am-icon-close am-text-primary"></i>';
		 		} else if("logoAttUrl" == $(this).attr("class")){
		 			td += item["logoAttUrl"] ? ("<img src='showImage?uuid=" + item["logoAttUrl"] + "' style='width:80px;height:80px;'/>") : "";
		 		} else {
			 		td += (item[$(this).attr("class")] != null ? item[$(this).attr("class")] : "");
		 		}
		 		td += "</td>";
		 		tr += td;
	 		}
	 	});
	 	tr += '<td><div class="am-btn-group am-btn-group-xs">';
	 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="修改商品" onclick="doEditGoods(id='+this.id+');"><span class="am-icon-pencil-square-o"></span></button>';
	 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除商品" onclick="doDelGoods(id='+this.id+');"><span class="am-icon-trash-o" ></span></button>';
	 	tr += '</div></td>';
	 	tr += "</tr>";
			$("#goodsList").append(tr);
	  });
}
 
/**
 * 修改
 */
function doEditGoods(e){
    $("#integrateGoodsId").val(e);
	$.post("mt/integrateGoods/get",{id:e},function(r){
		if(r.success){
			$("#goodsName").val(r.data.name),
	       	$("#price").val(r.data.price),
	       	$("#startTime").val(r.data.startTime),
	       	$("#endTime").val(r.data.endTime),
	       	$("#logoAttId").val(r.data.logoAttId),
	       	$("#logoAttUrl").val(r.data.logoAttUrl),
	       	$("#count").val(r.data.count)
       	
	       	if(r.data.detailInfo){
				/* editor.$txt.html(r.data.detailDescription); */
				console.log(r.data.detailInfo);
				var editor = EditorFactory.getInstance();
				editor.txt.html(r.data.detailInfo);
			}
	       	$("#dialog").modal('show');
			$("#dialogLabel").html('上架商品');
		}
	})
}

/**
 * 添加商品
 */
function doAddGoods(){
	$("#dialog").modal('show');
	$("#dialogLabel").html('上架商品');
	EditorFactory.getInstance();
}
/**
 * 删除商品
 */
 function doDelGoods(e){
	 if( e && confirm("确定执行下架操作吗？此操作不可还原")){
	$.post("mt/integrateGoods/doDelGoods",{id:e,removetor:$("#currentUserId").val()},function(r){
		if(r.success){
			window.location = window.location;         	
		}
	})
  }
}

</script>
<jsp:include page="./editor.jsp"></jsp:include>
</body>
</html>