package cn.dbqn.Vote.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class VoteUser implements Serializable {

	private Integer vuUserId;
	private String vuUserName;
	private String vuUserPassword;
	private Set<VoteItem> voteItems = new HashSet<VoteItem>();
	public Integer getVuUserId() {
		return vuUserId;
	}
	public void setVuUserId(Integer vuUserId) {
		this.vuUserId = vuUserId;
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
	public Set<VoteItem> getVoteItems() {
		return voteItems;
	}
	public void setVoteItems(Set<VoteItem> voteItems) {
		this.voteItems = voteItems;
	}
	public VoteUser(Integer vuUserId, String vuUserName, String vuUserPassword,
			Set<VoteItem> voteItems) {
		this.vuUserId = vuUserId;
		this.vuUserName = vuUserName;
		this.vuUserPassword = vuUserPassword;
		this.voteItems = voteItems;
	}
	public VoteUser(String vuUserName, String vuUserPassword) {
		this.vuUserName = vuUserName;
		this.vuUserPassword = vuUserPassword;
	}
	public VoteUser() {
	}
	

}
