<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../../common.jsp"%>

<style>
.category-dialog .modal-dialog {
    width: 1000px;
}
.dialog-div{
	height: 600px;
	overflow-y: auto;
    overflow-x: hidden;
}
.background-color {
	width: 30px;
	height: 30px;
}
.background-color-hex{
	float: right;
	margin-top: -30px;
}
.panel{
	margin:0;
}
</style>
<div class="panel panel-default">
	<div class="panel-heading">
		<div class="row">
			<div class="col-xs-8">
				<h3>转盘活动</h3>
			</div>
			<!-- /.col-xs-8 -->
			<div class="col-xs-4" style="margin-top: 15px">
				<button class="btn btn-primary btn-app btn-xs pull-right" style="margin-top: -5px;" data-toggle="modal" onclick="doAdd();">添加奖品</button>
				<!-- /input-group -->
			</div>
			<!-- /.col-xs-4 -->
		</div>
	</div>
	<div class="panel-body">
		<table
			class="am-table am-table-bordered am-table-radius am-table-striped"
			id="table">
			<thead>
				<tr id="table-head">
					<th class="id" style="display: none;"><input type="text" /></th>
					<th class="title">奖品名称</th>
					<th class="logo" style="display: none;">图标附件编号</th>
					<th class="logoUrl">图标</th>
					<th class="prizesCategory">奖品分类</th>
					<th class="count">剩余数量</th>
					<th class="backgroundColor">背景色</th>
					<th class="winningRate">能否中奖</th>
					<th class="validaty">有效期</th>
					<th class="sort">排序</th>
					<th class="remark">备注</th>
					<th width="163px">操作</th>
				</tr>
			</thead>
			<tbody id="orderList">
			</tbody>
		</table>
	</div>
</div>
<script type="text/javascript">
$(function () {
	loadData();
});
var baseURL = "mt/mtPrizes/";

function loadData() {
	$.post(baseURL + "list", null, function (r) {
		if (r.success) {
			$.each(r.data, function () {
				var tr = "<tr>"
				var item = this;
				$.each($("#table-head").children(), function () {
					var clazz = $(this).attr("class");
					var style = $(this).attr("style");
					if (clazz != null) {
						var td = "<td style='" + (style != null ? style : "") + "' class='" + clazz + "'>";
						switch (clazz) {
						case "logoUrl":
							td += "<img style='width:30px; height:30px;' src='showImage?uuid=" + item[clazz] + "'></img>"
							break;
						case "backgroundColor":
							td += '<div class="background-color" style="background-color: ' + item[clazz] + '"></div>';
							td += '<div class="background-color-hex">' + (item[clazz] != null ? item[clazz] : "") + '</div>';
							break;
						case "prizesCategory":
							switch (item[clazz]) {
							case "0":
								td += "e币";
								break;
							case "1":
								td += "可兑换商品";
								break;
							case "2":
								td += "谢谢参与";
								break;
							}
							break;
						case "winningRate":
							switch (item[clazz]) {
							case 0:
								td += "是 ";
								break;
							case 1:
								td += "否";
								break;
							}
							break;
						default:
							td += (item[clazz] != null ? item[clazz] : "");
							break;
						}
						td += "</td>";
						tr += td;
					}
				});
				tr += '<td><div class="am-btn-group am-btn-group-xs">';
				tr += '<button class="am-btn am-btn-default am-btn-xs am-text-secondary am-round" title="修改" onclick="doEdit($(this));"><span class="am-icon-pencil-square-o"></span></button>';
				tr += '<button class="am-btn am-btn-default am-btn-xs am-text-danger am-round" title="删除" onclick="doRemove($(this));"><span class="am-icon-trash-o" ></span></button>';
				tr += '</div></td>';
				tr += "</tr>";
				$("#table tbody").append(tr);
			});
		} else {
			alert(r.message);
			console.log("load secondhand container data error:" + r.error);
		}
	})
}

function doAdd() {
	showDialog();
}

function doEdit(e) {
	var id = e.parent().parent().parent().find(".id").html();
	if (id) {
		showDialog(id);
	}
}

function doRemove(e) {
	var id = e.parent().parent().parent().find(".id").html();
	if (id && confirm("是否删除这个奖品？此操作不可恢复!")) {
		$.post(baseURL + "remove", {
			id: id
		}, function (r) {
			if (r.success) {
				window.location = window.location;
			} else {
				alert(r.message);
				console.log("remove category error : " + r.error);
			}
		})
	}
}

function showDialog(id) {
	var url = baseURL + 'showEditor';
	if (id) {
		url += '?id=' + id;
	}
	BootstrapDialog.show({
		title: "修改",
		width: "1000px",
		cssClass: 'category-dialog',
		message: $('<div class="dialog-div"></div>').load(url),
		buttons: [{
			id: 'btn-ok',
			icon: 'glyphicon glyphicon-check',
			label: '保存',
			cssClass: 'btn-primary',
			action: dialogSubmit
		}, {
			label: '关闭',
			action: function (dialogRef) {
				dialogRef.close(); //对于对话框内部的实例对象的引用
			}
		}]
	});
}

function dialogSubmit(dialogRef) {
	var form = dialogRef.getModalBody().find("form");
	var items = $(form).find("input");
	var entity = {};
	$.each(items, function () {
		if ($(this).attr("name")) {
			entity[$(this).attr("name")] = $(this).val();
		}
	});
	if (!entity.title || !entity.title.length) {
		alert("请填写名称");
		return;
	}
	entity.logo = $(form).find("#logoAttId").val();
	entity.prizesCategory = $(form).find("#prizesCategory").val();
	entity.winningRate = $(form).find("#winningRate").val();
	if (!entity.validaty) {
		entity.validaty = 0;
	}
	$.post(baseURL + "update", entity, function (r) {
		if (r.success) {
			dialogRef.close();
			window.location = window.location;
		} else {
			console.log(r.error);
			$.showErr(r.message);
		}
	});
}
</script>
