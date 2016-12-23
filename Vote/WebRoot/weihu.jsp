<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>维护</title>
    
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
		a{text-decoration: none;color:blue;}
	</style>
    <script type="text/javascript">
	  	$(function(){
  		$("#dg").datagrid({
  			url:"index_server.jsp",
  			singleSelect:true,//只允许选择单行
  			iconCLs:"icon-search",//表头标题图片
			rowNumbers:true,//显示行号  	
			pagination:true,//显示底部分页栏
  			pageSize:10,//默认每页记录数mpagination参数为TRUE时才有效
  			pageList:[10,20,30],//显示列表记录数的下拉框选项，pagination参数为TRUE时生效
  			fitColumns:true,//自适应宽度，防止水平滚动
  			striped:true,//隔行变色
  			columns:[[
  				{field:"num",title:"序号",width:"40px",formatter:indexFormatter},
  				{field:"title",title:"投票标题",width:"340px"},
  				{field:"options",title:"选项数",width:"80px",align:"center"},/* ,sortable:true  */
  				{field:"participants",title:"参与人数",width:"80px",align:"center",style:participantsStyler},
  				{field:"id",title:"操作",width:"80px",align:"center",formatter:operateFormatter}
  			]],
  			loadMsg:"正在努力加载中..."//加载提示信息
  		});
  	});
  	//自定义序号咧单元格内容value是单元格的值,index序号从0开始，row行对象，return给单元格赋值
	function indexFormatter(value,row,index){
		return index+1;
	}
	function operateFormatter(value,row,index){
		return '<a href="ViewPoll.action?subid='+value+'" target="_top" style="color:blue">维护</a>';
	}
	function itemClick(val){
		alert("单元格值："+val);
	}
  	function add(){
  		alert("add''");
  	}
  	function participantsStyler(value,row,index){
  		if(value<5){
  			return "background-color:#ffee00;color:red";
  		}else if(value>15){
  			return "color:green";
  		}
  	}
    </script>
  </head>
  <body>
  <table id="dg" title="投票列表" style="height:410px;width:700px;"></table>
  </body>
</html>
