<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改投票</title>
    
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
		.body{margin-left:30px;width:600px;}
		.login_top{margin-bottom: 30px;width:400px;}
		.login_top:HOVER{cursor:pointer;}
		.login_top span{font-size: 28px;font-weight: bold;position:relative;top:-10px;}
		.table{margin:50px;height:400px;}
		#title_sub{width:100px;}
		#title{background-color: #cacaca;width:100%;height:35px;font-size: 16px;color: white;font-weight: bold;padding-top: 10px;}
	</style>
	<script type="text/javascript">
	$(function(){
		$("#addtab").click(function(){
	    $("#ta").append("<input class='easyui-textbox' type='text' name='options'  style='width:300px;'><div> &nbsp;</div>");
 		});
	});
	</script>
  </head>
  <body style="background-color:#dcdbfd;">
  <div class="body">
 	 <div class="login_top" onclick="document.location='index.jsp'" ><img src="image/login_top.png" width="90px" height="50px"/><span>北大青鸟网上调查系统</span></div>
	 <div id="title">修改投票</div>
	 <s:form id="subfrom" action="Update.action" method="post">
	 <table class="table">
	 <tr id="option_title">
	 	<td id="title_sub">投票内容：</td>
	 	<td><input class="easyui-textbox" type="text" style="width:300px;" name="subjects" value='<s:property value="#session.subject.vsTitle"/>'></td>
	 </tr>
	 <tr id="option_title">
	 	<td id="title_sub">投票类型：</td>
	 	<td>
	 	<input type="radio" name="optionType" <s:if test="#session.subject.vsType==1">checked</s:if> value="1">单选
	 	<input type="radio" name="optionType" <s:if test="#session.subject.vsType==2">checked</s:if>  value="2">多选
	 	</td>
	 </tr>
	 <tr id="option">
	 	<td >投票选项：</td>
	 	<td id="ta">
	 	<s:iterator value="#session.option" id="opt" status="st">
	 	<input class="easyui-textbox" type="text"  style="width:300px;"  name='options'  value="<s:property value='#opt.voOption'/>"><div> &nbsp;</div>
	 	</s:iterator>
	 	</td>
	 </tr>
	 <tr id="option_title">
	 	<td id="title_sub"></td>
	 	<td>
	 		<div>
				<a href="javaScript:void(0)" onclick="document.getElementById('subfrom').submit();" class="easyui-linkbutton">&nbsp;&nbsp;确   &nbsp;&nbsp;&nbsp;定&nbsp;&nbsp;</a>
				<a href="javaScript:void(0)" id="addtab" class="easyui-linkbutton">&nbsp;增加选项&nbsp;</a>
				<a href="index.jsp" class="easyui-linkbutton">&nbsp;取消操作&nbsp;</a>
			</div>	
		</td>
	 </tr>
	 </table>
	 </s:form>
  </div>
  </body>
</html>
