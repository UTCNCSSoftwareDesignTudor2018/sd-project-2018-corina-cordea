package sd.project.presentation.view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

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
		
		private JMenuBar menuBar;
		private JMenu menuOptions;
		private JMenuItem menuItemAddProduct;
		private JMenuItem menuItemViewOrders;
		
		private JTextField productCategoryField;
		private JFrame addProductFrame;
		private JPanel addProductPanel;
		private GridLayout addProductLayout;
		private JLabel productName;
		private JTextField productNameField;
		private JLabel productPrice;
		private JTextField productPriceField;
		private JLabel productQuantity;
		private JTextField productQuantityField;
		private JLabel productImage;
		private JButton addImage;
		private JLabel productCategory;
		private JButton addProduct;
		
		
		
		public SellerView() {
			initialize();
		}
		private void initialize() {
			sellerFrame = new JFrame("Seller");
			sellerFrame.setBounds(0, 0, 600, 400);
			sellerFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			sellerFrame.setLocationRelativeTo(null);
			sellerFrame.getContentPane().setLayout(null);
			
			menuBar = new JMenuBar();
			menuBar.setBounds(0, 0, 600, 20);
			menuOptions = new JMenu("Options");
			menuBar.add(menuOptions);
			menuItemAddProduct = new JMenuItem("Add Product");
			menuOptions.add(menuItemAddProduct);
			menuItemViewOrders = new JMenuItem("View Orders");
			menuOptions.add(menuItemViewOrders);
			
			saveDataButton = new JButton("Save Data");
			addProduct = new JButton("Add Product");
			addImage = new JButton("Add Image");
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
		public void addProduct() {
			addProductFrame = new JFrame();
			addProductFrame.setBounds(0, 0, 600, 400);
			addProductFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			addProductFrame.setLocationRelativeTo(null);
			addProductFrame.getContentPane().setLayout(null);
			
			addProductPanel = new JPanel();
			addProductLayout = new GridLayout(0, 2);
			addProductPanel.setLayout(addProductLayout);
			addProductPanel.setBounds(30, 50, 500, 300);
			addProductPanel.setVisible(true);
			
			addProduct.setBounds(200, 10, 200, 30);
			addProductFrame.getContentPane().add(addProduct);
			
			productName = new JLabel("Product Name");
			addProductPanel.add(productName);
			productNameField = new JTextField();
			addProductPanel.add(productNameField);
			productPrice = new JLabel("Product Price");
			addProductPanel.add(productPrice);
			productPriceField = new JTextField();
			addProductPanel.add(productPriceField);
			productQuantity = new JLabel("Product Quantity");
			addProductPanel.add(productQuantity);
			productQuantityField = new JTextField();
			addProductPanel.add(productQuantityField);
			productCategory = new JLabel("Product Category");
			addProductPanel.add(productCategory);
			productCategoryField = new JTextField();
			addProductPanel.add(productCategoryField);
			addImage.setHorizontalAlignment(SwingConstants.LEFT);
			addImage.setOpaque(false);
			addImage.setContentAreaFilled(false);
			addImage.setBorderPainted(false);
			addProductPanel.add(addImage);
			productImage = new JLabel();
			addProductPanel.add(productImage);
			addProductFrame.add(addProductPanel);
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
		public JMenuItem getMenuItemAddProduct() {
			return menuItemAddProduct;
		}
		public JTextField getProductCategoryField() {
			return productCategoryField;
		}
		public void setProductCategoryField(JTextField productCategoryField) {
			this.productCategoryField = productCategoryField;
		}
		public JFrame getAddProductFrame() {
			return addProductFrame;
		}
		public void setAddProductFrame(JFrame addProductFrame) {
			this.addProductFrame = addProductFrame;
		}
		public JPanel getAddProductPanel() {
			return addProductPanel;
		}
		public void setAddProductPanel(JPanel addProductPanel) {
			this.addProductPanel = addProductPanel;
		}
		public GridLayout getAddProductLayout() {
			return addProductLayout;
		}
		public void setAddProductLayout(GridLayout addProductLayout) {
			this.addProductLayout = addProductLayout;
		}
		public JLabel getProductName() {
			return productName;
		}
		public void setProductName(JLabel productName) {
			this.productName = productName;
		}
		public JTextField getProductNameField() {
			return productNameField;
		}
		public void setProductNameField(JTextField productNameField) {
			this.productNameField = productNameField;
		}
		public JLabel getProductPrice() {
			return productPrice;
		}
		public void setProductPrice(JLabel productPrice) {
			this.productPrice = productPrice;
		}
		public JTextField getProductPriceField() {
			return productPriceField;
		}
		public void setProductPriceField(JTextField productPriceField) {
			this.productPriceField = productPriceField;
		}
		public JLabel getProductQuantity() {
			return productQuantity;
		}
		public void setProductQuantity(JLabel productQuantity) {
			this.productQuantity = productQuantity;
		}
		public JTextField getProductQuantityField() {
			return productQuantityField;
		}
		public void setProductQuantityField(JTextField productQuantityField) {
			this.productQuantityField = productQuantityField;
		}
		public JLabel getProductImage() {
			return productImage;
		}
		public void setProductImage(JLabel productImage) {
			this.productImage = productImage;
		}
		public JButton getAddImage() {
			return addImage;
		}
		public void setAddImage(JButton addImage) {
			this.addImage = addImage;
		}
		public JLabel getProductCategory() {
			return productCategory;
		}
		public void setProductCategory(JLabel productCategory) {
			this.productCategory = productCategory;
		}
		public JButton getAddProduct() {
			return addProduct;
		}
		public void setAddProduct(JButton addProduct) {
			this.addProduct = addProduct;
		}
		public void setMenuItemAddProduct(JMenuItem menuItemAddProduct) {
			this.menuItemAddProduct = menuItemAddProduct;
		}
		public JMenuItem getMenuItemViewOrders() {
			return menuItemViewOrders;
		}
		public void setMenuItemViewOrders(JMenuItem menuItemViewOrders) {
			this.menuItemViewOrders = menuItemViewOrders;
		}
	
		public void  setSaveDataButtonActionListener(ActionListener actionListener) {
			saveDataButton.addActionListener(actionListener);
		}
		public void  setMenuItemAddProductActionListener(ActionListener actionListener) {
			menuItemAddProduct.addActionListener(actionListener);
		}
		public void setAddImageActionListener(ActionListener actionListener) {
			addImage.addActionListener(actionListener);
		}
		public void setAddProductActionListener(ActionListener actionListener) {
			addProduct.addActionListener(actionListener);
		}
		public void  setMenuItemViewOrdersActionListener(ActionListener actionListener) {
			menuItemViewOrders.addActionListener(actionListener);
		}
	}

