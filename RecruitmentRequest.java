

public class RecruitmentRequest {

	 private SubTeam subTeam;
	 private String description;
	 private int id;
	 
	 
	 public RecruitmentRequest( SubTeam subTeam, String description, int id) {

		 this.subTeam = subTeam;
		 this.description = description;
		 this.id = id;
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
		 return "[ SubTeam: " + subTeam + ", description: " + ", id: " + id + "]";
	 }

}
