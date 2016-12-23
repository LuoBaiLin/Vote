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
import cn.dbqn.Vote.entity.VoteUser;

import com.opensymphony.xwork2.ActionSupport;

public class UpdateVoteAction extends ActionSupport{
	private String subjects;
	private int optionType;
	private String[] options;
	
	private VoteItem voteitem;
	private VoteOption voteoptions;
	private VoteSubject votesubject;
	private VoteUser voteuser;
	
	private VoteItemDao itemdao=new VoteItemDaoImpl();
	private VoteOptionDao optiondao=new VoteOptionDaoImpl();
	private VoteSubjectDao subjectdao=new VoteSubjectDaoImpl();
	
	public String execute(){
		//���ͶƱ����(subject)
		//���ͶƱѡ�ѭ����(option)
		//���ͶƱȡֵ��item��
		HttpSession session=ServletActionContext.getRequest().getSession();
		voteitem=new VoteItem();
		voteoptions=new VoteOption();
		votesubject=new VoteSubject();
		voteuser=(VoteUser) session.getAttribute("userLogin");
		List<VoteOption> option=(List<VoteOption>) session.getAttribute("option");
		
		//���ͶƱ����(subject)
		votesubject.setVsTitle(subjects);
		votesubject.setVsType(optionType);
		int result1=subjectdao.updateSubject(votesubject);
		System.out.println(result1);
		
		int result=0;
		for(int i=0;i<options.length;i++){
			if (option.size()>i) {
				//���ͶƱѡ�ѭ����(option)
				voteoptions.setVoOption(options[i]);
				result=optiondao.updateOption(voteoptions);
			}else{
				voteoptions.setVoOption(options[i]);
				voteoptions.setVoteSubject(votesubject);
				result=optiondao.addOption(voteoptions);
			}
		}
		if(result==1){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	
	public String getSubjects() {
		return subjects;
	}
	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}
	public int getOptionType() {
		return optionType;
	}
	public void setOptionType(int optionType) {
		this.optionType = optionType;
	}
	public String[] getOptions() {
		return options;
	}
	public void setOptions(String[] options) {
		this.options = options;
	}
	
}
