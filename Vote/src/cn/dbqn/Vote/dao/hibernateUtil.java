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
		// ���sessionΪnull�����һ���µ�session
		if (session == null) { // 3
			//����һ�����ݿ����Ӷ���session��
			session = sessionFactory.openSession(); // 4
			// ��������ݿ�����session��ThreadLocal�С�
			sessionTL.set(session); // 5
		}
		//�����ǰ�߳��Ѿ����ʹ����ݿ��ˣ�
		//���sessionTL��get()�Ϳ��Ի�ȡ���߳��ϴλ�ȡ�������ݿ����Ӷ���
		return session; // 6
	}
	public static void closeSession(){
		Session session = (Session) sessionTL.get(); // 2
		sessionTL.set(null);
		if(session!=null)
			session.close();
	}
}
