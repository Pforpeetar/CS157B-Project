import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="LOCATION")
public class Location {
	@Id
	private int id;
	private String venue;
	private String city;
	private String state;
	private String country;
	
	@OneToMany(mappedBy="location", targetEntity = Attendance.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Attendance> attendance;
}
