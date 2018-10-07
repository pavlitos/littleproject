import javax.swing.*;


public class MainGUI extends JFrame{


    private Employee employee;
    private LoginGUI login;
    private EventRequest event;


    JPanel jpanel= new JPanel();
    JButton btnCreateEvent = new JButton("Create event");
    JButton btnCreateClient = new JButton("Create client");
    JButton btnListEvent = new JButton("List Events");
    JButton btnListStaff = new JButton("List Staff");
    JButton btnCreateResource = new JButton("Create Resource");
    JButton btnListResource = new JButton("List Resource");
    private final JButton btnLogout = new JButton("Logout");
    JButton btnCreateStaff = new JButton("Create Staff");
    private final JButton btnListClients = new JButton("List Clients");
    private final JButton btnCreateTask = new JButton("Create Task");
    private final JButton btnListTasks = new JButton("List Tasks");

    public MainGUI(Employee currentUser){

        super("SEP MAIN MENU");
        setSize(800, 900);
        jpanel.setLayout(null);
        employee=currentUser;


        getContentPane().add(jpanel);



        btnCreateEvent.setVisible(false);
        btnCreateClient.setVisible(false);
        btnListEvent.setVisible(false);
        btnListStaff.setVisible(false);
        btnCreateStaff.setVisible(false);
        btnListClients.setVisible(false);
        btnCreateTask.setVisible(false);
        btnListTasks.setVisible(false);
        btnCreateResource.setVisible(false);
        btnListResource.setVisible(false);




        switch(employee.getPosition()){
            case "Customer Service":
                btnCreateEvent.setVisible(true);
                break;
            case "Senior Customer Service":
                btnListEvent.setVisible(true);
                btnCreateClient.setVisible(true);
                btnListClients.setVisible(true);
                break;
            case "Financial Manager":
                btnListEvent.setVisible(true);
                btnListResource.setVisible(true);
                btnListClients.setVisible(true);
                break;
            case "Administration Dept. Manager":
                btnListEvent.setVisible(true);
                btnListClients.setVisible(true);
                break;
            case "Production Manager":
                btnCreateTask.setVisible(true);
                btnCreateStaff.setVisible(true);
                btnCreateResource.setVisible(true);
                btnListTasks.setVisible(true);
                break;
            case "Service Manager":
                btnCreateTask.setVisible(true);
                btnCreateStaff.setVisible(true);
                btnCreateResource.setVisible(true);
                btnListTasks.setVisible(true);
                break;
            case "HR":
                btnListStaff.setVisible(true);
                break;


        }

        btnCreateEvent.setBounds(12, 23, 157, 25);
        jpanel.add(btnCreateEvent);


        btnCreateClient.setBounds(12, 71, 157, 25);
        jpanel.add(btnCreateClient);


        btnListEvent.setBounds(12, 122, 157, 25);
        jpanel.add(btnListEvent);
        btnLogout.setBounds(450, 314, 117, 25);

        jpanel.add(btnLogout);
        btnListClients.setBounds(12, 169, 157, 25);

        jpanel.add(btnListClients);
        btnCreateTask.setBounds(12, 213, 150, 25);

        jpanel.add(btnCreateTask);
        btnListTasks.setBounds(234, 23, 150, 25);

        jpanel.add(btnListTasks);


        btnCreateStaff.setBounds(234, 71, 150, 25);
        jpanel.add(btnCreateStaff);


        btnListStaff.setBounds(237, 122, 147, 25);
        jpanel.add(btnListStaff);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

      createEventListener();
//        createClientListener();
//        listEventsListener();
//        listClientsListener();
//        createTaskListener();
//        listTasksListener();
//        createStaffListener();


    }

    public void createEventListener(){
        btnCreateEvent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EventRequestGUI frame = new EventRequestGUI(controller);
            }
        });
    }

}
