import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

public class CriteriaBuilder {
	private static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	private Criteria criteria;
	public CriteriaBuilder () {
		Session session = sessionFactory.openSession();
		Criteria criteria = session.createCriteria(Attendance.class);
	}
	
	public Criteria getCriteria() {
		return criteria;
	}
	
	public void addProjections(List<String> projections) {
		ProjectionList projectionList = Projections.projectionList();
		for (String p : projections) {
			projectionList.add(Projections.groupProperty(p));
		}
	    criteria.setProjection(projectionList);
	}
	
	public void addRestrictions(List<String> restrictions) {
		for (String r : restrictions) {
			criteria.setFetchMode(r, FetchMode.JOIN);
			//criteria.createAlias("attendance." + r, r);
		}
	}
	
	public void addOrder(List<String> orders) {
		for (String o : orders) {
			criteria.addOrder(Order.desc(o));
		}
	}
}
