package cn.dbqn.Vote.dao;

import java.util.List;

import cn.dbqn.Vote.entity.VoteOption;

public interface VoteOptionDao {
	/**
	 * 获取全部投票选项
	 * @return
	 */
	public List<VoteOption> getAll();
	/**
	 * 新增投票选项
	 * @param option 投票选项对象
	 * @return 受影响行数
	 */
	public int addOption(VoteOption option);
	/**
	 * 删除投票选项
	 * @param optionId 投票选项ID
	 * @return 受影响行数
	 */
	public int delOption(int optionId);
	/**
	 * 根据投票选项Id查询投票选项
	 * @param optionId 投票选项Id
	 * @return 投票选项对象
	 */
	public VoteOption selectById(int optionId);
	/**
	 * 根据投票内容id查询投票选项
	 * @param subjectId
	 * @return
	 */
	public List<VoteOption> selectBySubsId(int subid);
	/**
	 * 根据投票内容id查询投票选项
	 * @param optionsub
	 * @return
	 */
	public VoteOption selectBySubId(int optionsub);
	/**
	 * 根据投票内容名称查询投票选项
	 * @param optionName
	 * @return
	 */
	public List<VoteOption> selectByOptionName(String optionName);
	/**
	 * 修改
	 * @param option
	 * @return
	 */
	public int updateOption(VoteOption option);
}
