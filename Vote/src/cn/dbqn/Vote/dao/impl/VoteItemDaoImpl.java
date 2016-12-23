package cn.dbqn.Vote.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.dbqn.Vote.dao.VoteItemDao;
import cn.dbqn.Vote.dao.hibernateUtil;
import cn.dbqn.Vote.entity.VoteItem;

public class VoteItemDaoImpl implements VoteItemDao {

	@Override
	public int addItem(VoteItem item) {
		Transaction tx = null;
		Session session = null;
		try {
			session = hibernateUtil.currentSession();
			tx = session.beginTransaction();
			session.save(item);	
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return -1;
		}
	}

	@Override
	public int delItem(int itemid) {
		Transaction tx = null;
		Session session = null;
		try {
			//打开session
			session = hibernateUtil.currentSession();
			//开启事务
			tx = session.beginTransaction();
			VoteItem item = (VoteItem)session.get(VoteItem.class,itemid);
			session.delete(item);
			//提交事务
			tx.commit();
			return 1;
		} catch (Exception e) {
			tx.rollback();
			return -1;
		}
	}

	@Override
	public List<VoteItem> getAll() {
		Session session = null;
		try {
			//打开session
			session = hibernateUtil.currentSession();
			Query query = session.createQuery("FROM VoteItem");
			List<VoteItem> VoteItem = query.list();
			return VoteItem;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<VoteItem> selectBySubId(int subid) {
		Session session = null;
		try {
			//打开session
			session = hibernateUtil.currentSession();
			Query query = session.createQuery("from VoteItem as item where item.voteSubject.vsId = ?");
			query.setInteger(0, subid);
			List<VoteItem> VoteItem = query.list();
			return VoteItem;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<VoteItem> selectByoptionId(int optionid) {
		Session session = null;
		try {
			//打开session
			session = hibernateUtil.currentSession();
			Query query = session.createQuery("from VoteItem as item where item.voteOption.voId = ?");
			query.setInteger(0, optionid);
			List<VoteItem> VoteItem = query.list();
			return VoteItem;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
