
public enum Position {
	CustomerService("Customer Service"),
	SeniorCustomerService("Senior Customer Service"),
	FinancialManager("Financial Manager"),
	AdministrationManager("Administration Dept. Manager"),
	ServiceManager("Service Manager"),
	ProductionManager("Production Manager"),
	HR("HR"),
	AudioSpecialist("Audio Specialist"),
	Photographer("Photographer"),
	Designer("Designer"),
	Decorator("Decorator"),
	Technician("Techinician"),
	Chef("Chef"),
	Waiter("Waiter");
	
	private String text;
	
	private Position(String text) {
		this.text = text;
		
	}

}
