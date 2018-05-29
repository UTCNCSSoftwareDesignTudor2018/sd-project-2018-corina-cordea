package sd.project.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.springframework.stereotype.Component;

@Component
public class SellerView {

		private JFrame sellerFrame;
		private JPanel sellerPanel;
		
		private JFrame accountFrame;
		private JPanel accountPanel;
		private JLabel sellerName;
		private JTextField sellerNameTextField;
		private JButton saveDataButton;
		private JLabel username;
		private JTextField usernameTextField;
		private JLabel password;
		private JPasswordField passwordTextField;
		public SellerView() {
			initialize();
		}
		private void initialize() {
			sellerFrame = new JFrame("Seller");
			sellerFrame.setBounds(0, 0, 600, 400);
			sellerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			sellerFrame.setLocationRelativeTo(null);
			sellerFrame.getContentPane().setLayout(null);
			
			//sellerPanel = new JPanel();
			//sellerPanel.setLayout(null);
			//sellerPanel.setBounds(0, 0, 600, 400);
			//sellerPanel.setVisible(true);
			//sellerFrame.getContentPane().add(sellerPanel);
			
			saveDataButton = new JButton("Save Data");
		}
		public void createAccount() {
			accountFrame = new JFrame("Seller");
			accountFrame.setBounds(0, 0, 600, 400);
			accountFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			accountFrame.setLocationRelativeTo(null);
			accountFrame.getContentPane().setLayout(null);
			accountFrame.setVisible(true);
			
			accountPanel = new JPanel();
			accountPanel.setLayout(null);
			accountPanel.setBounds(0, 0, 600, 400);
			accountPanel.setVisible(true);
			
			sellerName = new JLabel("Name");
			sellerName.setBounds(170, 100, 90, 20);
			accountPanel.add(sellerName);
			
			sellerNameTextField = new JTextField();
			sellerNameTextField.setBounds(270, 100, 100, 20);
			accountPanel.add(sellerNameTextField);
			
			username = new JLabel("Username");
			username.setBounds(170, 130, 90, 20);
			accountPanel.add(username);
			
			usernameTextField = new JTextField();
			usernameTextField.setBounds(270, 130, 100, 20);
			accountPanel.add(usernameTextField);
			
			password = new JLabel("Password");
			password.setBounds(170, 160, 90, 20);
			accountPanel.add(password);
			
			passwordTextField = new JPasswordField();
			passwordTextField.setBounds(270, 160, 100, 20);
			accountPanel.add(passwordTextField);
			
			saveDataButton.setBounds(210, 40, 130, 20);
			accountPanel.add(saveDataButton);
			
			accountFrame.getContentPane().add(accountPanel);
		}
		public JFrame getSellerFrame() {
			return sellerFrame;
		}
		public void setSellerFrame(JFrame sellerFrame) {
			this.sellerFrame = sellerFrame;
		}
		public JPanel getSellerPanel() {
			return sellerPanel;
		}
		public void setSellerPanel(JPanel sellerPanel) {
			this.sellerPanel = sellerPanel;
		}
		public JFrame getAccountFrame() {
			return accountFrame;
		}
		public void setAccountFrame(JFrame accountFrame) {
			this.accountFrame = accountFrame;
		}
		public JPanel getAccountPanel() {
			return accountPanel;
		}
		public void setAccountPanel(JPanel accountPanel) {
			this.accountPanel = accountPanel;
		}
		public JLabel getSellerName() {
			return sellerName;
		}
		public void setSellerName(JLabel sellerName) {
			this.sellerName = sellerName;
		}
		public JTextField getSellerNameTextField() {
			return sellerNameTextField;
		}
		public void setSellerNameTextField(JTextField sellerNameTextField) {
			this.sellerNameTextField = sellerNameTextField;
		}
		public JButton getSaveDataButton() {
			return saveDataButton;
		}
		public void setSaveDataButton(JButton saveDataButton) {
			this.saveDataButton = saveDataButton;
		}
		public JLabel getUsername() {
			return username;
		}
		public void setUsername(JLabel username) {
			this.username = username;
		}
		public JTextField getUsernameTextField() {
			return usernameTextField;
		}
		public void setUsernameTextField(JTextField usernameTextField) {
			this.usernameTextField = usernameTextField;
		}
		public JLabel getPassword() {
			return password;
		}
		public void setPassword(JLabel password) {
			this.password = password;
		}
		public JPasswordField getPasswordTextField() {
			return passwordTextField;
		}
		public void setPasswordTextField(JPasswordField passwordTextField) {
			this.passwordTextField = passwordTextField;
		}
		public void  setSaveDataButtonActionListener(ActionListener actionListener) {
			saveDataButton.addActionListener(actionListener);
		}
		
	}

