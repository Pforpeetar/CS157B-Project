import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
//@Table(name = "attendance")
public class Attendance {
	@Id
	private int id;
	
	@ManyToOne
	@JoinColumn(name="location")
	private Location location;
	@ManyToOne
	@JoinColumn(name="attendee")
	private AttendeeDemographic attendee;
	@ManyToOne
	@JoinColumn(name="date")
	private Date date;
	@ManyToOne
	@JoinColumn(name="band")
	private Band band;
	@Column(name ="attendance_count")
	private int attendance_count;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getAttendance_count() {
		return attendance_count;
	}
	public void setAttendance_count(int attendance_count) {
		this.attendance_count = attendance_count;
	}
}
