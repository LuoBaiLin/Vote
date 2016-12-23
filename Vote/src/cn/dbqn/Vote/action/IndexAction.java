package cn.dbqn.Vote.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.dbqn.Vote.dao.VoteItemDao;
import cn.dbqn.Vote.dao.VoteOptionDao;
import cn.dbqn.Vote.dao.VoteSubjectDao;
import cn.dbqn.Vote.dao.impl.VoteItemDaoImpl;
import cn.dbqn.Vote.dao.impl.VoteOptionDaoImpl;
import cn.dbqn.Vote.dao.impl.VoteSubjectDaoImpl;
import cn.dbqn.Vote.entity.VoteItem;
import cn.dbqn.Vote.entity.VoteOption;
import cn.dbqn.Vote.entity.VoteSubject;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	@Override
	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		VoteItemDao voteitem=new VoteItemDaoImpl();
		VoteOptionDao voteoption=new VoteOptionDaoImpl();
		VoteSubjectDao votesubject=new VoteSubjectDaoImpl();
		List<VoteItem> voteitems=voteitem.getAll();
		session.setAttribute("listitem", voteitems);
		List<VoteSubject> votesubjects=votesubject.getAll();
		session.setAttribute("listsubject", votesubjects);
		return SUCCESS;
	}
}
