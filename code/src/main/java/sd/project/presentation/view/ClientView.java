package sd.project.presentation.view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.springframework.stereotype.Component;

@Component
public class ClientView {
	private JFrame clientFrame;
	private JPanel clientPanel;
	public ClientView() {
		initialize();
	}
	private void initialize() {
		clientFrame = new JFrame("Client");
		clientFrame.setBounds(100, 100, 600, 400);
		clientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		clientFrame.setLocationRelativeTo(null);
		clientFrame.getContentPane().setLayout(null);
		
		clientPanel = new JPanel();
		clientPanel.setLayout(null);
		clientPanel.setBounds(100, 100, 600, 400);
		clientPanel.setVisible(true);
		clientFrame.getContentPane().add(clientPanel);
		
		clientFrame.repaint();
	}
	public JFrame getClientFrame() {
		return clientFrame;
	}
	public void setClientFrame(JFrame clientFrame) {
		this.clientFrame = clientFrame;
	}
	public JPanel getClientPanel() {
		return clientPanel;
	}
	public void setClientPanel(JPanel clientPanel) {
		this.clientPanel = clientPanel;
	}
	
}
