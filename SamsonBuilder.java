import java.util.ArrayList;
import java.util.List;


public class SamsonBuilder {
	ArrayList<String> selects;
	ArrayList<String> froms;
	ArrayList<String> wheres;
	ArrayList<String> slices;
	
	public SamsonBuilder() {
		selects = new ArrayList<String>();
		froms = new ArrayList<String>();
		wheres = new ArrayList<String>();
		slices = new ArrayList<String>();
	}
	
	public String getStringQuery() {
		String queryResult = "";
		String select = "select ";
		String from = "\nfrom attendance, ";
		String where = "\nwhere ";
		String group = "GROUP BY ";
		select += generateString(selects);
		
		select += ", sum(attendance_count) as Attendance"; 
		from += generateString(froms);
		
		where += generateWhere(wheres);

		for (int i = 0; i < froms.size(); i++) {
			if (i == froms.size() - 1) {
				group += froms.get(i) + "." + selects.get(i);
			} else {
				group += froms.get(i) + "." + selects.get(i) + ", ";
			}
		}
		
		where += sliceAndDice(slices);
		
		queryResult = select + from + where + group + ";";
		
		return queryResult;
	}
	
	public String sliceAndDice(ArrayList<String> arr) {
		String str = "";
		for (int i = 0; i < arr.size(); i++) {
				str += "AND " + arr.get(i) +  "\n";
		}
		return str;
	}
	
	public String generateString(ArrayList<String> arr) {
		String str = "";
		for (int i = 0; i < arr.size(); i++) {
			if (i == arr.size() - 1) {
				str += arr.get(i);
			} else {
				str += arr.get(i) + ", ";
			}
		}
		return str;
	}
	
	public String generateWhere(ArrayList<String> arr) {
		String str = "";
		for (int i = 0; i < arr.size(); i++) {
			if (i == 0) {
				str += "attendance." + arr.get(i) +  " = " + arr.get(i) + ".id\n";
			} else {
				str += "AND attendance." + arr.get(i) +  " = " + arr.get(i) + ".id\n";
			}
		}
		return str;
	}
}
