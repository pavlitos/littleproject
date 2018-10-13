
public class RecruitmentRequest {
	private EventRequest event;
	 private SubTeam subTeam;
	 private String description;
	 private int id;
	 
	 
	 public RecruitmentRequest(EventRequest event, SubTeam subTeam, String description, int id) {
		 this.event = event;
		 this.subTeam = subTeam;
		 this.description = description;
		 this.id = id;
	 }


	public EventRequest getEvent() {
		return event;
	}


	public void setEvent(EventRequest event) {
		this.event = event;
	}


	public SubTeam getSubTeam() {
		return subTeam;
	}


	public void setSubTeam(SubTeam subTeam) {
		this.subTeam = subTeam;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	 
	 public String toString() {
		 return "[Event: " + event + ", SubTeam: " + subTeam + ", description: " + ", id: " + id + "]";
	 }

}
