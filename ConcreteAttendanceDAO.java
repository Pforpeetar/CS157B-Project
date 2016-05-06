import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ConcreteAttendanceDAO implements AttendanceDAO {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public List<Attendance> findByQuery(String queryString) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery(queryString);

		List<Attendance> result = query.list();
		
		session.getTransaction().commit();
		session.close();
		return result;
	}

}
