package hibernate;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;

public class UtilesHibernate {
	private static final SessionFactory sessionFactory;
	static {
		try {
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.configure().buildSessionFactory();
		} catch(Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
}
