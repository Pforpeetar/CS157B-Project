
public class Tester {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SamsonBuilder s = new SamsonBuilder();
		s.selects.add("name");
		s.selects.add("year");
		s.selects.add("venue");
		s.froms.add("band");
		s.froms.add("date_table");
		s.froms.add("location");
		s.wheres.add("band");
		s.wheres.add("date_table");
		s.wheres.add("location");
		s.slices.add("band.name = 'Taylor Swift'");
		s.slices.add("date_table.year = '2016'");
		
		ConcreteAttendanceDAO dao = new ConcreteAttendanceDAO();
		System.out.println(s.getStringQuery());
		dao.findByQuery(s.getStringQuery());
		System.out.println(dao.findByQuery(s.getStringQuery()));
	}

}
