package cn.dbqn.Vote.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class hibernateUtil {   
	
	private static final ThreadLocal sessionTL = new ThreadLocal(); // 1
	private static Configuration configuration;
	private final static SessionFactory sessionFactory;
	static {
		try {
			configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static Session currentSession() {
		Session session = (Session) sessionTL.get(); // 2
		// 如果session为null，则打开一个新的session
		if (session == null) { // 3
			//创建一个数据库连接对象session。
			session = sessionFactory.openSession(); // 4
			// 保存该数据库连接session到ThreadLocal中。
			sessionTL.set(session); // 5
		}
		//如果当前线程已经访问过数据库了，
		//则从sessionTL中get()就可以获取该线程上次获取过的数据库连接对象。
		return session; // 6
	}
	public static void closeSession(){
		Session session = (Session) sessionTL.get(); // 2
		sessionTL.set(null);
		if(session!=null)
			session.close();
	}
}
