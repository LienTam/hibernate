package timkiemdiadiemamthuc.model;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY;

	static {
		try {
			SESSION_FACTORY = new AnnotationConfiguration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println(ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session openSession() throws HibernateException {
		return SESSION_FACTORY.getCurrentSession();
	}

	public static void shutdown() {
		// Close caches and connection pools
		// Giải phóng cache và Connection Pools.
		SESSION_FACTORY.close();
	}

	public static void main(String[] args) {
		openSession();
		shutdown();
	}
}
