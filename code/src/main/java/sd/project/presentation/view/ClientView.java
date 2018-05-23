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
public class ClientView {
	private JFrame clientFrame;
	private JPanel clientPanel;
	
	private JFrame accountFrame;
	private JPanel accountPanel;
	private JLabel clientName;
	private JTextField clientNameTextField;
	private JLabel clientEmail;
	private JTextField clientEmailTextField;
	private JLabel clientAddress;
	private JTextField clientAddressTextField;
	private JLabel clientCity;
	private JTextField clientCityTextField;
	private JLabel clientPincode;
	private JTextField clientPincodeTextField;
	private JLabel clientPhoneNumber;
	private JTextField clientPhoneNumberTextField;
	private JButton saveDataButton;
	private JLabel username;
	private JTextField usernameTextField;
	private JLabel password;
	private JPasswordField passwordTextField;
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
		
		clientName = new JLabel("Name");
		clientName.setBounds(170, 100, 90, 20);
		accountPanel.add(clientName);
		
		clientNameTextField = new JTextField();
		clientNameTextField.setBounds(270, 100, 100, 20);
		accountPanel.add(clientNameTextField);
		
		clientEmail = new JLabel("Email");
		clientEmail.setBounds(170, 130, 90, 20);
		accountPanel.add(clientEmail);
		
		clientEmailTextField = new JTextField();
		clientEmailTextField.setBounds(270, 130, 100, 20);
		accountPanel.add(clientEmailTextField);
		
		clientAddress = new JLabel("Address");
		clientAddress.setBounds(170, 160, 90, 20);
		accountPanel.add(clientAddress);
		
		clientAddressTextField = new JTextField();
		clientAddressTextField.setBounds(270, 160, 100, 20);
		accountPanel.add(clientAddressTextField);
		
		clientCity = new JLabel("City");
		clientCity.setBounds(170, 190, 90, 20);
		accountPanel.add(clientCity);
		
		clientCityTextField = new JTextField();
		clientCityTextField.setBounds(270, 190, 100, 20);
		accountPanel.add(clientCityTextField);
		
		clientPincode = new JLabel("Pincode");
		clientPincode.setBounds(170, 220, 90, 20);
		accountPanel.add(clientPincode);
		
		clientPincodeTextField = new JTextField();
		clientPincodeTextField.setBounds(270, 220, 100, 20);
		accountPanel.add(clientPincodeTextField);
		
		clientPhoneNumber = new JLabel("Phone number");
		clientPhoneNumber.setBounds(170, 250, 90, 20);
		accountPanel.add(clientPhoneNumber);
		
		clientPhoneNumberTextField = new JTextField();
		clientPhoneNumberTextField.setBounds(270, 250, 100, 20);
		accountPanel.add(clientPhoneNumberTextField);
		
		username = new JLabel("Username");
		username.setBounds(170, 280, 90, 20);
		accountPanel.add(username);
		
		usernameTextField = new JTextField();
		usernameTextField.setBounds(270, 280, 100, 20);
		accountPanel.add(usernameTextField);
		
		password = new JLabel("Password");
		password.setBounds(170, 310, 90, 20);
		accountPanel.add(password);
		
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(270, 310, 100, 20);
		accountPanel.add(passwordTextField);
		
		saveDataButton.setBounds(210, 40, 130, 20);
		accountPanel.add(saveDataButton);
		
		accountFrame.getContentPane().add(accountPanel);
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
	public JLabel getClientName() {
		return clientName;
	}
	public void setClientName(JLabel clientName) {
		this.clientName = clientName;
	}
	public JTextField getClientNameTextField() {
		return clientNameTextField;
	}
	public void setClientNameTextField(JTextField clientNameTextField) {
		this.clientNameTextField = clientNameTextField;
	}
	public JLabel getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(JLabel clientEmail) {
		this.clientEmail = clientEmail;
	}
	public JTextField getClientEmailTextField() {
		return clientEmailTextField;
	}
	public void setClientEmailTextField(JTextField clientEmailTextField) {
		this.clientEmailTextField = clientEmailTextField;
	}
	public JLabel getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(JLabel clientAddress) {
		this.clientAddress = clientAddress;
	}
	public JTextField getClientAddressTextField() {
		return clientAddressTextField;
	}
	public void setClientAddressTextField(JTextField clientAddressTextField) {
		this.clientAddressTextField = clientAddressTextField;
	}
	public JLabel getClientCity() {
		return clientCity;
	}
	public void setClientCity(JLabel clientCity) {
		this.clientCity = clientCity;
	}
	public JTextField getClientCityTextField() {
		return clientCityTextField;
	}
	public void setClientCityTextField(JTextField clientCityTextField) {
		this.clientCityTextField = clientCityTextField;
	}
	public JLabel getClientPincode() {
		return clientPincode;
	}
	public void setClientPincode(JLabel clientPincode) {
		this.clientPincode = clientPincode;
	}
	public JTextField getClientPincodeTextField() {
		return clientPincodeTextField;
	}
	public void setClientPincodeTextField(JTextField clientPincodeTextField) {
		this.clientPincodeTextField = clientPincodeTextField;
	}
	public JLabel getClientPhoneNumber() {
		return clientPhoneNumber;
	}
	public void setClientPhoneNumber(JLabel clientPhoneNumber) {
		this.clientPhoneNumber = clientPhoneNumber;
	}
	public JTextField getClientPhoneNumberTextField() {
		return clientPhoneNumberTextField;
	}
	public void setClientPhoneNumberTextField(JTextField clientPhoneNumberTextField) {
		this.clientPhoneNumberTextField = clientPhoneNumberTextField;
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
