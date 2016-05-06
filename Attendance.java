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
	
	@Column(name ="location")
	private int location;
	@Column(name ="attendee")
	private int attendee;
	@Column(name ="date")
	private int date;
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
	public int getLocation_id() {
		return location;
	}
	public void setLocation_id(int location_id) {
		this.location = location_id;
	}
	public int getAttendee_id() {
		return attendee;
	}
	public void setAttendee_id(int attendee_id) {
		this.attendee = attendee_id;
	}
	public int getDate_id() {
		return date;
	}
	public void setDate_id(int date_id) {
		this.date = date_id;
	}
	
	public int getAttendance_count() {
		return attendance_count;
	}
	public void setAttendance_count(int attendance_count) {
		this.attendance_count = attendance_count;
	}
}
