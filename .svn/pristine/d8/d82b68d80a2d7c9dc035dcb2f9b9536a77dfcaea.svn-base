<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link type="text/css" rel="stylesheet" href="static/assets/minicolors/jquery.minicolors.css"/>
<script type="text/javascript" src="static/assets/minicolors/jquery.minicolors.min.js"></script>
<script type="text/javascript" src="static/assets/bootstrap-file-upload/ajaxfileupload.js"></script>
<div class="row">
	<div class="col col-sm-10">
		<form class="form-horizontal" role="form">
			<input type="text" style="display: none;" name="id" class="col-xs-12 col-sm-12" value="${entity.id }">
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right">奖品分类</label>
				<div class="col-sm-10">
					<input id="inputPrizesCategory" value="${entity.prizesCategory }" style="display: none;"/>
					<select name="prizesCategory" id="prizesCategory" class="col-xs-6 col-sm-6" onchange="categoryChange($(this));">
						<option value="0">e币</option>
						<option value="1">可兑换商品</option>
						<option value="2">谢谢参与</option>
					</select>
					<input type="text" placeholder="请输入e币数量" name="integrateCount" id="integrateCount" class="col-xs-6 col-sm-6" value="${entity.integrateCount == null ? 0 : entity.integrateCount}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right">名称</label>
				<div class="col-sm-10">
					<input type="text" placeholder="请输入奖品名称" name="title" class="col-xs-12 col-sm-12" value="${entity.title }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right">图标</label>
				<div class="col-sm-10">
					<iframe style="width: 100%; height: 40px;" src="file-upload/page" name="file-upload-iframe">
					</iframe>
					<input name="logo" id="logoAttId" style="display: none;" value="${entity.logo }">
					<input name="logo" id="logoUrl" style="display: none;" value="${entity.logoUrl }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right">数量(/份)</label>
				<div class="col-sm-10">
					<input type="text" placeholder="数量" name="count" class="col-xs-12 col-sm-12" value="${entity.count }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right">背景色</label>
				<div class="col-sm-10">
					<input type="text" id="backgroundColor" name="backgroundColor" placeholder="转盘中显示的背景色" name="backgroundColor" class="col-xs-12 col-sm-12" value="${entity.backgroundColor}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right">中奖率</label>
				<div class="col-sm-10">
					<input id="inputWinningRate" value="${entity.winningRate }" style="display: none;"/>
					<select name="winningRate" id="winningRate" class="col-xs-12 col-sm-12">
						<option value="0">是</option>
						<option value="1">否</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right">排序</label>
				<div class="col-sm-10">
					<input type="text" placeholder="排序" name="sort" class="col-xs-12 col-sm-12" value="${entity.sort }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right">备注</label>
				<div class="col-sm-10">
					<input type="text" placeholder="备注" name="remark" class="col-xs-12 col-sm-12" value="${entity.remark }">
				</div>
			</div>
		</form>
	</div>
	<div class="col col-sm-2">
		<div id="imageDiv">
		</div>
	</div>
</div>
<style type="text/css">
.minicolors-theme-bootstrap .minicolors-swatch {
    top: 0;
}
</style>
<script type="text/javascript">
$(function(){
	if($("#inputWinningRate").val()){
		$("#winningRate option[value='" + $("#inputWinningRate").val() + "']").attr("selected", true);
	}
	if($("#inputPrizesCategory").val()){
		$("#prizesCategory option[value='" + $("#inputPrizesCategory").val() + "']").attr("selected", true);
		if($("#inputPrizesCategory").val() == 0){
			$("#integrateCount").removeAttr("disabled");
		} else {
			$("#integrateCount").val(0);
			$("#integrateCount").attr("disabled", "disabled");
		}
	}
	if($("#logoAttId").val()){
		$("#imageDiv").children().remove();
		$("#imageDiv").append("<img style='width:84px;height:84px;' src='showImage?uuid=" + $("#logoUrl").val() + "'><img>");
	}
	$("#backgroundColor").minicolors({
		control: $(this).attr('data-control') || 'hue',
		defaultValue: $(this).attr('data-defaultValue') || '',
		inline: $(this).attr('data-inline') === 'true',
		letterCase: $(this).attr('data-letterCase') || 'lowercase',
		opacity: $(this).attr('data-opacity'),
		position: $(this).attr('data-position') || 'bottom left',
		change: function(hex, opacity) {
			if( !hex ) return;
			if( opacity ) hex += ', ' + opacity;
			try {
				console.log(hex);
			} catch(e) {}
		},
		theme: 'bootstrap'
	});
});
function categoryChange(e){
	if(e.val() == 0){
		$("#integrateCount").removeAttr("disabled");
	} else {
		$("#integrateCount").val(0);
		$("#integrateCount").attr("disabled", "disabled");
	}
}
function iframeCallBack(atts){
	if(atts != null){
		$("#imageDiv").children().remove();
		$("#imageDiv").append("<img style='width:120px;height:120px;' src='showImage?uuid=" + atts[0].uuid + "&fileType=" + atts[0].srcFileType + "'><img>");
		$("#logoAttId").val(atts[0].id);
	}
}
console.log("editor");
</script>