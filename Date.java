import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="DATE_TABLE")
public class Date {
	@Id
	private int id;
	private int day;
	@Enumerated(EnumType.STRING)
	private DayOfTheWeek day_of_the_week;
	@Enumerated(EnumType.STRING)
	private Month month;
	@Enumerated(EnumType.STRING)
	private Quarter quarter;
	private int year;
	
	@OneToMany(mappedBy="date", targetEntity = Attendance.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Attendance> attendance;
	
	public static String getDateHierarchy(int i) {
		if (i == 1) {
			return "day";
		} else if (i == 2) {
			return "month";
		} else if (i == 3) {
			return "quarter";
		} else if (i == 4) {
			return "year";
		}
		return null;
	}
}
