
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
}
