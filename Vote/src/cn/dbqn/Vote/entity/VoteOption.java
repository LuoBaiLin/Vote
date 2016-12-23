package cn.dbqn.Vote.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class VoteOption implements Serializable {
	
	private Integer voId;
	private VoteSubject voteSubject;
	private String voOption;
	private Integer voOrder;
	private Set<VoteItem> voteItems = new HashSet<VoteItem>();
	public Integer getVoId() {
		return voId;
	}
	public void setVoId(Integer voId) {
		this.voId = voId;
	}
	public VoteSubject getVoteSubject() {
		return voteSubject;
	}
	public void setVoteSubject(VoteSubject voteSubject) {
		this.voteSubject = voteSubject;
	}
	public String getVoOption() {
		return voOption;
	}
	public void setVoOption(String voOption) {
		this.voOption = voOption;
	}
	public Integer getVoOrder() {
		return voOrder;
	}
	public void setVoOrder(Integer voOrder) {
		this.voOrder = voOrder;
	}
	public Set<VoteItem> getVoteItems() {
		return voteItems;
	}
	public void setVoteItems(Set<VoteItem> voteItems) {
		this.voteItems = voteItems;
	}
	public VoteOption(Integer voId, VoteSubject voteSubject, String voOption,
			Integer voOrder, Set<VoteItem> voteItems) {
		this.voId = voId;
		this.voteSubject = voteSubject;
		this.voOption = voOption;
		this.voOrder = voOrder;
		this.voteItems = voteItems;
	}
	public VoteOption() {
	}

}
