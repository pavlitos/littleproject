import java.util.ArrayList;

public class Login {
	
	//Για να γλιτωσουμε το database χρησιμοποιουμε ArrayList οπου θα εχει τα attributes των employees
	private ArrayList<Employee> employees;
	
	public Login() {
		
		employees = new ArrayList<>();
		
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
		

		}
	
	public Employee EmployeeLogin(String name, String password) {
		
		for(Employee employee : employees) {
			if(employee.getName().equals(name) && employee.getPassword().equals(password))
				return employee;
			}
	
		return null;

	}
}