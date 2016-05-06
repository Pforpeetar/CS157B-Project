import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="ATTENDEE_INFO")
public class AttendeeDemographic {
	@Id
	private int id;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Enumerated(EnumType.STRING)
	private Race race;
	private int age;
	
	@OneToMany(mappedBy="attendee", targetEntity = Attendance.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Attendance> attendance;
	
	public static String getAttendeeHierarchy(int i) {
		if (i == 1) {
			return "gender";
		} else if (i == 2) {
			return "race";
		} else if (i == 3) {
			return "age";
		}
		return null;
	}
}
