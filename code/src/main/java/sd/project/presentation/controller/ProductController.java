package sd.project.presentation.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import sd.project.business.dto.CategoryDto;
import sd.project.business.dto.ProductDto;
import sd.project.business.service.ProductService;
import sd.project.presentation.proxy.Image;
import sd.project.presentation.proxy.ImageProxy;
import sd.project.presentation.view.ProductView;

@Controller
public class ProductController {
	@Autowired
	ProductService productService;
	private ProductView productView;

	public ProductController(ProductView productView) {
		super();
		this.productView = productView;
		productView.setComboBoxActionListener(new ComboBoxActionListener());
	}
	
	private class ComboBoxActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
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
	}
	
	public class ButtonActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	}
	
	public void displayProducts() {
		ArrayList<CategoryDto> categories = productService.findCategories();
		for(CategoryDto c: categories) {
			productView.getCategories().addItem(c.getCategoryName());
		}
		ArrayList<ProductDto> products = productService.findProducts();
		for(ProductDto p: products) {
			Image image = new ImageProxy(p.getProductImage());
			image.showImage(productView.getProductPanel());
		}
		productView.getProductFrame().repaint();
	}
	
	public ProductView getProductView() {
		return productView;
	}

	public void setProductView(ProductView productView) {
		this.productView = productView;
	}
	
}
