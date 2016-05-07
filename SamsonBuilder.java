import java.util.ArrayList;
import java.util.List;


public class SamsonBuilder {
	private ArrayList<String> hierarchy;
	private ArrayList<Dimension> dimensions;
	private ArrayList<String> slices;
	
	public SamsonBuilder() {
		hierarchy = new ArrayList<String>();
		dimensions = new ArrayList<Dimension>();
		slices = new ArrayList<String>();
	}
	
	public SamsonBuilder(ArrayList<Dimension> dimensions) {
		hierarchy = new ArrayList<String>();
		this.dimensions = dimensions;
		slices = new ArrayList<String>();
	}
	
	public String getStringQuery() {
		generateHierarchy();
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
		where += generateSlice(slices);
		
		queryResult = select + from + where + group;
		//System.out.println(queryResult);
		return queryResult;
	}
	
	public void addSlice(String slice) {
		slices.add(slice);
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
				hierarchy.remove(dimensions.get(i).getHierarchy());
				dimensions.remove(dimensions.get(i));
			}
		}
	}
	
	public void climbUpHierarchy(DimensionEnum s) {
		for (Dimension d : dimensions) {
			if (d.dimension.equals(s)) {
				hierarchy.remove(d.getHierarchy());
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
				hierarchy.remove(d.getHierarchy());
				d.hierarchy--;
				if (d.hierarchy < 1) {
					d.hierarchy = 1;
				}
			}
		}
	}

	
	private void generateHierarchy() {
		for (int i = 0; i < dimensions.size(); i++) {
			String dimensionHierarchy = dimensions.get(i).getHierarchy();
			//System.out.println("dimensionHierarchy: " + dimensionHierarchy);
			if (!hierarchy.contains(dimensionHierarchy) && dimensions.get(i).dimension.equals(DimensionEnum.Band) && !dimensionExists(DimensionEnum.Band)) {
				hierarchy.add(dimensionHierarchy);
			}
			if (!hierarchy.contains(dimensionHierarchy) && dimensions.get(i).dimension.equals(DimensionEnum.Date) && !dimensionExists(DimensionEnum.Date)) {
				hierarchy.add(dimensionHierarchy);
			}
			if (!hierarchy.contains(dimensionHierarchy) && dimensions.get(i).dimension.equals(DimensionEnum.Location) && !dimensionExists(DimensionEnum.Location)) {
				hierarchy.add(dimensionHierarchy);
			}
			if (!hierarchy.contains(dimensionHierarchy) && dimensions.get(i).dimension.equals(DimensionEnum.AttendeeDemographic) && !dimensionExists(DimensionEnum.AttendeeDemographic)) {
				hierarchy.add(dimensionHierarchy);
			}
		}
	}
	
	private boolean dimensionExists(DimensionEnum dim) {
		if (dim.equals(DimensionEnum.Band)) {
			for (int i = 1; i < DimensionEnum.Band.getSize(); i++) {
				if (hierarchy.contains(Band.getBandHierarchy(i))) {
					return true;
				}
			}
		}
		if (dim.equals(DimensionEnum.Location)) {
			for (int i = 1; i < DimensionEnum.Location.getSize(); i++) {
				if (hierarchy.contains(Location.getLocationHierarchy(i))) {
					return true;
				}
			}
		}
		if (dim.equals(DimensionEnum.Date)) {
			for (int i = 1; i < DimensionEnum.Date.getSize(); i++) {
				if (hierarchy.contains(Date.getDateHierarchy(i))) {
					return true;
				}
			}
		}
		if (dim.equals(DimensionEnum.AttendeeDemographic)) {
			for (int i = 1; i < DimensionEnum.AttendeeDemographic.getSize(); i++) {
				if (hierarchy.contains(AttendeeDemographic.getAttendeeHierarchy(i))) {
					return true;
				}
			}
		}
		return false;
	}
	
	
	private String generateGroupBy() {
		String str = "";
		for (int i = 0; i < dimensions.size(); i++) {
			String d = dimensions.get(i).dimension.toString();
			if (i == dimensions.size() - 1) {
				str += d.toLowerCase() + "." + hierarchy.get(i);
			} else {
				str += d.toLowerCase() + "." + hierarchy.get(i) + ", ";
			}
		}
		return str;
	}
	
	private String generateSlice(ArrayList<String> arr) {
		String str = "";
		for (int i = 0; i < arr.size(); i++) {
				str += "AND " + arr.get(i);
		}
		return str;
	}
	
	private String generateSelect() {
		String str = "";
		for (int i = 0; i < hierarchy.size(); i++) {
			//System.out.println("\nDimSize: " + dimensions.size() + " hierarchySize: " + hierarchy.size() + "\n");
			String d = dimensions.get(i).dimension.toString();
			if (i == hierarchy.size() - 1) {
				str += d.toLowerCase() + "." + hierarchy.get(i);
			} else {
				str += d.toLowerCase() + "." + hierarchy.get(i) + ", ";
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
			if (i == 0) {
				str += "a." + d.toLowerCase() +  "=" + d.toLowerCase() + ".id ";
			} else {
				str += "AND a." + d.toLowerCase() +  "=" + d.toLowerCase() + ".id ";
			}
		}
		return str;
	}
}
