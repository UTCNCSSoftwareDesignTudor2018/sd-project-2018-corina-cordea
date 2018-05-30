package sd.project.presentation.view;

import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
	private JMenuItem menuItemViewOrders;
	
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
	
	private JFrame orderFrame;
	private JPanel orderPanel;
	private JRadioButton cashButton;
	private JRadioButton creditCardButton;
	private JRadioButton debitCardButton;
	private ButtonGroup group;
	private JButton confirmButton;
	
	private JFrame viewOrdersFrame;
	private JPanel viewOrdersPanel;
	private JTable orders;
	private JTextArea orderTextArea;
	private ListSelectionModel orderRowSelectionModel;
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
		menuItemViewOrders = new JMenuItem("View Orders");
		menuOptions.add(menuItemViewOrders);
		
		saveDataButton = new JButton("Save Data");
		deleteProductButton = new JButton("Delete");
		createOrderButton = new JButton("Create Order");
		products = new JTable();
		rowSelectionModel = products.getSelectionModel();
		cashButton = new JRadioButton("Cash On Delivery");
		creditCardButton = new JRadioButton("Credit Card");
		debitCardButton = new JRadioButton("Debit Card");
		group = new ButtonGroup();
		confirmButton = new JButton("Confirm");
		orders = new JTable();
		orderRowSelectionModel = orders.getSelectionModel();
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
	public void placeOrder() {
		orderFrame = new JFrame("Order");
		orderFrame.setBounds(0, 0, 350, 250);
		orderFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		orderFrame.setLocationRelativeTo(null);
		orderFrame.getContentPane().setLayout(null);
		
		orderPanel = new JPanel();
		orderPanel.setLayout(null );
		orderPanel.setBounds(0, 0, 350, 250);
		orderPanel.setVisible(true);
		
		cashButton.setBounds(100, 50, 150, 15);
		orderPanel.add(cashButton);
		cashButton.setActionCommand("Cash On Delivery");
		
		creditCardButton.setBounds(100, 75, 150, 15);
		orderPanel.add(creditCardButton);
		creditCardButton.setActionCommand("Credit Card");
		
		debitCardButton.setBounds(100, 100, 150, 15);
		orderPanel.add(debitCardButton);
		debitCardButton.setActionCommand("Debit Card");
		
		confirmButton.setBounds(100, 125, 150, 25);
		orderPanel.add(confirmButton);
	
		group = new ButtonGroup();
		group.add(cashButton);
		group.add(creditCardButton);
		group.add(debitCardButton);
		
		orderFrame.getContentPane().add(orderPanel);
	}
	public void viewOrders() {
		viewOrdersFrame = new JFrame("Orders");
		viewOrdersFrame.setBounds(0, 0, 600, 400);
		viewOrdersFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		viewOrdersFrame.setLocationRelativeTo(null);
		viewOrdersFrame.getContentPane().setLayout(null);
		
		viewOrdersPanel = new JPanel();
		viewOrdersPanel.setLayout(null );
		viewOrdersPanel.setBounds(0, 0, 600, 400);
		viewOrdersPanel.setVisible(true);
		
		orders.setBounds(50, 30, 500, 150);
		orders.setVisible(true);	
		orders.setRowSelectionAllowed(true);
		orderRowSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		viewOrdersPanel.add(orders);
		JScrollPane scrollPane = new JScrollPane(orders);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 30, 500, 150);
		viewOrdersFrame.add(scrollPane);
		
		orderTextArea = new JTextArea();
		orderTextArea.setBounds(50, 200, 500, 150);
		orderTextArea.setEditable(false);
		
		viewOrdersPanel.add(orderTextArea);
		JScrollPane scrollPaneArea = new JScrollPane(orderTextArea);
		scrollPaneArea.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneArea.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPaneArea.setBounds(50, 200, 500, 150);
		viewOrdersFrame.add(scrollPaneArea);

		viewOrdersFrame.add(viewOrdersPanel);
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
	public JFrame getOrderFrame() {
		return orderFrame;
	}
	public void setOrderFrame(JFrame orderFrame) {
		this.orderFrame = orderFrame;
	}
	public JPanel getOrderPanel() {
		return orderPanel;
	}
	public void setOrderPanel(JPanel orderPanel) {
		this.orderPanel = orderPanel;
	}
	public JRadioButton getCashButton() {
		return cashButton;
	}
	public void setCashButton(JRadioButton cashButton) {
		this.cashButton = cashButton;
	}
	public JRadioButton getCreditCardButton() {
		return creditCardButton;
	}
	public void setCreditCardButton(JRadioButton creditCardButton) {
		this.creditCardButton = creditCardButton;
	}
	public JRadioButton getDebitCardButton() {
		return debitCardButton;
	}
	public void setDebitCardButton(JRadioButton debitCardButton) {
		this.debitCardButton = debitCardButton;
	}
	public ButtonGroup getGroup() {
		return group;
	}
	public void setGroup(ButtonGroup group) {
		this.group = group;
	}
	public JButton getConfirmButton() {
		return confirmButton;
	}
	public void setConfirmButton(JButton confirmButton) {
		this.confirmButton = confirmButton;
	}
	public JMenuItem getMenuItemViewOrders() {
		return menuItemViewOrders;
	}
	public void setMenuItemViewOrders(JMenuItem menuItemViewOrders) {
		this.menuItemViewOrders = menuItemViewOrders;
	}
	public JFrame getViewOrdersFrame() {
		return viewOrdersFrame;
	}
	public void setViewOrdersFrame(JFrame viewOrdersFrame) {
		this.viewOrdersFrame = viewOrdersFrame;
	}
	public JPanel getViewOrdersPanel() {
		return viewOrdersPanel;
	}
	public void setViewOrdersPanel(JPanel viewOrdersPanel) {
		this.viewOrdersPanel = viewOrdersPanel;
	}
	public JTable getOrders() {
		return orders;
	}
	public void setOrders(JTable orders) {
		this.orders = orders;
	}
	public JTextArea getOrderTextArea() {
		return orderTextArea;
	}
	public void setOrderTextArea(JTextArea orderTextArea) {
		this.orderTextArea = orderTextArea;
	}
	public ListSelectionModel getOrderRowSelectionModel() {
		return orderRowSelectionModel;
	}
	public void setOrderRowSelectionModel(ListSelectionModel orderRowSelectionModel) {
		this.orderRowSelectionModel = orderRowSelectionModel;
	}
	public DefaultTableModel getProductTableModel() {
		DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Product Name", "Quantity"},0);
		return tableModel;
	}
	public DefaultTableModel getOrderTableModel() {
		DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"Order id", "Date", "Status", "Total Price"},0);
		return tableModel;
	}
	public void setTableListener(ListSelectionListener listListener) {
		rowSelectionModel.addListSelectionListener(listListener);
	}
	public void setOrdersTableListener(ListSelectionListener listListener) {
		orderRowSelectionModel.addListSelectionListener(listListener);
	}
	public void  setSaveDataButtonActionListener(ActionListener actionListener) {
		saveDataButton.addActionListener(actionListener);
	}
	public void  setMenuItemViewCartActionListener(ActionListener actionListener) {
		menuItemViewCart.addActionListener(actionListener);
	}
	public void  setMenuItemViewOrdersActionListener(ActionListener actionListener) {
		menuItemViewOrders.addActionListener(actionListener);
	}
	public void  setDeleteButtonActionListener(ActionListener actionListener) {
		deleteProductButton.addActionListener(actionListener);
	}
	public void  setOrderButtonActionListener(ActionListener actionListener) {
		createOrderButton.addActionListener(actionListener);
	}
	public void  setConfirmButtonActionListener(ActionListener actionListener) {
		confirmButton.addActionListener(actionListener);
	}
}
