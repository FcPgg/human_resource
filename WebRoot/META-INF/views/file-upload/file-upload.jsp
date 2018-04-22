<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<%@ include file="../common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style type="text/css">
body {
	overflow: hidden;
}
</style>
</head>
<body>
	<form action="./fileUpload" enctype="multipart/form-data" target="file_upload_return" class="am-form am-form-horizontal"  method="post">
	 	<div class="am-form-group">
	 	 <div class="am-u-sm-10" >
			 <div class="am-form-group am-form-file">
			  <button type="button" class="am-btn am-btn-default am-btn-sm">
			    <i class="am-icon-cloud-upload"></i> <span id="file-name">选择要上传的文件</span></button>
			  <input type="file" name="file" id="file" >
			</div>
    	</div>
    	<div class="am-u-sm-2" >
	    	<button type="submit" class="am-btn am-btn-success am-round" id="btn-upload">上传</button>
	    </div>
	    </div>
	</form>
	<iframe id="file_upload_return" name="file_upload_return" style="display: none;"></iframe>
	<script type="text/javascript">
		var file = $('#file'),
		fileName = $('#file-name');
		file.on('change', function( e ){
		    //e.currentTarget.files 是一个数组，如果支持多个文件，则需要遍历
		    var name = e.currentTarget.files[0].name;
		    fileName.html( name );
		});

		//是否多张上传
		function ifMultipleUpload(){
			file.attr("multiple", "multiple");
		}
	</script>
	<script type="text/javascript">
		$("#file_upload_return").load(function(){//获取iframe中的内容
 			var body = $(window.frames['file_upload_return'].document.body);
 			var result = eval('(' + body[0].textContent + ')');  
 			if(result.success){
 				parent.iframeCallBack(result.data);
 			} else {
 				alert("文件上传失败！")
 				console.log(r.message);
 			}
		});
	</script>
</body>
</html>