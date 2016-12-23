package cn.dbqn.Vote.dao;

import java.util.List;

import cn.dbqn.Vote.entity.VoteItem;

public interface VoteItemDao {
	/**
	 * 获取全部投票取值对象
	 * @return
	 */
	public List<VoteItem> getAll();
	/**
	 * 新增投票取值
	 * @param item 投票取值对象
	 * @return
	 */
	public int addItem(VoteItem item);
	
	/**
	 * 删除投票取值
	 * @param itemid 投票取值编号
	 * @return 受影响行数
	 */
	public int delItem(int itemid);
	/**
	 * 根据选项内容id查询有多少条投票人数
	 * @param subid
	 * @return
	 */
	public List<VoteItem> selectBySubId(int subid);
	/**
	 * 根据选项id查询有多少条投票人数
	 * @param optionid
	 * @return
	 */
	public List<VoteItem> selectByoptionId(int optionid);
}
