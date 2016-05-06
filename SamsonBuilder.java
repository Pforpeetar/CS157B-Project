import java.util.ArrayList;
import java.util.List;


public class SamsonBuilder {
	ArrayList<String> selects;
	ArrayList<String> froms;
	ArrayList<String> wheres;
	ArrayList<String> orders;
	
	public SamsonBuilder() {
		selects = new ArrayList<String>();
		froms = new ArrayList<String>();
		wheres = new ArrayList<String>();
		orders = new ArrayList<String>();
	}
	
	public String getStringQuery() {
		String queryResult = "";
		String select = "select ";
		String from = "\nfrom attendance, ";
		String where = "\nwhere ";
		String order = "GROUP BY ";
		//generateString(selects, select);
		
		for (int i = 0; i < selects.size(); i++) {
			if (i == selects.size() - 1) {
				select += selects.get(i);
			} else {
				select += selects.get(i) + ", ";
			}
		}
		
		select += ", sum(attendance_count) as Attendance"; 
		//generateString(froms, from);
		
		for (int i = 0; i < froms.size(); i++) {
			if (i == froms.size() - 1) {
				from += froms.get(i);
			} else {
				from += froms.get(i) + ", ";
			}
		}
		
		
		//generateWhere(wheres, where);
		for (int i = 0; i < wheres.size(); i++) {
			if (i == 0) {
				where += "attendance." + wheres.get(i) +  " = " + wheres.get(i) + ".id\n";
			} else {
				where += "AND attendance." + wheres.get(i) +  " = " + wheres.get(i) + ".id\n";
			}
		}
		
		//generateString(orders, order);
		for (int i = 0; i < orders.size(); i++) {
			if (i == orders.size() - 1) {
				order += orders.get(i);
			} else {
				order += orders.get(i) + ", ";
			}
		}
		
		queryResult = select + from + where + order + ";";
		
		return queryResult;
	}
	
	public void generateString(ArrayList<String> arr, String str) {
		for (int i = 0; i < arr.size(); i++) {
			if (i == arr.size() - 1) {
				str += arr.get(i);
			} else {
				str += arr.get(i) + ", ";
			}
		}
	}
	
	public void generateWhere(ArrayList<String> arr, String str) {
		for (int i = 0; i < arr.size(); i++) {
			if (i == 0) {
				str += "attendance." + arr.get(i) +  " = " + arr.get(i) + ".id\n";
			} else {
				str += "AND attendance." + arr.get(i) +  " = " + arr.get(i) + ".id\n";
			}
		}
	}
}
