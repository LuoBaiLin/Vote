package cn.dbqn.Vote.dao;

import java.util.List;

import cn.dbqn.Vote.entity.VoteSubject;

public interface VoteSubjectDao {
	/**
	 * 获取全部投票内容
	 * @return
	 */
	public List<VoteSubject> getAll();
	/**
	 * 新增投票内容
	 * @param subject 投票内容对象
	 * @return 受影响行数
	 */
	public int addSubject(VoteSubject subject);
	/**
	 * 通过投票内容id删除投票内容
	 * @param subjectid  投票内容id
	 * @return  受影响行数
	 */
	public int delSubject(int subjectId);
	/**
	 * 通过投票内容id查询投票内容
	 * @param subjectid 投票内容id
	 * @return 投票内容对象
	 */
	public VoteSubject selectById(int subjectId);
	/**
	 * 根据投票内容标题查询投票内容
	 * @param subjectName
	 * @return
	 */
	public VoteSubject selectByName(String subjectName);
	/**
	 * 修改投票内容
	 * @param subject
	 * @return
	 */
	public int updateSubject(VoteSubject subject);
	
}
