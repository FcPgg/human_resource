<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html class="no-js">
<%@ include file="../common.jsp"%>
<base href="<%=basePath%>">
<head>
<meta charset="utf-8">
<title>Amaze UI Admin index Examples</title>
<meta name="description" content="这是一个 index 页面">
<meta name="keywords" content="index">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="renderer" content="webkit">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="icon" type="image/png" href="assets/i/favicon.png">
<link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
<meta name="apple-mobile-web-app-title" content="Amaze UI" />
<link rel="stylesheet" href="assets/css/amazeui.min.css"/>
<link rel="stylesheet" href="assets/css/admin.css">
<script src="assets/js/jquery.min.js"></script>
<script src="assets/js/app.js"></script>
<script src="static/admin/mt/assets/js/index.js"></script>
</head>
<body>

    <div class="listbiaoti am-cf">
      <ul class="am-icon-flag on">疾病信息录入</ul>
      
      <dl class="am-icon-home" style="float: right;"></dl>
      
    </div>
	
    <div class="fbneirong">
      <form class="am-form">
        <div class="am-form-group am-cf">
          <div class="zuo">疾病分类：</div>
          <div class="you">
           <select id="cat" style="width: 150px; height: 26px; padding-bottom: 0px; padding-top: 0px; margin-left: 0px;">
		   </select>
           </div>
        </div>
        <div class="am-form-group am-cf">
          <div class="zuo">症状：</div>
          <div class="you">
            <input type="text" class="am-input-sm" id="symptom" placeholder="请输入关键词">
          </div>
        </div>
        <div class="am-form-group am-cf">
          <div class="zuo">地址：</div>
          <div class="you">
            <input type="text" class="am-input-sm" id="address" placeholder="请输入关键词">
          </div>
        </div>
        <div class="am-form-group am-cf">
          <div class="zuo">季节：</div>
          <div class="you">
            <select id="season" style="width: 150px; height: 26px; padding-bottom: 0px; padding-top: 0px; margin-left: 0px;">
		     <option value="春季">春季</option>
		     <option value="春季">夏季</option>
		     <option value="春季">秋季</option>
		     <option value="春季">冬季</option>
		   </select>
          </div>
        </div>
        <div class="am-form-group am-cf">
          <div class="zuo">描述：</div>
          <div class="you">
            <textarea class="" rows="2" id="describe"></textarea>
          </div>
        </div>
        
         <div class="am-form-group am-cf">
          <div class="zuo">图片：</div>
          <div class="you">
            <iframe style="width: 80%; height: 40px;" src="file-upload/page" name="file-upload-iframe"></iframe>
				<div id="imageDiv"></div>
				<input name="logoAttId" id="logoAttId" style="display: none;" value=""/>
				<input name="logoAttUrl" id="logoAttUrl" style="display: none;" value=""/>
          </div>
        </div>
        
        <div class="am-form-group am-cf">
          <div class="you" style="margin-left: 11%;">
              <a type="submit" onclick="updateDisease()" class="am-btn am-btn-success am-radius">发布</a>
          </div>
        </div>
      </form>
    </div>


<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/polyfill/rem.min.js"></script>
<script src="assets/js/polyfill/respond.min.js"></script>
<script src="assets/js/amazeui.legacy.js"></script>
<![endif]--> 

<!--[if (gte IE 9)|!(IE)]><!--> 
<script src="assets/js/amazeui.min.js"></script>
<!--<![endif]-->



</body>
</html>