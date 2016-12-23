<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>参与投票</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.1/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.1/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.1/demo/demo.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
	<script type="text/javascript">
		function submitForm(){
			$("#ff").form("submit");
		}
	</script>
	<style type="text/css">
		#option{font-size: 16px;}
		#title{font-size: 16px;font-weight: bold;}
		.body{margin:40px;}
		.button_vote{margin-top:30px;}
		.login_top{margin-bottom: 30px;width:400px;}
		.login_top:HOVER{cursor:pointer;}
		.login_top span{font-size: 28px;font-weight: bold;position:relative;top:-10px;}
		#option_message{color:#999;font-size: 16px;}
	</style> 
  </head>
  <body style="background-color:#dcdbfd;">
  <div class="body">
  <div class="login_top" onclick="document.location='index.jsp'" ><img src="image/login_top.png" width="90px" height="50px"/><span>北大青鸟网上调查系统</span></div>
	<div style="font-size: 16px;font-weight: bold;"><img src="image/large_chart.png"/><span style="position:relative;top:-10px;">&nbsp;参与投票</span></div>
	<div style="width:500px;"><hr></div>
	<s:form action="addVote.action" method="post" id="ff">
	<div id="title"><img src="image/tablet.png"></img><label style="position:relative;top:-10px;">&nbsp;&nbsp;<s:property value="#session.subject.vsTitle"/></label></div>
	<div id="option_message">共有<s:property value="#session.options"/>个选项，已有<s:property value="#session.voteitems"/>个网友参与了投票</div><br><br>
	
	<s:iterator value="#session.option" id="opt" status="st">
	<div id="option"><input type="<s:if test='#session.subject.vsType=="1"'>radio</s:if><s:else>checkbox</s:else>" id="options" name="options" value="<s:property value='#opt.voOption'/>"/><s:property value='#opt.voOption'/></div><br>
	</s:iterator>
	
	<div class="button_vote">
	<a href="javaScript:void(0);" onclick="submitForm()" class="easyui-linkbutton" data-options="iconCls:'icon-print'" style="width:80px;margin-right:15px;">投票</a>
	<a href="viewPoll.jsp" class="easyui-linkbutton" data-options="iconCls:'icon-search'" style="width:80px;margin-right:15px;">查看</a>
	<a href="index.jsp" class="easyui-linkbutton" data-options="iconCls:'icon-undo'" style="width:80px">返回</a>
	</div>
	</s:form>
  </div>
  </body>
</html>
