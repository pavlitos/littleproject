import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RecruitmentRequestGUI extends JFrame{

    private final Controller controller;
    JPanel panel=new JPanel();
    JButton createButton= new JButton("Create");
    private  JTextField descriptionField;
    private JLabel lblDescription;
    private Employee currentUser;
    private JLabel lblTeam;
    private JList teamList;


    public  RecruitmentRequestGUI(Controller controller,Employee currentUser){

        super("SEP Create Recruitment Request");

        panel.setLayout(null);
        getContentPane().add(panel);
        setSize(800, 900);
        this.controller=controller;
        this.currentUser=currentUser;




        createButton.setBounds(233, 313, 117, 25);
        panel.add(createButton);

        descriptionField = new JTextField();
        descriptionField.setBounds(135, 29, 163, 86);
        panel.add(descriptionField);
        descriptionField.setColumns(10);

        lblDescription = new JLabel("Description");
        lblDescription.setBounds(12, 27, 105, 15);
        panel.add(lblDescription);
        setVisible(true);
        
        
        Login login = new Login();
        String position[];
        position = login.position();
        
        lblTeam = new JLabel("Team");
		lblTeam.setBounds(12, 159, 70, 15);
		panel.add(lblTeam);
		
		List <SubTeam> team = new ArrayList<>();
		
		if(currentUser.getPosition() == position[7]){
			team = controller.getProdTeam();
		}
		
		if(currentUser.getPosition() == position[8]){
			team = controller.getServTeam();
		}
		
		SubTeam[] teams  = team.toArray(new SubTeam[team.size()]);

		teamList = new JList(teams);
		teamList.setBounds(86, 173, 217, 77);
		panel.add(teamList);
		
		
		createStaffListener();
		setVisible(true);

    }
    
    
    public void createStaffListener(){
		createButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String description = descriptionField.getText();
				SubTeam team = (SubTeam) teamList.getSelectedValue();
				controller.createRecRequest(team, description);
			}
		});
	}


}
