import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ConcreteAttendanceDAO implements AttendanceDAO {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	
	@Override
	public List<Attendance> findByQuery(CriteriaBuilder cb) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		List<Attendance> result = cb.getCriteria().list();
		
		session.getTransaction().commit();
		session.close();
		return result;
	}

}
