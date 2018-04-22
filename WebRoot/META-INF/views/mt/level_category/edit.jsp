<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<link rel="stylesheet" href="static/assets/css/bootstrap-slider.min.css"/>
<script src="static/amaze/assets/js/mt/category.js"></script>
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
<div class="modal fade" id="edit" tabindex="-1" role="dialog" aria-labelledby="dialogLabel" aria-hidden="true">
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
				<ul class="nav nav-tabs" role="tablist">
					<li class="active"><a href="#category" role="tab" data-toggle="tab">商品分类</a></li>
				</ul>
				<div class="tab-content">
					<div role="tabpanel" class="tab-pane active" id="category">
						<form id="category" class="form-horizontal" role="form">
							<!--   <input class="data-id" id="data-id" style="display: none;"/> -->
							<input type="text" style="display:none" id="sellerId" value=""/>
							<div class="form-group">
								<label for="firstname" class="col-sm-1 control-label">分类名称</label>
								<div class="col-sm-11">
									<input type="text" class="form-control" name="name" id="categoryNames" placeholder="请输入分类名称" required>
									<input type="text" class="am-input-sm" id="categoryId" value="" style="display:none">
								</div>
							</div>
						</form>
					</div>
					<!-- end of basicInfo -->
				</div>
				<!-- #goodsDetailInfo -->
			</div>
			<!-- enf of tab content -->
		</div>
		<!-- /.modal-body -->
		<div class="modal-footer">
			<button type="button" id="saveCategory" class="btn btn-primary" onclick="save();">保存</button>
			<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		</div>
	</div>
	<!-- /.modal-content -->
</div>
<!-- /.modal -->
</div>
<script>
function save(){
    if ($("#categoryNames").val() == "") {
        $("#categoryNames").tips({
            side: 3,
            msg: '请输入分类',
            bg: '#AE81FF',
            time: 2
        });
        $("#categoryNames").focus();
        return false;
    }
    var data = null;
    var categoryName = $("#categoryNames").val(); //获取分类
    var sellerId = $("#sellerId").val();
    var categoryId = $("#categoryId").val();
    //分类Id不为空则修改；分类Id为空则添加分类
    if (categoryId != '' && categoryId != '0') {
        data = {
            'categoryName': categoryName,
            'id': categoryId,
            'sellerId': sellerId
        }
    } else {
        data = {
            'categoryName': categoryName,
            'sellerId': sellerId
        }
    }
    $.post("mt/mtSecondLevelCategory/update", data, function (r) {
        if (r = "true") {
            $("#categoryNames").val('');
            $("#categoryId").val('');
            window.location.reload();
        }
    });
}
</script>