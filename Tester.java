
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
		s.orders.add("band.name");
		s.orders.add("date_table.year");
		s.orders.add("location.venue");
		System.out.println(s.getStringQuery());
	}

}
