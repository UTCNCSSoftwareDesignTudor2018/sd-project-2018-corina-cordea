package sd.project.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sd.project.business.dto.ShoppingCart;

@Component
public class ClientView {
	@Autowired 
	ShoppingCart shoppingCart;
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
	private JMenuBar menuBar;
	private JMenu menuOptions;
	private JMenuItem menuItemViewCart;
	
	private JFrame cartFrame;
	private JPanel cartPanel;
	private JTable products;
	private JButton deleteProductButton;
	private JLabel productLabel;
	private JTextField productTextField;
	private JLabel quantityLabel;
	private JTextField quantityTextField;
	private JLabel totalPrice;
	private JLabel totalPriceSum;
	private ListSelectionModel rowSelectionModel;
	private JButton createOrderButton;
	
	public ClientView() {
		initialize();
	}
	private void initialize() {
		clientFrame = new JFrame("Client");
		clientFrame.setBounds(0, 0, 600, 400);
		clientFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		clientFrame.setLocationRelativeTo(null);
		clientFrame.getContentPane().setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 600, 20);
		menuOptions = new JMenu("Options");
		menuBar.add(menuOptions);
		menuItemViewCart = new JMenuItem("View Cart");
		menuOptions.add(menuItemViewCart);
		
		saveDataButton = new JButton("Save Data");
		deleteProductButton = new JButton("Delete");
		createOrderButton = new JButton("Create Order");
		products = new JTable();
		rowSelectionModel = products.getSelectionModel();
	}
	public void createAccount() {
		accountFrame = new JFrame("Client");
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
	public void viewCart() {
		cartFrame = new JFrame("Cart");
		cartFrame.setBounds(0, 0, 600, 400);
		cartFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		cartFrame.setLocationRelativeTo(null);
		cartFrame.getContentPane().setLayout(null);
		
		cartPanel = new JPanel();
		cartPanel.setLayout(null );
		cartPanel.setBounds(0, 0, 600, 400);
		cartPanel.setVisible(true);
		
		products.setBounds(30, 50, 400, 200);
		products.setVisible(true);	
		products.setRowSelectionAllowed(true);
		rowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		cartPanel.add(products);
		JScrollPane scrollPane = new JScrollPane(products);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(30, 50, 400, 200);
		cartFrame.add(scrollPane);
		
		createOrderButton.setBounds(280, 270, 150, 20);
		cartPanel.add(createOrderButton);
		
		deleteProductButton.setBounds(460, 200, 100, 20);
		cartPanel.add(deleteProductButton);
		
		productLabel = new JLabel("Product");
		productLabel.setBounds(460, 50, 100, 20);
		cartPanel.add(productLabel);
		
		productTextField = new JTextField();
		productTextField.setBounds(460, 80, 100, 20);
		productTextField.setEditable(false);
		cartPanel.add(productTextField);
		
		quantityLabel = new JLabel("Quantity");
		quantityLabel.setBounds(460, 110, 100, 20);
		cartPanel.add(quantityLabel);
		
		quantityTextField = new JTextField();
		quantityTextField.setBounds(460, 140, 100, 20);
		quantityTextField.setEditable(false);
		cartPanel.add(quantityTextField);
		
		totalPrice = new JLabel("Total Price: ");
		totalPrice.setBounds(30, 270, 70, 20);
		cartPanel.add(totalPrice);
		
		totalPriceSum = new JLabel();
		totalPriceSum.setBounds(100, 270, 50, 20);
		cartPanel.add(totalPriceSum);
		
		cartFrame.add(cartPanel);
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
	public JMenuBar getMenuBar() {
		return menuBar;
	}
	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}
	public JMenu getMenuOptions() {
		return menuOptions;
	}
	public void setMenuOptions(JMenu menuOptions) {
		this.menuOptions = menuOptions;
	}
	public JMenuItem getMenuItemViewCart() {
		return menuItemViewCart;
	}
	public void setMenuItemViewCart(JMenuItem menuItemViewCart) {
		this.menuItemViewCart = menuItemViewCart;
	}
	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}
	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}
	public JFrame getCartFrame() {
		return cartFrame;
	}
	public void setCartFrame(JFrame cartFrame) {
		this.cartFrame = cartFrame;
	}
	public JPanel getCartPanel() {
		return cartPanel;
	}
	public void setCartPanel(JPanel cartPanel) {
		this.cartPanel = cartPanel;
	}
	public JTable getProducts() {
		return products;
	}
	public void setProducts(JTable products) {
		this.products = products;
	}
	public JLabel getProductLabel() {
		return productLabel;
	}
	public void setProductLabel(JLabel productLabel) {
		this.productLabel = productLabel;
	}
	public JTextField getProductTextField() {
		return productTextField;
	}
	public void setProductTextField(JTextField productTextField) {
		this.productTextField = productTextField;
	}
	public JLabel getQuantityLabel() {
		return quantityLabel;
	}
	public void setQuantityLabel(JLabel quantityLabel) {
		this.quantityLabel = quantityLabel;
	}
	public JTextField getQuantityTextField() {
		return quantityTextField;
	}
	public void setQuantityTextField(JTextField quantityTextField) {
		this.quantityTextField = quantityTextField;
	}
	public JButton getDeleteProductButton() {
		return deleteProductButton;
	}
	public void setDeleteProductButton(JButton deleteProductButton) {
		this.deleteProductButton = deleteProductButton;
	}
	public JLabel getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(JLabel totalPrice) {
		this.totalPrice = totalPrice;
	}
	public JLabel getTotalPriceSum() {
		return totalPriceSum;
	}
	public void setTotalPriceSum(JLabel totalPriceSum) {
		this.totalPriceSum = totalPriceSum;
	}
	public ListSelectionModel getRowSelectionModel() {
		return rowSelectionModel;
	}
	public void setRowSelectionModel(ListSelectionModel rowSelectionModel) {
		this.rowSelectionModel = rowSelectionModel;
	}
	public JButton getCreateOrderButton() {
		return createOrderButton;
	}
	public void setCreateOrderButton(JButton createOrderButton) {
		this.createOrderButton = createOrderButton;
	}
	public DefaultTableModel getProductTableModel() {
		DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Product Name", "Quantity"},0);
		return tableModel;
	}
	public void setTableListener(ListSelectionListener listListener) {
		rowSelectionModel.addListSelectionListener(listListener);
	}
	public void  setSaveDataButtonActionListener(ActionListener actionListener) {
		saveDataButton.addActionListener(actionListener);
	}
	public void  setMenuItemViewCartActionListener(ActionListener actionListener) {
		menuItemViewCart.addActionListener(actionListener);
	}
	public void  setDeleteButtonActionListener(ActionListener actionListener) {
		deleteProductButton.addActionListener(actionListener);
	}
	public void  setOrderButtonActionListener(ActionListener actionListener) {
		createOrderButton.addActionListener(actionListener);
	}
}
