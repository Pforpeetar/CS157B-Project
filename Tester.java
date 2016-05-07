import java.util.Scanner;

public class Tester {
	static SamsonBuilder sam = new SamsonBuilder();
	static ConcreteAttendanceDAO dao = new ConcreteAttendanceDAO();
	public static void main(String[] args) {
		//testSamson();
		//testPeter();
		//testConsole();
	}

	public static void testPeter() {
		System.out.println("\n\nPeter's Test");
		sam.addDimension(DimensionEnum.Band, 1);
		printList();
		sam.addDimension(DimensionEnum.Date, 2);
		printList();
		sam.addDimension(DimensionEnum.Location, 1);
		printList();
		sam.climbUpHierarchy(DimensionEnum.Location);
		printList();
		sam.climbDownHierarchy(DimensionEnum.Location);
		printList();
		sam.removeDimension(DimensionEnum.Location);
		printList();
		sam.addSlice(DimensionEnum.Band, "Adele");
		printList();
	}
	
	public static void printList() {
		System.out.print("\n[");
		for(Object o : dao.findByQuery(sam.getStringQuery())){
			Object[] list = (Object[]) o;
			//maybe instead of a nested for loop we can use an iterator in the DAO. Query has a method iterate(), and we can use an iterator to get each row
			for(int i=0;i<list.length;i++){
				System.out.print(list[i].toString().trim() + ", ");
			}
			System.out.print("\t");
		}
	}
	
	public static void printQuery() {
		System.out.print("[");
		for(Object o : dao.findByQuery(sam.getStringQuery())){
			Object[] ah = (Object[])o;
			System.out.print("band name: " + ah[0]);
			System.out.print(", count: " + ah[1] + "  ");
		}
		System.out.println("]");
	}
	
	public static void testConsole() {
		Scanner in = new Scanner(System.in);
		promptInput(in);
		in.close();
	}
	

	
	public static DimensionEnum chooseDimension(Scanner in) {
		System.out.println("||====Choose Payment:=====||");
		System.out.println("||[1]Band, [2]Location, [3]Date, [4]AttendeeDemographic||");
		System.out.println("Input: ");
		int input = in.nextInt();
		DimensionEnum dimensionEnum = null;
		if (input == 1) {
			dimensionEnum = DimensionEnum.Band;
		} else if (input == 2) {
			dimensionEnum = DimensionEnum.Location;;
		} else if (input == 3) {
			dimensionEnum = DimensionEnum.Date;
		} else if (input == 4) {
			dimensionEnum = DimensionEnum.AttendeeDemographic;
		}
		return dimensionEnum;
	}
	
	public static void rollUpHierarchy(Scanner in) {
		sam.climbUpHierarchy(chooseDimension(in));
	}
	
	public static void rollUpDimension(Scanner in) {
		System.out.println("||====Choose Payment:=====||");
		System.out.println("||[1]Band, [2]Location, [3]Date, [4]AttendeeDemographic||");
		System.out.println("Input: ");
		int input = in.nextInt();
		DimensionEnum dimensionEnum = null;
		int hierarchy = 1;
		if (input == 1) {
			dimensionEnum = DimensionEnum.Band;
		} else if (input == 2) {
			dimensionEnum = DimensionEnum.Location;;
			System.out.println("||====Choose Hierarchy Level:=====||");
			System.out.println("|| Venue[1], City[2], State[3], Country[4] ||");
			System.out.println("Input: ");
			hierarchy = in.nextInt();
		} else if (input == 3) {
			dimensionEnum = DimensionEnum.Date;
			System.out.println("||====Choose Hierarchy Level:=====||");
			System.out.println("|| Day[1], Day Of the Week[2], Month[3], Quarter[4], Year[5] ||");
			System.out.println("Input: ");
			hierarchy = in.nextInt();
		} else if (input == 4) {
			dimensionEnum = DimensionEnum.AttendeeDemographic;
			System.out.println("||====Choose Hierarchy Level:=====||");
			System.out.println("|| Gender[1], Race[2], age[3] ||");
			System.out.println("Input: ");
			hierarchy = in.nextInt();
		}
		
		sam.addDimension(dimensionEnum, hierarchy);
	}
	
	public static void drillDownDimension(Scanner in) {
		sam.climbDownHierarchy(chooseDimension(in));
	}
	
	public static void drillDownHierarchy(Scanner in) {
		sam.removeDimension(chooseDimension(in));
	}
	
	public static void addSlice(Scanner in) {
		System.out.println("||====Choose Payment:=====||");
		System.out.println("||[1]Band, [2]Location, [3]Date, [4]AttendeeDemographic||");
		System.out.println("Input: ");
		int input = in.nextInt();
		DimensionEnum dimensionEnum = null;
		String slice = "";
		if (input == 1) {
			dimensionEnum = DimensionEnum.Band;
		} else if (input == 2) {
			dimensionEnum = DimensionEnum.Location;;
		} else if (input == 3) {
			dimensionEnum = DimensionEnum.Date;
		} else if (input == 4) {
			dimensionEnum = DimensionEnum.AttendeeDemographic;
		}
		
		System.out.println("||====Enter Slice:=====||");
		System.out.println("Input: ");
		slice = in.next();
		sam.addSlice(dimensionEnum, slice);
	}
	
	static void promptInput(Scanner in) {
		
		System.out.println();
		System.out.println("[1]Roll Up Dimension, [2]Drill Down Dimension, [3]Roll Up Hierarchy, [4]Drill Down Hierarchy, [5]Slice, [6]Print, [7]Quit");
		System.out.println("Input: ");
		int input = in.nextInt();
		if (input == 3) {
			rollUpHierarchy(in);
			printList();
			promptInput(in);
		} else if (input == 4) {
			drillDownHierarchy(in);
			printList();
			promptInput(in);
		} else if (input == 1) {
			rollUpDimension(in);
			printList();
			promptInput(in);
		} else if (input == 2) {
			drillDownDimension(in);
			printList();
			promptInput(in);
		} else if (input == 5) {
			addSlice(in);
			printList();
			promptInput(in);
		} else if (input == 6) {
			printList();
			promptInput(in);
		} else if (input == 7){
			System.exit(0);
		} else {
			promptInput(in);
		}
	}
	
	
	public static void testSamson() {
		System.out.println("\n\nSamson's Test");
		String hql = "select band.name, sum(a.attendance_count) from Attendance a, Band band where a.band=band.id group by band.name";
		
		//testing for band connection, also query for olap example
		
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
	}

}
