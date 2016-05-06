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
		for (Dimension d : dimensions) {
			if (d.dimension.equals(dim)) {
				dimensions.remove(d);
			}
		}
		dimensions.add(new Dimension(dim, i));
	}
	
	public void removeDimension(DimensionEnum dim) {
		for (Dimension d : dimensions) {
			if (d.dimension.equals(dim)) {
				dimensions.remove(d);
			}
		}
	}
	
	public void climbUpHierarchy(DimensionEnum s) {
		for (Dimension d : dimensions) {
			if (d.dimension.equals(s)) {
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

	
	private void generateHierarchy() {
		for (int i = 0; i < dimensions.size(); i++) {
			String bandHierarchy = Band.getBandHierarchy(dimensions.get(i).hierarchy);
			String dateHierarchy = Date.getDateHierarchy(dimensions.get(i).hierarchy);
			String locationHierarchy = Location.getLocationHierarchy(dimensions.get(i).hierarchy);
			String attendeeDemoHierarchy = AttendeeDemographic.getAttendeeHierarchy(dimensions.get(i).hierarchy);
			
			if (!hierarchy.contains(bandHierarchy) && dimensions.get(i).dimension.equals(DimensionEnum.Band)) {
				hierarchy.add(bandHierarchy);
			}
			if (!hierarchy.contains(dateHierarchy) && dimensions.get(i).dimension.equals(DimensionEnum.Date)) {
				hierarchy.add(dateHierarchy);
			}
			if (!hierarchy.contains(locationHierarchy) && dimensions.get(i).dimension.equals(DimensionEnum.Location)) {
				hierarchy.add(locationHierarchy);
			}
			if (!hierarchy.contains(attendeeDemoHierarchy) && dimensions.get(i).dimension.equals(DimensionEnum.AttendeeDemographic)) {
				hierarchy.add(attendeeDemoHierarchy);
			}
		}
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
			String d = dimensions.get(i).dimension.toString();
			if (i == dimensions.size() - 1) {
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
