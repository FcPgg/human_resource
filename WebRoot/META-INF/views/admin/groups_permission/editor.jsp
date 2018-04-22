<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

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
			<input type="hidden"  id="gorupId" value=""/>
			<div class="modal-body">				
                <div class="tab-content" >
                    <div role="tabpanel" class="tab-pane active" id="orderInfo">
						<table class="am-table am-table-bordered am-table-striped am-table-compact0" id="orderInfo">
						  <tbody>
						  <tr class="am-warning">
						    <td >分组名</td>
						    <td id="orderCode">
						    <input type="text" id="groupName" class="am-form-field" placeholder="分组名称">
						    </td>
						  </tr>
						  <tr class="am-warning">
						    <td>分组描述</td>
						    <td id="payStatusName">
						      <textarea class="form-control" rows="2" id="groupInfo" placeholder="分组描述"></textarea>
						    </td>
						  </tr>
						  </tbody>
						</table>
						
						<table class="am-table am-table-bordered am-table-striped am-table-compact" id="groupActionInfo">
						  <tbody id="groupPermission">
						   <tr id="permission">
						  </tr>
						  </tbody>
						</table>
						
                    </div> <!-- end of basicInfo -->
                </div><!-- enf of tab content -->
			</div> <!-- /.modal-body -->
			<div class="modal-footer">
                <button type="button" id="btnSubmit" class="btn btn-primary" onclick="doSaveGroup();">保存</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
            </div>
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
	 
</div>

<script>
function doSaveGroup(){
	var obj=document.getElementsByName('permissionID'); 
    check_val = [];
    for(k in obj){
        if(obj[k].checked)
            check_val.push(obj[k].value);
    }
    check_val.push(1);
    var entity = {
         "groupName":$("#groupName").val(),
         "groupInfo":$("#groupInfo").val()
    }
    
    entity.groupPermission = [];
    $.each(check_val,function(i,permission){
    	var permissions = {
    			permissionId: permission
			}
	  entity.groupPermission.push(permissions);
   });
    
	$.post("mt/userGroups/updateGroup", {entity: JSON.stringify(entity)}, function(r){
		if(r.success){
			window.location = window.location;
		} else {
			console.log(r.error);
			alert(r.message);
		}
	});
}

</script>
