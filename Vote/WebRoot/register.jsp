<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>用户注册</title>
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.1/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.1/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.1/demo/demo.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
	<style type="text/css">
	.body{position:relative;top:100px;left:350px;}
	.login_top{width:400px;}
	.login_top span{font-size: 28px;font-weight: bold;position:relative;top:-10px;}
	.login_top:HOVER{cursor:pointer;}
	#message{ position: relative; left:40px;color:red;}
	.na{
	  position: relative;
	  left:28px;
	  border: 1px solid #95B8E7;
	  background-color: #F5D4C9;
	  vertical-align: middle;
	  display: inline-block;
	  height:30px;
	  width:296px;
	  overflow: hidden;
	  white-space: nowrap;
	  margin: 0;
	  padding: 0;
	  -moz-border-radius: 5px 5px 5px 5px;
	  -webkit-border-radius: 5px 5px 5px 5px;
	  border-radius: 5px 5px 5px 5px;
	  }
	</style>
	<script type="text/javascript">
		function validate(){
			var names=$("#names").val();
			if(names !="" && names !=null){
				var url="getStreamResult.action";
				var data="names="+names;
				$.post(url,data,function(result){
					$("#message").html(result);
				});
			}else{
				$("#message").html("用户名不能为空");
			}
		}
		function del(){
			$("#message").html("");
		}
		function submitForm(){
			$("#ff").form("submit");
		}
		function clearForm(){
			$("#ff").form("clear");
		}
		$.extend($.fn.validatebox.defaults.rules, {
			confirmPass: {
				validator: function(value, param){
					var pass = $(param[0]).passwordbox("getValue");
					return value == pass;
				},
				message: "两次密码输入不一致"
			}
		});
	</script>
</head>
<body  style="background-color:#dcdbfd;">
<div class="body">
	<div class="login_top" onclick="document.location='index.jsp'" ><img src="image/login_top.png" width="90px" height="50px"/><span>北大青鸟网上调查系统</span></div>
 <div style="margin:20px 0;"></div>
	<div class="easyui-panel" title="新用户注册"  style="width:100%;max-width:600px;padding:30px 60px;">
		<form id="ff" method="post" action="Register.action">
			<div style="margin-bottom:20px">
				用&nbsp;户&nbsp;名：<input class="na" id="names" name="names" onkeyup="validate()" onblur="del()"  data-options="label:'用户名:',required:true"/><span id="message"></span>
			</div>
			<div style="margin-bottom:20px">
			<input id="pass" class="easyui-passwordbox" name="password" data-options="label:'密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:',required:true"  style="width:80%;height:34px;padding:10px">
		</div>
		<div style="margin-bottom:20px">
			<input class="easyui-passwordbox"  data-options="label:'确认密码:',required:true" validType="confirmPass['#pass']" style="width:80%;height:34px;padding:10px">
		</div>
		</form>
		<div style="text-align:center;padding:5px 0">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:80px">注&nbsp;&nbsp;册</a>&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:80px">清&nbsp;&nbsp;空</a>&nbsp;&nbsp;
			<a href="login.jsp" class="easyui-linkbutton" style="width:80px">返&nbsp;&nbsp;回</a>
		</div>
	</div>
	</div>
</body>
</html>
