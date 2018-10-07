import javax.swing.*;

public class EventRequestGUI extends JFrame {

    JPanel jpanel= new JPanel();
    private JTextField eventName;
    private JLabel lblName;
    private JLabel lblDate;
    private JTextField dateFrom;
    JButton SubmitButton = new JButton("Submit");
    private JTextField budget;
    private JLabel lblBudget;
    private JTextField Attendees;
    private JLabel lblNumAttendes;
    private JTextPane description;
    private JLabel lblDescription;
    private JTextField dateTo;
    private JLabel lblDateTo;
    private JList clientList;
    private JLabel statusLabel;
    private JTextField currentStatus;
    // private Status status;


    public EventRequestGUI(){
        super("Request for Event Planning");
        setSize(500, 600);
        jpanel.setLayout(null);


        eventName= new JTextField();
        eventName.setBounds(190,30,114,19);
        jpanel.add(eventName);
        eventName.setColumns(10);

        lblName= new JLabel("Event type");
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
        budget.setBounds(190, 145, 114, 19);
        jpanel.add(budget);
        budget.setColumns(10);

        lblBudget = new JLabel("Expected Budget");
        lblBudget.setBounds(47, 147, 120, 15);
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

        Attendees= new JTextField();
        Attendees.setBounds(190,190,100,15);
        jpanel.add(Attendees);


        SubmitButton.setBounds(233, 317, 117, 25);
        jpanel.add(SubmitButton);

        dateTo = new JTextField();
        dateTo.setBounds(190, 114, 114, 19);
        jpanel.add(dateTo);
        dateTo.setColumns(10);

        lblDateTo = new JLabel("To");
        lblDateTo.setBounds(47, 116, 70, 15);
        jpanel.add(lblDateTo);


        getContentPane().add(jpanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Setting the frame visibility to true
        setVisible(true);






    }
}
