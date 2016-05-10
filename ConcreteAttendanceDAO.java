import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ConcreteAttendanceDAO implements AttendanceDAO {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public List findByQuery(String query) {
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
		Query queryResult = session.createQuery(query);
		//TODO: make a data structure or something to store the result
		List result = queryResult.list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

}
