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

<div class="modal fade" id="archivesInfo" tabindex="-1" role="dialog" aria-labelledby="dialogLabel" aria-hidden="true">
	<div class="modal-dialog " style="width:900px;">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
					&times;
				</button>
				<h4 class="modal-title" id="dialogLabel">
				</h4>
			</div>
			<input type="hidden"  id="orderId"/>
			<div class="modal-body">				
                <div class="tab-content" >
                    <div role="tabpanel" class="tab-pane active" id="orderInfo">
						<table class="am-table am-table-bordered am-table-compact am-table-centered">
						  <thead>
						  <tr><tb><h3>档案详情</h3></tb></tr>
						  </thead>
						  <tbody>
						  <tr >
						    <td class="am-text-middle am-text-center">姓名</td>
						    <td id="userName" class="am-text-middle am-text-center"></td>
						    <td class="am-text-middle am-text-center am-serif">性别</td>
						    <td id="sexs" class="am-text-middle am-text-center"></td>
						     <td class="am-text-middle am-text-center am-serif">出生日期</td>
						    <td id="birthdays" class="am-text-middle am-text-center"></td>
						     <td rowspan="3" class="am-text-center"><img id = 'imgs' src='' style='width:71px;height:99px;'></td>
						  </tr>
						  <tr>
						    <td class="am-text-middle am-text-center">部门</td>
						    <td id="catName" class="am-text-middle am-text-center"></td>
						    <td class="am-text-middle am-text-center">民族</td>
						    <td id="nations" class="am-text-middle am-text-center"></td>
						    <td class="am-text-middle am-text-center">政治面貌</td>
						    <td id="politicss" class="am-text-middle am-text-center"></td>
						  
						  </tr>
						  <tr>
						   <td class="am-text-middle am-text-center">身份证号</td>
						    <td id="idNumbers" class="am-text-middle am-text-center"></td>
						    <td class="am-text-middle am-text-center">学历</td>
						    <td id="educationss" class="am-text-middle am-text-center"></td>
						    <td class="am-text-middle am-text-center">联系电话</td>
						    <td id="telPhones" class="am-text-middle am-text-center"></td>
						  </tr>
						   <tr>
						     <td class="am-text-middle am-text-center">毕业学习</td>
						    <td id="schools" class="am-text-middle am-text-center"></td>
						    <td class="am-text-middle am-text-center">所学专业</td>
						    <td id="majors"  colspan="4" class="am-text-middle am-text-center"></td>
						  </tr>
						   <tr>
						     <td class="am-text-middle am-text-center">爱好</td>
						    <td id="hobbys" colspan="6" ></td>
						   </tr>
						   <tr>
						    <td class="am-text-middle am-text-center">工作简历</td>
						    <td colspan="6"><div id="detailDescriptions"></div></td>
						   </tr>
						   <tr>
						    <td class="am-text-middle am-text-center">备注</td>
						    <td id="descriptions"  colspan="6"></td>
						   </tr>
						  </tbody>
						</table>
						
						
						<!-- 订单操作-->
						<table class="am-table am-table-bordered am-table-striped am-table-compact" id="goodsInfo">
						 <thead class="am-text-center">
						   <tr><tb>操作</tb></tr>
						 </thead>
						  <thead>
						  <tr class="am-success">
						    <th>
						    <button onclick="delivery()"  id="delivery" class="am-btn am-btn-warning" href="javascript:void(0)">
							  <i class="am-icon-paper-plane"></i>
							      导出
							</button>
							 <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
							</th>
						  </tr>
						  </thead>
						</table>
                    </div> <!-- end of basicInfo -->
                </div><!-- enf of tab content -->
			</div> <!-- /.modal-body -->
		</div><!-- /.modal-content -->
	</div><!-- /.modal -->
</div>

<script>

function delivery(){
	 var experss = $("#experss").val();
	 var trackingNo = $("#trackingsNo").val();
	 var id = $("#orderId").val();
	 if(trackingNo != '' && experss != ''){
		 data = {'orderId':id,
				 'streamCompanyNo':experss,
				 'trackingNo':trackingNo,
				 'userId':$("#currentUserId").val()
				 }
	 	 $.post("mt/mtOrderInfo/streamStatusUpdata",data,function(r){
	 		 if(r.success){
	 			 alert("发货成功！");
	 			window.location = window.location;
	 		 }
	 	})
	 }else{
		 alert("请填写快递公司和快递单号！")
	 }
}




</script>
