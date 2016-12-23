package cn.dbqn.Vote.dao;

import cn.dbqn.Vote.entity.VoteUser;

public interface VoteUserDao {
	/**
	 * ��¼
	 * @param user �û�����
	 * @return
	 */
	public VoteUser selectByLogin(VoteUser user);
	/**
	 * ע���û�
	 * @param user �û�����
	 * @return ��Ӱ������
	 */
	public int register(VoteUser user);
	/**
	 *  ͨ��idѰ���û�
	 * @param id �û�id
	 * @return �û�����
	 */
	public VoteUser selectById(int id);
	/**
	 * �û�ע����֤����
	 * @param name
	 * @return
	 */
	public VoteUser selectByName(String name);
}
