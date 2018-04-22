<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="../../common.jsp"%>

<script type="text/javascript" src="static/admin/admin/app-user.js"></script>

<style type="text/css">
ul,ol {
	margin: 0;
	padding: 0;
}

body {
	background-color: white;
}
</style>
		<div class="panel panel-primary">
	      <div class="panel-heading">
	       
		     <div class="row">
		      <div class="col-xs-8">
		        <h3>APP用户列表</h3>
		      </div><!-- /.col-xs-8 -->
		      <div class="col-xs-4" style="margin-top: 15px">
		        <div class="input-group">
		          <input type="text" class="form-control" id="phoneNumber" placeholder="输入电话查询">
		          <span class="input-group-btn">
		            <button class="btn btn-default btn-sm" type="button" onclick="doQuery();">查询</button>
		          </span>
		        </div><!-- /input-group -->
		      </div><!-- /.col-xs-4 -->
		    </div>
	      </div>
	      <div class="panel-body">
	        <table class="am-table am-table-bordered am-table-radius am-table-striped" id="users-table">
	           	 <thead>
	              <tr id="users-table-head">
	                  <th class="id" style="display: none;"><input type="text"/></th>
	                  <th class="nickName">昵称</th>
	                  <th class="userName">用户名</th>
	                  <th class="name">姓名</th>
	                  <th class="registerTime">注册时间</th>
	                  <th class="phoneNo">电话号码</th>
	                  <th class="status" style="display: none;">状态</th>
	                  <th class="statusName">状态</th>
	                  <th width="163px">操作</th>
	              </tr>
	            </thead>
	            <tbody id="orderList">
	            </tbody>
	          </table>
	      </div>
	      <div class="panel-footer">
	        	<div id="example" style="text-align: center"> <ul id="pageLimit" class="pagination"></ul> </div>
			</div>
	      </div>
				

<!-- 模态框（Modal） -->
<div class="modal fade" id="userConsumptionDialog" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" style="width: 1500px">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="myModalLabel">
					用户消费记录
				</h4>
			</div>
			<div class="modal-body">
				
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">关闭
				</button>
			</div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>
