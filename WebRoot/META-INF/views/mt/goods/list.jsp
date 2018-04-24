<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html class="no-js">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<%@ include file="../../common.jsp"%>
</head>
<body>
		<div class=" admin-content">     
			<div class="am-panel am-panel-default">
			  <div class="am-panel-hd" style="height: 40px;">员工档案<button class="btn btn-primary btn-app btn-xs pull-right" style="margin-top: -5px;" data-toggle="modal" onclick="doAddGoods();">添加档案</button></div>
			  <div class="am-panel-bd">
			  	<form class="form-horizontal" role="form">
                    <fieldset>
                       <div class="form-group">
                          <label class="col-sm-1 control-label" for="ds_host">姓名</label>
                          <div class="col-sm-2">
                             <input class="form-control" id="goodsName" type="text" placeholder="请输入姓名"/>
                          </div>
                          <label class="col-sm-1 control-label" for="ds_name">分类</label>
                          <div class="col-sm-2">
                             <select class="form-control category" id="secondLevelCategory">
                             	<option value="">--全部--</option>
                             </select>
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
		          <table class="am-table am-table-bordered am-table-radius am-table-striped table-condensed  table-striped am-table-centered">
		            <thead >
		              <tr class="am-default" id="goods-table-head">
		                <th class="id"  style="display: none">编号</th>
		                <th class="catName">部门</th>
		                <th class="name">姓名</th>
		                <th class="logoAttUrl">照片</th>
		                <th class="birthday">出生日期</th>
		                <th class="nation">民族</th>
		                <th class="politics">政治面貌</th>
		                <th class="hobby">爱好</th>
		                <th class="description" style="width: 150px;">备注</th>
		           
		            <!--     <th class="cashback">返现金额</th>
		                <th class="status">在售<i class="am-icon-check am-text-warning"></i> /下架 <i class="am-icon-close am-text-primary"></i></th>
		                <th class="creator" style="display: none">上架人</th>
		                <th class="createTime"  style="display: none">上架时间</th>
		                <th class="updator" style="display: none">修改人</th>
		                <th class="udpateTime"  style="display: none">修改日期</th>
		                <th class="undercarriageor" style="display: none">下架人</th>
		                <th class="undercarriageTime"  style="display: none">下架时间</th> -->
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
	
	$.post("mt/mtGoods/listNormalGoods", params, function(r){				
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

//构建档案列表
function createGoodsList(d){
	 $.each(d, function(){
		var tr = "<tr>"
		var item = this; "WebRoot/META-INF/views/admin/groups_permission/group.jsp"
	 	$.each($("#goods-table-head").children(), function(){
	 		if($(this).attr("class") != null){
		 		var td = "<td style='" + ($(this).attr("style") != null ? $(this).attr("style") : "") + "' class='" + $(this).attr("class") + "'>"
		 		if("logoAttUrl" == $(this).attr("class")){
		 			td += item["logoAttUrl"] ? ("<img src='showImage?uuid=" + item["logoAttUrl"] + "' style='width:71px;height:99px;'/>") : "";
		 		} else {
		 			td += (item[$(this).attr("class")] != null ? (item[$(this).attr("class")].length>40 ? item[$(this).attr("class")].substring(0,40)+"...": item[$(this).attr("class")]) : "");
		 		}
		 		td += "</td>";
		 		tr += td;
	 		}
	 	});
	 	tr += '<td><div class="am-btn-group am-btn-group-xs">';
	 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="查看档案" onclick="doGetInfo($(this));"><span class="icon-file-alt"></span></button>';
	 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="修改档案" onclick="doEditGoods($(this));"><span class="am-icon-pencil-square-o"></span></button>';
	 	tr += '<button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除档案" onclick="delArchives($(this));"><span class="am-icon-trash-o" ></span></button>';
	 	tr += '</div></td>';
	 	tr += "</tr>";
			$("#goodsList").append(tr);
	  });
}

/**
 * 查看档案详情
 */
function doGetInfo(e){
	var id = e.parent().parent().parent().find(".id").html();
	data = {
			id: id
		}
	 	$.post("mt/mtGoods/getArchivesInfoById", data, function (r) {
			if (r.success) {
				if (r.data) {
					$("#id").val(r.data.id);
					$("#userName").text(r.data.name);
					$("#sexs").text(r.data.sex == "1" ? '男':'女' );
					$("#birthdays").text(r.data.birthday);
					$("#catName").text(r.data.catName);
					$("#nations").text(r.data.nation);
					$("#politicss").text(r.data.politics);
					$("#idNumbers").text(r.data.idNumber);
					$("#educationss").text(r.data.education);
					$("#telPhones").text(r.data.telPhone);
					$("#schools").text(r.data.school);
					$("#majors").text(r.data.major);
					$("#hobbys").text(r.data.hobby);
					$("#detailDescriptions").text(r.data.detailDescription);
					$("#descriptions").append(r.data.description);
					$("#imgs").attr("src","showImage?uuid="+r.data.logoAttUrl);
				}
			}
		});
		$("#archivesInfo").modal('show');
}

/**
 * 添加档案
 */
 var i = 0;
function doAddGoods(){
	$("#dialog").modal('show');
	$("#dialogLabel").html('员工档案');
	EditorFactory.getInstance();
}

 
/**
 * 修改
 */
function doEditGoods(e){
	var id = e.parent().parent().parent().find(".id").html();
	$.post("mt/mtGoods/getArchivesInfoById",{id:id}, function(r){
		if(r.success){
			$("#data-id").val(r.data.id);
			$("#category").find("option[value=" + r.data.categroy +"]").attr("selected",true);
			$("#name").val(r.data.name);
			$("#sex").find("option[value=" + r.data.sex +"]").attr("selected",true);
			$("#birthday").val(r.data.birthday);
			$("#nation").val(r.data.nation);
			$("#politics").val(r.data.politics);
			$("#idNumber").val(r.data.idNumber);
			$("#education").val(r.data.education);
			$("#telPhone").val(r.data.telPhone);
			$("#school").val(r.data.school);
			$("#major").val(r.data.major);
			$("#hobby").val(r.data.hobby);
			$("#description").val(r.data.description);
			$("#logoAttId").val(r.data.attId);
			if(r.data.logoAttUrl){
				$("#imageDiv").children().remove();
				$("#imageDiv").append("<img style='width:120px;height:120px;' src='showImage?uuid=" + r.data.logoAttUrl+"'><img>");
			}
			if(r.data.detailDescription){
					/* editor.$txt.html(r.data.detailDescription); */
					console.log(r.data.detailDescription);
					var editor = EditorFactory.getInstance();
					editor.txt.html(r.data.detailDescription);
			}
			
			$("#dialog").modal('show');
		} else {
			console.log(r.error);
			alert(r.message);
		}
	})
}

//删除档案
function delArchives(e){
	var id = e.parent().parent().parent().find(".id").html();
	var data = {id : id}
	$.post("mt/mtGoods/remove",data,function(r){
		if(r.success){
			window.location = window.location;
		} else {
			console.log(r.error);
			alert(r.message);
		}		
	});
}

</script>
<jsp:include page="./editor.jsp"></jsp:include>
<jsp:include page="./info.jsp"></jsp:include>
</body>
</html>