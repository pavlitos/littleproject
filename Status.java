
public enum Status {
	Created("Created by the Customer Service"),
	ApprovedBySC("Approved by the Senior Customer Service"),
	ReviewedByFM("Reviewed by the Financial Manager"),
	ApprovedByAM("Approved by the Administration Dept. Manager"),
	Finalized("Finalized");
	
	private String text;
	
	private Status(String text) {
		this.text = text;
	}
	
	public String getText() {
		return text;
	}
	
	public String toString() {
		return text;
	}

}
