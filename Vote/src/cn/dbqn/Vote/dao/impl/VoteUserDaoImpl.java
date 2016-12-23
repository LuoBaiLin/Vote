package cn.dbqn.Vote.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.dbqn.Vote.dao.VoteUserDao;
import cn.dbqn.Vote.entity.VoteUser;
import cn.dbqn.Vote.dao.hibernateUtil;

public class VoteUserDaoImpl implements VoteUserDao {

	@Override
	public VoteUser selectByLogin(VoteUser user) {
		Session session = null;
		VoteUser users = null;
		try {
			session =hibernateUtil.currentSession();
			Query query = session.getNamedQuery("HQLUserLogin");
			query.setString(0, user.getVuUserName());
			query.setString(1, user.getVuUserPassword());
			users =(VoteUser)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public int register(VoteUser user) {
		Transaction tx = null;
		Session session = null;
		try {
			session = hibernateUtil.currentSession();
			tx = session.beginTransaction();
			session.save(user);	
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return -1;
		}
	}

	@Override
	public VoteUser selectById(int id) {
		Session session = null;
		VoteUser users = null;
		try {
			//��session
			session = hibernateUtil.currentSession();
			Query query = session.createQuery("from VoteUser as user where user.vuUserId = ?");
			query.setInteger(0, id);
			users =(VoteUser)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public VoteUser selectByName(String name) {
		Session session = null;
		VoteUser users = null;
		try {
			//��session
			session = hibernateUtil.currentSession();
			Query query = session.createQuery("from VoteUser as user where user.vuUserName = ?");
			query.setString(0, name);
			users =(VoteUser)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}

}
