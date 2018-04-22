$(document).ready(function(){  
	//首页导航栏
	$.post("mt/mobile/disease/listNormalSystemCategory","",function(r){
		if(r.success){
			 var html='';  
             for(var i=0;i<r.data.data.length;i++){  
                 html+="<li onclick='"+'getListByCategory(id = ' + r.data.data[i].id + ')'+"'><a href='javascript:void(0);'>"+r.data.data[i].catName+"</a></li>";  
             }  
             $("#title").html(html); 
		}
	})
	
	//首页诊断
	$.POST("mt/mobile/disease/listNormalAdvertisement",{'categoryId' : 1},function(r){
		if(r.success){
			$("#list").children().remove();
             for(var i=0;i<r.data.data.length;i++){  
            	    var html='<article class="am-g blog-entry-article">'
    				 +'<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">'
    			     +'<img  src="showImage?uuid='+r.data.data[i].logoAttUrl+'" alt="" class="am-u-sm-12">' 
            	     +'</div>' 
            	     +'<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">'
            	     +'<span><a href="javascript:void(0)" class="blog-color">article &nbsp;</a></span>'
            	     +'<span> @Admin &nbsp;</span>'
            	     +'<span>'+r.data.data[i].createTime+'</span>'
            	     +'<h1><a href="javascript:void(0)" onclick='+'wzinfo(id='+r.data.data[i].id +')'+'>'+r.data.data[i].adName+'</a></h1>'
            	     +'<blockquote><p style="font-size:20px;">疾病类型：'+r.data.data[i].catName+'</p></blockquote>'
            	     +'<p>症状：'+r.data.data[i].programme+'</p>'
            	     +'<p><a href="javascript:void(0)" class="blog-continue">continue reading</a></p>'
            	     +'</div></article>';
            	    $('#list').append(html);  
             }  
		}
	})
	
});


function getListByCategory(id){
	$.post("mt/mobile/disease/listNormalAdvertisement",{'categoryId' : id},function(r){
		if(r.success){
			$("#list").children().remove();
             for(var i=0;i<r.data.data.length;i++){  
            	    var html='<article class="am-g blog-entry-article">'
    				 +'<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-img">'
    			     +'<img  src="showImage?uuid='+r.data.data[i].logoAttUrl+'" alt="" class="am-u-sm-12">' 
            	     +'</div>' 
            	     +'<div class="am-u-lg-6 am-u-md-12 am-u-sm-12 blog-entry-text">'
            	     +'<span><a href="javascript:void(0)" class="blog-color">作者 &nbsp;</a></span>'
            	     +'<span> @Admin &nbsp;</span>'
            	     +'<span>'+r.data.data[i].createTime+'</span>'
            	     +'<h1><a href="javascript:void(0)" onclick='+'wzinfo(id='+r.data.data[i].id +')'+'>'+r.data.data[i].adName+'</a></h1>'
            	     +'<blockquote><p style="font-size:20px;">疾病类型：'+r.data.data[i].catName+'</p></blockquote>'
            	     +'<p>症状：'+r.data.data[i].programme+'</p>'
            	     +'<p><a href="javascript:void(0)" class="blog-continue">continue reading</a></p>'
            	     +'</div></article>';
            	    $('#list').append(html);  
             }  
		}
	});
	
}

function wzinfo(id){
	$.post("mt/mobile/systemAd/getContentById",{'id' : id},function(r){
		if(r.success){
			$("#list").children().remove();
				var html='<article class="am-article blog-article-p">'
					+'<input type="text" style="display:none" id="contentId" value='+r.data.id+' />'
					+'<div class="am-article-hd">'
					+'<h1 class="am-article-title blog-text-center">'+r.data.adName+'</h1>'
					+'<p class="am-article-meta blog-text-center">'
					+'<span><a href="#" class="blog-color">作者 &nbsp;</a></span>-'
					+'<span><a href="#">@admin &nbsp;</a></span>-'
					+'<span><a href="#">2015/10/9</a></span></p></div>'
					+'<div class="am-article-bd">'
					+'<img src="showImage?uuid='+r.data.logoAttUrl+'" alt="" class="blog-entry-img blog-article-margin">'
					+'<h1>症状:</h1>'
					+'<blockquote><p style="font-size:20px;">'+r.data.programme+'</p></blockquote>'
					+'<h1>治疗方案：</h1>'
					+'<p>'+r.data.symptom+'</p></p></div></article><hr>'
				    //动态生成评论表单
				    +'<form class="am-form am-g">'
				    +'<h3 class="blog-comment">评论</h3><fieldset>'
				    +'<div class="am-form-group"><textarea id="pinlun" class="" rows="5" placeholder="一字千金"></textarea></div>'
					+'<p><a type="submit" class="am-btn am-btn-default" onclick ='+'update()'+'>发表评论</a></p></fieldset></form><hr>';
				    $('#list').append(html);  
		}
	});
	/* 
      
       <hr>
       <div class="am-g blog-author blog-article-margin">
         <div class="am-u-sm-3 am-u-md-3 am-u-lg-2">
           <img src="assets/i/f15.jpg" alt="" class="blog-author-img am-circle">
         </div>
         <div class="am-u-sm-9 am-u-md-9 am-u-lg-10">
         <h3><span>作者 &nbsp;: &nbsp;</span><span class="blog-color">amazeui</span></h3>
           <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
         </div>
       </div>
       <hr>
       <ul class="am-pagination blog-article-margin">
         <li class="am-pagination-prev"><a href="#" class="">&laquo; 一切的回顾</a></li>
         <li class="am-pagination-next"><a href="">不远的未来 &raquo;</a></li>
       </ul>
       
       <hr>

   */
}


/**
 * 发布
 */
function doAddProblem(){
	window.location.href="mt/mobile/disease/addProblem";
}

/**
 *个人中心
 */
function doMyPage(){
	window.location.href="mt/mobile/disease/doMypage";
}

//治疗方案分类
$(function () {
	$.post("mt/mobile/mtCategory/list", null, function (r) {
		if (r.success) {
			if (r.data) {
				$("#cat").children().remove();
				console.log(r.data[0]);
				goodsList(r.data);
			}
		}
	});
	//构建分类列表
	function goodsList(d) {
		$.each(d, function () {
			console.log(d);
			list = '<option value=' + this.id + '>' + this.catName + '</option>'
			$("#cat").append(list);
		});
	}
});

//照片上传

$(function() {
	if($("#logoAttId").val()){
		$("#imageDiv").children().remove();
		$("#imageDiv").append("<img style='width:350px;height:200px;' src='showImage?uuid=" + $("#logoAttUrl").val() + "&fileType=jpg'><img>");
	}
});
	
function iframeCallBack(atts) {
	if (atts != null) {
		$("#imageDiv").children().remove();
		$("#imageDiv").append("<img style='width:350px;height:200px;' src='showImage?uuid=" + atts[0].uuid + "&fileType=" + atts[0].srcFileType + "'><img>");
		$("#logoAttId").val(atts[0].id);
	}
}	

//疾病录入
function updateDisease(){
	alert($("#logoAttId").val())
	var attId = $("#logoAttId").val(); 
    var address = $("#address").val();
    var categroy = $("#cat").val();
    var symptom = $("#symptom").val();
    var season = $("#season").val();
    var describe = $("#describe").val()
    data = {
    	'attId' : attId,
    	'address' : address,
    	'categroy' : categroy,
    	'symptom' : symptom,
    	'season' : season,
    	'describe' : describe
    }
    $.post("mt/mobile/diseaseManager/updateDisease",data,function(r){
    	if (r.success) {
			window.location = window.location;
		} else {
			console.log("update integrate goods error:" + r.error);
		}
    });
}