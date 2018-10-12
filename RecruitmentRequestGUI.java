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


    public class RecruitmentRequestGUI(Controller controller,Employee current){

        super("Request More Resources");
        this.controller=controller;



    }


}
