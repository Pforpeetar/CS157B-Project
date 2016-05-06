
public class Tester {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SamsonBuilder s = new SamsonBuilder();
		s.selects.add("name");
		s.froms.add("Band");
		s.wheres.add("Band");
		s.slices.add("Band.name = 'Taylor Swift'");
		
		
		String hql = "select band.name, sum(a.attendance_count) from Attendance a, Band band where a.band=band.id group by band.name";
		ConcreteAttendanceDAO dao = new ConcreteAttendanceDAO();
		for(Object o : dao.findByQuery(hql)){
			Object[] ah = (Object[])o;
			System.out.println("band name: " + ah[0]);
			System.out.println("count: " + ah[1]);
		}

//		System.out.println(s.getStringQuery());
//		dao.findByQuery(s.getStringQuery());
	}

}
