<%@page import="cn.dbqn.Vote.dao.impl.VoteOptionDaoImpl"%>
<%@page import="cn.dbqn.Vote.dao.impl.VoteSubjectDaoImpl"%>
<%@page import="cn.dbqn.Vote.dao.VoteSubjectDao"%>
<%@page import="cn.dbqn.Vote.dao.VoteOptionDao"%>
<%@page import="cn.dbqn.Vote.dao.impl.VoteItemDaoImpl"%>
<%@page import="cn.dbqn.Vote.dao.VoteItemDao"%>
<%@page import="cn.dbqn.Vote.entity.VoteOption"%>
<%@page import="cn.dbqn.Vote.entity.VoteSubject"%>
<%@page import="cn.dbqn.Vote.entity.VoteItem"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
//构造测试数据
	VoteItemDao voteitem=new VoteItemDaoImpl();
	VoteOptionDao voteoption=new VoteOptionDaoImpl();
	VoteSubjectDao votesubject=new VoteSubjectDaoImpl();
	
	List<VoteItem> listitem=(List<VoteItem>)session.getAttribute("listitem");
	List<VoteSubject> listsubject=(List<VoteSubject>)session.getAttribute("listsubject");
	
	//获取客户端传递的分页参数
	Integer pageSize=Integer.parseInt(request.getParameter("rows"));
	//默认参数rows表示每页显示记录条数
	Integer pageNumber=Integer.parseInt(request.getParameter("page"));
	//默认参数page表示当前页码
	StringBuffer builder=new StringBuffer("{\"total\":"+listsubject.size()+",\"rows\":[");
	int start=(pageNumber-1)*pageSize;//计算分页开始记录数
	int end=start+pageSize;
	//根据分页其实参数构建当前页的列表数据
	for(int i=0;i<end && i<listsubject.size();i++){
	
		VoteSubject su=listsubject.get(i);
		
		List<VoteOption> voteop=voteoption.selectBySubsId(su.getVsId());
		List<VoteItem> voteit=voteitem.selectBySubId(su.getVsId());
		
		builder.append("{\"id\":\""+su.getVsId()+"\",\"title\":\""+su.getVsTitle()+"\",\"options\":"+
			voteop.size()+",\"participants\":"+voteit.size()+"},");
	
	}
	
	String gridJSON=builder.toString();
	if(gridJSON.endsWith(",")){
		gridJSON=gridJSON.substring(0,gridJSON.lastIndexOf(","));
	}
	out.print(gridJSON+"]}");
%>
