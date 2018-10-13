import java.awt.Event;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class Controller {
	private Login login;
	
	private int clientC;
	private int eventC;
	private int taskC;
	private int subTeamC;
	private int budgetC;
	
	private SubTeam audioSpecialists;
	private SubTeam photographers;
	private SubTeam designers;
	private SubTeam decorators;
	private SubTeam technicians;
	private SubTeam chefs;
	private SubTeam waiters;
	
	private List<Client> clients;
	private List<EventRequest> events;
	private List<Task> tasks;
	private List<RecruitmentRequest> recruitmentRequest;
	private List<FinancialRequest> financialRequest;

	
	// Τhe constructor creates the arraylists of the clients, events, tasks, recruitmentRequest and financialRequest. 
	public Controller() {
		calling();
	}
	
	private void calling(){
		clients = new ArrayList<Client>();
		events =  new ArrayList<EventRequest>();
		tasks = new ArrayList<Task>();
		recruitmentRequest = new ArrayList<RecruitmentRequest>();
		financialRequest = new ArrayList<FinancialRequest>();
		
		createTeams();
	}
	
	//Creates the event and adds it to the list
	public void createEvRequest(String name, String type, String from, String to, String attendees, double budget, String status) {
		EventRequest event = new EventRequest( name,  type,  from,  to,  attendees,  budget, status,  eventC++);
		events.add(event);
	}
	
	public List<EventRequest> getEvents(){
		return events;
	}

	public void deleteEvRequest(EventRequest event) {
		for(Iterator<EventRequest> evIter = events.listIterator() ; evIter.hasNext();) {
			EventRequest ev = evIter.next();
			if(ev.getID() == event.getID()) {
				evIter.remove();
			}
		}
	}
	
	//creates the financial request and adds it to the list
	public void createFinRequest(EventRequest event, String reason, String amount, Employee manager) {
		FinancialRequest finRequest = new FinancialRequest(event, reason, amount, manager, budgetC++);
		financialRequest.add(finRequest);
	}
	public List<FinancialRequest> getFinRequest(){
		return financialRequest;
	}
	

	//creates the client and adds him to the list
	public void createClient(String name, int age, String mail) {
		Client client = new Client(name, age, mail, clientC++);
		clients.add(client);
	}
	public List<Client> getClients(){
		return clients;
	}
	
	
	
	//creates the employee and adds him to the list
	public Employee login(String username, String password) {
		return login.EmployeeLogin(username, password);
	}
	
	//creates a task and adds it to the list
	public void createTask(SubTeam team, Employee currentEmployee, String description, double extraBudget, String expectedPlan, double budget) {
		Task task = new Task(team, description, budget, extraBudget, expectedPlan, taskC++);
		tasks.add(task);
	}
	public List<Task> getTasks(){
		return tasks;
	}

	
	public void createRecRequest(EventRequest event, SubTeam subteam, String description) {
		RecruitmentRequest recRequest = new RecruitmentRequest(event, subteam, description, budgetC++);
		recruitmentRequest.add(recRequest);
	}
	public List<RecruitmentRequest> getRecRequest(){
		return recruitmentRequest;
	}
	
	
	public List<SubTeam> getProdTeam(){
		List<SubTeam> prodTeam = new ArrayList<>();
		prodTeam.add(audioSpecialists);
		prodTeam.add(photographers);
		prodTeam.add(designers);
		prodTeam.add(decorators);
		prodTeam.add(technicians);
		
		return prodTeam;
	}
	
	public List<SubTeam> getServTeam(){
		List<SubTeam> servTeam = new ArrayList<>();
		servTeam.add(chefs);
		servTeam.add(waiters);
		
		return servTeam;
	}
	
		
	
	
	//subteam(String manager, String position)
	public void createTeams() {
		String position[];
		Login login1 = new Login();
		position = login1.position();
		audioSpecialists = new SubTeam(position[7], "Audio Specialist");
		photographers = new SubTeam(position[7], "Photographer");
		designers = new SubTeam(position[7], "Designer");
		decorators = new SubTeam(position[7], "Decorator");
		technicians = new SubTeam(position[7], "Technician");
		
		chefs = new SubTeam(position[8], "Chef");
		waiters = new SubTeam(position[8], "Waiter");
		
		for(Employee employee : login1.getEmployee()) {
			switch(employee.getPosition()) {
				case "Audio Specialist":
					audioSpecialists.addStaff(employee);
					break;
				case "Photographer":
					photographers.addStaff(employee);
					break;
				case "Designer":
					designers.addStaff(employee);
					break;
				case "Decorator":
					decorators.addStaff(employee);
					break;
				case "Technician":
					technicians.addStaff(employee);
					break;
				case "Chef":
					chefs.addStaff(employee);
					break;
				case "Waiter":
					waiters.addStaff(employee);
			}
		}
		
	}
	
	public void showStatus(int currentEvID, Employee employee) {
		for(EventRequest event : events) {
			switch(employee.getPosition()) {
			case "Financial Manager":
				if(event.getStatus() != Status.ApprovedBySC.getText()) {
					events.clear();
				}
				else
					events.add(event);
				break;
			case "Administration Dept. Manager":
				if(event.getStatus() == Status.ReviewedByFM.getText()) {
					event.setStatus(Status.ApprovedByAM.getText());
				}
				break;
			}
		}
	}
	
	public void changeStatus(int currentEventID, Employee employee) {
		EventRequest event = events.get(currentEventID);
		Status newStatus;
		switch(employee.getPosition()) {
		case "Senior Customer Service":
			if(event.getStatus() == Status.Created.getText()) {
				newStatus = Status.ApprovedBySC;
			}
			else {
				newStatus = Status.Finalized;
			}
			break;
		case "Financial Manager":
			newStatus = Status.ReviewedByFM;
			break;
		case "Administration Dept. Manager":
			newStatus = Status.ApprovedByAM;
			break;
		default:
			newStatus = null;
		}
		
		event.setStatus(newStatus.toString());
	
	}
	
	


}