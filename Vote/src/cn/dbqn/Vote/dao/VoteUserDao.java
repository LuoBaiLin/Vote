package cn.dbqn.Vote.dao;

import cn.dbqn.Vote.entity.VoteUser;

public interface VoteUserDao {
	/**
	 * 登录
	 * @param user 用户对象
	 * @return
	 */
	public VoteUser selectByLogin(VoteUser user);
	/**
	 * 注册用户
	 * @param user 用户对象
	 * @return 受影响行数
	 */
	public int register(VoteUser user);
	/**
	 *  通过id寻找用户
	 * @param id 用户id
	 * @return 用户对象
	 */
	public VoteUser selectById(int id);
	/**
	 * 用户注册验证方法
	 * @param name
	 * @return
	 */
	public VoteUser selectByName(String name);
}
