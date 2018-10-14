import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.*;
public class ViewRecruitmentRequestsGUI extends JFrame{

	private Controller controller;
	
	JPanel panel = new JPanel();
	private JTextField teamField;
	
	JButton closeButton = new JButton("Close");
	
	private JTextPane descriptionField;
	private JLabel lblDescription;
	
	private JList requestList;
	
	private int currentEventId;
	private Employee currentUser;
	
	
	public ViewRecruitmentRequestsGUI(Controller controller, Employee currentUser) {
		super("SEP List Staff Request");
		this.controller = controller;
		this.currentUser = currentUser;
		setSize(800, 600);
		View();
		closeStaffReqListener();
		setVisible(true);
	
	}
	
	private void View() {
		
		panel.setLayout(null);


		getContentPane().add(panel);

		teamField = new JTextField();
		teamField.setBounds(164, 10, 150, 19);
		panel.add(teamField);
		teamField.setColumns(10);
		
		JLabel lblTeamName = new JLabel("Team");
		lblTeamName.setBounds(12, 12, 117, 15);
		panel.add(lblTeamName);
		
		descriptionField = new JTextPane();
		descriptionField.setBounds(164, 85, 119, 88);
		panel.add(descriptionField);

		lblDescription = new JLabel("Description");
		lblDescription.setBounds(12, 84, 134, 15);
		panel.add(lblDescription);
		
		JLabel requestLabel = new JLabel("Staff Requests");
		requestLabel.setBounds(328, 32, 114, 15);
		panel.add(requestLabel);

		List<RecruitmentRequest> req = controller.getRecRequest();

		RecruitmentRequest[] requests  = req.toArray(new RecruitmentRequest[req.size()]);
		
		requestList = new JList(requests);
		panel.add(requestList);
		requestList.setBounds(356, 59, 228, 167);
		JScrollPane pane = new JScrollPane();

		getContentPane().add(pane, BorderLayout.NORTH);


		closeButton.setBounds(237, 314, 117, 25);
		panel.add(closeButton);
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addListMouseListener(requestList);
		closeButton.setVisible(true);
		
	}
	
	public void addListMouseListener(JList list) {
		list.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JList list = (JList) evt.getSource();
				int index = list.locationToIndex(evt.getPoint());
				RecruitmentRequest req = (RecruitmentRequest) list.getModel().getElementAt(index);
				teamField.setText(req.getSubTeam().getName());
				descriptionField.setText(req.getDescription());
	
			}
			
		});
	}
	
	public void closeStaffReqListener(){
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RecruitmentRequest req = (RecruitmentRequest) requestList.getSelectedValue();
				controller.deleteStaffRequest(req);
				
			}
		});
	}
}
