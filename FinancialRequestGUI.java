import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FinancialRequestGUI extends JFrame {



    private Employee employee;
    private Controller controller;

    JPanel jpanel=new JPanel();
    JButton createButton = new JButton("Create");
    JTextField descriptionField;
    private JLabel lblDescription;
    private JList eventList;
    private JLabel lblFinance;
    private JTextField financeField;



    public FinancialRequestGUI(Controller controller, Employee currentuser) {
        super("SEP Financial Request");
        setSize(800, 900);
        jpanel.setLayout(null);
        this.employee=currentuser;
        this.controller = controller;

        getContentPane().add(jpanel);

        JLabel eventsLabel = new JLabel("Events");
        eventsLabel.setBounds(328, 12, 70, 15);
        jpanel.add(eventsLabel);


        createButton.setBounds(233, 313, 117, 25);
        jpanel.add(createButton);

        descriptionField=new JTextField();
        descriptionField.setBounds(135,29,163,86);
        jpanel.add(descriptionField);
        descriptionField.setColumns(10);

        lblDescription = new JLabel("Description");
        lblDescription.setBounds(12, 27, 105, 15);
        jpanel.add(lblDescription);

        //List<EventRequest> event= controller.getEvents();
        //EventRequest[] events  = event.toArray(new EventRequest[event.size()]);

        //************* does not work yet  **************
//        eventList = new JList(events);
//        jpanel.add(eventList);
//        eventList.setBounds(338, 42, 228, 93);
//        JScrollPane pane = new JScrollPane();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lblFinance = new JLabel("Financial");
        lblFinance.setBounds(12, 159, 105, 15);
        jpanel.add(lblFinance);

        financeField = new JTextField();
        financeField.setColumns(10);
        financeField.setBounds(135, 157, 163, 86);
        jpanel.add(financeField);


        createResourceListener();
        setVisible(true);


    }
  public void createResourceListener(){
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String description=descriptionField.getText();
                String finance= financeField.getText();
                EventRequest event = (EventRequest) eventList.getSelectedValue();
                controller.createFinRequest(event, description, finance, employee);
            }
        });
  }


}
