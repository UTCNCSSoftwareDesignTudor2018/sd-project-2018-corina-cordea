package sd.project.presentation.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.springframework.stereotype.Component;

@Component
public class ProductView {
	private JFrame productFrame;
	private JPanel productPanel;
	private GridLayout productsLayout;
	private JPanel northOnlyPanel;
	private JScrollPane scroll;
	private JLabel category;
	private JComboBox<String> categories;
	
	private JComboBox<String> productCategories;
	private JFrame updateProductFrame;
	private JPanel updateProductPanel;
	private GridLayout updateProductLayout;
	private JLabel productName;
	private JTextField productNameField;
	private JLabel productPrice;
	private JTextField productPriceField;
	private JLabel productQuantity;
	private JTextField productQuantityField;
	private JLabel productImage;
	private JButton changeImage;
	private JLabel productCategory;
	private JButton updateProduct;
	
	private JButton addToCart;
	private JLabel desiredQuantity;
	private JTextField desiredQuantityField;
	public ProductView() {
		initialize();
	}

	private void initialize() {
		productFrame = new JFrame();
		productFrame.setBounds(0, 0, 600, 400);
		productFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		productFrame.setLocationRelativeTo(null);
		productFrame.getContentPane().setLayout(null);
		
		productPanel = new JPanel();
		productsLayout = new GridLayout(0, 3);
		productPanel.setLayout(productsLayout);
		productPanel.setBounds(30, 50, 500, 300);
		productPanel.setVisible(true);

		northOnlyPanel = new JPanel();
		northOnlyPanel.setLayout(new BorderLayout());
		northOnlyPanel.setBounds(30, 50, 500, 300);
		northOnlyPanel.add(productPanel, BorderLayout.NORTH);
		productFrame.getContentPane().add(northOnlyPanel);
		
		scroll = new JScrollPane(productPanel, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(30, 50, 500, 300);
		
		category = new JLabel("Category: ");
		category.setBounds(30, 25, 100, 20);
		productFrame.getContentPane().add(category);
		
		categories = new JComboBox<String>();
		categories.setBounds(130, 25, 150, 20);
		categories.addItem("All");
		productFrame.getContentPane().add(categories);
		
		productFrame.getContentPane().add(scroll);
		productFrame.getContentPane().add(northOnlyPanel);
		
		updateProduct = new JButton("Update Product");
		changeImage = new JButton("Choose image");
		addToCart = new JButton("Add to cart");
	}
	public void updateProduct() {
		updateProductFrame = new JFrame();
		updateProductFrame.setBounds(0, 0, 600, 400);
		updateProductFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		updateProductFrame.setLocationRelativeTo(null);
		updateProductFrame.getContentPane().setLayout(null);
		
		updateProductPanel = new JPanel();
		updateProductLayout = new GridLayout(0, 2);
		updateProductPanel.setLayout(updateProductLayout);
		updateProductPanel.setBounds(30, 50, 500, 300);
		updateProductPanel.setVisible(true);
		
		updateProduct.setBounds(200, 10, 200, 30);
		updateProductFrame.getContentPane().add(updateProduct);
		
		productName = new JLabel("Product Name");
		updateProductPanel.add(productName);
		productNameField = new JTextField();
		updateProductPanel.add(productNameField);
		productPrice = new JLabel("Product Price");
		updateProductPanel.add(productPrice);
		productPriceField = new JTextField();
		updateProductPanel.add(productPriceField);
		productQuantity = new JLabel("Product Quantity");
		updateProductPanel.add(productQuantity);
		productQuantityField = new JTextField();
		updateProductPanel.add(productQuantityField);
		productCategory = new JLabel("Product Category");
		updateProductPanel.add(productCategory);
		productCategories = new JComboBox<String>();
		updateProductPanel.add(productCategories);
		changeImage.setHorizontalAlignment(SwingConstants.LEFT);
		changeImage.setOpaque(false);
		changeImage.setContentAreaFilled(false);
		changeImage.setBorderPainted(false);
		updateProductPanel.add(changeImage);
		productImage = new JLabel();
		updateProductPanel.add(productImage);
		updateProductFrame.add(updateProductPanel);
	}
	public void viewProduct() {
		updateProductFrame = new JFrame();
		updateProductFrame.setBounds(0, 0, 600, 400);
		updateProductFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		updateProductFrame.setLocationRelativeTo(null);
		updateProductFrame.getContentPane().setLayout(null);
		
		updateProductPanel = new JPanel();
		updateProductLayout = new GridLayout(0, 2);
		updateProductPanel.setLayout(updateProductLayout);
		updateProductPanel.setBounds(30, 50, 500, 300);
		updateProductPanel.setVisible(true);
		
		desiredQuantity = new JLabel("Quantity");
		desiredQuantity.setBounds(50,10,100,30);
		updateProductFrame.getContentPane().add(desiredQuantity);
		desiredQuantityField = new JTextField();
		desiredQuantityField.setBounds(170, 10, 100, 30);
		updateProductFrame.getContentPane().add(desiredQuantityField);
		addToCart.setBounds(320, 10, 150, 30);
		updateProductFrame.getContentPane().add(addToCart);
		
		productName = new JLabel("Product Name");
		updateProductPanel.add(productName);
		productNameField = new JTextField();
		productNameField.setEditable(false);
		updateProductPanel.add(productNameField);
		productPrice = new JLabel("Product Price");
		updateProductPanel.add(productPrice);
		productPriceField = new JTextField();
		productPriceField.setEditable(false);
		updateProductPanel.add(productPriceField);
		productQuantity = new JLabel("Product Quantity");
		updateProductPanel.add(productQuantity);
		productQuantityField = new JTextField();
		productQuantityField.setEditable(false);
		updateProductPanel.add(productQuantityField);
		productCategory = new JLabel("Product Category");
		updateProductPanel.add(productCategory);
		productCategories = new JComboBox<String>();
		updateProductPanel.add(productCategories);
		productCategories.setEditable(false);
		updateProductPanel.add(new JLabel());
		productImage = new JLabel();
		updateProductPanel.add(productImage);
		updateProductFrame.add(updateProductPanel);
	}
	public JPanel getNorthOnlyPanel() {
		return northOnlyPanel;
	}

	public void setNorthOnlyPanel(JPanel northOnlyPanel) {
		this.northOnlyPanel = northOnlyPanel;
	}

	public JScrollPane getScroll() {
		return scroll;
	}

	public void setScroll(JScrollPane scroll) {
		this.scroll = scroll;
	}

	public JPanel getProductPanel() {
		return productPanel;
	}

	public void setProductPanel(JPanel productPanel) {
		this.productPanel = productPanel;
	}

	public GridLayout getProductsLayout() {
		return productsLayout;
	}

	public void setProductsLayout(GridLayout productsLayout) {
		this.productsLayout = productsLayout;
	}

	public JFrame getProductFrame() {
		return productFrame;
	}

	public void setProductFrame(JFrame productFrame) {
		this.productFrame = productFrame;
	}

	public JLabel getCategory() {
		return category;
	}

	public void setCategory(JLabel category) {
		this.category = category;
	}

	public JComboBox<String> getCategories() {
		return categories;
	}

	public void setCategories(JComboBox<String> categories) {
		this.categories = categories;
	}
	public void setComboBoxActionListener(ActionListener actionListener) {
		categories.addActionListener(actionListener);
	}

	public JFrame getUpdateProductFrame() {
		return updateProductFrame;
	}

	public void setUpdateProductFrame(JFrame updateProductFrame) {
		this.updateProductFrame = updateProductFrame;
	}

	public JPanel getUpdateProductPanel() {
		return updateProductPanel;
	}

	public void setUpdateProductPanel(JPanel updateProductPanel) {
		this.updateProductPanel = updateProductPanel;
	}

	public GridLayout getUpdateProductLayout() {
		return updateProductLayout;
	}

	public void setUpdateProductLayout(GridLayout updateProductLayout) {
		this.updateProductLayout = updateProductLayout;
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

	public JButton getUpdateProduct() {
		return updateProduct;
	}

	public void setUpdateProduct(JButton updateProduct) {
		this.updateProduct = updateProduct;
	}

	public JLabel getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(JLabel productCategory) {
		this.productCategory = productCategory;
	}
	
	public JComboBox<String> getProductCategories() {
		return productCategories;
	}

	public void setProductCategories(JComboBox<String> productCategories) {
		this.productCategories = productCategories;
	}

	public JButton getChangeImage() {
		return changeImage;
	}

	public void setChangeImage(JButton changeImage) {
		this.changeImage = changeImage;
	}

	public JButton getAddToCart() {
		return addToCart;
	}

	public void setAddToCart(JButton addToCart) {
		this.addToCart = addToCart;
	}

	public JLabel getDesiredQuantity() {
		return desiredQuantity;
	}

	public void setDesiredQuantity(JLabel desiredQuantity) {
		this.desiredQuantity = desiredQuantity;
	}

	public JTextField getDesiredQuantityField() {
		return desiredQuantityField;
	}

	public void setDesiredQuantityField(JTextField desiredQuantityField) {
		this.desiredQuantityField = desiredQuantityField;
	}

	public void setChangeImageActionListener(ActionListener actionListener) {
		changeImage.addActionListener(actionListener);
	}
	
	public void setUpdateProductActionListener(ActionListener actionListener) {
		updateProduct.addActionListener(actionListener);
	}
	
	public void setAddToCartActionListener(ActionListener actionListener) {
		addToCart.addActionListener(actionListener);
	}
}
