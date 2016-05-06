import java.util.List;

public interface AttendanceDAO {
	List<Attendance> findByQuery(String queryString);
}
