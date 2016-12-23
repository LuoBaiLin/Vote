<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>查看投票</title>
    
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
	<style type="text/css">
		a{text-decoration: none;}
		#option{font-size: 14px;}
		.body{margin:40px;}
		#title{font-size: 16px;font-weight: bold;}
		.button_vote{margin-top:30px;}
		.login_top{margin-bottom: 30px;width:400px;}
		.login_top:HOVER{cursor:pointer;}
		.login_top span{font-size: 28px;font-weight: bold;position:relative;top:-10px;}
		#option_message{color:#999;font-size: 14px;}
	</style>
  </head>
  <body style="background-color:#dcdbfd;">
  <div class="body">
  <div class="login_top" onclick="document.location='index.jsp'" ><img src="image/login_top.png" width="90px" height="50px"/><span>北大青鸟网上调查系统</span></div>
	<div style="font-size: 16px;font-weight: bold;"><img src="image/large_chart.png"/><span style="position:relative;top:-10px;">&nbsp;查看投票</span></div>
	<div style="width:500px;"><hr></div>
	<div id="title"><img src="image/tablet.png"></img><label style="position:relative;top:-10px;">&nbsp;&nbsp;选出你心中最好的聊天工具</label></div>
	<div id="option_message">共有<s:property value="#session.options"/>个选项，已有<s:property value="#session.voteitems"/>个网友参与了投票</div><br><br>
	<table>
	<s:iterator value="#session.nums" id="nums"  status="st">
		<tr>
			<td width="40px"><s:property value='#st.index+1'/>.</td>
			<td  width="420px"><div class="easyui-progressbar" data-options="value:<s:property value='#nums'/>0" style="width:400px;height:30px;"></div></td>
			<td><label><s:property value='#nums'/>票</label><label style="color: #ffcc00">(<s:property value='#nums'/>0%)</label></td>
		</tr>
	</s:iterator>
	</table>
	</div>
	<a href="voting.jsp" style="width:80px;font-size:16px;position:relative;top:-13px;left:60px;">返回投票列表</a>
  </body>
</html>
