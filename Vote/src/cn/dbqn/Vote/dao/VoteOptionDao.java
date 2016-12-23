package cn.dbqn.Vote.dao;

import java.util.List;

import cn.dbqn.Vote.entity.VoteOption;

public interface VoteOptionDao {
	/**
	 * ��ȡȫ��ͶƱѡ��
	 * @return
	 */
	public List<VoteOption> getAll();
	/**
	 * ����ͶƱѡ��
	 * @param option ͶƱѡ�����
	 * @return ��Ӱ������
	 */
	public int addOption(VoteOption option);
	/**
	 * ɾ��ͶƱѡ��
	 * @param optionId ͶƱѡ��ID
	 * @return ��Ӱ������
	 */
	public int delOption(int optionId);
	/**
	 * ����ͶƱѡ��Id��ѯͶƱѡ��
	 * @param optionId ͶƱѡ��Id
	 * @return ͶƱѡ�����
	 */
	public VoteOption selectById(int optionId);
	/**
	 * ����ͶƱ����id��ѯͶƱѡ��
	 * @param subjectId
	 * @return
	 */
	public List<VoteOption> selectBySubsId(int subid);
	/**
	 * ����ͶƱ����id��ѯͶƱѡ��
	 * @param optionsub
	 * @return
	 */
	public VoteOption selectBySubId(int optionsub);
	/**
	 * ����ͶƱ�������Ʋ�ѯͶƱѡ��
	 * @param optionName
	 * @return
	 */
	public List<VoteOption> selectByOptionName(String optionName);
	/**
	 * �޸�
	 * @param option
	 * @return
	 */
	public int updateOption(VoteOption option);
}
