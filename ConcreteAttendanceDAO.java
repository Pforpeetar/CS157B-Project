import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ConcreteAttendanceDAO implements AttendanceDAO {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public List<Attendance> findByQuery(String query) {
		Session session = sessionFactory.openSession();
	    session.beginTransaction();
		Query queryResult = session.createQuery(query);
		List<Attendance> result = queryResult.list();
		session.getTransaction().commit();
		session.close();
		return result;
	}

}
