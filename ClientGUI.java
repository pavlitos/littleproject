import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ClientGUI extends JFrame{

	private Controller controller;

	JPanel panel = new JPanel();
	
	JLabel lblName = new JLabel("Name");
	JTextField textName = new JTextField();
	
	JTextField textAge = new JTextField();
	JLabel lblAge = new JLabel("Age");
	
	JTextField textMail = new JTextField();
	JLabel lblMail = new JLabel("Mail");
	
	JButton btnSubmit = new JButton("Submit");
	
	public ClientGUI(Controller controller) {
		super("SEP Client Registration");
		setSize(450, 300);
		panel.setLayout(null);
		
		this.controller = controller;
		
		getContentPane().add(panel);
		
		lblName.setBounds(10, 11, 105, 14);
		panel.add(lblName);
		
		textName.setBounds(125, 8, 160, 20);
		panel.add(textName);
		
		lblAge.setBounds(10, 95, 105, 14);
		panel.add(lblAge);
		
		textAge.setBounds(125, 94, 160, 20);
		panel.add(textAge);
		
		lblMail.setBounds(10, 180, 105, 14);
		panel.add(lblMail);
		
		textMail.setBounds(125, 177, 160, 20);
		panel.add(textMail);
		
		btnSubmit.setBounds(335, 227, 89, 23);
		panel.add(btnSubmit);
		
		pushButton();
		setVisible(true);
	}
	
	public void pushButton() {
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textName.getText();
				int age = Integer.parseInt(textAge.getText());
				String mail = textMail.getText();
				
				controller.createClient(name, age, mail);
				
			}
		});
	}


}
