import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MainGUI extends JFrame{

	private Controller controller;
    private Employee employee;
    private LoginGUI loginGUI;
    private EventRequest event;


    JPanel jpanel= new JPanel();
    ViewClients listClientsView;
    
    public ViewClients getListClientsView() {
    	return listClientsView;
    }
    
    public void setListClientsView() {
    	this.listClientsView = listClientsView;
    }
    
    JButton btnCreateEvent = new JButton("Create event");
    JButton btnCreateClient = new JButton("Create client");
    JButton btnListEvent = new JButton("List Events");
    JButton btnListStaff = new JButton("List Staff");
   // JButton btnCreateResource = new JButton("Create Resource");
    JButton btnListResource = new JButton("List Resource");
    private final JButton btnLogout = new JButton("Logout");
    JButton btnCreateStaff = new JButton("Request Staff");
    private final JButton btnListClients = new JButton("List Clients");
    private final JButton btnCreateTask = new JButton("Create Task");
    private final JButton btnListTasks = new JButton("List Tasks");
    JButton btnCreateFinReq = new JButton("Create Financial Req");

    public MainGUI(Employee currentUser, Controller controller){

        super("SEP MAIN MENU");
        setTitle("SEP Main Menu");
        setSize(600, 400);
        jpanel.setLayout(null);
       
        employee=currentUser;
        this.controller = controller;


        getContentPane().add(jpanel);



        btnCreateEvent.setVisible(false);
        btnCreateClient.setVisible(false);
        btnListEvent.setVisible(false);
        btnListStaff.setVisible(false);
        btnCreateStaff.setVisible(false);
        btnListClients.setVisible(false);
        btnCreateTask.setVisible(false);
        btnListTasks.setVisible(false);
        btnListResource.setVisible(false);
        btnCreateFinReq.setVisible(false);
        btnCreateStaff.setVisible(false);




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
                btnCreateFinReq.setVisible(true);
                btnListTasks.setVisible(true);
                break;
            case "Service Manager":
                btnCreateTask.setVisible(true);
                btnCreateStaff.setVisible(true);
                btnCreateFinReq.setVisible(true);
                btnListTasks.setVisible(true);
                break;
            case "HR":
                btnListStaff.setVisible(true);
                break;
            case "Photographer":
            	btnListTasks.setVisible(true);
            case "Audio Specialist":
            	btnListTasks.setVisible(true);
            case "Designer":
            	btnListTasks.setVisible(true);
            case "Decorator":
            	btnListTasks.setVisible(true);
            case "Technician":
            	btnListTasks.setVisible(true);
            case "Waiter":
            	btnListTasks.setVisible(true);
            case "Chef":
            	btnListTasks.setVisible(true);

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
        
        btnCreateTask.setBounds(12, 213, 157, 25);
        jpanel.add(btnCreateTask);

        btnListTasks.setBounds(234, 23, 150, 25);
        jpanel.add(btnListTasks);


        btnCreateStaff.setBounds(234, 71, 150, 25);
        jpanel.add(btnCreateStaff);


        btnListStaff.setBounds(234, 122, 150, 25);
        jpanel.add(btnListStaff);
        

        btnCreateFinReq.setBounds(234, 170, 150, 23);
        jpanel.add(btnCreateFinReq);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

      createEventListener();
      listEventsListener();
      createFinReqListener();

      createClientListener();
      listClientListener();
      createTaskListener();
      listTasksListener();
      createStaffListener();
      logoutListener();


    }

    public void createEventListener(){
        btnCreateEvent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EventRequestGUI frame = new EventRequestGUI(controller);
            }
        });
    }
    
    
    public void createClientListener() {
    	btnCreateClient.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ClientGUI frame = new ClientGUI(controller);
				
			}
		});
    }
    
    public void listClientListener() {
    	btnListClients.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				listClientsView = new ViewClients(controller);
				
			}
		});
    	
    }
    
    
    public void createFinReqListener() {
    	btnCreateFinReq.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FinancialRequestGUI frame = new FinancialRequestGUI(controller, employee);
				
			}
		});
    }


    public void createTaskListener() {
    	btnCreateTask.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TaskGUI frame = new TaskGUI(controller, employee);

			}
		});
    }
    
    


    public void createStaffListener() {
    	btnCreateStaff.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RecruitmentRequestGUI frame= new RecruitmentRequestGUI(controller, employee);

			}
		});
    }


    public void  listEventsListener() {
        btnListEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewEventsGUI frame= new ViewEventsGUI(controller, employee);

          }
        });

    }
    
    public void listTasksListener() {
    	btnListTasks.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ViewTasksGUI frame = new ViewTasksGUI(controller, employee);
				
			}
		});
    }
    
    public void logoutListener(){
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                employee = null;
                dispose();
            }
        });
    }
    
    
}
