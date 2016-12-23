package cn.dbqn.Vote.action;

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
import cn.dbqn.Vote.entity.VoteUser;

import com.opensymphony.xwork2.ActionSupport;

public class FabuAction extends ActionSupport{
	//获取页面输入数据
	private String votecontent;
	private int xuan;
	private String[] voteoption;
	
	private VoteItem voteitem;
	private VoteOption voteoptions;
	private VoteSubject votesubject;
	private VoteUser voteuser;
	
	private VoteItemDao itemdao=new VoteItemDaoImpl();
	private VoteOptionDao optiondao=new VoteOptionDaoImpl();
	private VoteSubjectDao subjectdao=new VoteSubjectDaoImpl();
	@Override
	public String execute(){
		//添加投票内容(subject)
		//添加投票选项（循环）(option)
		//添加投票取值（item）
		HttpSession session=ServletActionContext.getRequest().getSession();
		
		voteitem=new VoteItem();
		voteoptions=new VoteOption();
		votesubject=new VoteSubject();
		
		voteuser=(VoteUser) session.getAttribute("userLogin");
		//添加投票内容(subject)
		votesubject.setVsTitle(votecontent);
		votesubject.setVsType(xuan);
		int result1=subjectdao.addSubject(votesubject);
		int result=0;
		for(int i=0;i<voteoption.length;i++){
			////添加投票选项（循环）(option)
				voteoptions.setVoOption(voteoption[i]);
				voteoptions.setVoteSubject(votesubject);
				result=optiondao.addOption(voteoptions);
		}
		if(result==1){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String getVotecontent() {
		return votecontent;
	}
	public void setVotecontent(String votecontent) {
		this.votecontent = votecontent;
	}
	public int getXuan() {
		return xuan;
	}
	public void setXuan(int xuan) {
		this.xuan = xuan;
	}
	public String[] getVoteoption() {
		return voteoption;
	}
	public void setVoteoption(String[] voteoption) {
		this.voteoption = voteoption;
	}
	public VoteItem getVoteitem() {
		return voteitem;
	}
	public void setVoteitem(VoteItem voteitem) {
		this.voteitem = voteitem;
	}
	public VoteOption getVoteoptions() {
		return voteoptions;
	}
	public void setVoteoptions(VoteOption voteoptions) {
		this.voteoptions = voteoptions;
	}
	public VoteSubject getVotesubject() {
		return votesubject;
	}
	public void setVotesubject(VoteSubject votesubject) {
		this.votesubject = votesubject;
	}
}
