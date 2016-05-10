
public class Dimension {
	public DimensionEnum dimension;
	public int hierarchy;
	
	public Dimension (DimensionEnum dimension, int hierarchy) {
		this.dimension = dimension;
		this.hierarchy = hierarchy;
		if (hierarchy > dimension.getSize()) {
			this.hierarchy = dimension.getSize();
		}
		if (hierarchy < 1) {
			this.hierarchy = 1;
		}
	}
	
	public String getHierarchy() {
		String bandHierarchy = Band.getBandHierarchy(hierarchy);
		String dateHierarchy = Date.getDateHierarchy(hierarchy);
		String locationHierarchy = Location.getLocationHierarchy(hierarchy);
		String attendeeDemoHierarchy = AttendeeDemographic.getAttendeeHierarchy(hierarchy);
		
		if (dimension.equals(DimensionEnum.Band)) {
			return bandHierarchy;
		}
		if (dimension.equals(DimensionEnum.Date)) {
			return dateHierarchy;
		}
		if (dimension.equals(DimensionEnum.Location)) {
			return locationHierarchy;
		}
		if (dimension.equals(DimensionEnum.AttendeeDemographic)) {
			return attendeeDemoHierarchy;
		}
		return null;
	}
}
