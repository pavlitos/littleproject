import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;

class ViewFinancialRequestsGUI extends JFrame{
	
	private Controller controller;
	private Employee employee;
	
	JPanel panel = new JPanel();
	
	private JTextField managerField;
	JButton closeButton = new JButton("Close");
	private JLabel lblResources;
	private JTextPane descriptionField;
	private JLabel lblDescription;
	private JList requestList;
	
	JTextPane financeField = new JTextPane();
	
	
	public ViewFinancialRequestsGUI(Controller controller, Employee employee) {
		
		super("SEP View Financial Requests");
		setSize(800,600);
		panel.setLayout(null);
		
		this.controller = controller;
		this.employee = employee;
		
		getContentPane().add(panel);
		
		managerField = new JTextField();
		managerField.setBounds(164, 10, 150, 20);
		panel.add(managerField);
		managerField.setColumns(10);
		
		JLabel lblManagerName = new JLabel("Manager");
		lblManagerName.setBounds(12, 12, 117, 15);
		panel.add(lblManagerName);
		
		lblResources = new JLabel("Amount");
		lblResources.setBounds(12, 39, 134, 15);
		panel.add(lblResources);
		
		descriptionField = new JTextPane();
		descriptionField.setBounds(164, 138, 119, 88);
		panel.add(descriptionField);
		
		lblDescription = new JLabel("Description");
		lblDescription.setBounds(12, 140, 134, 15);
		panel.add(lblDescription);
		
		
		JLabel requestLabel = new JLabel(" List of Financial Requests");
		requestLabel.setBounds(400, 32, 200, 15);
		panel.add(requestLabel);
		
		List<FinancialRequest> req = controller.getFinRequest();
		
		FinancialRequest[] requests  = req.toArray(new FinancialRequest[req.size()]);
		
		requestList = new JList(requests);
		panel.add(requestList);
		requestList.setBounds(400, 59, 228, 167);
	    JScrollPane pane = new JScrollPane();

	    getContentPane().add(pane, BorderLayout.NORTH);
		
		
		closeButton.setBounds(237, 314, 150, 25);
		panel.add(closeButton);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addListMouseListener(requestList);
		
		
		financeField.setBounds(164, 41, 150, 20);
		panel.add(financeField);
		closeButton.setVisible(true);
		
	
		closeResourceReqListener();
		
		setVisible(true);
	}
	
	public void addListMouseListener(JList list) {
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				int index = list.locationToIndex(evt.getPoint());
				FinancialRequest req = (FinancialRequest) list.getModel().getElementAt(index);
				managerField.setText(req.getManager().getPosition().toString());
				financeField.setText(String.valueOf(req.getAmount()));
				
				descriptionField.setText(req.getReason());
			}
			
		});
	}
	
	public void closeResourceReqListener(){
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FinancialRequest req = (FinancialRequest) requestList.getSelectedValue();
				controller.deleteFinancialRequest(req);
				
			}
		});
	}
	
}

