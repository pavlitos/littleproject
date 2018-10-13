//import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;


public class TaskGUI extends JFrame{

    private Controller controller;
    private Employee currentUser;

    JPanel panel= new JPanel();
    JButton createButton= new JButton("Create");
    private JTextField InitiateBudget;
    private JLabel lblInitiateBudget;
    private JLabel lblTeam;
    private JTextField descriptionField;
    private JLabel lblDescription;
    private JList teamList;
    private JTextField additionalBudget;


    public TaskGUI(Controller controller,Employee currentUser)
        {
            setTitle("SEP Create Tasks");
            panel.setLayout(null);
            
            getContentPane().add(panel);
            setSize(800, 900);

            this.controller=controller;
            this.currentUser=currentUser;

            InitiateBudget = new JTextField();
            InitiateBudget.setBounds(164, 10, 114, 19);
            panel.add(InitiateBudget);
            InitiateBudget.setColumns(10);

            JLabel lblInitiateBudget = new JLabel("Budget");
            lblInitiateBudget.setBounds(12, 12, 114, 19);
            panel.add(lblInitiateBudget);

            createButton.setBounds(233, 313, 117, 25);
            panel.add(createButton);

            descriptionField = new JTextField();
            descriptionField.setBounds(135, 64, 163, 86);
            panel.add(descriptionField);
            descriptionField.setColumns(10);

            lblDescription = new JLabel("Description");
            lblDescription.setBounds(12, 66, 105, 15);
            panel.add(lblDescription);

            lblTeam = new JLabel("Team");
    		lblTeam.setBounds(12, 159, 70, 15);
    		panel.add(lblTeam);
            
    		String position[];
    		Login login=new Login();
    		
    		position = login.position();
    		
            List<SubTeam> subteam = new ArrayList<>();


            if(currentUser.getPosition() == position[7] ){
                subteam = controller.getProdTeam();
            }
            if(currentUser.getPosition() == position[8]){
                subteam = controller.getServTeam();
            }
            
            SubTeam[] teams = subteam.toArray(new SubTeam[subteam.size()]);

            teamList= new JList(teams);
            teamList.setBounds(90,170,220,80);
            panel.add(teamList);
            
            JLabel lblAdditionalBudget = new JLabel("Additional Budget");
            lblAdditionalBudget.setBounds(322, 13, 139, 14);
            panel.add(lblAdditionalBudget);
            
            additionalBudget = new JTextField();
            additionalBudget.setBounds(471, 10, 128, 20);
            panel.add(additionalBudget);
            additionalBudget.setColumns(10);

            createTasks();
            setVisible(true);



        }
        public void createTasks(){
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double originalBudget = Double.valueOf(InitiateBudget.getText());
                double additionalBudget1 = Double.valueOf(additionalBudget.getText());
                String description = descriptionField.getText();
                SubTeam team = (SubTeam) teamList.getSelectedValue();
                controller.createTask(team,currentUser,description,additionalBudget1, "", originalBudget);
            }
        });
        }
}
