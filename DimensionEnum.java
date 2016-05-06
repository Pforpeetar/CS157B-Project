
public enum DimensionEnum {
	Band(1), Date(5), Location(4), AttendeeDemographic(3);
	
	private int size;
	private DimensionEnum(int size) {
		this.size = size;
	}
	public int getSize() {
		return size;
	}
}
