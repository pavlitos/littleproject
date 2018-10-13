public class EventRequest {
    private String name;
    private String type;
    private String from;
    private String to;
    private String attendees;
    private double budget;
    private String status;
    private final int ID;


    public EventRequest(String name, String type, String from,String to, String attendees, double budget, String status, int ID){
        this.name = name;
        this.type = type;
        this.from = from;
        this.to = to;
        this.attendees = attendees;
        this.budget = budget;
        this.status = Status.Created.getText();
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getAttendees() {
        return attendees;
    }

    public void setAttendees(String attendees) {
        this.attendees = attendees;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
    

    public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getID() {
        return ID;
    }
}