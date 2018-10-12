import javax.naming.ldap.Control;
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
    private JLabel eventsLabel;
    private JTextField descriptionField;
    private JLabel lblDescription;
private JList eventList;
    private JList teamList;


    public TaskGUI(Controller controller,Employee currentUser)
        {
            super("create Tasks");
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

            JLabel eventsLabel = new JLabel("List of Events");
            eventsLabel.setBounds(328, 12, 70, 15);
            panel.add(eventsLabel);

            createButton.setBounds(233, 313, 117, 25);
            panel.add(createButton);

            descriptionField = new JTextField();
            descriptionField.setBounds(135, 64, 163, 86);
            panel.add(descriptionField);
            descriptionField.setColumns(10);

            lblDescription = new JLabel("Description");
            lblDescription.setBounds(12, 66, 105, 15);
            panel.add(lblDescription);

            List<SubTeam> subteam= new ArrayList<>();
            Login login=new Login();


            if(currentUser.getPosition() ==login.position[8] ){
                subteam=controller.getProdTeam();
            }
            if(currentUser.getPosition() == login.position[9]){
                subteam=controller.getServTeam();
            }
            SubTeam[] teams=subteam.toArray(new SubTeam[subteam.size()]);

            teamList= new JList(teams);
            teamList.setBounds(90,170,220,80);
            panel.add(teamList);

            createTasks();
            setVisible(true);



        }
        public void createTasks(){
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double originalBudget = Double.valueOf(InitiateBudget.getText());
                String description = descriptionField.getText();
                SubTeam team=(SubTeam) teamList.getSelectedValue();
                // Please have a look on the arguments in your controller! check the 3rd argument, you can erase it!
                controller.createTask(team,currentUser,description,originalBudget);
            }
        });
        }

}


