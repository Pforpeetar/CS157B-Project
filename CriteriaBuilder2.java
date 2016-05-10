import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class CriteriaBuilder2 {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	List<String> restrictions;
	List<String> projections;
	List<String> orders;
	
	public Criteria getCriteria() {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Attendance.class);
		ProjectionList projectionList = Projections.projectionList();
		for (String p : projections) {
			projectionList.add(Projections.groupProperty(p));
		}
	    criteria.setProjection(projectionList);
		for (String r : restrictions) {
			criteria.setFetchMode(r, FetchMode.JOIN);
			//criteria.createAlias("attendance." + r, r);
		}
		for (String o : orders) {
			criteria.addOrder(Order.desc(o));
		}
		return criteria;
	}
}
