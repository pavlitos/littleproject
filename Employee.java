public class Employee {
    private String name;
    private String password;
    private String position;
    private String email;
    private int age;
    private String gender;
    private final int employeeID;

    public Employee(String name, String password, String position, String email, int age, String gender, int employeeID){
        this.name = name;
        this.password = password;
        this.position = position;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getEmployeeID() {
        return employeeID;
    }
}
