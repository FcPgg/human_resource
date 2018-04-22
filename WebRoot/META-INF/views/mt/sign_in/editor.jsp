<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="row">
	<div class="col col-sm-12">
		<form class="form-horizontal" role="form">
			<input type="text"  style="display: none;" name="id" class="col-xs-12 col-sm-12" value="${entity.id }">
			
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" >时间</label>
				<div class="col-sm-10">
					<select name="dayNo" class="col-xs-12 col-sm-12" value="${entity.dayNo }" id="sltDayNo">
						<c:forEach var="dict" items="${dictionary}">
							<option value="${dict.code }" <c:if test="${ entity.dayNo eq dict.code}">selected="selected"</c:if>> ${dict.description}</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" >标题</label>
				<div class="col-sm-10">
					<input type="text"  placeholder="请输入标题" name="title" class="col-xs-12 col-sm-12" value="${entity.title }">
				</div>
			</div>
			
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" >赠送e币数量</label>
				<div class="col-sm-10">
					<input type="text" name="count"  placeholder="赠送e币数量" name="count" class="col-xs-12 col-sm-12" value="${entity.count}">
				</div>
			</div>
			<div class="form-group">
				<label class="col-sm-2 control-label no-padding-right" >备注</label>
				<div class="col-sm-10">
					<input type="text"  placeholder="备注" name="remark" class="col-xs-12 col-sm-12" value="${entity.remark }">
				</div>
			</div>
		</form>
				
	</div>
</div>
<script type="text/javascript">

$(function(){
	if($("#inputWinningRate").val()){
		$("#winningRate option[value='" + $("#inputWinningRate").val() + "']").attr("selected", true);
	}
});

console.log("editor");
</script>