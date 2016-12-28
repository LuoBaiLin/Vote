package cn.dbqn.Vote.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.dbqn.Vote.dao.VoteSubjectDao;
import cn.dbqn.Vote.dao.impl.VoteSubjectDaoImpl;
import cn.dbqn.Vote.entity.VoteSubject;

import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	private String likeName;
	
	@Override
	public String execute(){
		HttpSession session = ServletActionContext.getRequest().getSession();
		VoteSubjectDao votesubject=new VoteSubjectDaoImpl();
		List<VoteSubject> votesubjects=new ArrayList<VoteSubject>();
		if(likeName=="" || likeName==null){
			votesubjects=votesubject.getAll();
		}else{
			votesubjects=votesubject.selectByLikeName(likeName);
		}
		session.setAttribute("listsubject", votesubjects);
		return SUCCESS;
	}

	public String getLikeName() {
		return likeName;
	}
	public void setLikeName(String likeName) {
		this.likeName = likeName;
	}
}
