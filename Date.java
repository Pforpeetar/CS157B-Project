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
}
