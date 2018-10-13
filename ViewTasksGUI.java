import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class ViewTasksGUI extends JFrame {
	
	private Controller controller;
	
	JPanel panel = new JPanel();
    private JTextField originalBudgetField;
    private JTextPane descriptionField;
    private JLabel lblDescription;
    private JList tasksList;
    
    private Employee employee;

    
    public ViewTasksGUI(Controller controller, Employee currentEmployee) {
    	super("SEP View Tasks");
    	this.controller = controller;
    	this.employee = currentEmployee;
    	List<Task> taskToDisplay = listTasks(controller, employee);
        Task[] tasks = taskToDisplay.toArray(new Task[taskToDisplay.size()]);
        
        tasksList = new JList(tasks);
        panel.add(tasksList);
        tasksList.setBounds(356, 59, 228, 167);
        JScrollPane pane = new JScrollPane();

        getContentPane().add(pane, BorderLayout.NORTH);
        

        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addListMouseListener(tasksList);

        
        setVisible(true);
    }
    
    private List<Task> listTasks(Controller controller, Employee employee){
    	setSize(800, 600);
    	panel.setLayout(null);
    	getContentPane().add(panel);
    	
    	originalBudgetField = new JTextField();
        originalBudgetField.setBounds(120, 9, 119, 19);
        panel.add(originalBudgetField);
        originalBudgetField.setColumns(10);
    	
        JLabel lblOriginalBudget = new JLabel("Budget");
        lblOriginalBudget.setBounds(12, 12, 117, 15);
        panel.add(lblOriginalBudget);
        
        
        descriptionField = new JTextPane();
        descriptionField.setBounds(120, 86, 119, 88);
        panel.add(descriptionField);

        lblDescription = new JLabel("Description");
        lblDescription.setBounds(12, 84, 134, 15);
        panel.add(lblDescription);
        
        JLabel tasksLabel = new JLabel("Tasks");
        tasksLabel.setBounds(276, 60, 70, 15);
        panel.add(tasksLabel);

        Login login = new Login();
        String position[];
        position = login.position();
        
        List<Task> allTasks = controller.getTasks();
        List<Task> taskToDisplay = new ArrayList<>();
        


               
        for (Task t : allTasks) {
            if ((employee.getPosition() == position[7] || employee.getPosition() == position[8]) && t.getSubTeam().getManager() == employee.getPosition()) {
                taskToDisplay.add(t);
            } 
            else {
            	if(t.getSubTeam().getStaff().contains(employee))
            		taskToDisplay.add(t);
            }

        }
        return taskToDisplay;
    }
    
    public void addListMouseListener(JList list) {
        list.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
            	Login login1 = new Login();
            	String position[];
            	position = login1.position();
                JList list = (JList) evt.getSource();
                int index = list.locationToIndex(evt.getPoint());
                Task task = (Task) list.getModel().getElementAt(index);
                originalBudgetField.setText(String.valueOf(task.getBudget()));
                descriptionField.setText(task.getDescription());



            }

        });
    }
    
    
    
}
    
            


