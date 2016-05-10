import java.util.ArrayList;
import java.util.List;


public class SamsonBuilder {
	private ArrayList<Dimension> dimensions;
	private ArrayList<Slice> slices;
	
	public SamsonBuilder() {
		dimensions = new ArrayList<Dimension>();
		slices = new ArrayList<Slice>();
	}
	
	public SamsonBuilder(ArrayList<Dimension> dimensions) {
		this.dimensions = dimensions;
		slices = new ArrayList<Slice>();
	}
	
	public String getStringQuery() {
		String queryResult = "";
		String select = "select ";
		String from = "from Attendance a, ";
		String where = "where ";
		String group = "group by ";

		select += generateSelect();
		
		select += ", sum(a.attendance_count) "; 
		from += generateFrom();
		group += generateGroupBy();
		where += generateWhere();
		where += generateSlice();
		queryResult = select + from + where + group;
		//System.out.println(queryResult);
		return queryResult;
	}
	
	public void addSlice(DimensionEnum dimension, String slice) {
		slices.add(new Slice(dimension, slice));
	}
	
	public void addDimension(DimensionEnum dim, int i) {
		removeDimension(dim);
		dimensions.add(new Dimension(dim, i));
	}
	
	public void removeDimension(DimensionEnum dim) {
//		for (Dimension d : dimensions) {
//			if (d.dimension.equals(dim)) {
//				dimensions.remove(d);
//			}
//		}
		for (int i = 0; i < dimensions.size(); i++) {
			if (dimensions.get(i).dimension.equals(dim)) {
				dimensions.remove(dimensions.get(i));
			}
		}
	}
	
	public void climbUpHierarchy(DimensionEnum s) {
		for (Dimension d : dimensions) {
			if (d.dimension.equals(s)) {
				//System.out.println("\nDimension: " + d.dimension.toString() + " S: " + s + "\n");
				d.hierarchy++;
				if (d.hierarchy > d.dimension.getSize()) {
					d.hierarchy = d.dimension.getSize();
				}
			}
		}
	}
	
	public void climbDownHierarchy(DimensionEnum s) {
		for (Dimension d : dimensions) {
			if (d.dimension.equals(s)) {
				d.hierarchy--;
				if (d.hierarchy < 1) {
					d.hierarchy = 1;
				}
			}
		}
	}

	
	private String generateHierarchy(DimensionEnum d, int hierarchy) {
		if (d.equals(DimensionEnum.AttendeeDemographic)) {
			return AttendeeDemographic.getAttendeeHierarchy(hierarchy);
		}
		if (d.equals(DimensionEnum.Band)) {
			return Band.getBandHierarchy(hierarchy);
		}
		if (d.equals(DimensionEnum.Date)) {
			return Date.getDateHierarchy(hierarchy);
		}
		if (d.equals(DimensionEnum.Location)) {
			return Location.getLocationHierarchy(hierarchy);
		}
		return null;
	}
	
//	private boolean dimensionExists(DimensionEnum dim) {
//		if (dim.equals(DimensionEnum.Band)) {
//			for (int i = 1; i < DimensionEnum.Band.getSize(); i++) {
//				if (hierarchy.contains(Band.getBandHierarchy(i))) {
//					return true;
//				}
//			}
//		}
//		if (dim.equals(DimensionEnum.Location)) {
//			for (int i = 1; i < DimensionEnum.Location.getSize(); i++) {
//				if (hierarchy.contains(Location.getLocationHierarchy(i))) {
//					return true;
//				}
//			}
//		}
//		if (dim.equals(DimensionEnum.Date)) {
//			for (int i = 1; i < DimensionEnum.Date.getSize(); i++) {
//				if (hierarchy.contains(Date.getDateHierarchy(i))) {
//					return true;
//				}
//			}
//		}
//		if (dim.equals(DimensionEnum.AttendeeDemographic)) {
//			for (int i = 1; i < DimensionEnum.AttendeeDemographic.getSize(); i++) {
//				if (hierarchy.contains(AttendeeDemographic.getAttendeeHierarchy(i))) {
//					return true;
//				}
//			}
//		}
//		return false;
//	}
//	
	
	private String generateGroupBy() {
		String str = "";
		for (int i = 0; i < dimensions.size(); i++) {
			String d = dimensions.get(i).dimension.toString();
			if (i == dimensions.size() - 1) {
				str += d.toLowerCase() + "." + generateHierarchy(dimensions.get(i).dimension, dimensions.get(i).hierarchy);
			} else {
				str += d.toLowerCase() + "." + generateHierarchy(dimensions.get(i).dimension, dimensions.get(i).hierarchy) + ", ";
			}
		}
		return str;
	}
	
	private String generateSlice() {
		String str = "";
		
		for (int i = 0; i < slices.size(); i++) {
			for (Dimension d : dimensions) {
				if (slices.get(i).dimension.equals(d.dimension)) {
					str += " AND " + d.dimension.toString().toLowerCase() + "." + d.getHierarchy() + "='" + slices.get(i).slice + "' ";
					System.out.println("\nStr: " + str);
				}
			}
		}
		return str;
	}
	
	private String generateSelect() {
		String str = "";
		for (int i = 0; i < dimensions.size(); i++) {
			//System.out.println("\nDimSize: " + dimensions.size() + " hierarchySize: " + hierarchy.size() + "\n");
			String d = dimensions.get(i).dimension.toString();
			if (i == dimensions.size() - 1) {
				str += d.toLowerCase() + "." + generateHierarchy(dimensions.get(i).dimension, dimensions.get(i).hierarchy);
			} else {
				str += d.toLowerCase() + "." + generateHierarchy(dimensions.get(i).dimension, dimensions.get(i).hierarchy) + ", ";
			}
		}
		return str;
	}
	
	private String generateFrom() {
		String str = "";
		for (int i = 0; i < dimensions.size(); i++) {
			String d = dimensions.get(i).dimension.toString();
			if (i == dimensions.size() - 1) {
				str += dimensions.get(i).dimension + " " + d.toLowerCase()  + " ";
			} else {
				str += dimensions.get(i).dimension + " " + d.toLowerCase()  + ", ";
			}
		}
		return str;
	}
	
	private String generateWhere() {
		String str = "";
		for (int i = 0; i < dimensions.size(); i++) {
			String d = dimensions.get(i).dimension.toString();
			String help = "";
			if (d.toLowerCase().equals("attendeedemographic")) {
				help = "attendee";
			} else {
				help = d;
			}
			if (i == 0) {
				
				
				str += "a." + help.toLowerCase() +  "=" + d.toLowerCase() + ".id ";
			} else {
				str += "AND a." + help.toLowerCase() +  "=" + d.toLowerCase() + ".id ";
			}
		}
		return str;
	}
}
