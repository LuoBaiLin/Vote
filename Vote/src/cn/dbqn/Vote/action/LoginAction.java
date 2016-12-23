package cn.dbqn.Vote.action;

import java.io.InputStream;

import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import cn.dbqn.Vote.dao.VoteUserDao;
import cn.dbqn.Vote.dao.impl.VoteUserDaoImpl;
import cn.dbqn.Vote.entity.VoteUser;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport {
	
	private String vuUserName;
	private String vuUserPassword;
	private InputStream inputStream;
/*	private JSONObject resultJson=null;
	@Override
	public String execute(){
		HttpSession session=ServletActionContext.getRequest().getSession();
		resultJson=new JSONObject();
		VoteUser VoteUser=new VoteUser(vuUserName,vuUserPassword);
		VoteUserDao userDao = new VoteUserDaoImpl();
		VoteUser userLogin = userDao.selectByLogin(VoteUser);
		if(userLogin == null){
			resultJson.put("flag",false);
			resultJson.put("message","用户名或密码错误！");
		}else{
			session.setAttribute("userLogin", userLogin);
			resultJson.put("flag",true);
			resultJson.put("message",VoteUser.getVuUserName()+"登录成功");
		}
		return SUCCESS;
	}*/
	
	public String execute(){
		VoteUser VoteUser=new VoteUser(vuUserName,vuUserPassword);
		VoteUserDao userDao = new VoteUserDaoImpl();
		VoteUser userLogin = userDao.selectByLogin(VoteUser);
		HttpSession session=ServletActionContext.getRequest().getSession();
		if(userLogin == null){
			return INPUT;
		}else{
			session.setAttribute("userLogin", userLogin);
			return SUCCESS;
		}
	}
	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public String getVuUserName() {
		return vuUserName;
	}

	public void setVuUserName(String vuUserName) {
		this.vuUserName = vuUserName;
	}

	public String getVuUserPassword() {
		return vuUserPassword;
	}

	public void setVuUserPassword(String vuUserPassword) {
		this.vuUserPassword = vuUserPassword;
	}

	
}
