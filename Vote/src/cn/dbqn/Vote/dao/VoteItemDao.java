package cn.dbqn.Vote.dao;

import java.util.List;

import cn.dbqn.Vote.entity.VoteItem;

public interface VoteItemDao {
	/**
	 * ��ȡȫ��ͶƱȡֵ����
	 * @return
	 */
	public List<VoteItem> getAll();
	/**
	 * ����ͶƱȡֵ
	 * @param item ͶƱȡֵ����
	 * @return
	 */
	public int addItem(VoteItem item);
	
	/**
	 * ɾ��ͶƱȡֵ
	 * @param itemid ͶƱȡֵ���
	 * @return ��Ӱ������
	 */
	public int delItem(int itemid);
	/**
	 * ����ѡ������id��ѯ�ж�����ͶƱ����
	 * @param subid
	 * @return
	 */
	public List<VoteItem> selectBySubId(int subid);
	/**
	 * ����ѡ��id��ѯ�ж�����ͶƱ����
	 * @param optionid
	 * @return
	 */
	public List<VoteItem> selectByoptionId(int optionid);
}
