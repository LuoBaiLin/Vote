package cn.dbqn.Vote.entity;

import java.io.Serializable;

public class VoteItem implements Serializable {

	private Integer viId;
	private VoteOption voteOption;
	private VoteUser voteUser;
	private VoteSubject voteSubject;
	public Integer getViId() {
		return viId;
	}
	public void setViId(Integer viId) {
		this.viId = viId;
	}
	public VoteOption getVoteOption() {
		return voteOption;
	}
	public void setVoteOption(VoteOption voteOption) {
		this.voteOption = voteOption;
	}
	public VoteUser getVoteUser() {
		return voteUser;
	}
	public void setVoteUser(VoteUser voteUser) {
		this.voteUser = voteUser;
	}
	public VoteSubject getVoteSubject() {
		return voteSubject;
	}
	public void setVoteSubject(VoteSubject voteSubject) {
		this.voteSubject = voteSubject;
	}
	public VoteItem(Integer viId, VoteOption voteOption, VoteUser voteUser,
			VoteSubject voteSubject) {
		this.viId = viId;
		this.voteOption = voteOption;
		this.voteUser = voteUser;
		this.voteSubject = voteSubject;
	}
	public VoteItem(VoteOption voteOption, VoteUser voteUser,
			VoteSubject voteSubject) {
		this.voteOption = voteOption;
		this.voteUser = voteUser;
		this.voteSubject = voteSubject;
	}
	public VoteItem() {
	}
}
