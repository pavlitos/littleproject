import javax.swing.*;
import java.awt.*;

public class FinancialRequestGUI extends JFrame {


    private Employee employee;

    JPanel jpanel=new JPanel();
    JButton createButton = new JButton("Create");
    JTextField descriptionField;


    public FinancialRequestGUI( Employee currentUser) {
        super("SEP Financial Request");
        setSize(800, 900);
        jpanel.setLayout(null);
        employee=currentUser;
        getContentPane().add(jpanel);

        JLabel eventsLabel = new JLabel("Events");
        eventsLabel.setBounds(328, 12, 70, 15);
        jpanel.add(eventsLabel);


        createButton.setBounds(233, 313, 117, 25);
        jpanel.add(createButton);




    }



}
