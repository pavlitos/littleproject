import javax.swing.*;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EventRequestGUI extends JFrame {
	
	private Controller controller;
	private Status status;

    JPanel jpanel= new JPanel();
    private JTextField eventName;
    private JLabel lblName;
    private JLabel lblDate;
    private JTextField dateFrom;
    JButton SubmitButton = new JButton("Submit");
    private JTextField budget;
    private JLabel lblBudget;
    private JLabel lblNumAttendes;
    private JTextPane description;
    private JLabel lblDescription;
    private JTextField dateTo;
    private JLabel lblDateTo;
    private JList clientList;
    private JLabel statusLabel;
    private JTextField currentStatus;
    private JTextField textField;

    public EventRequestGUI(Controller controller){
        super("Request for Event Planning");
        setSize(500, 600);
        jpanel.setLayout(null);
        
        this.controller = controller;


        eventName= new JTextField();
        eventName.setBounds(190,30,114,19);
        jpanel.add(eventName);
        eventName.setColumns(10);

        lblName= new JLabel("Name");
        lblName.setBounds(47, 32, 99, 15);
        jpanel.add(lblName);

        dateFrom= new JTextField();
        dateFrom.setBounds(190, 76, 114, 19);
        jpanel.add(dateFrom);
        dateFrom.setColumns(10);

        lblDate= new JLabel("From");
        lblDate.setBounds(47, 78, 99, 15);
        jpanel.add(lblDate);

        budget = new JTextField();
        budget.setBounds(190, 155, 114, 19);
        jpanel.add(budget);
        budget.setColumns(10);

        lblBudget = new JLabel("Expected Budget");
        lblBudget.setBounds(47, 155, 120, 15);
        jpanel.add(lblBudget);

        description = new JTextPane();
        description.setBounds(190, 220, 300, 70);
        jpanel.add(description);

        lblDescription = new JLabel("Description");
        lblDescription.setBounds(47, 220, 100, 15);
        jpanel.add(lblDescription);


        lblNumAttendes= new JLabel("Number of Attendees");
        lblNumAttendes.setBounds(47,190,100,15);
        jpanel.add(lblNumAttendes);



        SubmitButton.setBounds(233, 317, 117, 25);
        jpanel.add(SubmitButton);
        
        SubmitButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String name1 = eventName.getText();
        		String from1 = dateFrom.getText();
        		String to1 = dateTo.getText();
        		double budget1 = Double.parseDouble(budget.getText());
        		String attendees1 = textField.getText();
        		String description1 = description.getText();
        		String newStatus = status.Created.getText();
        		
        		//Creating the event
        		controller.createEvRequest(name1, description1, from1, to1, attendees1, budget1, newStatus);
        		
        	}
        });

        dateTo = new JTextField();
        dateTo.setBounds(190, 114, 114, 19);
        jpanel.add(dateTo);
        dateTo.setColumns(10);

        lblDateTo = new JLabel("To");
        lblDateTo.setBounds(47, 117, 70, 15);
        jpanel.add(lblDateTo);


        getContentPane().add(jpanel);
        
        textField = new JTextField();
        textField.setColumns(10);
        textField.setBounds(190, 187, 114, 19);
        jpanel.add(textField);
        setVisible(true);
        
        

       



    }
}