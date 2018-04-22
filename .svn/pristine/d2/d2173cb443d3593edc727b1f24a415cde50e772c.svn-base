<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	
<%@ include file="../../common.jsp"%>
<script type="text/javascript" src="static/admin/admin/sys-user.js"></script>
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
				<h3>系统用户列表</h3>
			</div>
			<!-- /.col-xs-8 -->
			<div class="col-xs-4" style="margin-top: 15px">
				<div class="input-group">
					<input type="text" class="form-control" id="phoneNumber" placeholder="输入姓名查询"> 
					<span class="input-group-btn">
						<button class="btn btn-default btn-sm" type="button"  onclick="doQuery();">查询</button>
					</span>
				</div>
				<!-- /input-group -->
			</div>
			<!-- /.col-xs-4 -->
		</div>
	</div>
	<div class="panel-body">
		<table
			class="am-table am-table-bordered am-table-radius am-table-striped"
			id="users-table">
			<thead>
				<tr id="users-table-head">
					<th class="id" style="display: none;"><input type="text" /></th>
					<!-- <th class="nickName">昵称</th> -->
					<th class="userName">用户名</th>
					<th class="name">名称</th>
					<th class="phoneNo">电话号码</th>
					<th class="categoryName">类型</th>
					<!-- <th class="status" style="display: none;">状态</th> -->
					<th class="statusName">状态</th>
					<th width="163px">操作<button class="am-btn am-btn-default am-btn-xs am-text-success am-round pull-right" title="冻结该账号" onclick="doAddUser();"><i class="am-icon-plus" ></i>添加账号</button></th>
				</tr>
			</thead>
			<tbody id="orderList">
			</tbody>
		</table>
	</div>
	<div class="panel-footer">
		<div id="example" style="text-align: center">
			<ul id="pageLimit" class="pagination"></ul>
		</div>
	</div>
</div>
