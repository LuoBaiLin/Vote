package cn.dbqn.Vote.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class VoteSubject implements Serializable {
	
	private Integer vsId;
	private String vsTitle;
	private Integer vsType;
	private Set<VoteItem> voteItems = new HashSet<VoteItem>();
	private Set<VoteOption> voteOptions = new HashSet<VoteOption>();
	public Integer getVsId() {
		return vsId;
	}
	public void setVsId(Integer vsId) {
		this.vsId = vsId;
	}
	public String getVsTitle() {
		return vsTitle;
	}
	public void setVsTitle(String vsTitle) {
		this.vsTitle = vsTitle;
	}
	public Integer getVsType() {
		return vsType;
	}
	public void setVsType(Integer vsType) {
		this.vsType = vsType;
	}
	public Set<VoteItem> getVoteItems() {
		return voteItems;
	}
	public void setVoteItems(Set<VoteItem> voteItems) {
		this.voteItems = voteItems;
	}
	public Set<VoteOption> getVoteOptions() {
		return voteOptions;
	}
	public void setVoteOptions(Set<VoteOption> voteOptions) {
		this.voteOptions = voteOptions;
	}
	public VoteSubject(Integer vsId, String vsTitle, Integer vsType,
			Set<VoteItem> voteItems, Set<VoteOption> voteOptions) {
		this.vsId = vsId;
		this.vsTitle = vsTitle;
		this.vsType = vsType;
		this.voteItems = voteItems;
		this.voteOptions = voteOptions;
	}
	
	public VoteSubject(String vsTitle, Integer vsType, Set<VoteItem> voteItems,
			Set<VoteOption> voteOptions) {
		this.vsTitle = vsTitle;
		this.vsType = vsType;
		this.voteItems = voteItems;
		this.voteOptions = voteOptions;
	}
	public VoteSubject() {
	}

}
