package cn.dbqn.Vote.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import cn.dbqn.Vote.dao.VoteOptionDao;
import cn.dbqn.Vote.dao.hibernateUtil;
import cn.dbqn.Vote.entity.VoteItem;
import cn.dbqn.Vote.entity.VoteOption;


public class VoteOptionDaoImpl  implements VoteOptionDao{

	@Override
	public int addOption(VoteOption option) {
		Transaction tx = null;
		Session session = null;
		try {
			session = hibernateUtil.currentSession();
			tx = session.beginTransaction();
			session.save(option);	
			tx.commit();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
			return -1;
		}
	}

	@Override
	public int delOption(int optionId) {
		Transaction tx = null;
		Session session = null;
		try {
			//打开session
			session = hibernateUtil.currentSession();
			//开启事务
			tx = session.beginTransaction();
			VoteOption option = (VoteOption)session.get(VoteOption.class,optionId);
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
	public VoteOption selectById(int optionId) {
		Session session = null;
		VoteOption option = null;
		try {
			//锟斤拷session
			session = hibernateUtil.currentSession();
			Query query = session.createQuery("from VoteOption as option where option.voId = ?");
			query.setInteger(0, optionId);
			option =(VoteOption)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return option;
	}

	@Override
	public List<VoteOption> getAll() {
		Session session = null;
		try {
			//打开session
			session = hibernateUtil.currentSession();
			Query query = session.createQuery("FROM VoteOption");
			List<VoteOption> Option = query.list();
			return Option;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public VoteOption selectBySubId(int optionsub) {
		Session session = null;
		VoteOption option = null;
		try {
			//锟斤拷session
			session = hibernateUtil.currentSession();
			Query query = session.createQuery("from VoteOption as option where option.voteSubject.vsId = ?");
			query.setInteger(0, optionsub);
			option =(VoteOption)query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return option;
	}

	@Override
	public List<VoteOption> selectBySubsId(int subid) {
		Session session = null;
		try {
			//打开session
			session = hibernateUtil.currentSession();
			Query query = session.createQuery("from VoteOption as option where option.voteSubject.vsId = ?");
			query.setInteger(0, subid);
			List<VoteOption> VoteOption = query.list();
			return VoteOption;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<VoteOption> selectByOptionName(String optionName) {
		Session session = null;
		List<VoteOption> VoteOption=new ArrayList<VoteOption>();
		try {
			//锟斤拷session
			session = hibernateUtil.currentSession();
			Query query = session.createQuery("from VoteOption as option where option.voOption = ?");
			query.setString(0, optionName);
			VoteOption = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return VoteOption;
	}

	@Override
	public int updateOption(VoteOption option) {
		Transaction tx = null;
		Session session = null;
		try {
			//打开session
			session = hibernateUtil.currentSession();
			//开启事务
			tx = session.beginTransaction();
			session.update(option);
			//提交事务
			tx.commit();
			return 1;
		} catch (Exception e) {
			tx.rollback();
			return -1;
		}
	}
}
