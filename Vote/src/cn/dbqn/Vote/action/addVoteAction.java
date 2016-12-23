package cn.dbqn.Vote.action;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import cn.dbqn.Vote.dao.VoteItemDao;
import cn.dbqn.Vote.dao.VoteOptionDao;
import cn.dbqn.Vote.dao.impl.VoteItemDaoImpl;
import cn.dbqn.Vote.dao.impl.VoteOptionDaoImpl;
import cn.dbqn.Vote.entity.VoteItem;
import cn.dbqn.Vote.entity.VoteOption;
import cn.dbqn.Vote.entity.VoteUser;

import com.opensymphony.xwork2.ActionSupport;

public class addVoteAction  extends ActionSupport{
	
	private String[] options;
	
	@Override
	public String execute(){
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		int result=0;
		for (int i = 0; i < options.length; i++) {
			VoteOptionDao optiondao=new VoteOptionDaoImpl();
			List<VoteOption> option=optiondao.selectByOptionName(options[i]);
			VoteUser voteuser=(VoteUser) session.getAttribute("userLogin");
			VoteItemDao voteitemdao=new VoteItemDaoImpl();
			VoteItem voteitem=new VoteItem();
			voteitem.setVoteOption(option.get(i));
			voteitem.setVoteSubject(option.get(i).getVoteSubject());
			voteitem.setVoteUser(voteuser);
			result=voteitemdao.addItem(voteitem);
		}
		if(result==1){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}
}
