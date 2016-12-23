package cn.dbqn.Vote.action;


import cn.dbqn.Vote.dao.VoteUserDao;
import cn.dbqn.Vote.dao.impl.VoteUserDaoImpl;
import cn.dbqn.Vote.entity.VoteUser;

import com.opensymphony.xwork2.ActionSupport;

public class RegisteAction extends ActionSupport {
	
	private String names;
	private String password;
	@Override
	public String execute(){
		VoteUser user=new VoteUser(names,password);
		VoteUserDao userdao=new VoteUserDaoImpl();
		int result=userdao.register(user);
		if(result==1){
			return SUCCESS;
		}else{
			return INPUT;
		}
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
