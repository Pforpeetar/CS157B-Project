
public class Tester {
	
	public static void main(String[] args) {
		SamsonBuilder s = new SamsonBuilder();
		
		s.addDimension("Location", 3);
		ConcreteAttendanceDAO dao = new ConcreteAttendanceDAO();
		String hql = "select band.name, sum(a.attendance_count) from Attendance a, Band band where a.band=band.id group by band.name";

		System.out.println(hql);
		System.out.println(s.getStringQuery());
		
		System.out.print("[");
		for(Object o : dao.findByQuery(s.getStringQuery())){
			Object[] ah = (Object[])o;
			System.out.print("band name: " + ah[0]);
			System.out.print(", count: " + ah[1] + "  ");
		}
		System.out.println("]");
		
		/*
		//testing for band connection, also query for olap example
		String hql = "select band.name, sum(a.attendance_count) from Attendance a, Band band where a.band=band.id group by band.name";
		
		System.out.print("[");
		for(Object o : dao.findByQuery(hql)){
			Object[] ah = (Object[])o;
			System.out.print("band name: " + ah[0]);
			System.out.print(", count: " + ah[1] + "  ");
		}
		System.out.println("]");

		
		//testing for date connection
		hql = "select day_of_the_week from Date";
		System.out.println(dao.findByQuery(hql));
		
		
		//testing for location connection
		hql = "select venue from Location";
		System.out.println(dao.findByQuery(hql));
		

		//testing for attendee connection
		hql = "select age from AttendeeDemographic";
		System.out.println(dao.findByQuery(hql));
		
		System.out.println("CENTRAL CUBE: ");
		//testing for central cube
		hql = "select band.name, date.year, loc.venue, sum(a.attendance_count) from Attendance a, Band band, Date date, Location loc where a.band=band.id and"
				+ " a.date = date.id and a.location = loc.id group by band.name, date.year, loc.venue";
		System.out.print("[");
		for(Object o : dao.findByQuery(hql)){
			Object[] list = (Object[]) o;
			//maybe instead of a nested for loop we can use an iterator in the DAO. Query has a method iterate(), and we can use an iterator to get each row
			for(int i=0;i<list.length;i++){
				System.out.print(list[i].toString().trim() + ", ");
			}
			System.out.print("\t");
		}
		*/
		
	}
	
	public static void rollUpHierarchy() {
		
	}
	
	public static void rollUpDimension() {
		
	}
	
	public static void drillDownDimension() {
		
	}
	
	public static void drillDownHierarchy() {
		
	}
	
	public static void addSlice() {
		
	}

}
