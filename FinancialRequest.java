public class FinancialRequest {
	private EventRequest event;
	private String reason;
	private double amount;
	private Employee manager;
	private int id;
	
	public FinancialRequest( String reason, double amount, Employee manager, int id) {
		this.reason = reason;
		this.amount = amount;
		this.manager = manager;
		this.id = id;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "Financial Request[ Reason: " + reason + ", amount: " + amount + ", department: " + manager + ". id: " + id + "]";
	}

}
