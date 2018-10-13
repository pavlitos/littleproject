
public class Task {
	private SubTeam subTeam;
	private double extraBudget;
	private EventRequest event;
	private String description;
	private String expectedPlan;
	private double budget;
	private int id;
	
	public Task(SubTeam subTeam, String description, double budget, double extraBudget, String expectedPlan, int id) {
		this.subTeam = subTeam;
		this.description = description;
		this.budget = budget;
		this.expectedPlan = expectedPlan;
		this.extraBudget = extraBudget;
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

	public double getExtraBudget() {
		return extraBudget;
	}

	public void setExtraBudget(double extraBudget) {
		this.extraBudget = extraBudget;
	}

	public String getExpectedPlan() {
		return expectedPlan;
	}

	public void setExpectedPlan(String expectedPlan) {
		this.expectedPlan = expectedPlan;
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
