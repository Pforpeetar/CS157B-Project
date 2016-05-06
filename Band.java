import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="BAND")
public class Band {
	@Id
	private int id;
	private String name;
	
	@OneToMany(mappedBy="band", targetEntity = Attendance.class, fetch=FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval=true)
	private List<Attendance> attendance;
	Band(){
		
	}
	Band(String name){
		this.name =name;
	}
	public String toString(){
		return id + " " + name;
	}
}
