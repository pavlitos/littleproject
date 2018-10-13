import java.util.ArrayList;
import java.util.List;

public class Login {
	
	//Για να γλιτωσουμε το database χρησιμοποιουμε ArrayList οπου θα εχει τα attributes των employees
	private List<Employee> employees;
	String position[] = new String[256];
	
	public Login() {		
		employees = new ArrayList<>();

//		String position[] = new String[employees.size()];

		
		//Customer Service
		employees.add(new Employee("Sarah", "111", "Customer Service", "sarah@sep.se", 20, "female", 1));
		employees.add(new Employee("Sam", "111", "Customer Service", "sam@sep.se", 20, "male", 2));
		employees.add(new Employee("Judy", "111", "Customer Service", "judy@sep.se", 20, "female", 3));
		employees.add(new Employee("Carine", "111", "Customer Service", "carine@sep.se", 20, "female", 4));
		
		//Senior Customer Service
		employees.add(new Employee("Janet", "123", "Senior Customer Service", "janet@sep.se", 30, "female", 5));
		
		//Financial Manager
		employees.add(new Employee("Alice", "234", "Financial Manager", "alice@sep.se", 40, "female", 6));
		
		//Administration Dept. Manager
		employees.add(new Employee("Mike", "345", "Administration Dept. Manager", "mike@sep.se", 50, "male", 7));
		
		//Production Manager
		employees.add(new Employee("Jack", "456", "Production Manager", "jack@sep.se", 40, "male", 8));
		
		//Service Manager
		employees.add(new Employee("Natalie", "567", "Service Manager", "natalie@sep.se", 30, "female", 9));
		
		//HR 
		employees.add(new Employee("Simon", "678", "HR", "simon@sep.se", 35, "male", 10));
		
		//Photographer
		employees.add(new Employee("Tobias", "111", "Photographer", "tobias@sep.se", 35, "male", 11));
		
		//Audio Specialist
		employees.add(new Employee("Adam", "111", "Audio Specialist", "adam@sep.se", 35, "male", 12));
		
		//Designer
		employees.add(new Employee("Julia", "111", "Designer", "julia@sep.se", 35, "female", 13));
		
		//Decorator
		employees.add(new Employee("Magy", "111", "Decorator", "magy@sep.se", 35, "female", 14));
		
		//Technician
		employees.add(new Employee("Michael", "111", "Technician", "michael@sep.se", 35, "male", 15));
		
		//Waiter
		employees.add(new Employee("Johny", "111", "Waiter", "johny@sep.se", 35, "male", 16));
		
		//Chef
		employees.add(new Employee("Helen", "111", "Chef", "chef@sep.se", 51, "female", 17));
		
	}
	
	
	public Employee EmployeeLogin(String name, String password) {		
		for(Employee employee : employees) {
			if(employee.getName().equals(name) && employee.getPassword().equals(password)) {
				System.out.println("You have logged in succesfully!");
				return employee;
				}
		}
		return null;

	}
	
	public String[] position() {
		int i = 0;
		for(Employee employee : employees) {
			//System.out.println(employee.getPosition());
			position[i] = employee.getPosition();
			//System.out.println(position[i]);
			i++;
		}
		return position;
	}

	
	public List<Employee> getEmployee(){
		return employees;
	}
	

		
}


	
	

	
	
