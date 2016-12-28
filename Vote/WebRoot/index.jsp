<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>网上投票系统首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.1/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.1/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.1/demo/demo.css">
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <link rel="stylesheet" href="css/index.css" type="text/css"></link></head>
	<script type="text/javascript" src="jquery-easyui-1.5.1/jquery.min.js"></script>
	<script type="text/javascript" src="jquery-easyui-1.5.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/index.js"></script>
    <script type="text/javascript" charset="UTF-8">
    	function likename(){
	  		var title=$("#titlelike").val();
	  		location.href="index.action?likeName="+title;
  		}
    </script>
  <body  style="background-color:#dcdbfd;">
 	 <div class="login_top"><img src="image/login_top.png" width="90px" height="50px"/><span>北大青鸟网上调查系统</span></div>
	 <div style="margin:20px 0;"></div>
	 <div class="center" style="background-color:#CCC;">
	  <div class="userName">
			<a href="login.jsp" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-man'">
			<s:property value='#session.userLogin.vuUserName'/>
			</a> 
			<a href="register.jsp" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-edit'">注册</a> 
 	 </div>
	<div class="easyui-panel" style="padding:5px;width:200px;height:530px;">
		<ul class="easyui-tree" data-options="url:'json/tree_data1.json',method:'get',animate:true,closable: true"></ul>
	</div>
	 <div style="margin:20px 0;"></div>
	 <div class="easyui-tabs"  style="width:800px;height:530px;position:relative;top:-550px;left:230px;">
		 <div title="返回列表" data-options="tabWidth:112" style="padding-top:20px;padding-left:50px;">
			 <table id="dg" title="" toolbar="#toolbar" style="width:700px;height:470px;"
			 data-options="	pageList:[5,10,15],singleSelect:true,pagination:true,url:'index_server.jsp',method:'post'">
			 	 <thead>
					 <tr>
						<th data-options="field:'num',width:40,formatter:indexFormatter">序号</th>
						<th data-options="field:'title',width:400">投票标题</th>
						<th data-options="field:'options',width:70">选项数</th>
						<th data-options="field:'participants',width:70,align:'right'">投票人数</th>
						<th data-options="field:'id',width:100,align:'center',formatter:operateFormatter">操作</th>
					 </tr>
				 </thead>
			 </table>
			  <%--工具栏--%>			 
			   <div id="toolbar" style="width:700px;background-color:#dcdbfd;">
			   		<div style="position:relative;left:500px;">
			   			<input type="text" name="titlelike" id="titlelike" class="easyui-textbox"/>
			   			<input type="button" onclick="likename()" class="easyui-linkbutton" value="查询" />
					</div>
				</div>
		 </div>
		<div title="发布新投票" data-options="tabWidth:112"  style="padding:20px;">
			 <div id="aa" class="easyui-accordion" style="width:700px;height:400px;margin-left:30px;">
				<div title="发布新投票" style="overflow:auto;padding:10px;">
					<div style="margin-bottom:20px;margin-top:30px;margin-left:80px">
					<s:form action="Fabu.action" id="subfrom" method="post">
						<table id="ta" style="margin-bottom: 50px;">
							<tr>
								<td>投票内容:</td>
								<td><input class="easyui-textbox" name="votecontent"  data-options="validType:'text'" style="width:300px;height:25px"></td>
							</tr>
							<tr>
								<td>投票类型:</td>
								<td>
								<span class="radioSpan">
					                <input type="radio" name="xuan" value="1">单选</input>
					                <input type="radio" name="xuan" value="2">多选</input>
					            </span>				
					            </td>
							</tr>
							<tr>
								<td>投票选项:</td>
								<td><input class="easyui-textbox" name="voteoption" data-options="validType:'text'" style="width:300px;height:25px"></td>
							</tr>
							<tr>
								<td></td>
								<td><input class="easyui-textbox"  name="voteoption"  data-options="validType:'text'" style="width:300px;height:25px"></td>
							</tr>
						</table>
						</s:form>
					</div>
					<div style="position:absolute;top:300px;left:600px;">
						<a href="javaScript:void(0)" onclick="document.getElementById('subfrom').submit();" class="easyui-linkbutton">&nbsp;&nbsp;确   &nbsp;&nbsp;&nbsp;定&nbsp;&nbsp;</a><br><br>
						<a href="javaScript:void(0)" id="addtab" class="easyui-linkbutton">&nbsp;增加选项&nbsp;</a><br><br>
						<a href="index.jsp" class="easyui-linkbutton">&nbsp;取消操作&nbsp;</a>
					</div>	
				</div>
			</div>
			</div>
		<div title="维护" class="weihu" data-options="tabWidth:112" >
			<iframe src="weihu.jsp" width="720px" height="450px" scrolling="no" style="margin:10px;border:0px;">
			</iframe>
		</div>
	</div>
	</div>
  </body>
</html>
