<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
	<meta charset="UTF-8">
	<title>登         录</title>
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.1/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.1/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.1/demo/demo.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
	<style type="text/css">
		body{margin-top: 100px;margin-left:150px;overflow:-Scroll;overflow-y:hidden;overflow-x: hidden;}
		.login_top{margin-bottom: 30px;width:400px;}
		.login_top:HOVER{cursor:pointer;}
		.login_top span{font-size: 28px;font-weight: bold;position:relative;top:-10px;}
		#login_back_one_one{width:800px;height:210px;position:relative;top:-214px;right:-260px;background-color:#ccc;}
		label{font-weight: bold;color:white;font-size:16px;}
		.login_sty{position:relative;top:-470px;right:-580px;}
		a{color:blue;}
	</style>
	<script type="text/javascript">
		function login(){
			var names=$("#UserName").val();
			var pwds=$("#UserPassword").val();
			if(names !="" && names !=null){
				var url="Login.action";
				var data={"vuUserName":names,"vuUserPassword":pwds};
				$.post(url,data,function(resultJson){
					if(resultJson.flag=true){
						$(".body").html(resultJson.message);
					}else{
						$(".message").html(resultJson.message);
					}
				});
		}
		}
	</script>
</head>

<body style="background-color:#dcdbfd;">
<div class="body">
<div class="login_top" onclick="document.location='index.jsp'" ><img src="image/login_top.png" width="90px" height="50px"/><span>北大青鸟网上调查系统</span></div>
  <div class="login_back">
  <div id="login_back_one">
  	<img src="image/login_back_one.png" width="260px" height="210px"/>
  	<div id="login_back_one_one"><label style="position:relative;left:30px;top:30px;">北大青鸟</label><label style="position:relative;left:0px;top:50px;">网上调查系统</label></div>
  </div>
  </div>
  <s:form action="Login.action" method="post">
   <div class="login_sty">
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" style="width:100%;max-width:400px;padding:30px 60px;">
		<div style="margin-bottom:10px">
			<input class="easyui-textbox" id="UserName" name="vuUserName" style="width:100%;height:40px;padding:12px" data-options="prompt:'用户名',iconCls:'icon-man',iconWidth:38"><div id="message"></div>
		</div>
		<div style="margin-bottom:20px">
			<input class="easyui-textbox" id="UserPassword"  name="vuUserPassword" type="password" style="width:100%;height:40px;padding:12px" data-options="prompt:'密码',iconCls:'icon-lock',iconWidth:38">
		</div>
		<div style="margin-bottom:20px">
			<input type="checkbox" checked="checked">
			<span>记住密码</span>
		</div>
		<div>
			<input type="submit" class="easyui-linkbutton" onclick="" style="padding:5px 0px;width:100%;" value="登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;录"/>
			<a href="register.jsp" style="position:relative;right:-190px;top:12px">
				<span>没有账号？注册</span>
			</a>
		</div>
	</div>
	</div>
	</s:form>
	<div id="message"></div>
	</div>
</body>
</html>