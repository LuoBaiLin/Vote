package cn.dbqn.Vote.dao;

import java.util.List;

import cn.dbqn.Vote.entity.VoteSubject;

public interface VoteSubjectDao {
	/**
	 * ��ȡȫ��ͶƱ����
	 * @return
	 */
	public List<VoteSubject> getAll();
	/**
	 * ����ͶƱ����
	 * @param subject ͶƱ���ݶ���
	 * @return ��Ӱ������
	 */
	public int addSubject(VoteSubject subject);
	/**
	 * ͨ��ͶƱ����idɾ��ͶƱ����
	 * @param subjectid  ͶƱ����id
	 * @return  ��Ӱ������
	 */
	public int delSubject(int subjectId);
	/**
	 * ͨ��ͶƱ����id��ѯͶƱ����
	 * @param subjectid ͶƱ����id
	 * @return ͶƱ���ݶ���
	 */
	public VoteSubject selectById(int subjectId);
	/**
	 * ����ͶƱ���ݱ����ѯͶƱ����
	 * @param subjectName
	 * @return
	 */
	public VoteSubject selectByName(String subjectName);
	/**
	 * �޸�ͶƱ����
	 * @param subject
	 * @return
	 */
	public int updateSubject(VoteSubject subject);
	
}
