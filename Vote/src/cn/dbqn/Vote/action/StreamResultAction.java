package cn.dbqn.Vote.action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import cn.dbqn.Vote.dao.VoteUserDao;
import cn.dbqn.Vote.dao.impl.VoteUserDaoImpl;
import cn.dbqn.Vote.entity.VoteUser;

import com.opensymphony.xwork2.ActionSupport;

public class StreamResultAction extends ActionSupport{
	private InputStream inputStream;
	private String names;
	@Override
	public String execute() throws IOException{
		try {
			String result=null;
			VoteUserDao voteuser=new VoteUserDaoImpl();
			VoteUser user=voteuser.selectByName(names);
			if(user!=null){
				result="用户名已存在";
			}else{
				result="用户名可用";
			}
			inputStream =new ByteArrayInputStream(result.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "success";
	}
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public String getNames() {
		return names;
	}
	public void setNames(String names) {
		this.names = names;
	}
	
	
}
