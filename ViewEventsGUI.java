import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;



public class ViewEventsGUI extends JFrame{
	
	private Controller controller;
	
	private EventRequest event;


    JPanel panel = new JPanel();

    private JTextField eventName;
    private JTextField dateFrom;
    JButton acceptButton = new JButton("Accept");
    JButton rejectButton = new JButton("Reject");
    
    private JLabel lblDate;
    private JTextField budget;
    private JLabel lblBudget;
    private JTextPane description;
    private JLabel lblDescription;
    private JTextField dateTo;
    private JLabel lblDateTo;
    private JList eventList;
    private int currentEventId;
    private Employee currentEmployee;
    private String view;
    
    
    public ViewEventsGUI(Controller controller, Employee currentEmployee) {
        super("SEP List updater page");
        setSize(800, 600);
        panel.setLayout(null);
        
        this.controller = controller;
        this.currentEmployee = currentEmployee;
        getContentPane().add(panel);
        
        
        eventName = new JTextField();
        eventName.setBounds(164, 10, 114, 19);
        panel.add(eventName);
        eventName.setColumns(10);
        
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(47, 12, 70, 15);
        panel.add(lblName);
        
        
        dateFrom = new JTextField();
        dateFrom.setBounds(164, 41, 114, 19);
        panel.add(dateFrom);
        dateFrom.setColumns(10);
        
        
        lblDate = new JLabel("From");
        lblDate.setBounds(47, 39, 99, 15);
        panel.add(lblDate);
        
        
        budget = new JTextField();
        budget.setBounds(164, 91, 114, 19);
        panel.add(budget);
        budget.setColumns(10);
        
        
        lblBudget = new JLabel("Budget");
        lblBudget.setBounds(47, 93, 70, 15);
        panel.add(lblBudget);
        
        
        description = new JTextPane();
        description.setBounds(164, 122, 119, 88);
        panel.add(description);
        
        
        lblDescription = new JLabel("Description");
        lblDescription.setBounds(47, 120, 99, 15);
        panel.add(lblDescription);
        
        JLabel eventsLabel = new JLabel("Events List");
        eventsLabel.setBounds(328, 32, 70, 15);
        panel.add(eventsLabel);
        
        acceptButton.setBounds(61, 314, 117, 25);
        panel.add(acceptButton);
        
        dateTo = new JTextField();
        dateTo.setBounds(164, 64, 114, 19);
        panel.add(dateTo);
        dateTo.setColumns(10);
        
        lblDateTo = new JLabel("To");
        lblDateTo.setBounds(47, 66, 70, 15);
        panel.add(lblDateTo);
        
        
        List<EventRequest> event = controller.getEvents();
        EventRequest[] events = event.toArray(new EventRequest[event.size()]);
        
        eventList = new JList(events);
        panel.add(eventList);
        eventList.setBounds(356, 59, 228, 167);
        JScrollPane pane = new JScrollPane();
        
        getContentPane().add(pane, BorderLayout.NORTH);
        
        rejectButton.setBounds(413, 314, 117, 25);
        panel.add(rejectButton);
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        acceptButton.setVisible(false);
        rejectButton.setVisible(false);
        
        acceptEventListener();
        rejectEventAction();
        addListMouseListener(eventList);
        
        
        setVisible(true);
    }

    
    public void addListMouseListener(JList list) {

        list.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent evt) {
            	Login login = new Login();
            	String position[] = login.position();
                JList list = (JList) evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                EventRequest event = (EventRequest) list.getModel().getElementAt(index);
                eventName.setText(event.getName());
                dateFrom.setText(event.getFrom());
                dateTo.setText(event.getTo());
                budget.setText(String.valueOf((event.getBudget())));
                description.setText(event.getType());
//              currentStatus.setText(event.getStatus());
                currentEventId = event.getID();
                
                if(currentEmployee.getPosition() == position[4]  && event.getStatus() == Status.Created.getText()) {
                    acceptButton.setVisible(true);
                    rejectButton.setVisible(true);
                }
                
                else if(currentEmployee.getPosition() == position[6] && event.getStatus() == Status.ReviewedByFM.getText()) {
                	acceptButton.setVisible(true);
                    rejectButton.setVisible(true);
                }
            }
        });

    }
    
    public void acceptEventListener() {
        acceptButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controller.changeStatus(currentEventId, currentEmployee);
            }


          });
      }
    
    public void rejectEventAction() {
        rejectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EventRequest event = (EventRequest) eventList.getSelectedValue();
                controller.deleteEvRequest(event);
            }
        });
    
   }
    

   
}