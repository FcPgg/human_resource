<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<form class="am-form am-form-horizontal">
	<input style="display: none;" id="data-id" />
	<div class="am-form-group">
		<label for="doc-ipt-3" class="am-u-sm-3 am-form-label">选择分组</label>
		<div class="am-u-sm-9">
			  <form role="form">
				  <div class="form-group">
				    <select class="form-control" id="group"> 
				      </select>
				  </div>
			  </form>
		</div>
	</div>

<script>
		$(function() {
			$.post("mt/userGroups/list", null, function(r) {
				if (r.success) {
					if (r.data) {
						$("#group").children().remove();
						console.log(r.data[0]);
						choiseGroup(r.data);
					}
				}
			});
			//构建分组列表
			function choiseGroup(d) {
				$.each(d, function() {
					console.log(d);
					list = '<option value='+this.id+'>' + this.groupName
							+ '</option>'
					$("#group").append(list);
				});
			}
		});

</script>

</form>