import java.util.List;
import java.util.ArrayList;

public class SubTeam {
	private List<Employee> staff;
	private String manager;
	private String name;
	
	public SubTeam(String manager, String name) {
		staff = new ArrayList<>();
		this.manager = manager;
		this.setName(name);
	}
	
	public void addStaff(Employee employee) {
		staff.add(employee);
	}

	public List<Employee> getStaff() {
		return staff;
	}

	public void setStaff(List<Employee> staff) {
		this.staff = staff;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "name: " + name;
	}
	
}
