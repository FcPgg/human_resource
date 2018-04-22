<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link type="text/css" rel="stylesheet" href="static/assets/bootstrap-file-upload/css/fileinput.css"/>
<script type="text/javascript" src="static/assets/bootstrap-file-upload/js/fileinput.js"></script>
<script type="text/javascript" src="static/assets/bootstrap-file-upload/js/locales/zh.js"></script>
<script type="text/javascript" src="static/assets/bootstrap-file-upload/ajaxfileupload.js"></script>
<div class="row">
	<div class="col col-sm-10">
		<form class="form-horizontal" role="form">
			<input type="text" style="display: none;" name="id" class="col-xs-12 col-sm-12" value="${entity.id }">
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right">名称</label>
				<div class="col-sm-10">
					<input type="text" placeholder="名称" name="name" class="col-xs-12 col-sm-12" value="${entity.name }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right">图标</label>
				<div class="col-sm-10">
					<iframe style="width: 100%; height: 40px;" src="file-upload/page" name="file-upload-iframe">
					</iframe>
					<input name="logoAttId" id="logoAttId" style="display: none;" value="${entity.logoAttId }">
					<input name="logoAttUrl" id="logoAttUrl" style="display: none;" value="${entity.logoAttUrl }">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right">启用支付功能</label>
				<div class="col-sm-10">
					<select placeholder="启用支付功能" name="ifNeedTrade" class="col-xs-12 col-sm-12">
						<option value="0" <c:if test="${entity.ifNeedTrade == '0' }">selected="selected"</c:if>>否</option>
						<option value="1" <c:if test="${entity.ifNeedTrade == '1' }">selected="selected"</c:if>>是</option>
					</select>
				</div>
			</div>
		</form>
	</div>
	<div class="col col-sm-2">
		<div id="imageDiv">
		</div>
	</div>
</div>
<div class="form-group">
	<div class="panel-heading">
		<div class="row">
			<div class="col-xs-8">
				<h3>属性模板配置</h3>
			</div>
			<!-- /.col-xs-8 -->
			<div class="col-xs-4" style="margin-top: 15px">
				<button class="btn btn-primary btn-app btn-xs pull-right" style="margin-top: -5px;" data-toggle="modal" onclick="addProps();">+</button>
				<!-- /input-group -->
			</div>
			<!-- /.col-xs-4 -->
		</div>
	</div>
	<div class="panel-body">
		<table class="am-table am-table-bordered am-table-radius am-table-striped" id="propsTable">
		<thead>
		<tr id="propsTableHead">
			<th class="id" style="display: none;">
				<input type="text"/>
			</th>
			<th class="infoId" style="display: none;">
				<input type="text"/>
			</th>
			<th class="code">
				名称
			</th>
			<th class="controlType">
				控件类型
			</th>
			<th class="dictionary">
				使用数据字典
			</th>
			<th width="163px">
				操作
			</th>
		</tr>
		</thead>
		<tbody>
		<c:if test="entity.props != null">
		<c:forEach var="prop" items="${entity.props}">
		<tr>
			<td class="id" style="display: none;">
				<input class="id" value="${prop.id}" type="text"/>
			</td>
			<td class="infoId" style="display: none;">
				<input class="infoId" value="${prop.infoId}" type="text"/>
			</td>
			<td class="code">
				<input class="code" value="${prop.code}" type="text"/>
			</td>
			<td class="controlType">
				<select class="controlType" onchange="controlTypeChange($(this));">
					<c:forEach var="dict" items="${dictionary}">
					<option value="${dict.code }" <c:if test="${ prop.controlType eq dict.code}">selected="selected"</c:if>> ${dict.description}</option>
					</c:forEach>
				</select>
			</td>
			<td class="dictionary">
				<select class="dictionary" <c:if test="${ prop.controlType eq 'input'}">
					style='display:none'</c:if>>
					<option>请选择字典</option>
					<c:forEach var="dict" items="${dictionaryData}">
					<option value="${dict.code }" <c:if test="${ prop.dictionary eq dict.code}">selected="selected"</c:if>> ${dict.description}</option>
					</c:forEach>
				</select>
			</td>
			<td>
				<button class="btn btn-primary btn-app btn-xs pull-right" style="margin-top: -5px;" onclick="removeProps($(this));">-</button>
			</td>
		</tr>
		</c:forEach>
		</c:if>
		</tbody>
		</table>
	</div>
</div>
<script type="text/javascript">
var controlType = null;
var dictionarys = null;
$(function(){
	if($("#logoAttId").val()){
		$("#imageDiv").children().remove();
		$("#imageDiv").append("<img style='width:84px;height:84px;' src='showImage?uuid=" + $("#logoAttUrl").val() + "'><img>");
	}
	$.get("admin/sysDictionaryDatas/getDictionaryByCode", {code:"mtControlType"}, function(r){
		if(r.success){
			if(r.data){
				controlType = "<select class='controlType' onchange='controlTypeChange($(this))'>";
				$.each(r.data, function(){
					controlType += "<option value='" + this.code + "'>" + this.description + "</option>";
				});
				controlType += "</select>";
			}
		} else {
			console.log("get control type dictionary error:" + r.error);
		}
	});
	$.get("admin/sysDictionaryDatas/getDictionaryByCode", {code:"mtDictionarys"}, function(r){
		if(r.success){
			if(r.data){
				dictionarys = "<select class='dictionary'><option>请选择字典</option>";
				$.each(r.data, function(){
					dictionarys += "<option value='" + this.code + "'>" + this.description + "</option>";
				});
				dictionarys += "</select>";
			}
		} else {
			console.log("get dictionary error:" + r.error);
		}
	});
});
function controlTypeChange(e){
	if(e.val() == "input"){
		e.parent().parent().find("select.dictionary option:eq(0)").attr('selected','selected');
		e.parent().parent().find("select.dictionary").hide();
	} else {
		e.parent().parent().find("select.dictionary").show();	
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
function addProps(){
	var tr = "<tr>";
	$.each($("#propsTableHead").children(), function(){
		var clazz = $(this).attr("class");
 		var style = $(this).attr("style");
 		var td = null;
 		if(clazz != null){
	 		td = "<td style='" + (style != null ? style : "") + "' class='" + clazz + "'>";
	 		if(clazz == "controlType" && controlType){
	 			td += controlType;
	 		} else if(clazz == "dictionary" && dictionarys){
	 			td += dictionarys;
	 		} else {
		 		td += "<input type='text' class='" + clazz + "'/ >";
	 		}
	 		td += "</td>";
 		} else {
 			td = '<td><button class="btn btn-primary btn-app btn-xs pull-right" style="margin-top: -5px;" onclick="removeProps($(this));">-</button></td>';
 		}
		tr += td;
	});
	tr += "</tr>";
	$("#propsTable tbody").append(tr);
}
function removeProps(e){
	var id = e.parent().parent().find("input.id").val();
	if(id){
		if(confirm("确定删除这条数据吗?此操作不可恢复")){
			$.post("mt/mtUserPublishPropsTemplate/remove", {id: id}, function(r){
				if(r.success){
					e.parent().parent().remove();					
				} else {
					console.log("remove prop error :" + r.error);
				}
			});
		}
	} else {
		e.parent().parent().remove();
	}
}
</script>