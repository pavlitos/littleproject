import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





public class LoginGUI extends JFrame {

    public static void main(String[] args){
        new LoginGUI();

    }


    JPanel jpanel = new JPanel();
    JLabel userLabel= new JLabel("Username");
    JTextField userText = new JTextField(20);
    JLabel passwordLabel = new JLabel("Password");
    JPasswordField passwordText = new JPasswordField(20);
    JButton btnLogin=new JButton("Login");
    JLabel creation= new JLabel("powered by SEP");
    MainGUI regView;
    private final JButton btnExit = new JButton("Exit");

    //CONSTRUCTOR
    public LoginGUI(){
        super("Login with Username and Password");

        Controller controller = new Controller();
        
        panel(controller);
        JFrame frame = new JFrame("Type your credentials");
        

        getContentPane().add(jpanel);
        btnExit.addActionListener(e -> System.exit(0));
        btnExit.setBounds(235, 81, 89, 23);
        
        jpanel.add(btnExit);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Setting the frame visibility to true
        setVisible(true);
        //initView();

    }

    private void panel(Controller controller)
    {
        // Setting the width and height of frame
        setSize(350, 200);

        jpanel.setLayout(null);

        userLabel.setBounds(10,20,80,25);
        jpanel.add(userLabel);

        userText.setBounds(100,20,165,25);
        jpanel.add(userText);

        passwordLabel.setBounds(10,50,80,25);
        jpanel.add(passwordLabel);

        passwordText.setBounds(100,50,165,25);
        jpanel.add(passwordText);

        btnLogin.setBounds(10, 80, 80, 25);
        jpanel.add(btnLogin);

        creation.setBounds(224,125,100,25);
        jpanel.add(creation);



        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username= userText.getText();
                String password= passwordText.getText();

                Login login=new Login();
                Employee user=login.EmployeeLogin(username,password);
                if(user != null){
                    regView= new MainGUI(user, controller);
                    //Πρεπει να περασουμε το login αλλιως δεν μπορουμε
                    // να κλεισουμε το login παραθυρο
                    
                    regView.setVisible(true);


                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Wrong Password or Username");
                }


            }
        });

    }
    public JButton getLoginButton() {
        return btnLogin;
    }

    public JTextField getUserField() {
        return userText;
    }

    public JPasswordField getPassField() {
        return passwordText;
    }
    public MainGUI getMainGUI(){
        return regView;
    }




}
