package cn.dbqn.Vote.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.dbqn.Vote.dao.VoteSubjectDao;
import cn.dbqn.Vote.dao.hibernateUtil;
import cn.dbqn.Vote.entity.VoteSubject;

public class VoteSubjectDaoImpl implements VoteSubjectDao{

	@Override
	public int addSubject(VoteSubject subject) {
		Transaction tx = null;
		Session session = null;
		try {
			session = hibernateUtil.currentSession();
			tx = session.beginTransaction();
			session.save(subject);	
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return -1;
		}
	}

	@Override
	public int delSubject(int subjectid) {
		Transaction tx = null;
		Session session = null;
		try {
			//打开session
			session = hibernateUtil.currentSession();
			//开启事务
			tx = session.beginTransaction();
			VoteSubject option = (VoteSubject)session.get(VoteSubject.class,subjectid);
			session.delete(option);
			//提交事务
			tx.commit();
			return 1;
		} catch (Exception e) {
			tx.rollback();
			return -1;
		}
	}

	@Override
	public VoteSubject selectById(int subjectid) {
		Session session = null;
		VoteSubject subject = null;
		try {
			session = hibernateUtil.currentSession();
			Query query = session.createQuery("from VoteSubject as subject where subject.vsId = ?");
			query.setInteger(0, subjectid);
			subject =(VoteSubject)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subject;
	}

	@Override
	public List<VoteSubject> getAll() {
		Session session = null;
		try {
			//打开session
			session = hibernateUtil.currentSession();
			Query query = session.createQuery("FROM VoteSubject");
			List<VoteSubject> Subject = query.list();
			return Subject;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public VoteSubject selectByName(String subjectName) {
		Session session = null;
		VoteSubject subject = null;
		try {
			//锟斤拷session
			session = hibernateUtil.currentSession();
			Query query = session.createQuery("from VoteSubject as subject where subject.vsTitle = ?");
			query.setString(0, subjectName);
			subject =(VoteSubject)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subject;
	}

	@Override
	public int updateSubject(VoteSubject subject) {
		Transaction tx = null;
		Session session = null;
		try {
			//打开session
			session = hibernateUtil.currentSession();
			//开启事务
			tx = session.beginTransaction();
			session.update(subject);
			//提交事务
			tx.commit();
			return 1;
		} catch (Exception e) {
			tx.rollback();
			return -1;
		}
	}

}
