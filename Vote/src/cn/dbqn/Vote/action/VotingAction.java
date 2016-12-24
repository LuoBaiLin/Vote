package cn.dbqn.Vote.action;

import java.util.ArrayList;
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

public class VotingAction extends ActionSupport{
	//Ñ¡ÏîÄÚÈÝid
	private int subid;
	@Override
	public String execute(){
		VoteSubjectDao subjectdao=new VoteSubjectDaoImpl();
		VoteSubject subject=subjectdao.selectById(subid);
		VoteOptionDao optiondao=new VoteOptionDaoImpl();
		List<VoteOption> option=optiondao.selectBySubsId(subid);
		VoteItemDao voteitemdao=new VoteItemDaoImpl();
		List<VoteItem> voteitem=voteitemdao.selectBySubId(subid);
		List<Integer> Nums=new ArrayList<Integer>();
		for (int i = 0; i < option.size(); i++) {
			int result=voteitemdao.selectByoptionId(option.get(i).getVoId()).size();
			Nums.add(result);
		}
		
		HttpSession session=ServletActionContext.getRequest().getSession();
		session.setAttribute("nums", Nums);
		session.setAttribute("option", option);
		session.setAttribute("subject", subject);
		session.setAttribute("voteitem",voteitem);
		session.setAttribute("options", option.size());
		session.setAttribute("voteitems", voteitem.size());
		return SUCCESS;
	}
	public int getSubid() {
		return subid;
	}
	public void setSubid(int subid) {
		this.subid = subid;
	}
}
