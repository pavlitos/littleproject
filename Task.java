
public class Task {
	private SubTeam subTeam;
	private EventRequest event;
	private String description;
	private double budget;
	private int id;
	
	public Task(SubTeam subTeam, EventRequest event, String description, double budget, int id) {
		this.subTeam = subTeam;
		this.event = event;
		this.description = description;
		this.budget = budget;
		this.id = id;
	}

	public SubTeam getSubTeam() {
		return subTeam;
	}

	public void setSubTeam(SubTeam subTeam) {
		this.subTeam = subTeam;
	}

	public EventRequest getEvent() {
		return event;
	}

	public void setEvent(EventRequest event) {
		this.event = event;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "Task[ SubTeam: " +subTeam+", event: "+event+", description: "+description+", budget: "+budget+", id: "+id+"]";
	}
}
