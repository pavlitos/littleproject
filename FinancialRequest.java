

public class FinancialRequest {
	private EventRequest event;
	private String reason;
	private String amount;
	private Employee manager;
	private int id;
	
	public FinancialRequest(EventRequest event, String reason, String amount, Employee manager, int id) {
		this.event = event;
		this.reason = reason;
		this.amount = amount;
		this.manager = manager;
		this.id = id;
	}

	public EventRequest getEvent() {
		return event;
	}

	public void setEvent(EventRequest event) {
		this.event = event;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
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
		return "Financial Request[ Event: " + event +", reason: " + reason + ", amount: " + amount + ", department: " + manager + ". id: " + id + "]";
	}

}
