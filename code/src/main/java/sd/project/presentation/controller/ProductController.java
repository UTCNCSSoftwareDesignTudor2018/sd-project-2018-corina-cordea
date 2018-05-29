package sd.project.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sd.project.business.dto.CartProduct;
import sd.project.business.dto.CategoryDto;
import sd.project.business.dto.ProductDto;
import sd.project.business.service.ProductService;
import sd.project.presentation.proxy.Image;
import sd.project.presentation.proxy.ImageProxy;
import sd.project.presentation.view.ClientView;
import sd.project.presentation.view.ProductView;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	@Autowired
	ClientView clientView;
	private ProductView productView;
	private ProductDto product;
	private String userType;

	public ProductController(ProductView productView) {
		super();
		this.productView = productView;
		
	}
	
	public void setListeners() {
		productView.setComboBoxActionListener(new ComboBoxActionListener());
		productView.setChangeImageActionListener(new ChangeImageActionListener());
		productView.setUpdateProductActionListener(new UpdateProductActionListener());
		productView.setAddToCartActionListener(new AddToCartActionListener());
	}
	
	private class ComboBoxActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			repaintProducts();
		}
	}
	 
	public void repaintProducts() {
		productView.getProductPanel().removeAll();
		String category = productView.getCategories().getSelectedItem().toString();
		ArrayList<ProductDto> products = productService.findProducts();
		for(ProductDto p: products) {
			if(p.getCategory().getCategoryName().equals(category) || category.equals("All")) {
			Image image = new ImageProxy(p.getProductImage());
			JButton b = image.showImage(productView.getProductPanel());
			b.setActionCommand(p.getProductImage());
			b.addActionListener(new ButtonActionListener());
			}
		}
		productView.getProductPanel().repaint();
		productView.getProductPanel().validate();
		productView.getProductFrame().repaint();
	}
	
	public class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			product = productService.findProductByImage(e.getActionCommand());
			if(userType.equals("seller")) {
				productView.updateProduct();
			}else {
				productView.viewProduct();
			}
			ArrayList<CategoryDto> categories = productService.findCategories();
			for(CategoryDto c: categories) {
				productView.getProductCategories().addItem(c.getCategoryName());
			}
			productView.getProductNameField().setText(product.getProductName());
			productView.getProductPriceField().setText(String.valueOf(product.getProductPrice()));
			productView.getProductQuantityField().setText(String.valueOf(product.getProductQuantity()));
			productView.getProductCategories().setSelectedItem(product.getCategory().getCategoryName());
			productView.getProductImage().setIcon(new ImageIcon(product.getProductImage()));
			productView.getProductImage().setToolTipText(product.getProductImage());
			
			productView.getUpdateProductPanel().repaint();
			productView.getUpdateProductPanel().validate();
			productView.getUpdateProductFrame().setVisible(true);
		}
	}
	
	public class ChangeImageActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
			int result = fileChooser.showOpenDialog(productView.getProductFrame());
			if (result == JFileChooser.APPROVE_OPTION) {
				File selectedFile = fileChooser.getSelectedFile();
				Path path = Paths.get(selectedFile.getAbsolutePath());
			productView.getProductImage().setIcon(new ImageIcon(path.toString()));
			productView.getProductImage().setToolTipText(path.toString());
			}
		}
	}
	
	public class UpdateProductActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			ProductDto productDto = new ProductDto();
			productDto.setProductId(product.getProductId());
			productDto.setProductName(productView.getProductNameField().getText());
			productDto.setProductPrice(Float.parseFloat(productView.getProductPriceField().getText()));
			productDto.setProductQuantity(Float.parseFloat(productView.getProductQuantityField().getText()));
			productDto.setCategory(productService.findCategoryByName(productView.getProductCategories().getSelectedItem().toString()));
			productDto.setProductImage(productView.getProductImage().getToolTipText());
			productDto.setSeller(product.getSeller());
			productService.updateProduct(productDto);
			repaintProducts();
			productView.getUpdateProductFrame().dispose();
		}
	}
	
	private class AddToCartActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(Float.parseFloat(productView.getDesiredQuantityField().getText())<Float.parseFloat(productView.getProductQuantityField().getText())) {
			CartProduct cartProduct = new CartProduct(product, Float.parseFloat(productView.getDesiredQuantityField().getText()));
			clientView.getShoppingCart().getCart().add(cartProduct);
			float q = product.getProductQuantity()-Float.parseFloat(productView.getDesiredQuantityField().getText());
			product.setProductQuantity(q);
			productService.updateProduct(product);
			}else {
				JOptionPane.showMessageDialog(productView.getProductFrame(),"The quantity introduced is not available!");
			}
			productView.getUpdateProductFrame().dispose();
		}
	}
	
	public void displayProducts() {
		ArrayList<CategoryDto> categories = productService.findCategories();
		productView.getCategories().removeAll();
		productView.getCategories().addItem("All");
		for(CategoryDto c: categories) {
			productView.getCategories().addItem(c.getCategoryName());
		}
		ArrayList<ProductDto> products = productService.findProducts();
		for(ProductDto p: products) {
			Image image = new ImageProxy(p.getProductImage());
			JButton b = image.showImage(productView.getProductPanel());
			b.setActionCommand(p.getProductImage());
			b.addActionListener(new ButtonActionListener());
		}
		productView.getProductFrame().repaint();
	}
	
	public ProductView getProductView() {
		return productView;
	}

	public void setProductView(ProductView productView) {
		this.productView = productView;
	}
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
}
