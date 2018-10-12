import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class RecruitmentRequestGUI extends JFrame{

    private final Controller controller;
    JPanel panel=new JPanel();
    JButton createButton= new JButton("Create");
    private  JTextField descriptionField;
    private JLabel lblDescription;
    private JList eventList;
    private int EventID;
    private Employee currentUser;
    private JLabel lblTeam;
    private JList teamList;


    public  RecruitmentRequestGUI(Controller controller,Employee currentUser){

        super("Request More Resources");

        panel.setLayout(null);
        getContentPane().add(panel);
        setSize(800, 900);
        this.controller=controller;
        this.currentUser=currentUser;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);




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


    }


}
