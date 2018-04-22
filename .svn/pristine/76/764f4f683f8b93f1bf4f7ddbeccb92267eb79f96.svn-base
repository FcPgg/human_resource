<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="static/assets/css/bootstrap-slider.min.css"/>
<style type='text/css'>
        /* Example 1 custom styles */
        #ex1Slider .slider-selection {
            background: #BABABA;
        }
        /* Example 3 custom styles */
        #RGB {
            height: 20px;
            background: rgb(128, 128, 128);
        }
        #RC .slider-selection {
            background: #FF8282;
        }
        #RC .slider-handle {
            background: red;
        }
        #GC .slider-selection {
            background: #428041;
        }
        #GC .slider-handle {
            background: green;
        }
        #BC .slider-selection {
            background: #8283FF;
        }
        #BC .slider-handle {
            border-bottom-color: blue;
        }
        #R, #G, #B {
            width: 300px;
        }
</style>
<div class="modal fade" id="dialog" tabindex="-1" role="dialog" aria-labelledby="dialogLabel" aria-hidden="true">
	<div class="modal-dialog " style="width:1500px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="dialogLabel">
				</h4>
			</div>
			<div class="modal-body">
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active">
						<table class="am-table am-table-bordered am-table-striped am-table-compact0" id="orderInfo">
						<thead class="am-text-center">
						<tr>
							<tb>用户评论</tb>
						</tr>
						</thead>
						<tbody>
						<tr class="am-warning">
							<td class="am-serif" colspan="6">
								<a id="userNickName"></a>&nbsp;于<a id="valuationTime"></a>&nbsp;对<a id="specName"></a>&nbsp;发表品论
							</td>
						</tr>
						<tr class="am-warning">
							<td class="am-serif" colspan="6" id="contents">内容</td>
						</tr>
						</tbody>
						</table>
						<table class="am-table am-table-bordered am-table-striped am-table-compact" style="display:none" id="returnContents">
						<thead class="am-text-center">
						</thead>
						<tbody>
						<tr class="am-warning">
							<td class="am-serif" colspan="6">管理员</a> 于<a id="replyTime"></a>回复品论</td>
						</tr>
						<tr class="am-warning">
							<td class="am-serif" colspan="6" id="replyContents">
							</td>
						</tr>
						</tbody>
						</table>
						<!-- 回复品论-->
						<table class="am-table am-table-bordered am-table-striped am-table-compact">
						<thead class="am-text-center">
						<tr class="am-warning">
							<td class=" am-serif">回复评论</td>
							<td>
								<textarea class="" rows="2" id="reply" style="width: 530px;" placeholder="回复评论"></textarea>
							</td>
							<input type="hidden" id="experssCode" value=""/>
						</tr>
						</thead>
						</table>
						<table class="am-table am-table-bordered am-table-striped am-table-compact">
						<thead class="am-text-center">
						</thead>
						<thead>
						<tr class="am-success">
							<th>
								<button onclick="replyUser()" id="replyUser" class="am-btn am-btn-warning" href="javascript:void(0)">
								<i class="am-icon-paper-plane"></i>回复</button>
								<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							</th>
						</tr>
						</thead>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<script>
function replyUser(){
	var data = {
			"valuationId":$("#valuationId").val(),
			"replier":$("#sellerId").val(),
			"contents":$("#reply").val()
	}
	$.post("mt/goodsValuationReply/valuationReply",data,function(r){				
		if(r.success){
			$("#returnContents").show();
			$("#replyTime").text(r.data.replyTime);
			$("#replyContents").text(r.data.contents);
		}
	})
}
</script>